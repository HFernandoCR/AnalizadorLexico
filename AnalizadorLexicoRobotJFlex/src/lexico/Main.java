/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lexico;

import java.io.StringReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ANALIZADOR LEXICO (JFlex) ===");
        System.out.println("Ingresa las instrucciones para el robot (linea vacia para terminar):\n");

        StringBuilder entrada = new StringBuilder();
        while (true) {
            System.out.print(">> ");
            String linea = scanner.nextLine();
            if (linea.isBlank()) break;
            entrada.append(linea).append("\n");
        }

        // Crea el lexer con la entrada del usuario
        Lexer lexer = new Lexer(new StringReader(entrada.toString()));
        Token token;
        System.out.printf("%-16s%-20s%n", "TOKEN", "TIPO");
        System.out.println("--------------------------------------------------");

        while ((token = (Token) lexer.yylex()) != null) {
            System.out.printf("%-16s%-20s%n", token.getValor(), token.getTipo());
        }
    }
}
