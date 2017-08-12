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
import models.AlumnoDTO;

/**
 *
 * @author ivanimatrix
 */
public class AlumnoDAOImpl implements AlumnoDAO {
    
    private Connection userConn;
	
    private final String SQL_INSERT = "INSERT INTO alumnos(rut_alumno, nombres_alumno, apellidos_alumno, nacimiento_alumno, sexo_alumno, direccion_alumno) VALUES(?,?,?,?,?,?)";

    private final String SQL_SELECT = "SELECT id_alumno, rut_alumno, nombres_alumno, apellidos_alumno, nacimiento_alumno, sexo_alumno, direccion_alumno FROM alumnos";
    
    private final String SQL_UPDATE = "UPDATE alumnos set rut_alumno = ?, nombres_alumno = ?, apellidos_alumno = ?, nacimiento_alumno = ?, sexo_alumno = ?, direccion_alumno = ? where id_alumno = ?";
    
    private final String SQL_DELETE = "delete from alumnos where id_alumno = ?";

    private final String SQL_SELECT_BY_ID = "SELECT id_alumno, rut_alumno, nombres_alumno, apellidos_alumno, nacimiento_alumno, sexo_alumno, direccion_alumno FROM alumnos where id_alumno = ? limit 1";

    private final String SQL_SELECT_BY_RUT = "SELECT id_alumno, rut_alumno, nombres_alumno, apellidos_alumno, nacimiento_alumno, sexo_alumno, direccion_alumno FROM alumnos where rut_alumno = ? limit 1";

    
    public AlumnoDAOImpl() {
    }

    
    
    public AlumnoDAOImpl(Connection userConn) {
        this.userConn = userConn;
    }

    @Override
    public int insert(AlumnoDTO alumno) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumno.getRut_alumno());
            stmt.setString(2, alumno.getNombres_alumno());
            stmt.setString(3, alumno.getApellidos_alumno());
            stmt.setString(4, alumno.getNacimiento_alumno());
            stmt.setString(5, alumno.getSexo_alumno());
            stmt.setString(6, alumno.getDireccion_alumno());
            
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
    public int delete(int id_alumno) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_alumno);
            
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
    public int update(AlumnoDTO alumno) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumno.getRut_alumno());
            stmt.setString(2, alumno.getNombres_alumno());
            stmt.setString(3, alumno.getApellidos_alumno());
            stmt.setString(4, alumno.getNacimiento_alumno());
            stmt.setString(5, alumno.getSexo_alumno());
            stmt.setString(6, alumno.getDireccion_alumno());
            stmt.setInt(7, alumno.getId_alumno());
            
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
    public List<AlumnoDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AlumnoDTO alumnoDTO = null;
        List<AlumnoDTO> alumnos = new ArrayList<AlumnoDTO>();
        try{
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                alumnoDTO.setId_alumno(rs.getInt("id_alumno"));
                alumnoDTO.setRut_alumno(rs.getString("rut_alumno"));
                alumnoDTO.setNombres_alumno(rs.getString("nombres_alumno"));
                alumnoDTO.setApellidos_alumno(rs.getString("apellidos_alumno"));
                alumnoDTO.setNacimiento_alumno(rs.getString("nacimiento_alumno"));
                alumnoDTO.setSexo_alumno(rs.getString("sexo_alumno"));
                alumnoDTO.setDireccion_alumno(rs.getString("direccion_alumno"));

                alumnos.add(alumnoDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return alumnos;
    }

    @Override
    public AlumnoDTO selectById(int id_alumno) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AlumnoDTO alumnoDTO = null;
        
        try{
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id_alumno);
            rs = stmt.executeQuery();
            while(rs.next()){
                alumnoDTO = new AlumnoDTO();
                alumnoDTO.setId_alumno(rs.getInt("id_alumno"));
                alumnoDTO.setRut_alumno(rs.getString("rut_alumno"));
                alumnoDTO.setNombres_alumno(rs.getString("nombres_alumno"));
                alumnoDTO.setApellidos_alumno(rs.getString("apellidos_alumno"));
                alumnoDTO.setNacimiento_alumno(rs.getString("nacimiento_alumno"));
                alumnoDTO.setSexo_alumno(rs.getString("sexo_alumno"));
                alumnoDTO.setDireccion_alumno(rs.getString("direccion_alumno"));

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return alumnoDTO;
    }

    @Override
    public AlumnoDTO selectByRut(String rut_alumno) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AlumnoDTO alumnoDTO = null;
        
        try{
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_RUT);
            stmt.setString(1, rut_alumno);
            rs = stmt.executeQuery();
            while(rs.next()){
                alumnoDTO = new AlumnoDTO();
                alumnoDTO.setId_alumno(rs.getInt("id_alumno"));
                alumnoDTO.setRut_alumno(rs.getString("rut_alumno"));
                alumnoDTO.setNombres_alumno(rs.getString("nombres_alumno"));
                alumnoDTO.setApellidos_alumno(rs.getString("apellidos_alumno"));
                alumnoDTO.setNacimiento_alumno(rs.getString("nacimiento_alumno"));
                alumnoDTO.setSexo_alumno(rs.getString("sexo_alumno"));
                alumnoDTO.setDireccion_alumno(rs.getString("direccion_alumno"));

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return alumnoDTO;
    }
    
    
	
    
}
