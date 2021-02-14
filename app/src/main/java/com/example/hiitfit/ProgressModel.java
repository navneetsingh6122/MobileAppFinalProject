package com.example.hiitfit;

public class ProgressModel {
String Name,Duration,Category,ExerciseName,DateAndTime;

    public ProgressModel() {
    }

    public ProgressModel(String name, String duration, String category, String exerciseName, String dateAndTime) {
        Name = name;
        Duration = duration;
        Category = category;
        ExerciseName = exerciseName;
        DateAndTime = dateAndTime;
    }

    public String getName() {
        return Name;
    }

    public String getDuration() {
        return Duration;
    }

    public String getCategory() {
        return Category;
    }

    public String getExerciseName() {
        return ExerciseName;
    }

    public String getDateAndTime() {
        return DateAndTime;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setExerciseName(String exerciseName) {
        ExerciseName = exerciseName;
    }

    public void setDateAndTime(String dateAndTime) {
        DateAndTime = dateAndTime;
    }
}
