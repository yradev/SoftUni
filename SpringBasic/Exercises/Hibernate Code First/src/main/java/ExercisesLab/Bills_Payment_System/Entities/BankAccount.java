package ExercisesLab.Bills_Payment_System.Entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BankAccount extends BillingDetails{

    @Column(nullable = false)
    private String bank_name;
    @Column(nullable = false)
    private String SWIFT;

    public BankAccount() {
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getSWIFT() {
        return SWIFT;
    }

    public void setSWIFT(String SWIFT) {
        this.SWIFT = SWIFT;
    }
}
