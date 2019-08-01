package uk.co.idealflatmate.appmanager;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class PopUpHelper {

    public String closeAdvPopup = "//div[@id='signupNeedspaceModal']//button[@aria-label='Close']";
    public String closeRenewPopup = "//section[@class='modal-content u_bg-gray-lighter']//button[@aria-label='Close']";
    public String closeMatching = "//button[@class='btn btn-sm btn-close close js-close-notify-matching']";



}
