package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTests {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldCheckingOperationsWithIntegers() {
        driver.get("http://google.com");
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("Калькулятор");
        driver.findElement(By.cssSelector("div.aajZCb input.gNO89b")).click();
        driver.findElement(By.cssSelector("div.fB3vD > div")).sendKeys("(1+2)*3-40/5", Keys.ENTER);

        String memoryLine = driver.findElement(By.cssSelector("div.xwgN1d.XSNERd span")).getText();
        assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", memoryLine);
        String resultLine = driver.findElement(By.cssSelector("#cwos")).getText();
        assertEquals("1", resultLine);
    }

    @Test
    void shouldCheckingDivisionsNull() {
        driver.get("http://google.com");
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("Калькулятор");
        driver.findElement(By.cssSelector("div.aajZCb input.gNO89b")).click();
        driver.findElement(By.cssSelector("div.fB3vD > div")).sendKeys("6/0", Keys.ENTER);

        String memoryLine = driver.findElement(By.cssSelector("div.xwgN1d.XSNERd span")).getText();
        assertEquals("6 ÷ 0 =", memoryLine);
        String resultLine = driver.findElement(By.cssSelector("#cwos")).getText();
        assertEquals("Infinity", resultLine);
    }

    @Test
    void shouldCheckingNoValue() {
        driver.get("http://google.com");
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("Калькулятор");
        driver.findElement(By.cssSelector("div.aajZCb input.gNO89b")).click();
        driver.findElement(By.cssSelector("[aria-label=синус]")).click();
        driver.findElement(By.cssSelector("[aria-label=равно]")).click();

        String memoryLine = driver.findElement(By.xpath("//div[@class='XH1CIc']//span")).getText();
        assertEquals("sin() =", memoryLine);
        String resultLine = driver.findElement(By.cssSelector("#cwos")).getText();
        assertEquals("Error", resultLine);
    }
}
