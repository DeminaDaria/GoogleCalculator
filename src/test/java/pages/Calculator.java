package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Calculator {

    @FindBy(css = "[aria-label=синус]")
    public WebElement buttonSin;

    @FindBy(css = "[aria-label=равно]")
    public WebElement buttonEqual;

    @FindBy(css = "[aria-label='открывающая скобка']")
    public WebElement buttonOpenBrace;

    @FindBy(css = "[aria-label='закрывающая скобка']")
    public WebElement buttonCloseBrace;

    @FindBy(css = "[aria-label=деление]")
    public WebElement buttonDivision;

    @FindBy(css = "[aria-label=вычитание]")
    public WebElement buttonMinus;

    @FindBy(css = "[aria-label=умножение]")
    public WebElement buttonMultiply;

    @FindBy(css = "[aria-label=сложение]")
    public WebElement buttonPlus;

    @FindBy(css = "[jsname=bkEvMb]")
    public WebElement buttonNull;

    @FindBy(css = "[jsname=N10B9]")
    public WebElement buttonOne;

    @FindBy(css = "[jsname=lVjWed]")
    public WebElement buttonTwo;

    @FindBy(css = "[jsname=KN1kY]")
    public WebElement buttonThree;

    @FindBy(css = "[jsname=xAP7E]")
    public WebElement buttonFour;

    @FindBy(css = "[jsname=Ax5wH]")
    public WebElement buttonFive;

    @FindBy(css = "[jsname=abcgof]")
    public WebElement buttonSix;

    public Calculator(WebDriver driver) {
        initElements(driver, this);
    }

    public void caseOne() {
        buttonOpenBrace.click();
        buttonOne.click();
        buttonPlus.click();
        buttonTwo.click();
        buttonCloseBrace.click();
        buttonMultiply.click();
        buttonThree.click();
        buttonMinus.click();
        buttonFour.click();
        buttonNull.click();
        buttonDivision.click();
        buttonFive.click();
        buttonEqual.click();
    }

    public void caseTwo() {
        buttonSix.click();
        buttonDivision.click();
        buttonNull.click();
        buttonEqual.click();
    }

    public void caseThree() {
        buttonSin.click();
        buttonEqual.click();
    }
}
