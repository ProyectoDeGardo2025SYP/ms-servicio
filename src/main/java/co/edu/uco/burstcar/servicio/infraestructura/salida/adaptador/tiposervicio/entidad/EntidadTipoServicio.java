package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.tiposervicio.entidad;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tipo_servicio", schema = "servicio")
public class EntidadTipoServicio extends EntidadIdentificador {

    @Column(length = 100)
    private String descripcion;

    @Column(length = 20)
    private String nombre;

}
