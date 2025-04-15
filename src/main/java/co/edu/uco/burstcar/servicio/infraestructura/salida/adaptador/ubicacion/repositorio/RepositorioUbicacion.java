package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.repositorio;

import co.edu.uco.burstcar.servicio.dominio.modelo.DelimitacionServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.ViaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.entidad.EntidadDelimitacionServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.repositorio.jpa.RepositorioDelimitacionServicioJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.entidad.EntidadUbicacion;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.repositorio.jpa.RepositorioUbicacionJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.entidad.EntidadViaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.repositorio.jpa.RepositorioViaServicioJpa;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RepositorioUbicacion implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioUbicacion {

    private final RepositorioUbicacionJpa repositorioUbicacionJpa;
    private final RepositorioDelimitacionServicioJpa repositorioDelimitacionServicioJpa;
    private final RepositorioViaServicioJpa repositorioViaServicioJpa;

    public RepositorioUbicacion(RepositorioUbicacionJpa repositorioUbicacionJpa, RepositorioDelimitacionServicioJpa repositorioDelimitacionServicioJpa, RepositorioViaServicioJpa repositorioViaServicioJpa) {
        this.repositorioUbicacionJpa = repositorioUbicacionJpa;
        this.repositorioDelimitacionServicioJpa = repositorioDelimitacionServicioJpa;
        this.repositorioViaServicioJpa = repositorioViaServicioJpa;
    }


    @Override
    public UUID registrarUbicacionServicio(UbicacionServicio ubicacionServicio) {
        EntidadDelimitacionServicio entidadDelimitacionServicio = this.repositorioDelimitacionServicioJpa.findDelimitacion(
                ubicacionServicio.getDelimitacionServicio().getNombrePais(),
                ubicacionServicio.getDelimitacionServicio().getNombreDepartamento(),
                ubicacionServicio.getDelimitacionServicio().getNombreCiudad(),
                ubicacionServicio.getDelimitacionServicio().getNombreCorregimiento()
        );

        EntidadViaServicio entidadViaServicio = this.repositorioViaServicioJpa.findByNombre(
                ubicacionServicio.getViaServicio().getNombre()
        );



        EntidadUbicacion entidadUbicacion = new EntidadUbicacion(
                ubicacionServicio.getNumeroVia(), ubicacionServicio.getDireccion(), ubicacionServicio.getLatitud(),
                ubicacionServicio.getLongitud(), ubicacionServicio.getDetalleAdicional(),
                entidadDelimitacionServicio, entidadViaServicio
        );
        entidadUbicacion.setIdentificador(ubicacionServicio.getIdentificador());
        return this.repositorioUbicacionJpa.save(entidadUbicacion).getIdentificador();
    }

    @Override
    public void actualizarUbicacion(UbicacionServicio ubicacionServicioPrestador) {

    }

    @Override
    public UbicacionServicio consultarUbicacion(UUID identificador) {

        EntidadUbicacion entidadUbicacion = this.repositorioUbicacionJpa.findById(identificador).orElse(null);

        if (entidadUbicacion == null){
            return null;
        }
        DelimitacionServicio delimitacionServicio = DelimitacionServicio.nuevaDelimitacionConIdentificador(
                entidadUbicacion.getEntidadDelimitacionServicio().getIdentificador(),
                entidadUbicacion.getEntidadDelimitacionServicio().getNombreCorregimiento(),
                entidadUbicacion.getEntidadDelimitacionServicio().getNombreCiudad(),
                entidadUbicacion.getEntidadDelimitacionServicio().getIdentificacionCiudad(),
                entidadUbicacion.getEntidadDelimitacionServicio().getNombreDepartamento(),
                entidadUbicacion.getEntidadDelimitacionServicio().getIdentificacionDepartamento(),
                entidadUbicacion.getEntidadDelimitacionServicio().getIdentificacionPais(),
                entidadUbicacion.getEntidadDelimitacionServicio().getNombrePais()
        );
        ViaServicio viaServicio = ViaServicio.nuevaViaConIdentificador(
                entidadUbicacion.getEntidadViaServicio().getIdentificador(),
                entidadUbicacion.getEntidadViaServicio().getNombre());

        return UbicacionServicio.nuevaUbicacionServcioConIdentificador(
                entidadUbicacion.getIdentificador(),
                entidadUbicacion.getNumeroVia(), entidadUbicacion.getDireccion(),
                entidadUbicacion.getLatitud(), entidadUbicacion.getLongitud(),
                entidadUbicacion.getDetalleAdicional(), delimitacionServicio,
                viaServicio);
    }


    @Override
    public UbicacionServicio consultarUbicacionPorLatitudYLongitud(Double latiud, Double longitud) {

        EntidadUbicacion entidadUbicacionServicio = this.repositorioUbicacionJpa.findByLatitudAndLongitud(
                latiud, longitud);

        if (entidadUbicacionServicio == null){
            return null;
        }
        DelimitacionServicio delimitacionServicio = DelimitacionServicio.nuevaDelimitacionConIdentificador(
                entidadUbicacionServicio.getIdentificador(),
                entidadUbicacionServicio.getEntidadDelimitacionServicio().getNombreCorregimiento(),
                entidadUbicacionServicio.getEntidadDelimitacionServicio().getNombreCiudad(),
                entidadUbicacionServicio.getEntidadDelimitacionServicio().getIdentificacionCiudad(),
                entidadUbicacionServicio.getEntidadDelimitacionServicio().getNombreDepartamento(),
                entidadUbicacionServicio.getEntidadDelimitacionServicio().getIdentificacionDepartamento(),
                entidadUbicacionServicio.getEntidadDelimitacionServicio().getIdentificacionPais(),
                entidadUbicacionServicio.getEntidadDelimitacionServicio().getNombrePais()
        );
        ViaServicio viaPrestador = ViaServicio.nuevaViaConIdentificador(
                entidadUbicacionServicio.getEntidadViaServicio().getIdentificador(),
                entidadUbicacionServicio.getEntidadViaServicio().getNombre());
        return UbicacionServicio.nuevaUbicacionServcioConIdentificador(
                entidadUbicacionServicio.getIdentificador(),
                entidadUbicacionServicio.getNumeroVia(), entidadUbicacionServicio.getDireccion(),
                entidadUbicacionServicio.getLatitud(), entidadUbicacionServicio.getLongitud(),
                entidadUbicacionServicio.getDetalleAdicional(), delimitacionServicio,
                viaPrestador);
    }
}
