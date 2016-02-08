@GetQuotePage
Feature: Check Apollo displaying Borrower Data

  Background:
    Given user goes to Registration page

#  Scenario: Quote Creation High Level
#    Given user creates an account
#    When user logs in as his account is activated
#    Then user processes "Get a Quote"
#    And user processes "Invite a co-applicant"
##    And user processes "Forms"
#    And user fills in "Borrower's personal details"
#    And user fills in "Coapplicant's personal details"

  Scenario: Quote Creation Low Level
    Given user creates an account
    When user logs in as his account is activated
    Then user processes "Get a Quote"
    And user processes "Invite a co-applicant"
    And user processes "Forms"

#    PERSONAL DETAILS

    When user clicks "Borrower Personal Details"
    Then borrower user sees his name in the Personal Details title
    And borrower user types his firstname : Tonda
    And borrower user types his lastname : Mottot
    And borrower user checks his gender : Male
    And borrower user types his date of birth : 20/10/1978
    And borrower user selects his marital status : married/civil partner(s)
    And borrower user selects his nationality : French
    And borrower user types the number of resident years : 3
#    And borrower user checks if he is requiring a visa
    And borrower user types his residency address in line 1 : Prague, Czech Republic
    And borrower user types his residency address in line 2 : Hlavní město Praha
    And borrower user types his residency town/city : Prague
#    And borrower user selects his residency County/State : ???
    And borrower user types his postcode/zip : 14000
    And borrower user selects his residency country : Czech Republic
    And borrower user selects his residency accommodation : Rented on contract
    And borrower user types his residency rent : 200
    And borrower user checks if he is not living since 3 years
    And borrower user types his previous residency address in line 1 : Dijon, France
    And borrower user types his previous residency address in line 2 : Burgundy
    And borrower user types his previous residency town/city : Dijon
#    And borrower user selects his previous residency county/state :
    And borrower user types his previous residency postcode/zip : 21000
    And borrower user types his previous residency country : France
    And borrower user saves his personal details data
    When user clicks "Coapplicant Personal Details"
    Then coapplicant user sees his name in the Personal Details title
    And coapplicant user types his firstname : Anthony Mottot co-applicant
    And coapplicant user types his lastname : Mottot
    And coapplicant user checks his gender : Male
    And coapplicant user types his date of birth : 20/10/1978
    And coapplicant user selects his marital status : married/civil partner(s)
    And coapplicant user selects his nationality : French
    And coapplicant user types the number of resident years : 3
#    And coapplicant user checks if he is requiring a visa
    And coapplicant user types his residency address in line 1 : Prague, Czech Republic
    And coapplicant user types his residency address in line 2 : Hlavní město Praha
    And coapplicant user types his residency town/city : Prague
#    And coapplicant user selects his residency County/State : ???
    And coapplicant user types his postcode/zip : 14000
    And coapplicant user selects his residency country : Czech Republic
    And coapplicant user selects his residency accommodation : Rented on contract
    And coapplicant user types his residency rent : 200
    And coapplicant user checks if he is not living since 3 years
    And coapplicant user types his previous residency address in line 1 : Dijon, France
    And coapplicant user types his previous residency address in line 2 : Burgundy
    And coapplicant user types his previous residency town/city : Dijon
#    And coapplicant user selects his previous residency county/state :
    And coapplicant user types his previous residency postcode/zip : 21000
    And coapplicant user types his previous residency country : France
    And coapplicant user saves his personal details data

#    EMPLOYMENT & INCOME

    When user clicks "Borrower Employment Income"
    Then borrower user sees his name in the Employment & Income title
    And borrower user selects the employment & income category : Paye
    # problem of xpath or select method
    And borrower user selects the Paye occupation : Accountant
    And borrower user types the Paye employer's name : Test
    And borrower user selects the Paye employment type : Contract
    And borrower user types the Paye start date : 01/01/2013
    And borrower user types the Paye end date : 01/01/2014
    # to check if displayed or not !! disappear when end date is field ?
