package models;
import java.util.ArrayList;

public class Section {
    private final String name;
    private final String id;
    private ArrayList<Exercise> exercises = new ArrayList<>();

    public Section(String name, String id){
        this.id = id;
        this.name = name;
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }

    public String getName() { return name; }
    public String getId() { return id; }
}
