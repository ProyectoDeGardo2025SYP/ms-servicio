package co.edu.uco.burstcar.servicio.dominio.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicioEmisorDto implements Serializable {

    private UUID identificador;
    private String nombreSolicitante;
    private String numeroIdentificacion;
    private UUID codigoIdentificador;
    private String tipoIdentificacion;
    private UUID identificadorEstadoServicio;
    private String nombreEstado;
    private UUID ubicacionIdentificador;
    private Double latitudServicio;
    private Double longitudServicio;
    private String detalleAdicionalServicio;
    private UUID identificadorDestino;
    private String nombreDestinatario;
    private String identificacionDestinatario;
    private String codigoMoneda;
    private Double costoInicialSolicitante;
    private UUID identificadorMoneda;
}
