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
    @JoinColumn(name="marca_id",referencedColumnName = "id")
    private MarcaEntity marca;
    
    @Column
    private ModeloEntity modelo;
    
    @Column
    private String denominacion;
    
    @Column
    private String codigo_patrimonial;
    
    @Column
    private String codigo_ambiente;
    
    @Column
    private String codigo_inventario;
    
    @Column
    private String fecha_inventario;
    
    @Column
    private String serie;

    @Column
    private String color;
}
