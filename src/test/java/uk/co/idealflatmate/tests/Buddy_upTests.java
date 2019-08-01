package uk.co.idealflatmate.tests;

import uk.co.idealflatmate.appmanager.ProfileData;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static uk.co.idealflatmate.appmanager.AuthorHeaderMenuHelper.clickSignInButtonInForm;
import static uk.co.idealflatmate.appmanager.HelperBase.*;


public class Buddy_upTests extends TestBase {



   // @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }



    //@Test //(priority = 2)

    public void testNewBuddy_Up() {


        searchHelper.startNewBuddyUpSearch("London", "London", "+20 km");


        signUpHelper.click1PropCardMes("0");
        verificationHelper.signUpPopupName("Sign up to continue");
        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();
        //verificationHelper.passwordBlankAlertMessage();

        signUpHelper.yourInformation("passwUniv", "Ronald", "existingEmail", "Female");

        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.clearEmailMessage();
        signUpHelper.clearFirstnameMessage();
        //signUpHelper.clearGender();
        signUpHelper.clearPasswordMessage();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMupsBuddy1", "Female");
        sleep(2000);

        signUpHelper.clickYourInformationContinue();
        verificationHelper.dateMonthYearBlankErrorMessage();

        signUpHelper.moreAboutYou("10", "3", "1955", "58885588", "20",
                "I want to Buddy_upTests", "Professional", "Freelancer/self employed");

        //signUpHelper.clickBackToSearch();
        buddyUpHelper.closeIntrodGroupsPopup();


        messageHelper.clickMenuMessages();
        verificationHelper.noConverInbox("0 conversations");

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        verificationHelper.profileDisplays(new ProfileData("percentComplete6",  "myProfile6",
                "name6", "age6","lookingFor6", "aboutMe6","rooms6",
                "amountPropCards6"));
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        authorizationHelper.removeAnyAccount();
    }



   // @Test //(priority = 1)



    public void testAaabAddWholeProperty2() {

        authorizationHelper.login("passwUniv", "agentBuddyUp");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        closeMatchPopUp();
        addPropertyHelper.closeRenewPopup();

        //getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();
        addPropertyHelper.pressAddListingFromBody();

        addPropertyHelper.addListingWithoutPhotoBuddyUp("w2 ", "London W2, UK",
                "Bayswater","3", "900", "Area cannot be blank.");

        //addPropertyHelper.finishPropertyAgency();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyAddedProperty("London W2, UK");

        authorizationHelper.chooseTabFromInnerMenuDashboard("My profile");
        verificationHelper.profileDisplays(new ProfileData("percentComplete5",  "myProfile5",
                "name5", "age5","lookingFor5", "aboutMe5","rooms5",
                "amountPropCards5"));
        addPropertyHelper.chooseListingsFromDropDownMenu();
        addPropertyHelper.removeListingClick("0");

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        clearCache();
    }


    //@Test //(priority = 2)

    public void testBbbAaaMessageSignUpFMPageBuddy_Up() {

        //searchHelper.searchPropertyBySelectfromList("Caernarfon", "Caernarfon");
       // searchHelper.closePopupSignup();
       // searchHelper.selectRadius("+5 km");
       // searchHelper.verificationSearchPropertyMes("Castle Ditch, Caernarfon LL55 2AY, UK", 0);
        searchHelper.startBuddyUpSearch("Caernarfon", "Caernarfon", "+5 km",
                                         "Victoria Terrace, Llanberis, Caernarfon LL55 4TT, UK", "property_id2");

        String photo1 = $(byXpath("//div[@class='card-top-profile-img u_p5-right']/img")).getAttribute("src");
        //String name1 = $(byXpath("//span[@class='card-top-username']")).text();
        //String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();


        signUpHelper.click1PropCardMes("0");
        verificationHelper.signUpPopupName("Sign up to continue");
        signUpHelper.clickEmail();

        signUpHelper.clickYourInformationContinue();
        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();
        //verificationHelper.passwordBlankAlertMessage();

        signUpHelper.yourInformation("passwUniv", "Ronald", "existingEmail", "Female");

        verificationHelper.emailAlreadyExistedAlert();

        signUpHelper.clearEmailMessage();
        signUpHelper.clearFirstnameMessage();
        //signUpHelper.clearGender();
        signUpHelper.clearPasswordMessage();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMupsBuddy1", "Female");
        sleep(2000);

        signUpHelper.clickYourInformationContinue();
        verificationHelper.dateMonthYearBlankErrorMessage();

        signUpHelper.moreAboutYou("10", "3", "1955", "58885588", "20",
                "I want to Buddy_upTests", "Professional", "Freelancer/self employed");

        //signUpHelper.clickBackToSearch();
        buddyUpHelper.closeIntrodGroupsPopup();
        messageHelper.photoOfOwnerInMesBuddy_up(photo1);

        messageHelper.propertyPostcodeVerifying(postCode);

        messageHelper.clickMenuMessages();
        verificationHelper.noConverInbox("0 conversations");

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        verificationHelper.profileDisplays(new ProfileData("percentComplete6",  "myProfile6",
                "name6", "age6","lookingFor6", "aboutMe6","rooms6",
                "amountPropCards6"));
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        authorizationHelper.removeAnyAccount();
    }

