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
        TableName = "galeria",
        SingularDescription = "Galeria",
        PluralDescription = "Fotos",
        Icon = "fa fa-camera-retro",
        Type = EnumHelper.SourceType.Table
)

public class GaleriaSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
           ShortName = "Enlace",
            LongName = "Enlace",
            Description = "Foto",
            Type = EnumHelper.FieldType.Enlace,      
            IsForeignKeyDescriptor = true,
            IsRequired = false,
            IsVisible = true,
            Width = 3,
            MaxLength = 255
    )
    private String enlace;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Fecha",
            LongName = "Fecha",
            Description = "Fecha de la foto",
            Type = EnumHelper.FieldType.Date,
            IsRequired = false,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100
    )
    private Date fecha_imagen;

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

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public Date getFecha_imagen() {
        return fecha_imagen;
    }

    public void setFecha_imagen(Date fecha_imagen) {
        this.fecha_imagen = fecha_imagen;
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
    
    
    
    
}
