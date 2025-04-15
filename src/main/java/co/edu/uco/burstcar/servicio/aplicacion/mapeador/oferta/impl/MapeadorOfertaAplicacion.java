package co.edu.uco.burstcar.servicio.aplicacion.mapeador.oferta.impl;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando.dto.OfertaDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.servicio.dominio.modelo.*;
import co.edu.uco.burstcar.servicio.dominio.puerto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapeadorOfertaAplicacion implements MapeadorAplicacion<OfertaDto, Oferta> {

    @Autowired
    private RepositorioMonedaServicio repositorioMonedaServicio;
    @Autowired
    private RepositorioEstadoOferta repositorioEstadoOferta;
    @Autowired
    private RepositorioServicio repositorioServicio;

    @Autowired
    private RepositorioPrestadorServicio repositorioPrestadorServicio;


    @Override
    public Oferta aDominio(OfertaDto dto) {
        MonedaServicio monedaServicio = this.repositorioMonedaServicio.asociarMonedaServicio(dto.getMonedaServicio());
        EstadoOferta estadoOferta = this.repositorioEstadoOferta.asociarEstadoOferta(dto.getEstadoOferta());
        Servicio servicio = this.repositorioServicio.asociarServcioAOferta(dto.getServicio());
        PrestadorServicio prestadorServicio = this.repositorioPrestadorServicio.asociarSolicitanteServicio(dto.getPrestadorServicioIdentificacion());

        return Oferta.nuevaOferta(dto.getDescripcion(), dto.getCosto(), monedaServicio, dto.getFechaInicio(), dto.getFechaFin(),
                estadoOferta, servicio, prestadorServicio);
    }
}
