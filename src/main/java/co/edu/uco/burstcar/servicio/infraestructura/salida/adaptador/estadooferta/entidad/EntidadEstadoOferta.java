package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadooferta.entidad;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "estado_oferta", schema = "servicio")
public class EntidadEstadoOferta extends EntidadIdentificador {

    @Column(length = 20)
    private String nombre;

    @Column(length = 100)
    private String descripcion;


}
