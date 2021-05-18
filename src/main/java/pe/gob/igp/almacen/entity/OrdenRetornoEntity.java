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
    
    @Column(name = "comisionado_dni")
    private String comisionadoDni;
    
    @Column(name ="comisionado_area")
    private String comisionadoArea;
    
    @Column
    private String asignado;
    
    @Column(name = "asignado_dni")
    private String asignadoDni;
    
    @Column(name = "asignado_area")
    private String asignadoArea;
    
    @Column(name = "fecha_retorno")
    private Date fechaRetorno;
}
