package com.r2development.leveris.qa.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.Is;
import org.junit.Test;
import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;

public class OrasqlTest {

    private static final Log log = LogFactory.getLog(OrasqlTest.class);

    @Test
    public void validateTnsNamesPropertiesIsLoaded() throws Exception {
/*
        String TNSNAME_PATH = System.getProperty("oracle.net.tns_admin");
        log.error("Debugging : " + System.getProperty("jenkins.workspace"));
        assertThat("System property of oracle.net.tns_admin should be loaded", StringUtils.isNotEmpty(TNSNAME_PATH));
*/
    }

    @Test
    public void validateTnsNamesPropertiesNotLoaded() throws Exception {

        //noinspection ConstantConditions
        File file = new File(OrasqlTest.class.getClassLoader().getResource("tnsnames.ora").toURI());
        assertThat("File should exist", file.exists(), Is.is(true));

        String TNSNAME_PATH = System.getProperty("oracle.net.tns_admin");
        log.error("Debugging : " + System.getProperty("jenkins.workspace"));
        assertThat("System property of oracle.net.tns_admin should not be loaded", StringUtils.isEmpty(TNSNAME_PATH));
    }

    @Test
    public void getDataTest() throws Exception {
/*
        String TNSNAME_PATH = System.getProperty("oracle.net.tns_admin");
        log.error("Debugging : " + System.getProperty("jenkins.workspace"));
        assertThat("System property of oracle.net.tns_admin should be loaded", StringUtils.isNotEmpty(TNSNAME_PATH));

        Class.forName("oracle.jdbc.OracleDriver");
        Map<Integer, Map<String, String>> data = Orasql.executeSqlSelectQuery("jdbc:oracle:thin:@TEST1", "abakus_mchuser", "heslo", "select * from mch_user where EMAILADDRESS like '%anthony%' and isemailaddressvalid = 'false' and isphonenumbervalid = 'false' and isregistrationcomplete = 'false' and ROWNUM <=2");
        assertEquals("I am expected to have only two occurrences as a result", data.size(), 2);
*/
    }

    @Test
    public void updateDatabaseTest() throws Exception {
/*
        String TNSNAME_PATH = System.getProperty("oracle.net.tns_admin");
        log.error("Debugging : " + System.getProperty("jenkins.workspace"));
        assertThat("System property of oracle.net.tns_admin should be loaded", StringUtils.isNotEmpty(TNSNAME_PATH));

        Class.forName("oracle.jdbc.OracleDriver");
        Map<Integer, Map<String, String>> data = Orasql.executeSqlSelectQuery("jdbc:oracle:thin:@TEST1", "abakus_mchuser", "heslo", "select * from mch_user where EMAILADDRESS like '%anthony%' and isemailaddressvalid = 'false' and isphonenumbervalid = 'false' and isregistrationcomplete = 'false' and ROWNUM <=2");
        assertEquals("I am expected to have only two occurrences as a result", data.size(), 2);
        Map<String, String> currentOccurrence = data.get(0);
        Orasql.executeSqlUpdateQuery("jdbc:oracle:thin:@TEST1", "abakus_mchuser", "heslo", "update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + currentOccurrence.get("EMAILADDRESS") + "'");
        Map<Integer, Map<String, String>> data2 = Orasql.executeSqlSelectQuery("jdbc:oracle:thin:@TEST1", "abakus_mchuser", "heslo", "select * from mch_user where EMAILADDRESS = '" + currentOccurrence.get("EMAILADDRESS") + "'");
        assertEquals("I am expected to have only one occurrence as a result", data2.size(), 1);
        Map<String, String> updateDataVerification = data.get(0);
        assertEquals("I am expected to get isemailaddressvalid with value true", updateDataVerification.get("ISEMAILADDRESSVALID"), true);
        assertEquals("I am expected to get isphonenumbervalid with value true", updateDataVerification.get("ISPHONENUMBERVALID"), true);
        assertEquals("I am expected to get isphonenumbervalid with value true", updateDataVerification.get("ISPHONENUMBERVALID"), true);
*/
    }

}
