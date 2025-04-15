package co.edu.uco.burstcar.servicio.dominio.servicio.solicitanteservicio;


import co.edu.uco.burstcar.servicio.dominio.modelo.SolicitanteServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioSolicitanteServicio;

public class ServicioRegistrarSolicitante {
    private final RepositorioSolicitanteServicio repositorioSolicitanteServicio;

    public ServicioRegistrarSolicitante(RepositorioSolicitanteServicio repositorioSolicitanteServicio) {
        this.repositorioSolicitanteServicio = repositorioSolicitanteServicio;
    }


    public void ejecutarRegistro(SolicitanteServicio solicitante){
        this.repositorioSolicitanteServicio.registrarSolicitante(solicitante);
    }
}
