package StepDef;

import Helper.Config;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class CommunStepDef {
    @After
    public void tearDown(Scenario scenario) {

        System.out.println("========== AFTER HOOK ==========");

        if (scenario.isFailed() && Config.driver != null) {

            byte[] screenshot =
                ((TakesScreenshot) Config.driver)
                .getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                screenshot,
                "image/png",
                "Failed Scenario Screenshot"
            );
        }

        if (Config.driver != null) {
            Config.driver.quit();
        }
    }



}
