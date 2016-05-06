package com.r2development.leveris.utils.mdg;

import java.io.IOException;

/**
 * Created by anthonymottot on 28/04/2016.
 */
public interface MdgCallBack {
    String methodToEmailCallBack() throws IOException;
    String methodToSmsCallBack() throws IOException;
}
