package uk.co.idealflatmate.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.SearchHelper.getNumberOfListingFound;

public class SearchHomePageTests extends TestBase {

    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }
    @AfterMethod

    public void goHomePage() {
        helperBase.toHomePage();
    }


    @Test
    public void searchHomeByButton() {

        searchHelper.searchPropertyHome1("london");
        searchHelper.closePopupSignup();

        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" rooms to rent available");

    }

    @Test
    public void TestSearchHomeByEnter() {

        searchHelper.searchPropertyByEnter("Clapham");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" room to rent available");

    }
    @Test
    public void searchHomeLocationFromList() {

        searchHelper.searchPropertyBySelectfromList("Clapham", "Clapham Junction");
        searchHelper.closePopupSignup();

        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" room to rent available");

    }


    //@Test
    public void searchHomeIncorrectData() {

        searchHelper.searchPropertyHome("ttttttttt");
        searchHelper.verificationSearchHomePage("Location\n" +  "not found. Please try again.\n" +  "");

    }
    @Test
    public void searchHomePartOfLocationName() {

        searchHelper.searchPropertyHome("wellessbour we");
        searchHelper.closePopupSignup();

        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " room to rent available", getNumberOfListingFound()+" room to rent available");

    }
    @Test
    public void searchHomeIDProperty() {

        searchHelper.searchPropertyHome("#0013119");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMap(" London SE6 4RU, UK");

    }
    @Test
    public void searchHomeNorthLND() {

        searchHelper.searchPropertyHome("North London");
        sleep(20000);
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" room to rent available");
    }


}
