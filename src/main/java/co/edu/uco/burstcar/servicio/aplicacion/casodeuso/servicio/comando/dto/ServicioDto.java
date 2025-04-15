package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.dto;

import co.edu.uco.burstcar.servicio.dominio.modelo.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
public class ServicioDto extends EntidadIdentificador {
    private String descripcion;
    private String identificaionSolicitante;
    private String tipoServicio;
    private String estadoServicio;
    private UUID ubicacion;
    private UUID destino;
    private float costoInicial;
    private String moneda;
}
