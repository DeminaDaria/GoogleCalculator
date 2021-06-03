package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;


public class SearchLine {
    public WebDriver driver;
    public SearchLine(WebDriver driver) {
        initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "input.gLFyf.gsfi")
    public WebElement searchInput;

    @FindBy(css = "div.aajZCb input.gNO89b")
    public WebElement buttonSearch;

    public void search(String text) {
        searchInput.sendKeys(text);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.aajZCb input.gNO89b")));
        buttonSearch.click();
    }
}
