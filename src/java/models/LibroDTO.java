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
public class LibroDTO {
    
    private int id_libro;
    
    private String codigo_libro;
    
    private String descripcion_libro;
    
    private int cantidad_libro;

    private String ingreso_libro;

    private int genero_fk_libro;

    public LibroDTO() {
    }

    public LibroDTO(String codigo_libro, String descripcion_libro, int cantidad_libro, String ingreso_libro, int genero_fk_libro) {
        this.codigo_libro = codigo_libro;
        this.descripcion_libro = descripcion_libro;
        this.cantidad_libro = cantidad_libro;
        this.ingreso_libro = ingreso_libro;
        this.genero_fk_libro = genero_fk_libro;
    }

    public LibroDTO(int id_libro, String codigo_libro, String descripcion_libro, int cantidad_libro, String ingreso_libro, int genero_fk_libro) {
        this.id_libro = id_libro;
        this.codigo_libro = codigo_libro;
        this.descripcion_libro = descripcion_libro;
        this.cantidad_libro = cantidad_libro;
        this.ingreso_libro = ingreso_libro;
        this.genero_fk_libro = genero_fk_libro;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getCodigo_libro() {
        return codigo_libro;
    }

    public void setCodigo_libro(String codigo_libro) {
        this.codigo_libro = codigo_libro;
    }

    public String getDescripcion_libro() {
        return descripcion_libro;
    }

    public void setDescripcion_libro(String descripcion_libro) {
        this.descripcion_libro = descripcion_libro;
    }

    public int getCantidad_libro() {
        return cantidad_libro;
    }

    public void setCantidad_libro(int cantidad_libro) {
        this.cantidad_libro = cantidad_libro;
    }

    public String getIngreso_libro() {
        return ingreso_libro;
    }

    public void setIngreso_libro(String ingreso_libro) {
        this.ingreso_libro = ingreso_libro;
    }

    public int getGenero_fk_libro() {
        return genero_fk_libro;
    }

    public void setGenero_fk_libro(int genero_fk_libro) {
        this.genero_fk_libro = genero_fk_libro;
    }
    
    
    
    
    
}
