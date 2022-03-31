package softuni.exam.instagraphlite.models.Post.ImportDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserNameDTO {
    @XmlElement
    private String username;

    public UserNameDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = username;
    }
}
