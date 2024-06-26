package com.ibm.lab.domain.service;

import com.ibm.lab.Empregado;

public interface EnvioEmailService {

    void send(Empregado empregado, String resultado);

}
