package co.edu.uco.burstcar.servicio.dominio.modelo;

import co.edu.uco.burstcar.servicio.dominio.validador.ValidadorDeAtibutos;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class SolicitanteServicio extends EntidadIdentificador{

    @Size(max = 12)
    private String numeroIdentificacion;

    @Size(max = 30)
    private String nombreSolicitante;

    @Size(max = 15)
    private String nombreUsuario;

    private Long telefonoSolicitante;

    @Size(max = 30)
    private String nombreIdentificacion;

    @Size(max = 5)
    private String tipoIdentificacion;

    private UUID codigoIdentificador;

    private SolicitanteServicio(String numeroIdentificacion, String nombreSolicitante, String nombreUsuario, Long telefonoSolicitante, String nombreIdentificacion, String tipoIdentificacion, UUID codigoIdentificador) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreSolicitante = nombreSolicitante;
        this.nombreUsuario = nombreUsuario;
        this.telefonoSolicitante = telefonoSolicitante;
        this.nombreIdentificacion = nombreIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.codigoIdentificador = codigoIdentificador;
    }

    public static SolicitanteServicio nuevoSolicitanteServicio(String numeroIdentificacion, String nombreSolicitante, String nombreUsuario, Long telefonoSolicitante, String nombreIdentificacion, String tipoIdentificacion, UUID codigoIdentificador) {
        ValidadorDeAtibutos.validarAtributosTexto(numeroIdentificacion, "número de identifición", 12);
        ValidadorDeAtibutos.validarAtributosTexto(nombreSolicitante, "nombre", 30);
        ValidadorDeAtibutos.validarAtributosTexto(nombreUsuario, "usuario", 15);
        ValidadorDeAtibutos.validarObjetoNoNulo(telefonoSolicitante, "telefono");
        ValidadorDeAtibutos.validarAtributosTexto(nombreIdentificacion, "nombre del tipo de identificación", 30);
        ValidadorDeAtibutos.validarAtributosTexto(tipoIdentificacion, "tipo de identificación", 5);
        return new SolicitanteServicio(numeroIdentificacion, nombreSolicitante, nombreUsuario, telefonoSolicitante,
                nombreIdentificacion, tipoIdentificacion, codigoIdentificador);
    }

    private SolicitanteServicio(UUID identificador, String numeroIdentificacion, String nombreSolicitante, String nombreUsuario, Long telefonoSolicitante, String nombreIdentificacion, String tipoIdentificacion, UUID codigoIdentificador) {
        super(identificador);
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreSolicitante = nombreSolicitante;
        this.nombreUsuario = nombreUsuario;
        this.telefonoSolicitante = telefonoSolicitante;
        this.nombreIdentificacion = nombreIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.codigoIdentificador = codigoIdentificador;
    }

    public static SolicitanteServicio nuevoSolicitanteServicioConIdentificador(UUID id, String numeroIdentificacion, String nombreSolicitante, String nombreUsuario, Long telefonoSolicitante, String nombreIdentificacion, String tipoIdentificacion, UUID codigoIdentificador) {
        ValidadorDeAtibutos.validarAtributosTexto(numeroIdentificacion, "número de identifición", 12);
        ValidadorDeAtibutos.validarAtributosTexto(nombreSolicitante, "nombre", 30);
        ValidadorDeAtibutos.validarAtributosTexto(nombreUsuario, "usuario", 15);
        ValidadorDeAtibutos.validarObjetoNoNulo(telefonoSolicitante, "telefono");
        ValidadorDeAtibutos.validarAtributosTexto(nombreIdentificacion, "nombre del tipo de identificación", 30);
        ValidadorDeAtibutos.validarAtributosTexto(tipoIdentificacion, "tipo de identificación", 5);
        return new SolicitanteServicio(id, numeroIdentificacion, nombreSolicitante, nombreUsuario, telefonoSolicitante,
                nombreIdentificacion, tipoIdentificacion, codigoIdentificador);
    }

}
