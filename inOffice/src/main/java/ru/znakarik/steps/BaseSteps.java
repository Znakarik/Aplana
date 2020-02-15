package ru.znakarik.steps;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import ru.znakarik.util.TestProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * 1.  Перейти на chaihona.ru
 * 2.  Перейти в меню доставки – Бургеры и Шаурма.
 * 3.  Выбрать шаурму с телятиной, запомнить название и цену.
 * 4.  Перейти в меню доставки – Выпечка.
 * 5.  пичанон с сыром, запомнить название и цену.
 * 6.  Выбрать меню доставки – Плов – Плов чайханский – запомнить цену
 * 7.  Перейти в корзину
 * 8.  Проверить, что все товары добавлены
 * 9.  Проверить, что итоговая сумма совпадает с суммой выбранных товаров
 */
public class BaseSteps {

    private static WebDriver driver;
    private static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();
    private static Map<String, String> variables = new HashMap<>();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp() throws Exception {
        switch (properties.getProperty("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/o/IdeaProjects/Aplana/inOffice/resources/driver/chromedriver");
                driver = new ChromeDriver();
                break;
        }
        baseUrl = properties.getProperty("app.url");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
//        driver.close();
    }

    public String getVariable(String key) {
        return variables.get(key);
    }

    public static void setVariable(String key, String value) {
        variables.put(key, value);
    }
}

