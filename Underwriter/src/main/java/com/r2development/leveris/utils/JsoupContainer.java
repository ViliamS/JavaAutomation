package com.r2development.leveris.utils;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.select.Elements;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * Collection of Wicket Response per panel
 *      - Workflow
 *      - Financial Tool
 *      - Document
 *      - Document 2
 *      - Risk Tool
 *      - Application
 */

public class JsoupContainer {

    Map<String, Elements> container;

    public JsoupContainer() {
        container = new LinkedHashMap<>();
    }

    public Elements get(String key) {
        return (StringUtils.isEmpty(key) ? null : container.get(key));
    }

    public void put(String key, Elements elements) {
        container.put(key, elements);
    }

    public void replace(String key, Elements elements) { container.replace(key, elements); }
}
