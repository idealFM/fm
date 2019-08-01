package uk.co.idealflatmate.tests;

import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ConfData;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.sleep;
import static uk.co.idealflatmate.appmanager.AuthorHeaderMenuHelper.clickSignInButtonInForm;
import static uk.co.idealflatmate.appmanager.HelperBase.*;

//import ru.yandex.qatools.allure.annotations.Parameter;


public class ACleanaTests extends TestBase {

    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }


    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {

        return new Object[][] { {ConfData.getData("passwUniv"), ConfData.getData("agentRemoved" )},
                { "qqqqqq", "FMnewlq1t6@gmail.com" }, { "qqqqqq", "FMnew999@gmail.com"}, { "qqqqqq", "agentTest08@gmail.com" },
                { "qqqqqq", "Li1q3e11@gmail.com" }, { "qqqqqq", "Live_inNew021r@gmail.com" },{ "qqqqqq", "Lord_out_New034@gmail.com" },
                { "qqqqqq", "Live_inNewL012@gmail.com" },{ "qqqqqq", "Live_inNewL012yyy@gmail.com" },{ "qqqqqq", "Mes1email@gmail.com" },
                { "qqqqqq", "Mes2email@gmail.com" }, {"qqqqqq", "TerezaHQ1a@gmail.com"},{"qqqqqq", "Mes4email@gmail.com" },
                {"qqqqqq", "FMupsBuddy5@gmail.com" }, {"qqqqqq", "TerezaHQ5@gmail.com"}, {"qqqqqq", "TerezaHQ2@gmail.com"},
                {"qqqqqq", "FMnew124o@gmail.com"}, {"qqqqqq", "Tenanttyrrr1r@gmail.com"}, {"qqqqqq", "Live_inNewy733430@gmail.com"},
                {"qqqqqq", "FMnewuy7233@gmail.com"}, {"qqqqqq", "FMnew33riiq@gmail.com"}, {"qqqqqq", "LiveOut7t111r21@gmail.com"},
                {"qqqqqq", "FMupsBuddy6@gmail.com"}, {"qqqqqq", "FMupsBuddy7@gmail.com"}, {"qqqqqq", "Live_inChange@gmail.com"},
                {"qqqqqq", "TenantMesSpam2@gmail.com"}, {"qqqqqq", "TenantSpam11@gmail.com"}};

        }




    @Test(dataProvider = "Authentication" )
    
    @Step
    public void removeAccountBeforeTest(String confEmail, String confPassword) {

        authorizationHelper.loginHeader1(confEmail, confPassword);
        authorizationHelper.removeAccountBeforeTest();



    }





    //@Test (dataProvider = "dasf")


    @Parameters ({ "confEmail", "confPassword" })
    @Test
    @Step()
    public void removeAccountBeforeTestLive(@Optional("qqqqqq") String confPassword,@Optional("proideal@ukr.net") String confEmail) {
        clearBrowserCookies();
        authorizationHelper.loginHeader2(confEmail, confPassword);
        authorizationHelper.removeAccountBeforeTest();



    }



    @Test
    @Step()
    public void removeListingBeforeTest() {

        authorizationHelper.login("passwUniv", "agentNotPaid");
        closeListRenewPopUp();
        verifyNoPropertyOrRemove();

        authorizationHelper.login("passwUniv", "userNotpaid");
        verifyNoPropertyOrRemove();

        authorizationHelper.login("passwUniv", "userNotpaid1");
        verifyNoPropertyOrRemove();

        authorizationHelper.login("passwUniv", "agentBuddyUp");
        verifyNoPropertyOrRemove();

        //authorizationHelper.login("passwUniv", "agentNewBuddyUp");
        //closeListRenewPopUp();
        //verifyNoPropertyOrRemove();

        authorizationHelper.login("passwUniv", "userTitle");
        closeMatchPopUp();
        verifyNoPropertyOrRemove();

    }

    @Test
    public void removeFB_BeforeTest() {

        authorizationHelper.clickJoinFreeButton();
        clickSignInButtonInForm();
        authorizationHelper.clickSignUp_In_WithFacebook();
        authorizationHelper.LoginFacebookWithNewAccount("FB3","passwFB2");
        if(verificationHelper.userName.exists()){
            closeMatchPopUp();
            authorizationHelper.removeAccountBeforeTest();
        }else  signUpHelper.quit();
    }

    @Test
    public void activateListingBeforeTest() {
        authorizationHelper.login("passwUniv", "Live_in_Mes");
        closeListRenewPopUp();
        closeMatchPopUp();
        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.isNotActive("12947");
        sleep(2000);
        clearCache();

    }



    public void verifyNoPropertyOrRemove() {
        closeListRenewPopUp();
        closeMatchPopUp();
        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoUnfinishedProperty();
        verificationHelper.verifyNoPropertyPending();
        verificationHelper.verifyNoProperty();
        authorizationHelper.logoutFromApp();
        sleep(2000);
        clearCache();
    }


}

