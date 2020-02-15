package ru.znakarik.steps;

import io.qameta.allure.Step;
import ru.znakarik.pages.MainPage;

public class MainSteps extends BaseSteps {

    MainPage mainPage = new MainPage();

    @Step("выбран пункт главного меню - {0}")
    public void stepSelectMenuItem(String itemName) {
        mainPage.selectMenuItem(itemName);
    }

    @Step("в Меню Доставки выбран пункт - {0}")
    public void stepSelectMenuCategory(String item) {
        mainPage.selectSubMenuItem(item);
    }

    @Step("выполнен переход в корзину")
    public void stepGoToBasket() {
        mainPage.basket.click();
    }
}
