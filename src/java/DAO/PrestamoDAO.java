/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import models.PrestamoDTO;

/**
 *
 * @author ivanimatrix
 */
public interface PrestamoDAO {
    
    public int insert(PrestamoDTO prestamo) throws SQLException;
    
    public int delete(int id_prestamo) throws SQLException;
    
    public int update(PrestamoDTO prestamo) throws SQLException;
	
    public List<PrestamoDTO> select() throws SQLException;
        
    public PrestamoDTO selectById(int id_prestamo) throws SQLException;
        
    public PrestamoDTO selectByIdLibro(int cid_libro) throws SQLException;
    
    public int contar() throws SQLException;
    
}
