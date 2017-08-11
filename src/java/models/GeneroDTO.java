/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ivanimatrix
 */
public class GeneroDTO {
    
    private int id_genero;
    
    private String nombre_genero;
    
    
    public GeneroDTO(){
        
    }

    public GeneroDTO(int id_genero, String nombre_genero) {
        this.id_genero = id_genero;
        this.nombre_genero = nombre_genero;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombre_genero() {
        return nombre_genero;
    }

    public void setNombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }
    
    
    
}
