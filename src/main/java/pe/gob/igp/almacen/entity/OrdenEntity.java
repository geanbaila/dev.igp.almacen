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
@Table(name="orden")
public class OrdenEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name="tipo_orden_id", referencedColumnName="id")
    private TipoOrdenEntity tipo_orden;

    @OneToOne
    @JoinColumn(name="motivo_id", referencedColumnName = "id")
    private MotivoEntity motivo;

    @OneToOne
    @JoinColumn(name="estado_orden_id", referencedColumnName = "id")
    private EstadoOrdenEntity estado_orden;

    @OneToOne
    @JoinColumn(name="origen_id", referencedColumnName = "id")
    private OrigenEntity origen;

    @OneToOne
    @JoinColumn(name="usuario_id", referencedColumnName = "id")
    private UsuarioEntity usuario;

    @Column
    private String destino;

    @Column
    private Date fecha_salida_prevista;

    @Column
    private Date fecha_retorno_prevista;

    @Column
    private String comisionado;

    @Column
    private String comisionado_dni;

    @Column
    private String comisionado_area;

    @Column
    private String autoriza;

    @Column
    private String autoriza_dni;

    @Column
    private String autoriza_area;

    @Column
    private String accesorio;

    @Column
    private String observacion;

    @Column
    private Date fecha_salida;
    
}

