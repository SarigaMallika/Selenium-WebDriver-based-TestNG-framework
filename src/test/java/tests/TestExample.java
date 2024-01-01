package tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExample {

    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(TestExample.class);
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Setting up the test...");
    }

    @Test(dataProvider = "searchQueries")
    public void testGoogleSearch(String searchQuery) {
        driver.get("https://www.google.com");

        // Locate the search input field
        WebElement searchInput = driver.findElement(By.name("q"));

        // Enter the search query
        searchInput.sendKeys(searchQuery);

        // Press Enter to perform the search
        searchInput.sendKeys(Keys.RETURN);

        // Wait for some time (you might want to use explicit waits in a real scenario)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get and print the search results
        WebElement searchResults = driver.findElement(By.id("search"));
        System.out.println("Search results for '" + searchQuery + "':\n" + searchResults.getText());
        logger.info("Searching sing search  param");
    }


    @DataProvider(name = "searchQueries")
    public Object[][] getSearchQueries() {
        return new Object[][] {
                {"TestNG"},
                {"Selenium"},
                {"Automation"}
                // Add more data as needed
        };
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("Tear down...");
    }
}
