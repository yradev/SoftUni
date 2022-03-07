package ExercisesLab.Hospital_Database.Entities;

import javax.persistence.*;

@Entity
public class Diagnoses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private String name;

    private String comments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    private Patients patient;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Diagnoses() {
    }
}
