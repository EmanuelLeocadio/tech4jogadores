package br.com.tech4me.tech4jogadores.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Jogadores {
    @Id

   
        private String id;
        
    
    private String nome;
    private String posicao;
    private double jogadorvalor;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public double getJogadorvalor() {
        return jogadorvalor;
    }
    public void setJogadorvalor(double jogadorvalor) {
        this.jogadorvalor = jogadorvalor;
    }
 public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}