import org.testng.Assert;
import org.testng.annotations.Test;
import skillo.pom.HomePage;
import skillo.pom.LoginPage;
import skillo.pom.ProfilePage;

public class HomeTest extends TestObject {

    @Test
    public void followOrUnfollowUsers() {
        HomePage homePage = new HomePage(super.getWebDriver());
        System.out.println("Step 1: The user opens the Skillo homepage");
        homePage.openHomePage();

        System.out.println("Step 2: The user opens the login page by clicking on login page navigation  button");
        homePage.clickOnNavigationBarLoginButton();

        System.out.println("Step 3: The user is logging in");
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        Assert.assertTrue(loginPage.isLoginPageURlLoaded());

        loginPage.enterLoginCredentials();
        System.out.println("Step 4: The user is opening the home page");

        Assert.assertTrue(homePage.isHomePageURlLoaded());

        homePage.clickOnFollowOrUnfollowButton();
        System.out.println("Step 5: The user has followed another user");

        homePage.clickOnProfileNavigationButton();
        System.out.println("Step 6: The user has opens to profile page");
        ProfilePage profilePage = new ProfilePage(super.getWebDriver());
        profilePage.isProfilePageURlLoaded();

        profilePage.clickOnFollowingWindow();
        System.out.println("Step 7: The user is opening the following section");

        Assert.assertTrue(homePage.isFollowingTheUser());

        System.out.println("Step 8: The user is unfollowing another user");
        profilePage.clickOnFollowingUnfollowingButtonProfilePage();

        Assert.assertTrue(profilePage.isFollowingSectionTextVisible());
    }
}

