package skillo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class ProfilePage extends ISkillo {
    private final String PROFILEPAGE_URL = "/users/8489";
    private final String EDIT_PUBLIC_INFO = "Automation testing";
    private final String FOLLOWING_HEADER_TEXT = "Following";

    @FindBy(xpath = "//i[@class = 'fas fa-user-edit ng-star-inserted']")
    private WebElement userEditIcon;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement editSaveButton;
    @FindBy(xpath = "//div/textarea[@formcontrolname = 'publicInfo']")
    private WebElement editPublicInfoInputField;
    @FindBy(xpath = "//p[contains(text(),'Automation testing')]")
    private WebElement publicInfo;
    @FindBy(id = "followers")
    private WebElement followersWindow;
    @FindBy(id = "following")
    private WebElement followingWindow;
    @FindBy(xpath = "//h4[text()='Followers']")
    private WebElement followersList;
    @FindBy(xpath = "//h4[text()='Following']")
    private WebElement followingList;
    @FindBy(xpath = "//button[contains(text(),'Unfollow')]")
    private WebElement followingUnfollowingProfilePageButton;
    @FindBy(id = "nav-link-home")
    private WebElement homePageNavigationBarButton;
    @FindBy(xpath = "//h4[contains(text(),'Following')]")
    private WebElement followingHeader;


    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnUserEditIcon() {
        waitAndClick(userEditIcon);
        System.out.println("The user has clicked on user edit icon");
    }

    public void clickOnFollowingWindow() {
        waitAndClick(followingWindow);
        wait.until(ExpectedConditions.visibilityOf(followingList));
        System.out.println("The user has opened the 'following' window");
    }
    public void clickOnHomePageNavigationBarButton() {
        waitAndClick(homePageNavigationBarButton);
        System.out.println("The user has clicked on home page navigation bar button");
    }


    public void enterEditUserCredentials() {
        typeTextInField(editPublicInfoInputField, EDIT_PUBLIC_INFO);
        waitAndClick(editSaveButton);
        System.out.println("The user has entered new value for public info");
    }

    public void clickOnFollowingUnfollowingButtonProfilePage() {
        waitAndClick(followingUnfollowingProfilePageButton);
        System.out.println("The user has followed/unfollowed another user");
    }

    public boolean isProfilePageURlLoaded() {
        boolean isLoaded = false;
        System.out.println(" ACTION @ The user is verifying if the profile page url is loaded");

        try {
            wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200" + PROFILEPAGE_URL));
            System.out.println("CONFIRM # The profile page is loaded");
            isLoaded = true;

        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println("ERROR ! The profile page url is not loaded");
        }
        return isLoaded;
    }

    public boolean isPublicInfoChanged() {
        String publicInfoText = publicInfo.getText();
        if (publicInfoText.contains(EDIT_PUBLIC_INFO)) {
            System.out.println("CONFIRM # The public info is successfully changed");
        } else {
            System.out.println("ERROR ! The public info has not been changed");
        }
        return publicInfoText.contains(EDIT_PUBLIC_INFO);
    }
    public boolean isFollowingSectionTextVisible() {

        String followingHeaderText = followingHeader.getText();
        if (followingHeaderText.contains(FOLLOWING_HEADER_TEXT)) {
            System.out.println("CONFIRM # The following header text is correct");
        } else {
            System.out.println("ERROR ! The following header text is not correct");
        }
        return followingHeaderText.contains(FOLLOWING_HEADER_TEXT);

    }

}
