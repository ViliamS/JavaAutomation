package com.r2development.leveris.tdd.borrower;

import org.junit.Test;

import java.util.Collection;
import java.util.LinkedHashSet;

public class CalQuoteCombination {

    @Test
    public void CalQuoteCombination() {

        Collection<String> howManyBorrowers = new LinkedHashSet<>();
        howManyBorrowers.add("a single borrower");
        howManyBorrowers.add("two borrowers");

        Collection<String> quoteType = new LinkedHashSet<>();
        quoteType.add("first time buyer(s)"); // FTB
        quoteType.add("mover(s)"); // MOV

        Collection<String> borrowerAge = new LinkedHashSet<>();
        borrowerAge.add("15");
        borrowerAge.add("16");
        borrowerAge.add("17");
        borrowerAge.add("18");
        borrowerAge.add("19");
        borrowerAge.add("20");
        borrowerAge.add("21");
        borrowerAge.add("22");
        borrowerAge.add("23");
        borrowerAge.add("24");
        borrowerAge.add("25");
        borrowerAge.add("26");
        borrowerAge.add("27");
        borrowerAge.add("28");
        borrowerAge.add("29");
        borrowerAge.add("30");
        borrowerAge.add("31");
        borrowerAge.add("32");
        borrowerAge.add("33");
        borrowerAge.add("34");
        borrowerAge.add("35");
        borrowerAge.add("36");
        borrowerAge.add("37");
        borrowerAge.add("38");
        borrowerAge.add("39");
        borrowerAge.add("40");
        borrowerAge.add("41");
        borrowerAge.add("42");
        borrowerAge.add("43");
        borrowerAge.add("44");
        borrowerAge.add("45");

        Collection<String> coapplicantAge = new LinkedHashSet<>();
        coapplicantAge.add("15");
        coapplicantAge.add("16");
        coapplicantAge.add("17");
        coapplicantAge.add("18");
        coapplicantAge.add("19");
        coapplicantAge.add("20");
        coapplicantAge.add("21");
        coapplicantAge.add("22");
        coapplicantAge.add("23");
        coapplicantAge.add("24");
        coapplicantAge.add("25");
        coapplicantAge.add("26");
        coapplicantAge.add("27");
        coapplicantAge.add("28");
        coapplicantAge.add("29");
        coapplicantAge.add("30");
        coapplicantAge.add("31");
        coapplicantAge.add("32");
        coapplicantAge.add("33");
        coapplicantAge.add("34");
        coapplicantAge.add("35");
        coapplicantAge.add("36");
        coapplicantAge.add("37");
        coapplicantAge.add("38");
        coapplicantAge.add("39");
        coapplicantAge.add("40");
        coapplicantAge.add("41");
        coapplicantAge.add("42");
        coapplicantAge.add("43");
        coapplicantAge.add("44");
        coapplicantAge.add("45");

        Collection<String> maritalStatus = new LinkedHashSet<>();
        maritalStatus.add("Single"); // SIN
        maritalStatus.add("Separated"); // SEP
        maritalStatus.add("Married"); // MAR
        maritalStatus.add("Divorced"); // DIV
        maritalStatus.add("Window"); // WID

        Collection<String> dependents = new LinkedHashSet<>();
        dependents.add("0");
        dependents.add("1");
        dependents.add("2");
        dependents.add("3");
        dependents.add("4");
        dependents.add("5");
        dependents.add("6");
        dependents.add("7");
        dependents.add("8");
        dependents.add("9");
        dependents.add("10");

        Collection<String> employmentType1 = new LinkedHashSet<>();
        employmentType1.add("Employee"); // PAY
        employmentType1.add("Civil Servant"); // CIV
        employmentType1.add("Self Employed"); // SEL

        Collection<String> salary1 = new LinkedHashSet<>();
        salary1.add("80000");
        salary1.add("90000");
        salary1.add("100000");
        salary1.add("110000");
        salary1.add("120000");
        salary1.add("130000");
        salary1.add("140000");
        salary1.add("150000");

        Collection<String> employmentType2 = new LinkedHashSet<>();
        employmentType2.add("Employee : PAY"); // PAY
        employmentType2.add("Civil Servant"); // CIV
        employmentType2.add("Self Employed"); // SEL

        Collection<String> salary2 = new LinkedHashSet<>();
        salary2.add("80000");
        salary2.add("90000");
        salary2.add("100000");
        salary2.add("110000");
        salary2.add("120000");
        salary2.add("130000");
        salary2.add("140000");
        salary2.add("150000");

        Collection<String> monthlyCommitment = new LinkedHashSet<>();
        monthlyCommitment.add("0");
        monthlyCommitment.add("1000");
        monthlyCommitment.add("1500");
        monthlyCommitment.add("2000");
        monthlyCommitment.add("2500");
        monthlyCommitment.add("3000");

        for ( String currentNbBorrower : howManyBorrowers ) {
            for ( String currentQuoteType : quoteType) {
                for ( String currentBorrowerAge : borrowerAge ) {
                    for ( String currentCoapplicantAge : coapplicantAge) {
                        for ( String currentMaritalStatus : maritalStatus ) {
                            for ( String currentDependent : dependents ) {
                                for ( String currentEmploymentType1 : employmentType1 ) {
                                    for ( String currentSalary1 : salary1 ) {
                                        for ( String currentEmploymentType2 : employmentType2 ) {
                                            for ( String currentSalary2 : salary2 ) {
                                                for ( String currentMonthlyCommitment : monthlyCommitment ) {
                                                    System.out.println("| " + currentNbBorrower + " | " + currentQuoteType + " | " + currentBorrowerAge + " | " + currentCoapplicantAge + " | " + currentMaritalStatus + " | " + currentDependent + " | " + currentEmploymentType1 + " | " + currentSalary1 + " | " + currentEmploymentType2 + " | " + currentSalary2 + " | " + currentMonthlyCommitment + " | | | | | | |");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
