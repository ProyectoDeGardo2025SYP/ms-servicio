package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.entidad;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "via_servicio", schema = "servicio")
public class EntidadViaServicio extends EntidadIdentificador {

    @Column(length = 12)
    private String nombre;

}
