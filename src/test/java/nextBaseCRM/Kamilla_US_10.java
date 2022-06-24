package nextBaseCRM;

import nextBaseCRM.utilities.ConfigurationReader;
import nextBaseCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Kamilla_US_10 {




        @Test(priority = 1)
        public void checkHighPriBtn() {
            // Go to : https://login2.nextbasecrm.com/

            // 1. Users can check "high priority" button
            Driver.getDriver().get(ConfigurationReader.getProperty("env"));

            WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
            username.sendKeys(ConfigurationReader.getProperty("username3"));
            WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
            password.sendKeys(ConfigurationReader.getProperty("password"));
            WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
            loginBtn.click();


            WebElement taskBtn = Driver.getDriver().findElement(By.xpath("(//span[.='Task']) [2]"));
            taskBtn.click();
            WebElement checkbox = Driver.getDriver().findElement(By.xpath("//input[@id='tasks-task-priority-cb']"));
            System.out.println("checkbox.isSelected() = " + checkbox.isSelected());
            checkbox.click();

            Driver.closeDriver();
        }
        @Test (priority = 2)

        public void checkListBtn() {

            //2. Users can click on "checklist" to create checklist items

            Driver.getDriver().get(ConfigurationReader.getProperty("env"));
            WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
            username.sendKeys(ConfigurationReader.getProperty("username3"));
            WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
            password.sendKeys(ConfigurationReader.getProperty("password"));
            WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
            loginBtn.click();
            WebElement taskBtn = Driver.getDriver().findElement(By.xpath("(//span[.='Task']) [2]"));
            taskBtn.click();

            WebElement checklist = Driver.getDriver().findElement(By.xpath("//span[@class='tasks-task-mpf-link']"));
            checklist.click();
            Driver.closeDriver();
        }
        @Test (priority = 3)
        public void addDeadline() {

            //3. Users can add Deadline

            Driver.getDriver().get(ConfigurationReader.getProperty("env"));
            WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
            username.sendKeys(ConfigurationReader.getProperty("username3"));
            WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
            password.sendKeys(ConfigurationReader.getProperty("password"));
            WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
            loginBtn.click();
            WebElement taskBtn = Driver.getDriver().findElement(By.xpath("(//span[.='Task']) [2]"));
            taskBtn.click();

            WebElement deadlineBtn = Driver.getDriver().findElement(By.xpath("(//input[@data-bx-id='datepicker-display'])[1]"));
            deadlineBtn.click();
            Driver.closeDriver();
        }
        @Test (priority = 4)
        public void timePlanButton(){

            //Users can check Time Planning by using date pickers (checkbox)

            Driver.getDriver().get(ConfigurationReader.getProperty("env"));
            WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
            username.sendKeys(ConfigurationReader.getProperty("username3"));
            WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
            password.sendKeys(ConfigurationReader.getProperty("password"));
            WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
            loginBtn.click();
            WebElement taskBtn = Driver.getDriver().findElement(By.xpath("(//span[.='Task']) [2]"));
            taskBtn.click();

            WebElement timePlanBtn =Driver.getDriver().findElement(By.xpath("//span[@class='task-dashed-link task-dashed-link-terms task-dashed-link-add']"));
            timePlanBtn.click();

            Driver.closeDriver();


        }




    }

