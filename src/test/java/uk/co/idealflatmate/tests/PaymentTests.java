package uk.co.idealflatmate.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfData;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.close;
import static uk.co.idealflatmate.appmanager.HelperBase.closeMatchPopUp;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class PaymentTests extends TestBase {
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
    public void testAbilityToSeePhone() {


        authorizationHelper.login("passwUniv", "FH_Not_paid");
        verificationHelper.verificationUserNameOnHomePage("Zlatan");
        searchHelper.searchPropertyHome("#0012906");
        paymentsHelper.verificationNoPhone();
        //paymentsHelper.verificationPhone("XXXX");
        //getMessageHelper().clickPhoneReveal();

        //paymentsHelper.verificationPhoneVisible("3456666666");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void testGoPremiumFHPaymentOnPhone() {

        authorizationHelper.login("passwUniv", "FMNotPaid");

        verificationHelper.verificationUserNameOnHomePage("Borris");
        searchHelper.searchPropertyHome("#0012906");
        paymentsHelper.verificationNoPhone();
        //getMessageHelper().clickPhoneReveal();
        //paymentsHelper.verificationPremiumPopup("Get access to all properties");
        //paymentsHelper.clickUpgradePremiumFH("Upgrade Now");
        //paymentsHelper.verificationPaymentPage("Premium Flathunter");
        authorizationHelper.logoutFromApp();
    }

    //@Test
    public void goPremiumFHPaymentOnMessage() {

        authorizationHelper.login("passwUniv", "FMNotPaid");

        verificationHelper.verificationUserNameOnHomePage("Borris");
        searchHelper.searchPropertyHome("#0012906");
        getMessageHelper().clickPropertyContact();
        paymentsHelper.noUpgradePremiumFH("Upgrade to get a faster reply");
        //paymentsHelper.clickUpgradePremiumFH("Upgrade Now");
        //paymentsHelper.verificationPaymentPage("Premium Flathunter");
        authorizationHelper.logoutFromApp();
    }

    //@Test
    public void premiumFHPaymentWorldPay() {
        String newEmail = ConfData.getData("fmNotPaid3");
        authorizationHelper.goToPropertyPage();
        //authorizationHelper.clickCloseSignUpFMPage();

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "fmNotPaid3", "Female");

        signUpHelper.moreAboutYou("5", "12","1988","3456666666", "227","I am a FlatHunter", "Professional", "Other");

        signUpHelper.whereWouldLikeLive("watf", "Watford");

        signUpHelper.budgetMin();
        //signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        //signUpHelper.priceMove("15", "12", "2019");
        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        addPropertyHelper.openDropDownMenu()
                         .choosePayments();

        paymentsHelper.verificationPaymentPage("Premium Flathunter");
        //paymentsHelper.selectPremiumFlathunterPlan();
        paymentsHelper.upgradePremiumFH();
        paymentsHelper.verificationCheckout("£"+"3.99 (week)");
        paymentsHelper.verificationCheckoutTotal("3.99");
        paymentsHelper.checkout();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");

        verificationHelper.verifyPackagePurchase("Congratulations on choosing our Premium Flathunter plan for the property .");
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");


    }

    @Test
    public void testLordInWorldPaylistingEssen() {
        String price = "8";
        String newEmail = ConfData.getData("live-In3");

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.signListingFM_LiveIn("live-In3", "passwUniv",
                "5", "5", "1959", "3456666666", "19", "Ronald",
                "Professional", "Student");

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing();
        closeMatchPopUp();

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        addPropertyHelper.pressAddListingFromBody();
        addPropertyHelper.addListingWithoutPhotoEmptyAreaVerif("SE1", "5 Longfellow Way, London, SE1",
                "Bermondsey", "2",  "900", "Area cannot be blank.");

        paymentsHelper.verificationPaymentPageFeatureListing("Now choose the plan that is right for you.");
        paymentsHelper.activePlanVerification("Weekly", "8", "12", " disabled", "N/A");

        paymentsHelper.clickSelectPlan("Essential", "button");

        paymentsHelper.verificationCheckoutNewTotal(price);
        //paymentsHelper.choosePayPal();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");

        verificationHelper.verifyPackagePurchaseList("ideal flatmate Essentials");
        closeMatchPopUp();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();

        verificationHelper.promoteCard();
        verificationHelper.packageOnCard("Essentials listing", "default");

        addPropertyHelper.openDropDownMenu();
        addPropertyHelper.choosePayments();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");


    }
    @Test
    public void testLordOutWorldPaylistingPrem() {
        String price = "22";
        String newEmail = ConfData.getData("liv-Out4");

        authorizationHelper.goToFMpage();

        authorizationHelper.clickClosePopupSignUp();

        addPropertyHelper.pressAddListingFromHeaderNotLoggedUser();
        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.signListingLiveOut("liv-Out4", "passwUniv",
                "2Ronald", "897876567");

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing();
        verificationHelper.verificationUserNameOnHomePage("2Ronald");
        addPropertyHelper.pressAddListingFromBody();

        addPropertyHelper.addListingWithoutPhotoEmptyAreaVerif("1 longrise", "1 Longrise, Billericay, CM12",
                "Chalk Farm", "15","1333", "Area cannot be blank.");

        paymentsHelper.verificationPaymentPageFeatureListing("Now choose the plan that is right for you.");

        addPropertyHelper.openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        paymentsHelper.goToPaymentsTabInnerMenuUpgrade();
        paymentsHelper.activePlanVerification("Weekly", "8", "12", " disabled", "N/A");
        paymentsHelper.clickPlan("Monthly");
        paymentsHelper.activePlanVerification("Monthly", "16", "22", "", "34");

        paymentsHelper.clickSelectPlan("Premium", "button");

        paymentsHelper.verificationCheckoutNewTotal(price);
        //paymentsHelper.choosePayPal();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");

        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");
        closeMatchPopUp();
        verificationHelper.verifyPackagePurchaseList("ideal flatmate Premium");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.packageOnCard("Premium listing", "primary");

        addPropertyHelper.openDropDownMenu();
        addPropertyHelper.choosePayments();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("2Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }




    @Test
    public void testLordInWorldPaidListingProf() {

        String price = "319";
        String newEmail = ConfData.getData("fmNotPaid4");

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.signListingFM_LiveIn("fmNotPaid4", "passwUniv",
                "5", "5", "1959", "3456666666", "19", "Ronald",
                "Professional", "Student");

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing();
        closeMatchPopUp();

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        addPropertyHelper.pressAddListingFromBody();
        addPropertyHelper.addListingWithoutAreaDefault("C", "Studio",  "2100",
                                                        "Eden, CA10 1AB, UK", "Lazonby");

        verificationHelper.verificationUserNameOnHomePage("Ronald");

        paymentsHelper.verificationPaymentPageFeatureListing("Now choose the plan that is right for you.");
        //paymentsHelper.selectPremiumFlathunterPlan();
        paymentsHelper.activePlanVerification("Weekly", "8", "12", " disabled", "N/A");
        paymentsHelper.clickPlan("Yearly");
        paymentsHelper.defaultPlanProf("249");//essential and premium are disabled
        paymentsHelper.clickSelectPlan("Professional", "a");
        paymentsHelper.upgradeListingProfNew("up to 5");
        paymentsHelper.priceVerifPaymentSystemPage(price);
        //paymentsHelper.choosePrice("183", "ProfessionalPaymentForm");//1 month - "+"£"+"44.99
        paymentsHelper.upgradeListing("Upgrade to Professional", "Upgrade to Professional");
        //paymentsHelper.verificationCheckout("£"+"44.99 (monthly)");
        paymentsHelper.verificationCheckoutNewTotal(price);
        //paymentsHelper.checkout();
        //paymentsHelper.choosePayPal();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");

        closeMatchPopUp();

        verificationHelper.verifyPackagePurchaseList("ideal flatmate Professional");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.packageOnCard("Free listing", "default");
        paymentsHelper.promoteCardClick("Promote");
        verificationHelper.packageOnCard("Premium listing", "primary");

        addPropertyHelper.openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        closeMatchPopUp();
        paymentsHelper.goToPaymentsSubscriptionMenu();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }



    @Test
    public void testAgentProfWorldPay() {

        String newEmail = ConfData.getData("agent2");
        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("An agency");

        signUpHelper.agentSignListing("Ronald", "agent2", "passwUniv",
                "3456666666", "Tell us about yourself");

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing();
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        paymentsHelper.goToPaymentsTabNoProperty();

        paymentsHelper.upgradeListingProfOld("1-2");

        paymentsHelper.choosePrice("181", "ProfessionalPaymentForm");//1 month - £34.99
        //paymentsHelper.selectNLADiscount("NLA15", "ProfessionalPaymentForm");
        paymentsHelper.upgradeListing("Upgrade to", "Professional");
        paymentsHelper.verificationCheckout("£"+"34.99 (monthly)");
        paymentsHelper.verificationCheckoutTotal("34.99");
        paymentsHelper.checkout();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");
        verificationHelper.verifyPackagePurchaseList("ideal flatmate Professional");
        //paymentsHelper.choosePayPal();

        addPropertyHelper.chooseListLoggedFromHeaderProfile();
        addPropertyHelper.addListingWithoutAreaDefault("Coventry", "3",  "2100",
                "3 Coventry Close, Peterborough, PE4", "Coventry");

        addPropertyHelper.finishPropertyAgencyWithSubs("Your listing is now live!");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.packageOnCard("Premium listing", "primary");
        paymentsHelper.promoteCardClick("Switch to Essentials");
        verificationHelper.packageOnCard("Essentials listing", "default");

        addPropertyHelper.openDropDownMenu();
        addPropertyHelper.choosePayments();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseMenu_My_profile();
        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");


    }

}
