/*
 * Copyright (C) 2014 al037805
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package net.daw.dao.specific.implementation;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import net.daw.bean.generic.specific.implementation.ActividadBeanGenSpImpl;
import net.daw.dao.publicinterface.MetaDaoInterface;
import net.daw.dao.publicinterface.TableDaoInterface;
import net.daw.dao.publicinterface.ViewDaoInterface;
import net.daw.data.specific.implementation.MysqlDataSpImpl;
import net.daw.helper.statics.ExceptionBooster;
import net.daw.helper.statics.FilterBeanHelper;
import net.daw.helper.statics.SqlBuilder;

/**
 *
 * @author al037805
 */
public class ActividadDaoSpcImpl implements ViewDaoInterface<ActividadBeanGenSpImpl>, TableDaoInterface<ActividadBeanGenSpImpl>, MetaDaoInterface {

    private String strSqlDataSource = null;
    private MysqlDataSpImpl oMysql = null;
    private Connection oConnection = null;

    public ActividadDaoSpcImpl(String ob, Connection oConexion) throws Exception {
        //ob a extinguir como parametro
        try {
            strSqlDataSource = "select * from actividad where 1=1 ";
            oConnection = oConexion;
            oMysql = new MysqlDataSpImpl(oConnection);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":constructor ERROR: " + ex.getMessage()));
        }
    }

    @Override
    public int getPages(int intRegsPerPag, ArrayList<FilterBeanHelper> hmFilter) throws Exception {
        int pages = 0;
        try {
            strSqlDataSource += SqlBuilder.buildSqlWhere(hmFilter);
            pages = oMysql.getNewPages(strSqlDataSource, intRegsPerPag);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getPages ERROR: " + ex.getMessage()));
        }
        return pages;
    }

    @Override
    public int getCount(ArrayList<FilterBeanHelper> hmFilter) throws Exception {
        int pages = 0;
        try {
            strSqlDataSource += SqlBuilder.buildSqlWhere(hmFilter);
            pages = oMysql.getNewCount(strSqlDataSource);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getCount ERROR: " + ex.getMessage()));
        }
        return pages;
    }

    @Override
    public ArrayList<ActividadBeanGenSpImpl> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBeanHelper> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<ActividadBeanGenSpImpl> arrActividad = new ArrayList<>();
        try {
            strSqlDataSource += SqlBuilder.buildSqlWhere(hmFilter);
            strSqlDataSource += SqlBuilder.buildSqlOrder(hmOrder);
            arrId = oMysql.getNewPage(strSqlDataSource, intRegsPerPag, intPage);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                ActividadBeanGenSpImpl oActividadBean = new ActividadBeanGenSpImpl(iterador.next());
                arrActividad.add(this.get(oActividadBean, 1));
            }
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getPage ERROR: " + ex.getMessage()));
        }
        return arrActividad;
    }

    @Override
    public ActividadBeanGenSpImpl get(ActividadBeanGenSpImpl oActividadBean, Integer expand) throws Exception {
        if (oActividadBean.getId() > 0) {
            try {
                if (!oMysql.existsOne(strSqlDataSource, oActividadBean.getId())) {
                    oActividadBean.setId(0);
                } else {
                    oActividadBean.setEnunciado(oMysql.getOne(strSqlDataSource, "enunciado", oActividadBean.getId()));

                    String fecha = "";
                    fecha = oMysql.getOne(strSqlDataSource, "fecha", oActividadBean.getId());
                    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                    oActividadBean.setFecha(date.parse(fecha));

                    oActividadBean.setEvaluacion(Integer.valueOf(oMysql.getOne(strSqlDataSource, "evaluacion", oActividadBean.getId())));
                    oActividadBean.setActivo((byte) Integer.parseInt(oMysql.getOne(strSqlDataSource, "activo", oActividadBean.getId())));

                }
            } catch (Exception ex) {
                ExceptionBooster.boost(new Exception(this.getClass().getName() + ":get ERROR: " + ex.getMessage()));
            }
        } else {
            oActividadBean.setId(0);
        }
        return oActividadBean;
    }

    @Override
    public ActividadBeanGenSpImpl set(ActividadBeanGenSpImpl oActividadBean) throws Exception {
        try {
            if (oActividadBean.getId() == 0) {
                oActividadBean.setId(oMysql.insertOne(strSqlDataSource));
            }
            oMysql.updateOne(oActividadBean.getId(), strSqlDataSource, "enunciado", oActividadBean.getEnunciado());

            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            oMysql.updateOne(oActividadBean.getId(), strSqlDataSource, "fecha", date.format(oActividadBean.getFecha()));

            oMysql.updateOne(oActividadBean.getId(), strSqlDataSource, "evaluacion", oActividadBean.getEvaluacion().toString());

            oMysql.updateOne(oActividadBean.getId(), strSqlDataSource, "activo", Integer.toString(oActividadBean.getActivo()));
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return oActividadBean;
    }

    @Override
    public int remove(ActividadBeanGenSpImpl oActividadBean) throws Exception {
        int result = 0;
        try {
            result = oMysql.removeOne(oActividadBean.getId(), strSqlDataSource);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":remove ERROR: " + ex.getMessage()));
        }
        return result;
    }

    @Override
    public ArrayList<String> getColumnsNames() throws Exception {
        ArrayList<String> alColumns = null;
        try {
            alColumns = oMysql.getColumnsName(strSqlDataSource);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getColumnsNames ERROR: " + ex.getMessage()));
        }
        return alColumns;
    }

    @Override
    public ArrayList<String> getPrettyColumnsNames() throws Exception {
        ArrayList<String> alColumns = null;
        try {
            alColumns = oMysql.getPrettyColumns(strSqlDataSource);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getPrettyColumnsNames ERROR: " + ex.getMessage()));
        }
        return alColumns;
    }

    @Override
    public int updateOne(int intId, String strTabla, String strCampo, String strValor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    

}
