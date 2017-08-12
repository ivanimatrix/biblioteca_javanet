/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.AlumnoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.AlumnoDTO;

/**
 *
 * @author ivanimatrix
 */
public class GuardarAlumno extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GuardarAlumno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GuardarAlumno at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
       
        int id = Integer.parseInt(request.getParameter("id_alumno"));
        String rut = request.getParameter("rut");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String fecha_nacimiento = request.getParameter("fecha_nacimiento");
        String sexo = request.getParameter("sexo");
        String direccion = request.getParameter("direccion");
        
        /*String[] fecha = fecha_nacimiento.split("/");
        fecha_nacimiento = fecha[2] + "-" + fecha[1] + "-" + fecha[0];*/
        
        boolean estado = false;
        String mensaje = "";
        
        AlumnoDTO alumno = new AlumnoDTO(id, rut, nombres, apellidos, sexo, fecha_nacimiento, direccion);
        AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl();
        
        if(id > 0){
            try{
                if(alumnoDAO.update(alumno) > 0){
                    estado = true;
                    mensaje = "Datos del alumno actualizados";
                }else{
                    mensaje = "Hubo un problema al actualizar los datos. Intente nuevamente";
                }
            }catch(SQLException e){
                System.out.println("Error actualizacion nuevo alumno");
                mensaje = "Error en actualizacion";
            }
        }else{
            try{
                if(alumnoDAO.insert(alumno) > 0){
                    estado = true;
                    mensaje = "Datos del alumno guardados";
                }else{
                    mensaje = "Hubo un problema al guardar los datos. Intente nuevamente";
                }
            }catch(SQLException e){
                System.out.println("Error insercion nuevo alumno");
                mensaje = "Error en insercion";
            }
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        
        String respuesta = "{\"estado\":"+estado+", \"mensaje\":\""+mensaje+"\"}";
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
