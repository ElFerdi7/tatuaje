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
package eu.fernandomartin.service.specificimplementation;

import com.google.gson.Gson;
import eu.fernandomartin.service.genericimplementation.TableGenericServiceImplementation;
import eu.fernandomartin.bean.helper.MetaBeanHelper;
import eu.fernandomartin.bean.helper.ReplyBeanHelper;
import eu.fernandomartin.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.fernandomartin.connection.publicinterface.ConnectionInterface;
import eu.fernandomartin.dao.specificimplementation.UsuarioSpecificDaoImplementation;
import eu.fernandomartin.factory.ConnectionFactory;
import eu.fernandomartin.helper.constant.ConnectionConstants;
import eu.fernandomartin.dao.publicinterface.MetaDaoInterface;
import eu.fernandomartin.factory.DaoFactory;
import eu.fernandomartin.helper.EncodingHelper;
import eu.fernandomartin.helper.GsonHelper;
import eu.fernandomartin.helper.Log4jHelper;
import eu.fernandomartin.helper.RandomHelper;
import eu.fernandomartin.helper.constant.ConfigurationConstants;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UsuarioSpecificServiceImplementation extends TableGenericServiceImplementation {

    public UsuarioSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }

    public ReplyBeanHelper getallobjectsmetadata() throws Exception {
        ReplyBeanHelper oReplyBean = null;
        HashMap hmObjectsMetaData = new HashMap();
        MetaDaoInterface oDao = null;

        oDao = DaoFactory.getDao("usuario", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
        hmObjectsMetaData.put("usuario", oDao.getObjectMetaData());
        oDao = DaoFactory.getDao("tipousuario", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
        hmObjectsMetaData.put("tipousuario", oDao.getObjectMetaData());       
        oDao = DaoFactory.getDao("tipopago", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
        hmObjectsMetaData.put("tipopago", oDao.getObjectMetaData());      
        oDao = DaoFactory.getDao("factura", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
        hmObjectsMetaData.put("factura", oDao.getObjectMetaData());
        oDao = DaoFactory.getDao("boceto", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
        hmObjectsMetaData.put("boceto", oDao.getObjectMetaData());
         oDao = DaoFactory.getDao("galeria", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
        hmObjectsMetaData.put("galeria", oDao.getObjectMetaData());
         oDao = DaoFactory.getDao("sesion", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
        hmObjectsMetaData.put("sesion", oDao.getObjectMetaData());
         oDao = DaoFactory.getDao("servicio", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
        hmObjectsMetaData.put("servicio", oDao.getObjectMetaData());
         oDao = DaoFactory.getDao("cliente", null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
        hmObjectsMetaData.put("cliente", oDao.getObjectMetaData());
        String strJson = GsonHelper.getGson().toJson(hmObjectsMetaData);
        oReplyBean = new ReplyBeanHelper(200, strJson);
        return oReplyBean;
    }

    public ReplyBeanHelper login() throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        UsuarioSpecificBeanImplementation oUsuarioBean = new UsuarioSpecificBeanImplementation();
        oUsuarioBean.setLogin(oRequest.getParameter("user"));
        oUsuarioBean.setPassword(oRequest.getParameter("pass"));
        if (!oUsuarioBean.getLogin().equalsIgnoreCase("") || !oUsuarioBean.getPassword().equalsIgnoreCase("")) {
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                UsuarioSpecificDaoImplementation oDao = new UsuarioSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                MetaBeanHelper oMetaBeanHelper = oDao.getFromLoginAndPass(oUsuarioBean);
                HttpSession oSession = oRequest.getSession();
                oSession.setAttribute("user", oMetaBeanHelper);
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
        }
        return oReplyBean;
    }

    public ReplyBeanHelper logout() throws Exception {
        HttpSession oSession = oRequest.getSession();
        oSession.invalidate();
        ReplyBeanHelper oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate("Session is closed"));
        return oReplyBean;
    }

    public ReplyBeanHelper getSessionStatus() throws Exception {
        ReplyBeanHelper oReplyBean = null;
        UsuarioSpecificBeanImplementation oUsuarioBean = null;
        try {
            HttpSession oSession = oRequest.getSession();
            MetaBeanHelper oMetaBeanHelper = (MetaBeanHelper) oSession.getAttribute("user");
            if (oMetaBeanHelper != null) {
                String strJson = GsonHelper.getGson().toJson(oMetaBeanHelper);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } else {
                oReplyBean = new ReplyBeanHelper(401, null);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return oReplyBean;
    }

    public ReplyBeanHelper getSessionUserLevel() {
        ReplyBeanHelper oReplyBean = null;
        String strAnswer = null;
        MetaBeanHelper oUserBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
        Map<Integer, String> map = new HashMap<>();
        if (oUserBean == null) {
            oReplyBean = new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        } else {
            oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate(((UsuarioSpecificBeanImplementation) oUserBean.getBean()).getId_tipousuario().toString()));
        }
        return oReplyBean;
    }

    public ReplyBeanHelper setPass() throws Exception {
        if (this.checkPermission("passchange")) {
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            String oldPass = oRequest.getParameter("old");
            String newPass = oRequest.getParameter("new");
            ReplyBeanHelper oReplyBean = null;
            Integer iResult = 0;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                oConnection.setAutoCommit(false);
                UsuarioSpecificDaoImplementation oUserDao = new UsuarioSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                MetaBeanHelper oSessionUsuarioBeanMeta = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
                UsuarioSpecificBeanImplementation oSessionUsuarioBean = (UsuarioSpecificBeanImplementation) oSessionUsuarioBeanMeta.getBean();
                if (oSessionUsuarioBean.getPassword().equalsIgnoreCase(oldPass)) {
                    oSessionUsuarioBean.setPassword(newPass);
                    iResult = oUserDao.set(oSessionUsuarioBean);
                    if (iResult >= 1) {
                        oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate(iResult.toString()));
                    } else {
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Server error during password change operation"));
                    }
                } else {
                    oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate(iResult.toString()));
                }
                oConnection.commit();
            } catch (Exception ex) {
                if (oConnection != null) {
                    oConnection.rollback();
                }
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

    public ReplyBeanHelper checklogin() throws SQLException, Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        UsuarioSpecificBeanImplementation oPuser = null;
        String strAnswer = null;
        String strCode = "200";
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            String login = oRequest.getParameter("login");
            if (!login.isEmpty()) {
                try {
                    UsuarioSpecificDaoImplementation oUserDao = new UsuarioSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                    if (oUserDao.getIDfromUser(login) == 0) {
                        oReplyBean = new ReplyBeanHelper(200, EncodingHelper.quotate("OK"));
                    } else {
                        oReplyBean = new ReplyBeanHelper(403, EncodingHelper.quotate("Server error during checklogin operation"));
                    }
                } catch (Exception ex) {
                    String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                    Log4jHelper.errorLog(msg, ex);
                    throw new Exception(msg, ex);
                }
            }
        } catch (Exception ex) {
            if (oConnection != null) {
                oConnection.rollback();
            }
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
    
}
