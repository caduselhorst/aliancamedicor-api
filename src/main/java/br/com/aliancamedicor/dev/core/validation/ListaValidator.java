package br.com.aliancamedicor.dev.core.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ListaValidator implements ConstraintValidator<Lista, String> {
	
	private List<String> allowed;
	
	@Override
	public void initialize(Lista constraintAnnotation) {
		this.allowed = Arrays.asList(constraintAnnotation.allowed());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return this.allowed.contains(value);
	}

}
