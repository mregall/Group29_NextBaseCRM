package nextBaseCRM.step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import nextBaseCRM.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    //@Before is from Cuke.  It runs before each scenario.
    @Before
    public void setUpScenario() {
        System.out.println("This is from @Before in Hooks");
    }

    //@After also from Cuke.  It runs before each scenario.
    @After
    public void teardownScenario(Scenario scenario) {
        System.out.println("This is from @After in Hooks");

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
