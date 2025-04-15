package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.entidad;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.entidad.EntidadDelimitacionServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.entidad.EntidadViaServicio;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Table(name = "ubicacion", schema = "servicio")
public class EntidadUbicacion extends EntidadIdentificador {

    @Column(length = 3)
    private String numeroVia;

    @Column(length = 15)
    private String direccion;

    private Double latitud;

    private Double longitud;

    @Column(length = 100)
    private String detalleAdicional;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "delimitacion_servicio_id")
    private EntidadDelimitacionServicio entidadDelimitacionServicio;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "via_servicio_id")
    private EntidadViaServicio entidadViaServicio;

    public EntidadUbicacion(String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, EntidadDelimitacionServicio entidadDelimitacionServicio, EntidadViaServicio entidadViaServicio) {
        this.numeroVia = numeroVia;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.detalleAdicional = detalleAdicional;
        this.entidadDelimitacionServicio = entidadDelimitacionServicio;
        this.entidadViaServicio = entidadViaServicio;
    }

    public String getNumeroVia() {
        return numeroVia;
    }

    public void setNumeroVia(String numeroVia) {
        this.numeroVia = numeroVia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getDetalleAdicional() {
        return detalleAdicional;
    }

    public void setDetalleAdicional(String detalleAdicional) {
        this.detalleAdicional = detalleAdicional;
    }

    public EntidadDelimitacionServicio getEntidadDelimitacionServicio() {
        return entidadDelimitacionServicio;
    }

    public void setEntidadDelimitacionServicio(EntidadDelimitacionServicio entidadDelimitacionServicio) {
        this.entidadDelimitacionServicio = entidadDelimitacionServicio;
    }

    public EntidadViaServicio getEntidadViaServicio() {
        return entidadViaServicio;
    }

    public void setEntidadViaServicio(EntidadViaServicio entidadViaServicio) {
        this.entidadViaServicio = entidadViaServicio;
    }
}
