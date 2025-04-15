package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.repositorio;

import co.edu.uco.burstcar.servicio.dominio.modelo.DelimitacionServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.entidad.EntidadDelimitacionServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.repositorio.jpa.RepositorioDelimitacionServicioJpa;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDelimitacionServicio implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioDelimitacionServicio {

    private final RepositorioDelimitacionServicioJpa repositorioDelimitacionServicioJpa;

    public RepositorioDelimitacionServicio(RepositorioDelimitacionServicioJpa repositorioDelimitacionServicioJpa) {
        this.repositorioDelimitacionServicioJpa = repositorioDelimitacionServicioJpa;
    }


    @Override
    public DelimitacionServicio asociarDelimitacionUbicacion(String nombrePais, String nombreDepartamento, String nombreCiudad, String nombreCorregimiento) {
        EntidadDelimitacionServicio entidadDelimitacionPrestador = this.repositorioDelimitacionServicioJpa.findDelimitacion(nombrePais, nombreDepartamento,
                nombreCiudad, nombreCorregimiento);


        if(entidadDelimitacionPrestador ==null){
            return null;
        }
        return  DelimitacionServicio.nuevaDelimitacionConIdentificador(
                entidadDelimitacionPrestador.getIdentificador(),
                entidadDelimitacionPrestador.getNombreCorregimiento(),
                entidadDelimitacionPrestador.getNombreCiudad(), entidadDelimitacionPrestador.getIdentificacionCiudad(),
                entidadDelimitacionPrestador.getNombreDepartamento(), entidadDelimitacionPrestador.getIdentificacionDepartamento(),
                entidadDelimitacionPrestador.getIdentificacionPais(), entidadDelimitacionPrestador.getNombrePais());
    }
}
