package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.entidad;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "moneda_servicio", schema = "servicio")
public class EntidadMonedaServicio extends EntidadIdentificador {

    @Column(length = 30)
    private String descripcion;

    @Column(length = 3)
    private String nombre;

}
