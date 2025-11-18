/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloVO;

/**
 *
 * @author USUARIO
 */
public class UsuarioVO {
    private String id_usuario,nombre,correo,contrasena,fecha_registro;
   

    public UsuarioVO(String id_usuario, String nombre, String correo, String contrasena, String fecha_registro) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fecha_registro = fecha_registro;
    }
    
    public UsuarioVO() {
    // Constructor vacío necesario para el LoginServlet
    }

    // Constructor compatible con UsuarioDAO
    public UsuarioVO(String idUsuario, String usuario, String contrasena) {
        this.id_usuario = idUsuario;
        this.nombre = usuario;
        this.contrasena = contrasena;
    }
    
    public UsuarioVO(String id_usuario, String nombre, String correo, String contrasena) {
    this.id_usuario = id_usuario;
    this.nombre = nombre;
    this.correo = correo;
    this.contrasena = contrasena;
    }

    
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
}
