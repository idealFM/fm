package uk.co.idealflatmate.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.ProfileData;
import utils.ConfData;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.close;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;


public class SignUpMatchingTests extends TestBase {
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }
    @AfterMethod

    public void closeMethod() {
        close();
    }


    @Test

    public void testSignUpMatchingWithBlankFirstName() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.verifyBlankNameMatchSign();
        matchingHelper.quitQuiz();
    }

    @Test


    public void testSignUpMatchingWithRequiredFieldsRoom() {
        String name = "Ronaldina";
        String location = "Watford";
        String age = "42";
        String newEmail = ConfData.getData("FMMatch5");

        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName(name);
        matchingHelper.clickARoom();

        //matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.yourInformation("passwUniv", name, "FMMatch5", "Female");
        signUpHelper.moreAboutYou("15","2","1977","3456666666","20","Tell us about yourself",
                                                "Professional", "Freelancer/self employed");


        signUpHelper.backClick();
        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation( "watf", location);
        signUpHelper.clickYourInformationContinue();


        //signUpHelper.budgetMax();
        //signUpHelper.clickYourInformationContinue();
        //verificationHelper.budgetError();


        signUpHelper.budgetMin();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();
        signUpHelper.selectMoveDate("8", "8", "2019");
        signUpHelper.selectHappyReceiveNews();
        signUpHelper.clickYourInformationContinue();

        signUpHelper.clickShowMeMyMatches();

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        //signUpHelper.clickShowMeMyMatches();
        verificationHelper.verifySearchListingPageMatching();

        getAddPropertyHelper().openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");
        matchingHelper.chooseMatchingFromDropDownMenu();
        matchingHelper.verificationResultOfMatching();

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        verificationHelper.profileDisplays(new ProfileData("percentComplete8",  "myProfile8",
                "name8", "age8","lookingFor8", "aboutMe8","rooms8",
                "amountPropCards8"));

        verificationHelper.verificationUserNameOnHomePage(name);

        authorizationHelper.removeAnyAccount();

    }


    @Test
    public void testSignUpMatchingWithRequiredFieldsFMRoom() {
        String newEmail = ConfData.getData("FMMatch4");
        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();

        matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMMatch4", "Female");
        signUpHelper.moreAboutYou("15","2","1977","3456666666","227",
                    "Tell us about yourself", "Professional", "Other");

        signUpHelper.clickListYourRoomMatching();

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyAddListingPage();
        addPropertyHelper.openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");
        authorizationHelper.chooseMenu_My_profile();
       // matchingHelper.closePopupMatching();
        //signUpHelper.verificationDataProfileNameUser("flatmate");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.removeAnyAccount();

    }

    @Test
    public void testSignUpMatchingWithRequiredFieldsFMRoomSearchFM() {
        String newEmail = ConfData.getData("FMMatch6");
        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();

        matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMMatch6", "Female");
        signUpHelper.moreAboutYou("15","2","1977","3456666666","227",
                     "Tell us about yourself", "Professional", "Other");

        signUpHelper.clickSearchFMMatching();

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));
        //signUpHelper.clickSearchFMMatching();
        verificationHelper.verifySearchFMPage();
        //verificationHelper.verifyAddListingPage();

        getAddPropertyHelper().openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");
        authorizationHelper.chooseMenu_My_profile();
       // matchingHelper.closePopupMatching();
        signUpHelper.verificationDataProfileNameUser("Ronald", "42");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        authorizationHelper.removeAnyAccount();

    }


    @Test
    public void testSignUpWithMatchingWithBlankRequiredFields() {
        pageUrlVerifLiveGoStage();
        clearCache();
        matchingHelper.clickHomePageMatching();

        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();

        matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.clickYourInformationContinue();

        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

}
