package com.br.gerenciadorportfolio.service;

import com.br.gerenciadorportfolio.entity.Gerente;
import com.br.gerenciadorportfolio.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {
    @Autowired
    private GerenteRepository gerenteRepository;

    @Transactional(readOnly = true)
    public List<Gerente> listarGerentes() {
        return gerenteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Gerente> buscarGerente(Long id) {
        return gerenteRepository.findById(id);
    }

    @Transactional
    public Gerente salvarGerente(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    @Transactional
    public void excluirGerente(Long id) {
        gerenteRepository.deleteById(id);
    }
}
