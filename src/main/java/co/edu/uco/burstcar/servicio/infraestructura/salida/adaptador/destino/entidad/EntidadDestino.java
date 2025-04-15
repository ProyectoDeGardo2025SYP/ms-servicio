package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.destino.entidad;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.entidad.EntidadDelimitacionServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.entidad.EntidadUbicacion;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.entidad.EntidadViaServicio;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Table(name = "destino", schema = "servicio")
public class EntidadDestino extends EntidadIdentificador {

    @Column
    private String nombreDestinatario;
    @Column
    private String numeroIdentificacion;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "ubicacion_servicio_id")
    private EntidadUbicacion entidadUbicacion;

    public EntidadDestino(String nombreDestinatario, String numeroIdentificacion, EntidadUbicacion entidadUbicacion) {
        this.nombreDestinatario = nombreDestinatario;
        this.numeroIdentificacion = numeroIdentificacion;
        this.entidadUbicacion = entidadUbicacion;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public EntidadUbicacion getEntidadUbicacion() {
        return entidadUbicacion;
    }
}
