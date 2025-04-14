package com.pluralsight.presentvalue;

import com.pluralsight.presentvalue.model.OrdinaryAnnuity;
import com.pluralsight.utils.ConsoleStringReader;

public class OrdinaryAnnuityCalculator {

    public static OrdinaryAnnuity getOrdinaryAnnuity() {
        OrdinaryAnnuity ordinaryAnnuity = new OrdinaryAnnuity();
        System.out.println("Enter the amount of periodic payment: ");
        ordinaryAnnuity.setMonthlyPayout(ConsoleStringReader.getPositiveDouble());
        System.out.println("Enter the interest rate: ");
        ordinaryAnnuity.setInterestRate(ConsoleStringReader.getPositiveDouble());
        System.out.println("Enter the number of years: ");
        ordinaryAnnuity.setYears(ConsoleStringReader.getPositiveInt());
        return ordinaryAnnuity;
    }

    public static void printOrdinaryAnnuityInfo(OrdinaryAnnuity ordinaryAnnuity) {
        //To fund an annuity that pays $3,000 monthly for 20
        //years and earns an expected 2.5% interest, you would need to
        //invest $566,141.46 today.
        System.out.printf("To fund an annuity that pays $%.2f monthly for %d years and earns an expected %.2f%% interest, " +
                        "you would need to invest $%.2f today.%n",
                ordinaryAnnuity.getMonthlyPayout().getDoubleValue(),
                ordinaryAnnuity.getYears(),
                ordinaryAnnuity.getExpectedInterestRate().getDoubleValue(),
                ordinaryAnnuity.getPresentValue().getDoubleValue());
    }

}
