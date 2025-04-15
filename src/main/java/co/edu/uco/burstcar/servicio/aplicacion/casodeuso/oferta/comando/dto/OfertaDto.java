package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando.dto;

import co.edu.uco.burstcar.servicio.dominio.modelo.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
public class OfertaDto extends EntidadIdentificador {

    private String descripcion;
    private float costo;
    private String monedaServicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaFin;
    private String estadoOferta;
    private UUID servicio;
    private String prestadorServicioIdentificacion;

    public OfertaDto(String descripcion, float costo, String monedaServicio, LocalDateTime fechaInicio, LocalDateTime fechaFin, String estadoOferta, UUID servicio, String prestadorServicioIdentificacion) {
        this.descripcion = descripcion;
        this.costo = costo;
        this.monedaServicio = monedaServicio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoOferta = estadoOferta;
        this.servicio = servicio;
        this.prestadorServicioIdentificacion = prestadorServicioIdentificacion;
    }

    public OfertaDto(UUID identificador, String descripcion, float costo, String monedaServicio, LocalDateTime fechaInicio, LocalDateTime fechaFin, String estadoOferta, UUID servicio, String prestadorServicioIdentificacion) {
        super(identificador);
        this.descripcion = descripcion;
        this.costo = costo;
        this.monedaServicio = monedaServicio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoOferta = estadoOferta;
        this.servicio = servicio;
        this.prestadorServicioIdentificacion = prestadorServicioIdentificacion;
    }
}
