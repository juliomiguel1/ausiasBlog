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
package net.daw.bean.specific.implementation;

import com.google.gson.annotations.Expose;
import net.daw.bean.generic.implementation.BeanGenImpl;
import net.daw.bean.group.GroupBeanImpl;
import net.daw.bean.publicinterface.BeanInterface;
import net.daw.helper.annotations.MethodMetaInformation;
import net.daw.helper.annotations.TableSourceMetaInformation;
import net.daw.helper.statics.MetaEnum;

/**
 *
 * @author a022583461z
 */
@TableSourceMetaInformation(
        TableName = "documentocategoriaarticulo",
        Description = "documento categoria articulo"
)

public class DocumentocategoriaarticuloBean extends BeanGenImpl implements BeanInterface {

    @Expose
    @MethodMetaInformation(
            IsId = true,
            UltraShortName = "Iden.",
            ShortName = "Identif.",
            Description = "Número Identificador",
            Type = MetaEnum.FieldType.Integer,
            DefaultValue = "0"
    )
    private Integer id = 0; //siempre inicializar los id a 0

    @Expose(serialize = false)
    @MethodMetaInformation(
            UltraShortName = "Documento",
            ShortName = "Documento",
            Description = "Identificador de Documento",
            IsIdForeignKey = true,
            ReferencesTable = "documento",
            Type = MetaEnum.FieldType.Integer
    )
    private Integer id_documento = 0; //important zero-initialize foreign keys

    @Expose(deserialize = false)
    @MethodMetaInformation(
            UltraShortName = "Documento",
            ShortName = "Documento",
            Description = "Referencia al documento",
            IsObjForeignKey = true,
            ReferencesTable = "documento",
            MyIdName = "id_documento"
    )
    private GroupBeanImpl obj_documento = null;

    @Expose(serialize = false)
    @MethodMetaInformation(
            UltraShortName = "Categoria",
            ShortName = "Categoria articulo",
            Description = "Identificador de categoria articulo",
            IsIdForeignKey = true,
            ReferencesTable = "categoriaarticulo",
            Type = MetaEnum.FieldType.Integer
    )
    private Integer id_categoriaarticulo = 0; //important zero-initialize foreign keys

    @Expose(deserialize = false)
    @MethodMetaInformation(
            UltraShortName = "Categoria",
            ShortName = "Categoria articulo",
            Description = "Referencia a la categoria articulo",
            IsObjForeignKey = true,
            ReferencesTable = "categoriaarticulo",
            MyIdName = "id_categoriaarticulo"
    )
    private GroupBeanImpl obj_categoriaarticulo = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_documento() {
        return id_documento;
    }

    public void setId_documento(Integer id_documento) {
        this.id_documento = id_documento;
    }

    public GroupBeanImpl getObj_documento() {
        return obj_documento;
    }

    public void setObj_documento(GroupBeanImpl obj_documento) {
        this.obj_documento = obj_documento;
    }

    public Integer getId_categoriaarticulo() {
        return id_categoriaarticulo;
    }

    public void setId_categoriaarticulo(Integer id_categoriaarticulo) {
        this.id_categoriaarticulo = id_categoriaarticulo;
    }

    public GroupBeanImpl getObj_categoriaarticulo() {
        return obj_categoriaarticulo;
    }

    public void setObj_categoriaarticulo(GroupBeanImpl obj_categoriaarticulo) {
        this.obj_categoriaarticulo = obj_categoriaarticulo;
    }

}
