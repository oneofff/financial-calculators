package com.pluralsight.futurevalue;

import com.pluralsight.futurevalue.model.CertificateDeposit;

public class Main {
    public static void main(String[] args) {
        CertificateDeposit certificateDeposit = CertificateDepositCalculator.getCertificateDepositInfo();
        certificateDeposit.setFutureValue(certificateDeposit.calculateFutureValue());
        certificateDeposit.setInterestEarned(certificateDeposit.calculateInterestEarned());
        CertificateDepositCalculator.printCertificateDepositInfo(certificateDeposit);
    }
}