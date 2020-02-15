package ru.znakarik.pages;

import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.znakarik.steps.BaseSteps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogPage extends BasePage {

    @FindBy(xpath = "//ul[@class='products-grid']//*[@title]/ancestor::li")
    List<WebElement> productCollection = new ArrayList<>();

    public void addProduct(String productName) {
        String price = getProduct(productName).findElement(By.xpath(".//span[@class='price']")).getText().replaceAll("\\D", "");
        BaseSteps.setVariable(productName, price);
        getProduct(productName)
                .findElement(By.xpath(".//button[@title='Заказать']")).click();
    }

    public WebElement getProduct(final String productName) {
        for (WebElement item : productCollection) {
            if (item.findElement(By.xpath(".//a[@title]")).getAttribute("title").equalsIgnoreCase(productName)) {
                return item;
            }
        }
        Assert.fail("Не найден продукт - " + productName);
        return null;
    }
}


