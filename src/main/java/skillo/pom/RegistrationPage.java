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
    private final String SIGN_UP_BUTTON_TEXT = "Sign up";


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

    public void enterValidCredentials() {
        ContentGeneration contentGeneration = new ContentGeneration();

        typeTextInField(registrationUsernameInputField, contentGeneration.createUser());
        typeTextInField(registrationEmailInputField, contentGeneration.createEmail());
        String password = contentGeneration.createPassword();
        typeTextInField(registrationPasswordInputField, password);
        typeTextInField(registrationConfirmPasswordInputField, password);
        System.out.println("The user has entered valid credentials");
        waitAndClick(registrationSignInButton);
        System.out.println("The user has clicked on registration submit button");
    }

    public void enterInvalidCredentials() {
        ContentGeneration contentGeneration = new ContentGeneration();

        typeTextInField(registrationUsernameInputField, contentGeneration.createUser());
        typeTextInField(registrationEmailInputField, contentGeneration.createInvalidEmail());
        String password = contentGeneration.createPassword();
        typeTextInField(registrationPasswordInputField, password);
        typeTextInField(registrationConfirmPasswordInputField, password);
        System.out.println("The user has entered invalid credentials");
        waitAndClick(registrationSignInButton);
        System.out.println("The user has clicked on registration submit button");
    }

    public boolean isRegisterPageURlLoaded() {
        boolean isLoaded = false;
        System.out.println(" ACTION @ The user is verifying if the registration page url is loaded");

        try {
            wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users/register"));
            System.out.println("CONFIRM # The registration page is loaded");
            isLoaded = true;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println("ERROR ! The registration page url is not loaded");
        }
        return isLoaded;
    }

    public boolean isSignInButtonTextCorrect() {
        if (registrationSignInButton.getText().equals(SIGN_UP_BUTTON_TEXT)) {
            System.out.println("CONFIRM # The sign up button text is correct");
        } else {
            System.out.println("ERROR ! The sign up button text is not correct");
        }
        return registrationSignInButton.getText().equals(SIGN_UP_BUTTON_TEXT);

    }
}
