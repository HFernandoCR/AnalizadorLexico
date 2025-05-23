/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lexico;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorLexico {

    private static final String[] PALABRAS_CLAVE = {
        "Robot", "iniciar", "detener", "abrirGarra", "cerrarGarra", "repetir", "finRepetir"
    };

    public List<Token> analizar(String entrada) {
        List<Token> tokens = new ArrayList<>();
        String[] partes = entrada.split("(?<=\\W)|(?=\\W)");

        for (String parte : partes) {
            if (parte.isBlank()) continue;
            tokens.add(clasificarToken(parte));
        }

        return tokens;
    }

    private Token clasificarToken(String lexema) {
        if (esPalabraClave(lexema)) return new Token(lexema, TipoToken.PALABRA_CLAVE);
        if (lexema.matches("[a-zA-Z_][a-zA-Z0-9_]*")) return new Token(lexema, TipoToken.IDENTIFICADOR);
        if (lexema.matches("\\d+")) return new Token(lexema, TipoToken.NUMERO);
        if (lexema.equals("=")) return new Token(lexema, TipoToken.ASIGNACION);
        if (lexema.equals("+")) return new Token(lexema, TipoToken.OPERADOR);
        if (lexema.equals("(")) return new Token(lexema, TipoToken.PARENTESIS_ABRE);
        if (lexema.equals(")")) return new Token(lexema, TipoToken.PARENTESIS_CIERRA);
        if (lexema.equals(".")) return new Token(lexema, TipoToken.PUNTO);

        return new Token(lexema, TipoToken.INVALIDO);
    }

    private boolean esPalabraClave(String palabra) {
        for (String clave : PALABRAS_CLAVE) {
            if (clave.equals(palabra)) return true;
        }
        return false;
    }
}

