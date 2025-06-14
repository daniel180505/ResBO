package conexion;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/restuu12";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e);
            return null;
        }
    }
}
