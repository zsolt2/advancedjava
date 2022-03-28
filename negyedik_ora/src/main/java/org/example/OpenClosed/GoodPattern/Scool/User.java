package org.example.OpenClosed.GoodPattern.Scool;

public abstract class User {
    public void login(){
        System.out.println("login");
    };
    public void logout(){
        System.out.println("logout");
    };
    public String getDashboard(){
        return "ListCourses";
    }
}
