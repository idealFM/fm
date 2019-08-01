package uk.co.idealflatmate.appmanager;

import utils.ConfDataProperty;

public class ProfileData {
    private final String percentComplete;
    private final String myProfile;
    private final String name;
    private final String age;
    private final String lookingFor;
    private final String aboutMe;
    private final String roomsLocation;
    private final String amountPropertiesCard;

    public ProfileData(String percentComplete, String myProfile, String name, String age, String lookingFor, String aboutMe, String roomsLocation, String amountPropertiesCard) {
        this.percentComplete = percentComplete;
        this.myProfile = myProfile;
        this.name = name;
        this.age = age;
        this.lookingFor = lookingFor;
        this.aboutMe = aboutMe;
        this.roomsLocation = roomsLocation;
        this.amountPropertiesCard = amountPropertiesCard;
    }

    public String getPercentComplete() {
        return ConfDataProperty.getData(percentComplete);
    }

    public String getMyProfile() {
        return ConfDataProperty.getData(myProfile);
    }

    public String getName() {
        return ConfDataProperty.getData(name);
    }

    public String getAge() {
        return ConfDataProperty.getData(age);
    }

    public String getLookingFor() {
        return ConfDataProperty.getData(lookingFor);
    }

    public String getAboutMe() {
        return ConfDataProperty.getData(aboutMe);
    }

    public String getRoomsLocation() {
        return ConfDataProperty.getData(roomsLocation);
    }

    public String getAmountPropertiesCard() {
        return ConfDataProperty.getData(amountPropertiesCard);
    }
}


