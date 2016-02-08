package com.r2development.leveris;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum BROWSER_TYPE {

    CHROME      ( "Chrome" ),
    PHANTHOMJS  ( "PhanthomJs" ),
    FIREFOX     ( "Firefox" ),
    IE          ( "Internet Explorer" );

    private static final Log log = LogFactory.getLog(BROWSER_TYPE.class);

    private final String browserAlias;

    BROWSER_TYPE(String browserAlias) {
        this.browserAlias = browserAlias;
    }

    private String browserAlias() {
        return browserAlias;
    }

    public static BROWSER_TYPE getBrowser(String browserAlias) {
        String val = StringUtils.trimToEmpty(browserAlias).toUpperCase();
        Optional<BROWSER_TYPE> possible = Enums.getIfPresent(BROWSER_TYPE.class, val);
        if (!possible.isPresent()) {
            throw new IllegalArgumentException(val + "? There is no such Browser!");
        }
        return possible.get();
    }
}