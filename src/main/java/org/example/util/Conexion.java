
package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://127.0.0.1:3320/biblioteca";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "1234";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}










//
//package org.example.util;
//
//
//import java.sql.*;
//
//
//public class Conexion {
//    private static final String URL = "jdbc:mysql://127.0.0.1:3320/?user=root";
//    private static final String USUARIO = "root";
//    private static final String CONTRASENA = "1234";
//
//    public static Connection obtenerConexion() throws SQLException {
//        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
//    }
//}