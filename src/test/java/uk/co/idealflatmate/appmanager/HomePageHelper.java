package uk.co.idealflatmate.appmanager;


import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;


public class HomePageHelper {





    @Step
    public void clickFM() {

        $(byXpath("(//div[@class='card-top-profile-img u_p5-right'])[1]")).waitUntil(visible, 4000).click();
    }
    @Step
    public void verificationFM() {
        $(byXpath("(//h4[@class='u_m0-top u_m20-bottom text-16'])[1]")).waitUntil(visible, 4000).shouldHave(text("About me"));
    }
    @Step
    public void clickFind() {
        $(byXpath("(//a[@href='/p/how-it-works'])[1]")).waitUntil(visible, 4000).click();
    }
    @Step
    public void verificationPageLinkHowItWorks() {
        $(byXpath("//title[contains(text(), 'How it works')]")).waitUntil(exist, 6000).should(exist);
    }
    @Step
    public void clickFindYourNewFM() {
        $(byXpath("//button[@data-target='#matchModal']")).waitUntil(visible, 4000).click();
    }
    @Step
    public void verificationMatchingStart() {
        $(byXpath("//h1")).waitUntil(visible, 4000).shouldHave(text("The ideal flatmate\n" +
                "Compatibility Quiz"));


    }
    @Step
    public void clickAddListingFromHow() {
        $(byXpath("//div[@class='skew-content clearfix']//a[@href='/create']")).waitUntil(visible, 4000).click();
    }
    @Step

    public void clickTakeMatching() {
        $(byXpath("//a[@data-target='#matchModal']")).waitUntil(visible, 4000).click();
    }
    @Step
    public void hoverCommunity() {

        $(byXpath("//nav//ul[@class='dropdown-menu']/../a[contains(text(), 'Community')]")).hover();
    }
    @Step
    public void clickFMBlog() {

        $(byXpath("//a[contains(text(), 'Flatmate HQ')]")).waitUntil(visible, 4000).click();
    }


    @Step
    public void clickLandlordBlog() {
        $(byXpath("//a[contains(text(), 'Landlord HQ')]")).waitUntil(visible, 4000).click();
    }


    @Step
    public void clickLogo() {
        $(byXpath("//header//div[@class='branding']//a/img")).waitUntil(visible, 4000).click();
    }
    @Step
    public void verificationLogo() {
        switchTo().window(0);
        $(byXpath("//div[@class='site-header__controls']/a/img[@class='nla-logo']")).waitUntil(exist, 5000).should(exist);

    }
    @Step
    public void clickBlogFMImgLink() {
        $(byXpath("(//div[@class='col-xs-6 u_p5-right-xs u_ed-flex']/div/div/a/img)[1]")).waitUntil(visible, 4000).click();
    }
    @Step
    public void clickBlogLandlordImgLink() {
        $(byXpath("(//div[@class='col-xs-6 u_p5-right-xs u_ed-flex']/div/div/a/img)[2]")).waitUntil(visible, 4000).click();
    }
    @Step
    public void clickBlogFMTextLink() {
        $(byXpath("(//div[@class='u_p10-xs u_p15-sm']/a)[1]")).waitUntil(visible, 4000).click();
    }
    @Step
    public void clickBlogLandlordTextLink() {
        $(byXpath("(//div[@class='u_p10-xs u_p15-sm']/a)[2]")).waitUntil(visible, 4000).click();
    }
    @Step
    public void amountOfBlogBlocks(int size) {

        $$(byXpath("//section[starts-with(@class, 'homepage-quiz-list')]/div")).shouldHaveSize(size);

    }
    @Step
    public void amountOfLatestFMblocks(int size) {
        $$("div.circle-card-img").shouldHaveSize(size);

    }
    @Step
    public void amountOfFeedbackBlocks(int size) {

        $$(byXpath("//ul[@class='testimonials-list child-4-per-row grid-row-mobile__child']/li")).shouldHaveSize(size);
    }
    @Step
    public void amountOfFeaturedRoom(int size) {
        $$(byXpath("//div[@class='card-img with-overlay']")).shouldHaveSize(size);
    }
    @Step
    public void amountOfAreasBlocks(int size) {

        $$("#hp-areas div.card-btr-amenities.text-white").shouldHaveSize(size);

        }
    @Step
    public void amountOfMatchListRoom(int size) {
        $$(byXpath("//section[@class='homepage-quiz-list col-sm-10 col-sm-offset-1 col-md-12 col-md-offset-0 u_p0 u_ed-flex-sm u_p25-top u_p25-bottom']/div")).shouldHaveSize(size);
    }
    @Step
    public void TextInAreas() {
        $$("#hp-areas div.owl-stage-outer").shouldHave(texts("test\n" +
                "East London\n" +
                "Clapham\n" +
                "South London\n" +
                "ZONE 2\n" +
                "Barnet Gate\n" +
                "East London\n" +
                "Ealing\n" +
                "West London\n" +
                "ZONE 3\n" +
                "Walthamstow\n" +
                "East London\n" +
                "ZONE 3"));
    }
    @Step
    public void clickFindRooms() {
        $(byXpath("(//a[contains(., 'or learn more ')])[1]")).click();

    }
    @Step
    public void clickFindFM() {
        $(byXpath("(//a[contains(., 'or learn more ')])[2]")).click();
    }
    @Step
    public void verificationPageLinkHowItWorksRooms() {
        $(byXpath("//h1")).shouldHave(text("Find Great Tenants"));

    }
    @Step
    public void verificationPageLinkHowItWorksFM() {
        $(byXpath("//h1")).shouldHave(text("Find Rooms to Rent"));
    }
    @Step
    public void scrollToBlockProperty() {
        HelperBase.hoverClick("//h2[starts-with(@class, 'u_m0 u_m10-bottom')]");
        //$(byXpath("//h2[starts-with(@class, 'u_m0 u_m10-bottom')]")).waitUntil(visible, 10000).click();
    }
    @Step
    public void scrollToBlockSelect() {
        $(byXpath("//h3[@class='text-64 u_m0 u_m5-bottom']/../p")).waitUntil(visible, 10000).click();
    }



    //private void $$(boolean equals) {

    /*
    public void experimentGetTest() {
        $$(byXpath("//div[@class='owl-item active']")).get();
        Assert

    }*/
}
