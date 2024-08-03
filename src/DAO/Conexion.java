package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexion {
    protected Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/personal_iud";
    private final String USER = "root";
    private final String PASS = "";
    
   public Connection conectar() {
    try {
        if (conexion == null || conexion.isClosed()) {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        return conexion;
    } catch (SQLException | ClassNotFoundException e) {
        return null; 
    }
}

    
    public void cerrar() {
    try {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    } catch (SQLException e) {
    }
}

}
