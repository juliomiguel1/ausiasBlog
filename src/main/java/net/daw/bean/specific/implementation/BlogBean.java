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
import java.util.Date;
import net.daw.bean.generic.implementation.BeanGenImpl;
import net.daw.bean.publicinterface.BeanInterface;
import net.daw.helper.annotations.MethodMetaInformation;
import net.daw.helper.annotations.SelectSourceMetaInformation;
import net.daw.helper.statics.MetaEnum;

/**
 *
 * @author juliomiguel
 */
@SelectSourceMetaInformation(
        SqlSelect = "SELECT d.id id_documento, d.titulo, d.contenido entrada, d.id_usuario id_usuario, d.etiquetas, d.hits,c.id id_comentario, c.id_usuario usuarioComentario, c.contenido comentario, c.nombreautor, d.alta, cat.id id_categoria, cat.nombre nombre_cat, cat.descripcion descripcion_cat FROM documento d, comentario c, documentocategoriaarticulo dca, categoriaarticulo cat WHERE d.id = c.id_documento AND dca.id_categoriaarticulo= cat.id AND d.id = dca.id_documento",
        Description = "Articulo"
)

public class BlogBean extends BeanGenImpl implements BeanInterface {

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Iden.",
            ShortName = "Iden. Heredado",
            Description = "Número Identificador Documento",
            Type = MetaEnum.FieldType.Integer,
            DefaultValue = "0"
    )
    private Integer id_documento = 0;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Tít.",
            ShortName = "Título",
            Description = "Título del documento",
            Type = MetaEnum.FieldType.String,
            MinLength = 1,
            MaxLength = 255,
            DefaultValue = "Sin título",
            IsForeignKeyDescriptor = true
    )
    private String titulo = "";

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Cont.",
            ShortName = "Contenido",
            Description = "Cuerpo del documento",
            Type = MetaEnum.FieldType.String,
            MinLength = 1,
            MaxLength = 999999999,
            DefaultValue = "Sin contenido"
    )
    private String entrada = "";

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Iden.",
            ShortName = "Iden. Heredado",
            Description = "Número Identificador Usuario",
            Type = MetaEnum.FieldType.Integer,
            DefaultValue = "0"
    )
    private Integer id_usuario = 0;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Etiq.",
            ShortName = "Etiquetas",
            Description = "Etiquetas del documento",
            Type = MetaEnum.FieldType.String,
            MinLength = 0,
            MaxLength = 255,
            DefaultValue = ""
    )
    private String etiquetas = "";

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Hits",
            ShortName = "Hits",
            Description = "Número de visitas del documento",
            Type = MetaEnum.FieldType.Integer
    )
    private Integer hits = 0;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Iden.",
            ShortName = "Iden. Heredado",
            Description = "Número Identificador Comentario",
            Type = MetaEnum.FieldType.Integer,
            DefaultValue = "0"
    )
    private Integer id_comentario = 0;

     @Expose
    @MethodMetaInformation(
            UltraShortName = "Iden.",
            ShortName = "Iden. Heredado",
            Description = "Número Identificador Comentario",
            Type = MetaEnum.FieldType.Integer,
            DefaultValue = "0"
    )
    private Integer usuariocomentario = 0;
    
    @Expose
    @MethodMetaInformation(
            UltraShortName = "Cont.",
            ShortName = "Contenido",
            Description = "Contenido del Comentario",
            Type = MetaEnum.FieldType.String
    )
    private String comentario;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "NomAut.",
            ShortName = "Nombre Autor",
            Description = "Nombre del autor del comentario",
            Type = MetaEnum.FieldType.String
    )
    private String nombreautor;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "F.alta",
            ShortName = "Fecha de alta",
            Description = "Fecha de creación del documento",
            Type = MetaEnum.FieldType.Date,
            DefaultValue = "01/01/2000",
            IsForeignKeyDescriptor = true
    )
    private Date alta = new Date();

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Iden.",
            ShortName = "Iden. Heredado",
            Description = "Número Identificador Categoria",
            Type = MetaEnum.FieldType.Integer,
            DefaultValue = "0"
    )
    private Integer id_categoria = 0;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Nom.",
            ShortName = "Nombre",
            Description = "Nombre de la categoría",
            Type = MetaEnum.FieldType.String
    )
    private String nombre_cat;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Desc.",
            ShortName = "Descripción",
            Description = "Descripción de la categoría",
            Type = MetaEnum.FieldType.String
    )
    private String descripcion_cat;
    
    @Expose
    @MethodMetaInformation(
            UltraShortName = "Iden.",
            ShortName = "Iden. Heredado",
            Description = "Número Identificador login",
            Type = MetaEnum.FieldType.Integer,
            DefaultValue = "0"
    )
    private Integer id_login = 0;
    
    /**
     * @return the id_documento
     */
    public Integer getId_documento() {
        return id_documento;
    }

    /**
     * @param id_documento the id_documento to set
     */
    public void setId_documento(Integer id_documento) {
        this.id_documento = id_documento;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the entrada
     */
    public String getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the etiquetas
     */
    public String getEtiquetas() {
        return etiquetas;
    }

    /**
     * @param etiquetas the etiquetas to set
     */
    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     * @return the hits
     */
    public Integer getHits() {
        return hits;
    }

    /**
     * @param hits the hits to set
     */
    public void setHits(Integer hits) {
        this.hits = hits;
    }

    /**
     * @return the id_comentario
     */
    public Integer getId_comentario() {
        return id_comentario;
    }

    /**
     * @param id_comentario the id_comentario to set
     */
    public void setId_comentario(Integer id_comentario) {
        this.id_comentario = id_comentario;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the nombreautor
     */
    public String getNombreautor() {
        return nombreautor;
    }

    /**
     * @param nombreautor the nombreautor to set
     */
    public void setNombreautor(String nombreautor) {
        this.nombreautor = nombreautor;
    }

    /**
     * @return the alta
     */
    public Date getAlta() {
        return alta;
    }

    /**
     * @param alta the alta to set
     */
    public void setAlta(Date alta) {
        this.alta = alta;
    }

    /**
     * @return the id_categoria
     */
    public Integer getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the nombre_cat
     */
    public String getNombre_cat() {
        return nombre_cat;
    }

    /**
     * @param nombre_cat the nombre_cat to set
     */
    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    /**
     * @return the descripcion_cat
     */
    public String getDescripcion_cat() {
        return descripcion_cat;
    }

    /**
     * @param descripcion_cat the descripcion_cat to set
     */
    public void setDescripcion_cat(String descripcion_cat) {
        this.descripcion_cat = descripcion_cat;
    }

    /**
     * @return the id_usuario
     */
    public Integer getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_login
     */
    public Integer getId_login() {
        return id_login;
    }

    /**
     * @param id_login the id_login to set
     */
    public void setId_login(Integer id_login) {
        this.id_login = id_login;
    }

    /**
     * @return the usuariocomentario
     */
    public Integer getUsuariocomentario() {
        return usuariocomentario;
    }

    /**
     * @param usuariocomentario the usuariocomentario to set
     */
    public void setUsuariocomentario(Integer usuariocomentario) {
        this.usuariocomentario = usuariocomentario;
    }

}
