/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DonacionesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");

        if ("registrar".equals(accion)) {
            registrarDonacion(request, response);
        }
    }

    private void registrarDonacion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String monto = request.getParameter("monto");
    String descripcion = request.getParameter("descripcion");

    // Aquí más adelante pondrás tu lógica con DAO para guardar la donación

    System.out.println("Monto recibido: " + monto);
    System.out.println("Descripción recibida: " + descripcion);

    // Redirigir de vuelta al JSP con mensaje de éxito
    response.sendRedirect("realizarDonaciones.jsp?exito=1");
}

}

