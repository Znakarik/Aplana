package main.java.ru.znakarik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.znakarik.steps.BaseSteps;

public class MortgagePage {

    /** Есть зарплатная карта Сбербанка */
    @FindBy(xpath = "//input[@data-test-id='paidToCard' and @class='dcCalc_switch__input']/following-sibling::span[@class='dcCalc_switch__control']")
    public WebElement isSberCardSwitch;

    /** Iframe */
    @FindBy(xpath = "//iframe[@title]")
    public WebElement iframe;

    /** Есть возможность подтвердить доход справкой */
    @FindBy(xpath = "//input[@data-test-id='canConfirmIncome' and @class='dcCalc_switch__input']/following-sibling::span[@class='dcCalc_switch__control']")
    public WebElement isCertificateSwitch;

    /** Молодая семья */
    @FindBy(xpath = "//input[@data-test-id='youngFamilyDiscount' and @class='dcCalc_switch__input']/following-sibling::span[@class='dcCalc_switch__control']")
    public WebElement isYoungFamily;


    public WebElement clearField(String fieldName){
        WebElement element = getElementByName(fieldName);
        for (int i = 0; i < 15 ; i++) {
            element.sendKeys(Keys.chord(Keys.BACK_SPACE));
        }
        return element;
    }

    public void sendKeys(String fieldName, String key) throws InterruptedException {
        WebElement element = clearField(fieldName);
        element.sendKeys(key);
    }

    public WebElement getElementByName(String name) {
        return BaseSteps.getDriver().findElement(By.xpath("//div[contains(text(),'" + name + "')]/..//input[@class='dcCalc_textfield__input']"));
    }

    public void initFrame() {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", new BuyingHousePage().iframe);
        BaseSteps.getDriver().switchTo().frame(new MortgagePage().iframe);
    }
}
