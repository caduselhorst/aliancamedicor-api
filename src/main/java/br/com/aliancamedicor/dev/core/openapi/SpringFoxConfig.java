package br.com.aliancamedicor.dev.core.openapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.ServletWebRequest;

import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.aliancamedicor.dev.api.exceptionhandler.Problem;
import br.com.aliancamedicor.dev.api.model.CBOOcupacaoModel;
import br.com.aliancamedicor.dev.api.openapi.model.CBOOcupacoesModelOpenApi;
import br.com.aliancamedicor.dev.api.openapi.model.PageableModelOpenApi;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RepresentationBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Response;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.json.JacksonModuleRegistrar;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig  {
	
	private static final String MSG_INSUPPORTED_MEDIA_TYPE = "Requisição recusada porque o corpo esta em formato não suportado";
	private static final String MSG_NOT_ACCEPTABLE = "Recurso não possui representação que pode ser aceita pelo consumidor";
	private static final String MSG_INTERNAL_SERVER_ERROR = "Erro interno do Servidor";
	private static final String MSG_BAD_REQUEST = "Requisição inválida (erro do cliente)";
	private static final String MSG_NAO_AUTORIZADO = "Você não possui permissão para executar essa operação";

	@Bean
	public Docket apiDocket() {
		
		TypeResolver typeResolver = new TypeResolver();
		
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.aliancamedicor.dev.api"))
				.paths(PathSelectors.any())
				.build()
			.useDefaultResponseMessages(false)
			.globalResponses(HttpMethod.GET, globalGetResponseMessages())
			.globalResponses(HttpMethod.POST, globalPostResponseMessages())
			.globalResponses(HttpMethod.PUT, globalPutResponseMessages())
			.globalResponses(HttpMethod.DELETE, globalDeleteResponseMessages())
			.ignoredParameterTypes(ServletWebRequest.class)
			.additionalModels(typeResolver.resolve(Problem.class))
			.directModelSubstitute(Pageable.class, PageableModelOpenApi.class)
			.alternateTypeRules(AlternateTypeRules.newRule(
					typeResolver.resolve(Page.class, CBOOcupacaoModel.class), CBOOcupacoesModelOpenApi.class))
//			.alternateTypeRules(AlternateTypeRules.newRule(
//					typeResolver.resolve(Page.class, PedidoModel.class), PedidosModelOpenApi.class))
			.apiInfo(apiInfo())
			.tags(
				new Tag("Ocupações", "Lista ocupações do Código Brasileiro de Ocupações"),
				new Tag("Pessoas", "Gerencia o registro de pessoas na base geral"),
				new Tag("Usuários", "Gerencia o registro de usuários na base geral"),
				new Tag("Perfis", "Gerencia perfis de atribuição a usuários"),
				new Tag("Sistemas", "Gerencia o registro de sistemas na base geral")
			);
	}
	
	// corrigir serialização de data OpenAPI 3 com SpringFox 3
	@Bean
	public JacksonModuleRegistrar springFoxJacksonConfig() {
		return objectMapper -> objectMapper.registerModule(new JavaTimeModule());
	}
	
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("DB Centralizada")
				.description("API centralizadora de dados")
				.version("1.0.0")
//				.contact(new Contact("LGSS Sistemas", "https://www.lgss.com.br", "suporte@lgss.com.br"))
				.build();
	}
	
	
	
	private List<Response> globalGetResponseMessages() {
		return Arrays.asList(
				new ResponseBuilder().code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
						.description(MSG_INTERNAL_SERVER_ERROR)
						.representation( MediaType.APPLICATION_JSON )
	                    .apply(getProblemaModelReference())
						.build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()))
						.description(MSG_NOT_ACCEPTABLE).build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.FORBIDDEN.value()))
					.description(MSG_NAO_AUTORIZADO)
					.representation(MediaType.APPLICATION_JSON)
					.apply(getProblemaModelReference())
					.build());
	}
	
	private List<Response> globalPostResponseMessages() {
		return Arrays.asList(
				new ResponseBuilder().code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
						.description(MSG_INTERNAL_SERVER_ERROR)
						.representation( MediaType.APPLICATION_JSON )
	                    .apply(getProblemaModelReference())
						.build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()))
						.description(MSG_NOT_ACCEPTABLE).build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
						.description(MSG_BAD_REQUEST)
						.representation( MediaType.APPLICATION_JSON )
	                    .apply(getProblemaModelReference())
						.build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()))
						.description(MSG_INSUPPORTED_MEDIA_TYPE)
						.representation( MediaType.APPLICATION_JSON )
	                    .apply(getProblemaModelReference())
						.build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.FORBIDDEN.value()))
						.description(MSG_NAO_AUTORIZADO)
						.representation(MediaType.APPLICATION_JSON)
						.apply(getProblemaModelReference())
						.build());
	}
	
	private List<Response> globalPutResponseMessages() {
		return Arrays.asList(
				new ResponseBuilder().code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
						.description(MSG_INTERNAL_SERVER_ERROR)
						.representation( MediaType.APPLICATION_JSON )
	                    .apply(getProblemaModelReference())
						.build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()))
						.description(MSG_NOT_ACCEPTABLE).build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
						.description(MSG_BAD_REQUEST)
						.representation( MediaType.APPLICATION_JSON )
	                    .apply(getProblemaModelReference())
						.build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()))
						.description(MSG_INSUPPORTED_MEDIA_TYPE)
						.representation( MediaType.APPLICATION_JSON )
	                    .apply(getProblemaModelReference())
						.build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.FORBIDDEN.value()))
						.description(MSG_NAO_AUTORIZADO)
						.representation(MediaType.APPLICATION_JSON)
						.apply(getProblemaModelReference())
						.build());
	}
	
	private List<Response> globalDeleteResponseMessages() {
		return Arrays.asList(
				new ResponseBuilder().code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
						.description(MSG_INTERNAL_SERVER_ERROR)
						.representation( MediaType.APPLICATION_JSON )
	                    .apply(getProblemaModelReference())
						.build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
						.description(MSG_BAD_REQUEST)
						.representation( MediaType.APPLICATION_JSON )
	                    .apply(getProblemaModelReference())
						.build(),
				new ResponseBuilder().code(String.valueOf(HttpStatus.FORBIDDEN.value()))
						.description(MSG_NAO_AUTORIZADO)
						.representation(MediaType.APPLICATION_JSON)
						.apply(getProblemaModelReference())
						.build());
	}
	
	private Consumer<RepresentationBuilder> getProblemaModelReference() {
	    return r -> r.model(m -> m.name("Problema")
	            .referenceModel(ref -> ref.key(k -> k.qualifiedModelName(
	                    q -> q.name("Problema").namespace("br.com.aliancamedicor.dev.api.exceptionhandler")))));
	}

}
