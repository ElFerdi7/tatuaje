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
import java.util.Date;

/**
 *
 * @author Fernando
 */

@MetaObjectBeanInterface(
        TableName = "sesion",
        SingularDescription = "Sesion",
        PluralDescription = "Sesiones",
        Icon = "fa fa-pie-chart",
        Type = EnumHelper.SourceType.Table
)
public class SesionSpecificBeanImplementation extends TableGenericBeanImplementation {
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Descripción",
            LongName = "Descripción",
            Description = "Descripción de la sesion",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = true,
            Width = 3,
            MaxLength = 100
    )
    private String descripcion;
    
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_servicio = 0;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Serv.",
            LongName = "Servicio",
            Description = "Servicio",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "servicio",
            Width = 4
    )
    private MetaBeanHelper obj_servicio = null;
    
     @Expose
    @MetaPropertyBeanInterface(
            ShortName = "F.Inicio",
            LongName = "Fecha inicio",
            Description = "Fecha de inicio de la primera sesion",
            Type = EnumHelper.FieldType.Date,
            IsRequired = false,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100
    )
    private Date fecha_inicio;
     
       @Expose
    @MetaPropertyBeanInterface(
            ShortName = "F.Fin",
            LongName = "Fecha fin",
            Description = "Fecha de fin de la ultima sesion",
            Type = EnumHelper.FieldType.Date,
            IsRequired = false,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100
    )
    private Date fecha_fin;
       
       
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Cant.",
            LongName = "Cantidad",
            Description = "Cantidad de sesiones",
            Type = EnumHelper.FieldType.Integer,
            IsRequired = true
    )
    private Integer cantidad;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public MetaBeanHelper getObj_servicio() {
        return obj_servicio;
    }

    public void setObj_servicio(MetaBeanHelper obj_servicio) {
        this.obj_servicio = obj_servicio;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
