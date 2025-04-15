package com.pluralsight.presentvalue.model;

import com.pluralsight.utils.BankBigDecimal;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Setter
@Getter
public class OrdinaryAnnuity {
    private BankBigDecimal monthlyPayout;
    private BankBigDecimal expectedInterestRate;
    private Integer termInYears;
    private BankBigDecimal presentValue;

    public BankBigDecimal calculatePresentValue() {
        BankBigDecimal interestRate = this.expectedInterestRate.divide(100).divide(12);
        int numberOfPayments = this.termInYears * 12;
        BankBigDecimal factor = interestRate.add(BigDecimal.ONE).pow(-numberOfPayments);
        BankBigDecimal numerator = BankBigDecimal.ONE.subtract(factor);
        BankBigDecimal denominator = interestRate;
        return this.monthlyPayout.multiply(numerator.divide(denominator));
    }

    public void setMonthlyPayout(double monthlyPayout) {
        this.monthlyPayout = new BankBigDecimal(monthlyPayout);
    }

    public void setInterestRate(double positiveDouble) {
        this.expectedInterestRate = new BankBigDecimal(positiveDouble);
    }


}