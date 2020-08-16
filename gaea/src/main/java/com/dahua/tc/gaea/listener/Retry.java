package com.dahua.tc.gaea.listener;

import lombok.Data;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 重试机制.
 *
 * @author kay
 * @since 2020-01-06
 */
@Data
public class Retry implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
