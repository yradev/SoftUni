package softuni.exam.instagraphlite.models.Post.ExportDTO.UserWithPostsDTO;

public class PostDetailsDTO {
    private String caption;
    private double pictureSize;



    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public double getPictureSize() {
        return pictureSize;
    }

    public void setPictureSize(double pictureSize) {
        this.pictureSize = pictureSize;
    }


    @Override
    public String toString() {
        return String.format("""
                ==Post Details:
                ----Caption: %s
                ----Picture Size: %.2f
                """,caption,pictureSize);
    }
}
