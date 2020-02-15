package ru.znakarik.pages;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Suite;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.znakarik.steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;

@Suite.SuiteClasses(BaseSteps.class)
public class MainPage extends BasePage {

//    @FindBy(xpath = "//ul[@id='desktopMenuMain']//a[text()]")
    @FindBy(xpath = "//a[@class='type-global-nav-link-1']")
    List<WebElement> items = new ArrayList<>();

    @Test
    public void itemsTest() {
        try {
        for (WebElement webElement : items) {
            System.out.println(webElement.getText() + " это элемент");
        }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//ul[contains(@class,'main-menu__list-')]//a[text()]")
    List<WebElement> subMenuItem;

    @FindBy(xpath = "//a[@title='Перейти в корзину']")
    public WebElement basket;

    /**
     * Можно выносить в BasePage
     *
     * @param menuItem
     */
    public void selectMenuItem(String menuItem) {
        for (WebElement item : items) {
            if (item.getText().equalsIgnoreCase(menuItem)) {
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(item)).click();
                return;
            }
        }
        Assert.fail("Не найден пункт меню " + menuItem);
    }

    public void selectSubMenuItem(String nameSubMenuItem) {
        for (WebElement subMenuItem : subMenuItem) {
            if (subMenuItem.getText().equalsIgnoreCase(nameSubMenuItem)) {
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(subMenuItem)).click();
                return;
            }
        }
        Assert.fail("Не найден пункт меню - " + nameSubMenuItem);
    }
}
