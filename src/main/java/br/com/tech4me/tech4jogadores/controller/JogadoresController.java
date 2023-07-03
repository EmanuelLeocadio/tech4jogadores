package br.com.tech4me.tech4jogadores.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4jogadores.model.Jogadores;
import br.com.tech4me.tech4jogadores.repository.JogadoresRepository;

@RestController
@RequestMapping("/jogadores")
public class JogadoresController {
@Autowired
    private JogadoresRepository repositorio;

    List<Jogadores> jogadores = new ArrayList();
    

     @GetMapping
    public List<Jogadores> obterJogadores() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Jogadores consultarPorId(@PathVariable String id) {
        Jogadores jogador = repositorio.findById(id).orElse(null);
        
        return jogador;
    }

     @PostMapping
    public ResponseEntity<String> cadastroJogador(@RequestBody Jogadores jogador) {
        repositorio.save(jogador);
        String mensagem = String.format("Nome: %s - Posição: %s - Valor : %d cadastrado com sucesso!", 
            jogador.getNome(), jogador.getPosicao(), jogador.getJogadorvalor());

        return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerJogador(@PathVariable String id) {
        repositorio.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

     @PutMapping("/{id}")
    public Jogadores atualizarJogador(@PathVariable String id, @RequestBody Jogadores novoJogador) {
       
        Jogadores antigoJogador = repositorio.findById(id).orElse(null);
if (antigoJogador != null) {
            antigoJogador.setNome(novoJogador.getNome());
            antigoJogador.setPosicao(novoJogador.getPosicao());
           antigoJogador.setJogadorvalor(novoJogador.getJogadorvalor());
            repositorio.save(antigoJogador);
        }
        
        return antigoJogador;
    }
}
