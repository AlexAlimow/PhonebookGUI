package Phonebook.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
    int counter = 0;
    int retryLimit = 4;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (counter < retryLimit) {
            counter++;
            System.out.println("Retry rest -> "
                    + iTestResult.getName()
                    + " in quantity "
                    + retryLimit + " times");
            return true;
        }
        return false;
    }
}
