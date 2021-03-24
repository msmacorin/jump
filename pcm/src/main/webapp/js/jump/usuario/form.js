/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $("#formCrud").validate({
        rules: {
            nome: "required",
            usuario: {
                required: true,
                remote: contexto + "/usuario/ajaxCheckUser.do"
            },
            email: {
                required: true,
                email: true,
                remote: contexto + "/usuario/ajaxCheckMail.do"
            },
            senha: {
                required: true,
                minlength: 6
            },
            confirmaSenha: {
                required: true,
                equalTo: "#senha"
            }
        },
        messages: {
            usuario: {
                remote: "Usuário já existe!"
            },
            email: {
                remote: "E-mail já existe!"
            }
        },
        errorClass: "help-inline",
        errorElement: "span",
        highlight: function(element, errorClass, validClass) {
            $(element).parents('.control-group').addClass('error');
        },
        unhighlight: function(element, errorClass, validClass) {
            $(element).parents('.control-group').removeClass('error');
            $(element).parents('.control-group').addClass('success');
        }
    });
});