/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fernandomartin.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import eu.fernandomartin.bean.genericimplementation.TableGenericBeanImplementation;
import eu.fernandomartin.bean.helper.MetaBeanHelper;
import eu.fernandomartin.bean.meta.publicinterface.MetaObjectBeanInterface;
import eu.fernandomartin.bean.meta.publicinterface.MetaPropertyBeanInterface;
import eu.fernandomartin.helper.EnumHelper;
import eu.fernandomartin.helper.constant.RegexConstants;

/**
 *
 * @author Fernando
 */
@MetaObjectBeanInterface(
        TableName = "servicio",
        SingularDescription = "Servicio",
        PluralDescription = "Servicios",
        Icon = "fa fa-paint-brush",
        Type = EnumHelper.SourceType.Table
)
public class ServicioSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Coment.",
            LongName = "Comentario",
            Description = "Comentario del servicio",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = true,
            Width = 3,
            MaxLength = 100
    )
    private String comentario;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_factura = 0;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Fact.",
            LongName = "Factura",
            Description = "Factura del servicio",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "factura",
            Width = 4
    )
    private MetaBeanHelper obj_factura = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_cliente = 0;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Cli.",
            LongName = "Cliente",
            Description = "Cliente del servicio",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "cliente",
            Width = 4
    )
    private MetaBeanHelper obj_cliente = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_usuario = 0;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Usu.",
            LongName = "Usuario",
            Description = "Usuario",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "usuario",
            Width = 4
    )
    private MetaBeanHelper obj_usuario = null;
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Sesion",
            LongName = "Sesiones de este servicio",
            Description = "Sesiones de este servicio",
            Type = EnumHelper.FieldType.Link,
            References = "sesion"
    )
    private Integer link_sesion = null;
    
     @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Boceto",
            LongName = "Bocetos de este servicio",
            Description = "Bocetos de este servicio",
            Type = EnumHelper.FieldType.Link,
            References = "boceto"
    )
    private Integer link_boceto = null;
     
      @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Galeria",
            LongName = "Galerias de este servicio",
            Description = "Galerias de este servicio",
            Type = EnumHelper.FieldType.Link,
            References = "galeria"
    )
    private Integer link_galeria = null;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getId_factura() {
        return id_factura;
    }

    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
    }

    public MetaBeanHelper getObj_factura() {
        return obj_factura;
    }

    public void setObj_factura(MetaBeanHelper obj_factura) {
        this.obj_factura = obj_factura;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public MetaBeanHelper getObj_cliente() {
        return obj_cliente;
    }

    public void setObj_cliente(MetaBeanHelper obj_cliente) {
        this.obj_cliente = obj_cliente;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public MetaBeanHelper getObj_usuario() {
        return obj_usuario;
    }

    public void setObj_usuario(MetaBeanHelper obj_usuario) {
        this.obj_usuario = obj_usuario;
    }

}
