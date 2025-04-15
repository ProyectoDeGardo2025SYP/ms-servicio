package co.edu.uco.burstcar.servicio.dominio.modelo;


import lombok.Setter;

import java.util.UUID;

@Setter
public class EntidadIdentificador {
    private final UUID identificador;

    public EntidadIdentificador() {
        this.identificador = UUID.randomUUID();
    }

    public EntidadIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public UUID getIdentificador() {
        return identificador;
    }
}
