/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $("#formCrud").validate({
        rules: {
            usuNome: "required",
            usuUsuario: {
                required: true,
                remote: contexto + "/usuario/ajaxCheckUser.do"
            },
            usuEmail: {
                required: true,
                email: true,
                remote: contexto + "/usuario/ajaxCheckMail.do"
            },
            usuSenha: {
                required: true,
                minlength: 6
            },
            confirmaSenha: {
                required: true,
                equalTo: "#usuSenha"
            },
            searchGrupoEmpresa: {
                required: true
            }
        },
        messages: {
            usuUsuario: {
                remote: "Usuário já existe!"
            },
            usuEmail: {
                remote: "E-mail já existe!"
            }
        },
        errorClass: "help-inline",
        errorElement: "span",
        errorPlacement: function(error, element) {
            // if the input has a prepend or append element, put the validation msg after the parent div
            if (element.parent().parent().hasClass('input-prepend') || element.parent().parent().hasClass('input-append')) {
                error.insertAfter(element.parent().parent());
                // else just place the validation message immediatly after the input
            } else {
                error.insertAfter(element);
            }
        },
        highlight: function(element) {
            $(element).parents('.control-group').addClass('error');
            $(element).parents('.control-group').removeClass('success');
        },
        unhighlight: function(element) {
            $(element).parents('.control-group').removeClass('error');
            $(element).parents('.control-group').addClass('success');
        }
    });
});