package org.example.OpenClosed.GoodPattern.Scool;

import org.example.OpenClosed.BadPattern.User;

public class Student extends User {
    public Student(String role) {
        super(role);
    }
    public String getDashboard(){
        return "courseSubscribe, takeExam" + super.getDashboard();
    }
}
