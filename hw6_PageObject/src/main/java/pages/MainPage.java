package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;


public class MainPage extends BasePage {

    @FindAll({
            @FindBy(xpath = "//input[contains(@class,'autocomplete-input search-box-text at__searchfield')]")
    })
    public WebElement searchField;

    @FindBy(xpath = "//input[contains(@id,'serch-button')]")
    public WebElement button;

    @FindBy(xpath = "//div[contains(@class,'c-productItem__price c-productItem__price--current at__product-price')][1]")
    public WebElement price;

    @FindBy(xpath = "//div[contains(@class,'c-productItem js-productItem-731018 at__productitem c-productItem--inited')]")
    public WebElement productItem;

    @FindBy(xpath = "//div[@data-productid=731018]//a[contains(text(),'Add')]")
    public WebElement addToCart;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
