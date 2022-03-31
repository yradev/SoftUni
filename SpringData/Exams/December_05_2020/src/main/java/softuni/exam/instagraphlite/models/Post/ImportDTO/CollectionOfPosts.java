package softuni.exam.instagraphlite.models.Post.ImportDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionOfPosts {
    @XmlElement(name = "post")
    private List<PostImportDTO>posts;

    public CollectionOfPosts(){}

    public List<PostImportDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostImportDTO> posts) {
        this.posts = posts;
    }
}
