package co.edu.uco.burstcar.servicio.aplicacion.mapeador.oferta.impl;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando.dto.EstadoOfertaDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoOferta;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioEstadoOferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MapeadorServicioActualizarEstadoOfertaAplicacion implements MapeadorAplicacion<EstadoOfertaDto, EstadoOferta> {
    @Autowired
    private RepositorioEstadoOferta repositorioEstadoOferta;


    @Override
    public EstadoOferta aDominio(EstadoOfertaDto dto) {
        return this.repositorioEstadoOferta.asociarEstadoOferta(dto.getEstadoOferta());
    }
}
