package co.edu.uco.burstcar.servicio.aplicacion.mapeador.servicio.impl;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioEmisorDto;
import co.edu.uco.burstcar.servicio.dominio.modelo.*;
import co.edu.uco.burstcar.servicio.dominio.puerto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MapeadorServicioEmisorAplicacion {

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

    public ServicioEmisorDto aDominio(ServicioDto dto, UUID identifiador) {
        SolicitanteServicio solicitanteServicio = this.repositorioSolicitanteServicio.asociarSolicitanteServicio(dto.getIdentificaionSolicitante());
        EstadoServicio estadoServicio = this.repositorioEstadoServicio.asociarEstadoServicio(dto.getEstadoServicio());
        UbicacionServicio ubicacionServicio = this.repositorioUbicacion.consultarUbicacion(dto.getUbicacion());
        DestinoServicio destinoServicio = this.repositorioDestino.consultarInformacionDestino(dto.getDestino());
        MonedaServicio monedaServicio = this.repositorioMonedaServicio.asociarMonedaServicio(dto.getMoneda());

        return new ServicioEmisorDto(identifiador, solicitanteServicio.getNombreSolicitante(), solicitanteServicio.getNumeroIdentificacion(), solicitanteServicio.getCodigoIdentificador(), solicitanteServicio.getTipoIdentificacion(),
                estadoServicio.getIdentificador(), estadoServicio.getNombre(), ubicacionServicio.getIdentificador(), ubicacionServicio.getLatitud(), ubicacionServicio.getLongitud(), ubicacionServicio.getDetalleAdicional(),
                destinoServicio.getIdentificador(), destinoServicio.getNombreDestinatario(), destinoServicio.getNumeroIdentificacion(), monedaServicio.getNombre(), (double) dto.getCostoInicial(), monedaServicio.getIdentificador());
    }
}
