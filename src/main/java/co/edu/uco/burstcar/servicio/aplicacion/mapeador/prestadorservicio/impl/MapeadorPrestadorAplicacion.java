package co.edu.uco.burstcar.servicio.aplicacion.mapeador.prestadorservicio.impl;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.prestadorservicio.comando.dto.PrestadorDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.servicio.dominio.modelo.PrestadorServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioSolicitanteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MapeadorPrestadorAplicacion implements MapeadorAplicacion<PrestadorDto, PrestadorServicio> {

    @Autowired
    private RepositorioSolicitanteServicio repositorioSolicitanteServicio;


    @Override
    public PrestadorServicio aDominio(PrestadorDto dto) {
        return PrestadorServicio.nuevoPrestadorServicio(dto.getIdentificacionPrestador(), dto.getNombrePrestador(), dto.getNombreUsuario(), dto.getTelefonoPrestador(),
                dto.getUbicacionIdentificador(), dto.getLatitudPrestador(), dto.getLongitudPrestador(), dto.getNombreIdentificacion(), dto.getTipoIdentificacion(),
                dto.getCodigoIdentificador());
    }
}
