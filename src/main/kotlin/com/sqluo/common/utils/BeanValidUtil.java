package com.sqluo.common.utils;


import com.sqluo.common.exception.ParameterValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


public class BeanValidUtil {
    /**
     * 参数验证工具
     */
    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static void validateObj(Object object){
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        if (constraintViolations != null && constraintViolations.size() > 0) {
            //只返回第一个验证不过的内容
            ConstraintViolation<Object> constraintViolation = constraintViolations.iterator().next();
            if (constraintViolation != null) {
                throw new ParameterValidationException(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
            }
        }
    }
}
