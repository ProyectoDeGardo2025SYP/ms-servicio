package co.edu.uco.burstcar.servicio.dominio.modelo;

import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;
import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeObjetos;
import lombok.NoArgsConstructor;

import java.util.UUID;


@NoArgsConstructor
public class UbicacionServicio extends EntidadIdentificador{

    private String numeroVia;
    private String direccion;
    private Double latitud;
    private Double longitud;
    private String detalleAdicional;
    private DelimitacionServicio delimitacionServicio;
    private ViaServicio viaServicio;

    private UbicacionServicio(String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, DelimitacionServicio delimitacionServicio, ViaServicio viaServicio) {
        this.numeroVia = numeroVia;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.detalleAdicional = detalleAdicional;
        this.delimitacionServicio = delimitacionServicio;
        this.viaServicio = viaServicio;
    }

    public static UbicacionServicio nuevaUbicacionServcio(String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, DelimitacionServicio delimitacionServicio, ViaServicio viaServicio) {
        ValidadorDeAtibutos.validarAtributosTexto(numeroVia, "número de vía", 3);
        ValidadorDeAtibutos.validarAtributosTexto(direccion, "dirección", 15);
        ValidadorDeObjetos.validarNoNulos(latitud, "latitud");
        ValidadorDeObjetos.validarNoNulos(longitud, "longitud");
        ValidadorDeAtibutos.validarAtributosTexto(detalleAdicional, "detalle adicional", 100);
        ValidadorDeObjetos.validarNoNulos(delimitacionServicio, "delimitación");
        ValidadorDeObjetos.validarNoNulos(viaServicio, "vía");
        return new UbicacionServicio(numeroVia, direccion, latitud, longitud, detalleAdicional, delimitacionServicio, viaServicio);
    }

    private UbicacionServicio(UUID identificador, String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, DelimitacionServicio delimitacionServicio, ViaServicio viaServicio) {
        super(identificador);
        this.numeroVia = numeroVia;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.detalleAdicional = detalleAdicional;
        this.delimitacionServicio = delimitacionServicio;
        this.viaServicio = viaServicio;
    }

    public static UbicacionServicio nuevaUbicacionServcioConIdentificador(UUID id, String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, DelimitacionServicio delimitacionServicio, ViaServicio viaServicio) {
        ValidadorDeAtibutos.validarAtributosTexto(numeroVia, "número de vía", 3);
        ValidadorDeAtibutos.validarAtributosTexto(direccion, "dirección", 15);
        ValidadorDeObjetos.validarNoNulos(latitud, "latitud");
        ValidadorDeObjetos.validarNoNulos(longitud, "longitud");
        ValidadorDeAtibutos.validarAtributosTexto(detalleAdicional, "detalle adicional", 100);
        ValidadorDeObjetos.validarNoNulos(delimitacionServicio, "delimitación");
        ValidadorDeObjetos.validarNoNulos(viaServicio, "vía");
        return new UbicacionServicio(id, numeroVia, direccion, latitud, longitud, detalleAdicional, delimitacionServicio, viaServicio);
    }

    public String getNumeroVia() {
        return numeroVia;
    }

    public String getDireccion() {
        return direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public String getDetalleAdicional() {
        return detalleAdicional;
    }

    public DelimitacionServicio getDelimitacionServicio() {
        return delimitacionServicio;
    }

    public ViaServicio getViaServicio() {
        return viaServicio;
    }
}
