package uk.co.idealflatmate.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.refresh;
import static uk.co.idealflatmate.appmanager.AreaPageHelper.areaNameInCarousel;
import static uk.co.idealflatmate.appmanager.AreaPageHelper.numberOfPropAreaPage;
import static uk.co.idealflatmate.appmanager.HelperBase.*;
import static uk.co.idealflatmate.appmanager.SearchHelper.field_searchBar_listing;

//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;


public class AreaPageTests extends TestBase {

    @BeforeMethod
    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearBrowserCookies();
        refresh();

    }

    @Features("Area")
    @Stories("homepage")
    @Test
    public void firstFeaturedAreasHomePageHeader() {
        areaPageHelper.areaScroll();
        String area1 = collectionReturn(areaNameInCarousel()).get(2).text();
        areaPageHelper.clickArea(1);
        areaPageHelper.checkAreaName(area1);
        areaPageHelper.clickHeaderItem("top-spots",  "explore", area1);

    }
    @Features("Area")
    @Stories("coliving")
    @Test
    public void firstFeaturedAreas_Coliving_HomePageHeader() {
        areaPageHelper.areaScroll();
        String area1 = collectionReturn(areaNameInCarousel()).get(4).text();
        areaPageHelper.clickArea(2);
        areaPageHelper.checkAreaName(area1);
        areaPageHelper.clickBlockColiving();
        int amountPropOnAreaPage = numberOfPropAreaPage();
        clickButton("See more coliving properties", "a");
        //switchTo().window(1);
        closeAdvPopUp();
        areaPageHelper.h1_HeaderTextIsExist("Co living in Barnet Gate");
        int NumberColiving1Cards = cardsOnThePage().size();
        Assert.assertEquals(getCardUserSelectLabelNumber(), NumberColiving1Cards);
        Assert.assertEquals(amountPropOnAreaPage, NumberColiving1Cards);


    }

    @Features("Area")
    @Stories("map")
    @Test
    public void firstFeaturedLinkArea() {
        areaPageHelper.areaScroll();
        String areaName = collectionReturn(areaNameInCarousel()).get(2).text();
        areaPageHelper.clickArea(1);
        //switchTo().window(1);
        int amountPropOnAreaPage = numberOfPropAreaPage();

        areaPageHelper.clicklinkNearbyAreas();
        closeAdvPopUp();
        Assert.assertTrue(cardsOnThePage().size() >= amountPropOnAreaPage);
        areaPageHelper.checklinkNearbyAreas(areaName, "Display map");//it is the same area
        String areaNameInput = selenidElement(field_searchBar_listing).getValue();

        Assert.assertEquals(areaNameInput, areaName);
        areaPageHelper.checkSortDropDownRoom("0", "Default");
        areaPageHelper.pagination(exist);

    }
    @Features("Area")
    @Stories("map")
    @Test
    public void firstFeaturedLinkMap() {
        Reporter.log("Application started");
        areaPageHelper.areaScroll();
        areaPageHelper.clickArea(1);
        areaPageHelper.checklinkMap();

    }
    @Features("Area")
    @Stories("homepage")
    @Test
    public void seeMoreRooms() {
        areaPageHelper.areaScroll();
        String area1 = collectionReturn(areaNameInCarousel()).get(4).text();
        areaPageHelper.clickArea(2);
        areaPageHelper.clickMoreRooms();
        closeAdvPopUp();
        areaPageHelper.checkLinkSeeMoreRooms(area1);
        areaPageHelper.numberPropertiesUnderSearchEqualsCards();
        areaPageHelper.checkSortDropDownRoom("0", "Default");
        areaPageHelper.pagination(exist);

    }
    @Features("Area")
    @Stories("homepage")
    @Test
    public void linkFH() {
        areaPageHelper.areaScroll();
        String area1 = collectionReturn(areaNameInCarousel()).get(2).text();
        areaPageHelper.clickArea(1);

        areaPageHelper.checklinkFH(area1);
        areaPageHelper.checkSortDropDownFM();
        areaPageHelper.pagination(exist);

    }

    @Features("Area")
    @Stories("coliving")
    @Test
    public void exploreMoreArea() {
        areaPageHelper.areaScroll();
        areaPageHelper.clickArea(1);
        areaPageHelper.checkArrowsBrowsAll("Coliving", "Explore", "Browse all areas");
        areaPageHelper.checkRestAreas("Rest of the UK", "Brixham");

    }
    @Features("Area")
    @Stories("homepage")
    @Test
    public void exploreMoreAreaCity() {
        areaPageHelper.areaScroll();
        areaPageHelper.clickArea(1);
        areaPageHelper.checkArrowsBrowsAll("Coliving", "Explore", " more areas");
        //switchTo().window(2);
        areaPageHelper.checkRestAreas("Browse all cities", "London");

    }
}
