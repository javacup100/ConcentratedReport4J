package javacup100.report4j.customs;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerImpl implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("test "+result.getName()+" starts......");
        System.out.println("test "+result.getParameters());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("test "+result.getName()+" status: "+result.getStatus());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("test "+result.getName()+" status: "+result.getStatus());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("test "+result.getName()+" status: "+result.getStatus());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("testRun "+context.getName()+" starts......");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("testRun "+context.getName()+" ends......");
    }
}
