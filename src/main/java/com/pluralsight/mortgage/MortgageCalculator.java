package com.pluralsight.mortgage;

import com.pluralsight.mortgage.model.MortgagePaymentInfo;
import com.pluralsight.utils.ConsoleStringReader;

public class MortgageCalculator {

    public static MortgagePaymentInfo getMortgageInfo() {
        MortgagePaymentInfo mortgagePaymentInfo = new MortgagePaymentInfo();
        System.out.println("Please enter the principal:");
        mortgagePaymentInfo.setPrincipal(ConsoleStringReader.getPositiveDouble());
        System.out.println("Please enter the interest rate:");
        mortgagePaymentInfo.setInterestRate(ConsoleStringReader.getPositiveDouble());
        System.out.println("Please enter the loan length in years:");
        mortgagePaymentInfo.setLoanLength(ConsoleStringReader.getPositiveInt());
        return mortgagePaymentInfo;
    }

    public static void printMortgageInfo(MortgagePaymentInfo mortgagePaymentInfo) {
        System.out.printf("A $%.2f loan at %.3f%% interest for %d years would have a $%.2f/mo payment with a total interest of $%.2f%n",
                mortgagePaymentInfo.getPrincipal().getDoubleValue(),
                mortgagePaymentInfo.getInterestRate().getDoubleValue(),
                mortgagePaymentInfo.getLoanLength(),
                mortgagePaymentInfo.getMonthlyPayment().getDoubleValue(),
                mortgagePaymentInfo.calculateTotalInterestPaid().getDoubleValue());
    }

}
