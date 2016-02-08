package com.r2development.leveris.selenium.apollo.pageobjects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum SEARCH_TYPE {

    FULL_SEARCH ( "FullSearch" ),
    ADVANCED_SEARCH ( "AdvancedSearch" );

    private static final Log log = LogFactory.getLog(SEARCH_TYPE.class);

    private final String searchAlias;

    SEARCH_TYPE(String searchAlias) {
        this.searchAlias = searchAlias;
    }

    private String searchAlias() {
        return searchAlias;
    }
}
