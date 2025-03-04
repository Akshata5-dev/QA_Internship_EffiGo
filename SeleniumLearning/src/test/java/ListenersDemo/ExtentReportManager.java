package ListenersDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//we can see Later in FrameWork again -->try to understand first
public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter;//UI of the report
	public ExtentReports extent;//populate common info on the report
    public ExtentTest test;//creating test case entries in the report and udate status of the test methods
    
    public void onStart(ITestContext context) {
    	//missing-->report name is hard-coded
    	sparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");//specify path
    	sparkReporter.config().setDocumentTitle("Automation Report"); //Title of Report
    	sparkReporter.config().setReportName("Functional Testing");//name of the report
    	sparkReporter.config().setTheme(Theme.STANDARD);
    	
    	extent=new ExtentReports();
    	extent.attachReporter(sparkReporter);
    	
    	//missing-->data hard coded
    	extent.setSystemInfo("Computer Name","local host");
    	extent.setSystemInfo("Environment","QA");
    	extent.setSystemInfo("Tester Name","pavan");
    	extent.setSystemInfo("os","windows 10");
    	extent.setSystemInfo("Browser name","Chrome");
    	
    	
    }
    public void onTestSuccess(ITestResult result) {
    	test =extent.createTest(result.getName()); //create a new entry in the report
    	test.log(Status.PASS,"Test case PASSED is:"+result.getName()); //update status p/f/s
    }
    public void onTestFailure(ITestResult result) {
    	//capture the failure of screenshot missing-->should appear in report
    	test =extent.createTest(result.getName()); //create a new entry in the report
    	test.log(Status.FAIL,"Test case FAILED is:"+result.getName()); 
    	test.log(Status.FAIL,"Test case FAILED  cause is:"+result.getThrowable());
    }
    public void onTestSkipped(ITestResult result) {
    	test =extent.createTest(result.getName()); 
    	test.log(Status.SKIP,"Test case SKIPPED is:"+result.getName()); 
    }
    
    public void onFinish(ITestContext content) {
    extent.flush(); //compulsory method
 
    }
    }
   //missing-->instead of define the methods ,define cls name along with test ID bcz if more not able handle
