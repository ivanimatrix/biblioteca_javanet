/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import models.LibroDTO;

/**
 *
 * @author ivanimatrix
 */
public interface LibroDAO {
    
    public int insert(LibroDTO libro) throws SQLException;
    
    public int delete(int id_libro) throws SQLException;
    
    public int update(LibroDTO libro) throws SQLException;
	
    public List<LibroDTO> select() throws SQLException;
        
    public LibroDTO selectById(int id_libro) throws SQLException;
        
    public LibroDTO selectByCodigo(String codigo_libro) throws SQLException;
}
