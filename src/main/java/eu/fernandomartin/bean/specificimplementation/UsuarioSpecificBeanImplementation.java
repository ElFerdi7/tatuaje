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
package eu.fernandomartin.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import eu.fernandomartin.bean.genericimplementation.TableGenericBeanImplementation;
import eu.fernandomartin.bean.helper.MetaBeanHelper;
import eu.fernandomartin.bean.meta.publicinterface.MetaObjectBeanInterface;
import eu.fernandomartin.bean.meta.publicinterface.MetaPropertyBeanInterface;
import eu.fernandomartin.helper.EnumHelper;
import eu.fernandomartin.helper.Log4jHelper;
import eu.fernandomartin.helper.constant.RegexConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

@MetaObjectBeanInterface(
        TableName = "usuario",
        SingularDescription = "Usuario",
        PluralDescription = "Usuarios",
        Icon = "fa fa-user",
        Type = EnumHelper.SourceType.Table
)
public class UsuarioSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Nombre completo",
            LongName = "Nombre completo",
            Description = "Nombre completo del usuario",
            Type = EnumHelper.FieldType.Calculated,
            IsForeignKeyDescriptor = true,
            Width = 3,
            MaxLength = 100
    )
    private String nombrecompleto;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Nombre",
            LongName = "Nombre",
            Description = "Nombre del usuario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String nombre;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "1er. Ap.",
            LongName = "Primer Apellido",
            Description = "Primer Apellido del usuario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String primer_apellido;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "2º Ap.",
            LongName = "Segundo Apellido",
            Description = "Segundo Apellido del usuario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String segundo_apellido;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "login",
            LongName = "Login",
            Description = "Login para entrar en el sistema",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.nameWithEndingNumbers,
            RegexHelp = RegexConstants.nameWithEndingNumbers_Help,
            MaxLength = 15
    )
    private String login;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.Password
    )
    private String password;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "email",
            LongName = "Correo electrónico",
            Description = "Correo electrónico del usuario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.email,
            RegexHelp = RegexConstants.email_Help,
            MaxLength = 50,
            IsVisible = false
    )
    private String email;

//    @Expose(serialize = false)
//    @MetaPropertyBeanInterface(
//            Type = EnumHelper.FieldType.Token
//    )
//    private String token;

//    @Expose
//    @MetaPropertyBeanInterface(
//            ShortName = "¿Activo?",
//            LongName = "¿Usuario activo?",
//            Description = "¿Usuario activo?",
//            Type = EnumHelper.FieldType.Boolean,
//            IsRequired = true,
//            IsVisible = false
//    )
//    private Integer activo;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "F.alta",
            LongName = "Fecha de alta",
            Description = "Fecha de alta del usuario",
            Type = EnumHelper.FieldType.Date,
            RegexHelp = "una fecha correcta",
            IsRequired = true,
            IsVisible = false
    )
    private Date fecha_alta;

//    @Expose
//    @MetaPropertyBeanInterface(
//            ShortName = "¿Validado?",
//            LongName = "¿Usuario validado?",
//            Description = "¿Usuario validado?",
//            Type = EnumHelper.FieldType.Boolean,
//            IsRequired = true,
//            IsVisible = false
//    )
//    private Integer validado;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_tipousuario = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Tipo",
            LongName = "Tipo usuario",
            Description = "Tipo de usuario",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "tipousuario",
            Width = 4
    )
    private MetaBeanHelper obj_tipousuario = null;

  

    

    @Override
    public void ComputeCalculatedFields() {
        this.nombrecompleto = this.nombre + " " + this.primer_apellido + " " + this.segundo_apellido;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primerapellido) {
        this.primer_apellido = primerapellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }
    
    public Integer getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(Integer id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public MetaBeanHelper getObj_tipousuario() {
        return obj_tipousuario;
    }

    public void setObj_tipousuario(MetaBeanHelper obj_tipousuario) {
        this.obj_tipousuario = obj_tipousuario;
    }
    
    
//    @Override
//    public UsuarioSpecificBeanImplementation fill(ResultSet oResultSet, Connection oConnection, MetaBeanHelper oPuserBean_security, Integer expand) throws Exception {
//        super.fill(oResultSet, oConnection, oPuserBean_security, expand);
//        GrupoSpecificDaoImplementation oGrupoDao = null;
//        GrupoSpecificBeanImplementation oGrupoBean = null;
//        MetaBeanHelper oMetaBeanHelper = null;
//        if (this.id_tipousuario == 3) { // si profesor rellenar sus grupos
//            GrupoSpecificBeanImplementation oGrupo = null;
//            PreparedStatement oPreparedStatement = null;
//            ResultSet oResultSet2 = null;
//            String strSQL = "select * from grupo where id_usuario= ?";
//            try {
//                oPreparedStatement = oConnection.prepareStatement(strSQL);
//                oPreparedStatement.setInt(1, this.getId());
//                oResultSet2 = oPreparedStatement.executeQuery();
//                if (oResultSet2.next()) {
//                    oGrupoDao = new GrupoSpecificDaoImplementation(oConnection, oPuserBean_security, "and id_usuario=" + this.getId().toString());
//                    oGrupoBean = (GrupoSpecificBeanImplementation) new GrupoSpecificBeanImplementation();
//                    this.getObj_grupos().add(oGrupoDao.get(oResultSet2.getInt("id"), expand - 1));
////                    oGrupo = (GrupoSpecificBeanImplementation) new GrupoSpecificBeanImplementation(this.getId_grupo()).fill(oResultSet2, oConnection, oPuserBean_security, expand - 1);
////                    this.getObj_grupos().add(oGrupo);
//                }
//            } catch (Exception ex) {
//                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
//                Log4jHelper.errorLog(msg, ex);
//                throw new Exception(msg, ex);
//            } finally {
//                if (oResultSet2 != null) {
//                    oResultSet2.close();
//                }
//                if (oPreparedStatement != null) {
//                    oPreparedStatement.close();
//                }
//            }
//        }
//        return this;
//    }

}
