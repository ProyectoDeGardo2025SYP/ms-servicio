package co.edu.uco.burstcar.servicio.dominio.modelo;

import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;
import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeObjetos;
import lombok.NoArgsConstructor;

import java.util.UUID;


@NoArgsConstructor
public class DestinoServicio extends EntidadIdentificador{

    private String nombreDestinatario;

    private String numeroIdentificacion;

    private UbicacionServicio ubicacion;

    private DestinoServicio(String nombreDestinatario, String numeroIdentificacion, UbicacionServicio ubicacion) {
        this.nombreDestinatario = nombreDestinatario;
        this.numeroIdentificacion = numeroIdentificacion;
        this.ubicacion = ubicacion;
    }

    public static DestinoServicio nuevoDestino(String nombreDestinatario, String numeroIdentificacion, UbicacionServicio ubicacion) {
        ValidadorDeAtibutos.validarAtributosTexto(nombreDestinatario, "nombre del destinatario", 30);
        ValidadorDeAtibutos.validarAtributosTexto(numeroIdentificacion, "número de indentificación del destinatario", 12);
        ValidadorDeObjetos.validarNoNulos(ubicacion, "ubicación del destino");
        return new DestinoServicio(nombreDestinatario, numeroIdentificacion, ubicacion);
    }

    private DestinoServicio(UUID identificador, String nombreDestinatario, String numeroIdentificacion, UbicacionServicio ubicacion) {
        super(identificador);
        this.nombreDestinatario = nombreDestinatario;
        this.numeroIdentificacion = numeroIdentificacion;
        this.ubicacion = ubicacion;
    }

    public static DestinoServicio nuevoDestinoConIdentificador(UUID id,  String nombreDestinatario, String numeroIdentificacion, UbicacionServicio ubicacion) {
        ValidadorDeAtibutos.validarAtributosTexto(nombreDestinatario, "nombre del destinatario", 30);
        ValidadorDeAtibutos.validarAtributosTexto(numeroIdentificacion, "número de indentificación del destinatario", 12);
        ValidadorDeObjetos.validarNoNulos(ubicacion, "ubicación del destino");
        return new DestinoServicio(id, nombreDestinatario, numeroIdentificacion, ubicacion);
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public UbicacionServicio getUbicacion() {
        return ubicacion;
    }
}
