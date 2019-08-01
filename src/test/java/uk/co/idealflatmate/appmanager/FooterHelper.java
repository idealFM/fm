package uk.co.idealflatmate.appmanager;

import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class FooterHelper extends HelperBase{
    private String block_home_quiz_addListing = "//div[@class='homepage-quiz-container container']";
    private String h2_text = "//h2";
    private String block_payment_method = "//div[@class='payment-logos']";
    private String block_NLA = "//div[@class='row']//div[@class='col-md-6 hidden-xs hidden-sm text-right']//img";
    private String button_NLApage = "(//ul/li/a[contains(text(), 'Join the NLA')])[1]";
    private String button_icon_FB = "//img[@alt='Facebook']";
    private String urlCurrent = "https://www.facebook.com/idealflatmate/";
    private String button_icon_Twitter = "//img[@alt='Twitter']";
    private String text_TwiterPage = "//img[@class='ProfileAvatar-image ' and @alt='ideal flatmate']";
    private String text_InstagrPage = "//img[@alt='Instagram']";
    private String h1_text = "(//h1)[1]";
    private String button_icon_YouTube = "//img[@alt='YouTube']";
    @Step
    public void verificationFooterHome() {
        $(byXpath(block_home_quiz_addListing)).waitUntil(exist, 6000).should(exist);
    }
    @Step
    public void verificationHowItWorks() {
        $(byXpath(h2_text)).waitUntil(visible, 10000).shouldHave(text("How Ideal Flatmate Works"));
    }
    @Step
    public void footerNLAPaymentsClick() {

        hoverClick(block_payment_method);
        hoverClick(block_NLA);

    }
    @Step
    public void verificationNLAWorks() {
        $(byXpath(button_NLApage)).waitUntil(visible, 10000).exists();
    }
    @Step
    public void footerFB() {
        hoverClick(button_icon_FB);

    }
    @Step
    public void verificationFB() {
        //switchTo().window(1);
        String urlNla= url();
        Assert.assertEquals(urlCurrent, urlNla);
        toHomePage();
    }
    @Step
    public void footerTwitter() {
        $(byXpath(button_icon_Twitter)).waitUntil(visible, 4000).click();
    }
    @Step
    public void verificationTwitter() {
        switchTo().window(1);
        $(byXpath(text_TwiterPage)).waitUntil(exist, 30000).should(exist);
    }
    @Step
    public void footerInstagram() {
        $(byXpath(text_InstagrPage)).waitUntil(visible, 4000).click();
    }
    @Step
    public void verificationInstagram(final String text) {
        switchTo().window(1);
        $(byXpath(h1_text)).waitUntil(exist, 30000).shouldHave(text(text));

    }
    @Step
    public void footerYoutube() {
        $(byXpath(button_icon_YouTube)).waitUntil(visible, 4000).click();
    }
    @Step
    public void verificationYoutube() {
        sleep(1000);
        switchTo().window(1);
        $(byXpath("//span[@id='channel-title' and contains(text(), 'ideal flatmate')]")).waitUntil(visible, 10000).should(exist);

    }

    @Step
    public void verificationAskLandlord() {
        //switchTo().window(1);
        $(byXpath("//h1[contains(., '#AsktheLandlord')]")).should(exist);


    }
    @Step
    public void verificationModern() {
        //switchTo().window(1);
        $(byXpath("//h1[contains(., 'Modern Living Index')]")).should(exist);

    }
    @Step
    public void footerClick(String item) {

        sleep(2000);
        hoverClick("//a[@class='u_ed-block u_p5-top u_p5-bottom' and contains(., '" + item + "')]");

    }
    @Step
    public void verificationFooter(String titleItem) {
        $(byXpath("//title[contains(text(), '" + titleItem + "')]")).waitUntil(exist, 10000).should(exist);
    }
//pageobject
    /*
    public SelenideElement verificationHowItWorks1(String text) {
        return $(byXpath("//h2")).waitUntil(visible, 8000).shouldHave(text(text));

    }*/
}