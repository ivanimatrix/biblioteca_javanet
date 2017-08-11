
<!DOCTYPE html>
<html>
    <%@include file="head.html" %>
    
    <body>
        <div class="container">
            <h1 class="page-header text-center">Men� del Sistema de Biblioteca</h1>
            <div class="row">
                <div class="col-xs-12 col-md-6 well">
                    <div class="text-center">
                        <a href="/Biblioteca/Alumnos">
                            <i class="fa fa-users fa-5x"></i>
                            <span style="display:block;" class="fa fa-3x">Alumnos</span>
                        </a>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6 well">
                    <div class="text-center">
                        <a href="/Biblioteca/Libros">
                            <i class="fa fa-book fa-5x"></i>
                            <span style="display:block;" class="fa fa-3x">Libros</span>
                        </a>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6 well">
                    <div class="text-center">
                        <a href="/Biblioteca/Prestamo">
                            <i class="fa fa-list fa-5x"></i>
                            <span style="display:block;" class="fa fa-3x">Pr�stamo</span>
                        </a>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6 well">
                    <div class="text-center">
                        <a href="/Biblioteca/Devolucion">
                            <i class="fa fa-undo fa-5x"></i>
                            <span style="display:block;" class="fa fa-3x">Devoluci�n</span>
                        </a>
                    </div>
                </div>
                <div class="col-xs-12 well">
                    <div class="text-center">
                        <a href="javascript:void(0);" onclick="Menu.verCreditos();">
                            <i class="fa fa-user fa-5x"></i>
                            <span style="display:block;" class="fa fa-3x">Cr�ditos</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </body>
    
    <script src="/Biblioteca/resources/js/menu/menu.js" charset="utf-8"></script>
</html>
