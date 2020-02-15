package ru.znakarik.steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import ru.znakarik.pages.BasketPage;

public class BasketSteps extends BaseSteps {

    BasketPage basketPage = new BasketPage();

    @Step("товар '{0}' найден в корзине")
    public void stepCheckProduct(String productName) {
        Assert.assertTrue( basketPage.productExist(productName),"Не найден продукт - " + productName);
    }

    @Step("товар '{0}' найден в корзине")
    public void stepCheckTotalAmount(String expectedAmount){
        Assert.assertEquals(String.format("Итоговая сумма не равна значению %s. Получено значение %s", expectedAmount, basketPage.getTotalAmount()),
                expectedAmount, basketPage.getTotalAmount());
    }
}

