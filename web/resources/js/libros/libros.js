
var Libros = {
    
    buscarLibro : function(btn){
        var btnText = $(btn).prop('disabled', true).html();
        $(btn).html('Buscando...<i class="fa fa-spin fa-spinner"></i>');
        
        var codigo = $("#codigo").val();
        
        if(codigo === ""){
            Modal.danger("El código no puede estar vacío", function(){
                $(btn).html(btnText).prop('disabled',false);
            });
        }else{
            $.ajax({
                url : '/Biblioteca/BuscarLibro',
                data : {codigo:codigo},
                dataType : 'json',
                type : 'post',
                success : function(response){
                    if(response.estado === true){
                        $("#id_libro").val(response.id);
                        $("#codigo").val(response.codigo);
                        $("#descripcion").val(response.descripcion);
                        $("#cantidad").val(response.cantidad);
                        $("#fecha_ingreso").val(response.fecha_ingreso);
                        $("#genero").val(response.genero);
                        $(btn).html(btnText).prop('disabled',false);
                    }else{
                        Modal.warning('El libro buscado no existe. Si quiere, puede registrarlo como nuevo Libro',function(){
                            $(btn).html(btnText).prop('disabled',false);
                        });
                    }
                }
                
            });
        }
    },
    
    
    guardarLibro : function(form, btn){
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
                url : '/Biblioteca/GuardarLibro',
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
    
    
    editarLibro : function(form, btn){
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
                url : '/Biblioteca/GuardarLibro',
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
    
    
    eliminarLibro : function(form,btn){
        
        
        Modal.confirm("Desea eliminar este libro?", function(){
            $.ajax({
                url : '/Biblioteca/EliminarLibro',
                data : {id: $("#id_libro").val()},
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
                $(btn).html(btnText).prop('disabled',false);
            });
        });
    }
    
}

