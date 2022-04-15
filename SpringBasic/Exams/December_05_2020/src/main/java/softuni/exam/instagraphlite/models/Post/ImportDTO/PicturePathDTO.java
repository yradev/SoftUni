package softuni.exam.instagraphlite.models.Post.ImportDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PicturePathDTO {
    @XmlElement
    private String path;

    public PicturePathDTO(){}

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
