package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;
    @Given("I Open Browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("Current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @And("Open the login page of saucedemo")
    public void openTheLoginPageOfSaucedemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo")
    public void locatedOnSaucedemo() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("I enter valid username")
    public void iEnterValidUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("I enter valid password")
    public void iEnterValidPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @And("Click Login")
    public void clickLogin() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("Redirected to homepage")
    public void redirectedToHomepage() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed();
        driver.close();
        driver.quit();
    }


}
