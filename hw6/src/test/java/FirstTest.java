import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import util.NumberUtil;

public class FirstTest extends BaseTest {

    @Test
    public void PagesTest() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 30);
        final WebDriverWait wait = new WebDriverWait(driver,5);

//        1. открыть dns-shop
        driver.navigate().to(properties.getProperty("app.url"));

        final MainPage mainPage = new MainPage(driver);
//        2. в поиске найти playstation
        mainPage.searchField.sendKeys("playstation");
//        3. кликнуть по playstation 4 slim black
        mainPage.playstation.click();

        final SearchPage searchPage = new SearchPage(driver);
        wait.until(ExpectedConditions.visibilityOf(searchPage.itemTitle));

        // Кликаем на title товара и переходим на ItemPage
        searchPage.itemTitle.click();

        ItemPage itemPage = new ItemPage(driver);

//        4. запомнить цену
//        final String priceValue = driver.findElement(By.xpath("//div[@class='product-price__current']")).getText();
//        System.out.println(NumberUtil.parseInt(priceValue));

        Integer playstationPrice1 = NumberUtil.parseInt(itemPage.price.getText());
        System.out.println(playstationPrice1);
//        5. Доп.гарантия - выбрать 2 года
        // Select блин

        itemPage.selectGuarantee.sendKeys("2");
        Integer playstationPrice2 = NumberUtil.parseInt(itemPage.price.getText());
        System.out.println(playstationPrice2);

        if (true) return;

//        6. дождаться изменения цены и запомнить цену с гарантией

        // Создаем и инициализиуем обьект Product
        itemPage.initItem();
        //Запоминаем цену с гарантией, нажатие на Select не реализовано
//        Integer playstationPrice2 = Integer.parseInt(itemPage.price.getText().replaceAll(" ", "").trim());

//        7. Нажать Купить
        itemPage.buyButton.click();

        Integer playstationPrice3 = Integer.parseInt(itemPage.price.getText().replaceAll(" ", "").trim());
//        System.out.println(playstationPrice2);
//        Assert.assertEquals(playstationPrice1, playstationPrice2);

//        System.out.printf("Цена на плейстейшн из выдачи поиска: %s\nЦена после добавления в корзину: %s\nЦена после изменения условий по гарантии: %s\n", playstationPrice1, playstationPrice2, playstationPrice3);
//        8. выполнить поиск Detroit
        mainPage.searchField.sendKeys("Detroit\n");

//        9. запомнить цену
        Integer detroiPrice = Integer.parseInt(itemPage.price.getText().replaceAll(" ", "").trim());

        // Cоздаем еще один обьект Product
        itemPage.initItem();

//        10. нажать купить
        itemPage.buyButton.click();

//        11. проверить что цена корзины стала равна сумме покупок
        Thread.sleep(1500); // ждем, пока динамический обьект цены корзины отрендерится
//        11. Проверить что цена корзины стала равна сумме покупок
        Assert.assertEquals(Integer.parseInt(itemPage.basketPrice.getText().replaceAll(" ", "").trim()), playstationPrice1 + detroiPrice);

//        12. перейти в корзину
        itemPage.basketPrice.click();

        BasketPage basketPage = new BasketPage(driver);

        // В мапу кладем товары - цена, имя
        basketPage.setItems();
        // Смотрим, правильно ли положилось
        basketPage.printItems();
        System.out.println("==========");
        // Смотрим, правильно ли заполнились поля обьектов Product ранее
        Product.getProductList();

//        13. проверить, что для приставки выбрана гарантия на 2 года - не реализовано

//        14. проверить цену каждого из товаров и сумму
        basketPage.checkParameters();

//        15. удалить из корзины Detroit


//        16. проверить что Detroit нет больше в корзине и что сумма уменьшилась на цену Detroit
//        17. добавить еще 2 playstation (кнопкой +) и проверить что сумма верна (равна трем ценам playstation)
//        18. нажать вернуть удаленный товар, проверить что Detroit появился в корзине и сумма увеличилась на его значение

        //div[@class='cart-items__product-thumbnail cart-items__product-thumbnail_product']//div[@class='cart-items__product-name']//a[contains(text(),'приставка')]

    }
}
