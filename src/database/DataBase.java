package database;

import models.Exercise;
import models.Section;
import models.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "Z4739n890";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";


    public static void connect(Student student) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_TASK1 = "INSERT INTO Student (ulearnID, email, firstName, lastName, studentgroup)" +
                "VALUES ('"+student.getUlearnID()+"','"+ student.getEmail() +"', '"+student.getFirstName() +"','" +student.getLastName() +"', '"+student.getGroup().name()+"');";
        statement.executeUpdate(SQL_SELECT_TASK1);
        for (Section section: student.getSections()) {
            String SQL_SELECT_TASK2 = "INSERT INTO Section (id, name)" +
                    "VALUES ('"+ section.getId() +"', '"+ section.getName() +"');" +
                    "INSERT INTO StudentSection (studentUlearnID, sectionID) " +
                    "VALUES ('"+student.getUlearnID()+"', '"+ section.getId() +"');";
            statement.executeUpdate(SQL_SELECT_TASK2);
            for (Exercise exercise: section.getExercises()) {
                String  SQL_SELECT_TASK3 = "INSERT INTO Exercise (id, name, points, type)" +
                        "VALUES ('"+exercise.id+"', '"+exercise.name+"', '"+exercise.points.intValue()+"', '"+exercise.type+"');"+
                        "INSERT INTO SectionExercise (sectionID, exerciseID)" +
                        "VALUES ('"+ section.getId() +"', '"+exercise.id+"');";
                statement.executeUpdate(SQL_SELECT_TASK3);
            }
        }
        connection.close();
    }
}
