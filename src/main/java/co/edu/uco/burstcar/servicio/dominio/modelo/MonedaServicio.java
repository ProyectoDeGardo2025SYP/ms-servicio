package co.edu.uco.burstcar.servicio.dominio.modelo;

import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@NoArgsConstructor
@Getter
@Setter
public class MonedaServicio extends EntidadIdentificador{

    @Size(max = 30)
    private String descripcion;

    @Size(max = 3)
    private String nombre;

    private MonedaServicio(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public static MonedaServicio nuevaMonedaServicio(String descripcion, String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción de la moneda del servicio", 30);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre de la moneda del servicio", 3);
        return new MonedaServicio(descripcion, nombre);
    }

    private MonedaServicio(UUID identificador, String descripcion, String nombre) {
        super(identificador);
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public static MonedaServicio nuevaMonedaServcioConIdentificador(UUID id, String descripcion, String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(descripcion, "descripción de la moneda del servicio", 30);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre de la moneda del servicio", 3);
        return new MonedaServicio(id, descripcion, nombre);
    }

}
