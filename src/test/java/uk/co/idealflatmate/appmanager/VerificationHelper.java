package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;



public class VerificationHelper extends HelperBase {

SelenideElement phoneAlert = $(byXpath("//div[contains(@class,'password')]/div[@class='help-block']"));
SelenideElement genderAlert = $(byXpath("//div[contains(@class,'gender')]/div[@class='help-block']"));
SelenideElement emailExistAlert = $(byXpath("//div[contains(@class,'email')]/div[@class='help-block']"));
private SelenideElement chatInput = $(byXpath("//textarea[@placeholder='Type your message here']"));
public String safeTip = "//label[@for='safety-tip-confirm']//span";
public SelenideElement userName = $("span.user-welcome--name");
public SelenideElement lastMessage = $(byXpath("(//div[@class='color-1 text-12 messages-list-item--authorinfo']//following-sibling::div)[last()]"));

    @Step
    public void verificationUserNameOnHomePage(String nameUser) {
        userName.waitUntil(visible, 30000).shouldHave(text(nameUser));
    }
    @Step
    public void verificationUserIsUnlogged(String SignUp) {

        $(byXpath("//nav/a[@class]")).waitUntil(visible, 10000).shouldHave(text(SignUp));
    }
    @Step
    public void VerificationLoginNameError() {
        $(byXpath("//div[input[@id='loginform-username']]/div")).waitUntil(visible, 4000).shouldHave(text("Username cannot be blank."));
    }
    @Step
    public void VerificationLoginPassError() {
        $(byXpath("//div[input[@id='loginform-password']]/div")).waitUntil(visible, 4000).shouldHave(text("Password cannot be blank."));
    }
    @Step
    public void VerificationMessagesTabIsAbsent() {
        $("body > header > div > ul.nav.navbar-nav.navbar-right.nav-aux.hidden-xs.hidden-sm > li:nth-child(3) > a").waitUntil(visible, 4000).shouldNotBe(text("Messages"));
    }
    @Step
    public void verifyUpgradeButton() {
        $("a.btn.btn-white.box-shadow").waitUntil(visible, 4000).shouldBe(Condition.visible);
    }
    @Step
    public void verifyTextMessage(String text) {
        sleep(5000);
        lastMessage.shouldHave(Condition.text(text));
    }
    @Step
    public void closeSafeTip(){
        safetyConfermMessage(safeTip, visible, 10000);
    }
    @Step
    public void verifyPageMessage() {

        closeSafeTip();

        chatInput.waitUntil(visible, 4000).sendKeys("test message");
        $(byXpath("//a[@title='Send']")).waitUntil(visible, 4000).click();

        $(byXpath("//div[@class='ScrollbarsCustom-Content']//div[contains(text(),'Hey, looks like we are well matched. When are you looking to move?')]")).exists();
        $(byXpath("//div[@class='ScrollbarsCustom-Content']//div[contains(text(),'test message')]")).exists();


    }
    @Step
    private void safetyConfermMessage(String s, Condition visible, int i) {
        $(byXpath(s)).waitUntil(visible, i).click();
    }
    @Step
    public void verifyPageMessageToFM() {

        closeSafeTip();

        chatInput.waitUntil(visible, 4000).sendKeys("test message");
        $(byXpath("//a[@title='Send']")).waitUntil(visible, 4000).click();

        $(byXpath("//div[@class='ScrollbarsCustom-Content']//div[contains(text(),'Hey, looks like we are well matched. When are you looking to move?')]")).exists();
        $(byXpath("//div[@class='ScrollbarsCustom-Content']//div[contains(text(),'test message')]")).exists();


    }
    @Step
    public void verifyAddedProperty(String location) {

        $(byXpath("(//h2[@class='h3 u_m0-top text-info'])[1]")).waitUntil(visible, 4000).shouldHave(text(location));

    }
    @Step
    public void verifyAddedPropertyWithAllFields(final String month, final String room1, final String room2, final String room3, final String listingAbout, final String location) {//section[@id]//h1/small

        String ref = $(byXpath("//section[@id]//h1/small")).getText();
        $(byXpath("//section[@id]//h1")).getText().contentEquals("3 bedrooms for rent in Bankside, South London from "+"500/month per room\n"
                 + ref);
        $(byXpath("//span[@class='property-phone_hide js-phone-box']")).shouldHave(text("\n" + "+44 2 XXXX"));

        verifyAddedPropertyNoRoom(listingAbout);

        $(byXpath("//div[@class='u_p10-bottom u_m30-bottom u_b-bottom']")).shouldHave(text(location));

        $(byXpath("//ul[@class='tabs-2']//a[contains(.,'Rooms')]")).click();

        roomVerification(room1, "£500", "£1,000", "£400", "Now", "", "", "7 months+", "Very comfortable room");
        roomVerification(room2, "£500", "£1,000", "£400", "Now", "", "", "7 months+", "Very comfortable room");
        roomVerification(room3, "£800", "", "", "15th ", month, " 2025", "", "");
    // $(byXpath("//h2[@class='h4 u_m20-top-xs u_m40-top-sm' and contains(text(), 'About this listing')]")).scrollIntoView(true);
}


