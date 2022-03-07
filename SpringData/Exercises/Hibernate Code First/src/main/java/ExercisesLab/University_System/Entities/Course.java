package ExercisesLab.University_System.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private LocalDate start_date;

    private LocalDate end_date;

    private int credits;

    @ManyToMany
    @JoinTable(name = "students_course",
    joinColumns =
    @JoinColumn(name = "student_id",referencedColumnName = "id"),
    inverseJoinColumns =
    @JoinColumn(name = "course_id",referencedColumnName = "id"))
    private Set<Student> students;

   @ManyToOne
    private Teacher teacher;

}
