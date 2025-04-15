package co.edu.uco.burstcar.servicio.infraestructura.config.general.rabbit.solicitanteservicio;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq.solicitante")
public class PropiedadesConfiguracionSolicitanteRabbit {
    private String cola;
    private String exchange;
    private String clave;
    private String dlx;
    private String dlq;

    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDlx() {
        return dlx;
    }

    public void setDlx(String dlx) {
        this.dlx = dlx;
    }

    public String getDlq() {
        return dlq;
    }

    public void setDlq(String dlq) {
        this.dlq = dlq;
    }
}
