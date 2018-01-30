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
package eu.fernandomartin.factory;

import eu.fernandomartin.bean.helper.MetaBeanHelper;
import eu.fernandomartin.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.fernandomartin.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.fernandomartin.dao.publicinterface.MetaDaoInterface;
import eu.fernandomartin.dao.specificimplementation.BocetoSpecificDaoImplementation;
import eu.fernandomartin.dao.specificimplementation.ClienteSpecificDaoImplementation;
import eu.fernandomartin.dao.specificimplementation.FacturaSpecificDaoImplementation;
import eu.fernandomartin.dao.specificimplementation.GaleriaSpecificDaoImplementation;
import eu.fernandomartin.dao.specificimplementation.ServicioSpecificDaoImplementation;
import eu.fernandomartin.dao.specificimplementation.SesionSpecificDaoImplementation;
import eu.fernandomartin.dao.specificimplementation.TipopagoSpecificDaoImplementation;
import eu.fernandomartin.dao.specificimplementation.TipousuarioSpecificDaoImplementation;
import eu.fernandomartin.dao.specificimplementation.UsuarioSpecificDaoImplementation;
import java.sql.Connection;

public class DaoFactory {

    public static MetaDaoInterface getDao(String ob, Connection oConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        MetaDaoInterface oDao = null;
        switch (ob) {
            case "usuario":
//                if (oPuserBean_security == null) {
//                    oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                    break;
//                } else {
//                    oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
//                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
//                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
//                    Integer idTipousuario = oTipoUsuario.getId();
//                    switch (idTipousuario) {
//                        case 1:
//                            oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
//                    }
//                }
                oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
               
                break;
            case "tipousuario":
                oDao = (MetaDaoInterface) new TipousuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "tipopago":
                oDao = (MetaDaoInterface) new TipopagoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "factura":
                oDao = (MetaDaoInterface) new FacturaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "boceto":
                oDao = (MetaDaoInterface) new BocetoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "galeria":
                oDao = (MetaDaoInterface) new GaleriaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "sesion":
                oDao = (MetaDaoInterface) new SesionSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "servicio":
                oDao = (MetaDaoInterface) new ServicioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            case "cliente":
                oDao = (MetaDaoInterface) new ClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            default:
                //oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oDao;
    }

}
