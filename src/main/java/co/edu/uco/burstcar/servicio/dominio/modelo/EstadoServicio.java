package co.edu.uco.burstcar.servicio.dominio.modelo;

import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;
import lombok.NoArgsConstructor;

import java.util.UUID;


@NoArgsConstructor
public class EstadoServicio extends EntidadIdentificador{
    private String descripcion;
    private String nombre;

    private EstadoServicio(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public static EstadoServicio nuevoEstadoServicio(String descripcion, String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción del estado del servicio", 100);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre del estado del servicio", 20);
        return new EstadoServicio(descripcion, nombre);
    }

    private EstadoServicio(UUID identificador, String descripcion, String nombre) {
        super(identificador);
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public static EstadoServicio nuevoEstadoServicioConIdentificador(UUID id, String descripcion, String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción del estado del servicio", 100);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre del estado del servicio", 20);
        return new EstadoServicio(id, descripcion, nombre);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }
}
