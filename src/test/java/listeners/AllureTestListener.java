package listeners;

import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListener extends AllureTestNg implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Тест упал: " + result.getName());
        super.onTestFailure(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Тест прошёл: " + result.getName());
        super.onTestSuccess(result);
    }
}