package softuni.exam.models.dto.town;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class TownImportDTO {
    @Expose
    @NotNull
    @Size(min = 2)
    private String townName;

    @Expose
    @PositiveOrZero
    private int population;

    public TownImportDTO(){}

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
