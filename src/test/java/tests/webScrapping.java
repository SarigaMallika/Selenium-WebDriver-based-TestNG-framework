package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class webScrapping{
        private WebDriver driver;

        @BeforeTest
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        @Test
        public void webScrapingTest() throws IOException {
            // Navigate to the website you want to scrape
            driver.get("https://www.google.com/");

            // Extract HTML content using JSoup
            String htmlContent = driver.getPageSource();
            //web page is typically a raw, unstructured text. Parsing it into a structured representation, such as a JSoup Document object, makes it easier to navigate and access specific elements
            Document document = Jsoup.parse(htmlContent);

            // Example: Extracting and printing all links.  using a[href] css selecor
            for (Element link : document.select("a[href]")) {
                System.out.println("Link: " + link.attr("href"));
            }
        }

        @AfterTest
        public void tearDown() {
            // Close the WebDriver instance
            if (driver != null) {
                driver.quit();
            }
        }

}
