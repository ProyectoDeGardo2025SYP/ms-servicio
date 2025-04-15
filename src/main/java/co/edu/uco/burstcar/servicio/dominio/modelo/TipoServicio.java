package co.edu.uco.burstcar.servicio.dominio.modelo;

import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@NoArgsConstructor
public class TipoServicio extends EntidadIdentificador{
    private String descripcion;
    private String nombre;

    private TipoServicio(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public static TipoServicio nuevoTipoServicio(String descripcion, String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción del tipo del servicio", 100);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre del tipo  del servicio", 20);
        return new TipoServicio(descripcion, nombre);
    }


    private TipoServicio(UUID identificador, String descripcion, String nombre) {
        super(identificador);
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public static TipoServicio nuevoTipoServicioConIdentificador(UUID id, String descripcion, String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción del estado del servicio", 100);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre del estado del servicio", 20);
        return new TipoServicio(id, descripcion, nombre);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }
}
