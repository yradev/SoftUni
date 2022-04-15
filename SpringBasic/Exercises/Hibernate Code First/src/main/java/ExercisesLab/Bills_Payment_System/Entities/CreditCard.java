package ExercisesLab.Bills_Payment_System.Entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CreditCard extends BillingDetails {

    @Column(nullable = false)
    private String card_type;
    @Column(nullable = false)
    private int expiration_month;
    @Column(nullable = false)
    private int expiration_year;

    public CreditCard() {
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public int getExpiration_month() {
        return expiration_month;
    }

    public void setExpiration_month(int expiration_month) {
        this.expiration_month = expiration_month;
    }

    public int getExpiration_year() {
        return expiration_year;
    }

    public void setExpiration_year(int expiration_year) {
        this.expiration_year = expiration_year;
    }
}
