package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.solicitanteservicio.entidad;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Table(name = "solicitante_servicio", schema = "servicio")
public class EntidadSolicitanteServicio extends EntidadIdentificador {

    @Column(length = 12)
    private String numeroIdentificacion;

    @Column(length = 30)
    private String nombreSolicitante;

    @Column(length = 15)
    private String nombreUsuario;

    @Column
    private Long telefonoSolicitante;

    @Column(length = 30)
    private String nombreIdentificacion;

    @Column(length = 5)
    private String tipoIdentificacion;

    @Column
    private UUID codigoIdentificador;

    public EntidadSolicitanteServicio(String numeroIdentificacion, String nombreSolicitante, String nombreUsuario, Long telefonoSolicitante, String nombreIdentificacion, String tipoIdentificacion, UUID codigoIdentificador) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreSolicitante = nombreSolicitante;
        this.nombreUsuario = nombreUsuario;
        this.telefonoSolicitante = telefonoSolicitante;
        this.nombreIdentificacion = nombreIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.codigoIdentificador = codigoIdentificador;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setTelefonoSolicitante(Long telefonoSolicitante) {
        this.telefonoSolicitante = telefonoSolicitante;
    }

    public void setNombreIdentificacion(String nombreIdentificacion) {
        this.nombreIdentificacion = nombreIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public void setCodigoIdentificador(UUID codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }
}
