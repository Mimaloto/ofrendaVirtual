/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloDAO.UsuarioDAO;
import modeloVO.UsuarioVO;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Leer y normalizar entrada
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        // DEBUG: imprime lo que llega desde el formulario (mira la consola del servidor)
        System.out.println("DEBUG LoginServlet - correo raw: '" + correo + "'");
        System.out.println("DEBUG LoginServlet - contrasena raw: '" + contrasena + "'");

        if (correo != null) correo = correo.trim();
        if (contrasena != null) contrasena = contrasena.trim();

        System.out.println("DEBUG LoginServlet - correo trimmed: '" + correo + "'");
        System.out.println("DEBUG LoginServlet - contrasena trimmed: '" + contrasena + "'");

        UsuarioDAO dao = new UsuarioDAO(new UsuarioVO());
        UsuarioVO usuario = dao.iniciarSesion(correo, contrasena);

        if (usuario != null) {
            request.getSession().setAttribute("usuario", usuario);
            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("mensaje", "Usuario no registrado ¿Desea registrarse?");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

