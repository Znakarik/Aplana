package ru.znakarik.util;

import io.qameta.allure.Attachment;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import io.qameta.allure.junit4.AllureJunit4;
import org.openqa.selenium.TakesScreenshot;
import ru.znakarik.steps.BaseSteps;

public class AllureListener extends AllureJunit4 {

    @Override
    public void testFailure(Failure failure) {
        takeScreenshot();
        super.testFailure(failure);
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
