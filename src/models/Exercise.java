package models;

public class Exercise {
    public final String name;
    public final String id;
    public Integer points;
    public final Integer maxPoints;

    public Exercise(String name, Integer maxPoints, String id){
         this.name = name;
         this.maxPoints = maxPoints;
         this.id = id;
    }


}
