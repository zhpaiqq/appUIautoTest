package com.dahua.tc.gaea.report;

import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;

import java.util.Calendar;

/**
 * 自定义测试报告类.
 *
 * @author kay
 * @since 2019-12-06
 */
public class Report {
    private static String reportName = "自动化测试报告";
    private static String splitTimeAndMsg = "===";

    public static void log(String msg) {
        long timeMillis = Calendar.getInstance().getTimeInMillis();
        Reporter.log(timeMillis + splitTimeAndMsg + msg, true);
    }

    public static String getReportName() {
        return reportName;
    }

    public static String getSpiltTimeAndMsg() {
        return splitTimeAndMsg;
    }

    public static void setReportName(String reportName) {
        if (StringUtils.isNotEmpty(reportName)) {
            Report.reportName = reportName;
        }
    }
}
