package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadoservicio.entidad;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "estado_servicio", schema = "servicio")
public class EntidadEstadoServicio extends EntidadIdentificador {

    @Column(length = 100)
    private String descripcion;

    @Column(length = 20)
    private String nombre;

}
