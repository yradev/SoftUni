package softuni.exam.instagraphlite.models.Post.ImportDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDTO {

    @XmlElement
    @Size(min = 21)
    @NotNull
    private String caption;

    @XmlElement
    @NotNull
    private UserNameDTO user;

    @XmlElement
    @NotNull
    private PicturePathDTO picture;

    public PostImportDTO(){}

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public UserNameDTO getUser() {
        return user;
    }

    public void setUser(UserNameDTO user) {
        this.user = user;
    }

    public PicturePathDTO getPicture() {
        return picture;
    }

    public void setPicture(PicturePathDTO picture) {
        this.picture = picture;
    }
}
