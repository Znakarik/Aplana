import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import pages.CartPage;
import pages.MainPage;

public class CUTest extends BaseTest {

    @Test
    public void  cuTest(){
        driver.navigate().to(properties.getProperty("app.url"));

        MainPage mainPage = new MainPage(driver);
        mainPage.searchField.sendKeys("macbook");
        mainPage.button.click();
        mainPage.addToCart.click();
        String price = mainPage.price.getText();
        CartPage cartPage = new CartPage(driver);

        String price2 = cartPage.price.getText();
        Assert.assertEquals(price,price2);

        ((Select)cartPage.quantity).selectByIndex(2);
    }
}
