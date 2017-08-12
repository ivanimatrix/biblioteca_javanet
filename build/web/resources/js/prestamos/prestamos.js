

var Prestamos = {
    
   guardarPrestamo : function(form, btn) {
       var btnText = $(btn).prop('disabled', true).html();
       $(btn).html('Grabando... <i class="fa fa-spin fa-spinner"></i>');
       
       var formulario = $(form).serializeArray();
       
       $.ajax({
           url : '/Biblioteca/GuardarPrestamo',
           data : formulario,
           dataType : 'json',
           type: 'post',
           success : function(response){
               if(response.estado === true){
                   Modal.success(response.mensaje, function(){
                       $("#limpiar").trigger('click');
                   });
               }else{
                   Modal.danger(response.mensaje)
               }
               $(btn).html(btnText).prop('disabled',false);
           }
       });
       
   },
   
   
   buscarPrestamo : function(btn){
       var btnText = $(btn).prop('disabled', true).html();
       $(btn).html('Buscando    ... <i class="fa fa-spin fa-spinner"></i>');
       
       var codigo_libro = $("#codigo").val();
       
       $.ajax({
           url : '/Biblioteca/BuscarPrestamo',
           data : {codigo:codigo_libro},
           dataType : 'json',
           type : 'post',
           success : function(response){
               if(response.estado === true){
                   $("#id_prestamo").val(response.id_prestamo);
                   $("#numero_prestamo").html(response.id_prestamo);
                   $("#descripcion").val(response.descripcion);
                   $("#rut").val(response.rut);
                   $("#nombres").val(response.nombres);
                   $("#apellidos").val(response.apellidos);
                   $("#fecha_entrega").val(response.fecha_entrega);
               }else{
                   Modal.danger("El libro no ha sido encontrado dentro de los registros de préstamos");
               }
               
               $(btn).html(btnText).prop('disabled',false);
           }
       })
       
   },
   
   
   entregarPrestamo : function(){
       Modal.confirm('Desea ingresar la devolución del préstamo', function(){
           var id_prestamo = $("#id_prestamo").val();
           
           $.ajax({
               url : '/Biblioteca/EntregarPrestamo',
               data : {id_prestamo:id_prestamo},
               dataType : 'json',
               type : 'post',
               success : function(response){
                   if(response.estado === true){
                       $("#limpiar").trigger('click');
                       Modal.success(response.mensaje);
                   }else{
                       Modal.danger(response.mensaje);
                   }
               }
           })
       });
   }
    
    
}

