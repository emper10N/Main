package converter;

import models.Exercise;
import models.Group;
import models.Section;
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
        for (int i = 7; i < res.length; i++) {
            if(!(Objects.equals(res[i], "Акт") || Objects.equals(res[i], "Упр")
                    || Objects.equals(res[i], "Сем"))){
                result.add(i);
            }
        }
        return result;
    }

    public static  ArrayList<String> getAllSections(String row){
        var res = row.split("\\|");
        ArrayList<String> result = new ArrayList<>();
        for (int i = 10; i < res.length; i++) {
            res[i].replace("\t", "");
            if (Objects.equals(res[i], "\t")){
                continue;
            }
            result.add(res[i]);
        }
        return result;
    }

    public static ArrayList<Student> convert(String parse){
        var res = parse.split("\n");
        var exercises = Converter.getBadIndex(res[1]);
        var sections = Converter.getAllSections(res[0]);
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 3; i < res.length; i++) {
            if ((res[i].split("\\|")[0].split(" ").length != 2) || (Objects.equals(res[i].split("\\|")[3], "\t"))){
                continue;
            }
            Student student = Converter.getStudent(res[i]);
            for (int j = 0; j < sections.size(); j++) {
                Section section = new Section(sections.get(j), Integer.toString(sections.get(j).hashCode()));
                for (int k = 0; k < exercises.size()-1; k++) {
                    String name = res[1].split("\\|")[exercises.get(k)];
                    String type = "WORK";
                    if (name.contains("ДЗ")){
                        type = "HOMEWORK";
                    }
                    Exercise exercise = new Exercise(name ,Integer.toString(name.hashCode()),
                            Double.parseDouble(res[i].split("\\|")[exercises.get(k)]), type);
                    section.addExercise(exercise);
                }
                student.addSection(section);
            }
            students.add(student);
        }
        return students;
    }
}
