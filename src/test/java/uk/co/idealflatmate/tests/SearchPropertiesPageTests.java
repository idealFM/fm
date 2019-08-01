package uk.co.idealflatmate.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;
import static uk.co.idealflatmate.appmanager.HelperBase.cardsOnThePage;
import static uk.co.idealflatmate.appmanager.HelperBase.getCardUserSelectLabel;
import static uk.co.idealflatmate.appmanager.HelperBase.getCardUserType;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.SearchHelper.*;

//import static org.seleniumhq.jetty7.util.LazyList.getList;
//import static uk.co.idealflatmate.appmanager.TespageUrlVerifLiveGoStage;

public class SearchPropertiesPageTests extends TestBase{
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
        refresh();
        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
    }

    @Test
    public void propertySearchByDropDown() {
        searchHelper.closePopupSignup();
        cardsOnThePage().shouldHaveSize(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.firstCardIsColivingAdv();
        helperBase.toHomePage();
    }

    @Test
    public void searchPagination() {


        searchHelper.moveToPage(2, "2");
        cardsOnThePage().shouldHaveSize(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToPage(3, "3");
        cardsOnThePage().shouldHaveSize(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToNext(4);
        cardsOnThePage().shouldHaveSize(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToPrevious(3);
        cardsOnThePage().shouldHaveSize(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.colivingButton();
        helperBase.toHomePage();
    }

    @Test
    public void searchZone1Pagination() {

        searchHelper.zone1();
        searchHelper.colivingButton();
        helperBase.toHomePage();
    }

    @Test
    public void searchEastLDNPagination() {

        searchHelper.EastLDN1();
        searchHelper.firstCardIsColivingAdv();
        helperBase.toHomePage();
    }

    @Test
    public void applyMoreFilters() {

        searchHelper.activeFiltersNumber();

        searchHelper.clickMoreFilterVerify("Garden", 15, "1 month", "1 week ago");

        searchHelper.numberOfActiveFilters(2);
        searchHelper.verifyClearMoreFilter("Garden");
        Assert.assertEquals(1, activeFiltersNumber());
        helperBase.toHomePage();
    }
    @Test
    public void applyAdvancedFiltersDefault() {

        searchHelper.checkHighPriceSort("3");
        searchHelper.verifSearchHasNoLocation("London");
        searchHelper.clickSearchPropPage("London");
        searchHelper.verifSearchHasLocation("London");
        searchHelper.selectRadius("+20 km");

        Assert.assertEquals(1, activeFiltersNumber());

        searchHelper.activeBudget();
        searchHelper.checkSort("Top matched");

        searchHelper.activeAvailable();
        searchHelper.checkSort("Most recent");

        searchHelper.activateRooms("Studio","1 room");
        searchHelper.activateIdealFM("Male", "Student", 11);
        searchHelper.numberOfActiveFilters(4);

        searchHelper.clearActiveFiters();
        searchHelper.activeFiltersNumber();

        helperBase.toHomePage();
    }

    @Test
    void sortListing() {

        searchHelper.checkSort("Price low to high");
        searchHelper.checkSort("Default");
        searchHelper.checkSort("Most recent");
        searchHelper.checkSort("Price high to low");
        searchHelper.checkSort("Top matched");

        helperBase.toHomePage();
    }

    @Test
    public void sortListingWith2Rooms() {

        searchHelper.clickAvailablePlus("2 rooms to rent");
        // No "1 rooms available" after sorting
        searchHelper.cardsFilterVerification(11, "\n" + "1 room available\n" + " ");
        helperBase.toHomePage();
    }

    @Test
    public void sortListingByUserType() {

        searchHelper.activateIdealFM(11);

        searchHelper.filterOptionClick("Flatmates");
        searchHelper.filterOptionClick("Live-in landlords");
        searchHelper.filterOptionClick("Live-out landlords");
        searchHelper.filterOptionClick("Select");

        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Agencies");
        clickApply();
        //searchHelper.setClickApply1();
        sleep(2000);
        Assert.assertEquals(getCardUserType(), cardsUserTypeAgent());

        searchHelper.clickMyIdealFM_FilterTypeUserVerify(1);
                    //.setClickApply1();
        searchHelper.numberOfActiveFilters(1);

        searchHelper.activeFiltersIs("Agencies");
        //deactivate previous filter
        searchHelper.filterOptionClick("Agencies");
        //activate filter
        searchHelper.filterOptionClick("Flatmates");
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Flatmates");
        clickApply();
        sleep(2000);
        Assert.assertEquals(getCardUserType(), cardsUserTypeFlatmate());

        searchHelper.clickMyIdealFM_FilterTypeUserVerify(1);
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Flatmates");
        //deactivate previous filter
        searchHelper.filterOptionClick("Flatmates");
        //activate filter
        searchHelper.filterOptionClick("Live-in landlords");
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Live-in landlords");
        clickApply();
        sleep(2000);
        Assert.assertEquals(getCardUserType(), cardsUserTypeLive_in());

        searchHelper.clickMyIdealFM_FilterTypeUserVerify(1);
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Live-in landlords");
        //deactivate previous filter
        searchHelper.filterOptionClick("Live-in landlords");
        //activate filter
        searchHelper.filterOptionClick("Live-out landlords");
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Live-out landlords");
        clickApply();
        sleep(2000);
        Assert.assertEquals(getCardUserType(), cardsUserTypeLive_out());

        searchHelper.clickMyIdealFM_FilterTypeUserVerify(1);
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Live-out landlords");
        //deactivate previous filter
        searchHelper.filterOptionClick("Live-out landlords");
        //activate filter
        searchHelper.filterOptionClick("Select");
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Select");
        clickApply();
        sleep(2000);


        try {
            Assert.assertEquals(getCardUserType(), cardsUserTypeSelect());
        }catch (AssertionError e) {
            throw new AssertionError("list of 1 users doesn't match");
        }
        Assert.assertEquals(getCardUserType(), cardsUserTypeSelect());

        /*

        Assert.assertEquals(getCardUserType(), cardsUserTypeAll());
        Assert.assertEquals(getCardUserSelectLabel(), cardsUserTypeSelectLabel());
        if (getCardUserType().contains("Live-out landlords")){
            throw new NullPointerException("Not only Select");
        }

        if (!Collections.disjoint(getCardUserType(), cardsUserTypeAll())){
            throw new NullPointerException("Not only Select");
        }
        if (!getCardUserType().containsAll(cardsUserTypeAll())) {
            try {
                throw new IOException("Not only Select");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("verificationHelper = " + Collections.disjoint(getCardUserType(), cardsUserTypeAll()));
        setCardUserType().waitUntil(Condition.visible, 10000);
        try {
            Assert.assertEquals(getCardUserType(), cardsUserTypeSelect());
        }catch (AssertionError e) {
            throw new AssertionError("list of users doesn't match");
        }*/

        searchHelper.moveToPage(1, "1");
        Assert.assertEquals(getCardUserType(), cardsUserTypeSelect());
        Assert.assertEquals(getCardUserSelectLabel(), cardsUserTypeSelectLabel());
        searchHelper.clickMyIdealFM_FilterTypeUserVerify(1);
        searchHelper.filterOptionClick("Select");
        clickApply();
        sleep(2000);
        searchHelper.clickMyIdealFM_FilterTypeUserVerify(0);
        clickApply();
        sleep(2000);

        searchHelper.clickMyIdealFM_FilterTypeUserVerify(0);
        searchHelper.filterOptionClick("Agencies");
        searchHelper.filterOptionClick("Flatmates");
        searchHelper.filterOptionClick("Live-in landlords");
        searchHelper.filterOptionClick("Live-out landlords");
        searchHelper.filterOptionClick("Select");
        clickApply();
        sleep(1000);
        searchHelper.clickMyIdealFM_FilterTypeUserVerify(5);
        clickApply();
        sleep(1000);

        helperBase.toHomePage();
    }




    /*@Test(priority = 4)
    public void sortListingByBudget() {

        authorizationHelper.goToPropertyPage();
        helperBase.toHomePage();
        //Lowest budget
        searchHelper.clickHighestPrice(3);
        sleep(5000);

        int cardsBudgetText = 0;
        String[] texts = $$(String.format("div.card-infos-left", cardsBudgetText)).getTexts();



        Arrays.sort(texts);

        $$(String.format("div.card-infos-left", cardsBudgetText)).shouldHave(CollectionCondition.texts(texts));

       // searchHelper.verifySortingByBudget();
        helperBase.toHomePage();
    }*/
    /*@Test
    public void userCanSortProductsByNameinList()   {


        // get list with product names
        ArrayList expectedBudget = getList(java.util.Optional.of(".//*[@class='product-name']/a"));

        // sort() will return this list sorted in ascending order
        Collections.sort(expectedBudget);


        // get another list with product names
        ArrayList actualBudget = getList(".//*[@class='product-name']/a");

        // compare lists
        assertEquals(actualNames, expectedBudget, "Not sorted by name.");

    }*/


}
