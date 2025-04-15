package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.entidad;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.destino.entidad.EntidadDestino;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadoservicio.entidad.EntidadEstadoServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.entidad.EntidadMonedaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.solicitanteservicio.entidad.EntidadSolicitanteServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.tiposervicio.entidad.EntidadTipoServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.entidad.EntidadUbicacion;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Table(name = "servicio", schema = "servicio")
public class EntidadServicio extends EntidadIdentificador {

    @Column
    private String descripcion;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitante_servicio_id")
    private EntidadSolicitanteServicio entidadSolicitanteServicio;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_servicio_id")
    private EntidadTipoServicio entidadTipoServicio;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_servicio_id")
    private EntidadEstadoServicio entidadEstadoServicio;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ubicacion_servicio_id")
    private EntidadUbicacion ubicacion;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "destino_servicio_id")
    private EntidadDestino destino;

    @Column(name = "costo_inicial_solicitante")
    private float costoInicialSolicitante;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "moneda_servicio_id")
    private EntidadMonedaServicio monedaServicio;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public EntidadServicio(String descripcion, EntidadSolicitanteServicio entidadSolicitanteServicio, EntidadTipoServicio entidadTipoServicio, EntidadEstadoServicio entidadEstadoServicio, EntidadUbicacion ubicacion, EntidadDestino destino, float costoInicialSolicitante, EntidadMonedaServicio monedaServicio, LocalDateTime fechaCreacion) {
        this.descripcion = descripcion;
        this.entidadSolicitanteServicio = entidadSolicitanteServicio;
        this.entidadTipoServicio = entidadTipoServicio;
        this.entidadEstadoServicio = entidadEstadoServicio;
        this.ubicacion = ubicacion;
        this.destino = destino;
        this.costoInicialSolicitante = costoInicialSolicitante;
        this.monedaServicio = monedaServicio;
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EntidadSolicitanteServicio getEntidadSolicitanteServicio() {
        return entidadSolicitanteServicio;
    }

    public EntidadTipoServicio getEntidadTipoServicio() {
        return entidadTipoServicio;
    }

    public EntidadEstadoServicio getEntidadEstadoServicio() {
        return entidadEstadoServicio;
    }

    public EntidadUbicacion getUbicacion() {
        return ubicacion;
    }

    public EntidadDestino getDestino() {
        return destino;
    }

    public float getCostoInicialSolicitante() {
        return costoInicialSolicitante;
    }

    public EntidadMonedaServicio getMonedaServicio() {
        return monedaServicio;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEntidadSolicitanteServicio(EntidadSolicitanteServicio entidadSolicitanteServicio) {
        this.entidadSolicitanteServicio = entidadSolicitanteServicio;
    }

    public void setEntidadTipoServicio(EntidadTipoServicio entidadTipoServicio) {
        this.entidadTipoServicio = entidadTipoServicio;
    }

    public void setEntidadEstadoServicio(EntidadEstadoServicio entidadEstadoServicio) {
        this.entidadEstadoServicio = entidadEstadoServicio;
    }

    public void setUbicacion(EntidadUbicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDestino(EntidadDestino destino) {
        this.destino = destino;
    }

    public void setCostoInicialSolicitante(float costoInicialSolicitante) {
        this.costoInicialSolicitante = costoInicialSolicitante;
    }

    public void setMonedaServicio(EntidadMonedaServicio monedaServicio) {
        this.monedaServicio = monedaServicio;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
