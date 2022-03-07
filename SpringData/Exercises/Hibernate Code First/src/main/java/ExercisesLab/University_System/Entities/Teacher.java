package ExercisesLab.University_System.Entities;

import javax.persistence.*;

@Entity
public class Teacher extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int email;
    @Column(nullable = false)
    private int salary_per_hour;
}
