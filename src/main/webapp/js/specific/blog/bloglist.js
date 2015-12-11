/* 
 * Copyright (c) 2015 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * openAUSIAS: The stunning micro-library that helps you to develop easily 
 * AJAX web applications by using Java and jQuery
 * openAUSIAS is distributed under the MIT License (MIT)
 * Sources at https://github.com/rafaelaznar/openAUSIAS
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 */
var blogList = function() {
};
blogList.prototype = new listModule();


blogList.prototype.render = function() {

    var cabecera = "";
    cabecera += "<div>";
    cabecera += "<div class=\"cabecera\">";
    cabecera += "Consejos efectivos para lograr el éxito, por Dawland";
    cabecera += "</div>";
    cabecera += "<div class=\"interno\">";
    cabecera += "TU CAMINO.";
    cabecera += "</div>";
    cabecera += "</div>";
    $("#broth_title").empty();
    $(".panel-heading").empty().append(cabecera);
    var blog = "";
    var blogpintado = 0;
    var titulo = "";
    var entrada = "";
    var comentario = "";
    var categorias = "";
    var contador = 0;
    var fecha = "";
    var tags = "";
    var miarray = new Array();
    var miarraynuevo = new Array();
    miarraynuevo[0] = jsonData.message.page.message[0].etiquetas;
    var y = 0;
    //  blog += "<div class=\"container\">"
    for (var i = 0; i < jsonData.message.page.message.length; i++) {
        miarray[i] = jsonData.message.page.message[i].etiquetas;

    }

    for (var i = 0; i < miarray.length; i++) {
        for (var j = 0; j < miarray.length - 1; j++) {
            if (i != j) {
                if (miarray[i] == miarray[j]) {
                    miarray[j] = null;
                }
            }
        }

    }

    for (var i = 0; i < miarray.length; i++) {
        if (miarray[i] != null) {
            categorias += "<div>";
            categorias += miarray[i];
            categorias += "</div>";
        }
    }
    if (11 == jsonData.message.page.message[0].id_usuario) {
        blog += "<div class=\"row\">";
        blog += "<div class=\"col-md-11 col-md-offset-1\">";
        blog += "<a href=\"http://localhost:8081/ausiasblog/#/documento/new/usuario="+jsonData.message.page.message[0].id_usuario+"&tipodocumento=2\" class=\"btn btn-success\" role=\"button\">Crear Documento</a>&nbsp";
        blog += "<a href=\"http://localhost:8081/ausiasblog/#/documentocategoriaarticulo/new\" class=\"btn btn-success\" role=\"button\">Asignar Categoría</a>";
        
        blog += "</div>";
        
        blog += "</div>";
    }
    for (var i = 0; i < jsonData.message.page.message.length; i++) {
        blog += "<div class=\"row\">";

        titulo = jsonData.message.page.message[i].titulo;
        //lado izquierdo
        blog += "<div class=\"col-md-7 col-md-offset-1\">";
        ////titulo
        blog += "<div class=\"titulo\">";

        blog += "<h2>";
        blog += titulo;
        blog += "</h2>";

        blog += '<div class = "datos">' + "Publicado el: " + jsonData.message.page.message[i].alta + "   |   ";
        //autor += jsonData.message.page.message[i].autor;
        blog += "Visitas: " + jsonData.message.page.message[i].hits;
//                        entrada += "Tags: " + jsonData.message.page.message[i].etiquetas;
        blog += '</div>';


        blog += '<a title="' + jsonData.message.page.message[i].titulo + '" href="http://localhost:8081/ausiasblog/#/blog/view/' + jsonData.message.page.message[i].id + '"><div class = "hover"><img src="images/imagen' + jsonData.message.page.message[i].id + '.jpg" alt="' + jsonData.message.page.message[i].titulo + '" class="img-responsive" /></div></a>';

        blog += "</div>";
        ///fin titulo
        //fecha
        blog += "<div>";
        blog += "</div>";
        //fin fecha
        //entrada
        blog += "<div class=\"entrada\">";
        blog += "<h4>";
        entrada = jsonData.message.page.message[i].contenido;
        blog += entrada;
        blog += "</h4>";
        blog += "</div>";
        //fin entrada
        //leer mas
//        blog += "<div class=\"leermas\">";
//        blog += "<a href=\"http://localhost:8081/ausiasblog/#/blog/view/" + jsonData.message.page.message[i].id + "\">Leer más...</a>";
//        blog += "</div>";
        blog += "<a href=\"http://localhost:8081/ausiasblog/#/blog/view/" + jsonData.message.page.message[i].id + "\" class=\"leermas btn btn-success\" role=\"button\">Leer más</a>";
        if (11 == jsonData.message.page.message[i].id_usuario) {
            blog += "<div class=\"editar\">";
            blog += "<a href=\"http://localhost:8081/ausiasblog/#/documento/edit/" + jsonData.message.page.message[i].id + "\" class=\"btn btn-warning\" role=\"button\">Editar</a>";
            blog += "&nbsp";
            blog += "<a href=\"http://localhost:8081/ausiasblog/#/documento/remove/" + jsonData.message.page.message[i].id + "\" class=\"btn btn-danger\" role=\"button\">Eliminar</a>";
            blog += "</div>";
        }

        //fin leer mas

        blog += "</div>";
        //fin lado izquierdo

        //lado derecho
        if (contador == 0) {
            blog += "<div class=\"col-md-2 col-md-offset-1\">";

            blog += "<div class=\"columnaderecha\">";

            blog += "<div>";
            blog += "Nombre";
            blog += "</div>";

            blog += "<div class=\"imagen\">";
            blog += '<img src="images/about.jpg" alt="" class="img-responsive" />"';
            blog += "</div>";

            blog += "<div>";
            blog += "Somos una organización si ánimo de lucro, simplemente escribimos lo que se nos ocurre";
            blog += "</div>";

            blog += "<div style=\"padding-top:20px;\">";
            blog += "Busqueda por Categorias";
            blog += "</div>";

            blog += "<div>";
            blog += categorias;
            blog += "</div>";


            blog += "</div>";

            blog += "</div>";

        }
        blog += "</div>";
        contador++;
        //fin lado derecho
    }


    return blog;

};