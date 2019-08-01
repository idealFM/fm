package uk.co.idealflatmate.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import uk.co.idealflatmate.appmanager.ProfileData;
import utils.ConfData;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;
import static uk.co.idealflatmate.appmanager.AddPropertyHelper.roomAmountIs;
import static uk.co.idealflatmate.appmanager.HelperBase.*;
import static uk.co.idealflatmate.appmanager.SearchHelper.getNumberOfListingFound;

//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
//import static uk.co.idealflatmate.appmanager.AddPropertyHelper.monthAvailableFrom;

public class bListingbTests extends TestBase {

    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
        clearBrowserCookies();
    }
    @AfterMethod
    public void closeMethod() {
        close();
    }


    @Features("Listing")
    @Stories("login")
    @Test
    public void loginStartListing() {

        authorizationHelper.login("passwUniv","userNotpaid1");
        closeListRenewPopUp();
        verificationHelper.closeMatchingPopup();

        //verificationHelper.verifyNoProperty();
        addPropertyHelper.chooseListingsFromDropDownMenu()
                         .addListingFromListingPage()
                         .setPostalCode("L11","5 Galemeade, Liverpool, L11")
                         .pressContinue();
        sleep(1000);
        addPropertyHelper.pressContinue();
        sleep(1000);
        addPropertyHelper.saveQuitHeaderMenuListing()
                         .chooseListingsFromDropDownMenu();
        verificationHelper.finishUnfinished();
        addPropertyHelper.saveQuitHeaderMenuListing()
                         .chooseListingsFromDropDownMenu();

        verificationHelper.removeUnfinishedListing();
        verificationHelper.verifyNoPropertyPending();
        verificationHelper.verificationUserNameOnHomePage("John");

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }
    @Features("Listing")
    @Stories("pending")
    @Test
    public void loginPendingListing() {
        authorizationHelper.login("passwUniv","userNotpaid");

        verificationHelper.closeMatchingPopup();
        closeListRenewPopUp();

        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();

        addPropertyHelper.chooseListingsFromDropDownMenu()
                         .addListingFromListingPage()
                         .setPostalCode("sw1a ", "79 Whitehall, London, SW1A")
                         .pressContinue()
                         //.chooseArea("Knightsbridge")
                         //.pressContinue()
                         .setTotalBedrooms("4");
        scrollDownPageOn("1500");
        addPropertyHelper.setMonthlyRent("500")
                         .pressContinue()
                         .continueListingWithoutPhoto();
        verificationHelper.finishPendingProperty();

        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyPendingProperty();

        addPropertyHelper.removeListingClick("0");
        verificationHelper.verifyNoPropertyPending();
        verificationHelper.verificationUserNameOnHomePage("John");

        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }
    @Features("Listing")
    @Stories("change")
    @Test
    public void houseFeaturesListing() {
        authorizationHelper.login("passwUniv","agentNotpaid1");

        verificationHelper.verificationUserNameOnHomePage("AgentF");
        closeListRenewPopUp();
        addPropertyHelper.chooseListingsFromDropDownMenu();

        verificationHelper.verifyNoProperty();
        addPropertyHelper.chooseListingsFromDropDownMenu()
                         .addListingFromListingPage()
                         .setPostalCode("N11 1GN", "Building 1, North London Business Park, Oakleigh Road South, London, N11")
                         .pressContinue()
                         //.chooseArea("New Southgate")
                         //.pressContinue()
                         .setTotalBedrooms("1")
                         .isCheckedSutableFore("Professionals and/or Students")
                         .clickSutableFore("Students Only")
                         .isCheckedSutableFore("Students Only")
                         .setAllAmanitiesFeatures("Gym", "Concierge");

        scrollDownPageOn("1000");

        addPropertyHelper.featuresPropertyClick("property-is_bills_included", checked)
                         .featuresPropertyClick("property-has_no_deposit", checked);

        scrollDownPageOn("600");

        addPropertyHelper.setMonthlyRent("1700");
        scrollDownPageOn("300");
        addPropertyHelper.pressContinue();
        sleep(1000);

        addPropertyHelper.pressBack();

        addPropertyHelper.featuresPropertyIsChecked("property-is_bills_included", checked)
                         .featuresPropertyIsChecked("property-has_no_deposit", checked)
                         .saveQuitHeaderMenuListing()
                         .continueListing()
                         .pressContinue()
                         .continueListingWithoutPhoto();

        helperBase.toHomePage();

        searchHelper.searchPropertyHome1("N11 1GN ");
        searchHelper.selectRadius("+3 km");
        //displaying "BILLS INCL.", "ZERO DEPOSIT", "GYM", "CONCIERGE", "STUDENT"
        verificationHelper.featuresOnTheCard();

        removeListing();

    }
    @Features("Listing")
    @Stories("sign up")
    @Test
    public void signUpPropertyAdding() {
        String newEmail = ConfData.getData("agentRemoved");

        addPropertyHelper.pressAddListingFromHeaderNotLoggedUser()
                         .selectTypeUser("An agency");

        signUpHelper.agentSignListing("Ronald", "agentRemoved", "passwUniv",
                                      "07399042641", "Tell us about yourself");

        signUpHelper.confirmGmailSignUp(newEmail, newEmail);
        clearBrowserCookies();
        clearCache();
        emailHelper.confirmGmailAccount(ConfData.getData("gmailStage"), ConfData.getData("passwGmail"));

        addPropertyHelper.saveQuitHeaderMenuListing()
                         .chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();
        verificationHelper.verifyAddListingPage();

        addPropertyHelper.pressAddListingFromBody()
                         .addListingWithoutPhotoEmptyAreaVerif("M11 ","20 Eastern-by-Pass, Manchester, M11",
        "Bradford-with-Beswick", "2","1500", "Area cannot be blank.")
                         .chooseListingsFromDropDownMenu();
        verificationHelper.verifyAddedProperty("20 Eastern-by-Pass, Manchester, M11 ");

        addPropertyHelper.removeListingClick("0");


        authorizationHelper.chooseTabFromInnerMenuDashboard("My profile");
        verificationHelper.profileDisplays(new ProfileData("percentComplete4",  "myProfile4",
                "name4", "age4","lookingFor4", "aboutMe4","rooms4",
                "amountPropCards4"));

        authorizationHelper.chooseTabFromInnerMenuDashboard("Settings");
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }
    @Features("Listing")
    @Stories("new")
    @Test
    public void propertyAddWithAllFields() {

        authorizationHelper.login("passwUniv", "agentNotPaid");

        closeMatchPopUp();
        addPropertyHelper.closeRenewPopup();

        //getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();

        allFields();

        addPropertyHelper.chooseListingsFromDropDownMenu()
                         .viewListing();

        verificationHelper.photoListingExist();
        verificationHelper.verifyAddedPropertyWithAllFields("August ", "Room 1", "Room 2", "Room 3",
                "En-suite available\n" + "Garden\n" + "Communal living room\n" +  "Balcony/patio\n" +
                        "Parking space\n" + "Smokers Accepted\n" +  "Suitable for couples\n" + "Pets Accepted\n" +
                        "LGBT Friendly\n" + "Trans Friendly\n" + "Family Friendly\n" + "Vegan Household\n" +
                        "Vegetarian Household\n" + "DSS Accepted", "Location\n"+"40 Foreshore, london, SE8 3AG, UK - see more rooms to rent in Evelyn");

        removeListing();
    }
    @Features("Listing")
    @Stories("new")
    @Test
    public void propertyEditAllFieldsAbout() {

        authorizationHelper.login("passwUniv", "agentEdit");
        closeMatchPopUp();
        addPropertyHelper.closeRenewPopup()
                         .chooseListingsFromDropDownMenu()
                         .viewListing();

        verificationHelper.photoListingExist();
        verificationHelper.verifyAboutProperty("3 of 4 bedrooms available");

        addPropertyHelper.chooseListingsFromDropDownMenu()
                         .clickEdit()
                         .changeWholeToRoomOfProperty()
                         .scrollPropertySection()
                         .changeAboutOptions(" Garden", " Communal living room", " Balcony/patio",
    " Parking", "Pets Accepted", "Smokers Accepted", "Suitable for couples", "LGBT Friendly", "Family Friendly",
                                 "Trans Friendly", "Vegan Household", "Vegetarian Household", "DSS Accepted");
        sleep(1000);


        clickButton("Save and update", "button");

        //getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutProperty("3 of 4 bedrooms available\n" + "Garden\n" + "Communal living room\n" +  "Balcony/patio\n" +
                "Parking space\n" + "Smokers Accepted\n" +  "Suitable for couples\n" + "Pets Accepted\n" +
                        "LGBT Friendly\n" + "Trans Friendly\n" + "Family Friendly\n" + "Vegan Household\n" +
                        "Vegetarian Household\n" + "DSS Accepted");

        buddyUpHelper.groupSectionIsVisible(true);

        addPropertyHelper.chooseListingsFromDropDownMenu()
                         .clickEdit()
                         .changeRoomToWholeOfProperty()
                         .scrollPropertySection()
                         .changeAboutOptions(" Garden", " Communal living room", " Balcony/patio", " Parking", "Pets Accepted", "Smokers Accepted", "Suitable for couples", "LGBT Friendly", "Family Friendly", "Trans Friendly", "Vegan Household", "Vegetarian Household", "DSS Accepted");

        //addPropertyHelper.changeRoomsProperty();
        helperBase.clickButton("Save and update", "button");

        //getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutProperty("3 of 4 bedrooms available");
        buddyUpHelper.groupSectionIsVisible(false);
        String areaSearch = "Bankside";
        addPropertyHelper.verifyBreadCrumbs("Search Rooms", "London", areaSearch,
                                            "3 bedrooms for rent in "+areaSearch+", South London from ");
        scrollUpPage("-200");
        sleep(1000);
        addPropertyHelper.goByLink(areaSearch);
        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" room to rent available");



        authorizationHelper.logoutFromApp();
    }
    @Features("Listing")
    @Stories("change")
    @Test
    public void propertyDeactivateRooms() {

        String roomId1 = "24155";
        String roomId2 = "24156";
        String roomId3 = "24157";
        String save = "Save";
        String button = "button";



        authorizationHelper.login("passwUniv", "agentDeactivateRoom");
        closeMatchPopUp();
        addPropertyHelper.closeRenewPopup();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        String Month = addPropertyHelper.monthAvailableFromRoom3();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutProperty("3 bedrooms available\n" + "Garden\n" + "Communal living room\n" +
                "Balcony/patio\n" + "Parking space\n" + "Smokers Accepted\n" + "Suitable for couples\n" +
                "Pets Accepted\n" + "LGBT Friendly\n" + "Trans Friendly\n" + "Family Friendly\n" +
                "Vegan Household\n" + "DSS Accepted");
        verificationHelper.verifyAboutPropertyRooms("3 rooms available in 3 bed property in Birmingham. " +
                "Room 1 is £1900.00 per month. Room 2 is £1950.00 per month, the deposit is £500.00. " +
                "Room 3 is £1950.00 per month, the deposit is £700.00 and bills are an additional £1200.00 per month.");

        addPropertyHelper.clickRoomsSection();
        verificationHelper.roomVerification("Room 1", "1900", "no", "no",
                                            "Now", "", "", "no",
                                            "no");
        verificationHelper.roomVerification("Room 2", "1950", "£500", "no",
                                            "25th", "March", "2019",
                                            "minimum 2 months maximum 4 months","no");
        verificationHelper.roomVerification("Room 3", "1950", "£700", "£1200",
                                            "15th", Month, "2020",
                                            "minimum 6 months maximum 8 months",
                                            "How would you describe your room");

        String citySearch = "Birmingham";
        addPropertyHelper.goByLink(citySearch);
        searchHelper.verifSearchHasLocation("Birmingham");
        propertySortBy("Top matched");
        searchHelper.moveToPage(3, "3");
        sleep(3000);
        //searchHelper.verificationSearchProperty("Found " + getNumberOfListing() + " rooms to rent in "+citySearch);
        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" room to rent available");
        int searchWithActivatedRooms = Integer.parseInt(getNumberOfListingFound());

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        addPropertyHelper.deactivateVerifyRoom(roomId1, "Available now", "Unavailable");
        addPropertyHelper.deactivateVerifyRoom(roomId2, "Available now", "Unavailable");
        addPropertyHelper.deactivateVerifyRoom(roomId3, "Available from 15 April", "Unavailable");
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutPropertyRooms("room available in 3 bed property in Birmingham.");
        verificationHelper.noRoomVerification("Room 1");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutProperty("0 of 3 bedrooms available\n" + "Garden\n" +"Communal living room\n" +
                "Balcony/patio\n" + "Parking space\n" + "Smokers Accepted\n" + "Suitable for couples\n"+"Pets Accepted\n" +
                "LGBT Friendly\n" +"Trans Friendly\n" +"Family Friendly\n" + "Vegan Household\n" +"DSS Accepted");
        addPropertyHelper.goByLink(citySearch);
        propertySortBy("Most recent");
        searchHelper.moveToPage(5, "5");
        sleep(3000);
        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" room to rent available");
        sleep(1000);
        int searchResultDeactivRooms = Integer.parseInt(getNumberOfListingFound());

        Assert.assertEquals(searchWithActivatedRooms, searchResultDeactivRooms+1);

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        addPropertyHelper.activateVerifyRoom(roomId1);
        addPropertyHelper.activateVerifyRoom(roomId2);
        addPropertyHelper.activateVerifyRoom(roomId3);
        addPropertyHelper.clickEditRoom(roomId2);
        addPropertyHelper.availableEdiRoomCheck(roomId2);
        clickButton(save, button);
        addPropertyHelper.clickEditRoom(roomId3);
        addPropertyHelper.availableEdiRoomCheck(roomId3);
        clickButton(save, button);

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutProperty("3 bedrooms available\n" + "Garden\n" +"Communal living room\n" +
                "Balcony/patio\n" + "Parking space\n" + "Smokers Accepted\n" + "Suitable for couples\n"+"Pets Accepted\n" +
                "LGBT Friendly\n" +"Trans Friendly\n" +"Family Friendly\n" + "Vegan Household\n" +"DSS Accepted");
        verificationHelper.verifyAboutPropertyRooms("3 rooms available in 3 bed property in Birmingham. " +
                "Room 1 is £1900.00 per month. Room 2 is £1950.00 per month, the deposit is £500.00. " +
                "Room 3 is £1950.00 per month, the deposit is £700.00 and bills are an additional £1200.00 per month.");
        addPropertyHelper.clickRoomsSection();

        verificationHelper.roomVerification("Room 1", "1900", "no", "no",
                                            "Now", "", "", "no",
                                            "no");
        verificationHelper.roomVerification("Room 2", "1950", "£500", "no",
                                            "25th", "March", "2019",
                                            "minimum 2 months maximum 4 months",
                                            "no");
        verificationHelper.roomVerification("Room 3", "1950", "£700", "£1200",
                                            "15th", Month, "2020",
                                            "minimum 6 months maximum 8 months",
                                            "How would you describe your room");


        addPropertyHelper.goByLink(citySearch);
        propertySortBy("Most recent");
        sleep(1000);
        searchHelper.selectRadius("+3 km");
        sleep(1000);
        searchHelper.moveToPage(4, "4");
        sleep(4000);
        int searchResultNewActivRooms = Integer.parseInt(getNumberOfListingFound());
        searchHelper.verificationSearchProperty("Find A Room To Rent",
                getNumberOfListingFound()+ " rooms to rent available", getNumberOfListingFound()+" room to rent available");
        Assert.assertEquals(searchWithActivatedRooms, searchResultNewActivRooms);

        authorizationHelper.logoutFromApp();
    }
    @Features("Listing")
    @Stories("change")
    @Test
    public void propertyEditRooms() {
        String idRoom = "24324";
        String price1 = "1500"; String price2 = "1200"; String deposit1 = "215"; String deposit2 = "230";
        String bill1 = "120"; String bill2 = "230";
        String year1 = "2022"; String year2 = "2021";   String date1 = "7"; String date2 = "18";
        String description1 = "test1"; String description2 = "test2 test";
        int minStay1 = 5; int minStay2 = 2;
        int maxStay1 = 6; int maxStay2 = 8;

        //SearchHelper listN = new SearchHelper();

        authorizationHelper.login("passwUniv", "agentEditRoom");

        closeMatchPopUp();
        addPropertyHelper.closeRenewPopup();

        //getAddPropertyHelper().openDropDownMenu();
        addPropertyHelper.chooseListingsFromDropDownMenu();

        addPropertyHelper.clickEditRoom(idRoom);
        sleep(1000);
        addPropertyHelper.clickEditRoom(idRoom);//close edit
        sleep(1000);
        addPropertyHelper.clickEditRoom(idRoom);
        sleep(2000);
        //addPropertyHelper.availableDateIsChecked();
        addPropertyHelper.fillRoomData(price1, deposit1, bill1, year1, date1,
                                        minStay1, maxStay1, description1, "Next");
        clickButton("Save", "button");
        sleep(1000);
        String Month = addPropertyHelper.monthAvailableFrom(idRoom);
        sleep(1000);

        addPropertyHelper.viewListing();
        addPropertyHelper.clickRoomsSection();
        verificationHelper.roomVerification("Room 1", price1, "£"+deposit1, "£"+bill1,
                                            date1+"th", Month, year1,
                                            "minimum "+minStay1+" months maximum "+maxStay1+" months",
                                            description1);


        addPropertyHelper.chooseListingsFromDropDownMenu();
        addPropertyHelper.clickEditRoom("24324");
        addPropertyHelper.fillRoomData(price2, deposit2, bill2, year2, date2,  minStay2, maxStay2,
                                        description2, "Prev");
        clickButton("Save", "button");
        sleep(1000);
        String Month2 = addPropertyHelper.monthAvailableFrom(idRoom);
        sleep(1000);

        addPropertyHelper.viewListing();
        addPropertyHelper.clickRoomsSection();
        verificationHelper.roomVerification("Room 1", price2, "£"+deposit2, "£"+bill2,
                                             date2+"th", Month2, year2,
                                            "minimum "+minStay2+" months maximum "+maxStay2+" months",
                                            "test2");

        authorizationHelper.logoutFromApp();
    }
    @Features("Listing")
    @Stories("change")
    @Test
    public void propertyAddRooms() {

        //SearchHelper listN = new SearchHelper();

        authorizationHelper.login("passwUniv", "agentAddRoom");

        sleep(2000);
        addPropertyHelper.closeRenewPopup();
        closeMatchPopUp();


        //getAddPropertyHelper().openDropDownMenu();
        addPropertyHelper.chooseListingsFromDropDownMenu();

        clickButton("Add room", "a");
        sleep(1000);
        clickButton("Remove", "a");
        sleep(1000);
        clickButton("Add room", "a");

        addPropertyHelper.availableDateIsCheckedAddingRoom();
        addPropertyHelper.fillRoomData("1300", "300", "120", "2021", "7",
                                        4, 7,
                                        "How test1", "Next");
        clickButton("Save and create", "button");
        sleep(1000);

        String Month = addPropertyHelper.monthAvailableFromRoom2();
        sleep(1000);

        clickButton("Add room", "a");
        addPropertyHelper.availableDateIsCheckedAddingRoom();
        addPropertyHelper.fillRoomData("", "300", "120", "2022", "7",
                                        5, 8,
                                        "How would you describe your room?", "Next");
        clickButton("Save and create", "button");
        verificationHelper.roomPriceNotif("Monthly rent cannot be blank.");

        addPropertyHelper.fillRoomData("1500", "700", "120", "2023", "20",
                                        1, 8,
                                        "How test2", "Next");

        addPropertyHelper.fillRoomData("1500", "700", "120", "2023", "20",
                                        1, 8,"How test2", "Prev");
        clickButton("Save and create", "button");


        addPropertyHelper.viewListing();
        verificationHelper.verifyAboutProperty("3 of 1 bedroom available\n" +   "Parking space\n" +                "Pets Accepted\n" +
                                                "Trans Friendly\n" +  "DSS Accepted");
        verificationHelper.verifyAboutPropertyRooms("Rome, 36 is a male professional. 3 rooms available in 1" +
                " bed property in Birmingham. Room 1 is £999.00 per month. " +
                "Room 2 is £1300.00 per month, the deposit is £300.00 and bills are an additional £120.00 per month." +
                " Room 3 is £1500.00 per month, the deposit is £700.00 and bills are an additional £120.00 per month.");

        addPropertyHelper.clickRoomsSection();
        verificationHelper.roomVerification("Room 1", "999", "no", "no", "Now",
                                            "", "", "no", "no");
        verificationHelper.roomVerification("Room 2", "1300", "£300", "£120",
                                            "7th",Month, "2021", "minimum 4 months maximum 7 months",
                                            "How test1");
        verificationHelper.roomVerification("Room 3", "1500", "£700",
                                            "£220", "20th",Month, "2023",
                                            "minimum 1 month maximum 8 months","How test2");

        addPropertyHelper.chooseListingsFromDropDownMenu();

        addPropertyHelper.removeRooms("2", "Yes, delete");
        addPropertyHelper.removeRooms("2", "Yes, delete");

        Assert.assertEquals(1, roomAmountIs());

        addPropertyHelper.viewListing();
        verificationHelper.verifyAboutProperty("1 bedroom available\n" + "Parking space\n" + "Pets Accepted\n" +
                                                "Trans Friendly\n" + "DSS Accepted");

        verificationHelper.verifyAboutPropertyRooms("Rome, 36 is a male professional. 1 room available in" +
                                                        " 1 bed property in Birmingham. Room 1 is £999.00 per month.");
        addPropertyHelper.clickRoomsSection();
        verificationHelper.roomVerification("Room 1", "999", "no", "no", "Now",
                                            "", "", "no", "no");


        authorizationHelper.logoutFromApp();
    }
    @Features("Listing")
    @Stories("new")
    @Test
    public void titleListing() {

        authorizationHelper.login("passwUniv", "userTitle");
        verificationHelper.verificationUserNameOnHomePage("Title");
        closeListRenewPopUp();
        verificationHelper.closeMatchingPopup();

        paymentsHelper.addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();

        addPropertyHelper.addListingFromListingPage()
                         .setPostalCode("2 Knowsley ","2 Knowsley Close, Lancaster, LA1")
                         .pressContinue();

        //addPropertyHelper.chooseRoadFor("testRoad");
        //verificationHelper.addingListFlowCity("London");
        //verificationHelper.addingListFlowArea("Shoreditch");
        getAddPropertyHelper().pressContinue();

        //addPropertyHelper.pressBack();

        //verificationHelper.addingListFlowCity("London");
        //verificationHelper.roadFor("Liverpool Street");
        //getAddPropertyHelper().pressContinue();

        addPropertyHelper.setTotalBedrooms("4");
        scrollDownPageOn("1300");
        sleep(1000);
        addPropertyHelper.setMonthlyRent("500");

        String text1 = "Test_Property_Title";
        addPropertyHelper.propertytitle(text1);

        getAddPropertyHelper().pressContinue();

        addPropertyHelper.continueListingWithoutPhoto();
        paymentsHelper.verificationPaymentPageFeatureListing("Now choose the plan that is right for you.");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        closeMatchPopUp();
        getAddPropertyHelper().viewListing();

        verificationHelper.verifyTitleProperty(text1);

        removeListing();

    }



    public void allFields() {

        addPropertyHelper.pressAddListingFromBody()
                         .setPostalCode("Se8 ", "40 Foreshore, London, SE8")
                         .pressContinue()
                         //.chooseRoadFor("Idealstreet")
                         //.chooseArea("Deptford")
                         //.pressContinue()
                         .setTotalBedrooms("4")
                         .isCheckedSutableFore("Professionals and/or Students")
                         .clickSutableFore("Professionals Only")
                         .isCheckedSutableFore("Professionals Only");
        scrollDownPageOn("200");
        addPropertyHelper.setAllAmanities("Garden", "Parking", "Communal living room", "Balcony/patio",
                                            "Pet Friendly", "Smoker Friendly", "Family Friendly",
                                            "LGBT Friendly", "Trans Friendly", "Vegan Household",
                                            "Vegetarian Household", "DSS Accepted", "Suitable for couples",
                                             "Gym", "Concierge", "En-suite")
                         .setPropertyDescription("Very good flat");
        scrollDownPageOn("600");
        sleep(1000);
        addPropertyHelper.setMonthlyRent("500")
                         .setDeposit("1000")
                         .setTotalBills("400")
                         .availabaleChecked("1")
                         .setLeasePeriodRoom("1", "3", "7")
                         .setRoomDescription("Very comfortable room")
                         .copySecondRoom();
        scrollDownPageOn("400");
        sleep(1000);
        addPropertyHelper.removeSecondRoom()
                         .copySecondRoom()
                         .addAnotherRoom();
        scrollDownPageOn("400");
        sleep(1000);
        addPropertyHelper.setAnotherMonthlyRent("800", "800")
                         .availabaleChecked("3")
                         .setAvailablePeriodRoom("3", "2025", "15", "Next");
        scrollDownPageOn("1000");
        addPropertyHelper.setPhoneNumber1("+44 20 7234 3456")
                         .pressContinue()
                         .uploadProperty3Photos()
                         .checkPhotos()
                         .uploadPropertyLargePhoto()
                         .uploadPropertyNotPhoto()
                         .checkPhotos()
                         .pressBack();
        scrollDownPageOn("100");
        sleep(1000);
        addPropertyHelper.checkAllAmanities("Garden", "Parking", "Communal living room", "Balcony/patio",
                                            "property-pets_accepted", "property-smokers_accepted",
                                            "property-family_friendly", "property-lgbt_friendly",
                                            "property-trans_friendly", "property-vegan_household",
                                            "property-vegetarian_household", "DSS Accepted", "Suitable for couples", "En-suite")
                         .pressContinue()
                         .checkPhotos()
                         .finishPropertyCreatingAgency();
    }

    public void removeListing() {
        addPropertyHelper.chooseListingsFromDropDownMenu()
                         .removeListingClick("0");
        verificationHelper.verifyNoProperty();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

}











