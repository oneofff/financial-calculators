package com.pluralsight.mortgage.model;

import com.pluralsight.utils.BankBigDecimal;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Setter
@Getter
public class MortgagePaymentInfo {
    private BankBigDecimal principal;
    private BankBigDecimal interestRate;
    private Integer loanLength;
    @Setter
    private BankBigDecimal monthlyPayment;
    private BankBigDecimal totalInterestPaid;


    public BankBigDecimal calculateMonthlyPayment() {
        BankBigDecimal monthlyInterestRate = this.interestRate.divide(100).divide(12);
        int numberOfPayments = this.loanLength * 12;

        BankBigDecimal factor = monthlyInterestRate.add(BigDecimal.ONE).pow(numberOfPayments);
        BankBigDecimal numerator = monthlyInterestRate.multiply(factor);
        BankBigDecimal denominator = factor.subtract(BigDecimal.ONE);
        BankBigDecimal monthlyPayment = this.principal.multiply(numerator.divide(denominator));

        return monthlyPayment;
    }

    public BankBigDecimal calculateTotalInterestPaid() {
        int numberOfPayments = this.loanLength * 12;

        if (this.monthlyPayment == null)
            monthlyPayment = this.calculateMonthlyPayment();

        return this.monthlyPayment.multiply(numberOfPayments).subtract(this.principal);
    }


    public void setPrincipal(double principal) {
        this.principal = new BankBigDecimal(principal);
    }


    public void setInterestRate(double interestRate) {
        this.interestRate = new BankBigDecimal(interestRate);
    }

    public void setLoanLength(int loanLength) {
        this.loanLength = loanLength;
    }

}