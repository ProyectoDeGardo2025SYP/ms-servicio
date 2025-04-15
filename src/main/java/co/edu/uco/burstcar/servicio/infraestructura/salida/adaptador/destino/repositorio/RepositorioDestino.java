package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.destino.repositorio;

import co.edu.uco.burstcar.servicio.dominio.modelo.DelimitacionServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.DestinoServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.ViaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.destino.entidad.EntidadDestino;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.destino.repositorio.jpa.RepositorioDestinoJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.entidad.EntidadUbicacion;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.repositorio.jpa.RepositorioUbicacionJpa;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RepositorioDestino implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioDestino {

    private final RepositorioDestinoJpa repositorioDestinoJpa;
    private final RepositorioUbicacionJpa repositorioUbicacionJpa;

    public RepositorioDestino(RepositorioDestinoJpa repositorioDestinoJpa, RepositorioUbicacionJpa repositorioUbicacionJpa) {
        this.repositorioDestinoJpa = repositorioDestinoJpa;
        this.repositorioUbicacionJpa = repositorioUbicacionJpa;
    }

    @Override
    public UUID registrarDestino(DestinoServicio destinoServicio) {
        EntidadUbicacion entidadUbicacion = this.repositorioUbicacionJpa.findByLatitudAndLongitud(destinoServicio.getUbicacion().getLatitud(),
                destinoServicio.getUbicacion().getLongitud());

        EntidadDestino entidadDestino = new EntidadDestino(destinoServicio.getNombreDestinatario(), destinoServicio.getNumeroIdentificacion(),
                entidadUbicacion
        );
        entidadDestino.setIdentificador(destinoServicio.getIdentificador());
        return this.repositorioDestinoJpa.save(entidadDestino).getIdentificador();
    }

    @Override
    public void actualizarDestino(DestinoServicio destinoServicio) {
    }

    @Override
    public DestinoServicio consultarInformacionDestino(UUID identificador) {
        EntidadDestino entidadDestino = this.repositorioDestinoJpa.findById(identificador).orElse(null);

        if (entidadDestino == null){
            return null;
        }
        DelimitacionServicio delimitacionServicio = DelimitacionServicio.nuevaDelimitacionConIdentificador(
                entidadDestino.getEntidadUbicacion().getEntidadDelimitacionServicio().getIdentificador(),
                entidadDestino.getEntidadUbicacion().getEntidadDelimitacionServicio().getNombreCorregimiento(),
                entidadDestino.getEntidadUbicacion().getEntidadDelimitacionServicio().getNombreCiudad(),
                entidadDestino.getEntidadUbicacion().getEntidadDelimitacionServicio().getIdentificacionCiudad(),
                entidadDestino.getEntidadUbicacion().getEntidadDelimitacionServicio().getNombreDepartamento(),
                entidadDestino.getEntidadUbicacion().getEntidadDelimitacionServicio().getIdentificacionDepartamento(),
                entidadDestino.getEntidadUbicacion().getEntidadDelimitacionServicio().getIdentificacionPais(),
                entidadDestino.getEntidadUbicacion().getEntidadDelimitacionServicio().getNombrePais()
        );
        UbicacionServicio ubicacionServicio = getUbicacionServicio(entidadDestino, delimitacionServicio);

        return DestinoServicio.nuevoDestinoConIdentificador(entidadDestino.getIdentificador(), entidadDestino.getNombreDestinatario(),
                entidadDestino.getNumeroIdentificacion(), ubicacionServicio);
    }

    private static UbicacionServicio getUbicacionServicio(EntidadDestino entidadDestino, DelimitacionServicio delimitacionServicio) {
        ViaServicio viaServicio = ViaServicio.nuevaViaConIdentificador(
                entidadDestino.getEntidadUbicacion().getEntidadViaServicio().getIdentificador(),
                entidadDestino.getEntidadUbicacion().getEntidadViaServicio().getNombre());


        return UbicacionServicio.nuevaUbicacionServcioConIdentificador(
                entidadDestino.getEntidadUbicacion().getIdentificador(),
                entidadDestino.getEntidadUbicacion().getNumeroVia(),
                entidadDestino.getEntidadUbicacion().getDireccion(),
                entidadDestino.getEntidadUbicacion().getLatitud(),
                entidadDestino.getEntidadUbicacion().getLongitud(),
                entidadDestino.getEntidadUbicacion().getDetalleAdicional(),
                delimitacionServicio, viaServicio
                );
    }

    @Override
    public DestinoServicio consultarUbicacionPorLatitudYLongitud(Double latiud, Double longitud) {
        return null;
    }
}
