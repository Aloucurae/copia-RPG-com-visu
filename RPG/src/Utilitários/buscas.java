/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitários;

import Tabelas.Jogadores;
import conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexjonas
 */
public class buscas {

    private final Connection conecta;
    private Object rs;

    public buscas() throws SQLException {
        this.conecta = conexao.getConexao();

    }
    // busca jogador apartir do nome para login
    public List<Jogadores> buscaJogador(String nomJog) throws SQLException {

        String sql = "SELECT * FROM Jogadores where nome_jogador like ? ";
        List<Jogadores> lista;

        PreparedStatement stmt = this.conecta.prepareStatement(sql);
        stmt.setString(1, nomJog);
        ResultSet RS = stmt.executeQuery();
        {

            lista = new ArrayList<>();

            while (RS.next()) {

                Jogadores jog = new Jogadores();

                jog.setCodigo_jogador(RS.getInt("codigo_jogador"));
                jog.setNome_jogador(RS.getString("nome_jogador"));
                jog.setSenha_jogador(RS.getString("senha_jogador"));
                jog.setMestre_jogador(RS.getBoolean("mestre_jogador"));

                lista.add(jog);

            }
        }
        return lista;
    }
    //buscaPersonagem
    
     public List<Jogadores> buscaPersonagens(String codJog) throws SQLException {

        String sql = "SELECT * FROM Jogadores where nome_jogador like ? ";
        List<Jogadores> lista;

        PreparedStatement stmt = this.conecta.prepareStatement(sql);
        stmt.setString(1, codJog);
        ResultSet RS = stmt.executeQuery();
        {

            lista = new ArrayList<>();

            while (RS.next()) {

                Jogadores jog = new Jogadores();

                jog.setCodigo_jogador(RS.getInt("codigo_jogador"));
                jog.setNome_jogador(RS.getString("nome_jogador"));
                jog.setSenha_jogador(RS.getString("senha_jogador"));
                jog.setMestre_jogador(RS.getBoolean("mestre_jogador"));

                lista.add(jog);

            }
        }
        return lista;
    }
    
    
}
