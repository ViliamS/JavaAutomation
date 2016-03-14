@BorrowerLowLevel
Feature: Verification Quote Creation Process

  Background:
    Given Borrower goes to Registration page

#  Scenario: Quote Creation High Level
#    Given Borrower creates an account
#    When Borrower logs in as his account is activated
#    Then Borrower processes "Get a Quote"
#    And Borrower processes "Invite a co-applicant"
##    And Borrower processes "Forms"
#    And Borrower fills in "Borrower's personal details"
#    And Borrower fills in "Coapplicant's personal details"

  Scenario: Quote Creation Low Level
    Given Borrower creates an account
    When Borrower logs in as his account is activated
    Then Borrower processes "Get a Quote"
    And Borrower processes "Invite a co-applicant"
    And Borrower processes "Forms"

#    PERSONAL DETAILS

    When Borrower clicks "Borrower Personal Details"
    Then borrower Borrower sees his name in the Personal Details title
    And borrower Borrower types his firstname : Tony
    And borrower Borrower types his lastname : Mottot
    And borrower Borrower checks his gender : Male
    And borrower Borrower types his date of birth : 20/10/1978
    And borrower Borrower selects his marital status : married/civil partner(s)
    And borrower Borrower selects his nationality : French
    And borrower Borrower types the number of resident years : 3
#    And borrower Borrower checks if he is requiring a visa
    And borrower Borrower types his residency address in line 1 : Prague, Czech Republic
    And borrower Borrower types his residency address in line 2 : Hlavní město Praha
    And borrower Borrower types his residency town/city : Prague
#    And borrower Borrower selects his residency County/State : ???
    And borrower Borrower types his postcode/zip : 14000
    And borrower Borrower selects his residency country : Czech Republic
    And borrower Borrower selects his residency accommodation : Rented on contract
    And borrower Borrower types his residency rent : 200
    And borrower Borrower checks if he is not living since 3 years
    And borrower Borrower types his previous residency address in line 1 : Dijon, France
    And borrower Borrower types his previous residency address in line 2 : Burgundy
    And borrower Borrower types his previous residency town/city : Dijon
#    And borrower Borrower selects his previous residency county/state :
    And borrower Borrower types his previous residency postcode/zip : 21000
    And borrower Borrower types his previous residency country : France
    And borrower Borrower saves his personal details data
    When Borrower clicks "Coapplicant Personal Details"
    Then coapplicant Borrower sees his name in the Personal Details title
    And coapplicant Borrower types his firstname : Anthony Mottot co-applicant
    And coapplicant Borrower types his lastname : Mottot
    And coapplicant Borrower checks his gender : Male
    And coapplicant Borrower types his date of birth : 20/10/1978
    And coapplicant Borrower selects his marital status : married/civil partner(s)
    And coapplicant Borrower selects his nationality : French
    And coapplicant Borrower types the number of resident years : 3
#    And coapplicant Borrower checks if he is requiring a visa
    And coapplicant Borrower types his residency address in line 1 : Prague, Czech Republic
    And coapplicant Borrower types his residency address in line 2 : Hlavní město Praha
    And coapplicant Borrower types his residency town/city : Prague
#    And coapplicant Borrower selects his residency County/State : ???
    And coapplicant Borrower types his postcode/zip : 14000
    And coapplicant Borrower selects his residency country : Czech Republic
    And coapplicant Borrower selects his residency accommodation : Rented on contract
    And coapplicant Borrower types his residency rent : 200
    And coapplicant Borrower checks if he is not living since 3 years
    And coapplicant Borrower types his previous residency address in line 1 : Dijon, France
    And coapplicant Borrower types his previous residency address in line 2 : Burgundy
    And coapplicant Borrower types his previous residency town/city : Dijon
#    And coapplicant Borrower selects his previous residency county/state :
    And coapplicant Borrower types his previous residency postcode/zip : 21000
    And coapplicant Borrower types his previous residency country : France
    And coapplicant Borrower saves his personal details data

