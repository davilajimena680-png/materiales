package utng.gtid.jdj.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Cambia estos datos si tu configuración es diferente
    private static final String URL = "jdbc:postgresql://localhost:5432/materialesdb";
    private static final String USUARIO = "admin";
    private static final String PASSWORD = "admin";

    private static Connection conexion;

    public static Connection getConexion() {

        try {

            if (conexion == null || conexion.isClosed()) {

                Class.forName("org.postgresql.Driver");

                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);

                System.out.println("Conexión exitosa a PostgreSQL");

            }

        } catch (ClassNotFoundException e) {

            System.out.println("No se encontró el Driver PostgreSQL");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();

        }

        return conexion;
    }

    public static void cerrarConexion() {

        try {

            if (conexion != null && !conexion.isClosed()) {

                conexion.close();
                System.out.println("Conexión cerrada");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