#    And borrower user checks the PAYE currently
    And borrower user types the Paye gross salary : 200
    And borrower user types the Paye regular overtime : 200
    And borrower user types the Paye regular guaranteed bonus : 100
    And borrower user types the Paye guaranteed commission : 100
    And borrower user clicks "Add This Employment"

    When borrower user clicks "ADD EMPLOYMENT"
    Then borrower user selects the employment & income category : Self Employed
    And borrower user selects the Self Employed occupation : Accountant
    And borrower user types the Self Employed business name : Business name Self Employed
    And borrower user types the Self Employed address line 1 : Prague
    And borrower user types the Self Employed address line 2 : address line 2
    And borrower user types the Self Employed town/city : Prague
    And borrower user types the Self Employed county/state : Dublin
    And borrower user selects the Self Employed country : Czech Republic
    And borrower user types the Self Employed nature of business : it's my nature
    And borrower user types the Self Employed start date : 01/01/2013
    And borrower user types the Self Employed end date : 01/01/2014
    And borrower user checks the Self Employed currently
    And borrower user types the Self Employed net profit last year : 200
    And borrower user types the Self Employed net profit previous year : 200
    And borrower user types the Self Employed accountant name / practice : accountant name test
    And borrower user clicks "Add This Employment"

    When borrower user clicks "ADD EMPLOYMENT"
    Then borrower user sees his name in the Employment & Income title
    And borrower user selects the employment & income category : Paye
    And borrower user selects the Civil Servant occupation : Accountant
    And borrower user types the Civil Servant employer's name : Test
    And borrower user selects the Civil Servant employment type : Permanent
    And borrower user types the Civil Servant start date : 01/01/2013
    And borrower user types the Civil Servant end date : 01/01/2014
    And borrower user checks the Civil Servant currently
    And borrower user types the Civil Servant gross salary : 200
    And borrower user types the Civil Servant regular overtime : 200
    And borrower user types the Civil Servant regular guaranteed bonus : 100
    And borrower user types the Civil Servant guaranteed commission : 100
    And borrower user clicks "Add This Employment"

    When borrower user clicks "ADD EMPLOYMENT"
#    Then borrower user selects the employment & income category : Unemployed/Homemaker
    Then borrower user selects the employment & income category : Unemployed
    And borrower user types the Unemployed/Homemaker start date : 01/01/2015
    And borrower user types the Unemployed/Homemaker end date : 01/10/2015
    And borrower user checks the Unemployed/Homemaker currently
    And borrower user clicks "Add This Employment"

#    When borrower user clicks "ADD EMPLOYMENT"
#    Then borrower user selects the employment & income category : Other
#    And borrower user types the Other source of additional income : Testing
#    And borrower user types the Other gross income : 200
#    And borrower user types the Other time earning this income : 200
#    And borrower user clicks "Add This Employment"
    And borrower user clicks "Done"

    When user clicks "Coapplicant Employment Income"
    Then coapplicant user sees his name in the Employment & Income title
    And coapplicant user selects the employment & income category : Paye
    # problem of xpath or select method
    And coapplicant user selects the Paye occupation : Accountant
    And coapplicant user types the Paye employer's name : Test
    And coapplicant user selects the Paye employment type : Contract
    And coapplicant user types the Paye start date : 01/01/2013
    And coapplicant user types the Paye end date : 01/01/2014
    # to check if displayed or not !! disappear when end date is field ?
#    And coapplicant user checks the PAYE currently
    And coapplicant user types the Paye gross salary : 200
    And coapplicant user types the Paye regular overtime : 200
    And coapplicant user types the Paye regular guaranteed bonus : 100
    And coapplicant user types the Paye guaranteed commission : 100
    And coapplicant user clicks "Add This Employment"

    When coapplicant user clicks "ADD EMPLOYMENT"
    Then coapplicant user selects the employment & income category : Self Employed
    And coapplicant user selects the Self Employed occupation : Accountant
    And coapplicant user types the Self Employed business name : Business name Self Employed
    And coapplicant user types the Self Employed address line 1 : Prague
    And coapplicant user types the Self Employed address line 2 : address line 2
    And coapplicant user types the Self Employed town/city : Prague
    And coapplicant user types the Self Employed county/state : Dublin
    And coapplicant user selects the Self Employed country : Czech Republic
    And coapplicant user types the Self Employed nature of business : it's my nature
    And coapplicant user types the Self Employed start date : 01/01/2013
    And coapplicant user types the Self Employed end date : 01/01/2014
    And coapplicant user checks the Self Employed currently
    And coapplicant user types the Self Employed net profit last year : 200
    And coapplicant user types the Self Employed net profit previous year : 200
    And coapplicant user types the Self Employed accountant name / practice : accountant name test
    And coapplicant user clicks "Add This Employment"

    When coapplicant user clicks "ADD EMPLOYMENT"
    Then coapplicant user sees his name in the Employment & Income title
    And coapplicant user selects the employment & income category : Paye
    And coapplicant user selects the Civil Servant occupation : Accountant
    And coapplicant user types the Civil Servant employer's name : Test
    And coapplicant user selects the Civil Servant employment type : Permanent
    And coapplicant user types the Civil Servant start date : 01/01/2013
    And coapplicant user types the Civil Servant end date : 01/01/2014
    And coapplicant user checks the Civil Servant currently
    And coapplicant user types the Civil Servant gross salary : 200
    And coapplicant user types the Civil Servant regular overtime : 200
    And coapplicant user types the Civil Servant regular guaranteed bonus : 100
    And coapplicant user types the Civil Servant guaranteed commission : 100
    And coapplicant user clicks "Add This Employment"

    When coapplicant user clicks "ADD EMPLOYMENT"
