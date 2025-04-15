package com.pluralsight.futurevalue.model;

import com.pluralsight.utils.BankBigDecimal;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class CertificateDeposit {
    private BankBigDecimal deposit;
    private BankBigDecimal annualInterestRate;
    private Integer years;
    private BankBigDecimal futureValue;
    private BankBigDecimal interestEarned;

    public void setDeposit(double deposit) {
        this.deposit = new BankBigDecimal(deposit);
    }

    public void setAnnualInterestRate(double anualInterestRate) {
        this.annualInterestRate = new BankBigDecimal(anualInterestRate);
    }

    public void setYears(int years) {
        this.years = years;
    }

    public BankBigDecimal calculateFutureValue() {
        BankBigDecimal interestRate = this.annualInterestRate.divide(100);
        int exponent = this.years * 365;
        BankBigDecimal base = BankBigDecimal.ONE.add(interestRate.divide(365));
        BankBigDecimal futureValue = this.deposit.multiply(base.pow(exponent));
        return futureValue;
    }

    public BankBigDecimal calculateInterestEarned() {
        if (this.futureValue == null) {
            this.futureValue = this.calculateFutureValue();
        }
        return this.calculateFutureValue().subtract(this.deposit);
    }
}
