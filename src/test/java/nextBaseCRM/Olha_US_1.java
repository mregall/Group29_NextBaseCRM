package nextBaseCRM;

import nextBaseCRM.base.TestBase;
import nextBaseCRM.utilities.CRM_Utilities;
import nextBaseCRM.utilities.ConfigurationReader;
import nextBaseCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Olha_US_1 {
    // Given user navigate to login page
    // When user enters username
    // And user enters password
    // Then user should log in to CRM application
    @Test
    public void AC1Login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        String actualResult = Driver.getDriver().getTitle();
        String expectedResult = "Portal";
        Assert.assertTrue(actualResult.contains(expectedResult));

        Driver.closeDriver();
    }

    // Given user navigate to login page
    // When user enters username
    // And user enters wrong password
    // Then user should not log in to CRM application
    @Test
    public void AC2LoginNegative(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("User");
        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        WebElement errorText = Driver.getDriver().findElement(By.cssSelector(".errortext"));
        String expectedMsg = "Incorrect login or password";
        Assert.assertEquals(errorText.getText(), expectedMsg, "Negative login testing failed");

        Driver.closeDriver();
    }

    // Given user on login page
    // When user click on Remember me on this computer
    // Then option Remember me on this computer was checked
    @Test
    public void AC3RememberMeBtn(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement rememberMeBtn = Driver.getDriver().findElement(By.cssSelector("#USER_REMEMBER"));
        rememberMeBtn.click();
        System.out.println(rememberMeBtn.isSelected());

    }

    @Test
    public void AC4ForgotPassword(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement forgotPassword = Driver.getDriver().findElement(By.cssSelector(".login-link-forgot-pass"));
        forgotPassword.click();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Get Password", "Forgot password verification failed");
    }

}
