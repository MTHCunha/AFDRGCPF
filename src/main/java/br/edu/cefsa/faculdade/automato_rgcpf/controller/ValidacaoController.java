package br.edu.cefsa.faculdade.automato_rgcpf.controller;

import br.edu.cefsa.faculdade.automato_rgcpf.service.ValidadorService;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validar")
public class ValidacaoController {

    @Autowired
    private ValidadorService validadorService;

    @PostMapping
    public ResponseEntity<Map<String, String>> validarDocumento(@RequestParam String documento) {
        boolean valido = validadorService.validar(documento);
        String mensagem = valido ? "✅ Documento válido!" : "❌ Documento inválido!";
        
        Map<String, String> resposta = Collections.singletonMap("mensagem", mensagem);
        return ResponseEntity.ok(resposta);
    }
}
