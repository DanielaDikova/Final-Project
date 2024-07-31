package skillo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class ProfilePage extends ISkillo {
    private final String PROFILEPAGE_URL = "/users/5510";
    private final String EDIT_USERNAME = "Daniela";
    private final String EDIT_PASSWORD = "123456";
    private final String EDIT_PUBLIC_INFO = "Automation testing";


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


    public ProfilePage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }


    public void clickOnUserEditIcon() {
        waitAndClick(userEditIcon);
    }

    public void clickOnFollowerWindow() {
        waitAndClick(followersWindow);
    }

    public void clickOnFollowingWindow() {
        waitAndClick(followingWindow);
        wait.until(ExpectedConditions.visibilityOf(followingList));
    }

    public void enterEditUserCredentials() {
        typeTextInField(editPublicInfoInputField, EDIT_PUBLIC_INFO);
        waitAndClick(editSaveButton);


    }

    public void clickOnFollowingUnfollowingButtonProfilePage() {
        waitAndClick(followingUnfollowingProfilePageButton);
    }

    public boolean isProfilePageURlLoaded() {
        boolean isLoaded = false;

        try {
            wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users/8489"));
            isLoaded = true;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return isLoaded;
    }

    public boolean isPublicInfoChanged() {
        String publicInfoText = publicInfo.getText();
        return publicInfoText.contains(EDIT_PUBLIC_INFO);


    }


}