#    EMPLOYMENT & INCOME

    When Borrower clicks "Borrower Employment Income"
    Then borrower Borrower sees his name in the Employment & Income title
    And borrower Borrower clicks the employment & income category : Paye
    # problem of xpath or select method
    And borrower Borrower selects the Paye occupation : Accountant
    And borrower Borrower types the Paye employer's name : Test
    And borrower Borrower selects the Paye employment type : Contract
    And borrower Borrower types the Paye start date : 01/01/2013
    And borrower Borrower types the Paye end date : 01/01/2014
    # to check if displayed or not !! disappear when end date is filled ?
#    And borrower Borrower checks the Paye currently
    And borrower Borrower types the Paye gross salary : 200
    And borrower Borrower types the Paye regular overtime : 200
    And borrower Borrower types the Paye regular guaranteed bonus : 100
    And borrower Borrower types the Paye guaranteed commission : 100
    And borrower Borrower clicks "Add This Employment"

    When borrower Borrower clicks "ADD EMPLOYMENT"
    Then borrower Borrower clicks the employment & income category : SelfEmployed
    And borrower Borrower selects the Self Employed occupation : Accountant
    And borrower Borrower types the Self Employed business name : Business name Self Employed
    And borrower Borrower types the Self Employed address line 1 : Prague
    And borrower Borrower types the Self Employed address line 2 : address line 2
    And borrower Borrower types the Self Employed town/city : Prague
    And borrower Borrower types the Self Employed county/state : Dublin
    And borrower Borrower selects the Self Employed country : Czech Republic
    And borrower Borrower types the Self Employed nature of business : it's my nature
    And borrower Borrower types the Self Employed start date : 01/01/2013
    And borrower Borrower types the Self Employed end date : 01/01/2014
    And borrower Borrower checks the Self Employed currently
    And borrower Borrower types the Self Employed net profit last year : 200
    And borrower Borrower types the Self Employed net profit previous year : 200
    And borrower Borrower types the Self Employed accountant name / practice : accountant name test
    And borrower Borrower clicks "Add This Employment"

    When borrower Borrower clicks "ADD EMPLOYMENT"
#    Then borrower Borrower sees his name in the Employment & Income title
    And borrower Borrower clicks the employment & income category : CivilServant
    And borrower Borrower selects the Civil Servant occupation : Accountant
    And borrower Borrower types the Civil Servant employer's name : Test
    And borrower Borrower selects the Civil Servant employment type : Permanent
    And borrower Borrower types the Civil Servant start date : 01/01/2013
    And borrower Borrower types the Civil Servant end date : 01/01/2014
    And borrower Borrower checks the Civil Servant currently
    And borrower Borrower types the Civil Servant gross salary : 200
    And borrower Borrower types the Civil Servant regular overtime : 200
    And borrower Borrower types the Civil Servant regular guaranteed bonus : 100
    And borrower Borrower types the Civil Servant guaranteed commission : 100
    And borrower Borrower clicks "Add This Employment"

    When borrower Borrower clicks "ADD EMPLOYMENT"
    Then borrower Borrower clicks the employment & income category : Unemployed/Homemaker
    And borrower Borrower types the Unemployed/Homemaker start date : 01/01/2015
    And borrower Borrower types the Unemployed/Homemaker end date : 01/10/2015
    And borrower Borrower checks the Unemployed/Homemaker currently
    And borrower Borrower clicks "Add This Employment"

    When borrower Borrower clicks "ADD EMPLOYMENT"
    Then borrower Borrower clicks the employment & income category : Other
    And borrower Borrower types the Other source of additional income : Testing
    And borrower Borrower types the Other gross income : 200
    And borrower Borrower types the Other time earning this income : 200
    And borrower Borrower clicks "Add This Employment"
    And borrower Borrower clicks "Done"

    When Borrower clicks "Coapplicant Employment Income"
    Then coapplicant Borrower sees his name in the Employment & Income title
    And coapplicant Borrower clicks the employment & income category : Paye
    # problem of xpath or select method
    And coapplicant Borrower selects the Paye occupation : Accountant
    And coapplicant Borrower types the Paye employer's name : Test
    And coapplicant Borrower selects the Paye employment type : Contract
    And coapplicant Borrower types the Paye start date : 01/01/2013
    And coapplicant Borrower types the Paye end date : 01/01/2014
    # to check if displayed or not !! disappear when end date is field ?
