package softuni.exam.instagraphlite.models.Picture.ExportDTO;

public class PictureWithSpecificSizeDTO {
    private double size;
    private String path;

    public PictureWithSpecificSizeDTO(){
    }

    public PictureWithSpecificSizeDTO(double size, String path) {
        this.size = size;
        this.path = path;
    }

    public double getSize() {
        return size;
    }


    public void setSize(double size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {

        return String.format("""
                 %.2f - %s
                 """,size,path);
    }

}
