package co.edu.uco.burstcar.servicio.aplicacion.mapeador.servicio.impl;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.servicio.dominio.modelo.*;
import co.edu.uco.burstcar.servicio.dominio.puerto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MapeadorServicioAplicacion implements MapeadorAplicacion<ServicioDto, Servicio> {

    @Autowired
    private RepositorioViaServicio repositorioViaServicio;
    @Autowired
    private RepositorioSolicitanteServicio repositorioSolicitanteServicio;
    @Autowired
    private RepositorioTipoServicio repositorioTipoServicio;
    @Autowired
    private RepositorioEstadoServicio repositorioEstadoServicio;
    @Autowired
    private RepositorioUbicacion repositorioUbicacion;
    @Autowired
    private RepositorioDestino repositorioDestino;
    @Autowired
    private RepositorioMonedaServicio repositorioMonedaServicio;

    @Override
    public Servicio aDominio(ServicioDto dto) {
        SolicitanteServicio solicitanteServicio = this.repositorioSolicitanteServicio.asociarSolicitanteServicio(dto.getIdentificaionSolicitante());
        TipoServicio tipoServicio = this.repositorioTipoServicio.asociarTipoServicio(dto.getTipoServicio());
        EstadoServicio estadoServicio = this.repositorioEstadoServicio.asociarEstadoServicio(dto.getEstadoServicio());
        UbicacionServicio ubicacionServicio = this.repositorioUbicacion.consultarUbicacion(dto.getUbicacion());
        DestinoServicio destinoServicio = this.repositorioDestino.consultarInformacionDestino(dto.getDestino());
        MonedaServicio monedaServicio = this.repositorioMonedaServicio.asociarMonedaServicio(dto.getMoneda());
        return Servicio.nuevoServicio(dto.getDescripcion(), solicitanteServicio, tipoServicio, estadoServicio, ubicacionServicio, destinoServicio,
                dto.getCostoInicial(), monedaServicio, LocalDateTime.now());
    }
}
