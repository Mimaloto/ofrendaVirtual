/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String driver, user, password, database, url, port;
    private Connection conexion;

    public Conexion() {

        driver = "com.mysql.cj.jdbc.Driver";
        user = "root";
        password = "";
        database = "ofrendavirtual";
        port = "3307";
        url = "jdbc:mysql://localhost:" + port + "/" + database 
                + "?useSSL=false&serverTimezone=UTC";

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conexión a MySQL exitosa");

        } catch (Exception e) {
            System.out.println("❌ Error conectando a MySQL: " + e.getMessage());
        }
    }

    // Getter para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }
    public Connection cerrarConexion() throws SQLException {
        conexion.close();
        conexion=null;
        return conexion;
    }
}

