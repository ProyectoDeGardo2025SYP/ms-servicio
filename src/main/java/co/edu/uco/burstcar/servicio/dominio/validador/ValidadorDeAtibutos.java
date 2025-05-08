package co.edu.uco.burstcar.servicio.dominio.validador;

public class ValidadorDeAtibutos {

    private ValidadorDeAtibutos() {
    }

    private static void validateNoNulos(String valor, String nombreAtributo) {
        if(valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El atributo " + nombreAtributo +" no puede estar nulo");
        }
    }

    public static void validarObjetoNoNulo(Object valor, String nombreAtributo) {
        if(valor == null) {
            throw new IllegalArgumentException("El atributo " + nombreAtributo +" no puede estar nulo");
        }
    }

    private static void validarTamanoTexto(String valor, String nombreAtributo, int tamano){
        if(valor.length()>tamano)
        {
            throw new IllegalArgumentException("El " + nombreAtributo +" es más grande de lo permitido, " +
                    "solo soporta " + tamano + " caracteres");
        }
    }

    public static void validarAtributosTexto(String valor, String mensaje, int tamano){
        validateNoNulos(valor, mensaje);
        validarTamanoTexto(valor, mensaje, tamano);
    }
}
