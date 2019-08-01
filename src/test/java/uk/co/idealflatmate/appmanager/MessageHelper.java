package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ConfData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MessageHelper extends HelperBase {



    VerificationHelper v = new VerificationHelper();
    private SelenideElement submit = $(byXpath("//a[@class='btn btn-success btn-msg-send']"));

    @Step
    public void chooseAnyMessageFromList() {

        //$(".list-group").shouldBe(Condition.visible).click();
        $(byXpath("//p[contains(., 'Hi there! It looks great!')]")).waitUntil(Condition.appears, 4000).click();
    }
    @Step
    public void typeAndSendMessage(String message) {
        SelenideElement submit = $(byXpath("//a[@class='btn btn-success btn-msg-send']"));
        sleep(1000);
        if($(byXpath("//span[@class='close-link text-28']")).exists()){
            $(byXpath("//span[@class='close-link text-28']")).waitUntil(visible, 3000).click();
        }
        sleep(1000);
        if($(byXpath(v.safeTip)).exists()){
            $(byXpath(v.safeTip)).waitUntil(visible, 3000).click();
        }
        $("textarea.form-control.msgbox").shouldBe(visible).setValue(message);
        submit.shouldBe(visible).click();
    }
    @Step
    public void typeAndSendMessageWithoutTips(String message) {

        sleep(1000);
        if ($(byXpath(v.safeTip)).exists()){
            v.closeSafeTip();
            $("textarea.form-control.msgbox").waitUntil(visible, 3000).setValue(message);
            submit.shouldBe(visible).click();
        }else {
            $("textarea.form-control.msgbox").waitUntil(visible, 3000).setValue(message);
             submit.shouldBe(visible).click();}
    }
    @Step
    public void chooseAnyMessageFromPopup() {
        $("#notifications").click();
    }
    @Step
    public void click(By locator) {
        $(locator).click();
    }
    @Step
    public void chooseMessageTab(final String massage) {
        //$(byXpath("/html/body/header/div/ul[2]/li[3]")).waitUntil(Condition.appears, 4000).click();


        $(byXpath("//a[@class='dropdown-toggle' and contains(text(), 'Inbox')]")).waitUntil(Condition.appears, 4000).click();
            if ($(byXpath("//div[contains(text(), 'New messages')]")).isDisplayed()) {
                $(byXpath("//a[contains(text(), 'View all')]")).waitUntil(Condition.appears, 4000).click();
                v.closeSafeTip();
                //$(byXpath("//p[contains(.,'" + massage + "')]")).waitUntil(Condition.appears, 8000).click();
                    //if ($(byXpath("//li/a[@page='2']")).isDisplayed()) {
                       // $(byXpath("//li/a[@page='2']")).waitUntil(Condition.appears, 8000).click();
                       // sleep(5000);
                       // $(byXpath("//p[contains(.,'" + massage + "')]")).waitUntil(Condition.appears, 8000).click();
                }else{  v.closeSafeTip();}
                //$(byXpath("//p[contains(.,'" + massage + "')]")).waitUntil(Condition.appears, 8000).click();

    }
    @Step
    public void chooseMessageTabLordWithoutSubscr() {
        $(byXpath("//a[@class='dropdown-toggle' and contains(text(), 'Inbox')]")).waitUntil(Condition.appears, 4000).click();
        if ($(byXpath("//div[contains(text(), 'New messages')]")).isDisplayed()) {
            $(byXpath("//a[contains(text(), 'View all')]")).waitUntil(Condition.appears, 4000).click();

        }else{  }
    }
    @Step
    public void chooseMesTabView() {
        //$(byXpath("/html/body/header/div/ul[2]/li[3]")).waitUntil(Condition.appears, 4000).click();
        $(byXpath("//a[@class='dropdown-toggle' and contains(text(), 'Inbox')]")).click();
        sleep(3000);
        if ($(byXpath("//div[contains(text(), 'New messages')]")).isDisplayed()) {
            $(byXpath("//a[contains(text(), 'View all')]")).waitUntil(Condition.appears, 15000).click();
        }
    }
    @Step
    public void clickPropertyCardMessageUnlogged(final String property_id) {
        //$(byXpath("(//h2)[4]")).hover();
        //$$("a.card-start-chat.btn.btn-circle").get(indexOfCard).click();
        $("#property_card_" + property_id + " a.card-start-chat.btn.btn-circle").click();
    }
    @Step
    public  void clickPropertyCardFirstOnPage(){
        sleep(3000);
        $(byXpath("(//h2)[5]")).hover();
        sleep(1000);
        $(byXpath("(//div[@class='card-infos-left'])[1]")).click();

    }
    @Step
    public  void clickPropertyContact(){
        sleep(2000);
        click(By.xpath("//li[@class='active']//a"));
        //$(byXpath("//section[@id='property-infos']//div[@id='fixed-sidebar']")).click();

        hoverClick("//section[@id='property-infos']//a[@class='btn btn-success u_ed-block u_m10-top text-18']");

    }
    @Step
    public void clickFMCardMessageUnlogged() {

        $(byXpath("//div[1]/div/div/a[@class='card-start-chat btn btn-circle']")).shouldBe(visible).click();

    }
    @Step
    public void clickFMCardFirstOnPage() {

        $(byXpath("((//div[@class='card-img'])[1])//img")).click();
    }
    @Step
    public void clickFMContact() {
        $(byXpath("//a[starts-with(@class, 'btn btn-success')]")).waitUntil(visible, 6000).click();
    }



    @Step
    public void clickCardMessageLogged() {
        $(byXpath("//div[contains(text(), 'Newport PO30 2DN, UK')]/../../../../a[@class='card-start-chat btn btn-circle']")).waitUntil(visible, 6000).click();

    }
    @Step
    public void clickCardImgProperty(final String byLocation) {

        $(byXpath("//div[div[contains(@class,'card-body clearfix')]//div[contains(text(), '"+byLocation+"')]]//picture/img")).waitUntil(visible, 5000).click();
    }
    @Step
    public void clickPropertyCardFMnamePagelogged() {
        $(byXpath("//span[@class='card-top-username u_ed-block' and contains(text(), 'Jason, 40')]")).waitUntil(visible, 6000).click();

    }
    @Step
    public void clickFMPageMessage() {
        sleep(2000);

        $(byXpath("//div[@class='col-sm-4 u_m20-bottom-xs']//a[contains(., 'Message')]")).waitUntil(visible, 10000).click();

    }
    @Step
    public void clickUpgradeToMessage() {
        $(byXpath("//a[contains(text(), 'Upgrade to message')]")).waitUntil(visible, 6000).click();
    }
    @Step
    public void clickPhoneReveal() {
        sleep(2000);
        click(By.xpath("//li[@class='active']//a"));
        //$(byXpath("//section[@id='property-infos']//div[@id='fixed-sidebar']")).click();
        $(byXpath("//section[@id='property-infos']//span[contains(text(), 'Reveal')]")).click();
        sleep(2000);
    }
    @Step
    public void clickImgOwnerOnPropertyPage() {

        $(By.xpath("//div[@class='text-center u_ep-relative']/a")).click();

    }
    @Step
    public void clickMessage(String text) {
         $(byText(text)).click();
    }
    @Step
    public void clickMenuMessages() {

        $(byXpath("//span/a[contains(., 'Inbox')]")).click();
        sleep(2000);
        if($(byXpath(v.safeTip)).exists()){
            v.closeSafeTip();
        }

    }
    @Step
    public void clickMessagePropOwnerIcon() {
        $(byXpath("(//span[@class='u_m15-right u_m25-right-md conversation-v2-meta-images']/a/img)[2]")).click();
    }
    @Step
    public void photoOfOwnerInMessage(String photo1) {
        if (photo1.endsWith("no-image-initial.jpg")) {
            String photo2 = photo1.substring(0, 64);
            String messagePhoto = $(byXpath("(//a[@class='u_ed-inline-block messages-top-images--item']/ img)[1]")).getAttribute("src").substring(0, 64);
            Assert.assertEquals(photo2, messagePhoto);
        } else {
            String photo2 = photo1.substring(0, 73);
            String messagePhoto = $(byXpath("(//a[@class='u_ed-inline-block messages-top-images--item']/ img)[1]")).getAttribute("src").substring(0, 73);
            Assert.assertEquals(photo2, messagePhoto);

        }
    }
    @Step
    public void photoOfOwnerInMesBuddy_up(String photo1) {
            sleep(1000);
            if (photo1.endsWith("no-picture-circle.jpg")) {
                String photo2 = photo1.substring(55, 65);
                String messagePhoto = $(byXpath("//section[@id='property-infos']//div[@id='fixed-sidebar']//a/ img")).getAttribute("src").substring(54, 64);
                Assert.assertEquals(photo2, messagePhoto);
            } else {
                String photo2 = photo1.substring(0, 73);
                String messagePhoto = $(byXpath("//section[@id='property-infos']//div[@id='fixed-sidebar']//a/ img")).getAttribute("src").substring(0, 73);
                Assert.assertEquals(photo2, messagePhoto);

            }
    }


    @Step
    public void nameOfOwnerInMessage(String name1, final String userName){
            String name2 = (name1.split(","))[0].replaceAll("/,",  "");

            //String nameInMessage = $(byXpath("//p[@class='quickMessage']")).getText();
            //String nameInMessage1 = (nameInMessage.split("\\|"))[0].replaceAll("\\|",  "");
            //String nameInMessage1 = (nameInMessage.substring(11, 22));
            v.lastMessage.shouldHave(text("Hi " +name2+", your room looks great! Are you holding viewings?"));
            //String nameInMessage1 = (nameInMessage.replaceAll("\\|",  ""));
            //Assert.assertEquals(name2, nameInMessage1);

        }
    @Step
    public void messageVerifying(String message1) {
        //String messagePlaceholder = $("textarea#messagewritesignupform-message").text();
        //String name2 = (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        //String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String messageInbox = $(byXpath("//div[@class='msg-body']")).text();
        Assert.assertEquals(message1, messageInbox);
    }
    @Step
    public void clickMessage1Inbox() {
        $$(byXpath("//div[@class='text-14 u_m15-left u_m5-top-sm u_m10-top-lg']")).get(0).click();
    }
    @Step
    public void messageToPropertyExist(final String idProperty) {
        $(byXpath("//div[@class='col-md-5 u_ea-right-md']/em[contains(.,'" + idProperty + "')]")).should(exist);

    }
    @Step
    public void propertyPostcodeVerifying(String postCode) {
        String messageInbox = $(byXpath("//section//div[h2[contains(.,'Location')]]//p")).text();
        messageInbox.endsWith(postCode);
    }
    @Step
    public void propertyPostcodeVerifMes(String postCode) {
        String messageInbox = $(byXpath("//select[@id='property-select']//optgroup/option")).text();
        //Assert.assertEquals(messageInbox, postCode);
        messageInbox.endsWith(postCode);
    }
    @Step
    public void verifyNoProperties(String text) {
        $(byXpath("//select[@id='property-select']/option")).shouldHave(text(text));
    }

    @Step
    public void sendDecline(String text) {
        v.closeSafeTip();
        $(byXpath("//button[@class='btn-cancel']")).click();
        $(byXpath("//button[@class='btn btn-success']")).click();
        sleep(2000);
        $(byXpath("(//div[@class='msg msg-sent'][last()]//span[last()])[2]")).shouldHave(text(text)).click();
        sleep(2000);
    }

    @Step
    public void verifyMemberImgInboxNumber(int numberOfUsers) {
        sleep(3000);
        int memberNumber = $$(byXpath("(//div[contains(@class,'col-xs-9 col-md-10')]//strong[contains(.,'Ronald')]/../../../..//div[@class='circle-card-img'])[1]/img")).size();
        Assert.assertEquals(memberNumber,numberOfUsers);
    }

    @Step
    public void numberConverInbox(int numberOfConv) {
        sleep(3000);
        int converNumber = $$(byXpath("//div[@class='text-14 u_m15-left u_m5-top-sm u_m10-top-lg']")).size();
        Assert.assertEquals(converNumber,numberOfConv);
    }
    @Step
    public void backToInbox() {
        $(byXpath("//a[contains(text(), ' Back to inbox')]")).click();
    }
    @Step
    public void messageSearchFM(final String cardNumber, final String url) {
        SignUpHelper s = new SignUpHelper();
        s.click1CardMessage(ConfData.getData(cardNumber));
        typeAndSendMessageWithoutTips(ConfData.getData(url));
    }
    @Step
    public void messageSearchFM1(final int cardNumber, final String message1) {
        SignUpHelper s = new SignUpHelper();
        sleep(1000);
        s.click1CardMessage1(cardNumber);
        typeAndSendMessageWithoutTips(ConfData.getData(message1));
    }
}