package co.edu.uco.burstcar.servicio.dominio.dto;

import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoOferta;
import co.edu.uco.burstcar.servicio.dominio.modelo.MonedaServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.PrestadorServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.Servicio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class OfertaDto {
    private UUID idOferta;
    private String descripcion;
    private float costo;
    private String monedaServicio;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String estadoOferta;
    private UUID servicio;
    private String prestadorServicio;

    public OfertaDto(UUID idOferta, String descripcion, float costo, String monedaServicio, LocalDateTime fechaInicio, LocalDateTime fechaFin, String estadoOferta, UUID servicio, String prestadorServicio) {
        this.idOferta = idOferta;
        this.descripcion = descripcion;
        this.costo = costo;
        this.monedaServicio = monedaServicio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoOferta = estadoOferta;
        this.servicio = servicio;
        this.prestadorServicio = prestadorServicio;
    }
}
