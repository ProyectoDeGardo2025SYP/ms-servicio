package co.edu.uco.burstcar.servicio.dominio.modelo;

import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
public class DelimitacionServicio extends EntidadIdentificador{

    private String nombreCorregimiento;
    private String nombreCiudad;
    private UUID identificacionCiudad;
    private String nombreDepartamento;
    private UUID identificacionDepartamento;
    private UUID identificacionPais;
    private String nombrePais;

    private DelimitacionServicio(String nombreCorregimiento, String nombreCiudad, UUID identificacionCiudad, String nombreDepartamento, UUID identificacionDepartamento, UUID identificacionPais, String nombrePais) {
        this.nombreCorregimiento = nombreCorregimiento;
        this.nombreCiudad = nombreCiudad;
        this.identificacionCiudad = identificacionCiudad;
        this.nombreDepartamento = nombreDepartamento;
        this.identificacionDepartamento = identificacionDepartamento;
        this.identificacionPais = identificacionPais;
        this.nombrePais = nombrePais;
    }

    public static DelimitacionServicio nuevaDelimitacion(String nombreCorregimiento, String nombreCiudad, UUID identificacionCiudad, String nombreDepartamento, UUID identificacionDepartamento, UUID identificacionPais, String nombrePais) {
        ValidadorDeAtibutos.validarAtributosTexto(nombreCorregimiento, "nombre del corregimiento", 20);
        ValidadorDeAtibutos.validarAtributosTexto(nombreCiudad, "nombre de la ciudad", 20);
        ValidadorDeAtibutos.validarAtributosTexto(nombreDepartamento, "nombre del departamento", 20);
        ValidadorDeAtibutos.validarAtributosTexto(nombrePais, "nombre del país", 20);
        return new DelimitacionServicio(nombreCorregimiento, nombreCiudad, identificacionCiudad, nombreDepartamento, identificacionDepartamento, identificacionPais, nombrePais);
    }

    private DelimitacionServicio(UUID identificador, String nombreCorregimiento, String nombreCiudad, UUID identificacionCiudad, String nombreDepartamento, UUID identificacionDepartamento, UUID identificacionPais, String nombrePais) {
        super(identificador);
        this.nombreCorregimiento = nombreCorregimiento;
        this.nombreCiudad = nombreCiudad;
        this.identificacionCiudad = identificacionCiudad;
        this.nombreDepartamento = nombreDepartamento;
        this.identificacionDepartamento = identificacionDepartamento;
        this.identificacionPais = identificacionPais;
        this.nombrePais = nombrePais;
    }

    public static DelimitacionServicio nuevaDelimitacionConIdentificador(UUID id, String nombreCorregimiento, String nombreCiudad, UUID identificacionCiudad, String nombreDepartamento, UUID identificacionDepartamento, UUID identificacionPais, String nombrePais) {
        ValidadorDeAtibutos.validarAtributosTexto(nombreCorregimiento, "nombre del corregimiento", 20);
        ValidadorDeAtibutos.validarAtributosTexto(nombreCiudad, "nombre de la ciudad", 20);
        ValidadorDeAtibutos.validarAtributosTexto(nombreDepartamento, "nombre del departamento", 20);
        ValidadorDeAtibutos.validarAtributosTexto(nombrePais, "nombre del país", 20);
        return new DelimitacionServicio(id, nombreCorregimiento, nombreCiudad, identificacionCiudad, nombreDepartamento, identificacionDepartamento, identificacionPais, nombrePais);
    }

    public String getNombreCorregimiento() {
        return nombreCorregimiento;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public UUID getIdentificacionCiudad() {
        return identificacionCiudad;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public UUID getIdentificacionDepartamento() {
        return identificacionDepartamento;
    }

    public UUID getIdentificacionPais() {
        return identificacionPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }
}
