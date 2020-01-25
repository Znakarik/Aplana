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
        WebElement inputWindow = webDriver.findElement(By.xpath("(//input[@type='search'])[3]"));

        inputWindow.sendKeys("ниже");

        webDriver.findElement(By.xpath("//a[contains(text(),'Нижего')]")).click();
        WebElement nizniy = webDriver.findElement(By.xpath("(//span[text()='Нижегородская область'])[1]"));
        Assert.assertEquals("Нижегородская область", nizniy.getText());

        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);

        WebElement fb = webDriver.findElement(By.xpath("//span[@class='footer__social_logo footer__social_fb']"));
        WebElement twitter = webDriver.findElement(By.xpath("//span[@class='footer__social_logo footer__social_tw']"));
        WebElement youTube = webDriver.findElement(By.xpath("//span[@class='footer__social_logo footer__social_yt']"));
        WebElement insta = webDriver.findElement(By.xpath("//span[@class='footer__social_logo footer__social_ins']"));
        WebElement vk = webDriver.findElement(By.xpath("//span[@class='footer__social_logo footer__social_vk']"));
        WebElement odnoklass = webDriver.findElement(By.xpath("//span[@class='footer__social_logo footer__social_ok']"));

        System.out.println(fb.isDisplayed());
        System.out.println(twitter.isDisplayed());
        System.out.println(youTube.isDisplayed());
        System.out.println(insta.isDisplayed());
        System.out.println(vk.isDisplayed());
        System.out.println(odnoklass.isDisplayed());
    }
}