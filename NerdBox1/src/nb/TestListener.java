package nb;

import java.util.Timer;
import java.util.TimerTask;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import email.SendMail;

public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test is getting started"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is passed"+result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test is failed"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test is started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test is finished");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path="C:\\Users\\Ahmed Bilal\\git\\AB\\NerdBox\\test-output\\emailable-report.html";
		SendMail.execute(path);

	}

}