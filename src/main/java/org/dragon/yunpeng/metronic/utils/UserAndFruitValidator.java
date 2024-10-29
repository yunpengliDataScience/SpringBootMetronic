package org.dragon.yunpeng.metronic.utils;

import org.dragon.yunpeng.metronic.pojos.UserAndFruit;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service(value = "userAndFruitValidator")
public class UserAndFruitValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return UserAndFruit.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserAndFruit userAndFruit = (UserAndFruit) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", null, "User is a required Field");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fruit", null, "Fruit is a required Field");

		System.out.println("errors=" + errors);
	}
}
