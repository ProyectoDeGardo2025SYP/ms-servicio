package co.edu.uco.burstcar.servicio.dominio.modelo;

import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@NoArgsConstructor
public class EstadoOferta extends EntidadIdentificador{

    private String descripcion;
    private String nombre;

    private EstadoOferta(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public static EstadoOferta nuevoEstadoOferta(String descripcion, String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción del estado de la oferta", 100);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre del estado de la oferta", 20);
        return new EstadoOferta(descripcion, nombre);
    }

    private EstadoOferta(UUID identificador, String descripcion, String nombre) {
        super(identificador);
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public static EstadoOferta nuevoEstadoOfertaConIdentificador(UUID id, String descripcion, String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción del estado de la oferta", 100);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre del estado de la oferta", 20);
        return new EstadoOferta(id, descripcion, nombre);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }
}
