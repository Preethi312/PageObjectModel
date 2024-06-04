package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.CustomerPage;
import config.AppUtil;
import utiles.ExcelFileUtil;

public class AppTest extends AppUtil
{
  String InputPath = "./FileInput/CustomerData.xlsx";
  String OutputPath = "./FileOutput/CustomerResults.xlsx";
  ExtentReports report;
  ExtentTest logger;
  @Test
  public void add_Customer()throws Throwable
  {
	  report = new ExtentReports("./target/Reports/LoginReports.html");
	  ExcelFileUtil xl = new ExcelFileUtil(InputPath);
	  CustomerPage cus = PageFactory.initElements(driver, CustomerPage.class);
	  int rc = xl.rowcount("customerdata");
	  Reporter.log("No Of rows are ::" + rc, true);
	  for (int i = 1; i<=rc; i++)
	  {
		  logger = report.startTest("Customer Module");
		  logger.assignAuthor("Preethi");
		  String customerName = xl.getCellData("customerdata", i, 0);
		  String Address = xl.getCellData("customerdata", i, 1);
	      String City = xl.getCellData("customerdata", i, 2);
	      String Country = xl.getCellData("customerdata", i, 3);
	      String ContactPerson = xl.getCellData("customerdata", i, 4);
	      String PhoneNumber = xl.getCellData("customerdata", i, 5);
	      String Email = xl.getCellData("customerdata", i, 6);
	      String MobileNumber = xl.getCellData("customerdata", i, 7);
	      String Notes = xl.getCellData("customerdata", i, 8);
	      logger.log(LogStatus.INFO, customerName+"   "+Address+"    "+City+"  "+Country+"   "+ContactPerson+"   "+PhoneNumber+"    "+Email+"   "+MobileNumber+"   "+Notes);
	      boolean res = cus.addCustomer(customerName, Address, City, Country, ContactPerson, PhoneNumber, Email, MobileNumber, Notes);
	      if(res)
	      {
	    	  xl.setCellData("customerdata", i, 9, "Pass", OutputPath);
	    	  logger.log(LogStatus.PASS, "Customer added successfully");
	      }
	      else
	      {
	    	  xl.setCellData("customerdata", i, 9, "Fail", OutputPath);
	    	  logger.log(LogStatus.FAIL, "Customer add Failed");
	      }
	      report.endTest(logger);
	      report.flush();
	  }
  }
}
