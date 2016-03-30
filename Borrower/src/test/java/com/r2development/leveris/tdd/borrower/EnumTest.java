package com.r2development.leveris.tdd.borrower;

import com.r2development.leveris.enums.E_MARITAL_STATUS;

public class EnumTest {

    E_MARITAL_STATUS maritalStatus;

    public EnumTest(E_MARITAL_STATUS maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void tellMe() {
        switch (maritalStatus) {
            case SINGLE:
                System.out.println("Borrrring guy !!!");
                System.out.println(maritalStatus.getShortValue());
                break;
            case SEPARATED:
                System.out.println("Due to what ?!");
                break;
            case MARRIED_CIVIL_PARTNER:
                System.out.println("Are they really happy together ?!");
                break;
            case DIVORCED_DISSOLVED_CIVIL_PARTNERSHIP:
                System.out.println("Who is the happiest ?");
                break;
            case WIDOWED:
                System.out.println("Seriously, (s)he killed her(him)");
                break;
        }
    }

    public static void main(String... args) {
        EnumTest single = new EnumTest(E_MARITAL_STATUS.SINGLE);
        single.tellMe();
        EnumTest separated = new EnumTest(E_MARITAL_STATUS.SEPARATED);
        separated.tellMe();
        EnumTest married = new EnumTest(E_MARITAL_STATUS.MARRIED_CIVIL_PARTNER);
        married.tellMe();
        EnumTest divorced = new EnumTest(E_MARITAL_STATUS.DIVORCED_DISSOLVED_CIVIL_PARTNERSHIP);
        divorced.tellMe();
        EnumTest widowed = new EnumTest(E_MARITAL_STATUS.WIDOWED);
        widowed.tellMe();
    }
}
