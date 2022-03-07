package ExercisesLab.Bills_Payment_System.Entities;

import javax.persistence.*;


@Entity
public class BillingDetails extends BaseEntity {
    private int number;



    @ManyToOne
    private Users owner;

    public BillingDetails() {
    }

    public BillingDetails(Users user) {
        this.owner = user;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

