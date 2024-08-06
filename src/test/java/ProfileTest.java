import org.testng.Assert;
import org.testng.annotations.Test;
import skillo.pom.HomePage;
import skillo.pom.LoginPage;
import skillo.pom.ProfilePage;

public class ProfileTest extends TestObject {

    @Test
    public void editUserProfile() throws InterruptedException {
        System.out.println("Step 1: The user is opening the home page");
        HomePage homePage = new HomePage(super.getWebDriver());
        homePage.openHomePage();
        homePage.clickOnNavigationBarLoginButton();

        System.out.println("Step 2: The user is opening the login page");
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        Assert.assertTrue(loginPage.isLoginPageURlLoaded());

        System.out.println("Step 3: The user is logging in");
        loginPage.enterLoginCredentials();
        loginPage.clickOnLoginSubmitButton();

        Assert.assertTrue(homePage.isHomePageURlLoaded());
        System.out.println("Step 4: The user is been navigated to the home page");

        homePage.clickOnProfileNavigationButton();
        System.out.println("Step 5: The user is opening the profile page");
        ProfilePage profilePage = new ProfilePage(super.getWebDriver());
        profilePage.waitPageTobeFullLoaded();

        Assert.assertTrue(profilePage.isProfilePageURlLoaded());

        profilePage.clickOnUserEditIcon();
        System.out.println("Step 6: The user is clicking on user edit icon ");
        profilePage.enterEditUserCredentials();
        System.out.println("Step 7: The user has entered new public info");

        Assert.assertTrue(profilePage.isProfilePageURlLoaded());

        Assert.assertTrue(profilePage.isPublicInfoChanged());
    }
}