package com.dahua.tc.gaea.asserts;

import com.dahua.tc.gaea.constant.AssertConst;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 重写TestNG断言.
 *
 * @author kay
 * @since 2019-12-09
 */
public class Assertion {
    public static List<Error> errors = new ArrayList<Error>();

    public static String verifyEquals(Object actual, Object expected) {
        try {
            Assert.assertEquals(actual, expected);
            return AssertConst.PASS;
        } catch (Error e) {
            errors.add(e);
            return AssertConst.FAIL + ": " + errors.get(0).toString();
        }
    }

    public static String verifyEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
            return AssertConst.PASS;
        } catch (Error e) {
            errors.add(e);
            return AssertConst.FAIL + ": " + errors.get(0).toString();
        }
    }

    public static String verifyTrue(boolean expected) {
        try {
            Assert.assertTrue(expected);
            return AssertConst.PASS;
        } catch (Error e) {
            errors.add(e);
            return AssertConst.FAIL + ": " + errors.get(0).toString();
        }
    }

    public static String verifyFalse(boolean expected, String result) {
        try {
            Assert.assertFalse(expected);
            return AssertConst.PASS;
        } catch (Error e) {
            errors.add(e);
            return result;
        }
    }

}
