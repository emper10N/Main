import converter.Converter;
import parser.Parser;

public class Main {
    public static void main(String[] args) {
        var str = Parser.parse("src/data/data.xlsx");
        System.out.println(str);
        var res = str.split("\n")[23];
        System.out.println(Converter.getStudent(res).getGroup().getName());
        var test = str.split("\n")[1];
        System.out.println(Converter.getBadIndex(test));
        var sections = str.split("\n")[0];
        System.out.println(Converter.getAllSections(sections));
    }
}
