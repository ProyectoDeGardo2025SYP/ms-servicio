package co.edu.uco.burstcar.servicio.dominio.servicio.prestadorservicio;

import co.edu.uco.burstcar.servicio.dominio.modelo.PrestadorServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioPrestadorServicio;

public class ServicioRegistrarPrestador {
    private final RepositorioPrestadorServicio repositorioPrestadorServicio;

    public ServicioRegistrarPrestador(RepositorioPrestadorServicio repositorioPrestadorServicio) {
        this.repositorioPrestadorServicio = repositorioPrestadorServicio;
    }

    public void ejecutarRegistro(PrestadorServicio prestadorServicio){
        this.repositorioPrestadorServicio.registrarSolicitante(prestadorServicio);
    }
}
