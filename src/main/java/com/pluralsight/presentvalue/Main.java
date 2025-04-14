package com.pluralsight.presentvalue;

import com.pluralsight.presentvalue.model.OrdinaryAnnuity;

public class Main {
    public static void main(String[] args) {
        OrdinaryAnnuity ordinaryAnnuity = OrdinaryAnnuityCalculator.getOrdinaryAnnuity();
        ordinaryAnnuity.setPresentValue(ordinaryAnnuity.calculatePresentValue());
        OrdinaryAnnuityCalculator.printOrdinaryAnnuityInfo(ordinaryAnnuity);
    }
}