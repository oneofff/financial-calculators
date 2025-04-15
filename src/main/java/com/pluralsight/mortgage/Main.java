package com.pluralsight.mortgage;

import com.pluralsight.mortgage.model.MortgagePaymentInfo;

public class Main {
    public static void main(String[] args) {
        MortgagePaymentInfo mortgageInfo = MortgageCalculator.getMortgageInfo();
        mortgageInfo.setMonthlyPayment(mortgageInfo.calculateMonthlyPayment());
        mortgageInfo.setTotalInterestPaid(mortgageInfo.calculateTotalInterestPaid());
        MortgageCalculator.printMortgageInfo(mortgageInfo);
    }
}