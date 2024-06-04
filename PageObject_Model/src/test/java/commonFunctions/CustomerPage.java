package commonFunctions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage 
{
   @FindBy(xpath = "//li[@id='mi_a_customers']//a[@href='a_customerslist.php'][normalize-space()='Customers']")
   WebElement ObjCustomer;
   @FindBy(xpath = "//div[@class='panel-heading ewGridUpperPanel']//span[@class='glyphicon glyphicon-plus ewIcon']")
   WebElement ObjAddIcon;
   @FindBy(id  = "x_Customer_Number")
   WebElement ObjCusNum;
   @FindBy(id = "x_Customer_Name")
   WebElement ObjCusName;
   @FindBy(id = "x_Address")
   WebElement ObjAddress;
   @FindBy(id = "x_City")
   WebElement ObjCity;
   @FindBy(id = "x_Country")
   WebElement ObjCountry;
   @FindBy(id = "x_Contact_Person")
   WebElement ObjConPerson;
   @FindBy(id = "x_Phone_Number")
   WebElement ObjPhnNum;
   @FindBy(id = "x__Email")
   WebElement ObjEmail;
   @FindBy(id = "x_Mobile_Number")
   WebElement ObjMobNum;
   @FindBy(id = "x_Notes")
   WebElement ObjNotes;
   @FindBy(name = "btnAction")
   WebElement ObjClickAddBtn;
   @FindBy(xpath = "//button[contains(text(),'OK!')]")
   WebElement ObjConfirmOkbtn;
   @FindBy(xpath = "(//button[contains(text(),'OK')])[6]")
   WebElement ObjAlertOkbtn;
   @FindBy(xpath = "//span[@class='glyphicon glyphicon-search ewIcon']")
   WebElement ObjSearchPanel;
   @FindBy(id = "psearch")
   WebElement ObjSearchTextbox;
   @FindBy(id = "btnsubmit")
   WebElement ObjSearchSubmit;
   @FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement webtable;
   public boolean addCustomer(String CustomerName, String Address, String City, String Country, String ContactPerson,
		                      String PhoneNumber, String Email, String MobileNumber, String Notes) throws Throwable
   {
	   ObjCustomer.click();
	   ObjAddIcon.click();
	   String Exp_Num = ObjCusNum.getAttribute("value");
	   ObjCusName.sendKeys(CustomerName);
	   ObjAddress.sendKeys(Address);
	   ObjCity.sendKeys(City);
	   ObjCountry.sendKeys(Country);
	   ObjConPerson.sendKeys(ContactPerson);
	   ObjPhnNum.sendKeys(PhoneNumber);
	   ObjEmail.sendKeys(Email);
	   ObjMobNum.sendKeys(MobileNumber);
	   ObjNotes.sendKeys(Notes);
	   ObjClickAddBtn.sendKeys(Keys.ENTER);
	   Thread.sleep(3000);
	   ObjConfirmOkbtn.click();
	   Thread.sleep(3000);
	   ObjAlertOkbtn.click();
	   Thread.sleep(3000);
	   if(!ObjSearchTextbox.isDisplayed())
		   ObjSearchPanel.click();
	   ObjSearchTextbox.clear();
	   ObjSearchTextbox.sendKeys(Exp_Num);
	   ObjSearchSubmit.click();
	   Thread.sleep(3000);
	   String Act_Num = webtable.getText();
	   if(Act_Num.equals(Exp_Num))
	   {
		   Reporter.log("Customer number matching");
		   return true;
	   }
	   else
	   {
		   Reporter.log("Customer number not matching");
		   return false;
	   }
   }
}
