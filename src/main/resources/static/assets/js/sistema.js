function buscarBienes(codigoPatrimonial){
    $.ajax({
        url:'/items/'+codigoPatrimonial,
        type:'POST',
        success:function(result){
            $("#suggesstion-box").show();
            $("#suggesstion-box").html(result);
            $("#search-box").css("background","#FFF");
        }
    });
}

function agregarItem(itemId){
    $.ajax({
        url:'/item/'+itemId,
        type:'POST',
        success: function(result){
            var ids = $("input[name=itemIds]").val();
            var separador = (ids!="")?",":"";
            $("input[name=itemIds]").val(itemId+separador+ids);
            $("#search-box").val(result.codigoPatrimonial);
            $("#suggesstion-box").hide();
            $("#itemadded").append(result.html);
        }
    });
}

function eliminarItemDom(itemId,element){
    var separador = "";
    var flag = false;
    var ids = $("input[name=itemIds]").val();
    var _ids = ids.split(",");
    ids = "";
    for(var i=0;i<_ids.length;i++){
        if(_ids[i]==itemId && flag==false){
            flag = true;
        }else{
            separador = (ids!="")?",":"";
            ids+= separador+_ids[i];
        }
    }
    $("input[name=itemIds]").val(ids);
    $(element).parent().parent().remove();
}

function eliminarItemOrdenDetalle(ordenDetalleId,itemId,element){
    var flag = false;
    var separador = "";
    $.ajax({
        url:'/salida/ordendetalle/'+ordenDetalleId,
        type:'POST',
        success: function(result){
            var ids = $("input[name=itemIds]").val();
            var _ids = ids.split(",");
            ids = "";
            for(var i=0;i<_ids.length;i++){
                if(_ids[i]==itemId && flag==false){
                    $(element).parent().parent().remove();
                    flag = true;
                }else{
                    separador = (ids!="")?",":"";
                    ids+= separador+_ids[i];
                }
            }
            $("input[name=itemIds]").val(ids);
        }
    });
}

