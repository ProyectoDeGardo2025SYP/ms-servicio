package co.edu.uco.burstcar.servicio.aplicacion.mapeador.servicio.impl;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.dto.EstadoDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.servicio.dominio.modelo.*;
import co.edu.uco.burstcar.servicio.dominio.puerto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MapeadorServicioEliminacionLogicaAplicacion implements MapeadorAplicacion<EstadoDto, EstadoServicio> {
    @Autowired
    private RepositorioEstadoServicio repositorioEstadoServicio;


    @Override
    public EstadoServicio aDominio(EstadoDto dto) {
        EstadoServicio estadoServicio = this.repositorioEstadoServicio.asociarEstadoServicio(dto.getEstadoServicio());
        return estadoServicio;
    }
}
