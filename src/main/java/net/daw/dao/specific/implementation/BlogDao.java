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
package net.daw.dao.specific.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import net.daw.bean.group.GroupBeanImpl;
import net.daw.bean.specific.implementation.BlogBean;
import net.daw.bean.specific.implementation.DocumentoBean;
import net.daw.dao.generic.implementation.TableDaoGenImpl;
import net.daw.data.specific.implementation.MysqlDataSpImpl;

/**
 *
 * @author juliomiguel
 */
public class BlogDao extends TableDaoGenImpl<BlogBean> {

    public BlogDao(Connection pooledConnection) throws Exception {
        super(pooledConnection);
    }

    public ArrayList<BlogBean> getBlog(DocumentoBean oDocumentoBean, int id_usuario) throws Exception {

        //Se crea un arraylist de CuestionarioBean
        ArrayList<BlogBean> alBlog = new ArrayList();

        //Se pide la conexión y se le asigna la operación a ResultSet (getAllSql)
        MysqlDataSpImpl oMysql = new MysqlDataSpImpl(oConnection);
        
        //int cantidad = oMysql.getCount("SELECT count(d.id) FROM documento d, comentario c, documentocategoriaarticulo dca, categoriaarticulo cat WHERE d.id = c.id_documento AND dca.id_categoriaarticulo= cat.id AND d.id = dca.id_documento AND d.id=" + oDocumentoBean.getId());
        
     //   int hola = cantidad;
        if (oDocumentoBean.getId() > 0) {
            ResultSet result = oMysql.getAllSql("SELECT d.id id_documento, d.titulo, d.contenido entrada, d.id_usuario id_usuario, d.etiquetas, d.hits,c.id id_comentario, c.id_usuario usuariocomentario, c.contenido comentario, us.login nombreautor, d.alta, cat.id id_categoria, cat.nombre nombre_cat, cat.descripcion descripcion_cat FROM documento d, comentario c, documentocategoriaarticulo dca, categoriaarticulo cat, usuario us WHERE d.id = c.id_documento AND dca.id_categoriaarticulo= cat.id AND d.id = dca.id_documento AND c.id_usuario = us.id  AND d.id=" + oDocumentoBean.getId());
            if (result != null) {
                while (result.next()) {
                    BlogBean oBlogBean= new BlogBean();
                    oBlogBean.setId_documento(result.getInt("id_documento"));
                    oBlogBean.setTitulo(result.getString("titulo"));
                    oBlogBean.setEntrada(result.getString("entrada"));
                    oBlogBean.setEtiquetas(result.getString("etiquetas"));
                    oBlogBean.setHits(result.getInt("hits"));
                    oBlogBean.setId_comentario(result.getInt("id_comentario"));
                    oBlogBean.setComentario(result.getString("comentario"));
                    oBlogBean.setNombreautor(result.getString("nombreautor"));
                    oBlogBean.setAlta(result.getDate("alta"));
                    oBlogBean.setId_categoria(result.getInt("id_categoria"));
                    oBlogBean.setNombre_cat(result.getString("nombre_cat"));
                    oBlogBean.setDescripcion_cat(result.getString("descripcion_cat"));
                    oBlogBean.setId_usuario(result.getInt("id_usuario"));
                    oBlogBean.setUsuariocomentario(result.getInt("usuariocomentario"));
                    oBlogBean.setId_login(id_usuario);
                    alBlog.add(oBlogBean);
                }
            }
        }
        return alBlog;
    }
    
    public ArrayList<DocumentoBean> getall(DocumentoBean oDocumentoBean2) throws Exception {

        //Se crea un arraylist de CuestionarioBean
        ArrayList<DocumentoBean> alDocumento = new ArrayList();

        //Se pide la conexión y se le asigna la operación a ResultSet (getAllSql)
        MysqlDataSpImpl oMysql = new MysqlDataSpImpl(oConnection);
        
            ResultSet result = oMysql.getAllSql("SELECT documento.id, documento.titulo,documento.contenido, documento.alta, categoriaarticulo.nombre, categoriaarticulo.id id_categoria from documento, categoriaarticulo, documentocategoriaarticulo where documento.id_tipodocumento=2 and documentocategoriaarticulo.id_documento= documento.id AND categoriaarticulo.id = documentocategoriaarticulo.id_categoriaarticulo");
            if (result != null) {
                while (result.next()) {
                    DocumentoBean oDocumentoBean= new DocumentoBean();
                    
                    oDocumentoBean.setId(result.getInt("id"));
                    oDocumentoBean.setTitulo(result.getString("titulo"));
                    oDocumentoBean.setContenido(result.getString("contenido"));
                    oDocumentoBean.setAlta(result.getDate("alta"));
                    oDocumentoBean.setHits(result.getInt("id_categoria"));
                    oDocumentoBean.setEtiquetas(result.getString("nombre"));
                    oDocumentoBean.setId_usuario(oDocumentoBean2.getId_usuario());
                    alDocumento.add(oDocumentoBean);
                }
            }
        
        return alDocumento;
    }
    
}
