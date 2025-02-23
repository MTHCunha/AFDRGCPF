package br.edu.cefsa.faculdade.automato_rgcpf.controller;

import br.edu.cefsa.faculdade.automato_rgcpf.service.ValidadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validar")
public class ValidacaoController {

    @Autowired
    private ValidadorService validadorService;

    @PostMapping
    public String validarDocumento(@RequestParam String documento) {
        boolean valido = validadorService.validar(documento);
        return valido ? "Documento válido!" : "Documento inválido!";
    }
}
