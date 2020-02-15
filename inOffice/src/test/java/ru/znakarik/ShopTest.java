package ru.znakarik;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runners.Suite;
import ru.znakarik.steps.BaseSteps;
import ru.znakarik.steps.BasketSteps;
import ru.znakarik.steps.CatalogSteps;
import ru.znakarik.steps.MainSteps;

@Suite.SuiteClasses(BaseSteps.class)
public class ShopTest extends BaseSteps {

    @Test
    @DisplayName("Заказ в чайхоне")
    public void Test() {
        MainSteps mainSteps = new MainSteps();
        CatalogSteps catalogSteps = new CatalogSteps();
        BasketSteps basketSteps = new BasketSteps();

        mainSteps.stepSelectMenuItem("Меню доставки");
        mainSteps.stepSelectMenuCategory("Выпечка");
        catalogSteps.stepAddProduct("Пичча нон с сыром");

        mainSteps.stepSelectMenuItem("Меню доставки");
        mainSteps.stepSelectMenuCategory("Бургеры и Шаурма");
        catalogSteps.stepAddProduct("Шаурма с курицей");

        mainSteps.stepSelectMenuItem("Меню доставки");
        mainSteps.stepSelectMenuCategory("Плов");

        catalogSteps.stepAddProduct("Плов Чайханский");

        mainSteps.stepGoToBasket();

        basketSteps.stepCheckProduct("Пичча нон с сыром");
        basketSteps.stepCheckProduct("Шаурма с курицей");
        basketSteps.stepCheckProduct("Плов Чайханский");

        int expectedAmount = Integer.parseInt(getVariable("Пичча нон с сыром")) + Integer.parseInt(getVariable("Шаурма с курицей")) +
                Integer.parseInt(getVariable("Плов Чайханский"));

        basketSteps.stepCheckTotalAmount(Integer.toString(expectedAmount));
    }
}
