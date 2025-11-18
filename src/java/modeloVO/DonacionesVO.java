/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloVO;

/**
 *
 * @author USUARIO
 */
public class DonacionesVO {
  

    private int id_donacion;
    private int id_usuario;
    private double monto;
    private String metodo_pago;
    private String fecha_donacion;
    private String referencia_pago;

    // --- Constructor vacío ---
    public DonacionesVO() {
    }

    // --- Constructor completo ---
    public DonacionesVO(int idDonacion, int idUsuario, double monto, String fecha, 
            String descripcion, String metodo_pago) {
        this.id_donacion = id_donacion;
        this.id_usuario = id_usuario;
        this.monto = monto;
        this.metodo_pago= metodo_pago;
        this.fecha_donacion = fecha_donacion;
        this.referencia_pago = referencia_pago;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    // --- Getters & Setters ---

    public int getIdDonacion() {
        return id_donacion;
    }

    public void setIdDonacion(int idDonacion) {
        this.id_donacion = idDonacion;
    }

    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.id_usuario = id_usuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha_donacion;
    }

    public void setFecha(String fecha) {
        this.fecha_donacion = fecha_donacion;
    }

    public String getDescripcion() {
        return referencia_pago;
    }

    public void setDescripcion(String descripcion) {
        this.referencia_pago = referencia_pago;
    }

}


