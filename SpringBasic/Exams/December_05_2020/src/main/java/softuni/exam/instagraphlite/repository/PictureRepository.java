package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.Picture.ExportDTO.PictureWithSpecificSizeDTO;
import softuni.exam.instagraphlite.models.Picture.Picture;

import java.util.List;

//ToDo
@Repository
public interface PictureRepository extends JpaRepository<Picture,Integer> {

    Picture findPictureByPath(String path);

    List<Picture> findPicturesBySizeGreaterThanOrderBySizeAsc(double size);
}
