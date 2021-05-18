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
@Table(name="orden_retorno_firma")
public class OrdenRetornoFirmaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "orden_retorno_id", referencedColumnName = "id")
    private OrdenRetornoEntity ordenRetorno;
    
    @Column
    private String cargo;
    
    @Column
    private String nombre;
    
    @Column
    private String estado;
}
