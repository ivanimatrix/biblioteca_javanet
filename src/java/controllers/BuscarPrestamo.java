/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.AlumnoDAOImpl;
import DAO.LibroDAOImpl;
import DAO.PrestamoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.AlumnoDTO;
import models.LibroDTO;
import models.PrestamoDTO;

/**
 *
 * @author ivanimatrix
 */
public class BuscarPrestamo extends HttpServlet {

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
            out.println("<title>Servlet BuscarPrestamo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuscarPrestamo at " + request.getContextPath() + "</h1>");
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
        
        String codigo_libro = request.getParameter("codigo");
        
        LibroDTO libro = new LibroDTO();
        AlumnoDTO alumno = new AlumnoDTO();
        PrestamoDTO prestamo = new PrestamoDTO();
        
        LibroDAOImpl libroDAO = new LibroDAOImpl();
        AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl();
        PrestamoDAOImpl prestamoDAO = new PrestamoDAOImpl();
        
        boolean estado = false;
        String mensaje = "";
        
        /* buscar libro para obtener id */
        int id_libro = 0;
        try{
            libro = libroDAO.selectByCodigo(codigo_libro);
            prestamo = prestamoDAO.selectByIdLibro(libro.getId_libro());
        }catch(SQLException e){
            System.out.println("Error SQL " + e.getMessage());
            estado = false;
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        
        
        if(prestamo == null){
            estado = false;
            mensaje = "No existen registro de prestamo del libro";
            String respuesta = "{\"estado\":"+estado+", \"mensaje\":\""+mensaje+"\"}";
            out.println(respuesta);
        }else{
            estado = true;
            String respuesta = "";
            try{
                libro = libroDAO.selectById(prestamo.getLibro_fk_prestamo());
            
                alumno = alumnoDAO.selectById(prestamo.getAlumno_fk_prestamo());
                
                respuesta = "{\"estado\":"+estado+", \"descripcion\":\""+libro.getDescripcion_libro()+"\", \"nombres\":\""+alumno.getNombres_alumno()+"\", \"apellidos\":\""+alumno.getApellidos_alumno()+"\",\"id_prestamo\":\""+prestamo.getId_prestamo()+"\", \"fecha_entrega\":\""+prestamo.getDevolucion_prestamo()+"\", \"rut\":\""+alumno.getRut_alumno()+"\"}";
                
            }catch(SQLException e){
                estado = false;
                mensaje = "Error en consulta SQL";
                respuesta = "{\"estado\":"+estado+", \"mensaje\":\""+mensaje+"\"}";
            }
            
            out.println(respuesta);
        }
        
        
        
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
