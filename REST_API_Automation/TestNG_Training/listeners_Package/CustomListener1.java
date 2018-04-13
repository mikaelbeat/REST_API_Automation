package listeners_Package;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomListener1 implements IInvokedMethodListener{

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
			// Before every method in test class
			System.out.println("beforeInvocation: " + testResult.getTestClass()
			.getName() + " => " + method.getTestMethod().getMethodName());
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
			// After every method in test class
			System.out.println("afterInvocation: " + testResult.getTestClass()
			.getName() + " => " + method.getTestMethod().getMethodName());
	}

}