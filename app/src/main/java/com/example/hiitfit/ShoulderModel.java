package com.example.hiitfit;

public class ShoulderModel {
    String Execution, ImageUrl , Instructions,Name,Category;



    public ShoulderModel() {
    }

    public ShoulderModel(String execution, String imageUrl, String instructions, String name,String category) {
        Execution = execution;
        ImageUrl = imageUrl;
        Instructions = instructions;
        Name = name;
        Category = category;
    }

    public String getCategory() {
        return Category;
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
    public void setCategory(String category) {
        Category = category;
    }
}
