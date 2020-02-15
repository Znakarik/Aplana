package ru.znakarik.steps;

import io.qameta.allure.Step;
import main.java.ru.znakarik.pages.MortgagePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ru.znakarik.pages.BasePage;
import main.java.ru.znakarik.pages.MortgagePage;

import static ru.znakarik.pages.BasePage.*;

public class MortgagePageSteps {

    MortgagePage mortgagePage = new MortgagePage();

    /**
     * Заполнить поле "Стоимость недвижимости" "5180000" ₽
     * * Заполнить поле "Первоначальный взнос" "3058000" ₽
     * * Заполнить поле "Срок кредита" "30" лет
     * * Снять галочку - "Есть зарплатная карта сбербанка"
     * * Дождаться появления "Есть возможность подтвердить доход справкой"
     * * Поставить галочку "Молодая семья"
     */
    @Step("Заполнение поля \"Стоимость недвижимости\"")
    public void fillFirstField(String amount) throws InterruptedException {
        mortgagePage.sendKeys("Стоимость недвижимости", amount);
    }

    @Step("Заполнение поля \"Первоначальный взнос\"")
    public void fillFirstPayField(String amount) throws InterruptedException {
        mortgagePage.sendKeys("Первоначальный взнос", amount);
    }

    @Step("Заполнение поля \"Срок кредита\"")
    public void fillYears(String amount) throws InterruptedException {
        mortgagePage.sendKeys("Срок кредита", amount);
    }

    @Step("Снятие галочки - \"Есть зарплатная карта сбербанка\"")
    public void turnIsSberSwitch() {
//        wait.until(ExpectedConditions.elementToBeClickable(new BuyingHousePage().isSberCardSwitch));
        click(new MortgagePage().isSberCardSwitch);
    }

    @Step("выполнено дождаться появления \"есть возможность подтвердить доход справкой\"")
    public void waitForIsCertificateSwitch() {
        Assert.assertTrue("Поле \"есть возможность подтвердить доход справкой\" не появилось", new MortgagePage().isCertificateSwitch.isDisplayed());
    }

    @Step("выполнено поставить галочку \"молодая семья\"")
    public void clickSwitchYoungFamily() {
        click(new MortgagePage().isYoungFamily);
    }

}
