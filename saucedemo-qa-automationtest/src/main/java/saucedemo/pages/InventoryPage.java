package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
        private WebDriver driver;


       private By firstProductAddToCartButton=By.id("add-to-cart-sauce-labs-backpack");
       private By shoppingCartLink=By.className("shopping_cart_link");
       private By shoppingCartBadge=By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver){
            this.driver=driver;
    }

    //Actions

    public void addFirstProductToCart(){
        driver.findElement(firstProductAddToCartButton).click();
    }

    public String getCartBadgeCount(){
         return driver.findElement(shoppingCartBadge).getText();
    }

    public void gotoCart(){
        driver.findElement(shoppingCartLink).click();
    }

}
