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
public class AlumnoDTO {
    
    private int id_alumno;
    
    private String rut_alumno;
    
    private String nombres_alumno;
    
    private String apellidos_alumno;
    
    private String sexo_alumno;
    
    private String nacimiento_alumno;
    
    private String direccion_alumno;

    public AlumnoDTO() {
    }

    public AlumnoDTO(String rut_alumno, String nombres_alumno, String apellidos_alumno, String sexo_alumno, String nacimiento_alumno, String direccion_alumno) {
        this.rut_alumno = rut_alumno;
        this.nombres_alumno = nombres_alumno;
        this.apellidos_alumno = apellidos_alumno;
        this.sexo_alumno = sexo_alumno;
        this.nacimiento_alumno = nacimiento_alumno;
        this.direccion_alumno = direccion_alumno;
    }

    public AlumnoDTO(int id_alumno, String rut_alumno, String nombres_alumno, String apellidos_alumno, String sexo_alumno, String nacimiento_alumno, String direccion_alumno) {
        this.id_alumno = id_alumno;
        this.rut_alumno = rut_alumno;
        this.nombres_alumno = nombres_alumno;
        this.apellidos_alumno = apellidos_alumno;
        this.sexo_alumno = sexo_alumno;
        this.nacimiento_alumno = nacimiento_alumno;
        this.direccion_alumno = direccion_alumno;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getRut_alumno() {
        return rut_alumno;
    }

    public void setRut_alumno(String rut_alumno) {
        this.rut_alumno = rut_alumno;
    }

    public String getNombres_alumno() {
        return nombres_alumno;
    }

    public void setNombres_alumno(String nombres_alumno) {
        this.nombres_alumno = nombres_alumno;
    }

    public String getApellidos_alumno() {
        return apellidos_alumno;
    }

    public void setApellidos_alumno(String apellidos_alumno) {
        this.apellidos_alumno = apellidos_alumno;
    }

    public String getSexo_alumno() {
        return sexo_alumno;
    }

    public void setSexo_alumno(String sexo_alumno) {
        this.sexo_alumno = sexo_alumno;
    }

    public String getNacimiento_alumno() {
        return nacimiento_alumno;
    }

    public void setNacimiento_alumno(String nacimiento_alumno) {
        this.nacimiento_alumno = nacimiento_alumno;
    }

    public String getDireccion_alumno() {
        return direccion_alumno;
    }

    public void setDireccion_alumno(String direccion_alumno) {
        this.direccion_alumno = direccion_alumno;
    }
    
    
    
    
}
