package com.example.attendencebook;

import java.io.Serializable;

public class Student implements Serializable{
    private String name;
    private boolean isPresent;

    public Student(String name, boolean isPresent) {
        this.name = name;
        this.isPresent = isPresent;
    }

    public String getName() {
        return name;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
