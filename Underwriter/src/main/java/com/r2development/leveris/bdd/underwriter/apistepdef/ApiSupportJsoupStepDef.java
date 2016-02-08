package com.r2development.leveris.bdd.underwriter.apistepdef;

import com.r2development.leveris.utils.JsoupContainer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.select.Elements;

public class ApiSupportJsoupStepDef {

    private static final Log log = LogFactory.getLog(ApiSupportJsoupStepDef.class);

    public static JsoupContainer jsoupContainer = new JsoupContainer();

    public static JsoupContainer getInstanceJsoupContainer() {
        return jsoupContainer;
    }

    public static Elements get(String key) {
        return (StringUtils.isEmpty(key) ? null : jsoupContainer.get(key));
    }

    public static void put(String key, Elements elements) {
        jsoupContainer.put(key, elements);
    }
}
