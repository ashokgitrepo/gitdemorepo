package seleniumTests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import org.testng.internal.annotations.DisabledRetryAnalyzer;

import retrypackage.RetryDefinedClass;

public class RetryFailedTestcases {
	@Test
	public void test1() {
		System.out.println("in test1");
		Assert.assertTrue(0>2);
	}
	@Test
	public void test2() {
		System.out.println("in test2");
		int i=1/0;
	}
	@Test()

	public void test3() {
		System.out.println("in test3");
		Assert.assertTrue(0>1);
	}

}