#    And coapplicant Borrower checks the Paye currently
    And coapplicant Borrower types the Paye gross salary : 200
    And coapplicant Borrower types the Paye regular overtime : 200
    And coapplicant Borrower types the Paye regular guaranteed bonus : 100
    And coapplicant Borrower types the Paye guaranteed commission : 100
    And coapplicant Borrower clicks "Add This Employment"

    When coapplicant Borrower clicks "ADD EMPLOYMENT"
    Then coapplicant Borrower clicks the employment & income category : SelfEmployed
    And coapplicant Borrower selects the Self Employed occupation : Accountant
    And coapplicant Borrower types the Self Employed business name : Business name Self Employed
    And coapplicant Borrower types the Self Employed address line 1 : Prague
    And coapplicant Borrower types the Self Employed address line 2 : address line 2
    And coapplicant Borrower types the Self Employed town/city : Prague
    And coapplicant Borrower types the Self Employed county/state : Dublin
    And coapplicant Borrower selects the Self Employed country : Czech Republic
    And coapplicant Borrower types the Self Employed nature of business : it's my nature
    And coapplicant Borrower types the Self Employed start date : 01/01/2013
    And coapplicant Borrower types the Self Employed end date : 01/01/2014
    And coapplicant Borrower checks the Self Employed currently
    And coapplicant Borrower types the Self Employed net profit last year : 200
    And coapplicant Borrower types the Self Employed net profit previous year : 200
    And coapplicant Borrower types the Self Employed accountant name / practice : accountant name test
    And coapplicant Borrower clicks "Add This Employment"

    When coapplicant Borrower clicks "ADD EMPLOYMENT"
#    Then coapplicant Borrower sees his name in the Employment & Income title
    And coapplicant Borrower clicks the employment & income category : Paye
    And coapplicant Borrower selects the Civil Servant occupation : Accountant
    And coapplicant Borrower types the Civil Servant employer's name : Test
    And coapplicant Borrower selects the Civil Servant employment type : Permanent
    And coapplicant Borrower types the Civil Servant start date : 01/01/2013
    And coapplicant Borrower types the Civil Servant end date : 01/01/2014
    And coapplicant Borrower checks the Civil Servant currently
    And coapplicant Borrower types the Civil Servant gross salary : 200
    And coapplicant Borrower types the Civil Servant regular overtime : 200
    And coapplicant Borrower types the Civil Servant regular guaranteed bonus : 100
    And coapplicant Borrower types the Civil Servant guaranteed commission : 100
    And coapplicant Borrower clicks "Add This Employment"

    When coapplicant Borrower clicks "ADD EMPLOYMENT"
    Then coapplicant Borrower clicks the employment & income category : Unemployed/Homemaker
    And coapplicant Borrower types the Unemployed/Homemaker start date : 01/01/2015
    And coapplicant Borrower types the Unemployed/Homemaker end date : 01/10/2015
    And coapplicant Borrower checks the Unemployed/Homemaker currently
    And coapplicant Borrower clicks "Add This Employment"

    When coapplicant Borrower clicks "ADD EMPLOYMENT"
    Then coapplicant Borrower clicks the employment & income category : Other
    And coapplicant Borrower types the Other source of additional income : Testing
    And coapplicant Borrower types the Other gross income : 200
    And coapplicant Borrower types the Other time earning this income : 200
    And coapplicant Borrower clicks "Add This Employment"
    And coapplicant Borrower clicks "Done"

#    YOUR ACCOUNTS

#    When Borrower clicks "Account"
    Then Borrower clicks "ADD ACCOUNT"
    And Borrower selects Other account
    And Borrower clicks "ADD ACCOUNT MANUALLY"
    And Borrower selects Current Account as source of funds
    And this account is applied to both
    And Borrower types his Current account provider: test
    And Borrower types his Current IBAN: IE92BOFI90001710027952
    And Borrower types his Current account balance: 200
    And Borrower types his Current overdraft limit: 200
    And Borrower clicks "ADD THIS ACCOUNT"

    Then Borrower clicks "ADD ACCOUNT"
    And Borrower selects Other account
    And Borrower clicks "ADD ACCOUNT MANUALLY"
    And Borrower selects Savings Account as source of funds
    And this account is applied to both
    And Borrower types his Savings account provider: test
    And Borrower types his Savings IBAN: CZ4855000000001021018730
    And Borrower types his Savings account balance: 200
    And Borrower selects Gift as Source of savings
    And Borrower types his Savings regular monthly: 200
    And Borrower clicks "ADD THIS ACCOUNT"
