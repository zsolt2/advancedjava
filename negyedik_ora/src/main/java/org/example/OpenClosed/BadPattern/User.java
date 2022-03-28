package org.example.OpenClosed.BadPattern;

public class User {
    String role;
    public User(String role){
        this.role = role;
    }
    public void login(){
        System.out.println("User login");
    }
    public void logout(){
        System.out.println("User logount");
    }
    public String getDashboard(){
        String dasboardContent="";
        if("student".equals(this.role)){
            dasboardContent = "courseSubscribe, takeexam, listcourses";
        } else if ("teacher".equals(this.role)){
            dasboardContent = "courseSubscribe, makeexam, listcourses";
        }
        return dasboardContent;
    }
}
