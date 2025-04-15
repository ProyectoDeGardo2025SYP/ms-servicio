package co.edu.uco.burstcar.servicio.dominio.puerto;

import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;

import java.util.UUID;

public interface RepositorioUbicacion {
    UUID registrarUbicacionServicio(UbicacionServicio ubicacionServicio);
    void actualizarUbicacion(UbicacionServicio ubicacionServicioPrestador);
    UbicacionServicio consultarUbicacion(UUID identificador);
    UbicacionServicio consultarUbicacionPorLatitudYLongitud(Double latiud, Double longitud);
}
