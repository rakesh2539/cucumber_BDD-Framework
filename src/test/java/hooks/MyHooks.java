package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;

public class MyHooks {
    
    // WebDriver instance
    public static WebDriver driver;
    
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        
        // Setup Extent Reports and initialize tests
    }

    // After hook - Runs after each scenario
    @After
    public void tearDown(Scenario scenario) throws IOException {
        boolean failed = scenario.isFailed();
        System.out.println("Is the test failed: " + failed);

        if (failed) {
            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File sourceFile = ts.getScreenshotAs(OutputType.FILE);

            // Create a dynamic filename using scenario name or timestamp to prevent overwriting
            String fileName = scenario.getName() + "_" + System.currentTimeMillis() + ".png";
            String screenshotDir = System.getProperty("user.dir") + File.separator + "Screenshot" + File.separator;
            File targetFile = new File(screenshotDir + fileName);

            // Create directories if they do not exist
            targetFile.getParentFile().mkdirs();

            // Copy the screenshot to the target location
            FileUtils.copyFile(sourceFile, targetFile);
            
            // Print the file path of the screenshot
            System.out.println("Screenshot saved at: " + targetFile.getAbsolutePath());
        }

        // Quit the driver after test execution
        driver.quit();
    }

}
