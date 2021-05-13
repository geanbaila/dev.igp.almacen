package pe.gob.igp.almacen.entity;

import java.sql.Date;

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
    private OrdenRetornoEntity orden_retorno;
    
    @Column
    private String marca;
    
    @Column
    private String modelo;
    
    @Column
    private String denominacion;
    
    @Column
    private String codigo_patrimonial;
    
    @Column
    private String codigo_ambiente;
    
    @Column
    private String codigo_inventario;
    
    @Column
    private String serie;
    
    @Column
    private String color;

    @Column
    private Date fecha_retorno_prevista;
}
