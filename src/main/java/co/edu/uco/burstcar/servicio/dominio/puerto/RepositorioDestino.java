package co.edu.uco.burstcar.servicio.dominio.puerto;

import co.edu.uco.burstcar.servicio.dominio.modelo.DestinoServicio;

import java.util.UUID;

public interface RepositorioDestino {
    UUID registrarDestino(DestinoServicio destinoServicio);
    void actualizarDestino(DestinoServicio destinoServicio);
    DestinoServicio consultarInformacionDestino(UUID identificador);
    DestinoServicio consultarUbicacionPorLatitudYLongitud(Double latiud, Double longitud);
}
