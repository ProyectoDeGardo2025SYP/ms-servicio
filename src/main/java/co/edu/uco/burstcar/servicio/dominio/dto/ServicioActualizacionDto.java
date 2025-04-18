package co.edu.uco.burstcar.servicio.dominio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class ServicioActualizacionDto {
    private String descripcion;
    private String tipoServicio;
    private UUID ubicacion;
    private UUID destino;
    private float costoInicial;
    private String moneda;
}
