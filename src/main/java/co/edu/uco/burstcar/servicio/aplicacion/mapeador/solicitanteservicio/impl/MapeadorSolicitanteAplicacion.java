package co.edu.uco.burstcar.servicio.aplicacion.mapeador.solicitanteservicio.impl;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.solicitanteservicio.comando.dto.SolicitanteDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.servicio.dominio.modelo.SolicitanteServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioSolicitanteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MapeadorSolicitanteAplicacion implements MapeadorAplicacion<SolicitanteDto, SolicitanteServicio> {

    @Autowired
    private RepositorioSolicitanteServicio repositorioSolicitanteServicio;


    @Override
    public SolicitanteServicio aDominio(SolicitanteDto dto) {
        return SolicitanteServicio.nuevoSolicitanteServicio(dto.getNumeroIdentificacion(), dto.getNombreSolicitante(), dto.getNombreUsuario(), dto.getTelefonoSolicitante(),
                dto.getNombreIdentificacion(), dto.getTipoIdentificacion(), dto.getCodigoIdentificador());
    }
}
