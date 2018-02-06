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
        TableName = "cliente",
        SingularDescription = "Cliente",
        PluralDescription = "Clientes",
        Icon = "fa fa-user-circle-o",
        Type = EnumHelper.SourceType.Table
)

public class ClienteSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Nombre completo",
            LongName = "Nombre completo",
            Description = "Nombre completo del cliente",
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
            Description = "Nombre del cliente",
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
            Description = "Primer Apellido del cliente",
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
            Description = "Segundo Apellido del cliente",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
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
            ShortName = "Dni",
            LongName = "Dni Completo",
            Description = "Documento Nacional de Identidad",
            Type = EnumHelper.FieldType.String,
            IsForeignKeyDescriptor = false,
            RegexPattern = RegexConstants.dni,
            RegexHelp = RegexConstants.dni_Help,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String dni;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Dir.",
            LongName = "Dirección",
            Description = "Dirección del cliente",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = RegexConstants.direction,
            RegexHelp = RegexConstants.directionSentence_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String direccion;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_tipopago = 0;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Tipo",
            LongName = "Tipo pago",
            Description = "Tipo de pago",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "tipopago",
            Width = 4,
            IsVisible = false
    )
    private MetaBeanHelper obj_tipopago = null;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Ciudad",
            LongName = "Ciudad",
            Description = "Ciudad del cliente",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String ciudad;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Cod. Postal",
            LongName = "Código Postal",
            Description = "Código Postal del cliente",
            Type = EnumHelper.FieldType.Integer,
            RegexPattern = "[0-9]{5,5}",
            RegexHelp = "5 dígitos",
            IsRequired = false,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 5,
            IsVisible = false
    )
    private String codigo_postal;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Provincia",
            LongName = "Provincia",
            Description = "Provincia del cliente",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = true
    )
    private String provincia;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "email",
            LongName = "Correo electrónico",
            Description = "Correo electrónico del cliente",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = RegexConstants.email,
            RegexHelp = RegexConstants.email_Help,
            MaxLength = 50,
            IsVisible = false
    )
    private String email;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Tel.",
            LongName = "Teléfono",
            Description = "Teléfono del cliente",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 20,
            IsVisible = true
    )
    private String telefono;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Desc.",
            LongName = "Descuento",
            Description = "Descuento para el cliente",
            Type = EnumHelper.FieldType.Decimal,
            IsVisible = true
    )
    private Double descuento;
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Servicio",
            LongName = "Servicios de este cliente",
            Description = "Servicios de este cliente",
            Type = EnumHelper.FieldType.Link,
            References = "servicio"
    )
    private Integer link_servicio = null;

    public String getNombrecompleto() {
        return nombrecompleto;
    }

     @Override
     public void ComputeCalculatedFields() {
        if (this.segundo_apellido == null) {
            this.nombrecompleto = this.nombre + " " + this.primer_apellido;
        } else {
            this.nombrecompleto = this.nombre + " " + this.primer_apellido + " " + this.segundo_apellido;
        }
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

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getId_tipopago() {
        return id_tipopago;
    }

    public void setId_tipopago(Integer id_tipopago) {
        this.id_tipopago = id_tipopago;
    }

    public MetaBeanHelper getObj_tipopago() {
        return obj_tipopago;
    }

    public void setObj_tipopago(MetaBeanHelper obj_tipopago) {
        this.obj_tipopago = obj_tipopago;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

}
