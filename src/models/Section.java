package models;
import java.util.ArrayList;

public class Section {
    private final String name;
    private final String id;
    private ArrayList<Exercise> exercises;

    public Section(String name, String id){
        this.id = id;
        this.name = name;
    }
}
