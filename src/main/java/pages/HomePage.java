
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By countrySelectButton = By.className("country-name");
    private By countryButton = By.xpath("//*[@id=\"country-selct\"]/a/div");
    private By subscriptionPackage  = By.className("trial-description");
    private By subscriptionPriceAndCurrency  = By.className("trial-cost");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void countrySelectClicker(){
        driver.findElement(countrySelectButton).click();
    }
    public void countrySelection(){
        driver.findElement(countryButton).click();
    }
    public String getSubscriptionPackage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(subscriptionPackage)));
        return driver.findElement(subscriptionPackage).getText();
    }
    WebElement costElement = driver.findElement(subscriptionPriceAndCurrency);
    String costText = costElement.getText();
    public String getPrice(){
        WebElement costElement1= costElement;
        String price = costText.substring(costText.indexOf("<b>") + 3, costText.indexOf("</b>")).trim();
        return price;
    }
    public String getCurrency(){
        WebElement costElement1= costElement;
        String price = costText.substring(costText.indexOf("<b>") + 3, costText.indexOf("</b>")).trim();
        String currency  = costText.substring(costText.indexOf(price) + price.length()).trim();
        return currency ;
    }
}