import org.testng.Assert;
import org.testng.annotations.Test;
import skillo.pom.HomePage;
import skillo.pom.LoginPage;
import skillo.pom.RegistrationPage;

public class RegistrationTest extends TestObject {
    @Test
    public void registerWithValidCredentials() {

        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();
        homePage.clickOnNavigationBarLoginButton();
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        Assert.assertTrue(loginPage.isLoginPageURlLoaded());

        loginPage.clickOnRegisterForm();

        RegistrationPage registrationPage = new RegistrationPage(super.getWebDriver());

        Assert.assertTrue(registrationPage.isRegisterPageURlLoaded());

        registrationPage.enterValidCredentials();
        Assert.assertTrue(homePage.isHomePageURlLoaded());
    }

    @Test
    public void registerWithInvalidCredentials() {

        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();
        homePage.clickOnNavigationBarLoginButton();
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        Assert.assertTrue(loginPage.isLoginPageURlLoaded());

        loginPage.clickOnRegisterForm();

        RegistrationPage registrationPage = new RegistrationPage(super.getWebDriver());

        Assert.assertTrue(registrationPage.isRegisterPageURlLoaded());

        registrationPage.enterInvalidCredentials();
        Assert.assertTrue(homePage.isHomePageURlLoaded());
    }
}
