import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTests {
     WebDriver driver;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\Desktop\\chrome driver");
        driver = new ChromeDriver();
        driver.get("https://sakshingp.github.io/assignment/login.html");
    }

    @Test
    public void testLoginWithValidCredentials() {
        // Perform login with valid credentials
        driver.findElement(By.id("username")).sendKeys("validUsername");
        driver.findElement(By.id("password")).sendKeys("validPassword");
        driver.findElement(By.id("login-button")).click();

        // Add assertions for successful login
        // Example: Assert that a welcome message is displayed
        // Assertions.assertEquals(driver.findElement(By.id("welcome-message")).getText(), "Welcome, User!");
    }


    }



