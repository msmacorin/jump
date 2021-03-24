function removerRegistro(id) {
    bootbox.confirm(global_confirmacao_deletar_registro_msg, global_nao_msg, global_sim_msg, function(result) {
        if (result) {
            var controller = $('#tableCrud').attr("data-controller");
            window.location = contexto + controller + "/deletar.do?id=" + id;
        }
    });
}

$(document).ready(function() {

    var elementos = document.getElementsByTagName('input');
    $(elementos).each(function() {
        if ($(this).attr("readonly") || $(this).attr("hidden")) {
        } else {
            $(this).focus();
            return false;
        }
    });

    var controller = $('#tableCrud').attr("data-controller");

    var oTable = $('#tableCrud').dataTable({
        "oLanguage": {
            "sUrl": contexto + "/js/dataTables-pt_BR.txt"
        },
        "bProcessing": true,
        "bServerSide": true,
        "bDestroy": true,
        "bAutoWidth": false,
        "sAjaxSource": contexto + controller + "/loadDataAjax.do",
        "aoColumnDefs": [{
                "aTargets": [-1],
                "mData": null,
                "sClass": "control center",
                "mRender": function(data, type, full) {
                    return '<a class="btn btn-warning btn-mini" type="button" href="' + contexto + controller + '/editar.do?id=' + full[0] + '"><i class="icon-pencil"></i></a> &nbsp;' +
                            '<a class="btn btn-danger btn-mini" type="button" onclick="removerRegistro(\'' + full[0] + '\');" ><i class="icon-remove"></i></a>';
                }
            }]
    });

    $('.dataTables_filter input')
            .unbind('keypress keyup')
            .bind('keypress keyup', function(e) {
        if ($(this).val().length > 3 && e.keyCode == 13)
            oTable.fnFilter($(this).val());
    });
});