#    And Borrower verifies account data
    And Borrower clicks Accounts "NEXT"

#    YOUR DEPENDANT

    When Borrower clicks "Dependants"
    Then Borrower has dependants
    And this dependant is applied to both
    And Borrower types the dependant date of birth: 20/10/1975
    And Borrower clicks "ADD THIS DEPENDANT"
    And Borrower clicks "ADD DEPENDANT"
    And this dependant is applied to borrower
    And Borrower types the dependant date of birth: 20/10/1975
    And Borrower clicks "ADD THIS DEPENDANT"
    And Borrower clicks "ADD DEPENDANT"
    And this dependant is applied to coapplicant
    And Borrower types the Dependant date of birth: 20/10/1975
    And Borrower clicks "ADD THIS DEPENDANT"
    And Borrower clicks Dependants "NEXT"

#    YOUR FINANCIAL ASSETS

    When Borrower clicks "Financial Assets"
    Then Borrower has financial assets
    And Borrower selects Investment Product Funds / Bonds as Financial Asset Type
    And this financial assets is applied to both
    And Borrower types Funds/Bonds investment value: 200
    And Borrower types Funds/Bonds institution: test
    And Borrower types Funds/Bonds maturity date: 02/11/2016
    And Borrower clicks "ADD THIS ASSET"
    And Borrower clicks "ADD ASSET"
    And Borrower selects Shares as Financial Asset Type
    And this financial assets is applied to both
    And Borrower types Shares company: test
    And Borrower types Shares value: 20
    And Borrower clicks "ADD THIS ASSET"
    And Borrower clicks "ADD ASSET"
    And Borrower selects Share Options as Financial Asset Type
    And this financial assets is applied to both
    And Borrower types Share Option Company: test
    And Borrower types Share Option exercise date: 20/10/2017
    And Borrower types Share Option value: 20
    And Borrower clicks "ADD THIS ASSET"
    And Borrower clicks "ADD ASSET"
    And Borrower selects Land/Site as Financial Asset Type
    And this financial assets is applied to both
    And Borrower types Land/Site nature: test
    And Borrower types Land/Site location: test
    And Borrower types Land/Site size: 20
    And Borrower selects Land/Site units: Hectares
    And Borrower types Land/Site estimation: 300000
    And Borrower clicks "ADD THIS ASSET"
    And Borrower clicks "ADD ASSET"
    And Borrower selects Life Policy as Financial Asset Type
    And this financial assets is applied to both
    And Borrower types Life Policy company: test
    And Borrower types Life Policy value: 200
    And Borrower clicks "ADD THIS ASSET"
    And Borrower clicks "ADD ASSET"
    And Borrower selects Other as Financial Asset Type
    And this financial assets is applied to both
    And Borrower types Other financial asset nature: test
    And Borrower types Other financial asset value: 300
    And Borrower clicks "ADD THIS ASSET"
#    And Borrower verifies financial assets data
    And Borrower clicks Financial assets "Next"

#    FUNDING

    When Borrower clicks "Funding"
    Then Borrower clicks "ADD SOURCE OF FUNDS"
    And Borrower selects Gift as source of funds
    And this funding is applied to both
    And Borrower types Gift description: test
    And Borrower types Gift amount: 200
    And Borrower clicks "ADD THIS SOURCE OF FUNDS"
    And Borrower clicks "ADD SOURCE OF FUNDS"
    And Borrower selects Inheritance as source of funds
    And this funding is applied to both
    And Borrower types Inheritance description: Test
    And Borrower types Inheritance amount: 200
    And Borrower clicks "ADD THIS SOURCE OF FUNDS"
    And Borrower clicks "ADD SOURCE OF FUNDS"
    And Borrower selects Other as source of funds
    And this funding is applied to both
    And Borrower types Other Funding description: Test
    And Borrower types Other Funding amount: 200
    And Borrower clicks "ADD THIS SOURCE OF FUNDS"
