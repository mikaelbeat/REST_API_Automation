package listeners_Package;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
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
		// If the @Test method is skipped
		System.out.println("SKIPPED -> Test name: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Ignore
	}

	@Override
	public void onStart(ITestContext context) {
		// Runs before <test> tag in xml file
		System.out.println("onStart -> Test tag name: " + context.getName());
		ITestNGMethod methods[] = context.getAllTestMethods();
		System.out.println("These methods will be executed in this test tag: ");
		for(ITestNGMethod method : methods) {
			System.out.println(method.getMethodName());
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// Runs after <test> tag in xml file
		System.out.println("onFinish -> Test tag name: " + context.getName());
	}

}