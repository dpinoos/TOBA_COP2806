package TOBA.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();;
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
    
   

    public String getAccountType() {
        return accountType;
    }

    public User getAccountOwner() {
        return accountOwner;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransactions(Transaction t){
        transactions.add(t);
    }
    
    public void credit(double amt) {
        balance = balance + amt;
    }

    public void debit(double amt) {
        balance = balance - amt;
    }

}
