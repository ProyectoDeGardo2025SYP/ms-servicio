package co.edu.uco.burstcar.servicio.dominio.dto;

import java.util.List;

public class PaginaDto<T> {
    private final List<T> contenidoPagina;
    private final int paginaActual;
    private final int totalPaginas;
    private final long totalElementos;

    public PaginaDto(List<T> contenidoPagina, int paginaActual, int totalPaginas, long totalElementos) {
        this.contenidoPagina = contenidoPagina;
        this.paginaActual = paginaActual;
        this.totalPaginas = totalPaginas;
        this.totalElementos = totalElementos;
    }

    public List<T> getContenidoPagina() {
        return contenidoPagina;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public long getTotalElementos() {
        return totalElementos;
    }
}
