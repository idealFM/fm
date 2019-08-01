package uk.co.idealflatmate.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.switchTo;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class FooterTests extends TestBase {

    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
        refresh();
    }

    @Test
    public void footerHomeLink() {

        footerHelper.footerClick("Home");
        footerHelper.verificationFooterHome();
        helperBase.toHomePage();
    }

    @Test
    public void footerAboutUsLink() {

        footerHelper.footerClick("About us");
        footerHelper.verificationFooter("About us");
        helperBase.toHomePage();
    }

    @Test
    public void footerContactLink() {

        footerHelper.footerClick("Contact");
        footerHelper.verificationFooter("Contact");
        helperBase.toHomePage();
    }

    @Test
    public void footerPressLink() {

        footerHelper.footerClick("Press");
        footerHelper.verificationFooter("Press");
        helperBase.toHomePage();
    }

    @Test
    public void footerPricingLink() {

        footerHelper.footerClick("Pricing");
        footerHelper.verificationFooter("Pricing");
        helperBase.toHomePage();
    }

    @Test
    public void footerMediaLink() {

        footerHelper.footerClick("Media");
        footerHelper.verificationFooter("Media");

    }

    @Test
    public void footerStaySafeLink() {

        footerHelper.footerClick("Stay safe");
        footerHelper.verificationFooter("Security warning");

    }

    @Test
    public void footerBlogLink() {

        footerHelper.footerClick("Blog");
        verificationHelper.FMBlogPage();

    }

    @Test
    public void footerBrowseFlatsharesLink() {
        //verifying city = "London"; region = "North London"; area = "Chalk Farm";


        footerHelper.footerClick("Browse Flatshares");
        searchHelper.verificationFlatshare();
        }

    @Test
    public void footerAskLandlord() {

        helperBase.toHomePage();
        footerHelper.footerClick("#AskTheLandlord");
        footerHelper.verificationAskLandlord();
        helperBase.toHomePage();
    }

    @Test
    public void footerModern() {

        helperBase.toHomePage();
        footerHelper.footerClick("Modern Living Index");
        footerHelper.verificationModern();

    }

    @Test
    public void footerBrowseHowItWorksLink() {

        footerHelper.footerClick("How it works");
        footerHelper.verificationHowItWorks();
        helperBase.toHomePage();
    }

    @Test
    public void footerBrowseTipsLink() {

        footerHelper.footerClick("Tips");
        footerHelper.verificationFooter("Tips");
        helperBase.toHomePage();
    }

    @Test
    public void footerNLALink() {

        footerHelper.footerNLAPaymentsClick();
        switchTo().window(0);
        footerHelper.verificationNLAWorks();
        //helperBase.toHomePage();
    }

    //@Test
    public void footerFBLink() {
        pageUrlVerifLiveGoStage();
        helperBase.toHomePage();
        footerHelper.footerFB();
        footerHelper.verificationFB();

    }

    @Test
    public void footerTwitterLink() {

        footerHelper.footerTwitter();
        footerHelper.verificationTwitter();
    }

   @Test
    public void footerInstagramLink() {

        footerHelper.footerInstagram();
        footerHelper.verificationInstagram("idealflatmate");

    }

    @Test
    public void footerYoutubeLink() {

        footerHelper.footerYoutube();
        refresh();
        footerHelper.verificationYoutube();
    }



}
