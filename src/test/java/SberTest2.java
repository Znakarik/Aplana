import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SberTest2 {

    static WebDriver webDriver = null;

    @BeforeClass
    public static void TestUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver");

        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public static void CleanUp() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void Sber() throws InterruptedException {
        webDriver.get("http://www.sberbank.ru/ru/person");

        WebDriverWait wait = new WebDriverWait(webDriver, 30);
//
////      2.Нажать на – Страхование
        WebElement webElement = webDriver.findElement(By.xpath("//span[contains(text(),'Страхование')]"));
//
////      3.Выбрать – Путешествие и покупки
        WebElement webElement1 = webDriver.findElement(By.xpath("//li[contains(@class,'lg-menu__sub-item')]/a[contains(text(),'Страхование путешественников')]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        webElement.click();
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement1);
        webElement1.click();

//      4.Проверить наличие на странице заголовка – Страхование путешественников

//        webDriver.get("https://www.sberbank.ru/ru/person/bank_inshure/insuranceprogram/life/travel");
        WebElement title = webDriver.findElement(By.xpath("//div[contains(@class,'kit-col kit-col_xs_0 kit-col_md_6 kit-col_lg_0 kit-col_md-bottom_10 kit-col_md-top_0')]/h2[contains(text(),'Страхование путешественников')]"));
        Assert.assertEquals("Страхование путешественников", title.getAttribute("innerHTML"));

//      5. Нажать на – Оформить Онлайн
        WebElement webElement2 = webDriver.findElement(By.xpath("//a[contains(@class,'kit-button  kit-button_default kit-button_type_big analytics-button')]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement2);
        webElement2.click();

//      6. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        webDriver.findElement(By.xpath("//div[contains(@class,'online-card-program')]/h3[contains(text(),'Минимальная')]")).click();
//
//      7. Нажать Оформить
        WebElement button = webDriver.findElement(By.xpath("//button[contains(text(),'Оформить')]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
//
//      8. На вкладке Оформить заполнить поля:
//          1) Фамилию и Имя, Дату рождения застрахованных
        webDriver.findElement(By.xpath("//input[contains(@placeholder,'Surname')]")).click();
        webDriver.findElement(By.xpath("//input[contains(@placeholder,'Surname')]")).sendKeys("Znakarik");
//
        webDriver.findElement(By.xpath("//input[contains(@placeholder,'Name')]")).sendKeys("Znakarik");

        webDriver.findElement(By.xpath("//input[contains(@id,'birthDate_vzr_ins_0')]")).sendKeys("31.10.1996");
//          2) Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол

        webDriver.findElement(By.xpath("//input[contains(@id,'person_lastName')]")).click();
        webDriver.findElement(By.xpath("//input[contains(@id,'person_lastName')]")).sendKeys("Знакарик");

        webDriver.findElement(By.xpath("//input[contains(@id,'person_firstName')]")).sendKeys("Знакарик");

        webDriver.findElement(By.xpath("//input[contains(@id,'person_middleName')]")).sendKeys("Знакарик");

        webDriver.findElement(By.xpath("//input[contains(@id,'person_birthDate')]")).sendKeys("30.10.1996");

        webDriver.findElement(By.xpath("//label[contains(text(),'Женский')]")).click();

//        //Паспортные данные
        webDriver.findElement(By.xpath("//input[contains(@id,'passportSeries')]")).sendKeys("3110");
        webDriver.findElement(By.xpath("//input[contains(@id,'passportNumber')]")).sendKeys("100000");
        webDriver.findElement(By.xpath("//input[contains(@id,'documentDate')]")).sendKeys("30102016");

        webDriver.findElement(By.xpath("//input[contains(@id,'documentIssue')]")).click();
        webDriver.findElement(By.xpath("//input[contains(@id,'documentIssue')]")).sendKeys("РГУ им Косыгина");
//       Контактные данные не заполняем

//        9. Проверить, что все поля заполнены правильно - визуально?

//      10.   Нажать продолжить
        webDriver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();
//      11. Проверить, что появилось сообщение - Заполнены не все обязательные поля
        Assert.assertEquals("При заполнении данных произошла ошибка", webDriver.findElement(By.xpath("//div[contains(@class,'alert-form alert-form-error')]")).getText());
    }
}
