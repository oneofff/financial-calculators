package com.pluralsight.futurevalue;

import com.pluralsight.futurevalue.model.CertificateDeposit;
import com.pluralsight.utils.ConsoleStringReader;

public class CertificateDepositCalculator {


    public static CertificateDeposit getCertificateDepositInfo() {
        CertificateDeposit certificateDeposit = new CertificateDeposit();
        System.out.println("Please enter the deposit:");
        certificateDeposit.setDeposit(ConsoleStringReader.getPositiveDouble());
        System.out.println("Please enter the interest rate:");
        certificateDeposit.setInterestRate(ConsoleStringReader.getPositiveDouble());
        System.out.println("Please enter the number of years:");
        certificateDeposit.setYears(ConsoleStringReader.getPositiveInt());
        return certificateDeposit;
    }

    public static void printCertificateDepositInfo(CertificateDeposit certificateDeposit) {
        System.out.printf("If you deposit $%.2f in a CD that earns %.2f%% interest and matures in %d years," +
                        " your CD's ending balance will be $%.2f and you would have earned $%.2f in interest%n",
                certificateDeposit.getDeposit().getDoubleValue(),
                certificateDeposit.getInterestRate().getDoubleValue(),
                certificateDeposit.getYears(),
                certificateDeposit.calculateFutureValue().getDoubleValue(),
                certificateDeposit.calculateInterestEarned().getDoubleValue());
    }

}
