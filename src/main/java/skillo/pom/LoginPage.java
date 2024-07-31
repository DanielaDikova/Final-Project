package skillo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class LoginPage extends ISkillo {
    //Consts
    private final String LOGINPAGE_URL = "/users/login";
    private final String USER_NAME = "testUser1234";
    private final String USER_NAME_INVALID = "test55";
    private final String USER_PASSWORD = "123456";
    private final String USER_PASSWORD_INVALID = "Test55";

    //WebElements => PageFactory / UI MAP
    @FindBy(id = "sign-in-button")
    private WebElement loginFormSubmitButton;
    @FindBy(id = "defaultLoginFormUsername")
    private WebElement loginFormUsername;
    @FindBy(id = "defaultLoginFormPassword")
    private WebElement loginFormPassword;
    @FindBy(xpath = "//a[contains (text(), 'Register')]")
    private WebElement registerForm;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void openLoginPage() {
        navigateToPage(LOGINPAGE_URL);
        System.out.println("The user has navigated to the login page.");
    }

    //User Interactions
    public void clickOnLoginSubmitButton() {
        waitAndClick(loginFormSubmitButton);

    }

    public void clickOnRegisterForm() {
        waitAndClick(registerForm);
        System.out.println("The user has navigated to the registration page.");

    }

    public void enterLoginCredentials() {
        typeTextInField(loginFormUsername, USER_NAME);
        typeTextInField(loginFormPassword, USER_PASSWORD);
        clickOnLoginSubmitButton();

    }

    public void enterLoginInvalidCredentials() {
        typeTextInField(loginFormUsername, USER_NAME_INVALID);
        typeTextInField(loginFormPassword, USER_PASSWORD_INVALID);
        clickOnLoginSubmitButton();
    }

    public boolean isLoginPageURlLoaded() {
        boolean isLoaded = false;

        try {
            wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users/login"));
            isLoaded = true;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return isLoaded;

    }


}