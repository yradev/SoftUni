package softuni.exam.instagraphlite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture.ImportDTO.PictureImportDTO;
import softuni.exam.instagraphlite.models.Post.ImportDTO.PostImportDTO;
import softuni.exam.instagraphlite.models.User.ImportDTO.UserImportDTO;
import softuni.exam.instagraphlite.service.ValidatingService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ValidatingServiceIMPL implements ValidatingService {
    private final Validator validator;

    @Autowired
    public ValidatingServiceIMPL(Validator validator) {
        this.validator = validator;
    }


    @Override
    public boolean ValidatePicture(PictureImportDTO pictureImportDTO) {
        Set<ConstraintViolation<PictureImportDTO>> validate = validator.validate(pictureImportDTO);
        return validate.isEmpty();
    }

    @Override
    public boolean ValidatePost(PostImportDTO postImportDTO) {
        Set<ConstraintViolation<PostImportDTO>> validate = validator.validate(postImportDTO);
        return validate.isEmpty();
    }

    @Override
    public boolean ValidateUser(UserImportDTO userImportDTO) {
        Set<ConstraintViolation<UserImportDTO>> validate = validator.validate(userImportDTO);
        return validate.isEmpty();
    }
}
