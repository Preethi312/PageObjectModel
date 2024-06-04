package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogoutPage 
{
   @FindBy(id = "logout")
   WebElement ObjLogout;
   @FindBy(xpath = "//button[normalize-space()='OK!']")
   WebElement ObjOkButton;
   public void adminLogout()
   {
	   ObjLogout.click();
	   ObjOkButton.click();
   }
}
