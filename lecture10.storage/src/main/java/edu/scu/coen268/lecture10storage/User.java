package edu.scu.coen268.lecture10storage;

public class User {
    private int age;
    private String name;

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public long getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

