import org.testng.Assert;
import org.testng.annotations.Test;
import skillo.pom.HomePage;
import skillo.pom.LoginPage;
import skillo.pom.ProfilePage;

public class HomeTest extends TestObject {
    @Test
    public void followOrUnfollowUsers() {

        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();
        homePage.clickOnNavigationBarLoginButton();
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        Assert.assertTrue(loginPage.isLoginPageURlLoaded());
        loginPage.enterLoginCredentials();

        Assert.assertTrue(homePage.isHomePageURlLoaded());
        homePage.clickOnFollowOrUnfollowButton();

        homePage.clickOnProfileNavigationBarButton();

        ProfilePage profilePage = new ProfilePage(super.getWebDriver());
        profilePage.isProfilePageURlLoaded();
        profilePage.clickOnFollowingWindow();

        Assert.assertTrue(homePage.isFollowingTheUser());

        profilePage.clickOnFollowingUnfollowingButtonProfilePage();
    }
}

