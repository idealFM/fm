package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SearchHelperFM extends HelperBase {

    @Step
    public void clickMoreFilterVerify(String About, String AboutProp) {

        SelenideElement checkBox = $(byXpath("//label[@for='no-photo']/../input"));
        SelenideElement moreFilter = $(By.xpath("//div[@class='flatmate-type-filter selected']"));
        List<String> hasList = getFMcardSearchText();

        moreFilter.click();
        $(By.xpath("//label[@class='circle-button-with-text active']/span[contains(., '"+About+"')]")).exists();
        $(By.xpath("//span[contains(.,'"+ AboutProp +"')]")).click();
        clickApply();
        sleep(1000);

        sleep(2000);
        List<String> noList = getFMcardSearchText();
        Assert.assertNotEquals(hasList, noList);

        moreFilter.click();
        sleep(1000);
        checkBox.shouldNotBe(checked);
        sleep(1000);
        clickClose();

    }
    @Step
    public void clickMoreFilterVerifyPhotoNoListing(String About) {

        SelenideElement checkBox = $(byXpath("//label[@for='no-photo']/../input"));
        SelenideElement checkBoxClick = $(byXpath("//div[input[@id='no-photo']]"));
        SelenideElement moreFilter = $(By.xpath("//div[@class='flatmate-type-filter selected']"));
        List<String> noPhotoList = getFMcardSearchText();

        moreFilter.click();
        $(By.xpath("//label[@class='circle-button-with-text active']/span[contains(., '"+About+"')]")).exists();

        sleep(1000);
        checkBox.shouldNotBe(checked);
        sleep(1000);
        checkBoxClick.click();
        clickApply();
        sleep(1000);

        sleep(2000);
        List<String> PhotoList = getFMcardSearchText();
        Assert.assertNotEquals(noPhotoList, PhotoList);

        moreFilter.click();
        sleep(1000);
        checkBox.shouldBe(checked);
        clearFilter();
        sleep(1000);

        moreFilter.click();
        sleep(1000);
        checkBox.shouldNotBe(checked);
        clickClose();

    }
    @Step
    public void clickMoreFilterVerifyPhotoListing(String About, String AboutProp) {

        SelenideElement checkBox = $(byXpath("//label[@for='no-photo']/../input"));
        SelenideElement checkBoxClick = $(byXpath("//div[input[@id='no-photo']]"));
        SelenideElement moreFilter = $(By.xpath("//div[@class='flatmate-type-filter selected']"));

        moreFilter.click();
        $(By.xpath("//label[@class='circle-button-with-text active']/span[contains(., '"+About+"')]")).exists();
        $(By.xpath("//span[contains(.,'"+ AboutProp +"')]")).click();
        clickApply();

        sleep(3000);
        List<String> noPhotoList = getFMcardSearchText();

        moreFilter.click();
        $(By.xpath("//label[@class='circle-button-with-text active']/span[contains(., '"+AboutProp+"')]")).exists();

        sleep(1000);
        checkBox.shouldNotBe(checked);
        sleep(1000);
        checkBoxClick.click();
        clickApply();
        sleep(1000);

        sleep(3000);
        List<String> PhotoList = getFMcardSearchText();
        Assert.assertNotEquals(noPhotoList, PhotoList);

        moreFilter.click();
        sleep(1000);
        checkBox.shouldBe(checked);
        clearFilter();
        sleep(1000);

        moreFilter.click();
        sleep(1000);
        checkBox.shouldNotBe(checked);
        $(By.xpath("//label[@class='circle-button-with-text active']/span[contains(., '"+About+"')]")).exists();
        clickClose();

    }
    @Step
    public void activeGender(String gender) {
        SelenideElement genderAct = $(By.xpath("//div[@class='gender-filter ']"));
        SelenideElement genderActive = $(By.xpath("//div[@class='gender-filter selected']"));

        List<String> noGender = getFMcardSearchText();
        genderAct.click();
        $$(By.xpath("//label[@class='circle-button-with-text ']")).shouldHaveSize(3);
        $(By.xpath("//label/span[contains(.,'"+ gender +"')]")).click();
        clickApply();

        sleep(2000);
        List<String> genderNew = getFMcardSearchText();
        Assert.assertNotEquals(noGender, genderNew);

        genderActive.click();
        $(By.xpath("//label[@class='circle-button-with-text active']/span[contains(.,'Male')]")).exists();
        sleep(1000);
        clearFilter();
        sleep(1000);

        genderAct.click();
        sleep(1000);
        $$(By.xpath("//label[@class='circle-button-with-text ']")).shouldHaveSize(3);

        $(By.xpath("//label/span[contains(.,'"+ gender +"')]")).click();
        clickApply();

    }
    @Step
    public void activeAgeFM() {

        List<String> noAge = getFMcardSearchText();
        activeAge();
        sleep(2000);
        List<String> ageAct = getFMcardSearchText();
        Assert.assertNotEquals(noAge, ageAct);

        $(byXpath("//div[@class='ideal-flatmate-filter selected']")).click();
        clearFilter();

        sleep(2000);
        List<String> ageAct2 = getFMcardSearchText();
        Assert.assertNotEquals(noAge, ageAct2);

        activeAge();

    }
    @Step
    public void activeOccupationFM(String occupation) {
        SelenideElement occupationAct = $(By.xpath("//div[@class='occupation-flatmate-filter ']"));
        SelenideElement occupationActive = $(By.xpath("//div[@class='occupation-flatmate-filter selected']"));
        SelenideElement occupSelect = $(By.xpath("//label/span[contains(.,'"+ occupation +"'/../div)]"));

        List<String> noOccup = getFMcardSearchText();



        occupationAct.click();
        $$(By.xpath("//label[@class='circle-button-with-text ']")).shouldHaveSize(3);
        occupSelect.click();
        clickApply();

        sleep(2000);
        List<String> occupNew = getFMcardSearchText();
        Assert.assertNotEquals(noOccup, occupNew);

        occupationActive.click();
        $(By.xpath("//label[@class='circle-button-with-text active']/span[contains(.,'"+occupation+"')]")).exists();
        sleep(1000);
        clearFilter();
        sleep(1000);

        occupationAct.click();
        occupSelect.click();
        clickApply();
    }
    @Step
    public void verifSearchHasNoLocationFM(String location) {
        sleep(3000);
        $(byXpath("//div[@class='container']//input")).shouldNotHave(value(location));
    }
    @Step
    public void verifSearchHasLocationFM(String location) {

        $(byXpath("//div[@class='container']//input")).waitUntil(visible, 15000).shouldHave(value(location));
    }
    @Step
    public static void activeAge() {
        SignUpHelper signUpHelper = new SignUpHelper();

        $(byXpath("//div[@class='ideal-flatmate-filter ']")).click();
        $(byXpath(signUpHelper.dragLow)).dragAndDropTo($(byXpath("//span[contains(.,'Clear')]")));
        $(byXpath(signUpHelper.dragUpper)).dragAndDropTo($(byXpath("//span[contains(.,'Apply')]")));
        clickApply();
    }
    @Step
    public static void clearFilter() {
        sleep(2000);
        $(byXpath("//span[contains(.,'Clear')]")).click();

    }
    @Step
    public static void clickApply() {
        $(byXpath("//span[contains(.,'Apply')]")).click();

    }
    @Step
    public void verifyMoreFilterActive() {
        $(By.xpath("//div[@class='flatmate-type-filter selected']//span[@class='active-filters-count']")).shouldBe(exist);
    }
    @Step
    private void clickClose() {
        $(By.xpath("//div[@class='flatmate-type-filter  opened ']")).click();
    }

}

