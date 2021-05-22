package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Calculator {

    @FindBy(css = "input.gLFyf.gsfi")
    public WebElement searchInput;

    @FindBy(css = "div.aajZCb input.gNO89b")
    public WebElement buttonSearch;

    @FindBy(css = "div.fB3vD > div")
    public WebElement calculateValue;

    @FindBy(css = "[aria-label=синус]")
    public WebElement buttonSin;

    @FindBy(css = "[aria-label=равно]")
    public WebElement buttonEqual;

    public Calculator(WebDriver driver) {
        initElements(driver, this);
    }

    public void search(String text) {
        searchInput.sendKeys(text);
    }

    public void calculate(String numbers) {
        calculateValue.sendKeys(numbers, Keys.ENTER);
    }


}
