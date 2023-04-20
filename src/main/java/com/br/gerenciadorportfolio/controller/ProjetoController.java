package com.br.gerenciadorportfolio.controller;


import com.br.gerenciadorportfolio.entity.Gerente;
import com.br.gerenciadorportfolio.entity.Membro;
import com.br.gerenciadorportfolio.entity.Projeto;
import com.br.gerenciadorportfolio.service.GerenteService;
import com.br.gerenciadorportfolio.service.MembroService;
import com.br.gerenciadorportfolio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {

    private List<Gerente> gerentes;

    private List<Membro> membros;

    private String resultado;
    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private MembroService membroService;

    @Autowired
    private GerenteService gerenteService;

    @GetMapping("/novo")
    public String novoProjeto(Model model){
        this.gerentes = this.gerenteService.listarGerentes();
        model.addAttribute("gerentes", this.gerentes);
        this.membros = this.membroService.listarMembros();
        model.addAttribute("membros", this.membros);
        return "cadastrar-projeto";
    }

    @PostMapping("/salvar")
    public String criarProjeto(Projeto projeto,Model model,
                               RedirectAttributes attributes) {
        Projeto novoProjeto = projetoService.salvarProjeto(projeto);
        if(Objects.nonNull(novoProjeto)){
            this.resultado = "sucesso";
            attributes.addFlashAttribute("mensagem", "Projeto salvo com sucesso!");
            return "redirect:/projetos/novo";
        }
        attributes.addFlashAttribute("mensagem-error", "Erro ao cadastrar projeto");
        return "redirect:/projetos/novo";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Projeto> lista = projetoService.listarProjetos();
        model.addAttribute("projetos", lista);
        return "listar-projetos";
    }

    @GetMapping(value = "/{id}", produces = { MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Projeto> buscarProjeto(@PathVariable Long id) {
        Optional<Projeto> projeto = projetoService.buscarProjeto(id);
        if (projeto.isPresent()) {
            return ResponseEntity.ok(projeto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualizarProjeto(@PathVariable Long id, @RequestBody Projeto projeto) {
        Optional<Projeto> projetoExistente = projetoService.buscarProjeto(id);
        if (projetoExistente.isPresent()) {
            Projeto projetoAtualizado = projetoService.salvarProjeto(projeto);
            return ResponseEntity.ok(projetoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProjeto(@PathVariable Long id) {
        projetoService.excluirProjeto(id);
        return ResponseEntity.noContent().build();
    }
}

