package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.destino.comando.dto;

import co.edu.uco.burstcar.servicio.dominio.modelo.EntidadIdentificador;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class DestinoDto extends EntidadIdentificador {
    private String nombreDestinatario;
    private String numeroIdentificacion;
    private UUID ubicacionId;

    public DestinoDto() {
    }

    public DestinoDto(UUID identificador) {
        super(identificador);
    }

    public DestinoDto(String nombreDestinatario, String numeroIdentificacion, UUID ubicacionId) {
        this.nombreDestinatario = nombreDestinatario;
        this.numeroIdentificacion = numeroIdentificacion;
        this.ubicacionId = ubicacionId;
    }

    public DestinoDto(UUID identificador, String nombreDestinatario, String numeroIdentificacion, UUID ubicacionId) {
        super(identificador);
        this.nombreDestinatario = nombreDestinatario;
        this.numeroIdentificacion = numeroIdentificacion;
        this.ubicacionId = ubicacionId;
    }
}
