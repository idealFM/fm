package uk.co.idealflatmate.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.AuthorHeaderMenuHelper;
import uk.co.idealflatmate.appmanager.ProfileData;
import utils.ConfData;

import static com.codeborne.selenide.Selenide.*;
import static uk.co.idealflatmate.appmanager.AuthorHeaderMenuHelper.clickLogInButtonInForm;
import static uk.co.idealflatmate.appmanager.AuthorHeaderMenuHelper.clickSignInButtonInForm;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifStageGoLive;

//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;


public class RegistrationTests extends TestBase {

    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    public void classicLogInOut() {

        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMNotPaid");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void classicResetPassword() {

        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.checkResetEmail("FMNotPaid");
        verificationHelper.isResetSuccessful();
    }

    @Test
    public void logInOutOnPropertyPage() {

        AuthorHeaderMenuHelper homepage = open("http://front.idealflatmate4test.demo.devplatform2.com/", AuthorHeaderMenuHelper.class);
        authorizationHelper.goToPropertyPage();


        authorizationHelper.clickSignInButtonInPopup();
        authorizationHelper.setLoginAsUserWithoutPackage("FMNotPaid");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("Borris");


        homepage.logoutFromApp1();
        //AuthorHeaderMenuHelper.logoutFromApp1();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void logInOutOnFMPage() {

        authorizationHelper.goToFMpage();
        authorizationHelper.clickSignInButtonInPopup();
        authorizationHelper.setLoginAsUserWithoutPackage("FMNotPaid");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void emailWrongHomePage() {

        //helperBase.pageUrlHomeNew();
        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("fmNotPaid5");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.passwWrongAlertHome();

        signUpHelper.quit();
    }

    @Test
    public void loginPassWronglogInHomePage() {

        clearCache();
        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMNotPaid");
        authorizationHelper.setPassword("passwWrong");
        authorizationHelper.submitLogin();

        verificationHelper.passwWrongAlertHome();

        signUpHelper.quit();
    }

    @Test
    //Facebook authorization doen`t work on staging
    public void addLogInViaFacebook() {

        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.clickSignUp_In_WithFacebook();
        authorizationHelper.LoginFacebookWithNewAccount("FB1","passwFB1");
        open("http://front.idealflatmate4test.demo.devplatform2.com");
        verificationHelper.verificationUserNameOnHomePage("Artem");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
    @Test
    public void addLogInViaGoogle() {

        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.clickSignUp_In_WithGoogle();
        authorizationHelper.LoginGoogleWithNewAccount("Google1", "passwGoogle1");
        open("http://front.idealflatmate4test.demo.devplatform2.com");
        verificationHelper.verificationUserNameOnHomePage("Met Damon");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
    @Test
    public void addLogInViaLinkedLn() {

        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.clickSignUp_In_WithLinkedLn();
        authorizationHelper.LoginLinkedLnWithActiveAccount("LinkedLn1","passwLinkedLn1");
        open("http://front.idealflatmate4test.demo.devplatform2.com");
        verificationHelper.verificationUserNameOnHomePage("Met");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void alogInWithMatchingFB() {

        pageUrlVerifStageGoLive();
        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        matchingHelper.clickAFM();

        matchingHelper.clickContinueMatching1();
        matchingHelper.clickContinueMatching2();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        matchingHelper.clickContinueMatching7();
        matchingHelper.clickContinueMatching8();
        matchingHelper.clickContinueMatching9();
        matchingHelper.clickContinueMatching10();
        matchingHelper.clickContinueMatching11();
        matchingHelper.clickContinueMatching12();
        matchingHelper.clickContinueMatching13();
        matchingHelper.clickContinueMatching14();
        matchingHelper.clickContinueMatching15();
        matchingHelper.clickContinueMatching16();
        matchingHelper.clickContinueMatching17();
        matchingHelper.clickContinueMatching18();
        matchingHelper.clickContinueMatching19();
        matchingHelper.clickContinueMatching20();
        clickLogInButtonInForm();
        authorizationHelper.clickSignUp_In_WithFacebook();
        authorizationHelper.LoginFacebookWithActiveAccount(ConfData.getData("FB1"), ConfData.getData("passwFB1"));
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }



    @Test
    public void invalidLoginWithEmptyFields() {

        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.submitLogin();
        verificationHelper.VerificationLoginPassError();
        verificationHelper.VerificationLoginNameError();
        signUpHelper.quit();
       //verificationHelper.VerificationMessagesTabIsAbsent();
    }

    @Test
    public void logInMesPropVerifProfilePageFull() {


        searchHelper.searchPropertyByEnter("Hounslow");
        searchHelper.closePopupSignup();
        messageHelper.clickPropertyCardMessageUnlogged("52369");
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMwithoutSub");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("FM_Manch_2");
        verificationHelper.verifyPageMessage();
        //clearCache();
        messageHelper.clickMessagePropOwnerIcon();
        messageHelper.clickImgOwnerOnPropertyPage();
        verificationHelper.profileDisplays(new ProfileData("percentComplete14",  "myProfile14",
                "name14", "age14","lookingFor14", "aboutMe14","rooms14",
                "amountPropCards14"));

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void logInContactProperty() {

        searchHelper.searchPropertyByEnter("Hounslow");
        searchHelper.closePopupSignup();

        messageHelper.clickCardImgProperty("4 Hollygrove Close, Hounslow, TW3 3NE, UK");
        //authorizationHelper.clickClosePopupSignUp();
        messageHelper.clickPropertyContact();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMwithoutSub");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("FM_Manch_2");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void logInMessageFM() {

        authorizationHelper.goToFMpage();
        authorizationHelper.clickClosePopupSignUp();
        getMessageHelper().clickFMCardMessageUnlogged();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMwithoutSub2");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void logInContactFM() {

        authorizationHelper.goToFMpage();
        authorizationHelper.clickClosePopupSignUp();
        getMessageHelper().clickFMCardFirstOnPage();
        getMessageHelper().clickFMContact();
        clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FMwithoutSub2");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
    @Test
    public void logInPhoneReveal() {

        getMessageHelper().clickPropertyCardFirstOnPage();
        getMessageHelper().clickPhoneReveal();
        authorizationHelper.clickSignInButtonInPopupPhone();
        authorizationHelper.setLoginAsUserWithoutPackage("FMwithoutSub2");
        authorizationHelper.setPassword("passwUniv");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

}

