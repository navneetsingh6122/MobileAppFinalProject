package com.example.hiitfit;

public class users {
    private String fName, email,LastExercise,LastDate,  BMI;

    public users()
    {
        //empty constructor needed
    }

    public users(String fName, String email, String lastExercise, String lastDate, String BMI) {
        this.fName = fName;
        this.email = email;
        LastExercise = lastExercise;
        LastDate = lastDate;
        this.BMI = BMI;
    }

    public String getBMI() {
        return BMI;
    }

    public String getLastExercise() {
        return LastExercise;
    }

    public String getLastDate() {
        return LastDate;
    }

    public String getfName() {
        return fName;
    }

    public String getEmail() {
        return email;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastExercise(String lastExercise) {
        LastExercise = lastExercise;
    }

    public void setLastDate(String lastDate) {
        LastDate = lastDate;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }
}
