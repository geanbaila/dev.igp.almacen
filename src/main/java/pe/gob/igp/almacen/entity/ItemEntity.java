package pe.gob.igp.almacen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class ItemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @OneToOne
    @JoinColumn(name = "marca_id", referencedColumnName = "id")
    private MarcaEntity marca;

    @OneToOne
    @JoinColumn(name = "puesto_id", referencedColumnName = "id")
    private PuestoEntity puesto;
    
    @OneToOne
    @JoinColumn(name = "modelo_id", referencedColumnName = "id")
    private ModeloEntity modelo;

    @OneToOne
    @JoinColumn(name = "estado_item_id", referencedColumnName = "id")
    private EstadoItemEntity estadoItem;
    
    @Column
    private String denominacion;
    
    @Column(name = "codigo_patrimonial")
    private String codigoPatrimonial;
    
    @Column(name = "codigo_ambiente")
    private String codigoAmbiente;
    
    @Column(name = "codigo_inventario")
    private String codigoInventario;
    
    @Column(name  = "fecha_inventario")
    private String fechaInventario;
    
    @Column
    private String serie;

    @Column
    private String color;

    public ItemEntity() {
    }

    public ItemEntity(MarcaEntity marca, PuestoEntity puesto, ModeloEntity modelo, EstadoItemEntity estadoItem,
            String denominacion, String codigoPatrimonial, String codigoAmbiente, String codigoInventario,
            String fechaInventario, String serie, String color) {
        this.marca = marca;
        this.puesto = puesto;
        this.modelo = modelo;
        this.estadoItem = estadoItem;
        this.denominacion = denominacion;
        this.codigoPatrimonial = codigoPatrimonial;
        this.codigoAmbiente = codigoAmbiente;
        this.codigoInventario = codigoInventario;
        this.fechaInventario = fechaInventario;
        this.serie = serie;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MarcaEntity getMarca() {
        return marca;
    }

    public void setMarca(MarcaEntity marca) {
        this.marca = marca;
    }

    public PuestoEntity getPuesto() {
        return puesto;
    }

    public void setPuesto(PuestoEntity puesto) {
        this.puesto = puesto;
    }

    public ModeloEntity getModelo() {
        return modelo;
    }

    public void setModelo(ModeloEntity modelo) {
        this.modelo = modelo;
    }

    public EstadoItemEntity getEstado() {
        return estadoItem;
    }

    public void setEstado(EstadoItemEntity estadoItem) {
        this.estadoItem = estadoItem;
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

    public String getCodigoInventario() {
        return codigoInventario;
    }

    public void setCodigoInventario(String codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    public String getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(String fechaInventario) {
        this.fechaInventario = fechaInventario;
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

    

}
