package pe.gob.igp.almacen.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orden_retorno_detalle")
public class OrdenRetornoDetalleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @OneToOne
    @JoinColumn(name="orden_retorno_id", referencedColumnName = "id")
    private OrdenRetornoEntity ordenRetorno;
    
    @Column
    private String marca;
    
    @Column
    private String modelo;
    
    @Column
    private String denominacion;
    
    @Column(name="codigo_patrimonial")
    private String codigoPatrimonial;
    
    @Column(name="codigo_ambiente")
    private String codigoAmbiente;
    
    @Column(name="codigo_inventario")
    private String codigoInventario;
    
    @Column
    private String serie;
    
    @Column
    private String color;

    @Column(name="fecha_retorno_prevista")
    private Date fechaRetornoPrevista;
}
