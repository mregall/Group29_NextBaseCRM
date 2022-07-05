package nextBaseCRM.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber-report.json"
        },
        features = "src/test/resources/features",
        glue = "nextBaseCRM/step_definitions",
        dryRun = false,
        tags = ""
)
public class NextBaseRunner {
}
