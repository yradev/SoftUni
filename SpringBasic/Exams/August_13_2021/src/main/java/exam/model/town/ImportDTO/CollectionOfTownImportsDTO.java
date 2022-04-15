package exam.model.town.ImportDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionOfTownImportsDTO {
    @XmlElement(name = "town")
    private List<TownImportDTO> town;

    public CollectionOfTownImportsDTO(){}

    public List<TownImportDTO> getTown() {
        return town;
    }

    public void setTown(List<TownImportDTO> town) {
        this.town = town;
    }
}
