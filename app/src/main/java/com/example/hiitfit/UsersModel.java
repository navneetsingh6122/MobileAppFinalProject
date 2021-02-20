package com.example.hiitfit;

public class UsersModel {

    String fName;
String ProfileImageUrl;
    public UsersModel() {
    }

    public UsersModel(String fName, String profileImageUrl) {
        this.fName = fName;
        ProfileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrl() {
        return ProfileImageUrl;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        ProfileImageUrl = profileImageUrl;
    }
}
