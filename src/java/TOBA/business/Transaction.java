/*
 Transaction*/
package TOBA.business;

import java.io.Serializable;
import java.text.NumberFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author David
 */
@Entity
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transID;
    private double startBal;
    private double endBal;
    private double transAmnt;
    private String transType;

    public Transaction() {

    }

    public Transaction(double start, double end, double amnt, String type) {
        this.startBal = start;
        this.endBal = end;
        this.transAmnt = amnt;
        this.transType = type;
    }

    public double getStartBal() {
        return startBal;
    }

    public String getStartCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(startBal);
    }

    public String getEndCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(endBal);
    }

    public String getTransCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(transAmnt);
    }

    public double getEndBal() {
        return endBal;
    }

    public double getTransAmnt() {
        return transAmnt;
    }

    public String getTransType() {
        return transType;
    }

}