   // @Test //(priority = 3)
    public void testCccButtonPropPage() {

        //searchHelper.searchPropertyBySelectfromList("Caernarfon", "Caernarfon");
        //searchHelper.closePopupSignup();
        //searchHelper.selectRadius("+5 km");
       // searchHelper.verificationSearchPropertyMes("Castle Ditch, Caernarfon LL55 2AY, UK", 0);
        searchHelper.startBuddyUpSearch("Caernarfon", "Caernarfon", "+5 km",
                                        "Victoria Terrace, Llanberis, Caernarfon LL55 4TT, UK", "property_id2");
        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();

        buddyUpHelper.clickCardProperty();
        buddyUpHelper.clickBuddy_upButton("m interested");
        verificationHelper.signUpPopupName("Sign up to continue");

        signUpHelper.clickEmail();
        signUpHelper.setSignUpNameFMessage("Ronald");
        signUpHelper.setSignEmailMessage("existingEmail");
        signUpHelper.setSignPasswordMessage("passwUniv");

        signUpHelper.quit();

        messageHelper.propertyPostcodeVerifying(postCode);
        verificationHelper.verificationUserIsUnlogged("Join Free");
        clearCache();
        refresh();
    }


    //@Test //(priority = 4)
    public void testDddGroupPropPageStartSignUp() {

        searchHelper.startBuddyUpSearch("ha0 1eh", "HA0 1EH", "+3 km",
                                        "Wembley HA0 1EH, UK", "property_id3");


        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();

        buddyUpHelper.clickCardProperty();

        buddyUpHelper.clickGroupSection();

        buddyUpHelper.clickCreateGroup();


        verificationHelper.signUpPopupName("Sign up to continue");

        signUpHelper.clickEmail();
        signUpHelper.setSignUpNameFMessage("Ronald");
        signUpHelper.setSignEmailMessage("existingEmail");
        signUpHelper.setSignPasswordMessage("passwUniv");

        signUpHelper.quit();

        messageHelper.propertyPostcodeVerifying(postCode);
        verificationHelper.verificationUserIsUnlogged("Join Free");
        clearCache();
        refresh();
    }



   // @Test //(priority = 5)
    public void testGggCardChatSignUpViaFB() {
        String id_property = "38204";

        pageUrlVerifStageGoLive();
        //idealfm_test@mail.co.uk user_id=92412
        searchHelper.startBuddyUpSearch1("Crew", "Crewe", "+5 km",
                "Crewe CW1 6BW, UK", id_property);

        String postcode = postCodeFromCard(id_property);

        signUpHelper.click1PropCardIDMes(id_property);

        authorizationHelper.clickSignUp_In_WithFacebook();
        //authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        authorizationHelper.LoginFacebookWithNewAccount("FB2", "passwFB2");
        signUpHelper.setSignPassword("passwUniv");
        signUpHelper.clickYourInformationContinue();
        signUpHelper.profileDateBirthAdd("5", "2", "1959");
        signUpHelper.profilePhone("5555555555");
        signUpHelper.occupation("19", "Professional", "Student");
        //signUpHelper.aboutYourself("Tell us about yourself");
        signUpHelper.clickYourInformationContinue();

        buddyUpHelper.closeIntrodGroupsPopup();

        messageHelper.propertyPostcodeVerifying(postcode);

        buddyUpHelper.closeIntrodGroupsPopup();
        messageHelper.clickMenuMessages();
        verificationHelper.noConverInbox("0 conversations");

        verificationHelper.verificationUserNameOnHomePage("Francine");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        //matchingHelper.closePopupMatching();
        verificationHelper.profileDisplays(new ProfileData("percentComplete7",  "myProfile7",
                "name7", "age7","lookingFor7", "aboutMe7","rooms7",
                "amountPropCards7"));
        signUpHelper.verificationDataProfileFotoDashboard();


        authorizationHelper.removeAnyAccount();

    }

