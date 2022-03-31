package softuni.exam.instagraphlite.service;

import softuni.exam.instagraphlite.models.Picture.ImportDTO.PictureImportDTO;
import softuni.exam.instagraphlite.models.Post.ImportDTO.PostImportDTO;
import softuni.exam.instagraphlite.models.User.ImportDTO.UserImportDTO;

public interface ValidatingService {
    boolean ValidatePicture(PictureImportDTO pictureImportDTO);
    boolean ValidatePost(PostImportDTO postImportDTO);
    boolean ValidateUser(UserImportDTO userImportDTO);
}