    @Step
    public void profileDisplays(ProfileData profileData) {
        if($(byXpath("//div[contains(@class,'circularProgress__value')]")).exists()){
            $(byXpath("//div[contains(@class,'circularProgress__value')]")).shouldHave(text(profileData.getPercentComplete()));}
        if($(byXpath("//ul[contains(@class,'nav dashboard-side-nav')]")).exists()){
            $(byXpath("//ul[contains(@class,'nav dashboard-side-nav')]")).shouldHave(text(profileData.getMyProfile()));}
        $(byXpath("//h2[contains(@class,'profile-info--name_age')]/strong")).shouldHave(text(profileData.getName()));
        if($(byXpath("//h2[contains(@class,'profile-info--name_age')]/span")).exists()){
            $(byXpath("//h2[contains(@class,'profile-info--name_age')]/span")).shouldHave(text(profileData.getAge()));}

        if($(byXpath("//strong[contains(@class,'u_ed-block')]")).exists()){
            $(byXpath("//strong[contains(@class,'u_ed-block')]")).shouldHave(text(profileData.getLookingFor()));
        }
        String about = $(byXpath("//div[contains(@class,'u_p30 u_bg-white')]")).text().replaceAll("£", "");
        Assert.assertEquals(about, profileData.getAboutMe().replaceAll("£", ""));

        if($(byXpath("//h4[contains(.,'My available rooms are ')]")).exists()){
            $(byXpath("//ul[contains(@class,'geo-list u_m0 u_p0')]")).shouldHave(text(profileData.getRoomsLocation()));
            collectionReturn("//ul[contains(@class,'geo-list u_m0 u_p0')]/li").shouldHaveSize(Integer.parseInt((profileData.getRoomsLocation())));
            cardsOnThePage().shouldHaveSize(Integer.parseInt((profileData.getAmountPropertiesCard())));

        }

    }
    @Step
    public void profileDisplaysForEdit(ProfileData profileData, String moveInDate) {
        if($(byXpath("//div[contains(@class,'circularProgress__value')]")).exists()){
            $(byXpath("//div[contains(@class,'circularProgress__value')]")).shouldHave(text(profileData.getPercentComplete()));}
        if($(byXpath("//ul[contains(@class,'nav dashboard-side-nav')]")).exists()){
            $(byXpath("//ul[contains(@class,'nav dashboard-side-nav')]")).shouldHave(text(profileData.getMyProfile()));}
        $(byXpath("//h2[contains(@class,'profile-info--name_age')]/strong")).shouldHave(text(profileData.getName()));
        if($(byXpath("//h2[contains(@class,'profile-info--name_age')]/span")).exists()){
            $(byXpath("//h2[contains(@class,'profile-info--name_age')]/span")).shouldHave(text(profileData.getAge()));}

        if($(byXpath("//strong[contains(@class,'u_ed-block')]")).exists()){
            $(byXpath("//strong[contains(@class,'u_ed-block')]")).shouldHave(text(profileData.getLookingFor()));
        }
        String about = $(byXpath("//h4[contains(.,'Ready to move')]")).text();
        Assert.assertEquals(about, profileData.getAboutMe()+" "+moveInDate);

        if($(byXpath("//h4[contains(.,'My available rooms are ')]")).exists()){
            $(byXpath("//ul[contains(@class,'geo-list u_m0 u_p0')]")).shouldHave(text(profileData.getRoomsLocation()));
            collectionReturn("//ul[contains(@class,'geo-list u_m0 u_p0')]/li").shouldHaveSize(Integer.parseInt((profileData.getRoomsLocation())));
            cardsOnThePage().shouldHaveSize(Integer.parseInt((profileData.getAmountPropertiesCard())));

        }

    }