#    Then coapplicant user selects the employment & income category : Unemployed/Homemaker
    Then coapplicant user selects the employment & income category : Unemployed
    And coapplicant user types the Unemployed/Homemaker start date : 01/01/2015
    And coapplicant user types the Unemployed/Homemaker end date : 01/10/2015
    And coapplicant user checks the Unemployed/Homemaker currently
    And coapplicant user clicks "Add This Employment"

#    When coapplicant user clicks "ADD EMPLOYMENT"
#    Then coapplicant user selects the employment & income category : Other
#    And coapplicant user types the Other source of additional income : Testing
#    And coapplicant user types the Other gross income : 200
#    And coapplicant user types the Other time earning this income : 200
#    And coapplicant user clicks "Add This Employment"
    And coapplicant user clicks "Done"

#    YOUR ACCOUNTS

    When user clicks "Account"
    Then user clicks "ADD ACCOUNT"
    And user selects Other account
    And user clicks "ADD ACCOUNT MANUALLY"
    And user selects Current Account as source of funds
    And this account is applied to both
    And user types his Current account provider: test
    And user types his Current IBAN: 1234
    And user types his Current account balance: 200
    And user types his Current overdraft limit: 200
    And user clicks "ADD THIS ACCOUNT"

    Then user clicks "ADD ACCOUNT"
    And user selects Other account
    And user clicks "ADD ACCOUNT MANUALLY"
    And user selects Savings Account as source of funds
    And this account is applied to both
    And user types his Savings account provider: test
    And user types his Savings IBAN: 1234
    And user types his Savings account balance: 200
    And user selects Gift as Source of savings
    And user types his Savings regular monthly: 200
    And user clicks "ADD THIS ACCOUNT"
#    And user verifies account data
    And user clicks Accounts "NEXT"

#    YOUR DEPENDENT

    When user clicks "Dependents"
    Then user has dependents
    And this dependent is applied to both
    And user types the Dependent date of birth: 20/10/1975
    And user clicks "ADD THIS DEPENDENT"
    And user clicks "ADD DEPENDENT"
    And this dependent is applied to borrower
    And user types the Dependent date of birth: 20/10/1975
    And user clicks "ADD THIS DEPENDENT"
    And user clicks "ADD DEPENDENT"
    And this dependent is applied to coapplicant
    And user types the Dependent date of birth: 20/10/1975
    And user clicks "ADD THIS DEPENDENT"
    And user clicks Dependents "NEXT"

