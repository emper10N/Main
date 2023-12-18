package converter;

import models.Group;
import models.Student;

import java.util.ArrayList;
import java.util.Objects;

public class Converter {

    public static Student getStudent(String row){
        var res = row.split("\\|");
        return new Student(res[0].split(" ")[0], res[0].split(" ")[1],
                new Group(res[3]), res[2], res[1]);
    }

    public static ArrayList<Integer> getBadIndex(String row){
        ArrayList<Integer> result = new ArrayList<>();
        var res = row.split("\\|");
        for (int i = 0; i < res.length; i++) {
            if(Objects.equals(res[i], "Акт") || Objects.equals(res[i], "Упр")
                    || Objects.equals(res[i], "ДЗ") || Objects.equals(res[i], "Сем")){
                result.add(i);
            }
        }
        return result;
    }
}
