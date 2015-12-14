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

var blogView = function () {

};
blogView.prototype = new viewModule();
blogView.prototype.getViewTemplate_func = function (strClass, jsonDataViewModule) {
    var cabecera = "";
    cabecera += "<div >";
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
    var fecha = "";
    var tags = "";

    // blog += "<div class=\"container\">"
    for (var i = 0; i < jsonDataViewModule.bean.message.length; i++) {
        blog += "<div class=\"row\">";
        blog += "<div class=\"col-md-10 col-md-offset-1\">";
        if (blogpintado == 0) {
            blog += "<div>";
            //titulo
            blog += "<div class=\"titulo\">"
            blog += "<h2>";
            titulo = jsonDataViewModule.bean.message[i].titulo;
            blog += titulo;
            blog += "</h2>";
            blog += "</div>";
            blog += '<div id="imagenview"><img src="images/imagen' + jsonDataViewModule.bean.message[i].id_documento + '.jpg" alt="' + jsonDataViewModule.bean.message[i].titulo + '" class="img-responsive" /></div>';
            //fin del titulo
            blog += "</div>";
            blog += "</br>";
            blog += "<div class=\"entrada\">";
            blog += "<h4>";
            entrada = jsonDataViewModule.bean.message[i].entrada;
            blog += entrada;
            blog += "</h4>";
            blog += "<div class=\"etiquetas\">";
            tags = "Etiqueta/s: " + jsonDataViewModule.bean.message[i].etiquetas;
            blog += tags;
            blog += "</div>";
            blog += "</div>";
            blog += '<h2>Comentarios</h2>';
            blogpintado++;
        }
        //fin del col-md-7

        blog += "<div class= \"comentario\">";
        comentario = jsonDataViewModule.bean.message[i].comentario;
        blog += "<p>";
        blog += "<h4>";
        blog += comentario;
        blog += "</h4>";
        blog += "</p>";
        blog += "<div class=\"autor\">";
        tags = jsonDataViewModule.bean.message[i].nombreautor;
        blog += tags;
        blog += "</div>";
        blog += "</div>";

        if (jsonDataViewModule.bean.message[i].usuariocomentario === jsonDataViewModule.bean.message[i].id_login) {

            blog += "<div class=\"editarcomentario\">";
            blog += "<a href=\"http://localhost:8081/ausiasblog/#/comentario/edit/" + jsonDataViewModule.bean.message[i].id_comentario + "\" class=\"btn btn-success\" role=\"button\">Editar Comentario</a>";
            blog += "</div>";
        }
        blog += "</br>";
        blog += "</div>";
        //fin del row
        blog += "</div>";
    }
    
    blog += "<div class=\"botoncom\">";
    blog += "<a href=\"http://localhost:8081/ausiasblog/#/comentario/new/usuario=" + jsonDataViewModule.bean.message[0].id_login + "&documento=" + jsonDataViewModule.bean.message[0].id_documento + "\" class=\"btn btn-success\" role=\"button\">Comentar</a>";
    blog += "</div>";
//    blog += "</div>";
    return blog;
};

