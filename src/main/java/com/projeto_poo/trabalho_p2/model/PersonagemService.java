package com.projeto_poo.trabalho_p2.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService {

    @Autowired
    PersonagemDAO cdao;

    public void inserirPersonagem(Personagem persona) {
        cdao.inserirPersonagem(persona);
    }

    public List<Personagem> puxarTodosPersonagens() {
        return Personagem.converterVarios(cdao.puxarTodosPersonagens());
    }

    public void atualizarPersonagem(int id, Personagem novo) {
        cdao.atualizarPersonagem(id, novo);
    }

    public Personagem puxarPersonagem(int id) {
        return Personagem.converter(cdao.puxarPersonagem(id));
    }

    public void deletar(int id) {
        cdao.deletar(id);
    }
}