#    And Borrower verifies funding data
    And Borrower clicks Funding "NEXT"

#    Financial Commitments

    When Borrower clicks "Financial Commitments"
    Then Borrower has financial commitments
    And Borrower selects Personal Loan as financial commitment type
    And this commitment is applied to both
    And Borrower types Personal Loan balance: 200
    And Borrower types Personal Loan institution: test
    And Borrower selects Weekly as Personal Loan repayment frequency
    And Borrower types Personal Loan purpose: test
    And Borrower types Personal Loan final repayment date: 29/10/2016
    And Borrower types Personal Loan repayment amount: 200
    And Borrower clicks "ADD THIS LIABILITY"
    And Borrower clicks "ADD LIABILITY"
    And Borrower selects Credit Card as financial commitment type
    And this commitment is applied to both
    And Borrower types Credit Card repayment amount: 200
    And Borrower types Credit Card provider: provider
    And Borrower selects VISA as Credit Card type
    And Borrower types Credit Card limit: 100
    And Borrower types Credit Card balance: 200
    And Borrower clicks "ADD THIS LIABILITY"
    And Borrower clicks "ADD LIABILITY"
    And Borrower selects Maintenance Payment as financial commitment type
    And this commitment is applied to both
    And Borrower types Maintenance Monthly payment: 200
    And Borrower clicks "ADD THIS LIABILITY"
    And Borrower clicks "ADD LIABILITY"
    And Borrower selects Other as financial commitment type
    And this commitment is applied to both
    And Borrower types Other Commitment repayment amount: 200
    And Borrower types Other Commitment value: 200
    And Borrower types Other Commitment description: description
    And Borrower clicks "ADD THIS LIABILITY"
    And Borrower clicks "ADD LIABILITY"
    And Borrower selects Car Loan as financial commitment type
    And this commitment is applied to both
    And Borrower types Car Loan balance: 200
    And Borrower types Car Loan institution: Institution
    And Borrower selects Fortnightly as Car Loan repayment frequency
    And Borrower types Car Loan final repayment date: 28/10/2016
    And Borrower types Car Loan repayment amount: 200
    And Borrower clicks "ADD THIS LIABILITY"
    And Borrower clicks "ADD LIABILITY"
    And Borrower selects Student Loan as financial commitment type
    And this commitment is applied to both
    And Borrower types Student Loan balance: 200
    And Borrower types Student Loan institution: institution
    And Borrower selects Weekly as Student Loan repayment frequency
    And Borrower types Student Loan final repayment date: 28/10/2017
    And Borrower types Student Loan repayment amount: 200
    And Borrower clicks "ADD THIS LIABILITY"
    And Borrower clicks Financial Commitment "NEXT"

#    Properties

    When Borrower clicks "Properties"
    Then Borrower has properties
    And this property is applied to both
    And other party has an interest in this property
    And this property is a Principal Dwelling House
    And this Principal Dwelling House property's address is same as home address
    And Borrower types the Principal Dwelling House property's address line 1: Prague, Czech Republic
    And Borrower types the Principal Dwelling House property's address line 2: Hlavní město Praha
    And Borrower types the Principal Dwelling House property's town city: Prague
    And Borrower types the Principal Dwelling House property's post code: 14000
    And Borrower selects the Principal Dwelling House property's country: Czech Republic
    And Borrower selects the Principal Dwelling House property's type: Detached house
    And Borrower types the Principal Dwelling House property's number of bedrooms: 3
    And Borrower types the Principal Dwelling House property's acquired year: 2000
    And Borrower types the Principal Dwelling House property's original purchase price: 200000
    And Borrower selects the Principal Dwelling House property if mortgaged: No, Never Had a Mortgage
    And Borrower chooses the Principal Dwelling House property if planned to sell: Yes
    And Borrower types the Principal Dwelling House property's estimated value/sale agreed price: 200000
    And Borrower clicks "ADD THIS PROPERTY"
