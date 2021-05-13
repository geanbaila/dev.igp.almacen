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
@Table(name="orden_retorno")
public class OrdenRetornoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "orden_id", referencedColumnName = "id")
    private OrdenEntity orden;

    @Column
    private String comisionado;
    
    @Column
    private String comisionado_dni;
    
    @Column
    private String comisionado_area;
    
    @Column
    private String asignado;
    
    @Column
    private String asignado_dni;
    
    @Column
    private String asignado_area;
    
    @Column
    private Date fecha_retorno;
}
