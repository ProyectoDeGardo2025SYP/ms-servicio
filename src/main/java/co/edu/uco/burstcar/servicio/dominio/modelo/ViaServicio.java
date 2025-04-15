package co.edu.uco.burstcar.servicio.dominio.modelo;

import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import java.util.UUID;


@NoArgsConstructor
public class ViaServicio extends EntidadIdentificador{

    @Size(max = 17)
    private String nombre;

    private ViaServicio(String nombre) {
        this.nombre = nombre;
    }

    public static ViaServicio nuevaVia(String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre de la vía del servicio", 17);
        return new ViaServicio(nombre);
    }

    private ViaServicio(UUID identificador, String nombre) {
        super(identificador);
        this.nombre = nombre;
    }

    public static ViaServicio nuevaViaConIdentificador(UUID id, String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre de la vía del servicio", 17);
        return new ViaServicio(id, nombre);
    }

    public String getNombre() {
        return nombre;
    }
}
