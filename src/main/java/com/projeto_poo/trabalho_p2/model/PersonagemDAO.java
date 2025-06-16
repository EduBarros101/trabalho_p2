package com.projeto_poo.trabalho_p2.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class PersonagemDAO {
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirPersonagem(Personagem persona) {
        String sql = "INSERT INTO personagens(nome,raca,classe,idade) VALUES(?,?,?,?)";
        Object[] parametros = new Object[4]; // Um para cada '?'
        parametros[0] = persona.getNome();
        parametros[1] = persona.getRaca();
        parametros[2] = persona.getClasse();
        parametros[3] = persona.getIdade();
        jdbc.update(sql, parametros);
    }

    public List<Map<String, Object>> puxarTodosPersonagens() {
        String sql = "SELECT * FROM personagens";
        return jdbc.queryForList(sql);
    }

    public Map<String, Object> puxarPersonagem(int id) {
        String sql = "SELECT * FROM personagens WHERE id = ?";
        return jdbc.queryForMap(sql, id);
    }

    public void atualizarPersonagem(int id, Personagem novo) {
        String sql = "UPDATE personagens SET nome = ?, idade = ?, raca = ?, classe = ? WHERE id = ?";
        Object[] parametros = new Object[5];
        parametros[0] = novo.getNome();
        parametros[1] = novo.getIdade();
        parametros[2] = novo.getRaca();
        parametros[3] = novo.getClasse();
        parametros[4] = id;
        jdbc.update(sql, parametros);
    }

    public void deletar(int id) {
        String sql = "DELETE FROM personagens WHERE id = ?";
        jdbc.update(sql, id);
    }
}
