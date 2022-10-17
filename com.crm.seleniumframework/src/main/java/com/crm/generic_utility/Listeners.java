package com.crm.generic_utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	public void onTestFailure(ITestResult result) {
		String data=result.getMethod().getMethodName();
		EventFiringWebDriver edriver= new EventFiringWebDriver(Baseclass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try {
			File dst= new File("./com.crm.seleniumframework/Screenshot/"+data+".png");
			FileUtils.copyFile(src, dst);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
			
		}
	}

}
