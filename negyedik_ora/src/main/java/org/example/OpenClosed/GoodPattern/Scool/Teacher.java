package org.example.OpenClosed.GoodPattern.Scool;

public class Teacher extends User{

    public String getDashboard(){
        return "courseSubscribe, makeExam" + super.getDashboard();
    }
}
