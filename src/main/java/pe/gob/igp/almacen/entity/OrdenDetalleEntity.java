package pe.gob.igp.almacen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="orden_detalle")
public class OrdenDetalleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Integer id;
    
    @OneToOne
    @JoinColumn(name = "orden_id", referencedColumnName = "id")
    private OrdenEntity orden;

    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private ItemEntity item;

    @Column
    @Transient
    private String marca;
    
    @Column
    @Transient
    private String modelo;
    
    @Column
    @Transient
    private String denominacion;
    
    @Column(name = "codigo_patrimonial")
    @Transient
    private String codigoPatrimonial;
    
    @Column(name = "codigo_ambiente")
    @Transient
    private String codigoAmbiente;
    
    @Column(name = "codigo_invetario")
    @Transient
    private String codigoInvetario;
    
    @Column
    @Transient
    private String serie;
    
    @Column
    @Transient
    private String color;

    @Column
    private String retorna;

    public OrdenDetalleEntity() {
    }

    public OrdenDetalleEntity(OrdenEntity orden, ItemEntity item, String marca, String modelo, String denominacion,
            String codigoPatrimonial, String codigoAmbiente, String codigoInvetario, String serie, String color,
            String retorna) {
        this.orden = orden;
        this.item = item;
        this.marca = marca;
        this.modelo = modelo;
        this.denominacion = denominacion;
        this.codigoPatrimonial = codigoPatrimonial;
        this.codigoAmbiente = codigoAmbiente;
        this.codigoInvetario = codigoInvetario;
        this.serie = serie;
        this.color = color;
        this.retorna = retorna;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrdenEntity getOrden() {
        return orden;
    }

    public void setOrden(OrdenEntity orden) {
        this.orden = orden;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getCodigoPatrimonial() {
        return codigoPatrimonial;
    }

    public void setCodigoPatrimonial(String codigoPatrimonial) {
        this.codigoPatrimonial = codigoPatrimonial;
    }

    public String getCodigoAmbiente() {
        return codigoAmbiente;
    }

    public void setCodigoAmbiente(String codigoAmbiente) {
        this.codigoAmbiente = codigoAmbiente;
    }

    public String getCodigoInvetario() {
        return codigoInvetario;
    }

    public void setCodigoInvetario(String codigoInvetario) {
        this.codigoInvetario = codigoInvetario;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRetorna() {
        return retorna;
    }

    public void setRetorna(String retorna) {
        this.retorna = retorna;
    }

    

}
