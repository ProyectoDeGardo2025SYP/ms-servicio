package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.ubicacion.comando.dto;

import co.edu.uco.burstcar.servicio.dominio.modelo.EntidadIdentificador;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UbicacionDto extends EntidadIdentificador {

    private String numeroVia;
    private String direccion;
    private Double latitud;
    private Double longitud;
    private String detalleAdicional;
    private String nombrePais;
    private String nombreDepartamento;
    private String nombreCiudad;
    private String nombreCorregimiento;

    private String nombreVia;
    public UbicacionDto(String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, String nombrePais, String nombreDepartamento, String nombreCiudad, String nombreCorregimiento, String nombreVia) {
        this.numeroVia = numeroVia;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.detalleAdicional = detalleAdicional;
        this.nombrePais = nombrePais;
        this.nombreDepartamento = nombreDepartamento;
        this.nombreCiudad = nombreCiudad;
        this.nombreCorregimiento = nombreCorregimiento;
        this.nombreVia = nombreVia;
    }
}
