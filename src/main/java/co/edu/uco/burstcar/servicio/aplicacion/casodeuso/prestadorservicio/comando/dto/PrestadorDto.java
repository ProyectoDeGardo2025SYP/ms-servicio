package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.prestadorservicio.comando.dto;

import co.edu.uco.burstcar.servicio.dominio.modelo.EntidadIdentificador;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorDto extends EntidadIdentificador {

    @JsonProperty("numeroIdentificacion")
    private String identificacionPrestador;
    @JsonProperty("nombre")
    private String nombrePrestador;
    @JsonProperty("usuario")
    private String nombreUsuario;
    @JsonProperty("numeroTelefonico")
    private long telefonoPrestador;
    private UUID ubicacionIdentificador;
    @JsonProperty("latitud")
    private Double latitudPrestador;
    @JsonProperty("longitud")
    private Double longitudPrestador;
    @JsonProperty("nombreIdentificaion")
    private String nombreIdentificacion;
    @JsonProperty("identificacionCategoriaId")
    private String tipoIdentificacion;
    private UUID codigoIdentificador;
}
