package co.edu.uco.burstcar.servicio.dominio.validador;

public class ValidadorDeObjetos {

    private ValidadorDeObjetos() {
    }

    public static void validarNoNulos(Object valor, String nombreAtributo) {
        if(valor == null) {
            throw new IllegalArgumentException("El atributo" + nombreAtributo +" no puede estar nulo");
        }
    }
}
