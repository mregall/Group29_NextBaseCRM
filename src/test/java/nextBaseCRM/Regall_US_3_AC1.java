package nextBaseCRM;

import nextBaseCRM.base.TestBase;
import nextBaseCRM.utilities.ConfigurationReader;
import nextBaseCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Regall_US_3_AC1 extends TestBase {

    /*
    US 3: As a user, I should be able to search people, document and more from search box.
    AC 1: Verify users can search a valid info from search box.
            (employee, doc, post, etc)
    */

    @Test
    public void US3_AC1_Search() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

        WebElement searchBox = Driver.getDriver().findElement(By.id("search-textbox-input"));
        searchBox.sendKeys("Chuck Norris" + Keys.ENTER);

        WebElement searchText = Driver.getDriver().findElement(By.id("LIVEFEED_search"));

        String expectedActivityStreamText = "Chuck Norris";
        String actualActivityStreamText = searchText.getAttribute("value");

        if (expectedActivityStreamText.equals(actualActivityStreamText)) {
            System.out.println("Search verification passed!");
        } else {
            System.out.println("Search verification failed!");
        }
    }

}

