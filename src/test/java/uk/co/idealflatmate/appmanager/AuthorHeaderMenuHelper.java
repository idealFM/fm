package uk.co.idealflatmate.appmanager;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ConfData;

import java.io.File;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AuthorHeaderMenuHelper extends HelperBase {

    @FindBy(how = How.XPATH, using = "//li/a[contains(text(), ' Log out')]")
    private SelenideElement item_header_drop_Logout1;




    private SelenideElement item_header_drop_Logout = $(byXpath("//li/a[contains(text(), ' Log out')]"));
    private SelenideElement tab_header_JoinFree = $(".btn.btn-primary.u_m10-top.hidden-xs.hidden-sm.u_m20-right-md.u_m20-right-lg.u_ef-right");
    private SelenideElement tab_header_Login = $(byXpath("//nav//ul[contains(@class, 'nav navbar-nav navbar-right ')]/li[contains(., 'Login')]"));

    public  SelenideElement tab_header_Username = $("li.dropdown.nav-ihm-profile-bars span.user-welcome--name");

    //private SelenideElement item_header_drop_Logout = $(byXpath("//li/a[contains(text(), ' Log out')]"));
    private SelenideElement tab_header_FindHome = $(byXpath("//header//nav//ul//li//a[contains(text(), 'Find a home')]"));
    private SelenideElement tab_header_AllProperties = $(byXpath("//a[@href='/search' and contains(text(), 'All properties')]"));
    private SelenideElement tab_header_GoFMPage = $(byXpath("//ul[starts-with(@class, 'nav navbar-nav')]//a[contains(.,'Find a flatmate')]"));
    private SelenideElement button_popup_login_Submit = $(byXpath("//button[contains(., 'Log in with email ')]"));
    private SelenideElement button_popup_FB = $(byXpath("//a[span[contains(.,'Facebook')]]"));
    private SelenideElement button_popup_Google = $(byXpath("//a[span[contains(.,'Google')]]"));
    private SelenideElement button_popup_LinkedLn = $(byXpath("//a[span[contains(.,'linkedIn')]]"));
    private SelenideElement field_fb_Email = $("#email");
    private SelenideElement field_G_Email = $("#identifierId");
    private SelenideElement field_LinledLn_Email = $("#username");
    private SelenideElement field_fb_Password = $("#pass");
    private SelenideElement field_G_Password = $("#password input");
    private SelenideElement field_L_Password = $("#password");
    private SelenideElement field_login_Username = $("input#loginform-username");
    private String field_reset_Email ="input[name='PasswordResetRequestForm[email]']";
    private SelenideElement field_login_Password = $("input#loginform-password");
    private SelenideElement button_G_Email_next = $("#identifierNext");
    private SelenideElement button_L_Email_next = $("#identifierNext");
    private SelenideElement button_G_Password_next = $("#passwordNext");
    private SelenideElement button_G_allow_birth =$(byXpath("(//div[@class='XfpsVe J9fJmf']//span[@class='CwaK9']//span[@class='RveJvd snByac'])[1]"));
    private SelenideElement button_G_allow_birth2 =$(byXpath("(//span[@class='RveJvd snByac'])[1]"));
    private SelenideElement button_L_Password_next = $("button.btn__primary--large.from__button--floating");
    private SelenideElement button_login_FB = $(byXpath("//button[@id='loginbutton']"));
    private SelenideElement button_listing_Remove = $(byXpath("//button[@type='submit' and contains(text(), 'Delete')]"));
    private String button_submit_Reset = "//button[@type='submit' and contains(text(), 'yes, reset my password ')]";
    private SelenideElement notif_incorrect_EmailPassword = $(byXpath("//body//div[contains(@class,' required has-error')]/div[contains(text(),'Incorrect email or password.')]"));
    private static SelenideElement link_SignIn = $(byXpath("//a[contains(., 'Sign in')]"));
    private SelenideElement clickEditProfile = $(byXpath("//a[@href='/dashboard/profile']"));
    private SelenideElement photoClick =  $(byXpath("//div[@id='profile-update-images']//input[@id='profile-image']"));
    private static SelenideElement link_LogIn = $(byXpath("//a[contains(., 'Login')]"));
    private static SelenideElement button_savePhoto = $(byXpath("//button[@class='btn btn-primary send2' and contains(.,'Save')]"));
    public  SelenideElement clickSaveProfile = $(byXpath("//button[@class='btn btn-success btn-wide' and contains(.,'Save')]"));
    private SelenideElement reset = $(byXpath("//a[contains(.,'Reset')]"));
    private SelenideElement popup_SignIn = $(byXpath("//div[@id='signupNeedspaceModal']//div//a[@class='text-bold' and contains(., 'Sign')]"));
    private SelenideElement popup_SignIn_phone = $(byXpath("//div[@id='signupRevealModal']//div//a[@class='text-bold' and contains(., 'Sign')]"));
    private SelenideElement drop_Menu_My_profile = $(byXpath("//ul[@class='dropdown-menu']//a[contains(., 'My profile')]"));

    private String  tab_inner_header1 = "//body//div[@class='inner-menu--scroll']//li/a[contains(., '";
    private String  tab_inner_header2 = "')]";
    private SelenideElement popup_button_close_SignUp = $(byXpath("//div[@id='signupNeedspaceModal']//button[@class='btn btn-sm close u_m15']"));

    private final VerificationHelper verificationHelper = new VerificationHelper();
    private final AddPropertyHelper addPropertyHelper = new AddPropertyHelper();
    private final SignUpHelper signUpHelper = new SignUpHelper();





    @Step
    public void logoutFromApp() {
        refresh();
        sleep(2000);
        tabHeaderUserName();
        item_header_drop_Logout.waitUntil(visible, 1000).click();

    }
    @Step
    public AuthorHeaderMenuHelper logoutFromApp1() {
        refresh();
        sleep(2000);
        tabHeaderUserName();
        item_header_drop_Logout1.waitUntil(visible, 1000).click();
        return page(AuthorHeaderMenuHelper.class);
    }
    @Step
    public void tabHeaderUserName() {
        clickAfterWaitVisible(tab_header_Username, 10000);
    }
    @Step
    public void goToPropertyPage() {
        tab_header_FindHome.waitUntil(appears, 1000).hover();
        sleep(1000);
        tab_header_AllProperties.waitUntil(appears, 1000).click();
    }
    @Step
    public void goToFMpage() {
        tab_header_GoFMPage.waitUntil(appears, 1000).click();
     }
    @Step
    public void submitLogin() {
        button_popup_login_Submit.click();
        sleep(1000);
    }
    @Step
    public void LoginFacebookWithActiveAccount(String email, String password) {
        sleep(2000);
        field_fb_Email.setValue(email);
        sleep(1000);
        field_fb_Password.setValue(password);
        button_login_FB.click();
    }


    @Step
    public void LoginFacebookWithNewAccount(String confEmail, String confPassword) {
        sleep(2000);
        field_fb_Email.setValue(ConfData.getData(confEmail));
        field_fb_Password.setValue(ConfData.getData(confPassword));
        button_login_FB.click();
        //switchTo().alert().dismiss();


    }
    @Step
    public void LoginGoogleWithNewAccount(String confEmail, String confPassword) {
        sleep(2000);
        field_G_Email.setValue(ConfData.getData(confEmail));
        button_G_Email_next.click();
        field_G_Password.setValue(ConfData.getData(confPassword));
        button_G_Password_next.click();
        sleep(2000);
       if(button_G_allow_birth.exists()){
           sleep(1000);
            button_G_allow_birth.click();
            sleep(1000);
            button_G_allow_birth2.click();
       }

    }

    @Step
    public void LoginLinkedLnWithNewAccount(String confEmail, String confPassword) {
        sleep(2000);
        field_LinledLn_Email.setValue(ConfData.getData(confEmail));
        field_L_Password.setValue(ConfData.getData(confPassword));
        button_L_Password_next.click();
        sleep(2000);
        /*if(button_G_allow_birth.exists()){
            sleep(1000);
            button_G_allow_birth.click();
            sleep(1000);
            button_G_allow_birth2.click();
        }*/

    }
    @Step
    public void LoginLinkedLnWithActiveAccount(String confEmail, String confPassword) {
        sleep(2000);
        field_LinledLn_Email.setValue(ConfData.getData(confEmail));
        sleep(1000);
        field_L_Password.setValue(ConfData.getData(confPassword));
        sleep(1000);
        button_L_Password_next.click();
    }
    @Step
    public void clickSignUp_In_WithFacebook() {
        clickAfterWaitVisible(button_popup_FB, 4000);

    }


    @Step
    public void clickSignUp_In_WithGoogle() {
        clickAfterWaitVisible(button_popup_Google, 4000);
    }
    @Step
    public void clickSignUp_In_WithLinkedLn() {
        clickAfterWaitVisible(button_popup_LinkedLn, 4000);
    }

    @Step("Verifying Join on Free button")
    public void clickJoinFreeButton() {
        tab_header_JoinFree.waitUntil(visible, 5000).click();
    }
    @Step
    public void removeAccount() {
        button_listing_Remove.waitUntil(appears, 4000).click();
        confirm(" Are you sure you want to  fully delete the account? The account can not be restored after this.");
        sleep(2000);
    }
    @Step
    public void removeAccountBeforeTest() {
        sleep(1000);
        if(notif_incorrect_EmailPassword.exists()){
            //signUpHelper.quitLogin();
        }else{
            removeAnyAccount();
        }
    }
    @Step
    public static void clickSignInButtonInForm() {
        //clickAfterWaitVisible(link_SignIn, 10000);
        link_SignIn.waitUntil(visible, 10000).click();
    }
    @Step
    public static void clickLogInButtonInForm() {
        link_LogIn.waitUntil(visible, 10000).click();
    }


    @Step
    public void clickSignInButtonInPopup() {
        sleep(2000);
        hoverClick1(popup_SignIn);

    }
    @Step
    public void clickSignInButtonInPopupPhone() {
        sleep(2000);
        popup_SignIn_phone.waitUntil(visible, 1000).hover().click();
    }
    @Step
    public void chooseMenu_My_profile() {
        clickAfterWaitVisible(drop_Menu_My_profile, 5000);
    }
    @Step
    public void chooseTabFromInnerMenuDashboard(final String item) {
        $(byXpath(tab_inner_header1 + item + tab_inner_header2)).click();
    }
    @Step
    public void clickClosePopupSignUp() {
        sleep(1000);
        if (popup_button_close_SignUp.isDisplayed()){
            popup_button_close_SignUp.click();
        }else {}
    }
    @Step
    public void FindHomeInMenu() {
        tab_header_FindHome.waitUntil(appears, 1000).click();
    }
    @Step
    public void headerLogin() {
        tab_header_Login.waitUntil(appears, 1000).click();
    }
    @Step
    public void setLoginAsUserWithoutPackage(String confEmail) {
        fillInField(ConfData.getData(confEmail), field_login_Username);
    }
    @Step
    public void setLoginAsUserWithoutPackage1(String confEmail) {
        fillInField(confEmail, field_login_Username);
    }
    @Step
    public void setPassword1(String confPassword) {
        field_login_Password.waitUntil(visible, 1000).setValue(confPassword);
    }
    @Step
    public void setPassword(String confPassword) {
       field_login_Password.waitUntil(visible, 1000).setValue(ConfData.getData(confPassword));
    }
    @Step
    public void login(String confPassword, String confEmail){
        clickJoinFreeButton();
        clickSignInButtonInForm();
        login2(confEmail,confPassword);
        submitLogin();
    }

    @Step
    public void loginMessage(String confEmail, String confPassword) {
        login(confPassword, confEmail);
        closeListRenewPopUp();
        closeMatchPopUp();
    }
    @Step
    public void login2(String confEmail, String confPassword) {
        setLoginAsUserWithoutPackage(confEmail);
        setPassword(confPassword);
    }
    @Step
    public void loginTest1(String UserName, String Password) {
        setLoginAsUserWithoutPackage1(UserName);
        setPassword1(Password);
    }
    @Step
    public void removeAnyAccount() {
        closeListRenewPopUp();
        closeMatchPopUp();
        addPropertyHelper.openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("70% complete");
        chooseMenu_My_profile();
        chooseTabFromInnerMenuDashboard("Settings");
        removeAccount();

        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Step
    public void chooseSettingsMenu() {
        closeListRenewPopUp();
        closeMatchPopUp();
        addPropertyHelper.openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("70% complete");
        chooseMenu_My_profile();
        chooseTabFromInnerMenuDashboard("Settings");

    }
    @Step
    public void loginBuddy_up(String confPassword, String confEmail){

        login2(confEmail,confPassword);
        submitLogin();
    }
    @Step
    public void loginHeader1(String Password, String UserName){
        open("http://front.idealflatmate4test.demo.devplatform2.com/auth/login");
        loginTest1(UserName,Password);
        submitLogin();
    }
    @Step
    public void loginHeader2(String confPassword, String confEmail){
        pageUrlVerifStageGoLive();
        headerLogin();
        loginTest1(confEmail,confPassword);
        submitLogin();
    }
    @Step
    public void checkResetEmail(String confEmail) {
        reset.click();
        fillInField(ConfData.getData(confEmail), $(field_reset_Email));
        $(byXpath(button_submit_Reset)).click();

    }
    @Step("click and change profile")
    public void changeProfile() {
        clickEditProfile.click();
        clickAfterWaitVisible($(byXpath("//h2[contains(.,'Profile Picture')]")), 3000);
        photoClick.uploadFile(new File("src/test/resources/profile1.jpeg"));
        clickAfterWaitAppear(button_savePhoto, 30000);

        scrollDownPageOn("600");
        $(byXpath("//label[input[@id='profile-looking_buddy']]")).click();

        $(byXpath("//input[@id='profile-first_name']")).clear();
        $(byXpath("//input[@id='profile-first_name']")).sendKeys("Tolly");
        $(byXpath("//a[@href='#section3' or contains(.,'Property Preferences')]")).click();
        $(byXpath("//select[@id='userspace-move_in_date']")).selectOptionContainingText("January (2020)");

        $(byXpath("//select[@id='profile-occupation_id']")).selectOptionByValue("227");
        $(byXpath("//textarea[@id='profile-bio']")).clear();
        scrollDownPageOn("800");
        $(byXpath("//input[@id='userspace-locationkeysearch']")).sendKeys("watch");
        $(byXpath("//li[@class='ui-menu-item']/div[contains(.,'Watchetts')]")).click();
        $(byXpath("//input[@id='userspace-budget_max']")).clear();
        $(byXpath("//input[@id='userspace-budget_max']")).sendKeys("1500");
        $(byXpath("//select[@id='flatmate_gender']")).selectOptionByValue("2");
        $(byXpath("//a[@href='#section3' or contains(.,'Property Preferences')]")).click();
    }
    @Step
    public String getDateMoveIn() {
        String s =  $(byXpath("//select[@id='userspace-move_in_date']/option[contains(.,'January (2020)')]")).getValue();
        //newMoveInDate.toCharArray();
        char result1 = s.charAt(0);
        char result2 = s.charAt(1);
        char result3 = s.charAt(2);
        char result4 = s.charAt(3);
        char result5 = s.charAt(4);
        char result6 = s.charAt(5);
        char result7 = s.charAt(6);
        char result8 = s.charAt(7);
        char result9 = s.charAt(8);
        char result10 = s.charAt(9);

        char[] a = {result9,result10,result8,result6,result7,result5,result1,result2,result3,result4};
        String b = new String(a);
        //Stream<Character> st = Stream.of(result9,result10,result8,result6,result7,result5,result1,result2,result3,result4);
        //String newMoveInDate = st.map(c->c.toString()).collect(Collectors.joining());
        //return newMoveInDate;
        return b;
    }


}