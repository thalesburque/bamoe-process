package com.ibm.lab.core.email;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import lombok.Getter;
import lombok.Setter;

@ApplicationScoped
@Getter
@Setter
public class EmailProperties {

    @NotNull
    @ConfigProperty(name = "lab.email.remetente")
    private String remetente;

    @ConfigProperty(name = "lab.email.sandbox.destinatario")
    private String sandboxDestinatario;

    @ConfigProperty(name = "lab.email.tipo")
    private TipoEmail tipo;

    public enum TipoEmail {
        FAKE,
        SMTP,
        SANDBOX
    }
}