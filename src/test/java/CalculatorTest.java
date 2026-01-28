import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        // Sample calculator website
        driver.get("https://www.calculator.net/");
        driver.manage().window().maximize();
    }

    @Test
    public void testAddition() {
        driver.findElement(By.xpath("//span[text()='2']")).click();
        driver.findElement(By.xpath("//span[text()='+']")).click();
        driver.findElement(By.xpath("//span[text()='3']")).click();
        driver.findElement(By.xpath("//span[text()='=']")).click();

        WebElement result = driver.findElement(By.id("sciOutPut"));
        String output = result.getText().trim();

        Assert.assertTrue(output.contains("5"), "Addition result is incorrect");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
