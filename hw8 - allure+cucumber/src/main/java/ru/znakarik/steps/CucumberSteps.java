package ru.znakarik.steps;

import cucumber.api.java.ru.Когда;
import main.java.ru.znakarik.pages.MainPage;
import org.openqa.selenium.By;
import main.java.ru.znakarik.pages.MainPage;
import ru.znakarik.steps.MainPageSteps;
import ru.znakarik.steps.MortgagePageSteps;


public class CucumberSteps {
    public MainPage mainPage;

    @Когда("Переходим на главную страницу СБербанка")
    public void goToMainSberPage() {
        mainPage = new MainPage();
    }

    @Когда("Нажимаем на \"(.+)\"$")
    public void touchMortgage(String name) throws InterruptedException {
        new MainPageSteps().selectTopMenu(name);
    }

    @Когда("В открывшемся меню выбрать \"(.+)\"$")
    public void selectSubItem(String name) throws InterruptedException {
        new MainPageSteps().selectSubMenu(name);
    }

    @Когда("^Заполнить поле \"Стоимость недвижимости\" \"(.+)\" ₽$")
    public void fillPropertyValue(String amount) throws InterruptedException {
        new MortgagePageSteps().fillFirstField(amount);
    }

    @Когда("Заполнить поле \"Первоначальный взнос\" \"(.+)\" ₽$")
    public void fillFirstPayField(String amount) throws InterruptedException {
        new MortgagePageSteps().fillFirstPayField(amount);
    }

    @Когда("Заполнить поле \"Срок кредита\" \"(.+)\" лет$")
    public void fillTermMort(String amount) throws InterruptedException {
        new MortgagePageSteps().fillYears(amount);
    }

    @Когда("Снять галочку - \"Есть зарплатная карта сбербанка\"")
    public void turnIsSberSwitch() {
        new MortgagePageSteps().turnIsSberSwitch();
    }

    @Когда("Дождаться появления \"Есть возможность подтвердить доход справкой\"")
    public void waitForIsCertificateSwitch() {
        new MortgagePageSteps().waitForIsCertificateSwitch();
    }

    @Когда("Поставить галочку \"Молодая семья\"")
    public void clickSwitchYoungFamily() {
        new MortgagePageSteps().clickSwitchYoungFamily();
    }
}
