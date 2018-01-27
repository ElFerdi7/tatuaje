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

import eu.fernandomartin.bean.helper.ReplyBeanHelper;
import eu.fernandomartin.helper.EncodingHelper;
import eu.fernandomartin.service.specificimplementation.BocetoSpecificServiceImplementation;
import eu.fernandomartin.service.specificimplementation.ClienteSpecificServiceImplementation;
import eu.fernandomartin.service.specificimplementation.FacturaSpecificServiceImplementation;
import eu.fernandomartin.service.specificimplementation.GaleriaSpecificServiceImplementation;
import eu.fernandomartin.service.specificimplementation.ServicioSpecificServiceImplementation;
import eu.fernandomartin.service.specificimplementation.SesionSpecificServiceImplementation;
import eu.fernandomartin.service.specificimplementation.TipopagoSpecificServiceImplementation;
import eu.fernandomartin.service.specificimplementation.TipousuarioSpecificServiceImplementation;
import eu.fernandomartin.service.specificimplementation.UsuarioSpecificServiceImplementation;
import javax.servlet.http.HttpServletRequest;

public class ServiceFactory {

    public static ReplyBeanHelper executeMethodService(HttpServletRequest oRequest) throws Exception {
        String ob = oRequest.getParameter("ob");
        String op = oRequest.getParameter("op");
        ReplyBeanHelper oReplyBean = null;
        switch (ob) {
            case "usuario":
                UsuarioSpecificServiceImplementation oUsuarioService = new UsuarioSpecificServiceImplementation(oRequest);
                switch (op) {

                    case "getallobjectsmetadata":
                        oReplyBean = oUsuarioService.getallobjectsmetadata();
                        break;
                    case "getmetadata":
                        oReplyBean = oUsuarioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oUsuarioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oUsuarioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oUsuarioService.get();
                        break;
                    case "set":
                        oReplyBean = oUsuarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oUsuarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oUsuarioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oUsuarioService.getCount();
                        break;
                    case "login":
                        oReplyBean = oUsuarioService.login();
                        break;
                    case "logout":
                        oReplyBean = oUsuarioService.logout();
                        break;
                    case "getsessionstatus":
                        oReplyBean = oUsuarioService.getSessionStatus();
                        break;
                    case "getcountx":
                        oReplyBean = oUsuarioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oUsuarioService.getPageX();
                        break;
                    case "setpass":
                        oReplyBean = oUsuarioService.setPass();
                        break;
                    case "getsessionuserlevel":
                        oReplyBean = oUsuarioService.getSessionUserLevel();
                        break;
                    case "checklogin":
                        oReplyBean = oUsuarioService.checklogin();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "tipousuario":
                TipousuarioSpecificServiceImplementation oTipousuarioService = new TipousuarioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipousuarioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipousuarioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipousuarioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipousuarioService.get();
                        break;
                    case "set":
                        oReplyBean = oTipousuarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipousuarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipousuarioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipousuarioService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "tipopago":
                TipopagoSpecificServiceImplementation oTipopagoService = new TipopagoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipopagoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipopagoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipopagoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipopagoService.get();
                        break;
                    case "set":
                        oReplyBean = oTipopagoService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipopagoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipopagoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipopagoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "factura":
                FacturaSpecificServiceImplementation oFacturaService = new FacturaSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oFacturaService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oFacturaService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oFacturaService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oFacturaService.get();
                        break;
                    case "set":
                        oReplyBean = oFacturaService.set();
                        break;
                    case "remove":
                        oReplyBean = oFacturaService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oFacturaService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oFacturaService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oFacturaService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oFacturaService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "boceto":
                BocetoSpecificServiceImplementation oBocetoService = new BocetoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oBocetoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oBocetoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oBocetoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oBocetoService.get();
                        break;
                    case "set":
                        oReplyBean = oBocetoService.set();
                        break;
                    case "remove":
                        oReplyBean = oBocetoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oBocetoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oBocetoService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oBocetoService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oBocetoService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "galeria":
                GaleriaSpecificServiceImplementation oGaleriaService = new GaleriaSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oGaleriaService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oGaleriaService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oGaleriaService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oGaleriaService.get();
                        break;
                    case "set":
                        oReplyBean = oGaleriaService.set();
                        break;
                    case "remove":
                        oReplyBean = oGaleriaService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oGaleriaService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oGaleriaService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oGaleriaService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oGaleriaService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "sesion":
                SesionSpecificServiceImplementation oSesionService = new SesionSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oSesionService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oSesionService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oSesionService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oSesionService.get();
                        break;
                    case "set":
                        oReplyBean = oSesionService.set();
                        break;
                    case "remove":
                        oReplyBean = oSesionService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oSesionService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oSesionService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oSesionService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oSesionService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "servicio":
                ServicioSpecificServiceImplementation oServicioService = new ServicioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oServicioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oServicioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oServicioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oServicioService.get();
                        break;
                    case "set":
                        oReplyBean = oServicioService.set();
                        break;
                    case "remove":
                        oReplyBean = oServicioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oServicioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oServicioService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oServicioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oServicioService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "cliente":
                ClienteSpecificServiceImplementation oClienteService = new ClienteSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oClienteService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oClienteService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oClienteService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oClienteService.get();
                        break;
                    case "set":
                        oReplyBean = oClienteService.set();
                        break;
                    case "remove":
                        oReplyBean = oClienteService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oClienteService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oClienteService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oClienteService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oClienteService.getPageX();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            default:
                oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Object not found : Please contact your administrator"));
                break;
        }
        return oReplyBean;
    }
}
