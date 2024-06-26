package com.ibm.lab.infrastructure.service.email;

import com.ibm.lab.Empregado;
import com.ibm.lab.domain.service.EnvioEmailService;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SmtpEnvioEmailService implements EnvioEmailService{

    
    private Mailer mail;

	@Override
	public void send(Empregado empregado, String resultado) {
        
        getMail().send(Mail.withText(empregado.getEmail(), "Notebook Solicitado", 
        message(empregado.getNome(), resultado)));

	}

    protected String message(String nome, String resultado) {
        return nome + 
        ", seu notebook foi solicitado, segue os detalhes da requisição " + resultado;
    }
	
}
