package org.dragon.yunpeng.metronic.utils;

import java.util.List;

import org.dragon.yunpeng.metronic.pojos.Child;
import org.dragon.yunpeng.metronic.pojos.Parent;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service(value = "accordionFormValidator")
public class AccordionFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Parent.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Parent parent = (Parent) target;

		List<Child> children = parent.getChildren();

		for (int i = 0; i < children.size(); i++) {
			String field = "children[" + i + "].text";
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, null, "Field " + field + " is a required Field");
		}
	}

}
