package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

    private WebDriver driver;

    //locators
    private By checkoutButton =By.id("checkout");
    private By firstNameField=By.id("first-name");
    private By lastNameField=By.id("last-name");
    private By postalCodeField=By.id("postal-code");
    private By continueButton=By.id("continue");
    private By finishButton=By.id("finish");
    private By completeHeader=By.className("complete-header");

    public CheckOutPage(WebDriver driver) {
        this.driver=driver;
    }
    //Actions
    public void clickCheckout(){
        driver.findElement(checkoutButton).click();
    }
    public void fillInfoForm(String firstname, String lastname, String postalcode){
        driver.findElement(firstNameField).sendKeys(firstname);
        driver.findElement(lastNameField).sendKeys(lastname);
        driver.findElement(postalCodeField).sendKeys(postalcode);
    }
    public void clickContinue(){
        driver.findElement(continueButton).click();
    }
    public void clickFinish(){
        driver.findElement(finishButton).click();
    }
    public void clearForm(){
        driver.findElement(firstNameField).clear();
        driver.findElement(lastNameField).clear();
        driver.findElement(postalCodeField).clear();
    }
    public String getConfirmationMessage(){
        return driver.findElement(completeHeader).getText();
    }

}
