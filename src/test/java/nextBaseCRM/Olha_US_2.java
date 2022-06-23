package nextBaseCRM;

import nextBaseCRM.utilities.ConfigurationReader;
import nextBaseCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Olha_US_2 {
    // Given user successfully logged into CRM page
    // When user clicks on message button
    // And user types message in the message console
    // And user clicks send button
    // The message should be displayed in the feed
    @Test
    public void AC1sendText() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        WebElement messageBtn = Driver.getDriver().findElement(By.cssSelector("span[id*='form-tab-message']"));
        messageBtn.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.cssSelector(".bx-editor-iframe")));
        Driver.getDriver().findElement(By.tagName("body")).sendKeys("Test");
        Driver.getDriver().switchTo().defaultContent();
        WebElement sendBtn = Driver.getDriver().findElement(By.id("blog-submit-button-save"));
        sendBtn.click();
        WebElement feedText = Driver.getDriver().findElement(By.xpath("//div[starts-with(@id, 'blog_post_body')]"));
        String actualText = feedText.getText();
        String expectedText = "Test";
        Assert.assertEquals(actualText, expectedText, "Feed message did not appear correctly!");
    }

    // Given user is on CRM page
    // When user clicks on message button
    // And user clicks on cancel button
    // Then message console collapsed and message canceled
    @Test
    public void AC2CancelMessage() {
        WebElement messageBtn = Driver.getDriver().findElement(By.cssSelector("span[id*='form-tab-message']"));
        messageBtn.click();
        WebElement cancelBtn = Driver.getDriver().findElement(By.id("blog-submit-button-cancel"));
        cancelBtn.click();

        Driver.closeDriver();
    }

    // Given user successfully logged into CRM page
    // When user clicks on message button
    // And user click link button
    // And user adds link to the popup window
    // And user click save
    // Then link should be added to text message
    @Test
    public void AC3attachLink() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        WebElement messageBtn = Driver.getDriver().findElement(By.cssSelector("span[id*='form-tab-message']"));
        messageBtn.click();
        WebElement linkBtn = Driver.getDriver().findElement(By.xpath("//span[@title='Link']"));
        linkBtn.click();
        WebElement linkField = Driver.getDriver().findElement(By.cssSelector("#linkidPostFormLHE_blogPostForm-href"));
        linkField.sendKeys("www.google.com");
        WebElement saveBtn = Driver.getDriver().findElement(By.cssSelector("#undefined"));
        saveBtn.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.cssSelector(".bx-editor-iframe")));
        Assert.assertEquals(Driver.getDriver().findElement(By.tagName("body")).getText(), "www.google.com", "Assertion failed");
    }


}
