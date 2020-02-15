import gherkin.formatter.model.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.MakeAttachmentEvent;
import sun.rmi.rmic.iiop.Generator;

import java.sql.Driver;
import java.sql.DriverManager;

public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {
    @Override
    public void result(Result result) {
        if ("failed".equals(result.getStatus())) takeScreenhot(result);
    }

    public void takeScreenhot(Result step) {
        if (DriverManager.getDriver() != null) {
            Allure.LIFECYCLE.fire(new MakeAttachmentEvent
                    (((TakesScreenshot) DriverManager.getDriver()).getScreenshootsAs(OutputType.BYTES),
                            "Скриншот во время ошибки", "image/png"));
        }

    }

}
