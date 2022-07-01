package nextBaseCRM;

import nextBaseCRM.utilities.ConfigurationReader;
import nextBaseCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Maha_US_6 {

    /*"1. Verify users can clock in
    2. Verify users can clock out.
    3. Verify users can edit Today's task under daily plan.
    4. Verify users can add events.
    5. Verify users can edit work day starting and ending time.
    (hour change buttons are webtable, great practice)"*/

    @Test
    public void AC1_ClockIn() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username3"));
        Thread.sleep(2000);
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        Thread.sleep(2000);
        String actualResult = Driver.getDriver().getTitle();
        String expectedResult = "Portal";
        assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(2000);

       // WebElement timeWorkBtn = Driver.getDriver().findElement(By.id("timeman-background"));
        WebElement clockIn = Driver.getDriver().findElement(By.xpath("//span[@id='timeman-status']"));
        clockIn.click();


        WebElement workingDayDurationText = Driver.getDriver().findElement(By.xpath("//span[.='Working Day Duration: ']"));
        workingDayDurationText.isDisplayed();

        WebElement clockInBtn = Driver.getDriver().findElement(By.xpath("//span[@class='webform-small-button-text']"));
        clockInBtn.click();

        WebElement workingStatus = Driver.getDriver().findElement(By.cssSelector("span#timeman-status"));
        System.out.println("workingStatus.isDisplayed() = " + workingStatus.isDisplayed());

        Driver.closeDriver();


    }

    @Test
    public void AC2_ClockOut() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username3"));
        Thread.sleep(2000);
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        Thread.sleep(2000);
       // String actualResult = Driver.getDriver().getTitle();
       // String expectedResult = "Portal";
       // assertTrue(actualResult.equals(expectedResult));
       // Thread.sleep(2000);

        // WebElement timeWorkBtn = Driver.getDriver().findElement(By.id("timeman-background"));
        WebElement clockIn = Driver.getDriver().findElement(By.xpath("//span[@id='timeman-status']"));
        clockIn.click();


        WebElement workingDayDurationText = Driver.getDriver().findElement(By.xpath("//span[.='Working Day Duration: ']"));
        workingDayDurationText.isDisplayed();

        WebElement clockInBtn = Driver.getDriver().findElement(By.xpath("//span[@class='webform-small-button-text']"));
        clockInBtn.click();

        Thread.sleep(2000);


        WebElement clockOutBtn = Driver.getDriver().findElement(By.xpath("//span[@class='webform-small-button-text']"));
        clockOutBtn.click();

        WebElement clockOutText = Driver.getDriver().findElement(By.xpath("//span[@id='timeman-status']"));

        Thread.sleep(1000);


        System.out.println("clockOutText.isDisplayed() = " + clockOutText.isDisplayed());
        System.out.println("clockOutText.getText() = " + clockOutText.getText());

        Driver.closeDriver();


    }

    @Test
    public void AC3_Edit_Task() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username3"));
        Thread.sleep(2000);
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        // String actualResult = Driver.getDriver().getTitle();
        // String expectedResult = "Portal";
        // assertTrue(actualResult.equals(expectedResult));
        // Thread.sleep(2000);
        WebElement timeBlock = Driver.getDriver().findElement(By.xpath("//span[@id='timeman-block']"));
        timeBlock.click();

        Driver.closeDriver();



    }

    @Test
    public void AC4_Add_Events() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username3"));
        Thread.sleep(2000);
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        // String actualResult = Driver.getDriver().getTitle();
        // String expectedResult = "Portal";
        // assertTrue(actualResult.equals(expectedResult));
        // Thread.sleep(2000);
        WebElement timeBlock = Driver.getDriver().findElement(By.xpath("//span[@id='timeman-block']"));
        timeBlock.click();

        Thread.sleep(1000);
        WebElement newEvent = Driver.getDriver().findElement(By.xpath("//input[@class='tm-popup-event-form-textbox_am_pm']"));
        newEvent.sendKeys("Demo Meeting");

        Thread.sleep(1000);

        WebElement addEvent = Driver.getDriver().findElement(By.xpath("//span[@class='tm-popup-event-form-submit']"));
       addEvent.click();

        Thread.sleep(1000);

       WebElement eventVerify = Driver.getDriver().findElement(By.xpath("//span[@class='tm-popup-event-text']"));


        System.out.println("eventVerify.getText() = " + eventVerify.getText());

        System.out.println("eventVerify.isDisplayed() = " + eventVerify.isDisplayed());

        Driver.closeDriver();


    }

    @Test
    public void AC5_Edit_WorkingTime() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username3"));
        Thread.sleep(2000);
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        // String actualResult = Driver.getDriver().getTitle();
        // String expectedResult = "Portal";
        // assertTrue(actualResult.equals(expectedResult));
        // Thread.sleep(2000);
        WebElement timeBlock = Driver.getDriver().findElement(By.xpath("//span[@id='timeman-block']"));
        timeBlock.click();

        WebElement pencilBtn = Driver.getDriver().findElement(By.xpath("//span[@class='tm-popup-notice-pencil']"));
        pencilBtn.click();

        Thread.sleep(4000);

        WebElement upArrow = Driver.getDriver().findElement(By.xpath("(//td[@title='Increase (Up)'])[1]"));
        upArrow.click();

        Thread.sleep(2000);

        WebElement downArrow = Driver.getDriver().findElement(By.xpath("(//td[@title='Decrease (Down)'])[2]"));
        downArrow.click();
        WebElement downArrowEnd = Driver.getDriver().findElement(By.xpath("(//td[@title='Decrease (Down)'])[3]"));
        Thread.sleep(2000);
        downArrowEnd.click();
        WebElement upArrowEnd = Driver.getDriver().findElement(By.xpath("(//td[@title='Increase (Up)'])[4]"));
        upArrowEnd.click();

        WebElement endAmPm = Driver.getDriver().findElement(By.xpath("(//span[@class='bxc-am-pm'])[2]"));
        endAmPm.click();
        Thread.sleep(2000);

        WebElement reason = Driver.getDriver().findElement(By.xpath("(//div[@class='bx-tm-popup-clock-wnd-report'])[4]/div"));
        reason.sendKeys("Time change");

        Thread.sleep(1000);

        WebElement saveBtn = Driver.getDriver().findElement(By.xpath("//span[@class='popup-window-button popup-window-button-create']"));
        saveBtn.click();













    }


}
