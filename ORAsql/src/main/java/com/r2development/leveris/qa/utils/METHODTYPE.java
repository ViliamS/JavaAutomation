package com.r2development.leveris.qa.utils;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;

public enum METHODTYPE {

    VARCHAR ("java.lang.String", "setString", "getString"),
    VARCHAR2 ("java.lang.String", "setString", "getString"),
    CHAR ("java.lang.String", "setString", "getString"),
    LONGVARCHAR ("java.lang.String", "setString", "getString"),
    BIT ("boolean", "setBoolean", "getBoolean"),
    NUMERIC ("java.math.BigDecimal", "setBigDecimal", "getBigDecimal"),
    TINYINT ("byte", "setByte", "getByte"),
    SMALLINT ("short", "setShort", "getShort"),
    INTEGER ("int", "setInt", "getInt"),
    NUMBER ("int", "setInt", "getInt"),
    BIGINT ("long", "setLong", "getLong"),
    REAL ("float", "setFloat", "getFloat"),
    FLOAT ("float", "setFloat", "getFloat"),
    DOUBLE ("double", "setDouble", "getDouble"),
    VARBINARY ("byte[ ]", "setBytes", "getBytes"),
    BINARY ("byte[ ]", "setBytes", "getBytes"),
    DATE ("java.sql.Date", "setDate", "getDate"),
    TIME ("java.sql.Time", "setTime", "getTime"),
    TIMESTAMP ("java.sql.Timestamp", "setTimestamp", "getTimestamp"),
    CLOB ("java.sql.Clob","setClob", "getClob"),
    BLOB ("java.sql.Blob", "setBlob", "getBlob"),
    ARRAY ("java.sql.Array", "setARRAY", "getARRAY"),
    REF ("java.sql.Ref", "SetRef", "getRef"),
    STRUCT ("java.sql.Struct", "SetStruct", "getStruct");

    private String getMethodName;
    private String setMethodName;
    private String javaDataType;

    METHODTYPE(String javaDataType, String setMethodName, String getMethodName) {
        this.getMethodName = getMethodName;
        this.setMethodName = setMethodName;
        this.javaDataType = javaDataType;
    }

    public  static METHODTYPE setMethod(String setMethodName) {
        String val = StringUtils.trimToEmpty(setMethodName).toUpperCase();

        Optional<METHODTYPE> possible = Enums.getIfPresent(METHODTYPE.class, val);

        if (!possible.isPresent()){
            throw new IllegalArgumentException(val + "? There is no such method!");
        }
        return possible.get();
    }

    public static METHODTYPE getMethod(String getMethodName) {
        String val = StringUtils.trimToEmpty(getMethodName).toUpperCase();
        Optional<METHODTYPE> possible = Enums.getIfPresent(METHODTYPE.class, val);
        if (!possible.isPresent()) {
            throw new IllegalArgumentException(val + "? There is no such method!");
        }
        return possible.get();
    }

    public static Object getJavaClassType(METHODTYPE dataType){
        return dataType.getJavaDataType();
    }

    public String getMethodName() {
        return getMethodName;
    }

    public String setMethodName(){
        return setMethodName;
    }

    public String getJavaDataType(){
        return javaDataType;
    }

}