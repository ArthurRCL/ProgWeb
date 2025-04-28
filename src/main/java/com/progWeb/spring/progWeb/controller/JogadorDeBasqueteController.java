package com.progWeb.spring.progWeb.controller;

import com.progWeb.spring.progWeb.model.JogadorDeBasquete;
import com.progWeb.spring.progWeb.repository.JogadorDeBasqueteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorDeBasqueteController {

    @Autowired
    private JogadorDeBasqueteRepository jogadorRepository;

    @PostMapping
    public JogadorDeBasquete criar(@Valid @RequestBody JogadorDeBasquete jogador) {
        return jogadorRepository.save(jogador);
    }

    @GetMapping
    public List<JogadorDeBasquete> listar() {
        return jogadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public JogadorDeBasquete buscarPorId(@PathVariable Long id) {
        return jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
    }

    @PutMapping("/{id}")
    public JogadorDeBasquete atualizar(@PathVariable Long id, @Valid @RequestBody JogadorDeBasquete jogadorAtualizado) {
        JogadorDeBasquete jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        jogador.setNome(jogadorAtualizado.getNome());
        jogador.setPosicao(jogadorAtualizado.getPosicao());
        jogador.setDataNascimento(jogadorAtualizado.getDataNascimento());
        jogador.setNacionalidade(jogadorAtualizado.getNacionalidade());
        jogador.setAtivo(jogadorAtualizado.getAtivo());
        jogador.setAltura(jogadorAtualizado.getAltura());
        jogador.setNumero(jogadorAtualizado.getNumero());

        return jogadorRepository.save(jogador);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        jogadorRepository.deleteById(id);
    }
}
