package com.br.gerenciadorportfolio.controller;

import com.br.gerenciadorportfolio.entity.Gerente;
import com.br.gerenciadorportfolio.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/gerentes")
public class GerenteController {
    private String resultado;
    private GerenteService gerenteService;

    @Autowired
    public GerenteController(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }


    @GetMapping("/listar")
    public String listar(Model model) {
        List<Gerente> lista = gerenteService.listarGerentes();
        model.addAttribute("gerentes", lista);
        return "listar-gerentes";
    }


    @GetMapping("/{id}")
    public String buscarGerente(@PathVariable Long id, Model model) {
        List<Gerente> lista = new ArrayList<>();
        Optional<Gerente> gerente = gerenteService.buscarGerente(id);
        if (gerente.isPresent()) {
            lista.add(gerente.get());
            model.addAttribute("gerentes", lista);
            return "listar-gerentes";
        } else {
            model.addAttribute("gerentes", lista);
            return "listar-gerentes";
        }
    }

    @GetMapping("/novo")
    public String novoGerente(){
        return "cadastrar-gerente";
    }

    @PostMapping("/salvar")
    public String criarGerente(Gerente gerente, Model model,
                               RedirectAttributes attributes) {
        Gerente novoGerente = gerenteService.salvarGerente(gerente);
        if(Objects.nonNull(novoGerente)){
            this.resultado = "sucesso";
            attributes.addFlashAttribute("mensagem", "Gerente salvo com sucesso!");
            return "redirect:/gerentes/novo";
        }
        attributes.addFlashAttribute("mensagem-error", "Erro ao cadastrar gerente");
        return "redirect:/gerentes/novo";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gerente> atualizarGerente(@PathVariable Long id, @RequestBody Gerente gerente) {
        Optional<Gerente> gerenteExistente = gerenteService.buscarGerente(id);
        if (gerenteExistente.isPresent()) {
            Gerente gerentetoAtualizado = gerenteService.salvarGerente(gerente);
            return ResponseEntity.ok(gerentetoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/remover/{id}")
    public String excluirGerente(@PathVariable Long id, RedirectAttributes attributes) {
        this.gerenteService.excluirGerente(id);
        List<Gerente> lista = this.gerenteService.listarGerentes();
        attributes.addFlashAttribute("gerentes", lista);
        return "redirect:/gerentes/listar";
    }

}

