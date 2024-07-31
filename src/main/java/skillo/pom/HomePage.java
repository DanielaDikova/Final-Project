package skillo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import java.util.Arrays;

public class HomePage extends ISkillo {

    private final String HOMEPAGE_URL = "/posts/all";

    @FindBy(id = "nav-link-login")
    private WebElement navigationLoginButton;
    @FindBy(id = "nav-link-new-post")
    private WebElement navigationNewPostButton;
    @FindBy(id = "nav-link-profile")
    private WebElement profileNavigationBarButton;
    @FindBy(xpath = "(//button[contains (@class, 'btn btn-primary ng-star-inserted')])[1]")
    private WebElement followOrUnfollowButton;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        navigateToPage(HOMEPAGE_URL);
        waitPageTobeFullLoaded();
    }

    public void clickOnNavigationBarLoginButton() {
        waitAndClick(navigationLoginButton);

    }

    public void clickOnFollowOrUnfollowButton() {
        waitAndClick(followOrUnfollowButton);
    }

    public void clickOnProfileNavigationBarButton() {
        waitAndClick(profileNavigationBarButton);
    }

    public void clickOnProfileNavigationButton() {
        waitAndClick(profileNavigationBarButton);
    }


    public boolean isFollowingTheUser() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return followOrUnfollowButton.getText().contains("Unfollow");
    }

    public boolean isUnfollowingTheUser() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return followOrUnfollowButton.getText().contains("Follow");

    }

    public boolean isHomePageURlLoaded() {
        boolean isLoaded = false;

        try {
            wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/posts/all"));
            isLoaded = true;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return isLoaded;
    }
}