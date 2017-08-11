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
import models.GeneroDTO;

/**
 *
 * @author ivanimatrix
 */
public class GeneroDAOImpl implements GeneroDAO {
    
    private Connection userConn;
	
    private final String SQL_SELECT = "SELECT id_genero, nombre_genero FROM generos";

    public GeneroDAOImpl() {
    }

    public GeneroDAOImpl(Connection userConn) {
        this.userConn = userConn;
    }
    
    
    

    @Override
    public List<GeneroDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        GeneroDTO generoDTO = null;
        List<GeneroDTO> generos = new ArrayList<GeneroDTO>();
        try{
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                generoDTO = new GeneroDTO();
                generoDTO.setId_genero(rs.getInt("id_genero"));
                generoDTO.setNombre_genero(rs.getString("nombre_genero"));
                
                generos.add(generoDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return generos;
    }


}
