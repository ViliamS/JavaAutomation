package com.r2development.leveris.tdd.borrower;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

import static com.r2development.leveris.utils.XPathBuilder.*;

public class XPathBuilderTest {

    public class GuavaUtils {
        private Table<String, String, String> table;

        GuavaUtils() {
            table = HashBasedTable.create();
        }

        public Table<String, String, String> setGuava(Table<String, String, String> t) {
            table = t;
            return table;
        }

        public GuavaUtils put(String row, String column, String value ) {
            table.put(row, column, value);
            return this;
        }

        public Table<String, String, String> getTable() {
            return table;
        }
    }

//    public static void main(String... args) {
//
//        XPathBuilderTest xpathBuilderTest = new XPathBuilderTest();
//        xpathBuilderTest.test1();
//        xpathBuilderTest.test2();
//        xpathBuilderTest.test3();
//        xpathBuilderTest.test4();
//        xpathBuilderTest.test5();
//        xpathBuilderTest.test6();
//    }

    @Test
    public void test1 () {

        Table<String, String, String> t = HashBasedTable.create();
        t.put(contains, wicketpath, "lnkAddMore_dialog");
        String xpath1 = xpath(
                doubleSlash,
                div,
                t
        );
        System.out.println("xpath1: " + xpath1);

    }

    @Test
    public void test2 () {

        Table<String, String, String> t = HashBasedTable.create();
        t.put(contains, wicketpath, "pnlNew");
        t.put(contains, wicketpath, "rptDocs");
        String xpath1 = xpath(
                doubleSlash,
                div,
                t
        );
        System.out.println("xpath2: " + xpath1);

    }

    @Test
    public void test3 () {

        Table<String, String, String> t = HashBasedTable.create();
        t.put(notContains, wicketpath, "pnlNew");
        String xpath1 = xpath(
                doubleSlash,
                div,
                t
        );
        System.out.println("xpath3: " + xpath1);

    }

    @Test
    public void test4 () {

        Table<String, String, String> t = HashBasedTable.create();
        t.put(contains, wicketpath, "pnlNew");
        String xpath1 = xpath(
                doubleSlash,
                div,
                t
        );
        System.out.println("xpath3: " + xpath1);

    }

    @Test
    public void test5 () {

        Table<String, String, String> t = HashBasedTable.create();
        t.put("s;dlfijglsdkjfg;lj", wicketpath, "pnlNew");
        String xpath1 = xpath(
                doubleSlash,
                div,
                t
        );
        System.out.println("xpath5: " + xpath1);

    }

    @Test
    public void test6() {
        String xpathResult =
            xpath(doubleSlash, "a", new GuavaUtils().put(equals, "href", "#/search").getTable())
                +
            xpath(singleSlash, "img", new GuavaUtils().put(equals, "src", "assets/logo,png").put(equals, "alt", "Abakus").getTable());

        System.out.println("xpath6: " + xpathResult);
    }

}


