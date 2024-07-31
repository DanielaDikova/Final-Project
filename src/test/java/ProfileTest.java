import org.testng.Assert;
import org.testng.annotations.Test;
import skillo.pom.HomePage;
import skillo.pom.LoginPage;
import skillo.pom.ProfilePage;

public class ProfileTest extends TestObject {


    @Test
    public void editUserProfile() throws InterruptedException {

        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();
        homePage.clickOnNavigationBarLoginButton();
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        Assert.assertTrue(loginPage.isLoginPageURlLoaded());

        loginPage.enterLoginCredentials();
        loginPage.clickOnLoginSubmitButton();

        Assert.assertTrue(homePage.isHomePageURlLoaded());

        homePage.clickOnProfileNavigationButton();

        ProfilePage profilePage = new ProfilePage(super.getWebDriver());
        profilePage.waitPageTobeFullLoaded();

        Assert.assertTrue(profilePage.isProfilePageURlLoaded());

        profilePage.clickOnUserEditIcon();
        profilePage.enterEditUserCredentials();


        Assert.assertTrue(profilePage.isProfilePageURlLoaded());

        Assert.assertTrue(profilePage.isPublicInfoChanged());

    }
}