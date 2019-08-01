package uk.co.idealflatmate.appmanager;


import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class EmailHelper extends HelperBase {

    String tip = "(//span[contains(., 'AM') or contains(., 'PM')]//ancestor::tr//div//div//span[contains(., \'";
    String tip2 = "\')]//ancestor::tr//td/div[@role='checkbox'])[1]";
    public SelenideElement button_Inbox = $(byXpath("(//span[starts-with(@class, 'nU ')])[1]"));

    public final VerificationHelper verificationHelper = new VerificationHelper();
    @Step
    public void openGmailPage() {
        if($(byXpath("//div[@class='ub-emb-iframe-wrapper ub-emb-visible']")).is(exist)) {
            //sleep(4000);
            $(byXpath("(//button[@class='ub-emb-close'])[1]")).waitUntil(appears, 4000).click();
            // sleep(4000);
            open("https://mail.google.com/");
        }else {
            open("https://mail.google.com/");
        }
    }
    @Step
    public void setLoginAsUserEmail(String email) {
        gmailLogin(email, "//input[@type='email']", "//div[@id='identifierNext']//span[@class='RveJvd snByac']");
    }
    @Step
    public void setLoginAsUserPassword(String password) {
        gmailLogin(password, "//input[@type='password']", "//div[@id='passwordNext']//span[@class='RveJvd snByac']");
    }

    @Step
    public void enterInbox() {
        button_Inbox.waitUntil(visible, 6000).click();
        sleep(1000);
    }


    @Step
    public void verificationNoListingisLive() {
        $(byXpath("//div[@class='nH bkL']//tbody")).shouldNotHave((text("Congratulations! Your listing on Ideal Flatmate is live!")));
    }
    @Step
    public void verificationNoWelcome() {
        $(byXpath("//span[contains(., 'AM') or contains(., 'PM')]//ancestor::tr//div[span[contains(., 'Welcome')]][1]//ancestor::tr//td/div[@role='checkbox']")).shouldNot(exist);
    }

    @Step
    public void tipCheckboxWelcome() {
        $(byXpath("//span[contains(., 'AM') or contains(., 'PM')]//ancestor::tr//div[span[contains(., 'Welcome')]][1]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
        sleep(2000);
    }
    @Step
    public void tipCheckboxListingisLive() {
        $(byXpath("//span[contains(., 'AM') or contains(., 'PM')]//ancestor::tr//td//div//span[contains(., 'Congratulations')]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
        sleep(2000);
    }
    @Step
    public void tipCheckboxMessage(final String message) {
            $(byXpath(tip+ message + tip2)).waitUntil(visible, 6000).click();
        sleep(2000);
    }

    @Step
    public void removeAllEmails() {
        sleep(2000);
        $(byXpath("//div[@class='aeH']")).waitUntil(visible, 5000).click();
        $(byXpath("(//div[@class='asa'])[3]")).waitUntil(visible, 5000).click();
        sleep(2000);
    }
    @Step
    public void verificationPageAfterSignUp() {
        $(byXpath("//h4[contains(., 'Please Verify Your Email to Continue')]")).shouldBe(visible);
        $(byXpath("(//button[@class='btn btn-sm btn-close close'])[4]")).waitUntil(visible, 6000).click();
    }

    @Step
    public void accountConfirm() {

        open("https://mail.google.com/");
        setLoginAsUserEmail("cro.gen.idealflatmate@gmail.com");
        setLoginAsUserPassword("qqqqqq666D");
        enterInbox();
        openEmail();
        clickLinkInEmail();
       // tipCheckboxConfirm();
       // removeAllEmails();
    }


    @Step
    public void openEmail() {
        $(byXpath("//b[contains(., ':')]//ancestor::tr//td//span//b[contains(., 'Ideal Flatmate - Account confirmation')]")).waitUntil(visible, 6000).click();
        sleep(2000);
    }
    @Step
    public void clickLinkInEmail() {
        if($(byXpath(("//div[@data-tooltip='Show trimmed content']"))).is(visible)) {
            $(byXpath(("//div[@data-tooltip='Show trimmed content']"))).waitUntil(visible, 6000).click();
            sleep(2000);
            $(byXpath(("//a[contains(., 'Confirm registration')]"))).waitUntil(visible, 6000).click();
            sleep(2000);
        }else {
            $(byXpath(("//a[contains(., 'Confirm registration')]"))).waitUntil(visible, 6000).click();
            sleep(2000);
        }


    }
    @Step
    public void verificationSuccessfulLogin() {
        switchTo().window(1);
        $(byXpath("//div[@id='w0-success-0']")).waitUntil(appear, 6000).shouldHave(text("Email verified successfully!"));
        }

    public void clickContinue() {
        $(byXpath("//a[contains(., 'Continue')]")).waitUntil(visible, 6000).click();
        sleep(2000);
    }
    @Step
    public void enterEmail() {
        $(byXpath("(//content[@class='CwaK9'])[2]/span")).waitUntil(visible, 6000).click();
    }
    @Step
    public void emailVerification(String Name) {
        verificationPageAfterSignUp();
        accountConfirm();
        verificationSuccessfulLogin();
        verificationHelper.verificationUserNameOnHomePage(Name);
        clickContinue();
    }
    @Step
    public void verificationListingisLive() {
        $(byXpath("//div[@class='nH bkL']//tbody//tr[td//span[contains(., 'AM') or contains(., 'PM')]]")).shouldHave((text("Congratulations! Your listing on Ideal Flatmate is live!")));
    }
    @Step
    public void verificationMessage() {
        $(byXpath("//div[@class='nH bkL']//tbody//tr[td//span[contains(., 'AM') or contains(., 'PM')]]")).shouldHave((text("You have a new message!")));
    }
    @Step
    public void verificationPageAfterSignUpListing() {
        $(byXpath("//div[contains(., 'Please check your inbox and follow the instructions.')]")).shouldBe(visible);
    }
    @Step
    private void tipCheckboxConfirm() {
        $(byXpath("//span/b[contains(., ':')]//ancestor::tr//div//span/b[contains(., 'Account')]//ancestor::tr//td/div[@role='checkbox']")).waitUntil(visible, 6000).click();
    }
    @Step
    public void verificationWelcome() {
        $(byXpath("//div[@class='nH bkL']//tbody//tr[td//span[contains(., 'AM') or contains(., 'PM')]]")).shouldHave((text("Welcome to Ideal Flatmate!")));

    }
    @Step
    public void enterGmail(final String email, final String password) {
        openGmailPage();
        setLoginAsUserEmail(email);
        setLoginAsUserPassword(password);
        enterInbox();

    }
    @Step
    public void confirmGmailAccount(final String email, final String password) {
        EmailHelper e = new EmailHelper();
        openGmailPage();
        if(e.button_Inbox.exists()){
            verifyEmail();
        } else {sleep(1000);
            setLoginAsUserEmail(email);
            sleep(1000);
            setLoginAsUserPassword(password);
            enterInbox();
            verifyEmail();}

    }

    private void verifyEmail() {
        $(byXpath("(//span[contains(.,'Please verify your email address')])[2]")).waitUntil(visible, 10000).click();
        sleep(1000);
        scrollDownPageOn("500");
        sleep(1000);
        if(!$(byXpath("(//a[span[contains(.,'Verify my email address')]])[last()]")).isDisplayed()){
            scrollDownPageOn("1000");
            sleep(1000);
            $(byXpath("(//div[@class='ajR']/img)[last()]")).click();
            sleep(1000);
            $(byXpath("(//a[span[contains(.,'Verify my email address')]])[last()]")).click();
            sleep(1000);
            switchTo().window(1);
            sleep(2000);
        }else {scrollDownPageOn("1000");
              sleep(1000);
              $(byXpath("(//a[span[contains(.,'Verify my email address')]])[last()]")).click();
              sleep(1000);
              switchTo().window(1);
              sleep(2000);}
    }
}
