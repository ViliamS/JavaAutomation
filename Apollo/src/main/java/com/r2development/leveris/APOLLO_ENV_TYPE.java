package com.r2development.leveris;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum APOLLO_ENV_TYPE {

    TEST ( "Test" ),
    DEV ( "Dev" ),
    STABLE ( "Stable");

    private static final Log log = LogFactory.getLog(APOLLO_ENV_TYPE.class);

    private final String envAlias;

    APOLLO_ENV_TYPE(String envAlias) {
        this.envAlias = envAlias;
    }

    private String envAlias() {
        return envAlias;
    }

    public static APOLLO_ENV_TYPE getEnv(String envAlias) {
        String val = StringUtils.trimToEmpty(envAlias).toUpperCase();
        Optional<APOLLO_ENV_TYPE> possible = Enums.getIfPresent(APOLLO_ENV_TYPE.class, val);
        if (!possible.isPresent()) {
            throw new IllegalArgumentException(val + "? There is no such Environment!");
        }
        return possible.get();
    }
}
