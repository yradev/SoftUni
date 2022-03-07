package ExercisesLab.University_System.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int average_grade;
    @Column(nullable = false)
    private int attendance;

    @ManyToMany(mappedBy = "students")
    private Set<Course>courses;
}
