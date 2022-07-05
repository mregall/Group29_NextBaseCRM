package nextBaseCRM.pages;

import nextBaseCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRM_Login_Page {

    public CRM_Login_Page(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name= "USER_LOGIN")
    public WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    public WebElement password;

    @FindBy(className = "login-btn")
    public WebElement loginBtn;

}
