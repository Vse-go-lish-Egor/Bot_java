import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class SQL{
    public static String nameOfUser;
   public static String telephone;
   public static String dateOfEvent;
   public static String event;

    public static String getNameOfUser() {
        return nameOfUser;
    }

    public static String getTelephone() {
        return telephone;
    }

    public static String getDateOfEvent() {
        return dateOfEvent;
    }

    public static String getEvent() {
        return event;
    }

    public static void setNameOfUser(String nameOfUser) {
        SQL.nameOfUser = nameOfUser;
    }

    public static void setTelephone(String telephone) {
        SQL.telephone = telephone;
    }

    public static void setDateOfEvent(String dateOfEvent) {
        SQL.dateOfEvent = dateOfEvent;
    }

    public static void setEvent(String event) {
        SQL.event = event;
    }

    public static void parsToSQL() {
        try{
            String url = "jdbc:mysql://localhost/bot?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "StrongGrodno123";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT UserBook(UserName, Telphone,DateOfEvent,EventByDay ) VALUES (?, ?, ?, ? )";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, nameOfUser);
                preparedStatement.setString(2, telephone);
                preparedStatement.setString(3, dateOfEvent);
                preparedStatement.setString(4, event);

                int rows = preparedStatement.executeUpdate();

                System.out.printf("%d rows added", rows);


            }catch (Exception e){
                e.printStackTrace();
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}


