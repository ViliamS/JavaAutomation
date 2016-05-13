package com.r2development.leveris.utils.Enums;

import java.util.Collections;
import java.util.LinkedList;

public enum UNDERWRITINGSTATUS {

    NOT_SET("Not Set"),
    ACCEPTED("Accepted"),
    REJECTED("Rejected");

    private String uwStatus;

    UNDERWRITINGSTATUS(String uwStatus) {
        this.uwStatus = uwStatus;
    }

    public String getUWStatus() {
        return uwStatus;
    }

    private static String transformationOfStringToEnumName(String text) {
        return text.toUpperCase().replace(" ", "_");
    }

    public static UNDERWRITINGSTATUS getUWStatus(String uwStatus) {
        return UNDERWRITINGSTATUS.valueOf(UNDERWRITINGSTATUS.transformationOfStringToEnumName(uwStatus));
    }

    public static LinkedList<UNDERWRITINGSTATUS> getEnumValues() {
        LinkedList<UNDERWRITINGSTATUS> enumValuesList = new LinkedList<>();
        Collections.addAll(enumValuesList, UNDERWRITINGSTATUS.values());
        return enumValuesList;
    }


}
