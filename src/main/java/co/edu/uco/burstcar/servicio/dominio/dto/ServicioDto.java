package co.edu.uco.burstcar.servicio.dominio.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ServicioDto {
    private UUID idServicio;
    private String descripcion;
    private String nombreSolicitante;
    private String identificacionSolicitante;
    private String nombreTipoServicio;
    private String estadoServicio;
    private UUID idUbicacion;
    private Double latituUbicacion;
    private Double longitudUbicacion;
    private UUID idDestino;
    private String nombreDestinario;
    private String identificaionDestinario;
    private Double latituDestino;
    private Double longitudDestino;
    private float costoInicialSolicitante;
    private String monedaNombre;
    private LocalDateTime fechaCreacion;

    public ServicioDto(UUID idServicio, String descripcion, String nombreSolicitante, String identificacionSolicitante, String nombreTipoServicio, String estadoServicio, UUID idUbicacion, Double latituUbicacion, Double longitudUbicacion, UUID idDestino, String nombreDestinario, String identificaionDestinario, Double latituDestino, Double longitudDestino, float costoInicialSolicitante, String monedaNombre, LocalDateTime fechaCreacion) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.nombreSolicitante = nombreSolicitante;
        this.identificacionSolicitante = identificacionSolicitante;
        this.nombreTipoServicio = nombreTipoServicio;
        this.estadoServicio = estadoServicio;
        this.idUbicacion = idUbicacion;
        this.latituUbicacion = latituUbicacion;
        this.longitudUbicacion = longitudUbicacion;
        this.idDestino = idDestino;
        this.nombreDestinario = nombreDestinario;
        this.identificaionDestinario = identificaionDestinario;
        this.latituDestino = latituDestino;
        this.longitudDestino = longitudDestino;
        this.costoInicialSolicitante = costoInicialSolicitante;
        this.monedaNombre = monedaNombre;
        this.fechaCreacion = fechaCreacion;
    }
}
