package co.edu.uco.burstcar.servicio.aplicacion.mapeador.destino.impl;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.destino.comando.dto.DestinoDto;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.ubicacion.comando.dto.UbicacionDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.servicio.dominio.modelo.DestinoServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioDelimitacionServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioUbicacion;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioViaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapeadorDestinoAplicacion implements MapeadorAplicacion<DestinoDto, DestinoServicio> {

    @Autowired
    private RepositorioUbicacion repositorioUbicacion;

    @Override
    public DestinoServicio aDominio(DestinoDto dto) {
        UbicacionServicio ubicacionServicio = this.repositorioUbicacion.consultarUbicacionPorLatitudYLongitud(dto.getLatitudUbicacion(),
                dto.getLongitudUbicacion());
        return DestinoServicio.nuevoDestino(dto.getNombreDestinatario(), dto.getNumeroIdentificacion(), ubicacionServicio);
    }
}
