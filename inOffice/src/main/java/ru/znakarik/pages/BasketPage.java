package ru.znakarik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {

    @FindBy(xpath = "//td[@class='product-name']//a[text()]")
    List<WebElement> collectionCart = new ArrayList<>();

    @FindBy(xpath = "//span[@id='cartPrice']")
    WebElement totalPrice;

    public boolean productExist(String productName) {
        for (WebElement product : collectionCart) {
            if (isElementPresent(product) && product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public String getTotalAmount() {
        return totalPrice.getText().replaceAll("\u20BD","");
    }


}
