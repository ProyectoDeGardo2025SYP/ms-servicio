package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.oferta.entidad;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadooferta.entidad.EntidadEstadoOferta;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.entidad.EntidadMonedaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.prestadorservicio.entidad.EntidadPrestadorServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.entidad.EntidadServicio;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Table(name = "oferta", schema = "servicio")
public class EntidadOferta extends EntidadIdentificador {

    private String descripcion;

    @Column(nullable = false)
    private float costo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moneda_servicio_id", nullable = false)
    private EntidadMonedaServicio entidadMonedaServicio;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_oferta_id", nullable = false)
    private EntidadEstadoOferta entidadEstadoOferta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id", nullable = false)
    private EntidadServicio entidadServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prestador_servicio_id", nullable = false)
    private EntidadPrestadorServicio entidadPrestadorServicio;

    public EntidadOferta(String descripcion, float costo, EntidadMonedaServicio entidadMonedaServicio, LocalDateTime fechaInicio, LocalDateTime fechaFin, EntidadEstadoOferta entidadEstadoOferta, EntidadServicio entidadServicio, EntidadPrestadorServicio entidadPrestadorServicio) {
        this.descripcion = descripcion;
        this.costo = costo;
        this.entidadMonedaServicio = entidadMonedaServicio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.entidadEstadoOferta = entidadEstadoOferta;
        this.entidadServicio = entidadServicio;
        this.entidadPrestadorServicio = entidadPrestadorServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public EntidadMonedaServicio getEntidadMonedaServicio() {
        return entidadMonedaServicio;
    }

    public void setEntidadMonedaServicio(EntidadMonedaServicio entidadMonedaServicio) {
        this.entidadMonedaServicio = entidadMonedaServicio;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EntidadEstadoOferta getEntidadEstadoOferta() {
        return entidadEstadoOferta;
    }

    public void setEntidadEstadoOferta(EntidadEstadoOferta entidadEstadoOferta) {
        this.entidadEstadoOferta = entidadEstadoOferta;
    }

    public EntidadServicio getEntidadServicio() {
        return entidadServicio;
    }

    public void setEntidadServicio(EntidadServicio entidadServicio) {
        this.entidadServicio = entidadServicio;
    }

    public EntidadPrestadorServicio getEntidadPrestadorServicio() {
        return entidadPrestadorServicio;
    }

    public void setEntidadPrestadorServicio(EntidadPrestadorServicio entidadPrestadorServicio) {
        this.entidadPrestadorServicio = entidadPrestadorServicio;
    }
}
