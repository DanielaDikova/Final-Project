import org.testng.Assert;
import org.testng.annotations.Test;
import skillo.pom.HomePage;
import skillo.pom.LoginPage;
import skillo.pom.RegistrationPage;

public class RegistrationTest extends TestObject {
    @Test
    public void registerWithValidCredentials() {

        System.out.println("Step 1: The user is opening the home page");
        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();

        System.out.println("Step 2: The user is opening the login page");
        homePage.clickOnNavigationBarLoginButton();
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        Assert.assertTrue(loginPage.isLoginPageURlLoaded());

        System.out.println("Step 3: The user is opening register page");
        loginPage.clickOnRegisterForm();

        RegistrationPage registrationPage = new RegistrationPage(super.getWebDriver());

        Assert.assertTrue(registrationPage.isRegisterPageURlLoaded());

        System.out.println("Step 4: The user is entering valid credentials");
        registrationPage.enterValidCredentials();
        Assert.assertTrue(homePage.isHomePageURlLoaded());
    }

    @Test
    public void registerWithInvalidCredentials() {

        System.out.println("Step 1: The user is opening the home page");
        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();

        System.out.println("Step 2: The user is opening the login page");
        homePage.clickOnNavigationBarLoginButton();
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        Assert.assertTrue(loginPage.isLoginPageURlLoaded());

        System.out.println("Step 3: The user is opening register page");
        loginPage.clickOnRegisterForm();

        RegistrationPage registrationPage = new RegistrationPage(super.getWebDriver());

        Assert.assertTrue(registrationPage.isRegisterPageURlLoaded());

        System.out.println("Step 4: The user is entering invalid credentials");
        registrationPage.enterInvalidCredentials();

        Assert.assertFalse(homePage.isHomePageURlLoaded());
    }

    @Test
    public void signInButtonTextCheck() {

        System.out.println("Step 1: The user is opening the home page");
        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();

        System.out.println("Step 2: The user is opening the login page");
        homePage.clickOnNavigationBarLoginButton();
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        Assert.assertTrue(loginPage.isLoginPageURlLoaded());

        System.out.println("Step 3: The user is opening register page");
        loginPage.clickOnRegisterForm();

        RegistrationPage registrationPage = new RegistrationPage(super.getWebDriver());

        Assert.assertTrue(registrationPage.isRegisterPageURlLoaded());

        System.out.println("Step 4: User is validating sign up button text");

        Assert.assertTrue(registrationPage.isSignInButtonTextCorrect());


    }
}
