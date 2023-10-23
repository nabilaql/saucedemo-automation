package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import java.time.Duration;

public class Steps {
    static WebDriver driver;
    @Given("I Open Browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("Current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver.exe");
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

    @And("I enter null password")
    public void iEnterNullPassword() {
        driver.findElement(By.name("password")).sendKeys("null");
        //driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @Then("Redirected to homepage")
    public void redirectedToHomepage() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed();
        driver.close();
        driver.quit();
    }
    @And("Click Login")
    public void clickLogin() {
        driver.findElement(By.name("login-button")).click();
    }
    @Then("verify user failed login")
    public void userFailedLogin() {
        driver.findElement(By.className("error-button")).isDisplayed();
        driver.close();
        driver.quit();
    }
    @And("Click menu button")
    public void clickMenuButton() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("Click logout")
    public void clickLogout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("verify logout successfully")
    public void verifyLogoutSuccessfully() {
        driver.findElement(By.id("login-button")).isDisplayed();
        driver.close();
        driver.quit();
    }


    @When("Click filter menu")
    public void clickFilterMenu() {
        WebElement filterMenu = driver.findElement(By.className("product_sort_container"));
        filterMenu.click();
    }

    @And("Click Name\\(Z to A)")
    public void clickNameZToA() {
        WebElement filter = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]"));
        filter.click();
    }

    @Then("verify success filtering")
    public void verifySuccessFiltering() {
        WebElement confirmFilter = driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div"));
    }

    @When("Click product")
    public void clickProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));

        WebElement addtocart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addtocart.click();
    }

    @And("Click shoping cart")
    public void clickShopingCart() {
        WebElement shoppingcart = driver.findElement(By.id("shopping_cart_container"));
        shoppingcart.click();
    }

    @And("Click checkout")
    public void clickCheckout() {
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();
    }

    @And("Input firstname")
    public void inputFirstname() {
        WebElement firstname = driver.findElement(By.id("first-name"));
        firstname.sendKeys("Nabila");
    }

    @And("Input lastname")
    public void inputLastname() {
        WebElement lastname = driver.findElement(By.id("last-name"));
        lastname.sendKeys("Qonitah");
    }

    @And("Input postal code")
    public void inputPostalCode() {
        WebElement postalcode = driver.findElement(By.id("postal-code"));
        postalcode.sendKeys("66223");
    }

    @And("Click continue")
    public void clickContinue() {
        WebElement btncontinue = driver.findElement(By.id("continue"));
        btncontinue.click();
    }

    @And("Click finish")
    public void clickFinish() {
        WebElement btnfinish = driver.findElement(By.id("finish"));
        btnfinish.click();
    }

    @Then("verify success checkout result")
    public void verifySuccessCheckoutResult() {
        ExpectedConditions.presenceOfElementLocated(By.id("checkout_complete_container"));
        System.out.println("checkout Sukses");
    }

    @And("add product to cart")
    public void addProductToCart() {
        WebElement product_add = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        product_add.click();
    }

    @Then("see product added to cart")
    public void seeProductAddedToCart() {
        WebElement cart = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertEquals("1", cart.getText());
    }
}
