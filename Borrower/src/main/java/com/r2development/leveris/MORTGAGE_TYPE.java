package com.r2development.leveris;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;

public enum MORTGAGE_TYPE {

    SINGLE ("a single borrower"),
    DOUBLE ("two borrowers");

    private final String mortgageType;

//    @Inject
    MORTGAGE_TYPE(final String mortgageType) {
        this.mortgageType  = mortgageType;
    }

    @Override
    public String toString() {
        return mortgageType;
    }

    public static MORTGAGE_TYPE getMortgageType(String mortgageType) {
        String val = StringUtils.trimToEmpty(mortgageType).toUpperCase();
        Optional<MORTGAGE_TYPE> possible = Enums.getIfPresent(MORTGAGE_TYPE.class, val);
        if (!possible.isPresent()) {
            throw new IllegalArgumentException(val + "? There is no such Environment!");
        }
        return possible.get();
    }
}
