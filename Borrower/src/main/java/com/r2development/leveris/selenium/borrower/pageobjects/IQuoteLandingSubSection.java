package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IQuoteLandingSubSection {

    String
            HEADER_GREAT_AND_QUICK_LOAN_XPATH = "//div[contains(@wicketpath,'UnsecuredLoan')]/div[contains(@wicketpath,'UnsecuredLoan')]/span[text()='Unsecured Loan']", // TODO: 09/02/16  - This Header is missing
            SUB_HEADER_UNSECURED_LOAN_XPATH = "//div[contains(@wicketpath,'UnsecuredLoan')]/div[contains(@wicketpath,'UnsecuredLoan')]/span[text()='Unsecured Loan']",
            LOAN_UP_TO_LOAN_AMOUNT_XPATH = "//div[@id='value']//a[contains(text(),'Up to')]",
            RED_CONTINUE_BUTTON_XPATH = "//div[@id='value']//button[@name='RedContinueButton']",
            TEAL_CONTINUE_BUTTON_XPATH = "//div[@id='value']//button[@name='TealContinueButton']",
            HEADER_PAYDAY_LOAN_XPATH = "//div[@id='value']//a[text()='Payday loan']",
            PAYDAY_LOAN_AMOUNT_XPATH = "//a[text()='Payday loan']/div[contains(@anyElementExceptText,'value')]",
            HEADER_MORTGAGE_XPATH = "//div[@id='value']//a[text()='Mortgage']",
            HEADER_DEBIT_CONSOLIDATION_XPATH = "//div[@id='value']//a[text()='Debit consolidation']",
            TITLE_FROM_AMOUNT_PER_MONTH_XPATH = "//div[@id='value']//span[contains(text()='from £')]";

    QuickLoanPage clickContinueTealButton();

    QuickLoanPage clickContinueRedButton();

    boolean isHeaderGreatAndQuickLoanPresent();

    boolean isSubHeaderUnsecuredLoanPresent();

    boolean isLoanUpToLoanAmountPresent();

    String getValueLoanUpTo();

    String getPayDayLoanAmount();

    boolean isHeaderPayDayLoanPresent();

    boolean isHeaderMortgagePresent();

    boolean isHeaderDebitConsolidationPresent();

    boolean isTitleFromAmountPerMonthPresent();

    String getFromAmountPerMonthValue();
}
