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
import eu.fernandomartin.bean.publicinterface.GenericBeanInterface;
import eu.fernandomartin.bean.specificimplementation.BocetoSpecificBeanImplementation;
import eu.fernandomartin.bean.specificimplementation.ClienteSpecificBeanImplementation;
import eu.fernandomartin.bean.specificimplementation.FacturaSpecificBeanImplementation;
import eu.fernandomartin.bean.specificimplementation.GaleriaSpecificBeanImplementation;
import eu.fernandomartin.bean.specificimplementation.ServicioSpecificBeanImplementation;
import eu.fernandomartin.bean.specificimplementation.SesionSpecificBeanImplementation;
import eu.fernandomartin.bean.specificimplementation.TipopagoSpecificBeanImplementation;

public class BeanFactory {

    public static GenericBeanInterface getBean(String ob, MetaBeanHelper oPuserBean_security) {
        GenericBeanInterface oBean = null;
        MetaBeanHelper oPuserSecurity = oPuserBean_security;
        switch (ob) {
            case "usuario":
                oBean = new UsuarioSpecificBeanImplementation();
                break;
            case "tipousuario":
                oBean = new TipousuarioSpecificBeanImplementation();
                break;
            case "tipopago":
                oBean = new TipopagoSpecificBeanImplementation();
                break;
            case "factura":
                oBean = new FacturaSpecificBeanImplementation();
                break;
            case "boceto":
                oBean = new BocetoSpecificBeanImplementation();
                break;
            case "galeria":
                oBean = new GaleriaSpecificBeanImplementation();
                break;
            case "sesion":
                oBean = new SesionSpecificBeanImplementation();
                break;
            case "servicio":
                oBean = new ServicioSpecificBeanImplementation();
                break;
            case "cliente":
                oBean = new ClienteSpecificBeanImplementation();
                break;
            default:

                //  oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oBean;
    }
}
