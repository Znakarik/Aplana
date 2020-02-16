package ru.znakarik.steps;

import cucumber.api.java.ru.Когда;
import io.qameta.allure.Step;
import main.java.ru.znakarik.pages.MainPage;
import org.openqa.selenium.By;


public class MainPageSteps {
    MainPage mainPage = new MainPage();

    @Step("Нажимаем на \"Ипотека\"")
    public void selectTopMenu(String name) throws InterruptedException {
        new MainPage().selectSubMenu(mainPage.topMenu,name);
    }

    @Step("Нажимаем на \"Ипотека на готовое жильё\"")
    public void selectSubMenu(String name) throws InterruptedException {
        new MainPage().selectSubMenu(mainPage.subMenu,name);
    }
}