#    YOUR FINANCIAL ASSETS

    When user clicks "Financial Assets"
    Then user has financial assets
    And user selects Investment Product Funds / Bonds as Financial Asset Type
    And this financial assets is applied to both
    And user types Funds/Bonds investment value: 200
    And user types Funds/Bonds institution: test
    And user types Funds/Bonds maturity date: 02/11/2016
    And user clicks "ADD THIS ASSET"
    And user clicks "ADD ASSET"
    And user selects Shares as Financial Asset Type
    And this financial assets is applied to both
    And user types Shares company: test
    And user types Shares value: 20
    And user clicks "ADD THIS ASSET"
    And user clicks "ADD ASSET"
    And user selects Share Options as Financial Asset Type
    And this financial assets is applied to both
    And user types Share Option Company: test
    And user types Share Option exercise date: 20/10/2017
    And user types Share Option value: 20
    And user clicks "ADD THIS ASSET"
    And user clicks "ADD ASSET"
    And user selects Land/Site as Financial Asset Type
    And this financial assets is applied to both
    And user types Land/Site nature: test
    And user types Land/Site location: test
    And user types Land/Site size: 20
    And user selects Land/Site units: Hectares
    And user types Land/Site estimation: 300000
    And user clicks "ADD THIS ASSET"
    And user clicks "ADD ASSET"
    And user selects Life Policy as Financial Asset Type
    And this financial assets is applied to both
    And user types Life Policy company: test
    And user types Life Policy value: 200
    And user clicks "ADD THIS ASSET"
    And user clicks "ADD ASSET"
    And user selects Other as Financial Asset Type
    And this financial assets is applied to both
    And user types Other financial asset nature: test
    And user types Other financial asset value: 300
    And user clicks "ADD THIS ASSET"
#    And user verifies financial assets data
    And user clicks Financial assets "Next"

#    FUNDING

    When user clicks "Funding"
    Then user clicks "ADD SOURCE OF FUNDS"
    And user selects Gift as source of funds
    And this funding is applied to both
    And user types Gift description: test
    And user types Gift amount: 200
    And user clicks "ADD THIS SOURCE OF FUNDS"
    And user clicks "ADD SOURCE OF FUNDS"
    And user selects Inheritance as source of funds
    And this funding is applied to both
    And user types Inheritance description: Test
    And user types Inheritance amount: 200
    And user clicks "ADD THIS SOURCE OF FUNDS"
    And user clicks "ADD SOURCE OF FUNDS"
    And user selects Other as source of funds
    And this funding is applied to both
    And user types Other Funding description: Test
    And user types Other Funding amount: 200
    And user clicks "ADD THIS SOURCE OF FUNDS"
#    And user verifies funding data
    And user clicks Funding "NEXT"

#    Financial Commitments

    When user clicks "Financial Commitments"
    Then user has financial commitments
    And user selects Personal Loan as financial commitment type
    And this commitment is applied to both
    And user types Personal Loan balance: 200
    And user types Personal Loan institution: test
    And user selects Weekly as Personal Loan repayment frequency
    And user types Personal Loan purpose: test
    And user types Personal Loan final repayment date: 29/10/2016
    And user types Personal Loan repayment amount: 200
    And user clicks "ADD THIS LIABILITY"
    And user clicks "ADD LIABILITY"
    And user selects Credit Card as financial commitment type
    And this commitment is applied to both
    And user types Credit Card repayment amount: 200
    And user types Credit Card provider: provider
    And user selects VISA as Credit Card type
    And user types Credit Card limit: 100
    And user types Credit Card balance: 200
    And user clicks "ADD THIS LIABILITY"
    And user clicks "ADD LIABILITY"
    And user selects Maintenance Payment as financial commitment type
    And this commitment is applied to both
    And user types Maintenance Monthly payment: 200
    And user clicks "ADD THIS LIABILITY"
    And user clicks "ADD LIABILITY"
    And user selects Other as financial commitment type
    And this commitment is applied to both
    And user types Other Commitment repayment amount: 200
    And user types Other Commitment value: 200
    And user types Other Commitment description: description
    And user clicks "ADD THIS LIABILITY"
    And user clicks "ADD LIABILITY"
    And user selects Car Loan as financial commitment type
    And this commitment is applied to both
    And user types Car Loan balance: 200
    And user types Car Loan institution: Institution
    And user selects Fortnightly as Car Loan repayment frequency
    And user types Car Loan final repayment date: 28/10/2016
    And user types Car Loan repayment amount: 200
    And user clicks "ADD THIS LIABILITY"
    And user clicks "ADD LIABILITY"
    And user selects Student Loan as financial commitment type
    And this commitment is applied to both
    And user types Student Loan balance: 200
    And user types Student Loan institution: institution
    And user selects Weekly as Student Loan repayment frequency
    And user types Student Loan final repayment date: 28/10/2017
    And user types Student Loan repayment amount: 200
    And user clicks "ADD THIS LIABILITY"
    And user clicks Financial Commitment "NEXT"

