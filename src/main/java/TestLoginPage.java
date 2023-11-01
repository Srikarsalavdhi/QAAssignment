import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestLoginPage {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\ChromeRecovery\\chromedriver.exe");
        driver = new ChromeDriver(co);
        driver.get("https://sakshingp.github.io/assignment/login.html");
        //Maximize hte windows
        driver.manage().window().maximize();


    }
    @BeforeTest
    public void LoginThePage(){

        //Inspecting the Field of Username,Password and Login button and copy the xpath
        WebElement Username= driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement Password= driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement LoginButton= driver.findElement(By.xpath("//*[@id=\"log-in\"]"));

        //Giving Login credentials for successful login
        Username.sendKeys("Srikar");
        Password.sendKeys("Srikar");
        LoginButton.click();

        //Financial Overview Message displayed after login and giving Assertion to the message by copying the xpath.
        WebElement FinancialOverviewMessage= driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/h6[2]"));
        Assert.assertEquals(FinancialOverviewMessage.getText(),"Financial Overview");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
