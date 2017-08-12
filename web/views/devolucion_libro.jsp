<%-- 
    Document   : devolucion_libro
    Created on : 10-08-2017, 19:59:06
    Author     : ivanimatrix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.html" %>
    <body>
        <div class="container">
            <%@include file="info_usuario.jsp" %>
            <h1 class="page-header">Devolución de Libros</h1>
            <span style="display:block" class="text-right"><p>Fecha : <script>document.write(fechaActual())</script></p></span>
            <div class="well">
                <form class="form-horizontal" role="form">
                    <div class="alert alert-default text-right">
                        <p>nº Préstamo: <span id="numero_prestamo" ></span></p>
                        
                    </div>
                    
                    <input type="hidden" id="id_prestamo" name="id_prestamo" value="0" />
                    <div class="form-group">
                        <label class="col-xs-12 col-md-2 control-label">Código</label>
                        <div class="col-xs-12 col-md-4">
                            <div class="input-group">
                                <input type="text" class="form-control" name="codigo" id="codigo" />
                                <div class="input-group-btn">
                                    <button type="button" class="btn btn-primary" onclick="Prestamos.buscarPrestamo(this)">
                                        <i class="fa fa-search"></i> Buscar
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-12 col-md-2 control-label">Descripción</label>
                        <div class="col-xs-12 col-md-10">
                            <input type="text" readonly class="form-control" name="descripcion" id="descripcion"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="col-xs-12 col-md-2 control-label">Rut</label>
                        <div class="col-xs-12 col-md-4">
                            <input type="text" class="form-control" name="rut" id="rut" readonly />
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <div class="form-group">
                                <label class="col-xs-12 col-md-4 control-label">Nombre</label>
                                <div class="col-xs-12 col-md-8">
                                    <input type="text" readonly class="form-control" name="nombres" id="nombres"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <div class="form-group">
                                <label class="col-xs-12 col-md-4 control-label">Apellido</label>
                                <div class="col-xs-12 col-md-8">
                                    <input type="text" readonly class="form-control" name="apellidos" id="apellidos"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="col-xs-12 col-md-2 control-label">Fecha de Entrega</label>
                        <div class="col-xs-12 col-md-4">
                            <div class="input-group">
                                <input type="date" class="form-control" name="fecha_entrega" id="fecha_entrega"  />
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="text-center">
                            <button type="button" class="btn btn-success btn-lg" onclick="Prestamos.entregarPrestamo();">Entregar</button>
                            <button type="reset" class="btn btn-primary btn-lg" id="limpiar">Limpiar</button>
                            <button type="reset" class="btn btn-default btn-lg" onclick="location.href='/Biblioteca/Menu'">Volver</button>
                        </div>
                    </div>
                         
                        
                </form>
            </div>
            
        </div>
    </body>
    
    <script src="/Biblioteca/resources/js/prestamos/prestamos.js" charset="utf-8"></script>
</html>
