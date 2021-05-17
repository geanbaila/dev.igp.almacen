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
    private TipoOrdenEntity tipoOrden;

    @OneToOne
    @JoinColumn(name="motivo_id", referencedColumnName = "id")
    private MotivoEntity motivo;

    @OneToOne
    @JoinColumn(name="estado_orden_id", referencedColumnName = "id")
    private EstadoOrdenEntity estadoOrden;

    @OneToOne
    @JoinColumn(name="origen_id", referencedColumnName = "id")
    private OrigenEntity origen;

    @OneToOne
    @JoinColumn(name="usuario_id", referencedColumnName = "id")
    private UsuarioEntity usuario;

    @Column
    private String destino;

    @Column(name="fecha_salida_prevista")
    private Date fechaSalidaPrevista;

    @Column(name="fecha_retorno_prevista")
    private Date fechaRetornoPrevista;

    @Column
    private String comisionado;

    @Column(name="comisionado_dni")
    private String comisionadoDni;

    @Column(name="comisionado_area")
    private String comisionadoArea;

    @Column
    private String autoriza;

    @Column(name="autoriza_dni")
    private String autorizaDni;

    @Column(name="autoriza_area")
    private String autorizaArea;

    @Column
    private String accesorio;

    @Column
    private String observacion;

    @Column(name = "numero_orden")
    private String numeroOrden;

    public OrdenEntity() {
    }

    public OrdenEntity(TipoOrdenEntity tipoOrden, MotivoEntity motivo, EstadoOrdenEntity estadoOrden,
            OrigenEntity origen, UsuarioEntity usuario, String destino, Date fechaSalidaPrevista,
            Date fechaRetornoPrevista, String comisionado, String comisionadoDni, String comisionadoArea,
            String autoriza, String autorizaDni, String autorizaArea, String accesorio, String observacion,
            String numeroOrden) {
        this.tipoOrden = tipoOrden;
        this.motivo = motivo;
        this.estadoOrden = estadoOrden;
        this.origen = origen;
        this.usuario = usuario;
        this.destino = destino;
        this.fechaSalidaPrevista = fechaSalidaPrevista;
        this.fechaRetornoPrevista = fechaRetornoPrevista;
        this.comisionado = comisionado;
        this.comisionadoDni = comisionadoDni;
        this.comisionadoArea = comisionadoArea;
        this.autoriza = autoriza;
        this.autorizaDni = autorizaDni;
        this.autorizaArea = autorizaArea;
        this.accesorio = accesorio;
        this.observacion = observacion;
        this.numeroOrden = numeroOrden;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoOrdenEntity getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(TipoOrdenEntity tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    public MotivoEntity getMotivo() {
        return motivo;
    }

    public void setMotivo(MotivoEntity motivo) {
        this.motivo = motivo;
    }

    public EstadoOrdenEntity getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrdenEntity estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public OrigenEntity getOrigen() {
        return origen;
    }

    public void setOrigen(OrigenEntity origen) {
        this.origen = origen;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalidaPrevista() {
        return fechaSalidaPrevista;
    }

    public void setFechaSalidaPrevista(Date fechaSalidaPrevista) {
        this.fechaSalidaPrevista = fechaSalidaPrevista;
    }

    public Date getFechaRetornoPrevista() {
        return fechaRetornoPrevista;
    }

    public void setFechaRetornoPrevista(Date fechaRetornoPrevista) {
        this.fechaRetornoPrevista = fechaRetornoPrevista;
    }

    public String getComisionado() {
        return comisionado;
    }

    public void setComisionado(String comisionado) {
        this.comisionado = comisionado;
    }

    public String getComisionadoDni() {
        return comisionadoDni;
    }

    public void setComisionadoDni(String comisionadoDni) {
        this.comisionadoDni = comisionadoDni;
    }

    public String getComisionadoArea() {
        return comisionadoArea;
    }

    public void setComisionadoArea(String comisionadoArea) {
        this.comisionadoArea = comisionadoArea;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public String getAutorizaDni() {
        return autorizaDni;
    }

    public void setAutorizaDni(String autorizaDni) {
        this.autorizaDni = autorizaDni;
    }

    public String getAutorizaArea() {
        return autorizaArea;
    }

    public void setAutorizaArea(String autorizaArea) {
        this.autorizaArea = autorizaArea;
    }

    public String getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(String accesorio) {
        this.accesorio = accesorio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

     
    

    
}

