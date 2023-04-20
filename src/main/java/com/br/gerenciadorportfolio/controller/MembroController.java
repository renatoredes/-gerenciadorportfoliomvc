package com.br.gerenciadorportfolio.controller;

import com.br.gerenciadorportfolio.request.MembroRequest;
import com.br.gerenciadorportfolio.entity.Membro;
import com.br.gerenciadorportfolio.entity.Projeto;
import com.br.gerenciadorportfolio.service.MembroService;
import com.br.gerenciadorportfolio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/membros")
public class MembroController {

    private List<Projeto> projetos;
    private String resultado;
    private MembroService membroService;

    private ProjetoService projetoService;

    @Autowired
    public MembroController(MembroService membroService, ProjetoService projetoService) {
        this.membroService = membroService;
        this.projetoService = projetoService;
    }

    @GetMapping("/listar")
    public String listarMembrosPorProjeto(Model model) {
        List<Membro> lista = membroService.listarMembrosPorProjeto(1L);
        model.addAttribute("membros", lista);
        return "listar-membros";
    }

    @GetMapping("/novo")
    public String novoMembro(Model model) {
        this.projetos = new ArrayList<>();
        this.projetos = this.projetoService.listarProjetos();

        model.addAttribute("projetos", this.projetos);
        model.addAttribute("membroRequest", new MembroRequest());

        return "cadastrar-membro";
    }

    @PostMapping("/salvar")
    public String cadastrarMembro(Model model, RedirectAttributes attributes,
                                  @ModelAttribute("membroRequest") MembroRequest membroRequest) {
        Membro membro = new Membro();
        Optional<Projeto> projetoBD = this.projetoService.buscarProjeto(membroRequest.getIdProjetoSelecionado());
        if (projetoBD.isPresent()) {
            membro.setProjeto(projetoBD.get());
            Membro novoMembro = membroService.cadastrarMembro(membro);
            if(Objects.nonNull(novoMembro)){
                this.resultado = "sucesso";
                attributes.addFlashAttribute("mensagem", "Gerente salvo com sucesso!");
                return "redirect:/membros/novo";
            }
        } else {
            this.resultado = "error";
            attributes.addFlashAttribute("mensagem", "Erro ao cadastrar membro");
            return "redirect:/membros/novo";
        }
        return "redirect:/membros/novo";
    }

    @PutMapping("/{membroId}")
    public ResponseEntity<Membro> atualizarMembro(@PathVariable Long projetoId, @PathVariable Long membroId, @RequestBody Membro membro) {
        Projeto projeto = new Projeto();
        projeto.setId(projetoId);
        membro.setProjeto(projeto);
        Membro membroAtualizado = membroService.atualizarMembro(membroId, membro);
        return ResponseEntity.ok(membroAtualizado);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> excluirMembro(@PathVariable Long projetoId, @PathVariable Long membroId) {
        membroService.excluirMembro(membroId);
        return ResponseEntity.noContent().build();
    }
}

