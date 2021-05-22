package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Calculator;
import pages.ExpectedResult;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTests {
    private static WebDriver driver;
    private static Calculator calculator;
    private static ExpectedResult expectedResult;


    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        calculator = new Calculator(driver);
        expectedResult = new ExpectedResult(driver);
        driver.get("http://google.com");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldCheckingOperationsWithIntegers() {

        calculator.search("Калькулятор");
        calculator.buttonSearch.click();
        calculator.calculate("(1+2)*3-40/5");

        String memoryLine = expectedResult.getMemoryValue();
        String resultLine = expectedResult.getResultValue();

        assertAll(
                () -> assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", memoryLine),
                () -> assertEquals("1", resultLine)
        );
    }

    @Test
    public void shouldCheckingDivisionsNull() {

        calculator.search("Калькулятор");
        calculator.buttonSearch.click();
        calculator.calculate("6/0");

        String memoryLine = expectedResult.getMemoryValue();
        String resultLine = expectedResult.getResultValue();

        assertAll(
                () -> assertEquals("6 ÷ 0 =", memoryLine),
                () -> assertEquals("Infinity", resultLine)
        );
    }

    @Test
    public void shouldCheckingNoValue() {

        calculator.search("Калькулятор");
        calculator.buttonSearch.click();
        calculator.buttonSin.click();
        calculator.buttonEqual.click();

        String memoryLine = expectedResult.getMemoryValue();
        String resultLine = expectedResult.getResultValue();

        assertAll(
                () -> assertEquals("sin() =", memoryLine),
                () -> assertEquals("Error", resultLine)
        );
    }
}
