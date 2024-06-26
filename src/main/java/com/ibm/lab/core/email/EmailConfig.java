package com.ibm.lab.core.email;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.ibm.lab.domain.service.EnvioEmailService;
import com.ibm.lab.infrastructure.service.email.FakeEnvioEmailService;
import com.ibm.lab.infrastructure.service.email.SmtpEnvioEmailService;

import io.quarkus.mailer.Mailer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class EmailConfig {

    @Inject
    EmailProperties emailProperties;

    @Inject
    Mailer mail;
    
    @Produces
    @Singleton
    public EnvioEmailService envioEmailService() {
        
        log.info("tipo de email: " + emailProperties.getTipo());
        switch (emailProperties.getTipo()) {
            case FAKE -> {
                return new FakeEnvioEmailService();
            }
            case SMTP -> {
                return new SmtpEnvioEmailService(mail);
            }
            default -> throw new IllegalArgumentException("Unknown email type: " + emailProperties.getTipo());
        }
    }
    
}
