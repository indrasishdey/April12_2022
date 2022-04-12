package runner;

import org.testng.TestNG;

import testcases.LoginPageTest;
import utilities.Config;

public class TestRunner {
	static TestNG testng;

	public static void main(String[] args) {
		testng = new TestNG();
		testng.setTestClasses(new Class[] { LoginPageTest.class });
		testng.run();
	}
}
