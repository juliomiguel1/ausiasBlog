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
package net.daw.service.specific.implementation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.specific.implementation.BlogBean;
import net.daw.bean.specific.implementation.DocumentoBean;
import net.daw.bean.specific.implementation.UsuarioBean;
import net.daw.connection.implementation.BoneConnectionPoolImpl;
import net.daw.dao.specific.implementation.BlogDao;
import net.daw.helper.statics.ParameterCook;
import net.daw.service.generic.implementation.TableServiceGenImpl;

/**
 *
 * @author juliomiguel
 */
public class BlogService extends TableServiceGenImpl {

    public BlogService(HttpServletRequest request) {
        super(request);
    }
 
      public String get() throws Exception {

        Connection oConnection = new BoneConnectionPoolImpl().newConnection();
        UsuarioBean oUserBean = (UsuarioBean) oRequest.getSession().getAttribute("userBean");
        int id_usuario = oUserBean.getId();
        BlogDao oBlogDao = new BlogDao(oConnection);
        
        int id = ParameterCook.prepareId(oRequest);
        
        DocumentoBean oDocumentoBean = new DocumentoBean();
        oDocumentoBean.setId(id);
        ArrayList<BlogBean> alBlogBean = new ArrayList();
        alBlogBean = oBlogDao.getBlog(oDocumentoBean, id_usuario);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("dd/MM/yyyy");
        Gson gson = gsonBuilder.create();
        String data = "{\"status\":200,\"message\":" + gson.toJson(alBlogBean) + "}";

        return data;

    }
      
       public String getall() throws Exception {

        Connection oConnection = new BoneConnectionPoolImpl().newConnection();
        BlogDao oBlogDao = new BlogDao(oConnection);
        
        UsuarioBean oUserBean = (UsuarioBean) oRequest.getSession().getAttribute("userBean");
        int id_usuario = oUserBean.getId();
        
        int id = ParameterCook.prepareId(oRequest);
        
        DocumentoBean oDocumentoBean = new DocumentoBean();
        oDocumentoBean.setId(id);
        oDocumentoBean.setId_usuario(id_usuario);
        ArrayList<DocumentoBean> alBlogBean = new ArrayList();
        alBlogBean = oBlogDao.getall(oDocumentoBean);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("dd/MM/yyyy");
        Gson gson = gsonBuilder.create();
        String data = "{\"status\":200,\"message\":" + gson.toJson(alBlogBean) + "}";

        return data;

    }
    
}
