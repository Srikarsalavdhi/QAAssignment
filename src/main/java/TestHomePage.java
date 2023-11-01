import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestHomePage {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\ChromeRecovery\\chromedriver.exe");
        driver = new ChromeDriver(co);
        driver.get("https://sakshingp.github.io/assignment/login.html");
        //Maximize the window
        driver.manage().window().maximize();


        //Perform login here to access the Homepage
        WebElement Username= driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement Password= driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement LoginButton= driver.findElement(By.xpath("//*[@id=\"log-in\"]"));

        Username.sendKeys("Srikar");
        Password.sendKeys("Srikar");
        LoginButton.click();

    }
    @Test
    public void AmountHeaderSorting(){
        TestReport.createTest("testLogin");
        //Click the AMOUNT header to sort the values and copy the xpath.
        driver.findElement(By.xpath("//*[@id=\"amount\"]"));

        //Fetch the values in the Transaction table
        List<WebElement> AmountColumn=driver.findElements(By.xpath("//*[@id=\"transactionsTable\"]"));
        List<String> actualAmounts= new ArrayList<>();
        List<String> sortedAmounts= new ArrayList<>();

        for (WebElement amountElement : AmountColumn) {
            String amount = amountElement.getText().replace("USD ", "USD");
            actualAmounts.add(amount);
            sortedAmounts.add(amount);
        }
        //Assertions for sorting Amount along with test report
        Collections.sort(sortedAmounts);
        Assert.assertEquals(actualAmounts,sortedAmounts,"Amounts are not sorted");
        TestReport.logPass("LoginSuccessful");
    }
    @AfterClass
    public void teardown(){
        TestReport.flushReport();
        driver.quit();
    }
}
