package com.r2development.leveris;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum BORROWER_ENV_TYPE {

    TUNNING ( "Tunning" ),
    DEV1 ( "Dev1" ),
    APPTEST ( "AppTest" ),
    APPINT ( "AppInt" ),
    IT1 ( "IT1" ),
    AMAZONCLOUD ( "AmazonCloud" ),
    ST1 ( "St1App" );

    private static final Log log = LogFactory.getLog(BROWSER_TYPE.class);

    private final String envAlias;

    BORROWER_ENV_TYPE(String envAlias) {
        this.envAlias = envAlias;
    }

    private String envAlias() {
        return envAlias;
    }

    public static BORROWER_ENV_TYPE getEnv(String envAlias) {
        String val = StringUtils.trimToEmpty(envAlias).toUpperCase();
        Optional<BORROWER_ENV_TYPE> possible = Enums.getIfPresent(BORROWER_ENV_TYPE.class, val);
        if (!possible.isPresent()) {
            throw new IllegalArgumentException(val + "? There is no such Environment!");
        }
        return possible.get();
    }
}