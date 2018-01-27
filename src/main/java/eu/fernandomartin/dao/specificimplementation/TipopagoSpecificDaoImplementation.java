/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fernandomartin.dao.specificimplementation;

import eu.fernandomartin.bean.helper.MetaBeanHelper;
import eu.fernandomartin.dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

/**
 *
 * @author Fernando
 */
public class TipopagoSpecificDaoImplementation extends TableGenericDaoImplementation {
    
      public TipopagoSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("tipopago", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}
