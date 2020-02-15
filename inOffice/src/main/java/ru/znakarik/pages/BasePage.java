package ru.znakarik.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.znakarik.steps.BaseSteps;

import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver = BaseSteps.getDriver();

    /** Для того, чтобы инициализировать элементы */
    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    /** Изучить */
    public boolean isElementPresent(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    /** Изучить */
    public boolean isElementPresent(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    /** Изучить */
    public void fillField(WebElement element, String value)  {
        element.clear();
        element.sendKeys(value);
    }

    /** Изучить */
    public void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        Wait<WebDriver> wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
