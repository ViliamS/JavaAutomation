package com.r2development.leveris;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum APP_TYPE {

    BORROWER ( "Borrower" ),
    UNDERWRITER ( "Underwriter" ),
    SOLICITOR ( "Partner" ),
    VALUER ( "Valuer" ),
    CRM ( "CRM" ),
    GMAIL ( "GMail" ),
    DB ( "Database" );

    private static final Log log = LogFactory.getLog(APP_TYPE.class);

    private final String appAlias;

    APP_TYPE(String appAlias) {
        this.appAlias = appAlias;
    }

    private String appAlias() {
        return appAlias;
    }

    public static APP_TYPE getApp(String appAlias) {
        String val = StringUtils.trimToEmpty(appAlias).toUpperCase();
        Optional<APP_TYPE> possible = Enums.getIfPresent(APP_TYPE.class, val);
        if (!possible.isPresent()) {
            throw new IllegalArgumentException(val + "? There is no such Environment!");
        }
        return possible.get();
    }
}