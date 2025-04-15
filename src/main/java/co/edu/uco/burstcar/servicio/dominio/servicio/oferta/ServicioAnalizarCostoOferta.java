package co.edu.uco.burstcar.servicio.dominio.servicio.oferta;

import co.edu.uco.burstcar.servicio.dominio.modelo.MonedaServicio;

import java.time.Duration;
import java.time.LocalDateTime;

public class ServicioAnalizarCostoOferta {

    public ServicioAnalizarCostoOferta() {
    }

    public Boolean ejecutarAnalizis(LocalDateTime fechaInicio, LocalDateTime fechaFin, float costo){
        Duration duracion = Duration.between(fechaInicio, fechaFin);
        long cantidadHoras = duracion.toHours();
        long operacion = (long) (costo/cantidadHoras);
        return operacion <= 500000;
    }
}
