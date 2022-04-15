package ExercisesLab.Hospital_Database.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Visitations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;

    private String comments;

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Patients getPatient() {
        return patient;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    private Patients patient;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Visitations() {
    }
}