#    Then Borrower has properties
    And Borrower clicks "ADD PROPERTY"
    And this property is applied to both
    And other party has an interest in this property
    And this property is a Principal Dwelling House
    And this Principal Dwelling House property's address is same as home address
    And Borrower types the Principal Dwelling House property's address line 1: Prague, Czech Republic
    And Borrower types the Principal Dwelling House property's address line 2: Hlavní město Praha
    And Borrower types the Principal Dwelling House property's town city: Prague
    And Borrower types the Principal Dwelling House property's post code: 14000
    And Borrower selects the Principal Dwelling House property's country: Czech Republic
    And Borrower selects the Principal Dwelling House property's type: Detached house
    And Borrower types the Principal Dwelling House property's number of bedrooms: 3
    And Borrower types the Principal Dwelling House property's acquired year: 2000
    And Borrower types the Principal Dwelling House property's original purchase price: 200000
    And Borrower selects the Principal Dwelling House property if mortgaged: No, Mortgage Repaid
    And Borrower types the Principal Dwelling House property's repaid mortgage provider: provider
    And Borrower types the Principal Dwelling House property's repaid mortgage year: 2000
    And Borrower chooses the Principal Dwelling House property if planned to sell: Yes
    And Borrower types the Principal Dwelling House property's estimated value/sale agreed price: 200000
    And Borrower clicks "ADD THIS PROPERTY"
#    Then Borrower has properties
    And Borrower clicks "ADD PROPERTY"
    And this property is applied to both
    And other party has an interest in this property
    And this property is a Principal Dwelling House
    And this Principal Dwelling House property's address is same as home address
    And Borrower types the Principal Dwelling House property's address line 1: Prague, Czech Republic
    And Borrower types the Principal Dwelling House property's address line 2: Hlavní město Praha
    And Borrower types the Principal Dwelling House property's town city: Prague
    And Borrower types the Principal Dwelling House property's post code: 14000
    And Borrower selects the Principal Dwelling House property's country: Czech Republic
    And Borrower selects the Principal Dwelling House property's type: Detached house
    And Borrower types the Principal Dwelling House property's number of bedrooms: 3
    And Borrower types the Principal Dwelling House property's acquired year: 2000
    And Borrower types the Principal Dwelling House property's original purchase price: 200000

    And Borrower selects the Principal Dwelling House property if mortgaged: Yes
    And Borrower types the Principal Dwelling House property's mortgage provider: provider
    And Borrower types the Principal Dwelling House property's 1. mortgage account number: 12345678
    And Borrower types the Principal Dwelling House property's 1. mortgage account balance: 200
    And Borrower types the Principal Dwelling House property's 1. mortgage account monthly payment: 200
    And Borrower types the Principal Dwelling House property's 1. mortgage account interest rate: 20
    And Borrower checks the Principal Dwelling House property's 1. mortgage account only interest
    And Borrower selects the Principal Dwelling House property's 1. mortgage rate type: Fixed
    And Borrower chooses the Principal Dwelling House property's 1. mortgage last 24 month: YES
    And Borrower clicks "ADD ANOTHER MORTGAGE ACCOUNT"
    And Borrower types the Principal Dwelling House property's 2. mortgage account number: 12345678
    And Borrower types the Principal Dwelling House property's 2. mortgage account balance: 200
    And Borrower types the Principal Dwelling House property's 2. mortgage account monthly payment: 200
    And Borrower types the Principal Dwelling House property's 2. mortgage account interest rate: 20
    And Borrower checks the Principal Dwelling House property's 2. mortgage account only interest
    And Borrower selects the Principal Dwelling House property's 2. mortgage rate type: Fixed
    And Borrower chooses the Principal Dwelling House property's 2. mortgage last 24 month: YES

    And Borrower chooses the Principal Dwelling House property if planned to sell: Yes
    And Borrower types the Principal Dwelling House property's estimated value/sale agreed price: 200000

    And Borrower clicks "ADD THIS PROPERTY"
    And Borrower clicks "ADD PROPERTY"

    And this property is applied to both
    And other party has an interest in this property
    And this property is a Investment
    And Borrower types Investment property's monthly rent: 200000
    And Borrower selects Investment property's rent: Guaranteed
    And Borrower types the Investment property's address line 1: Prague, Czech Republic
    And Borrower types the Investment property's address line 2: Hlavní město Praha
    And Borrower types the Investment property's town city: Prague
    And Borrower types the Investment property's post code: 14000
    And Borrower selects the Investment property's country: Czech Republic
    And Borrower selects the Investment property's type: Detached house
    And Borrower types the Investment property's number of bedrooms: 3
    And Borrower types the Investment property's acquired year: 2000
    And Borrower types the Investment property's original purchase price: 200000
    And Borrower selects the Investment property if mortgaged: No, Never Had a Mortgage
    And Borrower chooses the Investment property if planned to sell: Yes
    And Borrower types the Investment property's estimated value/sale agreed price: 200000

    And Borrower clicks "ADD THIS PROPERTY"
    And Borrower clicks "ADD PROPERTY"

    And this property is applied to both
    And other party has an interest in this property
    And this property is a Holiday Home
    And Borrower types Holiday Home property's monthly rent: 200000
    And Borrower selects Holiday Home property's rent: Guaranteed
    And Borrower types the Holiday Home property's address line 1: Prague, Czech Republic
    And Borrower types the Holiday Home property's address line 2: Hlavní město Praha
    And Borrower types the Holiday Home property's town city: Prague
    And Borrower types the Holiday Home property's post code: 14000
    And Borrower selects the Holiday Home property's country: Czech Republic
    And Borrower selects the Holiday Home property's type: Detached house
    And Borrower types the Holiday Home property's number of bedrooms: 3
    And Borrower types the Holiday Home property's acquired year: 2000
    And Borrower types the Holiday Home property's original purchase price: 200000
    And Borrower selects the Holiday Home property if mortgaged: No, Never Had a Mortgage
    And Borrower chooses the Holiday Home property if planned to sell: Yes
    And Borrower types the Holiday Home property's estimated value/sale agreed price: 200000
    And Borrower clicks "ADD THIS PROPERTY"

    And Borrower clicks PROPERTY "NEXT"

    And Borrower clicks "Document Upload"

