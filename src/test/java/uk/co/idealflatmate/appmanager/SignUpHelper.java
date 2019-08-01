package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ConfData;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SignUpHelper extends HelperBase {
    private String roomClick = "//h3[@class='u_m0' and contains (text(), 'A room')]";
    private String photoClick = "//input[@id='moreinfosignupform-file']";
    public String dragLow = "//div[@class='noUi-handle noUi-handle-lower']";
    public String dragUpper = "//div[@class='noUi-handle noUi-handle-upper']";
    public SelenideElement input_email_confirm = $("input#verifyemailform-email");
    public SelenideElement input_email_settings = $("input#changecontactform-email");
    public SelenideElement link_conf_sendAgain = $(byXpath("//a[contains(.,'Click here to send again')]"));
    public SelenideElement buttonSubmitSendConf = $(byXpath("//button[@class='confirm']"));
    public SelenideElement link_conf_change = $(byXpath("//a[@href='#edit-email']"));
    public SelenideElement emailInput = $(byXpath("//input[contains(@id,'-email')]"));

    @Step
    public void clickRoom() {
        $(byXpath(roomClick)).click();
    }
    @Step
    public void backFromEmailToRoom() {
        $(byXpath("//a[contains (., 'back')]")).click();
     }
    @Step
    public void clickEmailPopup() {
        $(byXpath("//div[@id='signupRevealModal']//a[span[contains (text(), 'Sign up with email')]]")).click();
    }
    @Step
    public void clickEmail() {
        $(byXpath("//span[contains (text(), 'Sign up with email')]")).waitUntil(appear, 10000);
        $(byXpath("//span[contains (text(), 'Sign up with email')]")).waitUntil(visible, 10000).click();

    }
    @Step
    public void clickEmailMatching1() {
        $(byXpath("//a[contains (., 'Sign up with email')]")).click();
    }
    @Step
    public void setSignUpNameF(String nameF) {
        fillInField (nameF, $(byXpath("//input[contains(@id,'-first_name')]")));
    }
    @Step
    public void setSignUpNameFMessage(String nameF) {
        fillInField(nameF, $(byXpath("//input[contains(@id,'-first_name')]")));
    }
    @Step
    public void genderFemaleSelect(final String gender) {

      $(byXpath("//div[contains(@class,'gender required')]//label[contains(text(), '" + gender + "')]")).click();

    }
    @Step
    public void genderFemaleSelectMessage() {
        sleep(1000);
        $(byXpath("//div[@class='form-group field-yourinfoadditionalsignupform-gender required']/div[1]/label[contains(text(), 'Female')]")).waitUntil(visible, 5000).click();
    }
    @Step
    public void genderMaleSelectAfterBlank() {

        $(byXpath("//div[@id='yourinfosignupform-gender']/label[contains(text(), 'Male')]")).click();
        //$(byXpath("//div[@class='form-group field-yourinfosignupform-gender required']/div[1]/label[contains(text(), 'Female')]")).selectRadio("Female");
    }

    @Step
    public void genderMaleSelect() {
        $(byXpath("//div[@class='form-group field-yourinfosignupform-gender required']/div[1]/label[contains(text(), 'Male')]")).click();
    }

    public void genderCheckerPrefer() {
        $(byXpath("//div[@class='form-group field-yourinfosignupform-gender required']/div[1]/label[contains(text(), 'Prefer not to say')]/input")).is(checked);
    }
    @Step
    public void setSignEmail(String confEmail) {
        fillInField(ConfData.getData(confEmail), emailInput);
    }

    @Step
    public void setSignEmailMessage(String confEmail) {
        fillInField(ConfData.getData(confEmail), emailInput);
    }
    @Step
    public void setSignPassword(String confPassword) {
        fillInField(ConfData.getData(confPassword), $(byXpath("//input[contains(@id,'-password')]")));
    }
    @Step
    public void setSignPasswordMessage(String confPassword) {
        fillInField(ConfData.getData(confPassword), $(byXpath("//input[contains(@id,'-password')]")));
    }
    @Step
    public void clickFormSignUpContinue() {
        $(byXpath("(//button[contains(text(), 'Continue')])[1]")).waitUntil(appears, 4000).click();
        sleep(2000);
    }
    @Step
    public void clickYourInformationContinue() {
        sleep(1000);
        $(byXpath("//button[contains(text(), 'Continue')]")).waitUntil(appears, 4000).click();
        sleep(2000);
    }
    @Step
    public void clickCompleteSearchPref() {

        $(byXpath("//button[@class='btn btn-block btn-primary ws-normal u_m20-bottom']")).waitUntil(appears, 8000).click();
        sleep(2000);
    }
    @Step
    public void profilePhotoAddJpeg() {
        $(byXpath(photoClick)).uploadFile(new File("src/test/resources/profile1.jpeg"));
        sleep(2000);
    }
    @Step
    public void profilePhotoAddPng() {
        $(byXpath(photoClick)).uploadFile(new File("src/test/resources/Profile.png"));
        sleep(2000);
    }
    public void profilePhotoAddJpg() {
        $(byXpath(photoClick)).uploadFile(new File("src/test/resources/Property1.jpg"));
        sleep(2000);
    }
    @Step
    public void profilePhotoAddJpeg10Mb() {
        $(byXpath(photoClick)).uploadFile(new File("src/test/resources/8mb-artwork.jpg"));
        sleep(2000);
    }
    @Step
    public void profilePhotoAddPdf() {
        $(byXpath(photoClick)).uploadFile(new File("src/test/resources/IF-pdf.pdf"));
        sleep(2000);
    }
    @Step
    public void profilePhotoRemove() {
        $(byXpath("//div[@onclick='Auth.removeUploadImage()']")).waitUntil(appears, 4000).click();
        sleep(3000);

    }
    @Step
    public void profileDateBirthAdd(String day, String month, String year) {
        dateMonthYear(day, month, year, $(byXpath("//select[contains(@id,'-day')]")),
                                        $(byXpath("//select[contains(@id,'-month')]")),
                                        $(byXpath("//select[contains(@id,'-year')]")));
    }
    @Step
    public void profileDateBirthAddMessage(String day, String month, String year) {
        dateMonthYear(day, month, year, $(byXpath("//select[contains(@id,'-day')]")),
                                        $(byXpath("//select[contains(@id,'-month')]")),
                                        $(byXpath("//select[contains(@id,'-year')]")));
    }
    @Step
    public void profilePhone(String phone) {
        //Field2("input#moreinfosignupform-phone", phone);


            String val = phone;
            SelenideElement element = $("input#moreinfosignupform-phone");
            element.clear();
            for (char  c : val.toCharArray()) {
                sleep(500);
                String s = String.valueOf(c);
                element.sendKeys(s);
            }
            sleep(1000);


    }
    @Step
    public void profilePhoneMessage(String phone) {
        //Field2("#messagewritesignupform-phone",phone);
        String val = phone;
        SelenideElement element = $("#messagewritesignupform-phone");

        for (char  c : val.toCharArray()) {
            sleep(500);
            String s = String.valueOf(c);
            element.sendKeys(s);
        }
        sleep(1000);
    }
    @Step
    public void occupation(String profOption, String defaultOccupation, String occupationNew) {
        String occupation = $(byXpath("//select[@id='moreinfosignupform-occupation_id']")).getSelectedOption().getText();
        Assert.assertEquals(defaultOccupation, occupation);
        $(byXpath("//select[@id='moreinfosignupform-occupation_id']")).selectOptionByValue(profOption);
        String newOccupation = $(byXpath("//select[@id='moreinfosignupform-occupation_id']")).getSelectedOption().getText();
        Assert.assertEquals(occupationNew, newOccupation);
    }
    @Step
    public void aboutYourself(String text) {
        $(byXpath("//textarea[@id='moreinfosignupform-bio']")).setValue(text);
    }
    @Step
    public void aboutAgency(String text, String text1) {
        $(byXpath("//textarea[@id='moreinfosignupform-bio']")).setValue(text);
        $(byXpath("//textarea[@id='moreinfosignupform-bio']/../../div/label")).shouldHave(text(text1));
    }


    @Step
    public void preferredLocation(String location, String area) {

        FieldEnter(location, $("input#location"), $(byXpath("//li//div[contains(text(), '" + area + "')]")));

    }
    @Step
    public void preferredLocationButton(String area2) {
        $(byXpath("//a[starts-with(@class,'btn btn-primary-outline') and contains(.,'" + area2 + "')]")).click();
    }
    @Step
    public void backClick() {
        $(byXpath("//a[contains (., 'back')]")).click();
        sleep(1000);
    }
    @Step
    public  void budgetMin() {

        $(byXpath(dragLow)).dragAndDropTo($(byXpath("//span[@class='text-12']")));
        sleep(1000);
        //dragLow.dragAndDropTo($(byXpath("//div/span[@class='text-14']")));
    }
    @Step
    public void budgetMax() {

        $(byXpath(dragUpper)).dragAndDropTo($(byXpath("//div[@class='text-11 u_m35-top text-center']")));

    }

    @Step
    public void verifyToMoveCheckboxDisabled() {
        //$(byXpath("//div[@class='form-group field-budgetpreferredsignupform-move_in_now has-success']//input[@type='checkbox']")).shouldBe(checked);
        $("select#budgetpreferredsignupform-move_in_day").shouldHave(disabled);
        sleep(2000);
    }
    @Step
    public void toMoveCheckboxEnabled() {
        //$(byXpath("//div[@class='form-group field-budgetpreferredsignupform-move_in_now has-success']//input[@type='checkbox']")).shouldBe(checked);
        $(byXpath("//label[@for='budgetpreferredsignupform-move_in_now']")).click();
    }
    @Step
    public void verificationDataProfileFullAgent() {
        $(byXpath("//div[@class='col-sm-5 h5 heading-spaced text-normal u_m20-top u_m30-top-md text-normal-weight']")).shouldNot(exist);
    }
    @Step
    public void verificationDataProfileNameUser(String name, String age) {
        $(byXpath("//h2/strong")).shouldHave(text(name));
        $(byXpath("//h2/span")).shouldHave(text(age));
    }
    @Step
    public void verificationDataProfileFotoDashboard() {
        $(byXpath("//div[@class='row u_m40-bottom-xs']//a/img[@src='/images/no-image-initial-square.jpg']")).shouldNot(exist);
    }
    @Step
    public void clickFM() {
       $(byXpath("//h3[@class='u_m0' and contains (text(), 'A flatmate for my vacant room')]")).click();
    }
    @Step
    public void quit() {
        $(byXpath("//a[starts-with(@class,'btn btn--type-2')]")).click();
    }
    @Step
    public void quitLogin() {
        $(byXpath("//a[contains(.,'Quit Log in')]")).click();
        sleep(2000);
    }
    @Step
    public void selectMoveDate(String day, String month, String year) {
        dateMonthYear(day, month, year, $(byXpath("//select[contains(@id,'move_in_day')]")),
                                        $(byXpath("//select[contains(@id,'move_in_month')]")),
                                        $(byXpath("//select[contains(@id,'move_in_year')]")));
    }
    @Step
    public void selectHappyReceiveNews() {
        $(byXpath("//label[@for='budgetpreferredsignupform-is_subscribed']")).click();
    }
    @Step
    public void clickShowMeMyMatches() {
        $(byXpath("//a[contains(.,'List your room')]")).click();
    }


    @Step
    public void clickListYourRoomMatching() {
        $(byXpath("//a[contains(., 'List your room! ')]")).click();
    }
    @Step
    public void clickSearchFMMatching() {
        $(byXpath("//a[contains(., 'Search for a flatmate ')]")).click();
    }
    @Step
    public void clearEmail() {
        emailInput.clear();
        
    }
    @Step
    public void clearEmailMessage() {
        emailInput.clear();
    }
    @Step

    public void clearFirstname() {
        $(byXpath("//input[contains(@id,'-first_name')]")).clear();
    }
    @Step

    public void clearFirstnameMessage() {
        $(byXpath("//input[contains(@id,'-first_name')]")).clear();
    }
    @Step

    public void clearPassword() {
        $(byXpath("//input[contains(@id,'-password')]")).clear();
    }
    @Step

    public void clearPasswordMessage() {
        $(byXpath("//input[contains(@id,'-password')]")).clear();
    }
    @Step

    public void click1CardMessage(final String numberOfCard) {
        $(byXpath("(//div[@class='card-infos-flex-row']/a[2][@href])[" + numberOfCard + "]")).click();

    }
    @Step
    public void click1CardMessage1(final int numberOfCard) {
        $(byXpath("(//div[@class='card-infos-flex-row']/a[2][@href])[" + numberOfCard + "]")).click();

    }
    @Step
    public void click1PropCardMes(String property_id) {
        scrollDownPageOn("600");
        sleep(1000);
        $(byXpath("//div[@id='property_card_"+ConfData.getData(property_id)+"']//div[@class='card-infos-flex-row']/a[2][@href]")).click();
    }

    @Step
    public void click1PropCardIDMes(final String id_property) {
        $(byXpath("//div[@id='property_card_" + id_property + "']//a[@class='card-start-chat btn btn-circle']")).click();

    }
    @Step
    public void photoOfOwner(String photo1) {
        if (photo1.endsWith("no-image-initial.jpg")) {
            String photo2 = photo1.substring(0, 77);
            String messagePhoto = $("div.col-xs-12 img").getAttribute("src").substring(0, 77);
            Assert.assertEquals(photo2, messagePhoto);
        } else {
            String photo2 = photo1.substring(0, 73);
            String messagePhoto = $("div.col-xs-12 img").getAttribute("src").substring(0, 73);
            Assert.assertEquals(photo2, messagePhoto);

        }

    }
    @Step
    public void verificationAutoMessageProperty(String name1) {

        String messagePlaceholder = $("textarea#messagewritesignupform-message").text();
        String name2 = (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String name4 = "Hi " + name3 + ", your room looks great! Are you holding viewings?";
        Assert.assertEquals(name4, messagePlaceholder);
    }
    @Step
    public void verificationAutoMessageFM(String name1) {

        String messagePlaceholder = $("textarea#messagewritesignupform-message").text();
        String name2 = (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String name4 = "Hi " + name3 + ", looks like we are well matched. When are you looking to move?";
        Assert.assertEquals(name4, messagePlaceholder);
    }
    @Step
    public void nameOfOwner(String name1) {
        //String name2 = "Message " + (name1.substring(0, 1).toUpperCase() + name1.substring(1)).replaceAll("[^a-zA-z]",  "");
        String name2 = "Message " + (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String nameInMessage = $("h1").getText();
        Assert.assertEquals(name3, nameInMessage);
    }
    @Step
    public void nameOfOwnerOnPopup(String name1) {
        //String name2 = "Message " + (name1.substring(0, 1).toUpperCase() + name1.substring(1)).replaceAll("[^a-zA-z]",  "");
        String name2 = "Sign up to send a message to " + (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String nameInMessage = $("h1").getText();
        Assert.assertEquals(name3, nameInMessage);
    }

    @Step
    public void clickBackToSearch() {
        $(byXpath("//button[@value='back_to_search']")).waitUntil(visible, 10000).click();
    }
    @Step
    public void titleOfSearchPage(String title1) {
        String title2 = $(byXpath("//head/title")).getText();
        Assert.assertEquals(title1, title2);

    }
    @Step
    public void clickSubmit() {
        $(byXpath("//button[@type='submitLogin']")).click();
    }
    @Step
    public void clickPropertyCard1(int indexOfCard) {
        $(byXpath("//h1")).click();
        $$(byXpath("//div[@class='card-img']")).get(indexOfCard).click();
        //ElementsCollection states = $$(byXpath("//div[@class='card-img']"));
        //LinkedList<String> state1 = new LinkedList<>();
    }
    @Step
    public void clickMessageProperty(String buttonText) {
        sleep(1000);
        $(byXpath("//section//a[contains(.,'" + buttonText + "')]")).waitUntil(visible, 5000).click();

    }
    @Step
    public void clickLikePropertyCard() {
        $(byXpath("//a[starts-with(@class,'buddy')]")).waitUntil(visible, 5000);
        $$(byXpath("//a[starts-with(@class,'buddy')]")).get(3).click();

    }
    @Step
    public void backToSearch() {
        $(byXpath("//button[starts-with(@class,'btn-link')]")).click();

    }
    @Step
    public void clickLikePropertyCardHomePage(int propertyCard) {


        $$(byXpath("//a[starts-with(@class,'buddy-star')]")).get(propertyCard).click();

    }

    @Step
    public String getEmail() {

        String getEmail = input_email_confirm.getValue();
        return getEmail;
    }
    @Step
    public String getEmailfromSettings() {
        String emailSettings = input_email_settings.getValue();
        return emailSettings;
    }
    @Step
    public void submitVerifyEmailPopup(final String newEmail) {

        input_email_confirm.clear();
        input_email_confirm.sendKeys(newEmail);
        $(byXpath("//div[@class='form-group']/button[@type='submit']")).click();

    }
    @Step
    public void confirmGmailSignUp(final String emailConf, final String emailNew) {
        $(byXpath("//div[@class='modal-body' and contains(.,'" + emailNew + "')]")).should(exist);
        link_conf_change.click();
        Assert.assertEquals(getEmail(), emailConf);

    }
    @Step
    public void confirmNewGmailSignUp(final String emailConf, final String emailNew, final String newEmail) {
        $(byXpath("//div[@class='modal-body' and contains(.,'" + emailNew + "')]")).should(exist);
        link_conf_sendAgain.click();
        buttonSubmitSendConf.click();

        link_conf_change.click();
        Assert.assertEquals(getEmail(), emailConf);
        submitVerifyEmailPopup(newEmail);
        buttonSubmitSendConf.click();

    }

    @Step
    public void removeLike() {
        $(byXpath("//span[starts-with(@class,'saved-property')]")).click();
        sleep(4000);
        $(byXpath("//button[@class='confirm']")).waitUntil(appear, 6000).click();
        sleep(4000);

    }



    @Step
    public void yourInformation(String confPassword, String firstName, String confEmail, final String gender) {
        setSignUpNameF(firstName);
        genderFemaleSelect(gender);
        login1(confEmail, confPassword);
        clickYourInformationContinue();
    }
    @Step
    public void yourInformationWithPhone (String password, String firstName, String email) {
        setSignUpNameF(firstName);
        genderFemaleSelect("Female");
        setSignEmail(email);
        setSignPassword(password);
        clickYourInformationContinue();
    }
    @Step
    public void priceMove(String day, String month, String year) {
        verifyToMoveCheckboxDisabled();
        toMoveCheckboxEnabled();
        selectMoveDate(day, month, year);
        selectHappyReceiveNews();
        clickYourInformationContinue();
    }
    @Step
    public void whereWouldLikeLive(String location, String area1) {
        preferredLocation(location, area1);
        clickYourInformationContinue();
    }

    @Step
    public void moreAboutYou(String day, String month, String year, String phone, String newOccupation, String text, String defaultOccupation, String occupationNew) {
        profilePhotoAddJpeg();
        profileDateBirthAdd(day, month, year);
        profilePhone(phone);
        occupation(newOccupation, defaultOccupation, occupationNew);
        aboutYourself(text);
        clickYourInformationContinue();
    }
    @Step
    public void moreAboutYou2(String day, String month, String year, String phone, String newOccupation, String text, String defaultOccupation, String occupationNew) {
        profilePhotoAddPng();
        profileDateBirthAdd(day, month, year);
        profilePhone(phone);
        occupation(newOccupation, defaultOccupation, occupationNew);
        aboutYourself(text);
        clickYourInformationContinue();
    }
    @Step
    public void signListingFM_LiveIn(String confEmail, String confPassword, String day, String month, String year, String phone, String newOccupation, String firstName, String defaultOccupation, String occupationNew) {


        clickEmail();

        setSignUpNameF(firstName);
        genderMaleSelect();
        login1(confEmail, confPassword);
        clickYourInformationContinue();

        profilePhotoAddJpeg();
        profilePhotoRemove();
        profileDateBirthAdd(day, month, year);
        profilePhone(phone);
        occupation(newOccupation, defaultOccupation, occupationNew);
        //signUpHelper.aboutYourself("Tell us about yourself");
        clickYourInformationContinue();
    }

    public void signListingFM_LiveInRandom(String confPassword, String firstName) {


        clickEmail();

        setSignUpNameF(firstName);
        genderMaleSelect();
        loginRandom(confPassword);

        //signUpHelper.aboutYourself("Tell us about yourself");

    }

    public void More_about_you(String day, String month, String year, String phone, String newOccupation, String defaultOccupation, String occupationNew) {
        profilePhotoAddJpeg();
        profileDateBirthAdd(day, month, year);
        profilePhone(phone);
        occupation(newOccupation, defaultOccupation, occupationNew);
    }

    @Step
    public void signListingLiveOut(String confEmail, String confPassword, String firstName, String phone) {


        clickEmail();

        setSignUpNameF(firstName);
        login1(confEmail, confPassword);
        clickYourInformationContinue();

        profilePhotoAddJpeg();
        profilePhone(phone);

        clickYourInformationContinue();

    }

    @Step
    public void agentSignListing(String name, String confEmail, String confPassword, String phone, String text) {


        clickEmail();
        setSignUpNameF(name);
        //signUpHelper.genderFemaleSelect();
        login1(confEmail, confPassword);
        clickYourInformationContinue();

        profilePhotoAddJpeg();
        profilePhotoRemove();
        //signUpHelper.profileDateBirthAdd("2", "5", "2000");
        profilePhone(phone);
        //signUpHelper.occupation("19");
        aboutYourself(text);
        clickYourInformationContinue();

    }
    @Step
    public void login1(String confEmail, String confPassword) {
        setSignEmail(confEmail);
        setSignPassword(confPassword);
    }

    @Step
    public void loginRandom(String confPassword) {
        setSignPassword(confPassword);
    }
    @Step
    public static String userName() {
        String userName = $("span.user-welcome--name").text();
        return userName;
    }


}
