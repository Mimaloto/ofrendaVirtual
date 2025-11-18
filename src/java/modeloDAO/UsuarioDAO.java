/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modeloVO.UsuarioVO;
import util.Conexion;

public class UsuarioDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    private UsuarioVO vo; // VO opcional para insertar/editar/eliminar

    // Constructor vacío (se usa para login)
    public UsuarioDAO() {
        con = new Conexion().getConexion();
    }

    // Constructor con VO (para registrar, actualizar, eliminar)
    public UsuarioDAO(UsuarioVO vo) {
        this.vo = vo;
        con = new Conexion().getConexion();
    }

    // ---------------------------------------------------------
    // 1. REGISTRAR USUARIO
    // ---------------------------------------------------------
    public boolean agregarUsuario() {
        try {
            sql = "INSERT INTO usuarios (nombre, correo, contrasena) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setString(2, vo.getCorreo());
            ps.setString(3, vo.getContrasena());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error agregando usuario: " + e.getMessage());
            return false;
        }
    }

    // ---------------------------------------------------------
    // 2. ACTUALIZAR USUARIO
    // ---------------------------------------------------------
    public boolean actualizarUsuario() {
        try {
            sql = "UPDATE usuarios SET nombre = ?, correo = ?, clave = ? WHERE idUsuario = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setString(2, vo.getCorreo());
            ps.setString(3, vo.getContrasena());
            ps.setString(4, vo.getFecha_registro());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error actualizando usuario: " + e.getMessage());
            return false;
        }
    }

    // ---------------------------------------------------------
    // 3. ELIMINAR USUARIO
    // ---------------------------------------------------------
    public boolean eliminarUsuario() {
        try {
            sql = "DELETE FROM usuarios WHERE nombre = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getNombre());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error eliminando usuario: " + e.getMessage());
            return false;
        }
    }

    // ---------------------------------------------------------
    // 4. VALIDAR LOGIN (usuario + clave)
    // ---------------------------------------------------------
    public boolean validarLogin(String usuario, String contrasena) {
        try {
            sql = "SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);

            rs = ps.executeQuery();
            return rs.next(); // Si encontró un usuario → true

        } catch (Exception e) {
            System.out.println("Error en validarLogin: " + e.getMessage());
            return false;
        }
    }

    // ---------------------------------------------------------
    // 5. INICIAR SESIÓN (correo + clave) — Devuelve un UsuarioVO
    // ---------------------------------------------------------
    public UsuarioVO iniciarSesion(String correo, String contrasena) {
        UsuarioVO usuario = null;

        try {
            sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasena);

            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new UsuarioVO(
                    rs.getString("idUsuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasena")
                        
                );
            }

        } catch (Exception e) {
            System.out.println("Error en iniciarSesion: " + e.getMessage());
        }

        return usuario; // puede ser null si no existe
    }
}