#    And Borrower Borrower uploads the file file.txt as Proof of identity document
#    And Borrower Borrower uploads the file file.txt as Proof of address document
#    And Borrower Borrower uploads the file file.txt as Marriage certificate document
#    And Coapplicant Borrower uploads the file file.txt as Proof of identity document
#    And Coapplicant Borrower uploads the file file.txt as Proof of address document
#    And Coapplicant Borrower uploads the file file.txt as Marriage certificate document
#    And Borrower Borrower uploads the file file.txt as P60 document
#    And Borrower Borrower uploads the file file.txt as Certified account (Last year) document
#    And Borrower Borrower uploads the file file.txt as Certified account (Previous before last year) document
#    And Borrower Borrower uploads the file file.txt as Confirmation of tax affairs document
#    And Borrower Borrower uploads the file file.txt as Current payslip document
#    And Borrower Borrower uploads the file file.txt as Previous payslip document
#    And Borrower Borrower uploads the file file.txt as Salary certificate document
#    And Borrower Borrower uploads the file file.txt as P60 document
#    And Coapplicant Borrower uploads the file file.txt as Certified account (Last year) document
#    And Coapplicant Borrower uploads the file file.txt as Certified account (Previous before last year) document
#    And Coapplicant Borrower uploads the file file.txt as Confirmation of tax affairs document
#    And Coapplicant Borrower uploads the file file.txt as P60 document
#    And Coapplicant Borrower uploads the file file.txt as Current payslip document
#    And Coapplicant Borrower uploads the file file.txt as Previous payslip document
#    And Coapplicant Borrower uploads the file file.txt as Salary certificate document
#    And Borrower and Coapplicant Borrower uploads the file file.txt as Current account - 1234 document
#    And Borrower and Coapplicant Borrower uploads the file file.txt as Credit card - provider document
    And Upload all documents

#    FINAL STAGE 1
#    And borrower finalizes the Borrower Phase
    And Borrower clicks "Review and Submit"
    And Borrower clicks "Submit your application"
    And Borrower checks "Distance Marketing"
    And Borrower checks "Statutory"
    And Borrower checks "Declaration"
    And finally, Borrower clicks "Submit Application"


