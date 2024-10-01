package com.example.demo.Service1;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class IdentityService {


    private List<Identity> identidades = new ArrayList<>();

    public IdentityService() {

        identidades.add(new Identity("1234567"));
        identidades.add(new Identity("7654321"));
        identidades.add(new Identity("9876543"));
        identidades.add(new Identity("4567890"));
    }


    public void addIdentidad(Identity identidad) {
        identidades.add(identidad);
    }


    public boolean verificarCiExistente(String ci) {
        return identidades.stream().anyMatch(identidad -> identidad.getCi().equals(ci));
    }
}