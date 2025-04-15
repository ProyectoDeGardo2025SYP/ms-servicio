package co.edu.uco.burstcar.servicio.dominio.modelo;

import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;
import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeObjetos;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
public class Servicio extends EntidadIdentificador{
    private String descripcion;
    private SolicitanteServicio solicitanteServicio;
    private TipoServicio tipoServicio;
    private EstadoServicio estadoServicio;
    private UbicacionServicio ubicacion;
    private DestinoServicio destino;
    private float costoInicialSolicitante;
    private MonedaServicio monedaServicio;
    private LocalDateTime fechaCreacion;

    private Servicio(String descripcion, SolicitanteServicio solicitanteServicio, TipoServicio tipoServicio, EstadoServicio estadoServicio, UbicacionServicio ubicacion, DestinoServicio destino, float costoInicialSolicitante, MonedaServicio monedaServicio, LocalDateTime fechaCreacion) {
        this.descripcion = descripcion;
        this.solicitanteServicio = solicitanteServicio;
        this.tipoServicio = tipoServicio;
        this.estadoServicio = estadoServicio;
        this.ubicacion = ubicacion;
        this.destino = destino;
        this.costoInicialSolicitante = costoInicialSolicitante;
        this.monedaServicio = monedaServicio;
        this.fechaCreacion = fechaCreacion;
    }

    public static Servicio nuevoServicio(String descripcion, SolicitanteServicio solicitanteServicio, TipoServicio tipoServicio, EstadoServicio estadoServicio, UbicacionServicio ubicacion, DestinoServicio destino, float costoInicialSolicitante, MonedaServicio monedaServicio, LocalDateTime fechaCreacion) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción", 100);
        ValidadorDeObjetos.validarNoNulos(solicitanteServicio, "solicitante");
        ValidadorDeObjetos.validarNoNulos(tipoServicio, "tipo de servicio");
        ValidadorDeObjetos.validarNoNulos(estadoServicio, "estado de servicip");
        ValidadorDeObjetos.validarNoNulos(ubicacion, "ubicacipon");
        ValidadorDeObjetos.validarNoNulos(destino, "destino");
        ValidadorDeObjetos.validarNoNulos(monedaServicio, "moneda del servicio");
        ValidadorDeObjetos.validarNoNulos(fechaCreacion, "fecha de creación");
        return new Servicio(descripcion, solicitanteServicio, tipoServicio, estadoServicio,
                ubicacion, destino, costoInicialSolicitante, monedaServicio, fechaCreacion);
    }

    private Servicio(UUID identificador, String descripcion, SolicitanteServicio solicitanteServicio, TipoServicio tipoServicio, EstadoServicio estadoServicio, UbicacionServicio ubicacion, DestinoServicio destino, float costoInicialSolicitante, MonedaServicio monedaServicio, LocalDateTime fechaCreacion) {
        super(identificador);
        this.descripcion = descripcion;
        this.solicitanteServicio = solicitanteServicio;
        this.tipoServicio = tipoServicio;
        this.estadoServicio = estadoServicio;
        this.ubicacion = ubicacion;
        this.destino = destino;
        this.costoInicialSolicitante = costoInicialSolicitante;
        this.monedaServicio = monedaServicio;
        this.fechaCreacion = fechaCreacion;
    }

    public static Servicio nuevoServicioConIdentifiacdor(UUID id, String descripcion, SolicitanteServicio solicitanteServicio, TipoServicio tipoServicio, EstadoServicio estadoServicio, UbicacionServicio ubicacion, DestinoServicio destino, float costoInicialSolicitante, MonedaServicio monedaServicio, LocalDateTime fechaCreacion) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción", 100);
        ValidadorDeObjetos.validarNoNulos(solicitanteServicio, "solicitante");
        ValidadorDeObjetos.validarNoNulos(tipoServicio, "tipo de servicio");
        ValidadorDeObjetos.validarNoNulos(estadoServicio, "estado de servicip");
        ValidadorDeObjetos.validarNoNulos(ubicacion, "ubicacipon");
        ValidadorDeObjetos.validarNoNulos(destino, "destino");
        ValidadorDeObjetos.validarNoNulos(monedaServicio, "moneda del servicio");
        ValidadorDeObjetos.validarNoNulos(fechaCreacion, "fecha de creación");
        return new Servicio(id, descripcion, solicitanteServicio, tipoServicio, estadoServicio,
                ubicacion, destino, costoInicialSolicitante, monedaServicio, fechaCreacion);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public SolicitanteServicio getSolicitanteServicio() {
        return solicitanteServicio;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public EstadoServicio getEstadoServicio() {
        return estadoServicio;
    }

    public UbicacionServicio getUbicacion() {
        return ubicacion;
    }

    public DestinoServicio getDestino() {
        return destino;
    }

    public float getCostoInicialSolicitante() {
        return costoInicialSolicitante;
    }

    public MonedaServicio getMonedaServicio() {
        return monedaServicio;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}
