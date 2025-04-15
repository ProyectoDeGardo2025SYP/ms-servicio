package co.edu.uco.burstcar.servicio.aplicacion.mapeador.ubicacion.impl;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.ubicacion.comando.dto.UbicacionDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioDelimitacionServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioViaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapeadorUbicacionAplicacion implements MapeadorAplicacion<UbicacionDto, UbicacionServicio> {

    @Autowired
    private RepositorioViaServicio repositorioViaServicio;
    @Autowired
    private RepositorioDelimitacionServicio repositorioDelimitacionServicio;

    @Override
    public UbicacionServicio aDominio(UbicacionDto dto) {
        return UbicacionServicio.nuevaUbicacionServcio(dto.getNumeroVia(), dto.getDireccion(), dto.getLatitud(), dto.getLongitud(),
                dto.getDetalleAdicional(),
                this.repositorioDelimitacionServicio.asociarDelimitacionUbicacion(dto.getNombrePais(), dto.getNombreDepartamento(),
                        dto.getNombreCiudad(), dto.getNombreCorregimiento()),
                this.repositorioViaServicio.asociarViaUbicacionServicio(dto.getNombreVia()));
    }
}
