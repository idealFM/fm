package uk.co.idealflatmate.appmanager;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PropertyData {
    private final String cardProp_id;



    public PropertyData(String cardProp_Image) {
        this.cardProp_id = cardProp_Image;


    }

    public String getCardProp_Image() {
        return cardProp_id;
    }



}
