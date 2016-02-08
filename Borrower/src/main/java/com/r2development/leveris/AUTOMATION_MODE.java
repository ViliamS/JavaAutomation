package com.r2development.leveris;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum AUTOMATION_MODE {

    PROD ( "Production" ),
    DEV ( "Development" );

    private static final Log log = LogFactory.getLog(AUTOMATION_MODE.class);

    private final String automationModeAlias;

    AUTOMATION_MODE(String automationModeAlias) {
        this.automationModeAlias = automationModeAlias;
    }

    private String automationModeAlias() {
        return automationModeAlias;
    }

    public static AUTOMATION_MODE getAutomationMode(String automationModeAlias) {
        String val = StringUtils.trimToEmpty(automationModeAlias).toUpperCase();
        Optional<AUTOMATION_MODE> possible = Enums.getIfPresent(AUTOMATION_MODE.class, val);
        if (!possible.isPresent()) {
            throw new IllegalArgumentException(val + "? There is no such Environment!");
        }
        return possible.get();
    }
}