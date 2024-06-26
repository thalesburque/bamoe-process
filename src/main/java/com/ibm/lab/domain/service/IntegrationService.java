package com.ibm.lab.domain.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.ibm.lab.Empregado;

@ApplicationScoped
public class IntegrationService {

    @Inject
    EnvioEmailService envioEmailService;

    public void send(Empregado empregado, String resultado) {
        envioEmailService.send(empregado, resultado);
    }

}
