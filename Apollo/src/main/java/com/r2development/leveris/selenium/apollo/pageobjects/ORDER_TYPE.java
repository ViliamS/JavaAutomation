package com.r2development.leveris.selenium.apollo.pageobjects;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum ORDER_TYPE {

    UP ( "Up" ),
    DOWN ( "Down" );

    private static final Log log = LogFactory.getLog(ORDER_TYPE.class);

    private final String orderAlias;

    ORDER_TYPE(String orderAlias) {
        this.orderAlias = orderAlias;
    }

    private String orderAlias() {
        return orderAlias;
    }

    public static ORDER_TYPE getOrder(String orderAlias) throws Exception {
        String val = StringUtils.trimToEmpty(orderAlias).toUpperCase();
        Optional<ORDER_TYPE> possible = Enums.getIfPresent(ORDER_TYPE.class, val);
        if (!possible.isPresent()) {
            throw new IllegalArgumentException(val + "? There is no such Environment!");
        }
        return possible.get();
    }
}
