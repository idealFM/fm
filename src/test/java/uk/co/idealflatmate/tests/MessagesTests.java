package uk.co.idealflatmate.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.MessageHelper;
import utils.ConfData;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.refresh;
import static uk.co.idealflatmate.appmanager.HelperBase.*;


public class MessagesTests extends TestBase {
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
    }
    @AfterMethod

    public void closeMethod() {

    }


   public final MessageHelper messageHelper = new MessageHelper();

    @Test
    public void readMessageByLandlWithoutSubscription() {

        authorizationHelper.loginMessage("Live_in_Mes", "passwUniv");
        getMessageHelper().chooseMessageTabLordWithoutSubscr();
        verificationHelper.verifyUpgradeButton();
        authorizationHelper.logoutFromApp();
    }
    @Test
    public void landlordWithoutSubsToFM() {

        authorizationHelper.loginMessage("Live_in_Mes", "passwUniv");
        homePageHelper.scrollToBlockProperty();
        homePageHelper.clickFM();
        getMessageHelper().clickUpgradeToMessage();
        verificationHelper.paymentPageNotifUpgrade("Now choose the plan that is right for you.");
        authorizationHelper.logoutFromApp();

    }



    @Test
    public void lordWithSubsToFM() {
        clearCache();
        authorizationHelper.loginMessage("AgencyPaid", "passwUniv");
        homePageHelper.scrollToBlockProperty();
        homePageHelper.clickFM();
        getMessageHelper().clickFMPageMessage();
        verificationHelper.chatPage();
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void answMesFmWithoutSubsToFM() {

        authorizationHelper.loginMessage("FMwithMatch", "passwUniv");
        messageHelper.chooseMessageTab("FM can answer to FM");
        //verificationHelper.noSendDecline();
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        messageHelper.typeAndSendMessageWithoutTips("FM can answer to FM");
        verificationHelper.verifyTextMessage("FM can answer to FM");
        authorizationHelper.logoutFromApp();
    }

   // @Test
    public void answMesLandlToPremFHWithoutSubs() {

        authorizationHelper.loginMessage("Liv_out_paid", "passwUniv");
        messageHelper.chooseMessageTab("Landlord Answer to Prem FM");
        //paymentsHelper.addPropertyHelper.messageHepler.chooseAnyMessageFromList();
        messageHelper.sendDecline("Unfortunately this listing is no longer available. Good luck with your search!");//Lord to FH
        messageHelper.typeAndSendMessageWithoutTips("Landlord Answer to Prem FM");
        verificationHelper.verifyTextMessage("Landlord Answer to Prem FM");
        authorizationHelper.logoutFromApp();
    }

    //@Test
    public void premFmToLandlWithoutSubsWithListFromSearch() {

        authorizationHelper.loginMessage("Prem_FH_paid", "passwUniv");
        searchHelper.searchPropertyHomePostCode("PO30 2DN");
        searchHelper.selectRadius("2");
        messageHelper.clickCardMessageLogged();
        //messageHelper.clickPropertyPageMessage();
        verificationHelper.noTextUpgradeToFasterReply();
        verificationHelper.messageGroup("# 0012947 Newport PO30 2DN, UK");
        messageHelper.typeAndSendMessageWithoutTips("Landlord Answer to Prem FM");
        verificationHelper.verifyTextMessage("Landlord Answer to Prem FM");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void fmWithoutSubsToLandlordWithoutSubsWithListFromList() {
        clearBrowserCookies();
        authorizationHelper.loginMessage("FMNotPaid", "passwUniv");

        authorizationHelper.goToPropertyPage();

        searchHelper.priceFilterActive();
        searchHelper.clearFilter();
        searchHelper.clearSearch();
        searchHelper.clickSearchPropPage("PO30 2Dn  ");
        searchHelper.selectRadius("2");
        messageHelper.clickCardImgProperty("Newport PO30 2DN, UK");
        messageHelper.clickPropertyContact();
        //messageHelper.clickPropertyPageMessage();
        //verificationHelper.upgradeToFasterReply();
        //verificationHelper.messageGroup("# 0012947 Newport PO30 2DN, UK");
        //messageHelper.sendDecline("Unfortunately I have found a place elsewhere and no longer" + //FH to Lord" interested in the room. Good luck finding a flatmate!");

        messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void fmDirectToProperty() {
        String location = "LS2 7DT";
        clearBrowserCookies();
        authorizationHelper.loginMessage("FMNotPaid", "passwUniv");

        authorizationHelper.goToPropertyPage();

        closeAdvPopUp();

        searchHelper.clearSearch();
        searchHelper.clickSearchPropPage(location);
        signUpHelper.click1PropCardMes("property_id1");

        messageHelper.typeAndSendMessage("Test Message to Property without subscription");
        verificationHelper.verifyTextMessage("Test Message to Property without subscription");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void fmWithoutSubsToLordWithoutSubsDirectly() {

        String location = "Whitton";
        authorizationHelper.loginMessage("FMNotPaid", "passwUniv");


        searchHelper.searchPropertyHome(location);
        searchHelper.selectRadius("+3 km");

        verificationHelper.searchResultText("Find A Room To Rent");

        searchHelper.cardUserClick();

        messageHelper.clickFMPageMessage();

        //verificationHelper.upgradeToFasterReply();
        //verificationHelper.noSendDecline();
        //verificationHelper.messageGroup("No property");
        messageHelper.typeAndSendMessage("Test Message to Landlord without subscription");
        verificationHelper.verifyTextMessage("Test Message to Landlord without subscription");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void spamFmWithoutSubsToFMLink() {
        String newEmail = ConfData.getData("TenantSpam");
        String name = "Mash";

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("A current tenant");
        signUpHelper.signListingFM_LiveIn("TenantSpam", "passwUniv",
                "5", "5", "1959", "03456666666", "19",
                name, "Professional", "Student");

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage(name);
        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();

        //@Parameter({"Card1", "Url1"})
        messageHelper.messageSearchFM("Card1", "url1");
        authorizationHelper.goToFMpage();
        messageHelper.messageSearchFM("Card2", "url2");
        authorizationHelper.goToFMpage();
        messageHelper.messageSearchFM("Card3", "url3");


        verificationHelper.notifSpamer("Message limit reached. Please contact help@idealflatmate.co.uk" +
                                         " to have your messaging restored.");


        authorizationHelper.removeAnyAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void spamFmUnboundMessages() {
        String newEmail = ConfData.getData("TenantMesSpam");
        String name = "Mash";

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("A current tenant");
        signUpHelper.signListingFM_LiveIn("TenantMesSpam", "passwUniv",
                "5", "5", "1959", "03456666666", "19",
                name, "Professional", "Student");

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyAddListingPage();
        verificationHelper.verificationUserNameOnHomePage(name);
        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();

        for (int card = 1; card < 6; card++) {
            scrollDownPageOn("200");
            messageHelper.messageSearchFM1(card, "message");
            authorizationHelper.goToFMpage();
        }

        searchHelper.moveToPage(2, "2");

        for (int card = 1; card < 6; card++) {
            scrollDownPageOn("200");

            messageHelper.messageSearchFM1(card, "message");
            authorizationHelper.goToFMpage();
            scrollDownPageOn("2000");
            searchHelper.moveToPage(2, "2");
        }

        for (int card = 1; card < 6; card++) {
            scrollDownPageOn("200");
            messageHelper.messageSearchFM1(card, "message");
            authorizationHelper.goToFMpage();
            scrollDownPageOn("2000");
            searchHelper.moveToPage(3, "3");
        }
        searchHelper.moveToPage(4, "4");
        messageHelper.messageSearchFM1(2, "message");
        verificationHelper.notifSpamerNotExist();


        authorizationHelper.removeAnyAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }





}
