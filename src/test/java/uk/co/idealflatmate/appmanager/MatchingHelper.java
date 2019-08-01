package uk.co.idealflatmate.appmanager;

import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MatchingHelper extends HelperBase {

        String match2 = "//div[@class='quiz-question-inner' and contains(text(),  '";
        String match3 = "')]/../../..//label[@data-questionid=";

    @Step
    public void clickHomePageMatching() {
        if($(byXpath("//div[@class='lp-element lp-pom-root']")).is(visible)){
            $(byXpath("(//button[@class='ub-emb-close'])[1]")).waitUntil(visible, 4000).click();
            sleep(2000);
        }else {
            $(byXpath("//button[contains(text(), 'Find your new flatmate!')]")).waitUntil(visible, 4000).click();
            //$(byXpath("//button[contains(text(), 'Start the match test')] ")).waitUntil(visible, 4000).click();
        }
    }
    @Step
    public void enterFirstName(String Name) {
        Field2("input#addnamematchform-username", Name);
        $("input#addnamematchform-username").click();


    }
    @Step
    public void clickContinueMatching1() {
        $(byXpath("" +match2+ "I tend to go out to meet friends, socialize or network most evenings"+match3+"'1'][1]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching2() {
        $(byXpath("" +match2+ "I like to have people over for drinks on a regular basis" +match3+ "'2'][2]")).click();
        sleep(1000);

    }
    @Step
    public void clickContinueMatching3() {
        $(byXpath("" +match2+ "I like having friends staying over for a few days" +match3+ "'3'][3]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching4() {
        $(byXpath("" +match2+ "I would like my shared house to be known as a place to party" +match3+ "'4'][4]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching5() {
        $(byXpath("" +match2+ "I sometimes go out and come home in the early hours" +match3+ "'5'][5]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching6() {
        $(byXpath("" +match2+ "Occasionally I bring people I have just met to my house" +match3+ "'6'][6]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatchingAfterSignUp() {
        $(byXpath("(//button[contains(text(), 'Continue')])[7]")).waitUntil(visible, 4000).click();
        sleep(2000);
    }
    @Step
    public void clickContinueMatching7() {
        $(byXpath("" +match2+ "There should be a rota for putting the bins out" +match3+ "'7'][1]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching8() {
        $(byXpath("" +match2+ "I like to sort my spices and herbs clearly" +match3+ "'8'][2]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching9() {
        $(byXpath("" +match2+ "I like the fridge clean and organized" +match3+ "'9'][3]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching10() {
        $(byXpath("" +match2+ "There should be a rota for allocating household chores" +match3+ "'10'][4]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching11() {
        $(byXpath("" +match2+ "I am usually the person nagging others to tidy up" +match3+ "'11'][5]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching12() {
        $(byXpath("" +match2+ "I see flatmates as people I live with rather than friends" +match3+ "'12'][6]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching13() {
        $(byXpath("" +match2+ "If I could choose, I would prefer to live alone" +match3+ "'13'][1]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching14() {
        $(byXpath("" +match2+ "I prefer to eat in my room rather than in the communal areas" +match3+ "'14'][2]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching15() {
        $(byXpath("" +match2+ "I spend most of my time in my room" +match3+ "'15'][3]")).click();
        sleep(2000);
    }
    @Step
    public void clickContinueMatching16() {
        $(byXpath("" +match2+ "mind if my flatmates invite friends to our house, as long as they give me notice" +match3+ "'16'][4]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching17() {
        $(byXpath("" +match2+ "I am relaxed about the sexual preference of my flatmates" +match3+ "'17'][5]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching18() {
        $(byXpath("" +match2+ "It is sometimes OK to break the rules" +match3+ "'18'][6]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching19() {
        $(byXpath("" +match2+ "I am relaxed about the religious choices of my flatmates" +match3+ "'19'][1]")).click();
        sleep(1000);
    }
    @Step
    public void clickContinueMatching20() {
        $(byXpath("" +match2+ "I am happy to help a flatmate with a personal task, e.g. ironing a shirt or giving them a lift somewhere" +match3+ "'20'][2]")).click();
        sleep(1000);
    }
    @Step
    public void clickSkip7step() {
        $(byXpath("//label[@data-questionid='7']/../../../div//a")).waitUntil(visible, 8000).click();
    }
    @Step
    public void chooseMatchingFromDropDownMenu() {
        $(byXpath("//ul[@class='dropdown-menu']//a[@class='box-hide-overflow u_ed-block']" +
                "//span[@class='pull-left' and contains(text(), 'Matching')]")).click();
    }
    @Step
    public void clickSkip7stepFromHome() {
        $(byXpath("(//div[@class='col-sm-3 col-sm-push-6'])[1]/a")).waitUntil(visible, 4000).click();
    }
    @Step
    public void clickMatchBanner() {
        $(byXpath("//a[contains(.,'Take the match test ')]")).waitUntil(visible, 8000).click();
    }

    @Step
    public void clickARoom() {
        $(byXpath("//div[@class='col-sm-6 u_m15-bottom-xs']/a")).click();

    }
    @Step
    public void clickAFM() {
        $(byXpath("//div[@class='col-sm-6']/a")).click();

    }
    @Step
    public void verifyBlankNameMatchSign() {
        $("input#addnamematchform-username").click();
        $(byXpath("//div[@class='text-center text-16 u_m10-bottom']/strong")).click();
        $(byXpath("//a[contains(.,'A room')]")).doubleClick();
        $(byXpath("//div[input[@id='addnamematchform-username']]/div[@class='help-block']")).shouldHave(text("Whoops, please enter your name to continue!"));

    }
    @Step
    public void verificationResultOfMatching() {
        String match = "//div[@id='slider-snap-value-lower";
        $(byXpath(""+match+"1']")).shouldHave(text("Strongly agree"));
        $(byXpath(""+match+"2']")).shouldHave(text("Agree"));
        $(byXpath(""+match+"3']")).shouldHave(text("Agree slightly"));
        $(byXpath(""+match+"4']")).shouldHave(text("Disagree slightly"));
        $(byXpath(""+match+"5']")).shouldHave(text("Disagree"));
        $(byXpath(""+match+"6']")).shouldHave(text("Strongly disagree"));
        $(byXpath(""+match+"7']")).shouldHave(text("Strongly disagree"));
        $(byXpath(""+match+"8']")).shouldHave(text("Strongly agree"));
        $(byXpath(""+match+"9']")).shouldHave(text("Agree"));
        $(byXpath(""+match+"10']")).shouldHave(text("Agree slightly"));
        $(byXpath(""+match+"11']")).shouldHave(text("Disagree slightly"));
        $(byXpath(""+match+"12']")).shouldHave(text("Disagree"));
        $(byXpath(""+match+"13']")).shouldHave(text("Strongly disagree"));
        $(byXpath(""+match+"14']")).shouldHave(text("Strongly agree"));
        $(byXpath(""+match+"15']")).shouldHave(text("Agree"));
        $(byXpath(""+match+"16']")).shouldHave(text("Agree slightly"));
        $(byXpath(""+match+"17']")).shouldHave(text("Agree"));
        $(byXpath(""+match+"18']")).shouldHave(text("Strongly agree"));
        $(byXpath(""+match+"19']")).shouldHave(text("Disagree slightly"));
        $(byXpath(""+match+"20']")).shouldHave(text("Disagree"));
    }
    @Step
    public void verificationResultOfSixMatching() {
        String  lower = "//div[@id='slider-snap-value-lower";
        $(byXpath(""+lower+"1']")).shouldHave(text("Strongly agree"));
        $(byXpath(""+lower+"2']")).shouldHave(text("Agree"));
        $(byXpath(""+lower+"3']")).shouldHave(text("Agree slightly"));
        $(byXpath(""+lower+"4']")).shouldHave(text("Disagree slightly"));
        $(byXpath(""+lower+"5']")).shouldHave(text("Disagree"));
        $(byXpath(""+lower+"6']")).shouldHave(text("Strongly disagree"));
    }    @Step

    public void quitQuiz() {
        $(byXpath("//a[contains(.,'Quit')]")).click();
    }
    @Step
    public void end_Update_Quiz(final String text) {
        $(byXpath("//button[contains(.,'" + text + "')]")).click();
        $(byXpath("//div[@class='alert alert-success']")).waitUntil(visible, 15000).getText().contains("Well done! Thanks for " +
                "answering these questions. We can now match you with compatible flatmates." +
                " Remember, you can change your answers at any time in the ");
    }
    @Step
    public void closeTakeMatch() {
        $(byXpath("//button[@data-dismiss='alert']")).click();
    }
    @Step
    public void matchingTests() {

        clickContinueMatching1();
        clickContinueMatching2();
        clickContinueMatching3();
        clickContinueMatching4();
        clickContinueMatching5();
        clickContinueMatching6();
        clickContinueMatching7();
        clickContinueMatching8();
        clickContinueMatching9();
        clickContinueMatching10();
        clickContinueMatching11();
        clickContinueMatching12();
        clickContinueMatching13();
        clickContinueMatching14();
        clickContinueMatching15();
        clickContinueMatching16();
        clickContinueMatching17();
        clickContinueMatching18();
        clickContinueMatching19();
        clickContinueMatching20();
    }

    @Step
    public void matchingOnCardClick() {
        $(byXpath("//div[@id='property_card_35292']//div[contains(@class,'card-matching')]")).exists();
        $(byXpath("//div[@id='property_card_35292']//picture/img")).click();
    }
}
