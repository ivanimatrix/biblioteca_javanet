/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import models.GeneroDTO;

/**
 *
 * @author ivanimatrix
 */
public interface GeneroDAO {
    
    public List<GeneroDTO> select() throws SQLException;
    
}
