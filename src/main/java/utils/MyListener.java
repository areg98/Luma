package utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static utils.CustomWebDriver.getDriver;
import static utils.MyLog4j.*;

public class MyListener implements ITestListener{

    private int fileNum =1;

    @Override
    public void onTestStart(ITestResult context) {
        info(" Starting " + context.getName());
    }

    @Override
    public void onTestSuccess(ITestResult context) {
        info(" Test is Passed " + context.getName() + "\n");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        error(" Test is failed " + iTestResult.getName() + "\n");
        Screenshot screenshot1 = null;
        screenshot1 = new AShot().coordsProvider(new WebDriverCoordsProvider()).
                takeScreenshot(getDriver());
        BufferedImage randomImageItem1 = screenshot1.getImage();
        File file = new File("C:\\Users\\hovak\\IdeaProjects\\Luma\\src\\main\\java\\ScreenShots\\Screen" + "bug" + fileNum + ".png");
        try {
            ImageIO.write(randomImageItem1, "png", file);
            if (file.exists()) {
                fileNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        info(" Test is Skipped " + iTestResult.getName() + "\n");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
