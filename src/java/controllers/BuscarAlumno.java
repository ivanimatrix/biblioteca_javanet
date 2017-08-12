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
public class BuscarAlumno extends HttpServlet {

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
            out.println("<title>Servlet BuscarAlumno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuscarAlumno at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        
        AlumnoDTO alumno = new AlumnoDTO();
        AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl();
        
        boolean estado = false;
        String respuesta = "";
        
        try{
            alumno = alumnoDAO.selectByRut(rut);
        
            if(alumno != null){
                String[] fecha = alumno.getNacimiento_alumno().split("-");
                String fecha_nacimiento = fecha[2] + "/" + fecha[1] + "/" + fecha[0];
                respuesta = "{\"estado\":" + true + ", \"id\":\"" + alumno.getId_alumno() + "\", \"nombres\":\"" + alumno.getNombres_alumno()+ "\", \"apellidos\":\"" + alumno.getApellidos_alumno()+ "\", \"fecha_nacimiento\":\""+alumno.getNacimiento_alumno()+"\", \"sexo\":\""+alumno.getSexo_alumno()+"\", \"direccion\":\""+alumno.getDireccion_alumno()+"\"}";
            }else{
                respuesta = "{\"estado\":" + false + "}";
            }
        } catch (SQLException e){
            System.out.println("Error SQL " + e.getMessage());
            respuesta = "{\"estado\":" + false + "}";
        }
        
        
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        
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
