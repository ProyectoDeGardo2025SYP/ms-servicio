package co.edu.uco.burstcar.servicio.dominio.modelo;


import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;
import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeObjetos;

import java.util.UUID;

public class PrestadorServicio extends EntidadIdentificador{

    private String identificacionPrestador;
    private String nombrePrestador;
    private String nombreUsuario;
    private long telefonoPrestador;
    private UUID ubicacionIdentificador;
    private Double latitudPrestador;
    private Double longitudPrestador;
    private String nombreIdentificacion;
    private String tipoIdentificacion;
    private UUID codigoIdentificador;


    private PrestadorServicio(String identificacionPrestador, String nombrePrestador, String nombreUsuario, long telefonoPrestador, UUID ubicacionIdentificador, Double latitudPrestador, Double longitudPrestador, String nombreIdentificacion, String tipoIdentificacion, UUID codigoIdentificador) {
        this.identificacionPrestador = identificacionPrestador;
        this.nombrePrestador = nombrePrestador;
        this.nombreUsuario = nombreUsuario;
        this.telefonoPrestador = telefonoPrestador;
        this.ubicacionIdentificador = ubicacionIdentificador;
        this.latitudPrestador = latitudPrestador;
        this.longitudPrestador = longitudPrestador;
        this.nombreIdentificacion = nombreIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.codigoIdentificador = codigoIdentificador;
    }

    public static PrestadorServicio nuevoPrestadorServicio(String identificacionPrestador, String nombrePrestador, String nombreUsuario, long telefonoPrestador, UUID ubicacionIdentificador, Double latitudPrestador, Double longitudPrestador, String nombreIdentificacion, String tipoIdentificacion, UUID codigoIdentificador) {
        ValidadorDeAtibutos.validarAtributosTexto(identificacionPrestador, "número de identifición", 12);
        ValidadorDeAtibutos.validarAtributosTexto(nombrePrestador, "nombre", 30);
        ValidadorDeAtibutos.validarAtributosTexto(nombreUsuario, "usuario", 15);
        ValidadorDeObjetos.validarNoNulos(latitudPrestador, "latitud del prestador");
        ValidadorDeObjetos.validarNoNulos(longitudPrestador, "longitud del prestador");
        ValidadorDeAtibutos.validarAtributosTexto(nombreIdentificacion, "nombre del tipo de identificación", 30);
        ValidadorDeAtibutos.validarAtributosTexto(tipoIdentificacion, "tipo de identificación", 5);
        return new PrestadorServicio(identificacionPrestador, nombrePrestador, nombreUsuario,
                telefonoPrestador, ubicacionIdentificador, latitudPrestador, longitudPrestador,
                nombreIdentificacion, tipoIdentificacion, codigoIdentificador);
    }

    private PrestadorServicio(UUID identificador, String identificacionPrestador, String nombrePrestador, String nombreUsuario, long telefonoPrestador, UUID ubicacionIdentificador, Double latitudPrestador, Double longitudPrestador, String nombreIdentificacion, String tipoIdentificacion, UUID codigoIdentificador) {
        super(identificador);
        this.identificacionPrestador = identificacionPrestador;
        this.nombrePrestador = nombrePrestador;
        this.nombreUsuario = nombreUsuario;
        this.telefonoPrestador = telefonoPrestador;
        this.ubicacionIdentificador = ubicacionIdentificador;
        this.latitudPrestador = latitudPrestador;
        this.longitudPrestador = longitudPrestador;
        this.nombreIdentificacion = nombreIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.codigoIdentificador = codigoIdentificador;
    }

    public static PrestadorServicio nuevoPrestadorServicioConIdentificador(UUID id, String identificacionPrestador, String nombrePrestador, String nombreUsuario, long telefonoPrestador, UUID ubicacionIdentificador, Double latitudPrestador, Double longitudPrestador, String nombreIdentificacion, String tipoIdentificacion, UUID codigoIdentificador) {
        ValidadorDeAtibutos.validarAtributosTexto(identificacionPrestador, "número de identifición", 12);
        ValidadorDeAtibutos.validarAtributosTexto(nombrePrestador, "nombre", 30);
        ValidadorDeAtibutos.validarAtributosTexto(nombreUsuario, "usuario", 15);
        ValidadorDeObjetos.validarNoNulos(latitudPrestador, "latitud del prestador");
        ValidadorDeObjetos.validarNoNulos(longitudPrestador, "longitud del prestador");
        ValidadorDeAtibutos.validarAtributosTexto(nombreIdentificacion, "nombre del tipo de identificación", 30);
        ValidadorDeAtibutos.validarAtributosTexto(tipoIdentificacion, "tipo de identificación", 5);
        return new PrestadorServicio(id, identificacionPrestador, nombrePrestador, nombreUsuario,
                telefonoPrestador, ubicacionIdentificador, latitudPrestador, longitudPrestador,
                nombreIdentificacion, tipoIdentificacion, codigoIdentificador);
    }

    public String getIdentificacionPrestador() {
        return identificacionPrestador;
    }

    public String getNombrePrestador() {
        return nombrePrestador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public long getTelefonoPrestador() {
        return telefonoPrestador;
    }

    public UUID getUbicacionIdentificador() {
        return ubicacionIdentificador;
    }

    public Double getLatitudPrestador() {
        return latitudPrestador;
    }

    public Double getLongitudPrestador() {
        return longitudPrestador;
    }

    public String getNombreIdentificacion() {
        return nombreIdentificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public UUID getCodigoIdentificador() {
        return codigoIdentificador;
    }
}
