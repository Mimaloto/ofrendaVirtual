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

        // Aquí va tu lógica del DAO
        response.getWriter().println("OK Donación registrada");
    }
}

