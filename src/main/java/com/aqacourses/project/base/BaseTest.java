package com.aqacourses.project.base;

import com.aqacourses.project.pages.HomePage;
import com.aqacourses.project.utils.YamlParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseTest {

    // Instances of WebDriver and WebDriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor
     */
    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Return instance of Driver
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Open site and return instance of HomePage
     *
     * @return HomePage
     */
    public HomePage openSite() {
        driver.get(YamlParser.getYamlData().getUrl());
        return new HomePage(this);
    }

    /**
     * Close site with driver.quit()
     */
    public void closeSite() {
        driver.quit();
    }

    /**
     * Wait till element is visible
     *
     * @param element
     */
    public void waitTillElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait till list of elements are visible
     *
     * @param elements
     */
    public void waitTillListOfElementsAreVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

}
