/*
 * Custom functions for the jQuery validation plugin.
 * Locale: PT_BR
 */
$(function() {
    jQuery.validator.addMethod("dateBr", function(value, element) {
        return this.optional(element) || /^\d\d?\/\d\d?\/\d\d\d?\d?$/.test(value);
    }, "Por favor, forne&ccedil;a uma data v&aacute;lida.");

    jQuery.validator.addClassRules("dateBr", {
        dateBr: true
    });

    jQuery.validator.addMethod("cpfCnpj", function(value, element) {
        var length = this.getLength($.trim(value), element);
        return this.optional(element) || (length == 11 || length == 14);
    }, "Por favor, forne&ccedil;a um CPF/CNPJ v&aacute;lido.");

    jQuery.validator.addClassRules("cpfCnpj", {
        cpfCnpf: true
    });
});