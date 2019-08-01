package uk.co.idealflatmate.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class ZEmailzTests extends TestBase {
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }


    @Test
    public void zSuccesEmailReceivingWelcomeListingMessageSubscriptionCancSub() {
        emailHelper.enterGmail("cro.gen.idealflatmate@gmail.com", "qqqqqq666D");
        emailHelper.tipCheckboxWelcome();
        emailHelper.tipCheckboxListingisLive();


        //emailHelper.tipCheckboxMessage("You have a new enquiry!");

        //emailHelper.tipCheckboxMessage("ideal flatmate - Someone posted a group on your listing");
        //emailHelper.tipCheckboxMessage("ideal flatmate - Someone is interested in your property");
        //emailHelper.tipCheckboxMessage("ideal flatmate - A group was removed");
        //emailHelper.tipCheckboxMessage("Group reported");
        //emailHelper.tipCheckboxMessage("ideal flatmate - Someone joined your group");
        //emailHelper.tipCheckboxMessage("ideal flatmate - Premium Flathunter Subscription created");
       // emailHelper.tipCheckboxMessage("Premium Flathunter Subscription cancelled");
        emailHelper.tipCheckboxMessage("ideal flatmate - Subscription created");
        emailHelper.tipCheckboxMessage("ideal flatmate - Subscription cancelled");
        emailHelper.tipCheckboxMessage("Your listing on ideal flatmate is pending.");
        emailHelper.tipCheckboxMessage("You have a new message");
        emailHelper.removeAllEmails();
        emailHelper.verificationNoWelcome();
        emailHelper.verificationNoListingisLive();
        //emailHelper.verificationNoMessageEmail("You have a new message!");

    }


}
