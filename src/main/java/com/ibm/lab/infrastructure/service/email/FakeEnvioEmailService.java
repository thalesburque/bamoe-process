package com.ibm.lab.infrastructure.service.email;

import com.ibm.lab.Empregado;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FakeEnvioEmailService extends SmtpEnvioEmailService {

	@Override
	public void send(Empregado empregado, String resultado) {
		log.info("[FAKE E-MAIL] Para: {}\n{}", empregado.getEmail(), 
        message(empregado.getNome(), resultado));
	}

}
