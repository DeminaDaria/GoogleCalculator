package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ExpectedResult {
    public ExpectedResult(WebDriver driver) {
        initElements(driver, this);
    }

    @FindBy(css = "div.xwgN1d.XSNERd span")
    public WebElement memoryLine;

    @FindBy(css = "#cwos")
    public WebElement resultLine;


    public String getMemoryValue() {
        return memoryLine.getText();
    }

    public String getResultValue() {
        return resultLine.getText();
    }
}
