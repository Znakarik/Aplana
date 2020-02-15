package main.java.ru.znakarik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.znakarik.steps.BaseSteps;

import java.util.List;

public class MainPage extends ru.znakarik.pages.BasePage {

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class='lg-menu__list']//span[contains(text(),'')]")
    public List<WebElement> topMenu;

    @FindBy(xpath = "//li[@class='lg-menu__sub-item']//a")
    public List<WebElement> subMenu;

    public void selectSubMenu(List<WebElement> list, String name) {
        for (WebElement element : list) {
            if (element.getText().contains(name)) {
                element.click();
                return;
            }
        }
    }
}
