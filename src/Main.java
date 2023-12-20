import converter.Converter;
import models.Student;
import parser.Parser;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var str = Parser.parse("src/data/data.xlsx");
        ArrayList<Student> students = Converter.convert(str);
        for (Student student: students) {
            System.out.println(student.getEmail());
            System.out.println(student.getFirstName());
            System.out.println(student.getLastName());
            System.out.println(student.getGroup().getName());
            System.out.println(student.getUlearnID());
            System.out.println("\n");
        }
    }
}
