package br.edu.cefsa.faculdade.automato_rgcpf.service;

import org.springframework.stereotype.Service;

@Service
public class ValidadorService {

    public boolean validar(String documento) {
        if (documento == null || documento.isEmpty()) {
            return false;
        }

        return validarCPF(documento) || validarRG(documento);
    }

    private boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); 
        if (cpf.length() != 11) return false;
    
        int estado = 0;
        for (char c : cpf.toCharArray()) {
            switch (estado) {
                case 0:
                    estado = Character.isDigit(c) ? 1 : -1;
                    break;
                case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
                    estado = Character.isDigit(c) ? estado + 1 : -1;
                    break;
                case 10:
                    estado = Character.isDigit(c) ? 11 : -1;
                    break;
                case 11:
                    return Character.isDigit(c); 
                default:
                    return false;
            }
        }
        return estado == 11;
    }
    

    private boolean validarRG(String rg) {
        rg = rg.replaceAll("[^0-9xX]", "");
        if (rg.length() != 9) return false;
    
        if (rg.charAt(8) == 'x' || rg.charAt(8) == 'X') {
            return true;
        }
    
        int estado = 0;
        for (int i = 0; i < rg.length(); i++) {
            char c = rg.charAt(i);
    
            switch (estado) {
                case 0:
                    estado = Character.isDigit(c) ? 1 : (c == 'x' || c == 'X') ? 9 : -1;
                    break;
                case 1: case 2: case 3: case 4: case 5: case 6: case 7:
                    estado = Character.isDigit(c) ? estado + 1 : -1;
                    break;
                case 8:
                    estado = (c == 'x' || c == 'X') ? 9 : -1; 
                    break;
                case 9:
                    return false;  
                default:
                    return false;
            }
        }
        return estado == 9; 
    }
    
    
}
