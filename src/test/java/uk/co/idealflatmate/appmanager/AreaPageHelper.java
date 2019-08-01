package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AreaPageHelper extends HelperBase {
    public static String colivingCards() {
        String colivingCards = "//div[@id='coliving']//div[@class='card-body clearfix']";
        return colivingCards;
    }
    public static String areaNameInCarousel() {
        String areaNameOnCard = "//div[@class='card-btr-amenities text-white']/div";
        return areaNameOnCard;
    }



    SelenideElement sortOption = $(byXpath("//select[@id='property-sort']/option[1]"));

    static SelenideElement container = $(byXpath("//div[@class='container text-center u_p20-xs u_p40-sm text-shadow u_ep-relative']"));
    @Step
    public void clickArea(int number_of_area) {
        $(byXpath("//div[@class='homepage-quiz-container']/h2")).waitUntil(appears, 10000);
        $$("div.card-btr-amenities.text-white").get(number_of_area).click();


    }
    @Step
    public void clickHeaderItem(String select1, final String select2, final String area) {


        //switchTo().window(1);


        $(byXpath("//a[@href='#top']")).click();
        $(byXpath("//h2[contains(text(), 'Overview')]")).shouldBe(visible);
        sleep(1000);

        container.scrollIntoView(true).$(byXpath("//a[@href='#" + select1 + "']")).click();
        $(byXpath("//h2[contains(text(), 'Top Spots')]")).shouldBe(visible);
        sleep(1000);
        container.scrollIntoView(true).$(byXpath("//a[@href='/spare-room/london/south/clapham/rooms']")).click();
        $(byXpath("//h1[starts-with(@class,'splash-title')]")).shouldHave(text("Rooms for rent in " + area));
        navigator.back();
        sleep(1000);

        container.scrollIntoView(true).$(byXpath("//a[@href='/spare-room/london/south/clapham/flatmates']")).click();
        $(byXpath("//h1[starts-with(@class,'splash-title')]")).shouldHave(text("Flatmates in " + area));
        navigator.back();
        sleep(1000);

        container.scrollIntoView(true).$(byXpath("//a[@href='#" + select2 + "']")).click();
        $(byXpath("//div[@class='scrollspy clearfix scrollspy-horizontal']")).shouldBe(visible);

    }
    @Step
    public void clickBlockColiving() {


        //switchTo().window(1);

        container.scrollIntoView(true).$(byXpath("//h2[@class='u_m0']")).click();

    }
    @Step
    public void checklinkMap() {
        //switchTo().window(1);
        switchTo().frame(0);
        $(byXpath("//a[contains(text(), 'View larger map')]")).waitUntil(appears, 10000).click();
        switchTo().window(1);
        sleep(1000);
        $(byXpath("//link[@title='Google Maps']")).shouldBe(exist);
    }
    @Step
    public void clicklinkNearbyAreas() {
        //switchTo().window(1);
        sleep(3000);
        $(byXpath("//a[contains(text(), 'Click to search nearby areas')]")).waitUntil(exist, 5000).click();
        sleep(3000);

    }
    @Step
    public static int numberOfPropAreaPage() {

       int numberOfPropAreaPage = Integer.parseInt($(byXpath("//div[@class='col-sm-5 col-md-4']//span[@class='u_ed-block text-11']")).text().
               replaceAll("[^0-9]", ""));
       return numberOfPropAreaPage;

    }
    @Step
    public static String textOfPropAreaPage() {

        String textOfPropAreaPage = $(byXpath("//h2[@class='text-14']")).text().
                replaceAll("[0-9]", "");
        return textOfPropAreaPage;

    }
    @Step
    public void checklinkNearbyAreas(String area1, final String mapState) {
        //closeAdvPopUp();
        $(byXpath("//span[@class='map-toggle-button open-map-button']")).shouldHave(text(mapState));


    }


    @Step
    public void checkLinkSeeMoreRooms(String area1) {

        closeAdvPopUp();
        mapAreaPageCheck();

        String areaNameOnPageH1 = $(byXpath("//h1[@class='splash-title text-white text-center u_m0-top']")).text();
        String area2 = (areaNameOnPageH1.substring(0, 17) + " " + area1);
        Assert.assertEquals(areaNameOnPageH1, area2);

        //String sample = String.valueOf($(byXpath("//h2[@class='text-14']")).text().split("[^0-9]"));
        //System.out.println(sample);
        //$(byXpath("//h2[@class='text-14']")).text().replace(, );
        Assert.assertEquals(textOfPropAreaPage(), " rooms to rent available");

        //String areaNameOnPageH2 = $(byXpath("//h1[@class='h4']")).text();
        //String area3 = (areaNameOnPageH2.substring(0, 24) + " " + area1);
        //Assert.assertEquals(areaNameOnPageH2, area3);


    }
    @Step
    public void mapAreaPageCheck() {
        sleep(2000);
        SelenideElement openMap = $(byXpath("//span[@class='map-toggle-button open-map-button']"));
        SelenideElement hideMap = $(byXpath("//span[@class='map-toggle-button close-map-button']"));

        openMap.click();
        sleep(2000);
        hideMap.shouldHave(text("Hide map"));
        sleep(2000);
        hideMap.click();
        sleep(2000);
        openMap.shouldHave(text("Display map"));
    }
    @Step
    public void checklinkFH(String area1) {
        //switchTo().window(1);
        closeAdvPopUp();
        container.scrollIntoView(true).$(byXpath("//h2[contains(text(), 'Flathunters')]")).click();
        sleep(2000);

        $(byXpath("//a[contains(text(), 'See more flathunters')]")).waitUntil(exist, 5000).click();

        String areaNameOnPageH1 = $(byXpath("//h1")).text();
        String area2 = (areaNameOnPageH1.substring(0, 12) + " " + area1);
        Assert.assertEquals(areaNameOnPageH1, area2);

        $(byXpath("//div[@class='search-panel hidden-xs']//input")).shouldHave(value(area1));

        $(byXpath("//h1[@class='h4']")).shouldHave(text("Find Flatmates"));
    }
    @Step
    public void checklinkAreaslinkFooter() {
        $(byXpath("(//div[@class='card-btr-amenities text-white'])[1]')]")).waitUntil(exist, 5000).click();
        switchTo().window(1);
        $(byXpath("//h1[@class='splash-title text-white text-center u_m0-top']")).shouldHave(text("Stratford"));

    }
    @Step
    public void checkAreaName(String area1) {
        //String areaNameOnPageH1 = $("h1.splash-title.text-white.text-center.u_m0-top").text();
        //switchTo().window(1);
        String areaNameOnPageH1 = $(byXpath("//h1")).text();
        String area2 = (areaNameOnPageH1.substring(0, 9) + " " + area1);
        Assert.assertEquals(areaNameOnPageH1, area2);
    }
    @Step
    public void numberPropertiesUnderSearchEqualsCards() {

        String areaNameOnPageH1 = $(byXpath("//h2[@class='text-14']")).text().replaceAll("[^0-9]", "");
        //int Properties = Integer.valueOf((areaNameOnPageH1.substring(5, 6)));
        int Properties = Integer.valueOf((areaNameOnPageH1));
        //int PropertiesCard = $$(byXpath("//div[@class='cards-container']/div[@id]")).size();
        int propertiesCard = cardsOnThePage().size();
        Assert.assertEquals(Properties, propertiesCard);


    }
    @Step
    public void clickMoreRooms() {
        //switchTo().window(1);

        container.scrollIntoView(true).$(byXpath("//h2[contains(text(), 'Available rooms')]")).click();
        //$(byXpath("//h2[contains(text(), 'Available rooms')]")).click();
        sleep(3000);

        $(byXpath("(//a[@class='btn btn-primary'])[1]")).click();
    }
    @Step
    public void checkSortDropDownFM() {
        checkSortDropDownRoom("5", "Top Matched");

    }
    @Step
    public void checkSortDropDownRoom(final String expectedValue, final String defaultText) {
        closeAdvPopUp();
        sortOption.shouldHave(value(expectedValue));
        sortOption.shouldHave(text(defaultText));
    }
    @Step
    public void pagination(final Condition condition) {
        $(byXpath("//ul[@class='pagination']/li/a[@class='btn pagination-button pagination-button--prev btn-lg']")).should(condition);

    }
    @Step
    public void checkArrowsBrowsAll(final String tab1click, final String tab2click, final String linkClick) {
        SelenideElement arrow = $(byXpath("//div[@class='owl-carousel item-carousel js-carousel owl-theme owl-loaded']//button[@role='presentation' and @class='owl-next']"));

        //switchTo().window(1);
        $(byXpath("//a[contains(.,'" + tab2click + "')]")).click();

        sleep(2000);
        //scrollDownPageOn("400");
        do {
                arrow.click();
                sleep(1000);
        }while (!$(byXpath("//div/a[contains(.,'" + linkClick + "')]")).isDisplayed());

        $(byXpath("//div/a[contains(.,'" + linkClick + "')]")).click();
    }


    @Step
    public void checkAllAreas(String City) {
        $$(byXpath("//h2")).shouldHaveSize(6);
        $(byXpath("//div/p[contains(.,'Payment methods we accept:')]")).click();
        //$$(byXpath("//div[@class='page-heading u_nob']//button[@class='area-card--button text-bold']")).shouldHaveSize(6);
        $(byXpath("//div[@class='area-region u_m50-bottom']//button[@class='area-card--button text-bold']")).click();
        $(byXpath("//a[contains(.,'"+City+"')]")).click();
        //switchTo().window(2);

        closeAdvPopUp();

        $(byXpath("//div[@class='search-panel hidden-xs']//input")).shouldHave(value(City));
        $$(byXpath("//a[@class='buddy-star u_ed-inline-block float-right u_m15-right u_m10-top text-26 ']")).shouldHaveSize(11);
    }
    @Step
    public void checkRestAreas(final String text, final String area) {
        $(byXpath("//h1")).shouldHave(text(text));

        $(byXpath("//a[contains(.,'" + area + "')]")).click();
        //switchTo().window(2);
        closeAdvPopUp();
        if($(byXpath("//div[@class='search-panel hidden-xs']//input")).exists()){
            $(byXpath("//div[@class='search-panel hidden-xs']//input")).shouldHave(value(area));
        }

    }
    @Step
    public void areaScroll() {
        scrollDownPageOn("2300");
        $(byXpath("//h2[contains(.,'Explore cities and areas across the UK')]")).waitUntil(visible, 5000);
        $(byXpath("//section[@id='press-logos']")).waitUntil(visible, 5000);

    }
    @Step
    public void h1_HeaderTextIsExist(final String text) {
        $(byXpath("//h1[contains(.,'" + text + "')]")).exists();
    }


}
