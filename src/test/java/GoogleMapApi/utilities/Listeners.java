package GoogleMapApi.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener
{
	public static int totalTestPass=0;
	public static int totalTestFail=0;
	public static int totalTest=0;

		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			totalTest++;
		}

		public void onTestSuccess(ITestResult result) 
		{
			// TODO Auto-generated method stub
			totalTestPass++;
			
		}
		
		
		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
//			String s= result.getName();
//			try {
//				Testapk_base.getSreenshot(s);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			totalTestFail++;
			
		}
		
		
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub

			SparkHTML.extent.flush();
			
		}
}
