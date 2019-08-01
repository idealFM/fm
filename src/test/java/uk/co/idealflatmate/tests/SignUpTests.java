package uk.co.idealflatmate.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import uk.co.idealflatmate.appmanager.AuthorHeaderMenuHelper;
import uk.co.idealflatmate.appmanager.HelperBase;
import uk.co.idealflatmate.appmanager.ProfileData;
import utils.ConfData;

import static com.codeborne.selenide.Selenide.*;
import static uk.co.idealflatmate.appmanager.HelperBase.*;

//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;


public class SignUpTests extends TestBase {
    @AfterMethod

    public void closeMethod() {
        close();
    }


    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearBrowserCookies();
        clearCache();
    }
    @Features("without removing account")
    @Stories("blankFields")
    @Test
    public void testSignUpBlankFieldsPropAddRentBlock() {

        addPropertyHelper.pressAddListingNotLoggedBlock();
        addPropertyHelper.selectTypeUser( "A current tenant");

        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        sleep(1000);
        signUpHelper.quit();
        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");


    }
    @Features("without removing account")
    @Stories("blankFields")
    @Test
    public void testSignUpBlankFieldsPropAddWorkBlock() {

        addPropertyHelper.pressAddListingNotLoggedBlock1();
        addPropertyHelper.selectTypeUser( "A current tenant");

        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        sleep(1000);
        signUpHelper.quit();
        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }
    @Features("with removing account")
    @Stories("Home")
    @Test
    public void testHeaderRoomSignUpHomePageFM() {
        String location1 = "Watford";
        String name = "Ronaldina";
        String newEmail = ConfData.getData("Tenant1");

        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();
        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickRoom();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", name, "Tenant1", "Female");


        //signUpHelper.profilePhotoAddJpeg10Mb();
       // verificationHelper.profilePhoto10Mb();
       // signUpHelper.profilePhotoAddPdf();
       // verificationHelper.profilePhotoPdf();

        signUpHelper.profileDateBirthAdd("2", "5", "2000");

        signUpHelper.profilePhone("3456666666");

        signUpHelper.occupation("19", "Professional", "Student");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.backClick();
        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation("Watf", location1);
        signUpHelper.clickYourInformationContinue();

        signUpHelper.budgetMin();
        //signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();
        signUpHelper.selectMoveDate("8", "8", "2019");
        signUpHelper.selectHappyReceiveNews();
        signUpHelper.clickYourInformationContinue();

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);

        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        authorizationHelper.clickClosePopupSignUp();

        //verificationHelper.verifySearchListingPage();
        verificationHelper.verificationUserNameOnHomePage(name);

        getAddPropertyHelper().openDropDownMenu();
       // verificationHelper.verifyProfComplMenu("80% complete");
        authorizationHelper.chooseMenu_My_profile();
        verificationHelper.profileDisplays(new ProfileData("percentComplete9",  "myProfile9",
                "name9", "age9","lookingFor9", "aboutMe9","rooms9",
                "amountPropCards9"));

        authorizationHelper.removeAnyAccount();

    }
    @Features("without removing account")
    @Stories("blankPhoto")
    @Test
    public void testPhotoVerificationSignUpHomePageFM() {

        String name = "Ronaldina";


        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();
        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickRoom();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", name, "Photo1", "Female");

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profilePhotoAddPng();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profilePhotoAddJpg();
        signUpHelper.profilePhotoRemove();

        signUpHelper.occupation("19", "Professional", "Student");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.quit();
        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }
    @Features("without removing account")
    @Stories("blankPhone")
    @Test
    public void testPhoneSignUpHomePageFM() {
        String location1 = "Watford";
        String name = "Ronaldina";
        String newEmail = ConfData.getData("Phone1");

        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();
        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickRoom();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", name, "Tenant1", "Female");


        signUpHelper.profilePhotoAddJpg();

        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        verificationHelper.phoneVerification("Phone cannot be blank.", "          ");
        verificationHelper.phoneVerification("Phone is invalid.", "55555555d");
        verificationHelper.phoneVerification("Please enter a valid phone number (Need Help?)", "00000000000");
        verificationHelper.phoneVerification("Please enter a valid phone number (Need Help?)", "555555555");
        verificationHelper.phoneVerification("Please enter a valid phone number (Need Help?)", "d5555555");
        verificationHelper.phoneVerification("Phone is invalid.", "dfsfdfsdf");
        verificationHelper.phoneVerification("Please enter a valid phone number (Need Help?)", "+()55555555");

        signUpHelper.profilePhone("3456666666");


        signUpHelper.occupation("19", "Professional", "Student");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.quit();
        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }
    @Features("with removing account")
    @Stories("Listing flow")
    @Test
    public void testHeaderSignUpHomePageFMSearchLiv_inWithoutAbout() {
        String name = "Donald";
        String newEmail = ConfData.getData("LiveIn2");

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.signListingFM_LiveIn("LiveIn2", "passwUniv",
                                        "5", "5", "1959", "03456666666", "19",
                                        name, "Professional", "Student");

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing();
        closeMatchPopUp();

        //verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage(name);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        verificationHelper.profileDisplays(new ProfileData("percentComplete10",  "myProfile10",
                "name10", "age10","lookingFor10", "aboutMe10","rooms10",
                "amountPropCards10"));

        //matchingHelper.closePopupMatching();
        closeMatchPopUp();

        //signUpHelper.verificationDataProfileNameUser("live-in landlord");

        authorizationHelper.removeAnyAccount();

    }

    @Features("with removing account")
    @Stories("Listing flow")
    @Test
    public void testHeaderSignUpHomePageConfirmNewEmail() {
        AuthorHeaderMenuHelper a = new AuthorHeaderMenuHelper();
        String name = "Donald";
        String newEmail = ConfData.getData("LiveInChange");
        String emailRandom = randomString(8) + ConfData.getData("baseGmail");

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.signListingFM_LiveInRandom( "passwUniv", name);


        helperBase.fillInField(emailRandom, signUpHelper.emailInput);
        signUpHelper.clickYourInformationContinue();

        signUpHelper.More_about_you("5", "5", "1959", "03456666666", "19",
                "Professional", "Student");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.confirmNewGmailSignUp(emailRandom, emailRandom, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing();
        closeMatchPopUp();

        //verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage(name);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        verificationHelper.profileDisplays(new ProfileData("percentComplete10",  "myProfile10",
                "name10", "age10","lookingFor10", "aboutMe10","rooms10",
                "amountPropCards10"));

        //matchingHelper.closePopupMatching();
        closeMatchPopUp();

        //signUpHelper.verificationDataProfileNameUser("live-in landlord");

        authorizationHelper.chooseSettingsMenu();
        Assert.assertEquals(signUpHelper.getEmailfromSettings(), newEmail);

        a.removeAccount();
        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }



    @Features("without removing account")
    @Stories("blankFields")
    @Test
    public void testHeaderSignUpWithExistingEmail() {

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.clickEmail();
        signUpHelper.setSignUpNameF("Ronald");

        verificationHelper.verificationFieldLenth(460);


        //helperBase.closeOpen("");

        //signUpHelper.genderFemaleSelect();
        signUpHelper.setSignEmail("agency3");
        signUpHelper.setSignPassword("passwUniv");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.quit();
        sleep(1000);
        signUpHelper.quit();
        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");
     }
    @Features("without removing account")
    @Stories("blankFields")
    @Test
    public void testHeaderSignUpWithBlankRequiredFieldsYourInf() {

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("A current tenant");

        signUpHelper.clickEmail();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        sleep(1000);
        signUpHelper.quit();
        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Features("without removing account")
    @Stories("blankFields")
    @Test
    public void testHeaderSignUpWithBlankRequiredFieldsMoreAboutYou() {

        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("A current tenant");
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMnew1", "Female");
        signUpHelper.clickYourInformationContinue();
        verificationHelper.dateMonthYearPhoneOccupationBlankError();

        signUpHelper.quit();
        verificationHelper.ListingStart("Start your listing here");
        signUpHelper.quit();

        verificationHelper.verificationUserIsUnlogged("Join Free");
    }
    @Features("with removing account")
    @Stories("Listing flow")
    @Test
    public void testTenantProfileChanging() {
        String newEmail = ConfData.getData("TenantP");
        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("A current tenant");
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Molly", "TenantP", "Female");

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("03456666666");
        signUpHelper.occupation("19", "Professional", "Student");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing();
        noCloseMatchPopUp();

        verificationHelper.verificationUserNameOnHomePage("Molly");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();

        verificationHelper.profileDisplays(new ProfileData("percentComplete16",  "myProfile16",
                "name16", "age16","lookingFor16", "aboutMe16","rooms16",
                "amountPropCards16"));

        authorizationHelper.changeProfile();
        String newMoveInDate = authorizationHelper.getDateMoveIn();
        authorizationHelper.clickSaveProfile.click();

        verificationHelper.profileDisplaysForEdit(new ProfileData("percentComplete17",  "myProfile16",
                "name17", "age16","lookingFor17", "aboutMe18","rooms16",
                "amountPropCards16"), newMoveInDate);

        authorizationHelper.removeAnyAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
    @Features("without removing account")
    @Stories("blankFields")
    @Test
    public void testHeaderSignUpWithBlankRequiredFieldsLocation() {

        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();
        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickRoom();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMnew2", "Female");

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("03456666666");
        signUpHelper.occupation("19", "Professional", "Student");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.backClick();
        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.clickYourInformationContinue();
        verificationHelper.checkLocationBlank();

        signUpHelper.quit();
        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }
    @Features("without removing account")
    @Stories("blankFields")
    @Test
    public void testHeaderSignUpWithBlankRequiredFieldsBudget() {

        authorizationHelper.clickJoinFreeButton();

        signUpHelper.clickRoom();
        signUpHelper.backFromEmailToRoom();
        signUpHelper.clickRoom();

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMnew3", "Female");

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("03456666666");
        signUpHelper.occupation("19", "Professional", "Student");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.backClick();
        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation("Watf", "Watford");
        signUpHelper.clickYourInformationContinue();

        //signUpHelper.clickYourInformationContinue();
        //verificationHelper.budgetError();

        signUpHelper.quit();
        verificationHelper.isHomePage("Flatshare and Houseshare Across the UK: ideal flatmate");
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }


    @Features("with removing account")
    @Stories("social")
    @Test
    public void testHeaderSignUpViaFacebook() {
        String location1 = "Zone 1";
        String location2 = "Watford";
        String location3 = "North London";
        String name = "Francine";

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        authorizationHelper.clickSignUp_In_WithFacebook();
        //authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        authorizationHelper.LoginFacebookWithNewAccount("FBook2", "passwFB2");
        signUpHelper.backClick();
        signUpHelper.setSignPassword("passwUniv");
        signUpHelper.genderCheckerPrefer();
        signUpHelper.genderMaleSelect();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("03456666666");
        signUpHelper.occupation("20", "Professional", "Freelancer/self employed");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.preferredLocationButton(location1);
        signUpHelper.preferredLocation("Watf",location2);
        signUpHelper.preferredLocationButton(location3);
        signUpHelper.clickYourInformationContinue();

        signUpHelper.budgetMin();
        //signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage(name);
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        //matchingHelper.closePopupMatching();
        verificationHelper.profileDisplays(new ProfileData("percentComplete11",  "myProfile11",
                "name11", "age11","lookingFor11", "aboutMe11","rooms11",
                "amountPropCards11"));
        signUpHelper.verificationDataProfileFotoDashboard();

        authorizationHelper.removeAnyAccount();


    }
    @Features("with removing account")
    @Stories("social")
    @Test
    public void testHeaderSignUpViaGoogle() {
        String location1 = "Zone 1";
        String location2 = "Watford";
        String location3 = "North London";
        String name = "Met";
        String age = "60";

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        authorizationHelper.clickSignUp_In_WithGoogle();
        authorizationHelper.LoginGoogleWithNewAccount("Google1New", "passwGoogle1New");
        //signUpHelper.setSignPassword("passwUniv");
        //signUpHelper.genderMaleSelect();
        //signUpHelper.clickYourInformationContinue();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("03456666666");
        signUpHelper.occupation("20", "Professional", "Freelancer/self employed");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.preferredLocationButton(location1);
        signUpHelper.preferredLocation("Watf",location2);
        signUpHelper.preferredLocationButton(location3);
        signUpHelper.clickYourInformationContinue();

        signUpHelper.budgetMin();
        //signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage(name);
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        //matchingHelper.closePopupMatching();
        verificationHelper.profileDisplays(new ProfileData("percentComplete19",  "myProfile19",
                "name19", "age19","lookingFor19", "aboutMe19","rooms19",
                "amountPropCards19"));
        signUpHelper.verificationDataProfileFotoDashboard();


        authorizationHelper.removeAnyAccount();


    }


    @Features("with removing account")
    @Stories("social")
    @Test
    public void testHeaderSignUpViaLinkedLn() {
        String location1 = "Zone 1";
        String location2 = "Watford";
        String location3 = "North London";
        String name = "Ned";
        String age = "60";

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        authorizationHelper.clickSignUp_In_WithLinkedLn();
        authorizationHelper.LoginLinkedLnWithNewAccount("LinkedLn1New", "passwLinkedLn1New");
        //signUpHelper.setSignPassword("passwUniv");
        //signUpHelper.genderMaleSelect();
        //signUpHelper.clickYourInformationContinue();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("03456666666");
        signUpHelper.occupation("20", "Professional", "Freelancer/self employed");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.preferredLocationButton(location1);
        signUpHelper.preferredLocation("Watf",location2);
        signUpHelper.preferredLocationButton(location3);
        signUpHelper.clickYourInformationContinue();

        signUpHelper.budgetMin();
        //signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        verificationHelper.verificationUserNameOnHomePage(name);
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        //matchingHelper.closePopupMatching();
        verificationHelper.profileDisplays(new ProfileData("percentComplete20",  "myProfile20",
                "name20", "age20","lookingFor20", "aboutMe20","rooms20",
                "amountPropCards20"));
        signUpHelper.verificationDataProfileFotoDashboard();


        authorizationHelper.removeAnyAccount();


    }
    @Features("with removing account")
    @Stories("social")
    @Test
    //Facebook authorization doen`t work on staging

    public void testSignUpViaFBlistingAgent() {
        String name = "Kron";

        addPropertyHelper.pressAddListingFromHeaderNotLoggedUser();
        addPropertyHelper.selectTypeUser( "An agency");

        authorizationHelper.clickSignUp_In_WithFacebook();


        authorizationHelper.LoginFacebookWithNewAccount("FB3", "passwFB2");
        //signUpHelper.backClick();
        //signUpHelper.setSignPassword("passwUniv");
        //signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhone("03456666666");
        signUpHelper.aboutAgency("I am an agent", "About your agency");
        signUpHelper.clickYourInformationContinue();

        addPropertyHelper.saveQuitHeaderMenuListing();
        noCloseMatchPopUp();

        verificationHelper.verificationUserNameOnHomePage(name);
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        //matchingHelper.closePopupMatching();
        verificationHelper.profileDisplays(new ProfileData("percentComplete15",  "myProfile15",
                "name15", "age15","lookingFor15", "aboutMe15","rooms15",
                "amountPropCards15"));
        signUpHelper.verificationDataProfileFotoDashboard();


        authorizationHelper.removeAnyAccount();

    }

    //@Test
    public void SuccessfulSignUpWithListingWithAllFields() {
        HelperBase.closeAdvPopUp();
        verificationHelper.ageConfirmCheckMatching();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
    @Features("with removing account")
    @Stories("Listing flow")
    @Test
    public void testListingSignUpHeader() {
        String name = "Kron";
        String newEmail = ConfData.getData("LiveOut2");
        //helperBase.closeOpen("http://front.idealflatmate4test.demo.devplatform2.com/");
        addPropertyHelper.bottomAddListing();
        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.clickEmail();
        signUpHelper.setSignUpNameF(name);
        signUpHelper.setSignEmail("LiveOut2");
        signUpHelper.setSignPassword("passwUniv");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhone("03456666666");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing();
        closeMatchPopUp();

        //verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage(name);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        verificationHelper.profileDisplays(new ProfileData("percentComplete12",  "myProfile12",
                "name12", "age12","lookingFor12", "aboutMe12","rooms12",
                "amountPropCards12"));
        authorizationHelper.removeAnyAccount();

    }
    @Features("with removing account")
    @Stories("Listing flow")
    @Test
    public void testListingSignUpFromHomepage() {
        String name = "Kron";
        String age = "18";
        String newEmail = ConfData.getData("live-In1");

        addPropertyHelper.pressAddListingNotLogged();
        addPropertyHelper.selectTypeUser("Live-in landlord"); //LiveInLord

        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", name, "live-In1", "Female");

        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.profilePhotoRemove();
        signUpHelper.profileDateBirthAdd("2", "5", "2000");
        signUpHelper.profilePhone("03456666666");
        signUpHelper.occupation("227", "Professional", "Other");
        signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing();
        closeMatchPopUp();

        verificationHelper.verificationUserNameOnHomePage(name);
        //verificationHelper.verifyAddListingPage();

        getAddPropertyHelper().openDropDownMenu();
        //verificationHelper.verifyProfComplMenu("80% complete");
        authorizationHelper.chooseMenu_My_profile();
        closeMatchPopUp();
        verificationHelper.profileDisplays(new ProfileData("percentComplete13",  "myProfile13",
                "name13", "age13","lookingFor13", "aboutMe13","rooms13",
                "amountPropCards13"));
        authorizationHelper.removeAnyAccount();

    }


}
