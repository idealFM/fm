package uk.co.idealflatmate.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static uk.co.idealflatmate.appmanager.HelperBase.cardsOnThePage;
import static uk.co.idealflatmate.appmanager.HelperBase.closeListRenewPopUp;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class SearchFMPageTests extends TestBase{
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
        refresh();
        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();
    }

    @AfterMethod

    public void afterMethod() {
        helperBase.toHomePage();
    }


    @Test
    public void fmSearchBy() {

        cardsOnThePage().shouldHaveSize(12);
        matchingHelper.closeTakeMatch();
        searchHelperFM.verifyMoreFilterActive();
        //searchHelperFM.verifyClearMoreFilter("");
        helperBase.toHomePage();

    }

    @Test
    public void searchPagination() {

        searchHelper.moveToPage(2, "2");
        cardsOnThePage().shouldHaveSize(12);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToPage(3, "3");
        cardsOnThePage().shouldHaveSize(12);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToNext(4);
        cardsOnThePage().shouldHaveSize(12);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToPrevious(3);
        cardsOnThePage().shouldHaveSize(12);

    }


    @Test
    public void applyMoreFilters() {


        searchHelper.numberOfActiveFilters(1);
        searchHelperFM.clickMoreFilterVerify("Looking for a room", "Has a room");
        searchHelper.numberOfActiveFilters(1);

    }

    @Test
    public void applyMoreFiltersPhotoNoList() {

        searchHelper.numberOfActiveFilters(1);
        searchHelperFM.clickMoreFilterVerifyPhotoListing("Looking for a room", "Has a room");
        searchHelper.numberOfActiveFilters(1);

    }

    @Test
    public void applyMoreFiltersPhotoWithList() {

        searchHelper.numberOfActiveFilters(1);
        searchHelperFM.clickMoreFilterVerifyPhotoNoListing("Looking for a room");
        searchHelper.numberOfActiveFilters(1);

    }

    @Test
    public void applyAdvancedFiltersDefault() {

        searchHelper.checkHighPriceSort("7");
        //searchHelper.checkHighPriceSort1("7");
        searchHelperFM.verifSearchHasNoLocationFM("London");
        searchHelper.clickSearchPropPage("London");
        searchHelperFM.verifSearchHasLocationFM("London");
        searchHelper.selectRadius("+10 km");

        searchHelperFM.activeOccupationFM("Student");
        searchHelper.activeBudget();
        searchHelperFM.activeGender("Male");
        searchHelperFM.activeAgeFM();
        searchHelper.activeAvailable();
        searchHelper.numberOfActiveFilters(6);

    }

    @Test
    public void sortListingLoggedIn() {

        authorizationHelper.login("passwUniv", "MatchingSort");
        //closeListRenewPopUp();

        searchHelper.checkSort("Price high to low");//Price high to low
        searchHelper.checkSort("Most recent");//Most recen
        searchHelper.checkSort("Price low to high");//Price low to high
        searchHelper.checkSort("Top Matched");//Top Matched

        authorizationHelper.logoutFromApp();


    }

}
