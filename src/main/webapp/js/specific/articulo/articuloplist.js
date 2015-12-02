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
var articuloplist = function () {
};
articuloplist.prototype = new pListModule();
 
articuloplist.prototype.render = function () {
    if (jsonData.status == 200) {
        var entrada = "";
 
        entrada += '<div class = "container">';
       
            entrada += '<div class = "col-md-offset-1 col-md-3 categoria">';
                entrada += '<div class = "buscador">' + '<input type="text" class="query" name="q" size="21" maxlength="255" value=" Búsqueda por categoría" onclick="this.select()">' + '</div>';
                //entrada += '<div class = "buscar">' + '<input type="submit" name="Buscar" value="Buscar">' + '</div>';
                entrada += '</div>';
 
                entrada += '<div class = "col-md-8 entradas">';
                    for (var i = 0; i <= jsonData.message.page.message.length - 1; i++) {
 
                        entrada += '<div class = "blog">';
                        //entrada += '<div class = "titulo">' + jsonData.message.page.message[i].id + '</div>' + '</br>';
                        entrada += '<div class = "titulo">' + jsonData.message.page.message[i].titulo + '</div>' + '</br>';
                        entrada += '<div class = "contenido">' + jsonData.message.page.message[i].contenido + '</div>';
                        entrada += '<div class = "datos">' + "Fecha de alta: " + jsonData.message.page.message[i].alta + " | ";
                        //autor += jsonData.message.page.message[i].autor;
                        entrada += "Visitas: " + jsonData.message.page.message[i].hits + " | ";
                        entrada += "Tags: " + jsonData.message.page.message[i].etiquetas + '</div>';
                        entrada += '</div>';
 
                    }
               
                entrada += '</div>';
        entrada += '</div>';
        return  entrada;
 
    }
    ;
 
};