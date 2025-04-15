package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.solicitanteservicio.comando.dto;

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
public class SolicitanteDto extends EntidadIdentificador {

    private String numeroIdentificacion;
    @JsonProperty("nombre")
    private String nombreSolicitante;
    @JsonProperty("usuario")
    private String nombreUsuario;
    @JsonProperty("numeroTelefonico")
    private Long telefonoSolicitante;
    private String nombreIdentificacion;
    private String tipoIdentificacion;
    private UUID codigoIdentificador;
}
