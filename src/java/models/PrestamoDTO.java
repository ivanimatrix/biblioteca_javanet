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
public class PrestamoDTO {
    
    private int  id_prestamo;
    private String devolucion_prestamo;
    private int alumno_fk_prestamo;
    private int libro_fk_prestamo;
    private int estado_prestamo;

    public PrestamoDTO() {
    }

    public PrestamoDTO(String devolucion_prestamo, int alumno_fk_prestamo, int libro_fk_prestamo, int estado_prestamo) {
        this.devolucion_prestamo = devolucion_prestamo;
        this.alumno_fk_prestamo = alumno_fk_prestamo;
        this.libro_fk_prestamo = libro_fk_prestamo;
        this.estado_prestamo = estado_prestamo;
    }

    public PrestamoDTO(int id_prestamo, String devolucion_prestamo, int alumno_fk_prestamo, int libro_fk_prestamo, int estado_prestamo) {
        this.id_prestamo = id_prestamo;
        this.devolucion_prestamo = devolucion_prestamo;
        this.alumno_fk_prestamo = alumno_fk_prestamo;
        this.libro_fk_prestamo = libro_fk_prestamo;
        this.estado_prestamo = estado_prestamo;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public String getDevolucion_prestamo() {
        return devolucion_prestamo;
    }

    public void setDevolucion_prestamo(String devolucion_prestamo) {
        this.devolucion_prestamo = devolucion_prestamo;
    }

    public int getAlumno_fk_prestamo() {
        return alumno_fk_prestamo;
    }

    public void setAlumno_fk_prestamo(int alumno_fk_prestamo) {
        this.alumno_fk_prestamo = alumno_fk_prestamo;
    }

    public int getLibro_fk_prestamo() {
        return libro_fk_prestamo;
    }

    public void setLibro_fk_prestamo(int libro_fk_prestamo) {
        this.libro_fk_prestamo = libro_fk_prestamo;
    }

    public int getEstado_prestamo() {
        return estado_prestamo;
    }

    public void setEstado_prestamo(int estado_prestamo) {
        this.estado_prestamo = estado_prestamo;
    }
    
    
    
}
