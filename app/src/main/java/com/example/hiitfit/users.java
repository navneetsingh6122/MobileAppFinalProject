package com.example.hiitfit;

public class users {
    private String title, email;
    private int priority;

    public users()
    {
        //empty constructor needed
    }

    public users(String title, String email, int priority)
    {
        this.title = title;
        this.email = email;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public int getPriority() {
        return priority;
    }
}
