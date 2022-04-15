package softuni.exam.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class DtoValidator {
    private static Validator validator;

    @Autowired
    private DtoValidator(Validator validator) {
        DtoValidator.validator = validator;
    }

    public static <T> boolean validate(T dto){
        Set<ConstraintViolation<T>> validate = validator.validate(dto);

        return validate.isEmpty();
    }
}
