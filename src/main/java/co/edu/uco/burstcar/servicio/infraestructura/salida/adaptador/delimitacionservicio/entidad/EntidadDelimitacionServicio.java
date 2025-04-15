package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.entidad;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.EntidadIdentificador;
import jakarta.persistence.*;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "delimitacion_servicio", schema = "servicio")
public class EntidadDelimitacionServicio extends EntidadIdentificador {


    @Column(length = 20)
    private String nombreCorregimiento;

    @Column(length = 20)
    private String nombreCiudad;

    @Column
    private UUID identificacionCiudad;

    @Column(length = 20)
    private String nombreDepartamento;

    @Column
    private UUID identificacionDepartamento;

    @Column
    private UUID identificacionPais;

    @Column(length = 20)
    private String nombrePais;

}
