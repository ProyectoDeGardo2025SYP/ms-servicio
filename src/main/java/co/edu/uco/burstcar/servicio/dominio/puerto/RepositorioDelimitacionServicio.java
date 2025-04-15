package co.edu.uco.burstcar.servicio.dominio.puerto;

import co.edu.uco.burstcar.servicio.dominio.modelo.DelimitacionServicio;

public interface RepositorioDelimitacionServicio {

    DelimitacionServicio asociarDelimitacionUbicacion(String nombrePais, String nombreDepartamento,
                                                      String nombreCiudad, String nombreCorregimiento);
}
