package models;

import java.util.ArrayList;

public class Student {
    private final String ulearnID;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final Group group;
    private ArrayList<Section> course = new ArrayList<>();

    public Student(String firstName, String lastName, Group group, String email, String ulearnID) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.ulearnID = ulearnID;
    }

    public String getUlearnID(){ return ulearnID; }
    public String getEmail(){ return email; }
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public Group getGroup(){ return group; }
    public void addSection(Section section){
        course.add(section);
    }
    public ArrayList<Section> getSections() { return course; }
}
