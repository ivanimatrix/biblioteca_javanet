

var Menu = {
    
    verCreditos : function(){
        BootstrapDialog.show({
            title : 'Créditos',
            message : $('<div></div>').load('views/creditos.html'),
            buttons : [
                {
                    label: 'Cerrar',
                    action: function(dialogItself){
                        dialogItself.close();
                    }
                }
            ]
        });
    }
}