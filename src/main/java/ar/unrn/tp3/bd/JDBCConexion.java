package ar.unrn.tp3.bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConexion {

    public Connection crearConexionConBaseDeDatos() throws SQLException {

        return (DriverManager.getConnection(
                "jdbc:derby://localhost:1527/participantes",
                "app", "app"));
    }

}