    @Step
    public void verifyNoProperty() {
        refresh();
        //$(byXpath("(//ul[starts-with(@class, 'nav navbar-nav')]/li)[1]")).shouldHave(text("Add a Listing"));
        verifyNoUnfinishedProperty();
        verifyNoPropertyPending();

        if ($(byXpath("//section//div[@class='label label-default listing-panel-label u_p5']")).has((text("Free listing")))){
            $(byXpath("//button[starts-with(@class,'btn btn-primary-outline')]")).waitUntil(appear, 10000).click();
            $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 5000).selectRadio("0");
            $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 4000).click();
            sleep(4000);
        }
    }
    @Step
    public static void verifyNoUnfinishedProperty() {
        refresh();
        $(byXpath("//h2[@class='u_m0 u_m20-bottom text-24 u_ef-left-sm']")).shouldHave(text("My Listings"));
        sleep(2000);
        if ($(byXpath("//section//div[@class='col-sm-7 col-lg-8']/div")).has((text("Complete your listing now!")))){
            $(byXpath("//button[starts-with(@class,'btn btn-default ')]")).waitUntil(appear, 10000).click();
            $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 5000).selectRadio("0");
            $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 4000).click();
            sleep(4000);
        }
    }
    @Step
    public void verifyNoPropertyPending() {
        refresh();
        //$(byXpath("(//ul[starts-with(@class, 'nav navbar-nav')]/li)[1]")).shouldHave(text("Add a Listing"));
        $(byXpath("//h2[@class='u_m0 u_m20-bottom text-24 u_ef-left-sm']")).shouldHave(text("My Listings"));
        //$(byXpath("//section/div[@class='container']")).shouldNotHave((text("Complete your listing now!")));
        sleep(2000);
        if ($(byXpath("//section/div[@class='container']")).has((text("London SE1, UK")))){
            $(byXpath("//button[starts-with(@class,'btn btn-default')]")).waitUntil(appear, 10000).click();
            $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 4000).selectRadio("0");
            $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 5000).click();
            sleep(4000);
        }
    }
    @Step
    public void verifyPackagePurchase(String text) {
            $(byXpath("//div[@class='text-body-copy u_m20-top-md']/p[1]")).shouldHave(text(text));
    }
    @Step
    public void verifyPackagePurchaseList(String text) {
        $(byXpath("//h2[@class='h3 u_m0-top text-normal-weight']")).shouldHave(text(text));
    }
    @Step
    public void verifyPackageCanceled(String text) {
        $(byXpath("//div[@class='text-body-copy u_m20-top-md']/p[2]")).shouldHave(text(text));
    }
    @Step
    //span[contains(text(), 'This email address has already been taken.')]
    public void emailAlreadyExistedAlert() {
        emailExistAlert.shouldHave(text("This email address already has an Ideal Flatmate account"));
    }
    @Step
    public void passwWrongAlertHome() {
        //sleep(2000);
        $(byXpath("//input[@id='loginform-password']//following-sibling::div")).waitUntil(exist, 4000).shouldHave(text("Incorrect email or password."));
    }
    @Step
    public void nameFirstBlankAlert() {
        $(byXpath("//div[contains(@class,'first_name')]/div[@class='help-block']")).waitUntil(exist, 10000).shouldHave(text("First Name cannot be blank."));
    }

    @Step
    public void emailBlankAlert() {
        emailExistAlert.waitUntil(exist, 4000).shouldHave(text("Email cannot be blank."));
    }
    @Step
    public void genderBlankAlert() {
        genderAlert.waitUntil(exist, 4000).shouldHave(text("Gender cannot be blank."));
    }
    @Step
    public void passwordBlankAlert() {
        phoneAlert.waitUntil(exist, 4000).shouldHave(text("Password cannot be blank."));

    }
    @Step
    public void dateMonthYearPhoneOccupationBlankError() {
        dayMonthYearAlert();
        $(byXpath("//div[contains(@class,'phone')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));

        $(byXpath("//select[@id='moreinfosignupform-occupation_id']")).selectOptionByValue("");
        $(byXpath("//div[select[@id='moreinfosignupform-occupation_id']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Occupation Id cannot be blank."));
    }
    @Step
    public void dateMonthYearBlankErrorMessage() {
        dayMonthYearAlert();
        //$(byXpath("//div[div/input[@id='moreinfosignupform-phone']]//div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));
        //$(byXpath("//div[select[@id='moreinfosignupform-occupation_id']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Occupation Id cannot be blank."));
    }


    @Step
    public void dateMonthYearPhoneBlankErrorPhone() {
        dayMonthYearAlert();
        $(byXpath("//div[contains(@class,'phone')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));
    }

    @Step
    public void dayMonthYearAlert() {
        $(byXpath("//div[contains(@class,'day')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Day cannot be blank."));
        $(byXpath("//div[contains(@class,'month')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Month cannot be blank."));
        $(byXpath("//div[contains(@class,'year')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Year cannot be blank."));
    }
    @Step
    public void checkLocationBlank() {
        $("div.error-summary ul li").shouldHave(text("Please choose location"));
    }
    @Step
    public void budgetError() {
        $(byXpath("//div[input[@id='js-signup-budget-max']]/div[@class='help-block']")).shouldHave(text("Please choose minimum and maximum budget"));
    }
    @Step
    public void ageConfirmCheckMatching() {
       $(byXpath("(//input[@name='SignupForm[is_age_confirm]'])[1]")).waitUntil(appears, 4000).click();

    }
    @Step
    public void upgradeToFasterReply() {
        $(byXpath("//div[@class='alert alert-warning text-center u_m0']")).waitUntil(exist, 4000).shouldHave(text("Upgrade to get a faster reply"));

    }
    @Step
    public void noTextUpgradeToFasterReply() {
        $(byXpath("//div[@class='alert alert-warning text-center u_m0']")).shouldNot(exist);

    }
    @Step
    public void messageGroup(String text) {
        $(byXpath("//select[@id='property-select']")).waitUntil(exist, 4000).shouldHave(text(text));
    }
    @Step
    public void photoListingExist(){
        $(byXpath("//div[@class='owl-item active'][1]")).shouldBe(visible);
        $(byXpath("//div[@class='owl-item active'][2]")).shouldBe(visible);
        $(byXpath("//div[@class='owl-item active'][3]")).shouldBe(visible);

    }
    @Step
    public void checkMatchingConcurrence(String matchScore) {

        if($(byXpath("//ul[@class='dropdown-menu']//a[@class='box-hide-overflow u_ed-block']/span[2]")).isDisplayed()) {
            $(byXpath("//ul[@class='dropdown-menu']//a[@class='box-hide-overflow u_ed-block']/span[2]")).waitUntil(exist, 4000).shouldHave(text(matchScore));
        } else {
            $("span.hidden-xs").click();
            $(byXpath("//ul[@class='dropdown-menu']//a[@class='box-hide-overflow u_ed-block']/span[2]")).waitUntil(exist, 4000).shouldHave(text(matchScore));
        }

    }
    @Step
    public void checkPhoneAlertMessage(String text) {
        $(byXpath("//div[contains(@class,'phone has-error')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text(text));
    }

    @Step
    public void closeMatchingPopup() {
        if ($(byXpath("//button[@class='btn btn-sm btn-close close js-close-notify-matching']")).is(exist)) {
            $(byXpath("//button[@class='btn btn-sm btn-close close js-close-notify-matching']")).waitUntil(appears, 8000).click();
            sleep(2000);
        }
    }
    @Step
    public void paymentPageNotifUpgrade(String text) {
        $(byXpath("//h2[@class='text-18 u_m0-top u_m30-bottom']")).waitUntil(exist, 4000).shouldHave(text(text));
    }
    @Step
    public void chatPage() {

        $(byXpath(safeTip)).shouldNot(exist);
        chatInput.waitUntil(exist, 4000).shouldBe(visible);
    }
    @Step
    public void verifyAddListingPage() {
        $("li.active a").shouldHave(text("Active"));
        $(byXpath("//li/a[contains(.,'Deactivated')]")).shouldHave((text("Deactivated")));
    }
    @Step
    public void verifySearchListingPage() {

        $(byXpath("//div[@class='price-range-filter selected']")).getText().contentEquals("200" + " - " + "1250");
        $(byXpath("//input[1]")).shouldHave(value("Watford"));
        $("#property-sort").waitUntil(exist, 20000).should(exist);

    }
    @Step
    public void verifySearchListingPageMatching() {

        $(byXpath("//div[@class='price-range-filter selected']")).getText().contentEquals( "1200" + " - " + "1250");
        $(byXpath("//input[1]")).shouldHave(value("Watford"));
        $("#property-sort").waitUntil(exist, 20000).should(exist);

    }
    @Step
    public void verifySearchFMPage() {
        $(byXpath("//h2[contains(.,'flatmates')]")).shouldNotHave(text("rooms"));

    }
    @Step
    public void verificationFieldLenth(int widthOfField) {
       int p = $(byXpath("//input[@id='yourinfosignupform-email']")).getSize().getWidth();

        Assert.assertEquals(p, widthOfField);
    }

    @Step
    public void phoneVerification(String text, final String phone) {
        SignUpHelper signUpHelper = new SignUpHelper();
        signUpHelper.profilePhone(phone);

        signUpHelper.clickYourInformationContinue();
        $(byXpath("//div[contains(@class,'form-group required u_m15-bottom')]//div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text(text));

    }
    @Step
    public void profilePhoto10Mb() {
        $(byXpath("//div[starts-with(@class, 'upload-profile-photo u_ed-flex')]//div[@class='help-block']")).shouldHave(text("Sorry! " +
                "That image can’t be uploaded, please try a smaller image size (up to 8Mb)."));

    }
    @Step
    public void profilePhotoPdf() {
        $(byXpath("//div[starts-with(@class, 'upload-profile-photo u_ed-flex')]//div[@class='help-block']")).shouldHave(text("Wrong" +
                " Extension"));

    }
    @Step
    public void isHomePage(final String textTitle) {
        title().contains(textTitle);

    }
    @Step
    public void isHomePage1() {
        $(byXpath("//h1")).shouldHave(text("Clever matches.\n" +
                "Better flatshares."));

    }
    @Step
    public void isResetSuccessful() {
        $(byXpath("//p[@class='text-success']/span")).shouldHave(text("Check your email for further instructions"));

    }
    @Step
    public void ListingStart(final String text) {
            $(byXpath("//h2[@class='u_m0 u_m20-bottom text-24 text-20-xs']")).waitUntil(visible, 4000).shouldHave(text(text));
    }


    @Step
    public void isFMPage() {

        $(byXpath("//h1[@class='h4' and contains(.,'Find Flatmates')]")).waitUntil(visible, 10000).shouldBe(visible);
    }
    @Step
    public void isPropertyPageLocation(String searchLocation) {

        String currentLocation = $(byXpath("//h1")).getText();
        Assert.assertEquals(currentLocation, searchLocation);
    }
    @Step
    public void isPropertyPage() {

        isHomePage("Find A Room To Rent In The UK | Ideal Flatmate");
    }
    @Step
    public void PropertyPageNumber(String page) {

        String currentPage = $(byXpath("//a[@class='undefined']")).getText();
        Assert.assertEquals(page, currentPage);
    }
    @Step
    public void savedProperties(String referNumber) {
        String currentPage = $(byXpath("//div[@class='u_p0-left text-13']")).getText();
        Assert.assertEquals(referNumber, currentPage);

    }
    @Step
    public void cardIsUnliked() {
        $(byXpath("(//div[@class='container'])[1]")).shouldNotHave(cssClass("div.u_p0-left.text-13"));

    }
    @Step
    public void removeUnfinishedListing() {
        $(byXpath("//h2[@class='u_m0 u_m20-bottom text-24 u_ef-left-sm']")).shouldHave(text("My Listings"));

        if ($(byXpath("//section//div[@class='text-body-copy text-info pull-left']")).has((text("Complete your listing now!")))) {
            $(byXpath("//button[@class='btn btn-default u_p0 btn-circle pull-right js-bring-cover listing-panel-delete u_bg-white']")).waitUntil(appear, 4000).click();
            $(byXpath("(//input[1][@type='radio'])[1]")).selectRadio("0");
            $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).click();
            sleep(3000);
            }
        }
    @Step
    public void finishUnfinished() {
        $(byXpath("//a[contains(., 'Finish')]")).click();
        $(byXpath("//h1")).shouldHave(text("About your property"));
    }
    @Step
    public void finishViewUnfinished() {
        $(byXpath("//a[contains(., 'View listing')]")).click();
        $(byXpath("//div[@class='col-xs-6 col-sm-4 u_p10-bottom']")).shouldHave(text(" 0 bedroom available"));
    }
    @Step
    public static void areaBlank(final String errorMessage) {
        $(byXpath("//div[select[@id='property-area_link_id']]/p")).shouldHave(text(errorMessage));

    }

    @Step
    public void verifyPendingProperty() {
        $(byXpath("//div[@class='text-body-copy text-info pull-left']")).shouldHave(text("Your listing is pending."));
    }
    @Step
    public void finishPendingProperty() {
        $(byXpath("//div//h1/../span")).shouldHave(text("Your listing is pending."));
    }
    @Step
    public void areasNumberForSignUp() {
        sleep(3000);
        $(byXpath("//li[starts-with(@class,'js-area-limit')]")).shouldHave(text("Sorry, you can`t add more than 3 areas"));

    }
    @Step
    public void FMBlogPage() {
        //switchTo().window(1);
        $(byXpath("//section[@class='page-heading blog-splash']//div[@class=" +
                "'blog-hq-switch container']/a")).getText().contentEquals("You are a landlord? Head to our landlord HQ here");


    }
    @Step
    public void landlordBlogPage() {

        //switchTo().window(1);
        $(byXpath("//section[@class='page-heading blog-splash']//div[@class=" +
                "'blog-hq-switch container']/a")).getText().contentEquals("Are you a flatmate? Head to Flatmate HQ here");

    }

    @Step
    public void sentRequestDetails() {
        $(byXpath("//div[@class='msg-body']/span")).shouldHave(text("Hi my name is LivOutListNewTrialI am Other and I would" +
                " like to know if the room is still available. Thank you!"));

    }//div[starts-with(@class,'label label-primary')]
    @Step
    public void searchResultText(String text) {
        $(byXpath("//h1[@class='h4']")).shouldHave(text(text));

    }
    @Step
    public void noSendDecline() {
        $(byXpath("//button[@class='btn-cancel']")).shouldNot(exist);
    }
    @Step
    public void packageOnCard(String text, final String label) {
        $(byXpath("//div[@class='container']//div[@class='label label-" + label + " listing-panel-label u_p5']")).shouldHave(text(text));
    }
    @Step
    public void promoteCard() {
        $(byXpath("//a[contains(.,'Promote')]")).shouldHave(exist);
    }
    @Step
    public void addingListFlowCity(String value) {
        $("input#property-city").shouldHave(value(value));
    }
    @Step
    public void addingListFlowArea(String value) {
        $(byXpath("//select[@id='property-area_link_id']/option[contains(.,'"+value+"')]")).shouldBe(selected);
    }
    @Step
    public void roadFor(String value) {
        $("input#property-route").shouldHave(value(value));
    }
    @Step
    public void verifyTitleProperty(String text1) {
        $(byXpath("//h1[starts-with(@class,'h2 u_m0-top')]")).getText().contentEquals(text1);
    }
    @Step
    public void verifyAboutProperty(String aboutListing) {
        scrollDownPageOn("200");
        sleep(1000);
        $(byXpath("//div[@id='property_about']/div[@class='row']")).shouldHave(text(aboutListing));
    }
    @Step
    public void verifyAboutPropertyRooms(String aboutListing) {
        $(byXpath("//div[@id='property_about']/div[@class='u_m20-top']")).shouldHave(text(aboutListing));
    }
    @Step
    public void verifyAddedPropertyWithAllFieldsCouple(String listingAbout) {

        verifyAddedPropertyRooms(listingAbout);

    }
    @Step
    public void verifyAddedPropertyRooms(String listingAbout) {

        verifyAboutProperty(listingAbout);

    }
    @Step
    public void verifyAddedPropertyNoRoom(final String listingAbout) {

        verifyAddedPropertyWithAllFieldsCouple(listingAbout);

    }
    @Step
    public void signUpPopupName(String text) {
        $(byXpath("//h1")).shouldHave(text(text));

    }
    @Step
    public void noConverInbox(String text) {
        $(byXpath("//h1")).shouldHave(text(text));

    }
    @Step
    public void textNoGroup(String text) {
        sleep(2000);
        $(byXpath("//h2[contains(@class,'box-info')]")).shouldHave(text(text));
    }
    @Step
    public void nameUserInGroup(String name, int userInGroup) {
        $$(byXpath("//div[@id='js-groups-list']//div//div[@class='text-12 hunters-list--username']")).get(userInGroup).shouldHave(text(name));
    }
    @Step
    public void buddy_upGroup() {

    }
    @Step
    public void isNotActive(final String propertyID) {

        if($(byXpath("//div[@id='listing-" + propertyID + "']//a[contains(.,'here ')]")).isDisplayed()){
            $(byXpath("//div[@id='listing-" + propertyID + "']//a[contains(.,'here ')]")).click();
            sleep(2000);
        }

    }
    @Step
    public void roomVerification(final String roomNumber, final String roomPrice,final String deposit, final String bills,
                    String dateNumber, String month, String yearNumber, String lenthOfStay, String descriptionOfRoom) {
        String room = "//span[contains(.,'"+roomNumber+"')]/../..//";

        $(byXpath(room+"div[@class='col-xs-4 u_p0-left']")).waitUntil(visible, 5000);

        if($(byXpath(room+"div[@class='col-xs-4 u_p0-left']")).exists()){
            $(byXpath(room+"div[@class='col-xs-4 u_p0-left']")).shouldHave(text(roomPrice + "\n" +   "month")); }

        if($(byXpath(room+"div[@class='col-xs-4']")).exists()){
            $(byXpath(room+"div[@class='col-xs-4']")).shouldHave(text("Deposit\n" + deposit)); }

        if($(byXpath(room+"div[@class='u_ed-block text-13']")).exists()){
            $(byXpath(room+"div[@class='u_ed-block text-13']")).shouldHave(text(("Bills pcm\n" + bills)));  }

        if($(byXpath(room + "div[@class='col-xs-6 u_p0-right']")).exists()){
            $(byXpath(room + "div[@class='col-xs-6 u_p0-right']")).shouldHave(text("Length of Stay\n" +
                lenthOfStay));}

        if($(byXpath(room + "div[@class='clearfix u_m15-top']/p")).exists()){
            $(byXpath(room + "div[@class='clearfix u_m15-top']/p")).shouldHave(text(descriptionOfRoom));}

        if($(byXpath(room + "div[@class='col-xs-6 u_p0-left']")).exists()){
            $(byXpath(room + "div[@class='col-xs-6 u_p0-left']")).shouldHave(text(("Available from\n" + dateNumber+" " + month+" " + yearNumber)));
        }


    }
    @Step
    public void noRoomVerification(final String roomNumber) {
        String room = "//span[contains(.,'"+roomNumber+"')]/../..//";

        $(byXpath("//ul[@class='tabs-2']//a[contains(.,'Rooms')]")).click();
        $(byXpath(room+"div[@class='col-xs-12 col-md-7']")).shouldNot(exist);
        $(byXpath(room + "div[@class='col-xs-6 u_p0-left']/strong")).shouldNot(exist);
        $(byXpath(room + "div[@class='col-xs-6 u_p0-right']")).shouldNot(exist);
        $(byXpath(room + "div[@class='clearfix u_m15-top']/p")).shouldNot(exist);
        $(byXpath(room + "div[@class='col-xs-6 u_p0-left']")).shouldNot(exist);
    }
    @Step
    public void roomPriceNotif(final String tipsRent) {
        $(byXpath("//input[@id='room-price']/../../p[contains(@class,'help-block-error')]")).shouldHave(text(tipsRent));
    }
    @Step
    public void matchingForLordIsHidden() {
        $(byXpath("//div[contains(@class,'card-matching ')]")).shouldNotBe(exist);
    }
    @Step
    public void featuresOnTheCard() {
        List<String> featureProp = $$(byXpath("//div[span[contains(.,'AgentF')]]//ancestor::div[contains(@id,'property_card_')]//div[starts-with(@class,'card-img--label')]/a/span")).texts();
        List<String> featurePropExpected = Arrays.asList("BILLS INCL.", "ZERO DEPOSIT", "GYM", "CONCIERGE", "STUDENT");
        Assert.assertEquals(featurePropExpected,featureProp);


    }
    @Step
    public void notifSpamer(final String mesToSpamer) {

        $(byXpath("//div[@class='alert alert-danger']")).shouldHave(text(mesToSpamer));

    }
    @Step
    public void notifSpamerNotExist() {

        $(byXpath("//div[@class='alert alert-danger']")).shouldNot(exist);

    }
    @Step
    public void profileHasMatching() {
        $(byXpath("//span[contains(@class,'btn u_ed-inline-block')]")).shouldHave(text("100% match"));

    }

    //@Step
    public void profileHasMatching1() throws IOException {
        $(byXpath("//span[contains(@class,'btn u_ed-inline-block')]")).shouldHave(text("100% match"));
        getBytes("listing.png");
    }
    //@Attachment(value = "Вложение", type = "application/json")
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/test/resources/", resourceName));
    }


}