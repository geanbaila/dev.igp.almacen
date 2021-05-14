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

    @Column
    private Date fechaSalidaPrevista;

    @Column
    private Date fechaRetornoPrevista;

    @Column
    private String comisionado;

    @Column
    private String comisionadoDni;

    @Column
    private String comisionadoArea;

    @Column
    private String autoriza;

    @Column
    private String autorizaDni;

    @Column
    private String autorizaArea;

    @Column
    private String accesorio;

    @Column
    private String observacion;

    @Column
    private Date fechaSalida;

    public OrdenEntity() {
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

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    

    
}

