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
import java.util.HashMap;
import net.daw.bean.group.GroupBeanImpl;
import net.daw.bean.specific.implementation.CategoriaarticuloBean;
import net.daw.bean.specific.implementation.ComentarioBean;
import net.daw.bean.specific.implementation.DocumentoBean;
import net.daw.dao.generic.implementation.TableDaoGenImpl;
import net.daw.data.specific.implementation.MysqlDataSpImpl;
import net.daw.helper.statics.ExceptionBooster;
import net.daw.helper.statics.FilterBeanHelper;
import net.daw.helper.statics.SqlBuilder;

/**
 *
 * @author los increibles
 * dedicada a la hermana de Laorden
 */
public class ComentarioDao extends TableDaoGenImpl<ComentarioBean> {

    public ComentarioDao(Connection pooledConnection) throws Exception {
        super(pooledConnection);
    }
    
 
    

    @Override
    public ArrayList<ComentarioBean> getAll(ArrayList<FilterBeanHelper> alFilter, HashMap<String, String> hmOrder) throws Exception {

        MysqlDataSpImpl oMysql = new MysqlDataSpImpl(oConnection);
        strSqlSelectDataOrigin += SqlBuilder.buildSqlWhere(alFilter);
        strSqlSelectDataOrigin += SqlBuilder.buildSqlOrder(hmOrder);
        ArrayList<ComentarioBean> alComentarios = new ArrayList<>();
        try {
            ResultSet result = oMysql.getAllSql(strSqlSelectDataOrigin);
            if (result != null) {
                while (result.next()) {
                    ComentarioBean oComentarioBean = new ComentarioBean();
                    oComentarioBean.setId(result.getInt("id"));
                    oComentarioBean.setId_documento(result.getInt("id_documento"));

                    
                    DocumentoDao oDocumentoDao = new DocumentoDao(oConnection);
                   
                    DocumentoBean oDocumentoBean = new DocumentoBean();
                    oDocumentoBean.setId(result.getInt("id_documento"));

                    oDocumentoBean = oDocumentoDao.get(oDocumentoBean, 2);
                  
                    GroupBeanImpl oGroupBeanImpl = new GroupBeanImpl();
                    oGroupBeanImpl.setBean(oDocumentoBean);
                    oGroupBeanImpl.setMeta(oDocumentoDao.getmetainformation());
                    oComentarioBean.setObj_documento(oGroupBeanImpl);

             
                    oComentarioBean.setContenido(result.getString("contenido"));
                    alComentarios.add(oComentarioBean);
                }
            }
        } catch (Exception ex) {
            throw new Exception(this.getClass().getName() + ":get ERROR: " + ex.getMessage());
        }

        return alComentarios;

    }
    
        public ComentarioBean set(ComentarioBean oComentarioBean, int id){
        try {
            Boolean isNew = false;

            if(id == oComentarioBean.getId_usuario()){
            
            if (oComentarioBean.getId() == 0) {
                oComentarioBean.setId(oMysql.insertOne(strTableOrigin));
                isNew = true;
            }
            oMysql.updateOne(oComentarioBean.getId(), strTableOrigin, "contenido", oComentarioBean.getContenido());
            oMysql.updateOne(oComentarioBean.getId(), strTableOrigin, "id_documento", oComentarioBean.getId_documento().toString());
            oMysql.updateOne(oComentarioBean.getId(), strTableOrigin, "id_usuario", oComentarioBean.getId_usuario().toString());
//            oMysql.updateOne(oComentarioBean.getId(), strTableOrigin, "firma", oComentarioBean.get);
//            oMysql.updateOne(oComentarioBean.getId(), strTableOrigin, "skin", oComentarioBean.getSkin());
//            String prueba = oComentarioBean.getPassword();

//            if (isNew == false) {
//                if (oComentarioBean.getId() != 0 ) {
//                     || oComentarioBean.getPassword().equals("")
//                    oMysql.updateOne(oComentarioBean.getId(), strTableOrigin, "password", oMysql.getOne(strTableOrigin, "password", oComentarioBean.getId()));
//                } else {
//                    oMysql.updateOne(oComentarioBean.getId(), strTableOrigin, "password", oComentarioBean.getPassword());
//                }
//            } else {
//                oMysql.updateOne(oComentarioBean.getId(), strTableOrigin, "password", oComentarioBean.getPassword());
//            }
            }
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return oComentarioBean;
    }
}

