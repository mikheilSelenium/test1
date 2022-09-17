package Nugios.Kazunion.ScreenRecorder;

import Nugios.Kazunion.common.RunChrome;
import VideoRecorder.VideoRecorder_utlity;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenListener implements ITestListener{

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult result){
        // TODO Auto-generated method stub
        TakesScreenshot ts = (TakesScreenshot) RunChrome.driver;
        File file = ts.getScreenshotAs(OutputType.FILE);


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        String name = "TestFailure_Screen" + dateFormat.format(new Date());
        String directory = "TestRun_" + dateFormat.format(new Date());
        //File dir = new File("./automationrecordings/"+directory);
        //dir.mkdirs();

        try {
            FileHandler.copy(file, new File(VideoRecorder_utlity.dir+"/"+name+".png"));
        } catch (IOException e) {
            e.printStackTrace();

        }

        try {
            FileWriter fstream = new FileWriter(VideoRecorder_utlity.dir+"/"+"log.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);
            PrintWriter pWriter = new PrintWriter(out, true);
            result.getThrowable().printStackTrace(pWriter);
        }
        catch (Exception ie) {
            throw new RuntimeException("Could not write Exception to file", ie);
        }

        System.out.println("screenshot is taken");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }

}