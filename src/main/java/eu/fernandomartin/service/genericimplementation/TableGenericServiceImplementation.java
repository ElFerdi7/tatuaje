/*
 * Copyright (c) 2017-2018 
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 * 
 * GESANE: Free Open Source Health Management System
 *
 * Sources at:
 *                            https://github.com/rafaelaznar/gesane-server
 *                            https://github.com/rafaelaznar/gesane-client
 *                            https://github.com/rafaelaznar/gesane-database
 *
 * GESANE is distributed under the MIT License (MIT)
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
package eu.fernandomartin.service.genericimplementation;

import eu.fernandomartin.service.publicinterface.TableServiceInterface;
import com.google.gson.Gson;
import eu.fernandomartin.bean.genericimplementation.TableGenericBeanImplementation;
import eu.fernandomartin.bean.helper.MetaBeanHelper;
import eu.fernandomartin.bean.helper.ReplyBeanHelper;
import eu.fernandomartin.connection.publicinterface.ConnectionInterface;
import eu.fernandomartin.helper.constant.ConfigurationConstants;
import eu.fernandomartin.helper.Log4jHelper;
import eu.fernandomartin.factory.BeanFactory;
import eu.fernandomartin.factory.DaoFactory;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import eu.fernandomartin.helper.EncodingHelper;
import eu.fernandomartin.dao.publicinterface.TableDaoInterface;
import eu.fernandomartin.factory.ConnectionFactory;
import eu.fernandomartin.helper.constant.ConnectionConstants;
import eu.fernandomartin.helper.GsonHelper;

public abstract class TableGenericServiceImplementation extends ViewGenericServiceImplementation implements TableServiceInterface {

    public TableGenericServiceImplementation(HttpServletRequest request) {
        super(request);
    }


    @Override
    public ReplyBeanHelper get() throws Exception {
        if (this.checkPermission("get")) {
            int id = Integer.parseInt(oRequest.getParameter("id"));
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBeanHelper oReplyBean = null;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                TableDaoInterface oDao = (TableDaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                MetaBeanHelper oMetaBeanHelper = (MetaBeanHelper) oDao.get(id, ConfigurationConstants.jsonMsgDepth);
                String strJson = GsonHelper.getGson().toJson(oMetaBeanHelper);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

  
    private ReplyBeanHelper setoBean(TableGenericBeanImplementation oBean) throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        int iResult = 0;
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            TableDaoInterface oDao = (TableDaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            iResult = oDao.set(oBean);
            Gson oGson = GsonHelper.getGson();
            String strJson = oGson.toJson(iResult);
            oReplyBean = new ReplyBeanHelper(200, strJson);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
        return oReplyBean;
    }

    @Override
    public ReplyBeanHelper set() throws Exception {
        if (this.checkPermission("set")) {
            String jason = oRequest.getParameter("json");
            TableGenericBeanImplementation oBean = (TableGenericBeanImplementation) BeanFactory.getBean(ob, (MetaBeanHelper) oRequest.getSession().getAttribute("user"));
            Gson oGson = GsonHelper.getGson();
            oBean = oGson.fromJson(jason, oBean.getClass());
            ReplyBeanHelper oReplyBean = null;
            if (oBean == null) {
                throw new Exception("Bean null en service set");
            } else {
                oReplyBean = setoBean(oBean);
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

   
    @Override
    public ReplyBeanHelper remove() throws Exception {
        if (this.checkPermission("remove")) {
            int id = Integer.parseInt(oRequest.getParameter("id"));
            int iResult = 0;
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBeanHelper oReplyBean = null;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                TableDaoInterface oDao = (TableDaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                iResult = oDao.remove(id);
                Gson oGson = GsonHelper.getGson();
                String strJson = oGson.toJson(iResult);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

}
