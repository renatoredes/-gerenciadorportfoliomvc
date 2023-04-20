package com.br.gerenciadorportfolio.controller;

import com.br.gerenciadorportfolio.entity.Gerente;
import com.br.gerenciadorportfolio.repository.GerenteRepository;
import com.br.gerenciadorportfolio.service.GerenteService;
import com.br.gerenciadorportfolio.util.MockProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
@WebMvcTest(GerenteControllerTest.class)
public class GerenteControllerTest {

    @InjectMocks
    private GerenteController gerenteController;

    @Mock
    private GerenteService gerenteService;

//    @InjectMocks
    private GerenteRepository gerenteRepository;

    @Mock
    private RedirectAttributes redirectAttributes;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private Model model;

    @Test
    void should_returnTrue_when_postGerente_given_anInvalidPayload(){
        Gerente gerente = MockProvider.generateMockGerente();

        when(gerenteService.salvarGerente(any(Gerente.class)))
                .thenReturn(any(Gerente.class));

        String gerenteCriado = gerenteController.criarGerente(gerente, model, redirectAttributes);

        assertEquals(Boolean.TRUE, gerenteCriado.equals("redirect:/gerentes/novo"));
        assertNotNull(gerenteCriado);
        verify(gerenteService, times(1)).salvarGerente(gerente);
    }

    @Test
    void should_returnTrueGerenteService_when_find_given_aParameterValid(){
        Long id = MockProvider.generateMockGerente().getId();
        Optional<Gerente> gerente = Optional.ofNullable(MockProvider.generateMockGerente());

        when(gerenteService.buscarGerente(any())).thenReturn(gerente);

        String gerenteBD = gerenteController.buscarGerente(id, model);
        assertNotNull(gerenteBD);
        verify(gerenteService, times(1)).buscarGerente(id);
    }

    @Test
    void should_returnFalseGerenteService_when_find_given_aParameterInValid(){
        Optional<Gerente> gerente =
                Optional.ofNullable(MockProvider.generateMockGerente());

        when(gerenteService.buscarGerente(any())).thenReturn(gerente);

        String gerenteBD = gerenteController.buscarGerente(0L, model);
        assertEquals(Boolean.FALSE, gerenteBD.contains("false"));
        assertNotNull(gerenteBD);
        verify(gerenteService, times(1)).buscarGerente(0L);
    }


}
