/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import modeloVO.UsuarioVO;
import modeloDAO.UsuarioDAO;

public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {

            case "registrar":
                agregarUsuario(request, response);
                break;

            case "actualizar":
                actualizarUsuario(request, response);
                break;

            case "eliminar":
                eliminarUsuario(request, response);
                break;
                
            case "login":
                String user = request.getParameter("usuario");
                String pass = request.getParameter("contrasena");

                UsuarioDAO udao = new UsuarioDAO();

                if (udao.validarLogin(user, pass)) {
                    request.getRequestDispatcher("realizarDonaciones.jsp")
                           .forward(request, response);
                } else {
                    response.sendRedirect("login.jsp?error=1");
                }
                break;



        }
    }

    private void agregarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("cntrasena");

        UsuarioVO vo = new UsuarioVO("0", nombre, correo, contrasena, null);
        UsuarioDAO dao = new UsuarioDAO(vo);

        if (dao.agregarUsuario()) {
            request.setAttribute("mensaje", "Usuario agregado correctamente");
        } else {
            request.setAttribute("mensaje", "Error al agregar usuario");
        }
        System.out.println("== ENTRO A agregarUsuario ==");


        request.getRequestDispatcher("registrar.jsp").forward(request, response);
    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        UsuarioVO vo = new UsuarioVO("0", nombre, correo, contrasena, null);
        UsuarioDAO dao = new UsuarioDAO(vo);

        if (dao.actualizarUsuario()) {
            request.setAttribute("mensaje", "Usuario actualizado correctamente");
        } else {
            request.setAttribute("mensaje", "Error al actualizar");
        }

        request.getRequestDispatcher("editar.jsp").forward(request, response);
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        UsuarioVO vo = new UsuarioVO("", "", "", "", "");
        UsuarioDAO dao = new UsuarioDAO(vo);

        if (dao.eliminarUsuario()) {
            request.setAttribute("mensaje", "Usuario eliminado correctamente");
        } else {
            request.setAttribute("mensaje", "Error al eliminar");
        }

        request.getRequestDispatcher("listar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }
}

