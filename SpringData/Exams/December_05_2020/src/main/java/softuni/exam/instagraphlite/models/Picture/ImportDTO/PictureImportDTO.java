package softuni.exam.instagraphlite.models.Picture.ImportDTO;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PictureImportDTO {
    @Expose
    @NotNull
    private String path;

    @Expose
    @NotNull
    @Min(500)
    @Max(60000)
    private double size;

    public PictureImportDTO(){}

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
