package ExercisesLab.Hospital_Database.Entities;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

@Entity
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Set<Medicaments> getMedicaments() {
        return Collections.unmodifiableSet(medicaments);
    }

    public Set<Diagnoses> getDiagnoses() {
        return Collections.unmodifiableSet(diagnoses);
    }

    public int getId() {
        return id;
    }

    @Column (nullable = false)
    private String first_name;
    @Column (nullable = false)
    private String last_name;
    @Column (nullable = false)
    private String address;
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate birthDate;

    private byte[] picture;

    @Column (nullable = false)
    private boolean medical_insurance;

    @OneToMany(mappedBy = "patient")
    private Set<Visitations> visitations;
    @OneToMany(mappedBy = "patient")
    private Set<Medicaments> medicaments;
    @OneToMany(mappedBy = "patient")
    private Set<Diagnoses> diagnoses;

    public Patients() {
    }

    public Set<Visitations> getVisitations() {
        return Collections.unmodifiableSet(visitations);
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public boolean isMedical_insurance() {
        return medical_insurance;
    }

    public void setMedical_insurance(boolean medical_insurance) {
        this.medical_insurance = medical_insurance;
    }
}
