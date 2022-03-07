package ExercisesLab.Hospital_Database.Entities;

import javax.persistence.*;

@Entity
public class Medicaments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Medicaments() {
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    private Patients patient;
}
