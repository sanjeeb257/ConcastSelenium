package com.vtiger.Altern.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count=0;
	
	int retrycount= 4;
	
	public boolean retry(ITestResult result) {
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}

}
