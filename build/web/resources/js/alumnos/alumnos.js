
var Alumnos = {
    
    buscarAlumno : function(btn){
        var btnText = $(btn).prop('disabled', true).html();
        $(btn).html('Buscando...<i class="fa fa-spin fa-spinner"></i>');
        
        var rut = $("#rut").val();
        
        if(rut === ""){
            Modal.danger("El rut no puede estar vacío", function(){
                $(btn).html(btnText).prop('disabled',false);
            });
        }else{
            $.ajax({
                url : '/Biblioteca/BuscarAlumno',
                data : {rut:rut},
                dataType : 'json',
                type : 'post',
                success : function(response){
                    if(response.estado === true){
                        $("#id_alumno").val(response.id);
                        $("#nombres").val(response.nombres);
                        $("#apellidos").val(response.apellidos);
                        $("#fecha_nacimiento").val(response.fecha_nacimiento);
                        $("#sexo").val(response.sexo);
                        $("#direccion").val(response.direccion);
                        $(btn).html(btnText).prop('disabled',false);
                    }else{
                        Modal.warning('El alumno buscado no existe. Si quiere, puede registrarlo como nuevo Alumno',function(){
                            $(btn).html(btnText).prop('disabled',false);
                        });
                    }
                }
                
            });
        }
    },
    
    
    guardarAlumno : function(form, btn){
        var btnText = $(btn).prop('disabled', true).html();
        $(btn).html('Grabando...<i class="fa fa-spin fa-spinner"></i>');
        
        var error = "";
        
        if(error !== ""){
            Modal.danger(error, function(){
                $(btn).html(btnText).prop('disabled',false);
            });
        }else{
            var formulario = $(form).serializeArray();
            $.ajax({
                url : '/Biblioteca/GuardarAlumno',
                data : formulario,
                dataType : 'json',
                type : 'post',
                success : function(response){
                    if(response.estado === true){
                        Modal.success(response.mensaje, function(){
                            $(btn).html(btnText).prop('disabled',false);
                        });
                    }else{
                        Modal.danger(response.mensaje,function(){
                            $(btn).html(btnText).prop('disabled',false);
                        });
                    }
                }
                
            });
        }
    },
    
    
    editarAlumno : function(form, btn){
        var btnText = $(btn).prop('disabled', true).html();
        $(btn).html('Editando...<i class="fa fa-spin fa-spinner"></i>');
        
        var error = "";
        
        if(error !== ""){
            Modal.danger(error, function(){
                $(btn).html(btnText).prop('disabled',false);
            });
        }else{
            var formulario = $(form).serializeArray();
            $.ajax({
                url : '/Biblioteca/GuardarAlumno',
                data : formulario,
                dataType : 'json',
                type : 'post',
                success : function(response){
                    if(response.estado === true){
                        Modal.success(response.mensaje, function(){
                            $(btn).html(btnText).prop('disabled',false);
                        });
                    }else{
                        Modal.danger(response.mensaje,function(){
                            $(btn).html(btnText).prop('disabled',false);
                        });
                    }
                }
                
            });
        }
    },
    
    
    eliminarAlumno : function(form,btn){
        var btnText = $(btn).prop('disabled', true).html();
        
        
        Modal.confirm("Desea eliminar este alumno?", function(){
            $.ajax({
                url : '/Biblioteca/EliminarAlumno',
                data : {id: $("#id_alumno").val()},
                dataType : 'json',
                type : 'post',
                success : function(response){
                    if(response.estado === true){
                        Modal.success(response.mensaje, function(){
                            
                        });
                    }else{
                        Modal.danger(response.mensaje,function(){
                            
                        });
                    }
                }
                
            }, function(){
                
            });
        });
    }
    
}

