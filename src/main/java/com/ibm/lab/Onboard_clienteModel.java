package com.ibm.lab;

import org.kie.kogito.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Onboard_clienteModel implements Model{

    private Empregado empregado;
    private Boolean aprovado;

}
