package com.example.hiitfit;

public class users {
    private String fName, email;

    public users()
    {
        //empty constructor needed
    }

    public users(String fName, String email)
    {
        this.fName = fName;
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public String getEmail() {
        return email;
    }
}
