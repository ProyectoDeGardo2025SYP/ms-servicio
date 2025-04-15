package co.edu.uco.burstcar.servicio.aplicacion.mapeador;

public interface MapeadorAplicacion<A, D> {
    D aDominio(A dto);
}