#    Properties

    When user clicks "Properties"
    Then user has properties
    And this property is applied to both
    And other party has an interest in this property
    And this property is a Principal Dwelling House
    And this Principal Dwelling House property's address is same as home address
    And user types the Principal Dwelling House property's address line 1: Prague, Czech Republic
    And user types the Principal Dwelling House property's address line 2: Hlavní město Praha
    And user types the Principal Dwelling House property's town city: Prague
    And user types the Principal Dwelling House property's post code: 14000
    And user selects the Principal Dwelling House property's country: Czech Republic
    And user selects the Principal Dwelling House property's type: Detached house
    And user types the Principal Dwelling House property's number of bedrooms: 3
    And user types the Principal Dwelling House property's acquired year: 2000
    And user types the Principal Dwelling House property's original purchase price: 200000
    And user selects the Principal Dwelling House property if mortgaged: No, Never Had a Mortgage
    And user chooses the Principal Dwelling House property if planned to sell: Yes
    And user types the Principal Dwelling House property's estimated value/sale agreed price: 200000
    And user clicks "ADD THIS PROPERTY"
#    Then user has properties
    And user clicks "ADD PROPERTY"
    And this property is applied to both
    And other party has an interest in this property
    And this property is a Principal Dwelling House
    And this Principal Dwelling House property's address is same as home address
    And user types the Principal Dwelling House property's address line 1: Prague, Czech Republic
    And user types the Principal Dwelling House property's address line 2: Hlavní město Praha
    And user types the Principal Dwelling House property's town city: Prague
    And user types the Principal Dwelling House property's post code: 14000
    And user selects the Principal Dwelling House property's country: Czech Republic
    And user selects the Principal Dwelling House property's type: Detached house
    And user types the Principal Dwelling House property's number of bedrooms: 3
    And user types the Principal Dwelling House property's acquired year: 2000
    And user types the Principal Dwelling House property's original purchase price: 200000
    And user selects the Principal Dwelling House property if mortgaged: No, Mortgage Repaid
    And user types the Principal Dwelling House property's repaid mortgage provider: provider
    And user types the Principal Dwelling House property's repaid mortgage year: 2000
    And user chooses the Principal Dwelling House property if planned to sell: Yes
    And user types the Principal Dwelling House property's estimated value/sale agreed price: 200000
    And user clicks "ADD THIS PROPERTY"
