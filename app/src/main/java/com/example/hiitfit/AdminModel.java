package com.example.hiitfit;

public class AdminModel {
    String Execution, ImageUrl , Instructions , Name;

    public AdminModel() {
    }

    public AdminModel(String execution, String imageurl, String instructions, String name) {
        Execution = execution;
        ImageUrl = imageurl;
        Instructions = instructions;
        Name = name;
    }

    public String getExecution() {
        return Execution;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getInstructions() {
        return Instructions;
    }

    public String getName() {
        return Name;
    }

    public void setExecution(String execution) {
        Execution = execution;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public void setInstructions(String instructions) {
        Instructions = instructions;
    }

    public void setName(String name) {
        Name = name;
    }
}
