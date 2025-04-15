package com.pluralsight.futurevalue;

import com.pluralsight.futurevalue.domain.CertificateOfDeposit;
import com.pluralsight.futurevalue.ui.CertificateDepositConsoleUI;

public class CertificateDepositApp {
    public static void main(String[] args) {
        CertificateOfDeposit certificateOfDeposit = CertificateDepositConsoleUI.getCertificateDepositInfo();
        certificateOfDeposit.setFutureValue(certificateOfDeposit.calculateFutureValue());
        certificateOfDeposit.setInterestEarned(certificateOfDeposit.calculateInterestEarned());
        CertificateDepositConsoleUI.printCertificateDepositInfo(certificateOfDeposit);
    }
}