package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.NumberUtil;

import java.util.*;

@Getter
public class BasketPage extends BasePage {
//        @FindBy(xpath = "//div[(@class='cart-items__product-thumbnail cart-items__product-thumbnail_product')]")

    @FindBy(xpath = "//div[contains(@class,'cart-items__products')]//span[contains(@class,'price__current')]")
    public List<WebElement> prices;

    @FindBy(xpath = "//div[@class='cart-items__product-name']")
    public List<WebElement> names;

    @FindBy(xpath = "//div[@class='list-applied-product-services__item']//span[contains(text(),'24')]")
    public WebElement twoYearGuarantee;

    @FindBy(xpath = "//div[@class='cart-items__product']")
    public WebElement items;

    public void delete(String name) {
        WebElement deleteButton;
        WebElement names = items.findElement(By.xpath("//div[@class='cart-items__product-name']//a[contains(text(),'" + name + "')]"));
        WebElement parentOfNamesAndDelete = items.findElement(By.xpath("//div[@class='cart-items__product-name']//a[contains(text(),'" + name + "')]/parent::div"));
        if (names.isDisplayed()) {
            deleteButton = parentOfNamesAndDelete.findElement(By.xpath("//div[@class='cart-items__product']//div[@class='cart-items__product-price']//span[@class='price__current' and contains(text(),'34')]"));
            deleteButton.click();
        }
    }

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<Product> getProducts() {
        final List<Product> products = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            final Product product = new Product();
            product.setName(names.get(i).getText());
            product.setPrice(NumberUtil.parseInt(prices.get(i).getText()));
            products.add(product);
        }
        return products;
    }
}
