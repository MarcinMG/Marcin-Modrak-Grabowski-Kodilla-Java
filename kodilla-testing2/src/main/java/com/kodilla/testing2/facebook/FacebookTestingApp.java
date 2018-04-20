package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_WAIT_FOR = "//select[@name=\"birthday_year\"]";
    public static final String XPATH_FIRSTNAME = "//input[@name=\"firstname\"]";
    public static final String XPATH_DAY = "//select[@name=\"birthday_day\"]";
    public static final String XPATH_MONTH = "//select[@name=\"birthday_month\"]";
    public static final String XPATH_YEAR = "//select[@name=\"birthday_year\"]";


    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement textareaField = driver.findElement(By.xpath(XPATH_FIRSTNAME));
        textareaField.sendKeys("imie");

        WebElement selectComboDay = driver.findElement(By.xpath(XPATH_DAY));
        Select selectBoardDay = new Select(selectComboDay);
        selectBoardDay.selectByIndex(1);

        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectBoardMonth = new Select(selectComboMonth);
        selectBoardMonth.selectByIndex(1);

        WebElement selectComboYear = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectBoardYear = new Select(selectComboYear);
        selectBoardYear.selectByIndex(1);
    }
}
