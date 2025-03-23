package coldplay.automation.stepdefinitions;

import coldplay.automation.hooks.Hooks;
import coldplay.automation.pages.Home;
import coldplay.automation.util.PropertyReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TourSteps {
    WebDriver driver = Hooks.getDriver();
    Home home = new Home(driver);

    @Given("I navigate to coldplay home page")
    public void i_navigate_to_coldplay_home_page() {
        driver.get(PropertyReader.getProperty("homepage.url"));
    }

    @When("I click on tour page")
    public void i_click_on_tour_page() {
        home.goToTourPage();
    }

    @Then("I should see a list of upcoming tour dates")
    public void i_should_see_a_list_of_upcoming_tour_dates() throws InterruptedException {
        Assert.assertEquals(PropertyReader.getProperty("tour.page.title"), driver.getTitle());
        driver.findElement(By.xpath(PropertyReader.getProperty("tour.page.all.date.locator"))).click();
        Thread.sleep(5000);
    }

    @Then("I should see all the concerts are sold out")
    public void i_should_see_all_the_concerts_are_sold_out(){
        Integer numberOfConcerts = driver.findElements(By.xpath("//a[starts-with(@href,'https://www.coldplay.com/tour-date/')]")).size();
        for (int i=1;i<=numberOfConcerts;i++){
            String venue = driver.findElement(By.xpath("((//a[starts-with(@href,'https://www.coldplay.com/tour-date/')])["+i+"]/div)[2]/h4")).getText();
            if ("Rogers Stadium".equalsIgnoreCase(venue)){
                String availability = driver.findElement(By.xpath("(//div[@class='tour-card__button-wrapper grid-inner'])["+i+"]/span")).getText();
                Assert.assertEquals(availability,"SOLD OUT");
            }
        }
    }
}
