package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//select[contains(@class,'qty-input at__quantityselect')]")
    public WebElement quantity;

    @FindBy(xpath = "//td[contains(@class,'subtotal at__subtotalprice')]")
    public WebElement price;

}
