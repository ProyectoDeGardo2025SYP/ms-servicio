package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.prestadorservicio.entidad;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@NoArgsConstructor
@Getter
@Table(name = "prestador_servicio", schema = "servicio")
public class EntidadPrestadorServicio extends EntidadIdentificador {


    @Column(length = 12)
    private String numeroIdentificacion;

    @Column(length = 30)
    private String nombrePrestador;

    @Column(length = 15)
    private String nombreUsuario;

    @Column
    private Long telefonoPrestador;

    @Column
    private UUID ubicacionIdentificador;

    @Column
    private Double latitudPrestador;

    @Column
    private Double longitudPrestador;

    @Column(length = 30)
    private String nombreIdentificacion;

    @Column(length = 5)
    private String tipoIdentificacion;

    @Column
    private UUID codigoIdentificador;

    public EntidadPrestadorServicio(String numeroIdentificacion, String nombrePrestador, String nombreUsuario, Long telefonoPrestador, UUID ubicacionIdentificador, Double latitudPrestador, Double longitudPrestador, String nombreIdentificacion, String tipoIdentificacion, UUID codigoIdentificador) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombrePrestador = nombrePrestador;
        this.nombreUsuario = nombreUsuario;
        this.telefonoPrestador = telefonoPrestador;
        this.ubicacionIdentificador = ubicacionIdentificador;
        this.latitudPrestador = latitudPrestador;
        this.longitudPrestador = longitudPrestador;
        this.nombreIdentificacion = nombreIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.codigoIdentificador = codigoIdentificador;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public void setNombrePrestador(String nombrePrestador) {
        this.nombrePrestador = nombrePrestador;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setTelefonoPrestador(Long telefonoPrestador) {
        this.telefonoPrestador = telefonoPrestador;
    }

    public void setUbicacionIdentificador(UUID ubicacionIdentificador) {
        this.ubicacionIdentificador = ubicacionIdentificador;
    }

    public void setLatitudPrestador(Double latitudPrestador) {
        this.latitudPrestador = latitudPrestador;
    }

    public void setLongitudPrestador(Double longitudPrestador) {
        this.longitudPrestador = longitudPrestador;
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
