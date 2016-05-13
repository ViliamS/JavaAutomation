package com.r2development.leveris.utils.Enums;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collections;
import java.util.LinkedList;

public enum DOCUMENTTYPE {

    /**
     >​Certified Accounts (Year before last year)<    ">Certified Accounts (Year before last year)<
     >Certified Accounts (Last year)<                 ">Certified Accounts (Last year)<
     >Confirmation of Tax Affairs<                    ">Confirmation of Tax Affairs<
     >Credit Card<                                    ">Credit Card<
     >Current Payslip<                                ">Current Payslip<
     >Deed of Assignment<                             ">Deed of Assignment<
     >Direct debit confirmation<                      ">Direct debit confirmation<
     >Direct debit - paper<                           ">Direct debit - paper<
     >Divorce Agreement<                              ">Divorce Agreement<
     >European Standard Information Sheet<            ">European Standard Information Sheet<
     >Gift<                                           ">Gift<
     >Home Insurance Policy<                          ">Home Insurance Policy<
     >Credit score manual report<                     ">Credit score manual report<
     >Inheritance<                                    ">Inheritance<
     >Statement of suitability<                       ">Statement of suitability<
     >Life Assurance Policy<                          ">Life Assurance Policy<
     >Signed loan offer letter<                       ">Signed loan offer letter<
     >Loan Statement<                                 ">Loan Statement<
     >Marriage Certificate<                           ">Marriage Certificate<
     >Loan application form<                          >Loan application form<
     >Loan Terms & Conditions<                        ">Loan Terms &amp; Conditions<
     >No Formal Agreement<                            ">No Formal Agreement<
     >Notice of Interest and Fire<                    ">Notice of Interest and Fire<
     >P60<                                            ">P60</
     >Photo Identification<                           ">Photo Identification<
     >Previous Payslip<                               >Previous Payslip<
     >Proof of Address<                               ">Proof of Address<
     >Proof of Rental Income<                         ">Proof of Rental Income<
     >Proof of Residency<                             ">Proof of Residency<
     >Salary Certificate<                             ">Salary Certificate<
     >Solicitors undertaking<                         ">Solicitors undertaking<
     >Suitability<                                    ">Suitability<
     >Survey Report<                                  ">Survey Report<
     >Valuation Report<                               ">Valuation Report<
     >Other​<                                         ">Other<
     >Bank Statement<                                >Bank Statement<
     */

    BANK_STATEMENT                              ("Bank Statement", "BANSTM"),
    CERTIFIED_ACCOUNTS_YEAR_BEFORE_LAST_YEAR    ("Certified Accounts (Year before last year)", "ACCS2"),
    CERTIFIED_ACCOUNTS_LAST_YEAR                ("Certified Accounts (Last year)", "ACCS1"),
    CONFIRMATION_OF_TAX_AFFAIRS                 ("Confirmation of Tax Affairs", "TAXAFF"),
    CREDIT_CARD                                 ("Credit Card", "CRDSTM"),
    CURRENT_PAYSLIP                             ("Current Payslip", "PAYS1"),
    DEED_OF_ASSIGNMENT                          ("Deed of Assignment", "DEOASS"),
    DIRECT_DEBIT_CONFIRMATION                   ("Direct debit confirmation", "DOC_DDCL"),
    DIRECT_DEBIT_PAPER                          ("Direct debit - paper", "DIRDEB"),
    DIVORCE_AGREEMENT                           ("Divorce Agreement", "DIVAGR"),
    EUROPEAN_STANDARD_INFORMATION_SHEET         ("European Standard Information Sheet", "DOC_ESIS"),
    GIFT                                        ("Gift", "GIFLET"),
    HOME_INSURANCE_POLICY                       ("Home Insurance Policy", "HOINPD"),
    CREDIT_SCORE_MANUAL_REPORT                  ("Credit score manual report", "ICBREPMAN"),
    INHERITANCE                                 ("Inheritance", "INHLET"),
    STATEMENT_OF_SUITABILITY                    ("Statement of suitability", "DOC_LOS"),
    LIFE_ASSURANCE_POLICY                       ("Life Assurance Policy", "LAPOLD"),
    SIGNED_LOAN_OFFER_LETTER                    ("Signed loan offer letter", "DOC_LOLS"),
    LOAN_STATEMENT                              ("Loan Statement", "LOASTM"),
    MARRIAGE_CERTIFICATE                        ("Marriage Certificate", "MARCER"),
    LOAN_APPLICATION_FORM                       ("Loan application form", "DOC_MAF"),
    LOAN_STATEMENT2                             ("Loan Statement", "MTGSTM"),
    LOAN_TERMS_AND_CONDITIONS                   ("Loan Terms & Conditions", "AGR_MTC"),
    NO_FORMAL_AGREEMENT                         ("No Formal Agreement", "NOFAGR"),
    NOTICE_OF_INTEREST_AND_FIRE                 ("Notice of Interest and Fire", "NOTINF"),
    P60                                         ("P60", "P60"),
    PHOTO_IDENTIFICATION                        ("Photo Identification", "PROID"),
    PREVIOUS_PAYSLIP                            ("Previous Payslip", "PAYS2"),
    PROOF_OF_ADDRESS                            ("Proof of Address", "PROADR"),
    PROOF_OF_RENTAL_INCOME                      ("Proof of Rental Income", "RENTB"),
    PROOF_OF_RESIDENCY                          ("Proof of Residency", "PRORES"),
    SALARY_CERTIFICATE                          ("Salary Certificate", "SALCERT"),
    SOLICITORS_UNDERTAKING                      ("Solicitors undertaking", "SOLUND"),
    SUITABILITY                                 ("Suitability", "DOC_LOSF"),
    SURVEY_REPORT                               ("Survey Report", "SURREP"),
    VALUATION_REPORT                            ("Valuation Report", "VALREP"),
    OTHER                                       ("Other", "OTHER");

    private String documentType;
    private String documentCode;

    private static final Log log = LogFactory.getLog(DOCUMENTTYPE.class.getName());

    DOCUMENTTYPE(String documentType, String documentCode) {
        this.documentType = documentType;
        this.documentCode = documentCode;
    }

    public String getDocumentCode(){
        return documentCode;
    }

    public String getDocumentType() {
        return documentType;
    }

    private static String transformationOfStringToEnumName(String text) {
        return text.toUpperCase().replace(" ", "_").replace("(", "").replace(")", "");
    }

    public static DOCUMENTTYPE getDocumentType(String filterName) {
        log.info("\n DOCUMENTTYPE getDocumentType(String filterName ----> '" + filterName + "')\n");
        return DOCUMENTTYPE.valueOf(DOCUMENTTYPE.transformationOfStringToEnumName(filterName));
    }

    public static LinkedList<DOCUMENTTYPE> getEnumValues() {
        LinkedList<DOCUMENTTYPE> enumValuesList = new LinkedList<>();
        Collections.addAll(enumValuesList, DOCUMENTTYPE.values());
        return enumValuesList;
    }
}