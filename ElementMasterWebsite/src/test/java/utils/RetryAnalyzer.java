package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int maxRetry = 2; // retry 2 times

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetry) {
            count++;
            System.out.println("🔁 Retrying Test: " + result.getName() + " | Attempt: " + count);
            return true;
        }

        return false;
    }
}