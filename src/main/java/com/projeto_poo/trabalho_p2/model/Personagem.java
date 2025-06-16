package com.projeto_poo.trabalho_p2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Personagem {

    private int id, idade;
    private String nome, raca, classe;

    // Inicialzação vazia
    public Personagem() {
    }

    // Para cadastrar
    public Personagem(int idade, String nome, String raca, String classe) {
        this.idade = idade;
        this.nome = nome;
        this.raca = raca;
        this.classe = classe;
    }

    // Para retornar na view
    public Personagem(int id, int idade, String nome, String raca, String classe) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.raca = raca;
        this.classe = classe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public static Personagem converter(Map<String, Object> registro) {
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nome");
        int idade = (Integer) registro.get("idade");
        String raca = (String) registro.get("raca");
        String classe = (String) registro.get("classe");

        return new Personagem(id, idade, nome, raca, classe);
    }

    // Pensei em passar ArrayList como tipo no lugar de List, mas percebi que List é
    // uma Interface genérica que dá mais flexibilidade. Pode ser gerado um
    // ArrayList a partir do tipo List, por exemplo. Ainda preciso estudar mais
    // sobre este ponto.
    public static List<Personagem> converterVarios(List<Map<String, Object>> registros) {
        ArrayList<Personagem> lista = new ArrayList<>();

        for (Map<String, Object> reg : registros) {
            lista.add(converter(reg));
        }

        return lista;
    }

}
