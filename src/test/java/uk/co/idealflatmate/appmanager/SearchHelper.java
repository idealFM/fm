package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ConfDataProperty;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SearchHelper extends HelperBase {

    public static final String cardProp_Image = "//div[@id='property_card_";
    public static final String cardProp_Image_End = "']//div[@class='card-top-profile-img u_p5-right']/img";
    public static final String cardProp_Username = "//div[@id='property_card_";
    public static final String cardProp_Username_End = "']//span[@class='card-top-username']";
    public static final String headerTitle = "//head/title";
    public static final String postCode = "//div[@id='property_card_";
    public static final String postCode_End = "']//div[@class='card-infos-left']/div";
    public final String sortProperty = "#property-sort";


    @Step
    public static String getPropertyImage(String property_id) {
        String getPropertyImage = $(byXpath(cardProp_Image+ConfDataProperty.getData(property_id)+cardProp_Image_End)).getAttribute("src");
        return getPropertyImage;
    }
    @Step
    public static String getPropertyOwner(String property_id) {
        String getPropertyOwner = $(byXpath(cardProp_Username+ConfDataProperty.getData(property_id)+cardProp_Username_End)).text();
        return getPropertyOwner;
    }
    @Step
    public static String getPropertyTitle() {
        String getPropertyTitle = $(byXpath(headerTitle)).text();
        return getPropertyTitle;
    }
    @Step
    public static String getPropertyPostCode(String property_id) {
        String getPropertyPostCode = $(byXpath(postCode+ConfDataProperty.getData(property_id)+postCode_End)).text();
        return getPropertyPostCode;
    }



    private String inputSearch = "form input.react-autosuggest__input";
    public static SelenideElement field_searchBar_listing = $(byXpath("//form[@id='search-location']//input"));


    @Step
    public void searchPropertyHome(String location) {

        searchPropertyBy(location, $("input.react-autosuggest__input"));
        sleep(2000);

        //$(byXpath("//button[@class='text-20']")).waitUntil(visible, 10000).pressEnter();
        $("input.react-autosuggest__input").pressEnter();
    }
    @Step
    public void searchPropertyHome1(String location) {

        String val = location;
        SelenideElement element = $(inputSearch);

        for (char  c : val.toCharArray()) {
            sleep(500);
            String s = String.valueOf(c);
            element.sendKeys(s);
        }
        sleep(1000);
        element.pressEnter();
    }
    @Step
    public void searchPropertyHomePostCode(String location) {

        searchPropertyBy(location, $("input.react-autosuggest__input"));
        sleep(2000);
        $(byXpath("(//div[@id='react-autowhatever-1']//span[contains(.,'"+location+"')])[1]")).click();
    }
    @Step
    public void searchPropertyByEnter(String location) {

        searchPropertyBy(location, $("input.react-autosuggest__input"));
        $(byXpath("//input")).waitUntil(exist, 4000).pressEnter();


    }
    @Step

    public void searchPropertyBySelectfromList(String location, final String nameDrop) {
        searchPropertyBy(location, $("input.react-autosuggest__input"));
        $(byXpath("//span[contains(.,'" + nameDrop + "')]")).waitUntil(visible, 4000).click();

    }


    @Step
    public void searchPropertyIncorrectFirstfromList(String location) {

        searchPropertyBy(location, $("input.react-autosuggest__input"));

    }


    @Step
    public static String getNumberOfListing() {
        String getNumberOfListing = String.valueOf($(byXpath("//h1[@class='h4']")).text().substring(0, 12).replaceAll("[^0-9]", ""));
        return getNumberOfListing;
    }
    @Step
    public static String getNumberOfListingFound() {
        sleep(1000);
        $(byXpath("//h2[@class='text-14']")).waitUntil(appear, 5000);
        String getNumberOfListing = String.valueOf($(byXpath("//h2[@class='text-14']")).text().substring(0, 12).replaceAll("[^0-9]", ""));
        return getNumberOfListing;
    }
    @Step
    public void verificationSearchProperty(String listingNumber, final String text, final String text1) {
        sleep(1000);
        $(byXpath("//h1[@class='h4']")).waitUntil(visible, 15000).shouldHave(text(listingNumber));
        String number = getNumberOfListingFound();
        if(number.equals("1") || number.equals("0")){
            sleep(1000);
            $(byXpath("//h2[@class='text-14']")).waitUntil(visible, 15000).shouldHave(text(text1));
        } else sleep(1000);
        $(byXpath("//h2[@class='text-14']")).waitUntil(visible, 15000).shouldHave(text(text));
    }
    @Step
    public void verificationSearchPropertyMap(String location) {
        $(byXpath("//div[@class='u_p10-bottom u_m30-bottom u_b-bottom']/p")).waitUntil(visible, 10000).shouldHave(text(location));

    }
    @Step
    public void verificationSearchPropertyMes(String location, String IndexOfListing) {

        $(byXpath("//div[@id='property_card_"+(ConfDataProperty.getData(IndexOfListing))+"']//div[@class='row u_m0 u_m5-top']")).waitUntil(visible, 30000).shouldHave(text(ConfDataProperty.getData(location)));

    }
    @Step
    public void verificationSearchPropertyMesLive(String location, final String idProperty) {
        $(byXpath("//div[@id='property_card_" + idProperty + "']//div[@class='row u_m0 u_m5-top']")).waitUntil(visible, 30000).shouldHave(text(location));

    }


    @Step
    public void verificationSearchHomePage(String alert) {
        $(byXpath("//div[@class='js-no-location no-location u_p10-top text-center text-white']")).waitUntil(visible, 10000).shouldHave(text(alert));
    }
    @Step
    public void verificationFlatshare() {
        $(byXpath("//h1[contains(.,'Browse all cities')]")).exists();
        $(byXpath("//a/strong[contains(.,'London')]")).click();
        title().contains("Find A UK Room To Rent | Rent A Room | ideal flatmate");
        $(byXpath("//h2/a[contains(.,'North London')]")).click();
        $(byXpath("//strong[contains(.,'Chalk Farm')]")).click();
        $(byXpath("//h1[contains(.,'Living in Chalk Farm')]")).exists();
    }
    @Step
    public void zone1() {
        $(By.xpath("//a[contains(text(), 'Zone 1')]")).click();
    }
    @Step
    public void EastLDN1() {
        $(By.xpath("//a[contains(text(), 'East London')]")).click();
        sleep(5000);
    }
    @Step
    public void firstCardIsColivingAdv() {

        $$(byXpath("//div[@class='cards-container']/div")).first().waitUntil(visible, 25000).shouldHave(text("Select,"));
        $(By.xpath("//a[contains(text(), 'View all Select providers ')]")).click();
        $(By.xpath("//h2[contains(text(), 'Stunning homes, ')]")).exists();

    }
    @Step
    public void colivingButton() {

        $(By.xpath("//a[contains(., 'View all Select providers ')]")).click();
        $(By.xpath("//h1[contains(text(), 'Select')]")).exists();
    }
    public void colivingButtonOnFirstPage(final String text) {
        $(By.xpath("//a[contains(., '" + text + "')]")).exists();
    }
    @Step
    public void moveToPage(int pageNumberInd, String pageNumber) {
        sleep(1000);
        $$("div ul.pagination li a").findBy(text(pageNumber)).click();
        sleep(1000);
        $("ul.pagination li").waitUntil(visible, 5000);
        $$("ul.pagination li").get(pageNumberInd).shouldHave(cssClass("active"));
        sleep(1000);

    }
    @Step
    public void moveToFirstPage1(String page) {
        $$("div ul li a").findBy(exactText(page)).click();
        /*JavascriptExecutor jse;
        jse = (JavascriptExecutor)getWebDriver();
        jse.executeScript("document.getElementById('oauth-auth-forgot-link').click();");*/
    }
    @Step
    public void moveToNext(int pageActiveInd) {
        sleep(2000);
        $(By.xpath("//a[contains(text(), 'Next')]")).click();
        sleep(2000);
        $$("ul.pagination li").get(pageActiveInd).shouldHave(cssClass("active"));
    }
    @Step
    public void moveToPrevious(int pageActiveInd) {
        sleep(2000);
        $(By.xpath("//a[contains(text(), 'Previous')]")).click();
        sleep(2000);
        $$("ul.pagination li").get(pageActiveInd).shouldHave(cssClass("active"));
    }
    @Step
    public void shouldHaveResultText (int pageActiveInd, String text) {
        $(By.xpath("//a[contains(text(), 'Previous')]")).click();
        $$("ul.pagination li").get(pageActiveInd-1).shouldHave(text(text));
    }
    @Step
    public void clickAvailablePlus(String rooms) {
        //$(By.xpath("//div[contains(text(), 'Available bedrooms')]/..//button[@data-type='plus']")).click();

        $(By.xpath("//div[@class='bedrooms-filter ']")).click();
        $(By.xpath("//div[@class='form-group']/label[contains(.,'Rooms available in property')]/../select")).selectOptionContainingText(rooms);

        clickApply();
        //$(By.xpath("//button[contains(text(), 'Rooms number: 2 ')]")).click();
        //$(By.xpath("(//button[@class='btn btn-xs btn-gray'])[4]")).shouldHave(text(text));

    }
    @Step
    public void cardsFilterVerification(int number, String text) {
        ElementsCollection rooms1 = $$(byXpath("//div[@class='text-13 u_p10']"));

        //$$(byXpath("//div[@class='col-xs-6 u_p0-right text-13 u_ea-right']")).shouldHaveSize(number).shouldHave(CollectionCondition.texts(text));
        rooms1.shouldHaveSize(number);
        rooms1.filterBy(textCaseSensitive(text)).shouldHaveSize(0);

    }

    @Step
    public void clickApplyFilters() {
        $(By.xpath("//button[@class='btn btn-sm btn-primary js-submitLogin']")).click();
    }
    @Step
    public void selectRadius(String radius) {

        SelenideElement radius1 = $(byXpath("//div[@class='radius-select-holder']"));
        radius1.click();
        $(byXpath("//div[@class='radius-select-holder']/select")).selectOptionContainingText(radius);
        sleep(3000);
        radius1.click();


    }
    @Step
    public static void activeBudget() {

        $(byXpath("//div[@class='price-range-filter ']")).click();
        $(byXpath("//div[@class='noUi-handle noUi-handle-lower']")).dragAndDropTo($(byXpath("//span[contains(.,'Clear')]")));
        $(byXpath("//div[@class='noUi-handle noUi-handle-upper']")).dragAndDropTo($(byXpath("//span[contains(.,'Apply')]")));
        clickApply();
    }
    @Step
    public void activeAvailable() {
        $(byXpath("//div[@class='available-from-filter ']")).click();
        $(byXpath("//button[@class='react-calendar__navigation__arrow react-calendar__navigation__next-button']")).click();
        $(byXpath("//label[@for='react-calendar-check']")).click();
        clickApply();
    }
    @Step
    public void activateRooms(String roomsAvailable, String roomsTotal) {
        SelenideElement selectAvailRoom = $(byXpath("//label[contains(.,'Rooms available in property')]/..//select[@class='form-control']"));
        SelenideElement selectTotalRoom = $(byXpath("//label[contains(.,'Total rooms in property')]/..//select[@class='form-control']"));

        $(byXpath("//div[@class='bedrooms-filter ']")).click();
        selectAvailRoom.click();
        selectAvailRoom.selectOptionContainingText(roomsAvailable);
        selectTotalRoom.click();
        selectTotalRoom.selectOptionContainingText(roomsTotal);
        clickApply();
    }
    @Step
    public void activateIdealFM(String gender1, String suitableFor, final int fiterNumberIs) {
        activateIdealFM(fiterNumberIs);
        filterOptionClick(gender1);
        filterOptionClick(suitableFor);
        $(byXpath("//div[@class='noUi-handle noUi-handle-lower']")).dragAndDropTo($(byXpath("//span[contains(.,'"+suitableFor+"')]/../../../../div/label")));
        $(byXpath("//div[@class='noUi-handle noUi-handle-upper']")).dragAndDropTo($(byXpath("//span[contains(.,'Professionals and/or Students')]")));
        clickApply();
    }
    @Step
    public void activateIdealFM( final int fiterNumberIs) {
        clickIdealFMFilterActiveInactive();
        $$(By.xpath("//div[@class='circle-btn-group']/label")).shouldHaveSize(fiterNumberIs);

    }
    @Step
    public void clickMoreFilterVerify(String filter, int numberAboutFilters, String leaseLengthSelected, String addedTime) {
        SelenideElement lengthOfStay = $(By.xpath("//div[starts-with(@class, 'search-panel__more-cell')]//div[starts-with(@class, 'lease-length-filter')]//select[@class='form-control']"));
        SelenideElement propertyAdded = $(By.xpath("//div[starts-with(@class, 'search-panel__more-cell')]//div[starts-with(@class, 'property-added-filter')]//select[@class='form-control']"));
        moreFilterClick();
        filterOptionClick(filter);
        $$(By.xpath("//div[starts-with(@class,'search-panel__more-cell')]//label[@class='circle-button-with-text  ']/span")).shouldHaveSize(numberAboutFilters);
        $(byXpath("//label[@class='circle-button-with-text  active' and contains(.,'"+filter+"')]")).exists();
        lengthOfStay.click();
        lengthOfStay.selectOptionContainingText(leaseLengthSelected);
        propertyAdded.click();
        propertyAdded.selectOptionContainingText(addedTime);
        clickApply();
    }
    @Step
    public void filterOptionClick(String filter) {
        $(By.xpath("//label[contains(.,'"+ filter +"')]")).click();
    }

    @Step
    public void clickMyIdealFM_FilterTypeUserVerify(int numberTypes) {
        //FilterIdealClick();
        clickIdealFMFilterActiveInactive();
        //active filter
        String userTypeActive = "//div[contains(@class,'search-panel')]//label[@class='circle-button-with-text active']";
        //collection of active filter
        ElementsCollection userTypeIcon = $$(byXpath(userTypeActive));
        //number of active filter
        userTypeIcon.shouldHaveSize(numberTypes);
        //which filter is active by number
        //if($(byXpath(userTypeActive)).exists()){userTypeIcon.get(indexOfActiveFilter).isEnabled();}

    }
    @Step
    public void closePopupSignup() {

        sleep(4000);
        SelenideElement close1 = $(byXpath("//div[@id='signupNeedspaceModal']//button[@class='btn btn-sm close u_m15' and @aria-label='Close']"));

        if(close1.isDisplayed()){
            close1.click();}
    }
    @Step
    public void priceFilter() {
        $(byXpath("//div[@class='price-range-filter ']")).click();
    }
    @Step
    public void priceFilterActive() {
        $(byXpath("//div[@class='container']//span[@class='active-filters-count']")).click();
    }
    @Step
    public static void clearFilter() {
        sleep(2000);
        $(byXpath("//span[contains(.,'Clear')]")).click();

    }
    @Step
    public void clickSearchPropPage(String location) {

        SelenideElement searchField = $(byXpath("//div[@class='search-location-form']//input"));
        //SelenideElement searchElastic = $(byXpath("//span[contains(.,'"+location1+"')]"));

        if(field_searchBar_listing.exists()){
            field_searchBar_listing.click();

        }
        sleep(3000);
        searchField.click();

        for (char  c : location.toCharArray()) {
            sleep(500);
            String s = String.valueOf(c);
            searchField.sendKeys(s);

        }

        searchField.pressEnter();


    }
    @Step
    public void clearSearch() {
        $(byXpath("//form//span[@class='clear-location ']")).click();
        sleep(3000);

    }
    @Step
    public void cardUserClick() {
        $(byXpath("//div[@class='card-profile-text']/span[@class='card-top-username']")).click();

    }
    @Step
    public static void clickApply() {
        $(byXpath("//span[contains(.,'Apply')]")).click();

    }



    @FindBy(xpath = "//span[contains(.,'Apply')]")
    private WebElement loginButton;

    @Step
    public SearchHelper setClickApply1() {
        $(loginButton).click();
        return this;
    }
    @Step
    public void verifyClearMoreFilter(String activeFilter) {
        $(By.xpath("//div[@class='more-filters selected']")).click();
        $(By.xpath("//label[@class='circle-button-with-text  active']/span")).shouldHave(text(activeFilter));
        clearFilter();
        moreFilterClick();
        $(By.xpath("//label[@class='circle-button-with-text  ']/span[contains(.,'"+activeFilter+"')]")).should(exist);

    }


    @Step
    public static int activeFiltersNumber() {
        int activeFiltersNumber = $$(By.xpath("//div[@class='search-panel hidden-xs']//span[@class='active-filters-count']")).size();
        return activeFiltersNumber;
    }
    @Step
    public void numberOfActiveFilters(int size) {
        $$(By.xpath("//div[@class='container']//span[contains(@class,'active-filters-count')]")).shouldHaveSize(size);

    }
    @Step
    public void activeFiltersIs(String activeFilterAre) {
        $(By.xpath("//label[contains(@class,' active')]")).shouldHave(text(activeFilterAre));

    }


    @Step
    public void verifSearchHasNoLocation(String location) {
        sleep(3000);
        $(byXpath("//h1[@class='h4' and contains(.,'"+location+"')]")).shouldNotBe(visible);
    }
    @Step
    public void verifSearchHasLocation(String location) {

        $("form input.react-autosuggest__input").waitUntil(visible, 15000).shouldHave(value(location));
    }

    @Step
    public void clearActiveFiters() {
        $(byXpath("//div[@class='price-range-filter selected']")).click();
        clearFilter();
        $(byXpath("//div[@class='available-from-filter selected']")).click();
        clearFilter();
        $(byXpath("//div[@class='bedrooms-filter selected']")).click();
        clearFilter();
        clickIdealFMFilterActiveInactive();
        clearFilter();
    }
    @Step
    public void checkSort(String value) {

        List<String> sortDef1 = getFMcardSearchText();
        propertySortBy(value);
        sleep(4000);
        List<String> sortNew1 = getFMcardSearchText();
        Assert.assertNotEquals(sortNew1, sortDef1);
    }
    @Step
    public void checkHighPriceSort(String option) {
        sleep(5000);

        List<String> sortDef2 = getFMcardSearchText();
        $(sortProperty).click();
        $(sortProperty).selectOptionByValue(option);
        sleep(3000);
        List<String> sortNew2 = getFMcardSearchText();
        Assert.assertNotEquals(sortNew2, sortDef2);
        sleep(3000);
    }
    @Step
    public void clearLocation() {
        field_searchBar_listing.click();
    }
    @Step
    public void moreFilterClick() {
        $(By.xpath("//div[contains(@class,'more-filters ')]")).click();
    }

    @Step
    public static List<String> cardsUserTypeAgent() {

        List<String> cardsUserType = Arrays.asList("We are a representing agency", "We are a representing agency",
                "We are a representing agency", "We are a representing agency", "We are a representing agency",
                "We are a representing agency", "We are a representing agency", "We are a representing agency",
                "We are a representing agency", "We are a representing agency", "We are a representing agency");
        return cardsUserType;
    }
    @Step
    public static List<String> cardsUserTypeFlatmate() {

        List<String> cardsUserType = Arrays.asList("I live in the property", "I live in the property","I live in the property",
                "I live in the property","I live in the property","I live in the property",
                "I live in the property","I live in the property","I live in the property",
                "I live in the property","I live in the property");
        return cardsUserType;


    }
    @Step
    public static List<String> cardsUserTypeLive_in() {
        List<String> cardsUserType = Arrays.asList("I own and live in the property", "I own and live in the property","I own and live in the property",
                "I own and live in the property","I own and live in the property","I own and live in the property",
                "I own and live in the property","I own and live in the property","I own and live in the property",
                "I own and live in the property","I own and live in the property");
        return cardsUserType;
    }
    @Step
    public static List<String> cardsUserTypeLive_out() {
        List<String> cardsUserType = Arrays.asList("I own the property, but donʼt live here", "I own the property, but donʼt live here",
                "I own the property, but donʼt live here", "I own the property, but donʼt live here","I own the property, but donʼt live here",
                "I own the property, but donʼt live here", "I own the property, but donʼt live here","I own the property, but donʼt live here",
                "I own the property, but donʼt live here", "I own the property, but donʼt live here","I own the property, but donʼt live here");
        return cardsUserType;

    }
    @Step
    public static List<String> cardsUserTypeSelect() {
        List<String> cardsUserType = Arrays.asList("Select provider", "Select provider",  "Select provider", "Select provider",
                "Select provider", "Select provider", "Select provider", "Select provider", "Select provider",
                "Select provider","Select provider");
        return cardsUserType;

    }
    @Step
    public static List<String> cardsUserTypeSelectLabel() {
        List<String> cardsUserType = Arrays.asList("SELECT", "SELECT",  "SELECT", "SELECT","SELECT", "SELECT",
                "SELECT", "SELECT", "SELECT", "SELECT","SELECT");
        return cardsUserType;

    }
    @Step
    public static List<String> cardsUserTypeAll() {
        List<String> cardsUserType = Arrays.asList("I own the property, but donʼt live here", "We are a representing agency", "Select provider");
        return cardsUserType;

    }
    @Step
    public void startBuddyUpSearch(final String location, final String inDrop, final String radius,
                                   final String locationCardIs, final String indexOfCard) {
        searchPropertyBySelectfromList(location, inDrop);
        closePopupSignup();
        selectRadius(radius);
        verificationSearchPropertyMes(locationCardIs, indexOfCard);
    }
    @Step
    public void startNewBuddyUpSearch(final String location, final String inDrop, final String radius) {
        searchPropertyBySelectfromList(location, inDrop);
        closePopupSignup();
        selectRadius(radius);
        //verificationSearchPropertyMes(locationCardIs, indexOfCard);
    }
    @Step
    public void startBuddyUpSearch1(final String location, final String inDrop, final String radius,
                                    final String locationCardIs, final String idProperty) {
        searchPropertyBySelectfromList(location, inDrop);
        closePopupSignup();
        selectRadius(radius);
        verificationSearchPropertyMesLive(locationCardIs, idProperty);
    }

    @Step
    public void clickIdealFMFilterActiveInactive() {
        sleep(1000);
        if ($(By.xpath("//div[@class='ideal-flatmate-filter selected']")).exists()){
            $(By.xpath("//div[@class='ideal-flatmate-filter selected']")).click();
        } else $(By.xpath("//div[@class='ideal-flatmate-filter ']")).click();

    }
    @Step
    public static void getNumberOfListingFoundwq() {
        String number = ($(byXpath("//h2[@class='text-14']")).text().substring(0, 12).replaceAll("[^0-9]", ""));


        if ("".equals(number)) {
            System.out.println("Вы ввели число 1");

        } else if ("d".equals(number)) {
            System.out.println("Вы ввели число 2");

        } else if ("df".equals(number)) {
            System.out.println("Вы ввели число 3");

        } else if ("dsf".equals(number)) {
            System.out.println("Вы ввели число 4");

        } else {
            System.out.println("Вы ввели неправильное число");
        }


    }

    @Step
    public static void getImage1() {
        $$(byXpath("//div[@class='card-img with-overlay']")).findBy(cssClass("card-img--label-holder text-12 text-uppercase text-right")).getSize();
        $$(byXpath("//div[@class='card-img with-overlay']")).findBy(cssClass("card-img--label-holder text-12 text-uppercase text-right")).text();
        $$(byXpath("//div[@class='card-img with-overlay']")).get(0);
        $$(byXpath("//div[@class='card-img with-overlay']")).findBy(cssClass("card-img--label-holder text-12 text-uppercase text-right")).getSize();
        //System.out.println("cardProp_Image = " + cardProp_Image1);

    }

    @Step
    public List<String> getCardTexts(){


        List<String> elements = $$(byXpath("//div[@class='card-img with-overlay']")).texts();
        Assert.assertEquals((elements), (elements));
        return elements;

        //$$("#list li").filterBy(cssClass("enabled")).findBy(exactText("foo")).find(".remove").click();
        //$$(byXpath("")).filterBy((cssClass(""))).findBy(exactText("")).find("").click();

    }
}

