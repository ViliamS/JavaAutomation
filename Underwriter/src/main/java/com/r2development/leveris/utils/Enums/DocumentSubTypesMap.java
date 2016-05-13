package com.r2development.leveris.utils.Enums;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class DocumentSubTypesMap {

    private LinkedHashMap<DOCUMENTTYPE, LinkedList<String>> documentTypeSubTypeMap;

    /**
     <option value="UTIL">Utility Bill (Gas/Electricity/Phone/Television Provider)</option>
     <option value="CRTTFA">Tax Free Allowance Certificate</option>
     <option value="RCBS">Revenue Commissioners Balancing Statement</option>
     <option value="INSDOC">Insurance Document (house, motor, life)</option>
     */
    public DocumentSubTypesMap() {
        documentTypeSubTypeMap = new LinkedHashMap<>();
        documentTypeSubTypeMap.put(DOCUMENTTYPE.BANK_STATEMENT,                             new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.CERTIFIED_ACCOUNTS_YEAR_BEFORE_LAST_YEAR,   new LinkedList<String>(){{add("Accounts");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.CERTIFIED_ACCOUNTS_LAST_YEAR,               new LinkedList<String>(){{add("Accounts");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.CONFIRMATION_OF_TAX_AFFAIRS,                new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.CREDIT_CARD,                                new LinkedList<String>(){{add("Credit Card");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.CURRENT_PAYSLIP,                            new LinkedList<String>(){{add("Payslip");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.DEED_OF_ASSIGNMENT,                         new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.DIRECT_DEBIT_CONFIRMATION,                  new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.DIRECT_DEBIT_PAPER,                         new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.DIVORCE_AGREEMENT,                          new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.EUROPEAN_STANDARD_INFORMATION_SHEET,        new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.GIFT,                                       new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.HOME_INSURANCE_POLICY,                      new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.CREDIT_SCORE_MANUAL_REPORT,                 new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.INHERITANCE,                                new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.STATEMENT_OF_SUITABILITY,                   new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.LIFE_ASSURANCE_POLICY,                      new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.SIGNED_LOAN_OFFER_LETTER,                   new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.LOAN_STATEMENT,                             new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.MARRIAGE_CERTIFICATE,                       new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.LOAN_APPLICATION_FORM,                      new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.LOAN_TERMS_AND_CONDITIONS,                  new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.NO_FORMAL_AGREEMENT,                        new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.NOTICE_OF_INTEREST_AND_FIRE,                new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.P60,                                        new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.PHOTO_IDENTIFICATION,                       new LinkedList<String>(){{add("Passport");add("Drivers License");add("European Passport Card");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.PREVIOUS_PAYSLIP,                           new LinkedList<String>(){{add("Payslip");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.PROOF_OF_ADDRESS,                           new LinkedList<String>(){{add("Utility Bill (Gas/Electricity/Phone/Television Provider)");add("Tax Free Allowance Certificate");add("Revenue Commissioners Balancing Statement");add("Insurance Document (house, motor, life)");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.PROOF_OF_RENTAL_INCOME,                     new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.PROOF_OF_RESIDENCY,                         new LinkedList<String>(){{add("Passport");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.SALARY_CERTIFICATE,                         new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.SOLICITORS_UNDERTAKING,                     new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.SUITABILITY,                                new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.SURVEY_REPORT,                              new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.VALUATION_REPORT,                           new LinkedList<String>(){{add("None");}});
        documentTypeSubTypeMap.put(DOCUMENTTYPE.OTHER,                                      new LinkedList<String>(){{add("None");}});
    }

    public LinkedHashMap<DOCUMENTTYPE, LinkedList<String>> getMap(){
        return documentTypeSubTypeMap;
    }

    public static LinkedHashMap<DOCUMENTTYPE, LinkedList<String>> getDocumentTypeMap(){
        return new DocumentSubTypesMap().getMap();
    }

    public static LinkedList<String> getDocumentSubType(String documentType){
        return getDocumentTypeMap().get(DOCUMENTTYPE.getDocumentType(documentType));
    }

}