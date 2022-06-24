package nextBaseCRM;

import nextBaseCRM.utilities.ConfigurationReader;
import nextBaseCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Kamilla_US_11  {
    @Test( priority = 1)

    public void timeAndReport(){
        //  Go to : https://login2.nextbasecrm.com/
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username3"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

        // 1.Verify only hr and marketing team can access to time and report module
        WebElement timeRepoModule = Driver.getDriver().findElement(By.xpath("(//a[@href='/timeman/'])[1]"));
        timeRepoModule.click();
        Driver.closeDriver();



    }
    @Test (priority = 2)
    public void absenceChart(){
        // 2.Verify users can filter absence chart by day/week/month

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username3"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        WebElement timeRepoModule = Driver.getDriver().findElement(By.xpath("(//a[@href='/timeman/'])[1]"));
        timeRepoModule.click();

        WebElement dayBtn = Driver.getDriver().findElement(By.xpath("(//span[@class='bx-c'])[3]"));
        dayBtn.click();
        WebElement weekBtn = Driver.getDriver().findElement(By.xpath("(//span[@class='bx-c'])[2]"));
        weekBtn.click();
        WebElement monthBtn = Driver.getDriver().findElement(By.xpath("(//span[@class='bx-c'])[1]"));
        monthBtn.click();
        Driver.closeDriver();


    }
    @Test (priority = 3)
    public void workTimeBtn (){

        // 3. Verify users can check statistics under work time

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username3"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        WebElement timeRepoModule = Driver.getDriver().findElement(By.xpath("(//a[@href='/timeman/'])[1]"));
        timeRepoModule.click();
        WebElement workTime = Driver.getDriver().findElement(By.xpath("(//a[@class='main-buttons-item-link'])[2]//span[.='Worktime']"));
        workTime.click();
        //  Verify checkbox Statistics is SELECTED by default.
        WebElement checkbox1 = Driver.getDriver().findElement(By.cssSelector("input[id='stats']"));
        System.out.println("checkbox.isSelected() = " + checkbox1.isSelected());
        Driver.closeDriver();


    }
    @Test (priority = 4)
    public void checkStartEnd(){

        // 4.Verify users can check show start and end times under work times

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username3"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        WebElement timeRepoModule = Driver.getDriver().findElement(By.xpath("(//a[@href='/timeman/'])[1]"));
        timeRepoModule.click();
        WebElement workTime = Driver.getDriver().findElement(By.xpath(
                "(//a[@class='main-buttons-item-link'])[2]//span[.='Worktime']"));
        workTime.click();

        WebElement checkbox2 = Driver.getDriver().findElement(By.cssSelector("input[id='additional']"));
        checkbox2.click();
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());
        Driver.closeDriver();

    }







}
