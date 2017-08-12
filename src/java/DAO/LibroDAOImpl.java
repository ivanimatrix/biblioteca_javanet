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
import models.LibroDTO;

/**
 *
 * @author ivanimatrix
 */
public class LibroDAOImpl implements LibroDAO {
    
    private Connection userConn;
	
    private final String SQL_INSERT = "INSERT INTO libros(codigo_libro, descripcion_libro, cantidad_libro, ingreso_libro, genero_fk_libro) VALUES(?,?,?,?,?)";

    private final String SQL_SELECT = "SELECT id_libro, codigo_libro, descripcion_libro, cantidad_libro, ingreso_libro, genero_fk_libro FROM libros";
    
    private final String SQL_UPDATE = "UPDATE libros set codigo_libro = ?, descripcion_libro = ?, cantidad_libro = ?, ingreso_libro = ?, genero_fk_libro = ? where id_libro = ?";
    
    private final String SQL_DELETE = "delete from libros where id_libro = ?";

    private final String SQL_SELECT_BY_ID = "SELECT id_libro, codigo_libro, descripcion_libro, cantidad_libro, ingreso_libro, genero_fk_libro FROM libros where id_libro = ? limit 1";

    private final String SQL_SELECT_BY_CODIGO = "SELECT id_libro, codigo_libro, descripcion_libro, cantidad_libro, ingreso_libro, genero_fk_libro FROM libros where codigo_libro = ? limit 1";

    
    public LibroDAOImpl() {
    }

    
    
    public LibroDAOImpl(Connection userConn) {
        this.userConn = userConn;
    }

    @Override
    public int insert(LibroDTO libro) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, libro.getCodigo_libro());
            stmt.setString(2, libro.getDescripcion_libro());
            stmt.setInt(3, libro.getCantidad_libro());
            stmt.setString(4, libro.getIngreso_libro());
            stmt.setInt(5, libro.getGenero_fk_libro());
            
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
    public int delete(int id_libro) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_libro);
            
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
    public int update(LibroDTO libro) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, libro.getCodigo_libro());
            stmt.setString(2, libro.getDescripcion_libro());
            stmt.setInt(3, libro.getCantidad_libro());
            stmt.setString(4, libro.getIngreso_libro());
            stmt.setInt(5, libro.getGenero_fk_libro());
            stmt.setInt(6, libro.getId_libro());
            
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
    public List<LibroDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        LibroDTO libroDTO = null;
        List<LibroDTO> libros = new ArrayList<LibroDTO>();
        try{
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                libroDTO = new LibroDTO();
                libroDTO.setId_libro(rs.getInt("id_libro"));
                libroDTO.setCodigo_libro(rs.getString("codigo_libro"));
                libroDTO.setDescripcion_libro(rs.getString("descripcion_libro"));
                libroDTO.setCantidad_libro(rs.getInt("cantidad_libro"));
                libroDTO.setIngreso_libro(rs.getString("ingreso_libro"));
                libroDTO.setGenero_fk_libro(rs.getInt("genero_fk_libro"));

                libros.add(libroDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return libros;
    }

    @Override
    public LibroDTO selectById(int id_libro) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        LibroDTO libroDTO = null;
        
        try{
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id_libro);
            rs = stmt.executeQuery();
            while(rs.next()){
                libroDTO = new LibroDTO();
                libroDTO.setId_libro(rs.getInt("id_libro"));
                libroDTO.setCodigo_libro(rs.getString("codigo_libro"));
                libroDTO.setDescripcion_libro(rs.getString("descripcion_libro"));
                libroDTO.setCantidad_libro(rs.getInt("cantidad_libro"));
                libroDTO.setIngreso_libro(rs.getString("ingreso_libro"));
                libroDTO.setGenero_fk_libro(rs.getInt("genero_fk_libro"));

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return libroDTO;
    }

    @Override
    public LibroDTO selectByCodigo(String codigo_libro) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        LibroDTO libroDTO = null;
        
        try{
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_CODIGO);
            stmt.setString(1, codigo_libro);
            rs = stmt.executeQuery();
            while(rs.next()){
                libroDTO = new LibroDTO();
                libroDTO.setId_libro(rs.getInt("id_libro"));
                libroDTO.setCodigo_libro(rs.getString("codigo_libro"));
                libroDTO.setDescripcion_libro(rs.getString("descripcion_libro"));
                libroDTO.setCantidad_libro(rs.getInt("cantidad_libro"));
                libroDTO.setIngreso_libro(rs.getString("ingreso_libro"));
                libroDTO.setGenero_fk_libro(rs.getInt("genero_fk_libro"));

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return libroDTO;
    }
    
}
