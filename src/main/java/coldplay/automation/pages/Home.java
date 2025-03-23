package coldplay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home {
    private By tour = By.xpath("//a[@href='https://www.coldplay.com/tour/']");

    private By rejectCookie = By.id("onetrust-reject-all-handler");
    private WebDriver driver;
    WebDriverWait wait;

    public Home(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToTourPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(rejectCookie));
        driver.findElement(rejectCookie).click();
        wait.until(ExpectedConditions.elementToBeClickable(tour));
        driver.findElement(tour).click();
    }
}


