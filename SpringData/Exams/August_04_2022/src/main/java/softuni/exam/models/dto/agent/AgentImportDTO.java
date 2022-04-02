package softuni.exam.models.dto.agent;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AgentImportDTO {
    @Expose
    @NotNull
    @Size(min = 2)
    private String firstName;

    @Expose
    @NotNull
    @Size(min = 2)
    private String lastName;

    @Expose
    @NotNull
    private String town;

    @Expose
    @NotNull
    @Email
    private String email;

    public AgentImportDTO(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
