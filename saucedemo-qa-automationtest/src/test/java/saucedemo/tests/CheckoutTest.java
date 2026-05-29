package saucedemo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By; // Added for explicit error locating
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import saucedemo.pages.CheckOutPage;
import saucedemo.pages.InventoryPage;
import saucedemo.pages.LoginPage;

import java.time.Duration;

public class CheckoutTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CheckOutPage checkOutPage;

    @BeforeMethod
    public void checkOutSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com/");

        // Initializing pages
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkOutPage = new CheckOutPage(driver);

        // For checkout flow we need to login first
        loginPage.login("standard_user", "secret_sauce");
    }

    // Case 1:- Testing the product is added to the cart
    @Test(priority = 1)
    public void testAddProductToCart(){
        inventoryPage.addFirstProductToCart();
        inventoryPage.gotoCart();
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1", "Product was not added successfully");
        checkOutPage.clickCheckout();
    }

    // Case 2:- Complete checkout flow with valid details
    @Test(priority = 2)
    public void testSucessfulCheckout(){
        inventoryPage.addFirstProductToCart();
        inventoryPage.gotoCart();
        checkOutPage.clickCheckout();
        checkOutPage.fillInfoForm("ishan", "pokharel", "12345");
        checkOutPage.clickContinue();
        checkOutPage.clickFinish();

        String expectedoutcome = "Thank you for your order!";
        Assert.assertEquals(checkOutPage.getConfirmationMessage(), expectedoutcome, "Checkout failed");
    }

    // Case 3:- Negative validation test for missing First Name
    @Test(priority = 3)
    public void testMissingFirstNameValidation(){
        inventoryPage.addFirstProductToCart();
        inventoryPage.gotoCart();
        checkOutPage.clickCheckout();

        // Pass empty string for first name to trigger application validation error
        checkOutPage.fillInfoForm("", "doe", "54321");
        checkOutPage.clickContinue();


        String actualErrorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String expectedErrorOutcome = "Error: First Name is required";

        Assert.assertEquals(actualErrorMessage, expectedErrorOutcome, "Validation for empty first name missing or incorrect.");
    }

    // Case 4:- Form Interruption or cancellation
    @Test(priority = 4)
    public void testCancelCheckout(){
        inventoryPage.addFirstProductToCart();
        inventoryPage.gotoCart();
        checkOutPage.clickCheckout();
        driver.findElement(org.openqa.selenium.By.id("cancel")).click();
        String expectedUrl = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Checkout cancellation failed");
    }

    @AfterMethod
    public void stopDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}