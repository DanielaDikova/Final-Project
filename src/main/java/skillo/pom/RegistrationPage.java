package skillo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilis.ContentGeneration;

import java.util.Arrays;

public class RegistrationPage extends ISkillo {
    private final String REGISTRATIONPAGE_URL = "/users/register";


    @FindBy(xpath = "//p[contains (@class, 'h4 mb-4')]")
    private WebElement signInRegistrationTitle;
    @FindBy(xpath = "//div/input[@formcontrolname = 'username']")
    private WebElement registrationUsernameInputField;
    @FindBy(xpath = "//div/input[@formcontrolname = 'email']")
    private WebElement registrationEmailInputField;
    @FindBy(xpath = "//div/input[@formcontrolname = 'password']")
    private WebElement registrationPasswordInputField;
    @FindBy(xpath = "//div/input[@formcontrolname = 'confirmPassword']")
    private WebElement registrationConfirmPasswordInputField;
    @FindBy(xpath = " //div/button[@id='sign-in-button']")
    private WebElement registrationSignInButton;


    public RegistrationPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public void openRegistrationPage() {
        navigateToPage(REGISTRATIONPAGE_URL);
        waitPageTobeFullLoaded();

    }

    public void clickOnRegistrationUsernameInputField() {
        waitAndClick(registrationUsernameInputField);

    }

    public void clickOnRegistrationEmailInputField() {
        waitAndClick(registrationEmailInputField);

    }

    public void clickOnRegistrationPasswordInputField() {
        waitAndClick(registrationPasswordInputField);

    }

    public void clickOnRegistrationConfirmPasswordInputField() {
        waitAndClick(registrationConfirmPasswordInputField);

    }

    public void clickOnRegisterSignInButton() {
        waitAndClick(registrationSignInButton);

    }

    public void enterValidCredentials() {
        ContentGeneration contentGeneration = new ContentGeneration();

        typeTextInField(registrationUsernameInputField, contentGeneration.createUser());
        typeTextInField(registrationEmailInputField, contentGeneration.createEmail());
        String password = contentGeneration.createPassword();
        typeTextInField(registrationPasswordInputField, password);
        typeTextInField(registrationConfirmPasswordInputField, password);
        waitAndClick(registrationSignInButton);
    }

    public void enterInvalidCredentials() {
        ContentGeneration contentGeneration = new ContentGeneration();

        typeTextInField(registrationUsernameInputField, contentGeneration.createUser());
        typeTextInField(registrationEmailInputField, contentGeneration.createInvalidEmail());
        String password = contentGeneration.createPassword();
        typeTextInField(registrationPasswordInputField, password);
        typeTextInField(registrationConfirmPasswordInputField, password);
        waitAndClick(registrationSignInButton);
    }


    public boolean isRegisterPageURlLoaded() {
        boolean isLoaded = false;

        try {
            wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users/register"));
            isLoaded = true;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return isLoaded;
    }
}