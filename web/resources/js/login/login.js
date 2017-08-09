

var Login = {
    
    
    validar : function(form, btn){
        $("#contenedor-mensaje-error").addClass('hidden');
        var btnText = $(btn).prop('disabled',true).html();
        $(btn).html('Validando... <i class="fa fa-spin fa-spinner"></i>');
        
        var error = "";
        
        if(form.usuario.value == "" || form.pass.value == ""){
            error = "Debe ingresar las credenciales";
        }
        
        if(error !== ""){
            $("#mensaje-error").html(error);
            $("#contenedor-mensaje-error").removeClass('hidden');
            $(btn).html(btnText).prop('disabled',false);
        }else{
            
        }
        
    }
    
    
}