package com.dahua.tc.gaea.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.dahua.tc.gaea.util.PropertiesUtils;

/**
 * Extent测试报告管理类.
 *
 * @author kay
 * @since 2018-05-07
 */
public class ExtentManager {
    private static ExtentReports extent;
    private static String mongodbIp = PropertiesUtils.getValue("mongo.ip");
    private static int mongodbPort = Integer.parseInt(PropertiesUtils.getValue("mongo.port"));
    private static String klovUrl = PropertiesUtils.getValue("klov.url");
    public static String projectName = PropertiesUtils.getValue("project.name");
    public static String projectVersion = PropertiesUtils.getValue("project.version");

    public static ExtentReports getInstance(String filePath) {
        if (extent == null) {
            createInstance(filePath);
        }
        return extent;
    }

    public static void createInstance(String filePath) {
        extent = new ExtentReports();
        extent.setSystemInfo("os", "Linux");
        extent.attachReporter(createHtmlReporter(filePath));
//        extent.attachReporter(createHtmlReporter(filePath), createExtentxReporter());
    }

    public static ExtentHtmlReporter createHtmlReporter(String filePath) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
        //报表位置
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        //使报表上的图表可见
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        htmlReporter.config().setDocumentTitle(filePath);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("XXX项目测试报告");
        return htmlReporter;
    }

//    public static ExtentXReporter createExtentxReporter() {
//        ExtentXReporter extentx = new ExtentXReporter("10.200.143.9", 27017);
//        extentx.config().setProjectName("小泰乐活");
//        extentx.config().setReportName("Build-001");
//        extentx.config().setServerUrl("http://10.200.143.9:1337");
//        return extentx;
//    }

    public static KlovReporter createKlovReporter() {
        KlovReporter klov = new KlovReporter();
        klov.initMongoDbConnection(mongodbIp, mongodbPort);
        klov.setKlovUrl(klovUrl);
        klov.setProjectName(projectName);
        klov.setReportName(projectVersion);
        return klov;
    }
}
