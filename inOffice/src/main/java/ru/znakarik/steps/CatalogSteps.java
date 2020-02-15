package ru.znakarik.steps;

import io.qameta.allure.Step;
import ru.znakarik.pages.CatalogPage;

public class CatalogSteps extends BaseSteps{

    CatalogPage catalogPage = new CatalogPage();

    @Step("в корзину добавлен - {0}")
    public void stepAddProduct(String productName){
        catalogPage.addProduct(productName);
    }
}
