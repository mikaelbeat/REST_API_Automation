package listeners_Package;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener2 implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// When @Test method starts
		System.out.println("onTestStart ->  Test name: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// If @Test method is successful
		System.out.println("onTestSuccess -> Test name: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// If @Test method is failed
		System.out.println("onTestFailure -> Test name: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}