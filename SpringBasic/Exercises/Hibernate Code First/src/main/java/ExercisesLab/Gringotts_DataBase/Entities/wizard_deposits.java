package ExercisesLab.Gringotts_DataBase.Entities;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static Messages.ExerciseMessages.*;

@Entity
@Table (name = "wizard_deposits")
public class wizard_deposits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String first_name;
    @Column(length = 60, nullable = false)
    private String last_name;
    @Column(length = 1000)
    private String notes;
    @Column(nullable = false)
    private int age;
    @Column(length = 100)
    private String magic_wand_creator;
    private int magic_wand_size;
    @Column(length = 20)
    private String deposit_group;
    private LocalDateTime deposit_start_date;
    private double deposit_amount;
    private double deposit_interest;
    private double deposit_charge;
    private LocalDateTime deposit_expiration_date;
    private boolean is_deposit_expired;


    public wizard_deposits() {}
}
