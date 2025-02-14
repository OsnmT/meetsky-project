package net.meetsky.pages;
import net.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="user")
    public WebElement userInputBox;

    @FindBy(id="password")
    public WebElement passwordInputBox;

    @FindBy(id="submit-form")
    public WebElement submitButton;

    public void login(String username, String password) {
        userInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        submitButton.click();
    }

}
