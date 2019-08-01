package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class BuddyUpHelper extends HelperBase {
    SelenideElement closePopup = $(byXpath("//div[@id='createBuddyUpGroupModal']//button[@class='btn btn-sm close u_m15']"));
    static SelenideElement dragLow = $(byXpath("//div[@id='js-groups-list']//div[@class='noUi-handle noUi-handle-lower']"));
    static SelenideElement dragUpper = $(byXpath("//div[@id='js-groups-list']//div[@class='noUi-handle noUi-handle-upper']"));
    SelenideElement createGroupButton = $(byXpath("//section[@id='property-infos']//a[contains(.,'Create a Group')]"));
    SelenideElement closebuddyPopup = $(byXpath("//div[@id='introducingBuddyUpGroupModal' and contains(@style,'display: block;')]//div[@aria-label='Close']"));

    public void clickCardProperty() {
        $(byXpath("//div[@class='cards-container']//picture/img")).click();

    }
    public void clickBuddy_upButton(final String text) {
        sleep(2000);
        $(byXpath("//section//a[contains(.,'" + text + "')]")).click();
        sleep(2000);
    }

    public void clickGroupSection() {
        sleep(2000);
        $(byXpath("//a[@id='groups-label']")).click();

    }

    public boolean groupSectionIsVisible(final boolean expression) {
        $(byXpath("//a[@id='groups-label']")).isDisplayed();
        return expression;
    }


    public void clickCreateGroup() {
        $(byXpath("//section//div[contains(@class,'text-center create-group-label')]//a")).click();
    }



    public void closeIntrodGroupsPopup() {
        sleep(4000);
        if(closebuddyPopup.exists()){
            closebuddyPopup.click();
        }

    }


    public void popupGroup(final String create) {
        sleep(3000);
        $(byXpath("//section//div[@id='js-in-popup-groups-list']//a[contains(.,'" + create + "')]")).click();
    }

    public void createPageGroupButton() {
        sleep(2000);
        createGroupButton.click();
    }
    public void notVisibleCreatePageGroupButton() {
        sleep(2000);
        createGroupButton.shouldNotBe(Condition.visible);
    }

    public void learnMore(int selectGroup) {
        sleep(3000);
        $$(byXpath("//section//div[contains(@class,'js-group-item')]//a[contains(.,'Learn')]")).get(selectGroup).click();
    }

    public void myGroupPageClick(final String button) {
        sleep(2000);
        $(byXpath("//div//a[contains(.,'" + button + "')]")).click();
    }

    public void removeGroup(int indexGroup) {
        sleep(2000);
        $$(byXpath("//section[@class='modal-content']//a[contains(.,'Remove group')]")).get(indexGroup).click();
    }

    public void yesRemoveGroup(int indexGroup) {
        sleep(3000);
        $$(byXpath("//section[@class='modal-content']//a[contains(.,'remove the group')]")).get(indexGroup).click();
    }

    public void requestPopupToGroup() {
        sleep(2000);
        $(byXpath("//div[@class='u_p10 group-modal-item']//a[contains(.,'Say hi')]")).click();
    }

    public void requestPageToGroup() {
        sleep(2000);
        $(byXpath("//section//div[@class='modal-dialog vertical-align-center']//a[contains(.,'Say hi')]")).click();
    }


    public void assertNumberOfGroupsPropPage(int numberOfGroups) {
        sleep(3000);
        int GroupsNumber = $$(byXpath("//section//div[contains(@class,'js-group-item')]")).size();
        Assert.assertEquals(GroupsNumber, numberOfGroups);

    }

    public void assertNumberOfMyGroups(int numberOfGroups) {
        sleep(3000);
        int GroupsNumber = $$(byXpath("//div[@class='buddyup-group-item u_eh-100']")).size();
        Assert.assertEquals(GroupsNumber, numberOfGroups);

    }

    public void assertNumberOfMessInbox(int numberOfConver) {
        sleep(3000);

        int ConversNumber = $$(byXpath("//a[contains(@class, 'list-group-item u_nob-left u_nob-right')]")).size();
        Assert.assertEquals(ConversNumber, numberOfConver);

    }

    public void closePopupGroup(int indexGroup) {
        sleep(2000);
        $$(byXpath("//div[contains(@class,'modal fade in')]//div[@aria-label='Close']")).get(indexGroup).click();
    }

    public void closeCreateGroup() {
        sleep(2000);
        closePopup.click();
    }

    public void clickListingImgGroupCard() {
        $$(byXpath("//div[contains(@class,'container-max-940')]//div[@class='buddy-prop-info']//a/img")).get(0).click();
    }

    public void closeChooseYourFM() {
        sleep(2000);
        closePopup.click();
    }


    public void verifyNumberUser(int numberOfUser) {
        sleep(3000);
        int userNumber = $$(byXpath("//div[@class='buddyup-group-item u_eh-100']//li/a")).size();
        Assert.assertEquals(userNumber, numberOfUser);
    }

    public void postGroupButton() {
        sleep(2000);
        $(byXpath("//section//form[@id='create-buddy-up-form']//button[contains(.,'Post this group')]")).click();

    }

    public void postGroupButtonEdit() {
        sleep(2000);
        $(byXpath("(//div[contains(@class,'col-xs-12')]//button[contains(.,'Post this group')])[1]")).click();

    }

    public void arrowPopupNext() {
        sleep(3000);
        $(byXpath("//section//button[@class='owl-next']")).hover();
        $(byXpath("//section//button[@class='owl-next']")).click();
        sleep(2000);
    }

    public void arrowPopupPrevious() {

        $(byXpath("//section//button[@class='owl-prev']")).click();
        sleep(2000);
    }

    public void closePopupLookingGroup() {
        $(byXpath("//div[@id='interestedBuddyUpGroupModal']//div[@class='btn btn-sm close']")).click();
        sleep(2000);
    }

    public void approveMember() {
        $(byXpath("//div[@id='interestedBuddyUpGroupModal']//div[@class='btn btn-sm close']")).click();
        sleep(2000);
    }

    public void chat_MemberClick() {
        $(byXpath("//div[contains(@class,'onversation-header--group_')]")).click();
    }


    public void veryfNumberMember(int numberOfUsers) {
        int memberNumber = $$(byXpath("//div[@role='dialog']//li[contains(@class,'hunters-list--photos__modal--item')]")).size();
        Assert.assertEquals(memberNumber, numberOfUsers);
    }

    public void closeMemberPopup() {
        $(byXpath("//div[@class='modal-header']//button[@class='close']")).click();
    }

    public void minBudgetInput(String budget) {
        //$(byXpath("(//input[@id='buddyupgroup-max_price'])[2]")).click();
        fillInField(budget, $(byXpath("(//input[@id='buddyupgroup-max_price'])[2]")));
    }
    public void genderBuddy_up(final String gender) {
        $(byXpath("//div[@id='js-groups-list']//label[input[@name='BuddyupGroup[gender]' and @value='" + gender + "']]")).click();

    }
    public static void ageMin() {

        dragLow.dragAndDropTo($(byXpath("//div[@id='js-groups-list']//h3[contains(.,'Describe your ideal flatmates')]")));
        //dragLow.dragAndDropTo($(byXpath("//div/span[@class='text-14']")));
    }

    public static void ageMax() {

        dragUpper.dragAndDropTo($(byXpath("//div[@id='js-groups-list']//h3[contains(.,'Describe your ideal flatmates')]")));

    }

    public void addTextDescribe(String text) {
        $(byXpath("//div[@id='js-groups-list']//div/textarea")).sendKeys(text);
    }

    public void messageGroupVerif(final String ownerSays, final String secondFM, final String firstFM, final String thirdFM) {
        $(byXpath("//div[@id='message-list-container']//span[contains(.,'" + ownerSays + "')]")).should(Condition.exist);
        $(byXpath("//div[@id='message-list-container']//span[contains(.,'" + secondFM + "')]")).should(Condition.exist);
        $(byXpath("//div[@id='message-list-container']//span[contains(.,'" + firstFM + "')]")).should(Condition.exist);
        $(byXpath("//div[@id='message-list-container']//span[contains(.,'" + thirdFM + "')]")).should(Condition.exist);

    }

    public void clickPropImgChat() {
        $$(byXpath("//div[contains(@class, 'page-content main-content dashboard messages')]//a[@class='u_ed-inline-block messages-top-images--item']")).get(1).click();
    }

    public String minBudget() {
        String minBudget = $(byXpath("//div[@class='item'][strong[contains(.,'Min. budget per renter')]]/p")).text();
        //String moving = $(byXpath("//div[@class='item'][strong[contains(.,'TARGET MOVING DATE')]]/p")).text();
        return minBudget;

    }

    public String movingData() {
        //String minBudget = $(byXpath("//div[@class='item'][strong[contains(.,'Min. budget per renter')]]/p")).text();
        String movingData = $(byXpath("//div[@class='item'][strong[contains(.,'TARGET MOVING DATE')]]/p")).text();
        return movingData;

    }

    public void veryfyGroupEditData(String minBudget, String movingDate) {
        $(byXpath("(//dd[@class='text-bold text-11-xs'])[1]")).shouldHave(Condition.text(minBudget));
        $(byXpath("(//dd[@class='text-bold text-11-xs'])[2]")).shouldHave(Condition.text(movingDate));

    }


    public void groupPopupVerif(final String[] memberData) {

        List<String> inf = $$(byXpath("//div[@class='u_p10 group-modal-item']//li")).texts();
        List<String> expected = Arrays.asList(memberData);
        //List<String> memberData = Collections.singletonList(memberData1);
        Assert.assertEquals(inf, expected);
    }

    public void crumbsVerif(final String area) {
        $(byXpath("//ul[@class='custom-breadcrumbs']/li[contains(.,'" + area + "')]")).click();
    }

    public void genderBuddy_upGroupPageSelect(String gender) {
        $(byXpath("(//section[@class='modal-content']//label[input[@name='BuddyupGroup[gender]' and @value='"+gender+"']])[1]")).click();
    }
}
