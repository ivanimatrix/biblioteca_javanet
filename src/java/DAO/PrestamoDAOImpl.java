/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.PrestamoDTO;

/**
 *
 * @author ivanimatrix
 */
public class PrestamoDAOImpl implements PrestamoDAO{
    
    private Connection userConn;
	
    private final String SQL_INSERT = "INSERT INTO prestamos(id_prestamo, devolucion_prestamo, alumno_fk_prestamo, libro_fk_prestamo, estado_prestamo) VALUES(?,?,?,?,?)";

    private final String SQL_SELECT = "SELECT id_prestamo, devolucion_prestamo, alumno_fk_prestamo, libro_fk_prestamo, estado_prestamo FROM prestamos";
    
    private final String SQL_UPDATE = "UPDATE prestamos set devolucion_prestamo = ?, alumno_fk_prestamo = ?, libro_fk_prestamo = ?, estado_prestamo = ? where id_prestamo = ?";
    
    private final String SQL_DELETE = "delete from prestamos where id_prestamo = ?";

    private final String SQL_SELECT_BY_ID = "SELECT id_prestamo, devolucion_prestamo, alumno_fk_prestamo, libro_fk_prestamo, estado_prestamo FROM prestamos where id_prestamo = ? limit 1";

    private final String SQL_SELECT_BY_CODIGO_LIBRO = "SELECT id_prestamo, devolucion_prestamo, alumno_fk_prestamo, libro_fk_prestamo, estado_prestamo FROM prestamos where libro_fk_prestamo = ? and estado_prestamo = 1 limit 1";
    
    private final String SQL_SELECT_COUNT = "SELECT count(*) as total FROM prestamos ";

    public PrestamoDAOImpl() {
    }

    public PrestamoDAOImpl(Connection userConn) {
        this.userConn = userConn;
    }
    
    
    

    @Override
    public int insert(PrestamoDTO prestamo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, prestamo.getId_prestamo());
            stmt.setString(2, prestamo.getDevolucion_prestamo());
            stmt.setInt(3, prestamo.getAlumno_fk_prestamo());
            stmt.setInt(4, prestamo.getLibro_fk_prestamo());
            stmt.setInt(5, prestamo.getEstado_prestamo());
            
            rows = stmt.executeUpdate();

        }catch(SQLException e){
            rows = 0;
            System.out.println(e.getMessage());
        }
        finally{
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return rows;
    }

    @Override
    public int delete(int id_prestamo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_prestamo);
            
            rows = stmt.executeUpdate();

        }catch(SQLException e){
            rows = 0;
            System.out.println(e.getMessage());
        }
        finally{
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return rows;
    }

    @Override
    public int update(PrestamoDTO prestamo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, prestamo.getDevolucion_prestamo());
            stmt.setInt(2, prestamo.getAlumno_fk_prestamo());
            stmt.setInt(3, prestamo.getLibro_fk_prestamo());
            stmt.setInt(4, prestamo.getEstado_prestamo());
            stmt.setInt(5, prestamo.getId_prestamo());
            
            rows = stmt.executeUpdate();

        }catch(SQLException e){
            rows = 0;
            System.out.println(e.getMessage());
        }
        finally{
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return rows;
    }

    @Override
    public List<PrestamoDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PrestamoDTO prestamoDTO = null;
        List<PrestamoDTO> prestamos = new ArrayList<PrestamoDTO>();
        try{
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                prestamoDTO = new PrestamoDTO();
                prestamoDTO.setId_prestamo(rs.getInt("id_prestamo"));
                prestamoDTO.setDevolucion_prestamo(rs.getString("devolucion_prestamo"));
                prestamoDTO.setAlumno_fk_prestamo(rs.getInt("alumno_fk_prestamo"));
                prestamoDTO.setLibro_fk_prestamo(rs.getInt("libro_fk_prestamo"));
                prestamoDTO.setEstado_prestamo(rs.getInt("estado_prestamo"));

                prestamos.add(prestamoDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return prestamos;
    }

    @Override
    public PrestamoDTO selectById(int id_prestamo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PrestamoDTO prestamoDTO = null;
        try{
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id_prestamo);
            rs = stmt.executeQuery();
            while(rs.next()){
                prestamoDTO = new PrestamoDTO();
                prestamoDTO.setId_prestamo(rs.getInt("id_prestamo"));
                prestamoDTO.setDevolucion_prestamo(rs.getString("devolucion_prestamo"));
                prestamoDTO.setAlumno_fk_prestamo(rs.getInt("alumno_fk_prestamo"));
                prestamoDTO.setLibro_fk_prestamo(rs.getInt("libro_fk_prestamo"));
                prestamoDTO.setEstado_prestamo(rs.getInt("estado_prestamo"));

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return prestamoDTO;
    }

    @Override
    public PrestamoDTO selectByIdLibro(int id_libro) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PrestamoDTO prestamoDTO = null;
        try{
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_CODIGO_LIBRO);
            stmt.setInt(1, id_libro);
            rs = stmt.executeQuery();
            while(rs.next()){
                prestamoDTO = new PrestamoDTO();
                prestamoDTO.setId_prestamo(rs.getInt("id_prestamo"));
                prestamoDTO.setDevolucion_prestamo(rs.getString("devolucion_prestamo"));
                prestamoDTO.setAlumno_fk_prestamo(rs.getInt("alumno_fk_prestamo"));
                prestamoDTO.setLibro_fk_prestamo(rs.getInt("libro_fk_prestamo"));
                prestamoDTO.setEstado_prestamo(rs.getInt("estado_prestamo"));

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return prestamoDTO;
       
    }
    
    
    @Override
    public int contar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PrestamoDTO prestamoDTO = null;
        int total = 0;
        try{
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_COUNT);
            rs = stmt.executeQuery();
            while(rs.next()){
                total = rs.getInt("total");
            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return total;
    }
    
    
    
    
}