   // @Test //(priority = 6)
    //Facebook authorization doen`t work on staging
    public void Z_z_addLogInViaFBBuddy_up() {
        String id_property = "38204";

        pageUrlVerifStageGoLive();
        searchHelper.startBuddyUpSearch1("Crew", "Crewe", "+5 km",
                                         "Crewe CW1 6BW, UK", id_property);
        String postcode = postCodeFromCard(id_property);

        signUpHelper.click1PropCardIDMes(id_property);

        authorizationHelper.clickSignUp_In_WithFacebook();
        //authorizationHelper.LoginFacebookWithNewAccount("ron1991d@gmail.com", "qqqqqq666D");
        authorizationHelper.LoginFacebookWithNewAccount("FB1", "passwFB1");

        verificationHelper.verificationUserNameOnHomePage("Alex");

        buddyUpHelper.closeIntrodGroupsPopup();

        messageHelper.propertyPostcodeVerifying(postcode);

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    //@Test //(priority = 7)

    public void testR_R_GroupCreate() {
        clearCache();
        refresh();
        searchHelper.startBuddyUpSearch("HA0 1EH", "HA0 1EH", "+3 km",
                                         "Wembley HA0 1EH, UK", "property_id3");



        String photo1 = $(byXpath("//div[@class='card-top-profile-img u_p5-right']/img")).getAttribute("src");
        //String name1 = $(byXpath("//span[@class='card-top-username']")).text();
        //String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();


        signUpHelper.click1PropCardMes("0");
        verificationHelper.signUpPopupName("Sign up to continue");
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMupsBuddy2", "Female");
        sleep(2000);
        signUpHelper.moreAboutYou("10", "3", "1955", "58885588", "19", "I want to Buddy_upTests", "Professional", "Student");
        messageHelper.photoOfOwnerInMesBuddy_up(photo1);
        messageHelper.propertyPostcodeVerifying(postCode);

        buddyUpHelper.clickBuddy_upButton("Choose Your Flatmates");

        //buddyUpHelper.popupGroup("Post a group");
        //buddyUpHelper.popupGroup("Create a Group");

        //buddyUpHelper.postGroupButton();

        buddyUpHelper.assertNumberOfGroupsPropPage(1);

        messageHelper.clickMenuMessages();
        buddyUpHelper.assertNumberOfMessInbox(1);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        buddyUpHelper.assertNumberOfMyGroups(1);
        buddyUpHelper.clickListingImgGroupCard();
        buddyUpHelper.clickGroupSection();

        buddyUpHelper.learnMore(0);
        buddyUpHelper.removeGroup(0);
        buddyUpHelper.yesRemoveGroup(0);

        //buddyUpHelper.closeIntrodGroupsPopup();

        buddyUpHelper.clickGroupSection();

        verificationHelper.textNoGroup("This property is available to rent as a whole. Click \"I'm interested\" to " +
                "start a group and choose your flatmates");

        messageHelper.clickMenuMessages();
        buddyUpHelper.assertNumberOfMessInbox(0);

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        buddyUpHelper.assertNumberOfMyGroups(0);
        homePageHelper.clickLogo();

        searchHelper.startBuddyUpSearch("HA0 1EH", "HA0 1EH", "+3",
                                        "Wembley HA0 1EH, UK", "property_id3");

        signUpHelper.click1PropCardMes("0");
        buddyUpHelper.closeIntrodGroupsPopup();
        buddyUpHelper.clickGroupSection();

        buddyUpHelper.clickBuddy_upButton("m interested");
        buddyUpHelper.clickBuddy_upButton("Choose Your Flatmates");
        //buddyUpHelper.popupGroup("Create a Group");
        //buddyUpHelper.popupGroup("Post a group");
        //buddyUpHelper.postGroupButton();

        buddyUpHelper.assertNumberOfGroupsPropPage(1);

        buddyUpHelper.learnMore(0);
        buddyUpHelper.removeGroup(0);
        buddyUpHelper.yesRemoveGroup(0);
        buddyUpHelper.closeIntrodGroupsPopup();
        buddyUpHelper.clickGroupSection();

        verificationHelper.textNoGroup("This property is available to rent as a whole. Click \"I'm interested\" to start a group and choose your flatmates");

        buddyUpHelper.createPageGroupButton();
        //buddyUpHelper.postGroup();
        buddyUpHelper.postGroupButton();

        buddyUpHelper.learnMore(0);
        buddyUpHelper.closePopupGroup(0);

        //buddyUpHelper.createPageGroupButton();
        buddyUpHelper.notVisibleCreatePageGroupButton();
        //buddyUpHelper.closeCreateGroup();

        authorizationHelper.logoutFromApp();


        //authorizationHelper.removeAnyAccount();
    }

    //@Test //(priority = 8)//(dependsOnMethods = { "testMessageSignUpGroupCreate" })

    public void testT_T_MmmSignUpGroupJoin() {

        searchHelper.startBuddyUpSearch("HA0 1EH", "HA0 1EH", "+2",
                                         "Wembley HA0 1EH, UK", "property_id3");

        String photo1 = $(byXpath("//div[@class='card-top-profile-img u_p5-right']/img")).getAttribute("src");
        //String name1 = $(byXpath("//span[@class='card-top-username']")).text();
        //String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();


        signUpHelper.click1PropCardMes("0");
        verificationHelper.signUpPopupName("Sign up to continue");
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Trump", "FMupsBuddy3", "Female");
        sleep(2000);
        signUpHelper.moreAboutYou2("25", "12", "1985", "777777777", "227", "I an interested in Buddy_upTests", "Professional", "Other");

        messageHelper.photoOfOwnerInMesBuddy_up(photo1);
        messageHelper.propertyPostcodeVerifying(postCode);

        buddyUpHelper.closeIntrodGroupsPopup();

        buddyUpHelper.clickGroupSection();
        buddyUpHelper.learnMore(0);
        buddyUpHelper.requestPageToGroup();
        //buddyUpHelper.clickBuddy_upButton("View more groups");
        buddyUpHelper.chat_MemberClick();
        buddyUpHelper.veryfNumberMember(2);
        buddyUpHelper.closeMemberPopup();

        buddyUpHelper.clickPropImgChat();
        buddyUpHelper.clickGroupSection();

        buddyUpHelper.verifyNumberUser(2);
        verificationHelper.nameUserInGroup("Ronald", 0);
        verificationHelper.nameUserInGroup("Trump", 1);

        buddyUpHelper.learnMore(0);
        buddyUpHelper.clickBuddy_upButton("Exit group");
        buddyUpHelper.clickBuddy_upButton("Confirm leave");
        buddyUpHelper.verifyNumberUser(1);
        verificationHelper.nameUserInGroup("Ronald", 0);

        buddyUpHelper.learnMore(0);
        buddyUpHelper.clickBuddy_upButton("Report group");
        buddyUpHelper.clickBuddy_upButton("Report now");

        buddyUpHelper.clickBuddy_upButton("m interested");
        buddyUpHelper.clickBuddy_upButton("Choose Your Flatmates");
        //buddyUpHelper.arrowPopupNext();

        buddyUpHelper.requestPopupToGroup();
        buddyUpHelper.chat_MemberClick();
        buddyUpHelper.veryfNumberMember(2);
        buddyUpHelper.closeMemberPopup();
        buddyUpHelper.clickPropImgChat();
        buddyUpHelper.clickGroupSection();
        buddyUpHelper.assertNumberOfGroupsPropPage(2);

        buddyUpHelper.clickBuddy_upButton("m interested");
        buddyUpHelper.clickBuddy_upButton("Choose Your Flatmates");
        buddyUpHelper.groupPopupVerif( new String[]{"Ronald\n" + "64 years", "Trump\n"+ "33 years", "1 flatmate", ""});

        buddyUpHelper.closePopupLookingGroup();

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        buddyUpHelper.assertNumberOfMyGroups(2);
        buddyUpHelper.clickListingImgGroupCard();
        buddyUpHelper.clickGroupSection();

        buddyUpHelper.learnMore(0);
        buddyUpHelper.removeGroup(0);
        buddyUpHelper.yesRemoveGroup(0);

        authorizationHelper.logoutFromApp();

    }
   // @Test //(priority = 9)

    public void testW_W_MessageLoginGroupFull() {

        searchHelper.startBuddyUpSearch("HA0 1EH", "HA0 1EH", "+3 km",
                                        "Wembley HA0 1EH, UK", "property_id3");

        String photo1 = $(byXpath("//div[@class='card-top-profile-img u_p5-right']/img")).getAttribute("src");
        //String name1 = $(byXpath("//span[@class='card-top-username']")).text();
        //String title1 = $(byXpath("//head/title")).text();
        sleep(2000);
        String postCode = $(byXpath("//div[@class='card-infos-left']/div")).text();


        signUpHelper.click1PropCardMes("0");
        clickSignInButtonInForm();
        authorizationHelper.loginBuddy_up("passwUniv", "FMwithoutSub3");

        buddyUpHelper.closeIntrodGroupsPopup();

        messageHelper.photoOfOwnerInMesBuddy_up(photo1);
        messageHelper.propertyPostcodeVerifying(postCode);

        buddyUpHelper.clickGroupSection();

        buddyUpHelper.learnMore(0);
        buddyUpHelper.requestPageToGroup();
        //buddyUpHelper.clickBuddy_upButton("View more groups");
        buddyUpHelper.chat_MemberClick();
        buddyUpHelper.veryfNumberMember(3);
        buddyUpHelper.closeMemberPopup();

        //messageHelper.clickMenuMessages();
        messageHelper.backToInbox();
        //messageHelper.verifyMemberImgInboxNumber(3);
        messageHelper.messageToPropertyExist("45880");
        messageHelper.clickMessage1Inbox();

        buddyUpHelper.messageGroupVerif("Hi, thank you for your interest in this property.",
                "Hi my name is Trump", "Hi my name is Ronald", "Hi my name is Rene");

        buddyUpHelper.clickPropImgChat();

        authorizationHelper.logoutFromApp();
    }

    //@Test //(priority = 10)

    public void testY_Y_MessageLoginGroupEditFull() {

        searchHelper.startBuddyUpSearch("HA0 1EH", "HA0 1EH", "+3 km",
                                           "Wembley HA0 1EH, UK", "property_id3");

        signUpHelper.click1PropCardMes("0");
        clickSignInButtonInForm();
        authorizationHelper.loginBuddy_up("passwUniv", "FMupsBuddy2");

        buddyUpHelper.closeIntrodGroupsPopup();

        buddyUpHelper.clickGroupSection();

        buddyUpHelper.learnMore(0);
        buddyUpHelper.clickBuddy_upButton("Edit group");

        buddyUpHelper.minBudgetInput("1000");
        addPropertyHelper.periodDateBuddy_up();
        buddyUpHelper.genderBuddy_up("Male");
        buddyUpHelper.ageMin();
        buddyUpHelper.ageMax();
        buddyUpHelper.addTextDescribe("test description");
        buddyUpHelper.postGroupButtonEdit();
        open("http://front.idealflatmate4test.demo.devplatform2.com/spare-room/wembley/property-id45880");
        buddyUpHelper.closeIntrodGroupsPopup();
        String minBud = buddyUpHelper.minBudget();
        String movData = buddyUpHelper.movingData();

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        buddyUpHelper.veryfyGroupEditData(minBud, movData);

        buddyUpHelper.myGroupPageClick("Edit group");

        buddyUpHelper.genderBuddy_upGroupPageSelect("Female");
        buddyUpHelper.postGroupButtonEdit();
        open("http://front.idealflatmate4test.demo.devplatform2.com/spare-room/wembley/property-id45880");
        //open("http://front.idealflatmate4test.demo.devplatform2.com/buddy-up#");

        authorizationHelper.logoutFromApp();

    }


    //@Test //(priority = 11)

    public void testZ_Z_ZMessageLoginPropertyRemove() {


        authorizationHelper.login("passwUniv", "agentNewBuddyUp");
        //closeListRenewPopUp();

        addPropertyHelper.closeRenewPopup();

        messageHelper.chooseMesTabView();
        messageHelper.clickMenuMessages();
        messageHelper.numberConverInbox(1);
        //messageHelper.verifyMemberImgInboxNumber(3);
        messageHelper.clickMessage1Inbox();

        buddyUpHelper.chat_MemberClick();
        buddyUpHelper.veryfNumberMember(3);
        buddyUpHelper.closeMemberPopup();

        buddyUpHelper.messageGroupVerif("Hi, thank you for your interest in this property.",
                "Hi my name is Trump", "Hi my name is Ronald", "Hi my name is Rene");

        buddyUpHelper.clickPropImgChat();
        buddyUpHelper.clickGroupSection();
        buddyUpHelper.learnMore(0);
        buddyUpHelper.removeGroup(0);
        buddyUpHelper.yesRemoveGroup(0);

        //getAddPropertyHelper().chooseListingsFromDropDownMenu();
        //getAddPropertyHelper().removeListingClick();

        messageHelper.clickMenuMessages();
        messageHelper.numberConverInbox(0);

        authorizationHelper.logoutFromApp();

    }

}
