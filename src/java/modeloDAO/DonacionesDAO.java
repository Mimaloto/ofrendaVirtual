/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Conexion;
import util.CrudDonaciones;
import modeloVO.DonacionesVO;

public class DonacionesDAO extends Conexion implements CrudDonaciones {

    private Connection con;
    private PreparedStatement ps;
    private boolean operacion = false;
    private String sql;

    private DonacionesVO vo;

    public DonacionesDAO(DonacionesVO vo) {
        super();
        try {
            con = this.getConexion();
            this.vo = vo;
        } catch (Exception e) {
            System.out.println("Error DAO Donación: " + e.toString());
        }
    }

    @Override
    public boolean registrarDonacion() {
        try {
            sql = "INSERT INTO donaciones (idUsuario, monto, fecha) VALUES (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, vo.getIdUsuario());
            ps.setDouble(2, vo.getMonto());
            ps.setString(3, vo.getFecha());
            ps.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            System.out.println("Error al registrar donación: " + e.toString());
        }
        return operacion;
    }

    @Override
    public boolean actualizarDonacion() {
        return false; // si lo necesitas lo implementamos
    }

    @Override
    public boolean eliminarDonacion() {
        return false; // si lo necesitas lo implementamos
    }
}



