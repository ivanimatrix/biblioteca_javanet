/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import models.AlumnoDTO;

/**
 *
 * @author ivanimatrix
 */
public interface AlumnoDAO {
    
    public int insert(AlumnoDTO alumno) throws SQLException;
    
    public int delete(int id_alumno) throws SQLException;
    
    public int update(AlumnoDTO alumno) throws SQLException;
	
    public List<AlumnoDTO> select() throws SQLException;
        
    public AlumnoDTO selectById(int id_alumno) throws SQLException;
        
    public AlumnoDTO selectByRut(String rut_alumno) throws SQLException;
}
