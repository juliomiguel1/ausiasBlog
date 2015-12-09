/*
 * Copyright (c) 2015 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * openAUSIAS: The stunning micro-library that helps you to develop easily 
 *             AJAX web applications by using Java and jQuery
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
 */


appMenu = function () {
    return (
            dom.li('', //'class="active"'
                    dom.a('href="#/home"', 'Home')
                    ) +
            dom.li('',
                    dom.a('href="#/about"',
                            dom.i('class="fa fa-icon-smile"', '') +
                            'About'
                            )
                    ) +
            dom.li('class="dropdown"',
                    dom.a('href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"',
                            dom.i('class="fa fa-icon-list-alt"', '') +
                            'Principal' +
                            dom.span('class="caret"', '')
                            ) +
                    dom.ul('class="dropdown-menu" role="menu"',
                            dom.li('',
                                    dom.a('href="#/documento/plist"',
                                            dom.i('class="fa fa-fw fa-file-text"', '') +
                                            'Documentos'
                                            )
                                    ) +
                            dom.li('',
                                    dom.a('href="#/usuario/plist"',
                                            dom.i('class="fa fa-fw fa-user"', '') +
                                            'Usuarios'
                                            )
                                    )
                            )
                    ) +
            dom.li('class="dropdown"',
                    dom.a('href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"',
                            dom.i('class="fa fa-icon-list-alt"', '') +
                            'Consultas' +
                            dom.span('class="caret"', '')
                            ) +
                    dom.ul('class="dropdown-menu" role="menu"',
                            dom.li('class="dropdown-header"', 'Documento') +
                            dom.li('',
                                    dom.a('href="#/documento/abc"',
                                            dom.i('class="fa fa-fw fa-power-off"', '') +
                                            'Documento abc'
                                            )
                                    ) +
                            dom.li('',
                                    dom.a('href="#/documento/documentosautor"',
                                            dom.i('class="fa fa-fw fa-file-text"', '') +
                                            'Documentos x autor list'
                                            )
                                    )
                            )

                    ) +
            dom.li('class="dropdown"',
                    dom.a('href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"',
                            dom.i('class="fa fa-icon-list-alt"', '') +
                            'Configuración' +
                            dom.span('class="caret"', '')
                            ) +
                    dom.ul('class="dropdown-menu" role="menu"',
                            dom.li('class="dropdown-header"', 'Relacionados con el documento') +
                            dom.li('',
                                    dom.a('href="#/tipodocumento/plist"',
                                            dom.i('class="fa fa-fw fa-tag"', '') +
                                            'Tipos de documento'
                                            )
                                    ) +
                            dom.li('class="divider"', '') +
                            dom.li('class="dropdown-header"', 'Relacionados con el usuario') +
                            dom.li('',
                                    dom.a('href="#/estado/plist"',
                                            dom.i('class="fa fa-fw fa-smile-o"', '') +
                                            'Estados de usuario'
                                            )
                                    ) +
                            dom.li('',
                                    dom.a('href="#/tipousuario/plist"',
                                            dom.i('class="fa fa-fw fa-male"', '') +
                                            'Tipos de usuario'
                                            )
                                    )

                            )
                    ) +
            dom.li('class="dropdown"',
                    dom.a('href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"',
                            dom.i('class="fa fa-icon-list-alt"', '') +
                            'Proyectos' +
                            dom.span('class="caret"', '')
                            ) +
                    dom.ul('class="dropdown-menu" role="menu"',
                            dom.li('class="dropdown-header"', 'Blog') +
                            dom.li('',
                                    dom.a('href="#/blog/list"',
                                            dom.i('class="fa fa-fw fa-power-off"', '') +
                                            'Blog'
                                            )
                                    )
                            )

                    )

            )
}