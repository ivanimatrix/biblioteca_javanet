<%-- 
    Document   : ingresar_alumno
    Created on : 10-08-2017, 19:58:28
    Author     : ivanimatrix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.html" %>
    <body>
        <div class="container">
            
            <%@include file="info_usuario.jsp" %>
            <h1 class="page-header">Ingreso de Alumnos</h1>
            
            <div class="">
                <div class="well">
                    <form class="form-horizontal" role="form">
                        <input type="hidden" name="id_alumno" id="id_alumno" value="0" />
                        <div class="form-group">
                            <label class="col-xs-12 col-md-4 control-label">Rut</label>
                            <div class="col-xs-12 col-md-4">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="rut" id="rut" placeholder="12345678-9"/>
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-primary" onclick="Alumnos.buscarAlumno(this);">
                                            <i class="fa fa-search"></i> Buscar 
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-12 col-md-4 control-label">Nombres</label>
                            <div class="col-xs-12 col-md-6">
                                <input type="text" name="nombres" id="nombres" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-12 col-md-4 control-label">Apellidos</label>
                            <div class="col-xs-12 col-md-6">
                                <input type="text" name="apellidos" id="apellidos" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-12 col-md-4 control-label">Fecha Nacimiento</label>
                            <div class="col-xs-12 col-md-4">
                                <div class="input-group">
                                    <input type="date" class="form-control" name="fecha_nacimiento" id="fecha_nacimiento"  />
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-12 col-md-4 control-label">Sexo</label>
                            <div class="col-xs-12 col-md-4">
                                <select class="form-control" name="sexo" id="sexo">
                                    <option value="">Seleccione...</option>
                                    <option value="MASCULINO">Masculino</option>
                                    <option value="FEMENINO">Femenino</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-md-4">Dirección</label>
                            <div class="col-xs-12 col-md-6">
                                <input type="text" name="direccion" id="direccion" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group text-center">
                            <div class="col-xs-12">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-success btn-lg" onclick="Alumnos.guardarAlumno(this.form, this);">Grabar</button>
                                    <button type="button" class="btn btn-warning btn-lg" onclick="Alumnos.editarAlumno(this.form, this);">Editar</button>
                                    <button type="button" class="btn btn-danger btn-lg" onclick="Alumnos.eliminarAlumno(this.form, this);">Eliminar</button>
                                    <button type="button" class="btn btn-primary btn-lg" onclick="location.href='/Biblioteca/Menu'">Volver</button>
                                </div>
                            </div>
                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    
    <script src="/Biblioteca/resources/js/alumnos/alumnos.js" charset="utf-8"></script>
</html>
