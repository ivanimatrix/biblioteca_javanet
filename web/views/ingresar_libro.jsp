<%-- 
    Document   : ingresar_libro
    Created on : 10-08-2017, 19:58:39
    Author     : ivanimatrix
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.GeneroDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.html" %>
    <body>
        <div class="container">
            <%@include file="info_usuario.jsp" %>
            <h1 class="page-header">Ingreso de Libros</h1>
            
            <div class="">
                <div class="well">
                    <form class="form-horizontal" role="form">
                        <input type="hidden" name="id_libro" id="id_libro" value="0" />
                        <div class="form-group">
                            <label class="col-xs-12 col-md-4 control-label">Código</label>
                            <div class="col-xs-12 col-md-4">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="codigo" id="codigo" />
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-primary" onclick="Libros.buscarLibro(this);">
                                            <i class="fa fa-search"></i> Buscar
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-12 col-md-4 control-label">Descripción</label>
                            <div class="col-xs-12 col-md-6">
                                <input type="text" name="descripcion" id="descripcion" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-12 col-md-4 control-label">Cantidad</label>
                            <div class="col-xs-12 col-md-2">
                                <input type="number" name="cantidad" id="cantidad" class="form-control" min="0" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-12 col-md-4 control-label">Fecha Ingreso</label>
                            <div class="col-xs-12 col-md-4">
                                <div class="input-group">
                                    <input type="date" class="form-control" name="fecha_ingreso" id="fecha_ingreso"  />
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-12 col-md-4 control-label">Género</label>
                            <div class="col-xs-12 col-md-4">
                                <select class="form-control" name="genero" id="genero">
                                    <option value="">Seleccione...</option>
                                    <c:forEach var="genero" items="${generos}">
                                        <option value="${genero.id_genero}">${genero.nombre_genero}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        
                        <div class="form-group text-center">
                            <div class="col-xs-12">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-success btn-lg" onclick="Libros.guardarLibro(this.form, this)">Grabar</button>
                                    <button type="button" class="btn btn-warning btn-lg" onclick="Libros.editarLibro(this.form, this)">Editar</button>
                                    <button type="button" class="btn btn-danger btn-lg" onclick="Libros.eliminarLibro(this.form, this)">Eliminar</button>
                                    <button type="button" class="btn btn-primary btn-lg" onclick="location.href='/Biblioteca/Menu'">Volver</button>
                                </div>
                            </div>
                            
                        </div>
                    </form>
                </div>
            </div>
            
        </div>
        
        
    </body>
    <script src="/Biblioteca/resources/js/libros/libros.js" charset="utf-8"></script>
</html>
