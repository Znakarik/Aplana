import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SberTest {

    public static WebDriver webDriver = null;

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
    public void RGS() throws InterruptedException {
        webDriver.get("http://www.sberbank.ru/ru/person");

        WebDriverWait wait = new WebDriverWait(webDriver, 30);

        WebElement locationButton = webDriver.findElement(By.xpath("//a[@class='hd-ft-region']"));
        locationButton.click();
        webDriver.findElement(By.xpath("//div[contains(@class,'kit-col kit-col_xs_12 kit-col_lg_9 kit-col_xl_9')]/div[contains(@class,'kit-input')]/input")).sendKeys("ниже");
        ;

        webDriver.findElement(By.xpath("//a[contains(text(),'Нижего')]")).click();
        WebElement nizniy = webDriver.findElement(By.xpath("(//span[text()='Нижегородская область'])[1]"));
        Assert.assertEquals("Нижегородская область", nizniy.getText());

        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        List<WebElement> webElements = new ArrayList<>();
        webElements.add(webDriver.findElement(By.xpath("//span[contains(@class,'footer__social_fb')]")));
        webElements.add(webDriver.findElement(By.xpath("//span[contains(@class,'footer__social_tw')]")));
        webElements.add(webDriver.findElement(By.xpath("//span[contains(@class,'footer__social_yt')]")));
        webElements.add(webDriver.findElement(By.xpath("//span[contains(@class,'footer__social_ins')]")));
        webElements.add(webDriver.findElement(By.xpath("//span[contains(@class,'footer__social_vk')]")));
        webElements.add(webDriver.findElement(By.xpath("//span[contains(@class,'footer__social_ok')]")));

        webElements.forEach(webElement -> Assert.assertTrue(webElement.isDisplayed()));

    }
}