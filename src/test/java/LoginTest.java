import org.testng.Assert;
import org.testng.annotations.Test;
import skillo.pom.HomePage;
import skillo.pom.LoginPage;

public class LoginTest extends TestObject{



    @Test
    public void loginWithValidCredentials () throws InterruptedException{

        HomePage homePage = new HomePage(super.getWebDriver());
        //Step 1: The user opens the Skillo homepage.
        System.out.println("Step 1: The user opens the Skillo homepage.");
        homePage.openHomePage();

        //Step 2: The user opens the login page by clicking on login page navigation  button.
        System.out.println("Step 2: The user opens the login page by clicking on login page navigation  button.");
        homePage.clickOnNavigationBarLoginButton();


        //Step 3: The user has clicked on login form submit button.
        System.out.println("Step 3: The user has clicked on login form submit button.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        Assert.assertTrue(loginPage.isLoginPageURlLoaded());

        loginPage.enterLoginCredentials();

        Assert.assertTrue(homePage.isHomePageURlLoaded());
    }
    @Test
    public void loginWithInvalidCredentials () throws InterruptedException{

        HomePage homePage = new HomePage(super.getWebDriver());
        //Step 1: The user opens the Skillo homepage.
        System.out.println("Step 1: The user opens the Skillo homepage.");
        homePage.openHomePage();

        //Step 2: The user opens the login page by clicking on login page navigation  button.
        System.out.println("Step 2: The user opens the login page by clicking on login page navigation  button.");
        homePage.clickOnNavigationBarLoginButton();


        //Step 3: The user has clicked on login form submit button.
        System.out.println("Step 3: The user has clicked on login form submit button.");
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        Assert.assertTrue(loginPage.isLoginPageURlLoaded());

        loginPage.enterLoginInvalidCredentials();

        Assert.assertFalse(homePage.isHomePageURlLoaded());
    }

}
