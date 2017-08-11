/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.UsuarioDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UsuarioDTO;

/**
 *
 * @author ivanimatrix
 */
public class RegistrarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String pass = request.getParameter("clave");

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        
        String mensaje = "Hubo un problema al registrarse. Intente nuevamente";
        boolean estado = false;
        
        UsuarioDTO usuario = new UsuarioDTO(rut, pass, nombres, apellidos);
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        
        try{
            usuarioDAO.insert(usuario);
            estado = true;
            mensaje = "Registro correcto. Ahora puede ingresar al sistema con su rut y contraseña";
        }catch(SQLException e){
            System.out.println("Error SQL : " + e.getMessage());
        }
        

        String respuesta = "{\"estado\":" + estado + ", \"mensaje\":\"" + mensaje + "\"}";
        
        out.println(respuesta);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
