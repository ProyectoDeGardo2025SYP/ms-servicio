package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.destino.comando.dto;

import co.edu.uco.burstcar.servicio.dominio.modelo.EntidadIdentificador;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DestinoDto extends EntidadIdentificador {
    private String nombreDestinatario;
    private String numeroIdentificacion;
    private Double latitudUbicacion;
    private Double longitudUbicacion;

    public DestinoDto(String nombreDestinatario, String numeroIdentificacion, Double latitudUbicacion, Double longitudUbicacion) {
        this.nombreDestinatario = nombreDestinatario;
        this.numeroIdentificacion = numeroIdentificacion;
        this.latitudUbicacion = latitudUbicacion;
        this.longitudUbicacion = longitudUbicacion;
    }
}
