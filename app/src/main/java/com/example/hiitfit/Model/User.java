package com.example.hiitfit.Model;

public class User {

    String email,fName,id,profileImageUrl,isUser;

    public User() {
    }

    public User(String email, String fName, String id, String profileImageUrl, String isUser) {
        this.email = email;
        this.fName = fName;
        this.id = id;
        this.profileImageUrl = profileImageUrl;
        this.isUser = isUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getIsUser() {
        return isUser;
    }

    public void setIsUser(String isUser) {
        this.isUser = isUser;
    }
}
