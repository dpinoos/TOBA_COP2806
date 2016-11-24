package TOBA.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author David
 */


@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long accountId;
    private String accountType;
    @ManyToOne
    private User accountOwner;
    private double balance;
    
    public Account() {
    }

    public Account(String accntType, double balance, User acctOwner) {
        this.accountOwner = acctOwner;
        this.balance = balance;
        this.accountType = accntType;
    }

    
    public double getBalance() {
        return this.balance;
    }


    public void credit(double amt) {
        balance = balance + amt;
    }

    public void debit(double amt) {
        balance = balance - amt;
    }

}
