package com.example.kca_student_app.StudentModel;

public class StudentModel {
    String FirstName;
    String LastName;
    String image;

    public StudentModel() {
    }

    public StudentModel(String firstName, String lastName, String image) {
        FirstName = firstName;
        LastName = lastName;
        this.image = image;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public  String getFirstName(){
        return FirstName;
    }

    public  void setFirstName(String firstName){
        FirstName = firstName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
