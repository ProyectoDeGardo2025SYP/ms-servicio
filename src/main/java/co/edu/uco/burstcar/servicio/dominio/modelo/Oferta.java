package co.edu.uco.burstcar.servicio.dominio.modelo;

import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;

import java.time.LocalDateTime;
import java.util.UUID;

public class Oferta extends EntidadIdentificador{
    private String descripcion;
    private float costo;
    private MonedaServicio monedaServicio;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private EstadoOferta estadoOferta;
    private Servicio servicio;
    private PrestadorServicio prestadorServicio;

    private Oferta(String descripcion, float costo, MonedaServicio monedaServicio, LocalDateTime fechaInicio, LocalDateTime fechaFin, EstadoOferta estadoOferta, Servicio servicio, PrestadorServicio prestadorServicio) {
        this.descripcion = descripcion;
        this.costo = costo;
        this.monedaServicio = monedaServicio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoOferta = estadoOferta;
        this.servicio = servicio;
        this.prestadorServicio = prestadorServicio;
    }

    public static Oferta nuevaOferta(String descripcion, float costo, MonedaServicio monedaServicio, LocalDateTime fechaInicio, LocalDateTime fechaFin, EstadoOferta estadoOferta, Servicio servicio, PrestadorServicio prestadorServicio) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción", 100);
        ValidadorDeAtibutos.validarObjetoNoNulo(monedaServicio, "moneda");
        ValidadorDeAtibutos.validarObjetoNoNulo(fechaInicio, "fecha de inicio");
        ValidadorDeAtibutos.validarObjetoNoNulo(fechaFin, "fecha de finalización");
        ValidadorDeAtibutos.validarObjetoNoNulo(estadoOferta, "estado de la oferta");
        ValidadorDeAtibutos.validarObjetoNoNulo(servicio, "servicio");
        ValidadorDeAtibutos.validarObjetoNoNulo(prestadorServicio, "prestador");
        return  new Oferta(descripcion, costo, monedaServicio, fechaInicio, fechaFin, estadoOferta, servicio, prestadorServicio);
    }

    private Oferta(UUID identificador, String descripcion, float costo, MonedaServicio monedaServicio, LocalDateTime fechaInicio, LocalDateTime fechaFin, EstadoOferta estadoOferta, Servicio servicio, PrestadorServicio prestadorServicio) {
        super(identificador);
        this.descripcion = descripcion;
        this.costo = costo;
        this.monedaServicio = monedaServicio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoOferta = estadoOferta;
        this.servicio = servicio;
        this.prestadorServicio = prestadorServicio;
    }

    public static Oferta nuevaOfertaConIdentificador(UUID id, String descripcion, float costo, MonedaServicio monedaServicio, LocalDateTime fechaInicio, LocalDateTime fechaFin, EstadoOferta estadoOferta, Servicio servicio, PrestadorServicio prestadorServicio) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción", 100);
        ValidadorDeAtibutos.validarObjetoNoNulo(monedaServicio, "moneda");
        ValidadorDeAtibutos.validarObjetoNoNulo(fechaInicio, "fecha de inicio");
        ValidadorDeAtibutos.validarObjetoNoNulo(fechaFin, "fecha de finalización");
        ValidadorDeAtibutos.validarObjetoNoNulo(estadoOferta, "estado de la oferta");
        ValidadorDeAtibutos.validarObjetoNoNulo(servicio, "servicio");
        ValidadorDeAtibutos.validarObjetoNoNulo(prestadorServicio, "prestador");
        return  new Oferta(id, descripcion, costo, monedaServicio, fechaInicio, fechaFin, estadoOferta, servicio, prestadorServicio);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public MonedaServicio getMonedaServicio() {
        return monedaServicio;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public EstadoOferta getEstadoOferta() {
        return estadoOferta;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public PrestadorServicio getPrestadorServicio() {
        return prestadorServicio;
    }
}