#    Then user has properties
    And user clicks "ADD PROPERTY"
    And this property is applied to both
    And other party has an interest in this property
    And this property is a Principal Dwelling House
    And this Principal Dwelling House property's address is same as home address
    And user types the Principal Dwelling House property's address line 1: Prague, Czech Republic
    And user types the Principal Dwelling House property's address line 2: Hlavní město Praha
    And user types the Principal Dwelling House property's town city: Prague
    And user types the Principal Dwelling House property's post code: 14000
    And user selects the Principal Dwelling House property's country: Czech Republic
    And user selects the Principal Dwelling House property's type: Detached house
    And user types the Principal Dwelling House property's number of bedrooms: 3
    And user types the Principal Dwelling House property's acquired year: 2000
    And user types the Principal Dwelling House property's original purchase price: 200000

    And user selects the Principal Dwelling House property if mortgaged: Yes
    And user types the Principal Dwelling House property's mortgage provider: provider
    And user types the Principal Dwelling House property's 1. mortgage account number: 12345678
    And user types the Principal Dwelling House property's 1. mortgage account balance: 200
    And user types the Principal Dwelling House property's 1. mortgage account monthly payment: 200
    And user types the Principal Dwelling House property's 1. mortgage account interest rate: 20
    And user checks the Principal Dwelling House property's 1. mortgage account only interest
    And user selects the Principal Dwelling House property's 1. mortgage rate type: Fixed
    And user chooses the Principal Dwelling House property's 1. mortgage last 24 month: YES
    And user clicks "ADD ANOTHER MORTGAGE ACCOUNT"
    And user types the Principal Dwelling House property's 2. mortgage account number: 12345678
    And user types the Principal Dwelling House property's 2. mortgage account balance: 200
    And user types the Principal Dwelling House property's 2. mortgage account monthly payment: 200
    And user types the Principal Dwelling House property's 2. mortgage account interest rate: 20
    And user checks the Principal Dwelling House property's 2. mortgage account only interest
    And user selects the Principal Dwelling House property's 2. mortgage rate type: Fixed
    And user chooses the Principal Dwelling House property's 2. mortgage last 24 month: YES

    And user chooses the Principal Dwelling House property if planned to sell: Yes
    And user types the Principal Dwelling House property's estimated value/sale agreed price: 200000

    And user clicks "ADD THIS PROPERTY"
    And user clicks "ADD PROPERTY"

    And this property is applied to both
    And other party has an interest in this property
    And this property is a Investment
    And user types Investment property's monthly rent: 200000
    And user selects Investment property's rent: Guaranteed
    And user types the Investment property's address line 1: Prague, Czech Republic
    And user types the Investment property's address line 2: Hlavní město Praha
    And user types the Investment property's town city: Prague
    And user types the Investment property's post code: 14000
    And user selects the Investment property's country: Czech Republic
    And user selects the Investment property's type: Detached house
    And user types the Investment property's number of bedrooms: 3
    And user types the Investment property's acquired year: 2000
    And user types the Investment property's original purchase price: 200000
    And user selects the Investment property if mortgaged: No, Never Had a Mortgage
    And user chooses the Investment property if planned to sell: Yes
    And user types the Investment property's estimated value/sale agreed price: 200000

    And user clicks "ADD THIS PROPERTY"
    And user clicks "ADD PROPERTY"

    And this property is applied to both
    And other party has an interest in this property
    And this property is a Holiday Home
    And user types Holiday Home property's monthly rent: 200000
    And user selects Holiday Home property's rent: Guaranteed
    And user types the Holiday Home property's address line 1: Prague, Czech Republic
    And user types the Holiday Home property's address line 2: Hlavní město Praha
    And user types the Holiday Home property's town city: Prague
    And user types the Holiday Home property's post code: 14000
    And user selects the Holiday Home property's country: Czech Republic
    And user selects the Holiday Home property's type: Detached house
    And user types the Holiday Home property's number of bedrooms: 3
    And user types the Holiday Home property's acquired year: 2000
    And user types the Holiday Home property's original purchase price: 200000
    And user selects the Holiday Home property if mortgaged: No, Never Had a Mortgage
    And user chooses the Holiday Home property if planned to sell: Yes
    And user types the Holiday Home property's estimated value/sale agreed price: 200000
    And user clicks "ADD THIS PROPERTY"

    And user clicks PROPERTY "NEXT"

    And user clicks "Document Upload"

    And Borrower user uploads the file file.txt as Proof of identity document
    And Borrower user uploads the file file.txt as Proof of address document
    And Borrower user uploads the file file.txt as Marriage certificate document
    And Coapplicant user uploads the file file.txt as Proof of identity document
    And Coapplicant user uploads the file file.txt as Proof of address document
    And Coapplicant user uploads the file file.txt as Marriage certificate document
    And Borrower user uploads the file file.txt as P60 document
    And Borrower user uploads the file file.txt as Certified account (Last year) document
    And Borrower user uploads the file file.txt as Certified account (Previous before last year) document
    And Borrower user uploads the file file.txt as Confirmation of tax affairs document
    And Borrower user uploads the file file.txt as Current payslip document
    And Borrower user uploads the file file.txt as Previous payslip document
    And Borrower user uploads the file file.txt as Salary certificate document
    And Borrower user uploads the file file.txt as P60 document
    And Coapplicant user uploads the file file.txt as Certified account (Last year) document
    And Coapplicant user uploads the file file.txt as Certified account (Previous before last year) document
    And Coapplicant user uploads the file file.txt as Confirmation of tax affairs document
    And Coapplicant user uploads the file file.txt as P60 document
    And Coapplicant user uploads the file file.txt as Current payslip document
    And Coapplicant user uploads the file file.txt as Previous payslip document
    And Coapplicant user uploads the file file.txt as Salary certificate document
    And Borrower and Coapplicant user uploads the file file.txt as Current account - 1234 document
    And Borrower and Coapplicant user uploads the file file.txt as Credit card - provider document
    And Upload all documents

    And user is on Apollo homepage
    When user searches the created client on simple search
    And user chooses 1st client
    And user chooses 2nd client
    Then user checks client's data
