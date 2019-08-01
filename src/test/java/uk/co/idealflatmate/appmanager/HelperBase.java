package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.security.SecureRandom;
import java.util.List;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.url;
import static uk.co.idealflatmate.tests.TestBase.newPage;


public class HelperBase  {
    @Step
    public static void closeAdvPopUp() {
        PopUpHelper popUpHelper = new PopUpHelper();
        String needSpace = popUpHelper.closeAdvPopup;

        if ($(byXpath(needSpace)).is(visible)) {
            hoverClick(needSpace);
            sleep(2000);
        }

        if ($(byXpath(needSpace)).isDisplayed()) {
            hoverClick(needSpace);
            sleep(2000);
        }

    }
    @Step
    public static void closeListRenewPopUp() {
        PopUpHelper popUpHelper = new PopUpHelper();
        String buttonRenew = popUpHelper.closeRenewPopup;
        sleep(1000);
        if($(byXpath(buttonRenew)).isDisplayed()){
            $(byXpath(buttonRenew)).waitUntil(visible, 2000).click();
        }
    }
    @Step
    public static void propertySortBy(String value) {
        SearchHelper searchHelper = new SearchHelper();
        $(searchHelper.sortProperty).waitUntil(visible, 5000).selectOptionContainingText(value);
    }
    @Step
    public static void closeMatchPopUp() {
        PopUpHelper popUpHelper = new PopUpHelper();
        SelenideElement buttonMatch = $(byXpath(popUpHelper.closeMatching));
        sleep(1000);
        if (buttonMatch.isDisplayed()) {
            buttonMatch.waitUntil(visible, 3000).click();
        }
    }
    @Step
    public static void noCloseMatchPopUp() {
        PopUpHelper popUpHelper = new PopUpHelper();
        SelenideElement buttonMatch = $(byXpath(popUpHelper.closeMatching));
        buttonMatch.shouldNotBe(visible);

    }
    @Step
    public static void closeButtonRenew() {
        $(byXpath("(//button[@aria-label='Close'])[2]")).click();
    }
    @Step
    public static List<String> getFMcardSearchText() {
        return $$(byXpath("//div[@class='card-profile-text']")).texts();
    }
    @Step
    public static List<String> getCardUserType() {
        $(byXpath("(//div[@class='card-profile-text']/span[@class='card-top-username u_ed-block text-11 text-muted'])[1]")).waitUntil(visible, 10000);
        return $$(byXpath("//div[@class='card-profile-text']/span[@class='card-top-username u_ed-block text-11 text-muted']")).texts();

    }
    @Step
    public static SelenideElement setCardUserType() {

        return $(byXpath("(//div[@class='card-profile-text']/span[@class='card-top-username u_ed-block text-11 text-muted'])[1]"));

    }



    public static List<String> getCardUserSelectLabel() {

        return $$(byXpath("//div[@class='card-matching text-uppercase text-12 text-center u_bg-orange']")).texts();

    }

    public static int getCardUserSelectLabelNumber() {

        return $$(byXpath("//div[@class='card-matching text-uppercase text-12 text-center u_bg-orange']")).size();

    }
    public static void scrollDownPageOn(final String points) {
        executeJavaScript("scrollBy(0," + points + ")");
    }

    public static void scrollUpPage(final String points) {
        executeJavaScript("scrollBy(0," + points + ")");
    }



    public void fillInField(String text, SelenideElement selElem) {
        sleep(1500);
        selElem.waitUntil(visible, 2000).click();
        selElem.waitUntil(visible, 2000).clear();
        selElem.waitUntil(visible, 2000).setValue(text);
    }


    public void gmailLogin(String text, String field, String next) {
        $(byXpath(field)).waitUntil(appears, 10000).click();
        $(byXpath(field)).waitUntil(appears, 10000);
        $(byXpath(field)).shouldBe(visible);
        $(byXpath(field)).setValue(text);
        $(byXpath(next)).click();
        sleep(2000);
    }



    public void toHomePage() {
        //$(By.xpath("//a[@class='navbar-brand']")).click();
        open("http://front.idealflatmate4test.demo.devplatform2.com/");

    }

    public void Field2(String locator, String phone) {
        $(locator).click();
        $(locator).clear();
        $(locator).setValue(phone);
    }

    public void FieldEnter(String text, SelenideElement string1, SelenideElement string2) {
        string1.click();
        string1.clear();
        string1.setValue(text);
        sleep(1000);
        string2.click();
    }

    public void dateMonthYear(String day, String month, String year, SelenideElement day1, SelenideElement month1, SelenideElement year1) {
        day1.selectOptionByValue(day);
        month1.click();
        month1.selectOptionByValue(month);
        year1.click();
        year1.selectOptionByValue(year);
    }


    public static void pageUrlVerifStageGoLive(){
        // проверить, что вы находитесь на верной странице
        if (! url().equals("https://www.idealflatmate.co.uk/")) {
            newPage("https://www.idealflatmate.co.uk/");
        }

    }


    public static void pageUrlVerifLiveGoStage(){
        // проверить, что вы находитесь на верной странице
        String currentUrl = url();

        if (!url().equals("http://front.idealflatmate4test.demo.devplatform2.com/")) {
            sleep(1000);
            close();
            newPage("http://front.idealflatmate4test.demo.devplatform2.com");
            //open("http://front.idealflatmate4test.demo.devplatform2.com");

        } else System.out.println(currentUrl);
    }


    public void closeOpen(String relOrAbsolUrl) {
        clearBrowserCache();
        clearBrowserCookies();
        close();

        open(relOrAbsolUrl);
    }

    public static void hoverClick(String xpath) {
        SelenideElement elementHoverClick = $(byXpath(""+xpath+"")).waitUntil(visible, 10000);
        elementHoverClick.hover().click();
    }

    public  void hoverClick1(SelenideElement elementHoverClick) {
        clickAfterWaitVisible(elementHoverClick, 10000);

    }

    public  void clickAfterWaitVisible(SelenideElement elementHoverClick, final int wait) {
        clickAfterWaitAppear(elementHoverClick, wait);

    }
    public  void clickAfterWaitAppear(SelenideElement elementHoverClick, final int wait) {
        elementHoverClick.waitUntil(visible, wait).hover().click();

    }


    public void searchPropertyBy(String location, SelenideElement location1) {

        location1.waitUntil(visible, 10000).click();
        for (char  c : location.toCharArray()) {
            sleep(500);
            String s = String.valueOf(c);
            location1.sendKeys(s);
        }
        //location1.waitUntil(visible, 10000).click();
        sleep(1000);


    }

    public static void clickButton(final String textButton, final String byTag) {
        sleep(1000);
        $(byXpath("//" + byTag + "[contains(.,'" + textButton + "')]")).click();
        sleep(1000);
    }

    public static  ElementsCollection cardsOnThePage() {
        ElementsCollection cardsOnThePage = $$(byXpath("//div[@class='card-body clearfix']"));
        return cardsOnThePage;
    }

    public static  ElementsCollection collectionReturn(final String xpath) {
        ElementsCollection collectionReturn = $$(byXpath(xpath));
        return collectionReturn;
    }





    public static  String postCodeFromCard(final String id_property) {
        String postCodeFromCard = $(byXpath("//div[@id='property_card_" + id_property + "']//div[@class='card-infos-left']/div")).text();

        return postCodeFromCard;
    }
    public static SelenideElement selenidElement(final SelenideElement sel_element) {
        SelenideElement selenidElement = (sel_element);

        return selenidElement;
    }




    public static String  randomString( int len ){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
}
