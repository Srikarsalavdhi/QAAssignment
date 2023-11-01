import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestReport {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initializeReport() {
        extent = new ExtentReports();
    }

    public static void createTest(String testLogin) {
        test = extent.createTest(testLogin);
    }

    public static void logPass(String loginSuccessful) {
        test.log(Status.PASS, MarkupHelper.createLabel(loginSuccessful, ExtentColor.GREEN));
    }


    public static void flushReport() {
        extent.flush();
    }
}
