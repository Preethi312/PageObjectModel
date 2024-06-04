package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage 
{
   @FindBy(name = "btnreset")
   WebElement ObjReset;
   @FindBy(id = "username")
   WebElement ObjUser;
   @FindBy(id = "password")
   WebElement ObjPass;
   @FindBy(id = "btnsubmit")
   WebElement ObjSubmit;
   public void adminLogin(String user, String pass)
   {
	   ObjReset.click();
	   ObjUser.sendKeys(user);
	   ObjPass.sendKeys(pass);
	   ObjSubmit.click();
   }
}
