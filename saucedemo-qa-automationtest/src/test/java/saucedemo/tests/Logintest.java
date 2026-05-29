package saucedemo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import saucedemo.pages.LoginPage;

import java.time.Duration;

public class Logintest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com/");
        loginPage =new LoginPage(driver);
    }
    //valid username with valid password
    @Test(priority=1)
    public void testSucessLogin(){
        loginPage.login("standard_user","secret_sauce");
        String expected="https://www.saucedemo.com/inventory.html";
       Assert.assertEquals(driver.getCurrentUrl(),expected,"Login Failed:URL mismatched");
    }
     //valid username with invalid password
     @Test(priority = 2)
     public void testFailLogin(){
         // locked out user (correct casing)
         loginPage.login("locked_out_user","secrets_sauce");
         // Login should fail and stay on login page
         String expectedUrl="https://www.saucedemo.com/";
         Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"Should remain on login page");
     }
     //invalid username with valid password
     @Test(priority = 3)
     public void testFailLogina(){
         // invalid username
         loginPage.login("hero_user","secret_sauce");
         // Login should fail and stay on login page
         String expectedUrl="https://www.saucedemo.com/";
         Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"Should remain on login page");
     }
     //empty field with valid password
     @Test(priority = 4)
     public void testFailLoginb(){
         // empty username
         loginPage.login("","secret_sauce");
         // Login should fail and stay on login page
         String expectedUrl="https://www.saucedemo.com/";
         Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"Should remain on login page");
     }
     //valid username with emptyfield
     @Test(priority = 5)
     public void testFailLoginc(){
         // empty password
         loginPage.login("standard_user","");
         // Login should fail and stay on login page
         String expectedUrl="https://www.saucedemo.com/";
         Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"Should remain on login page");
     }

    @AfterMethod
    public void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
