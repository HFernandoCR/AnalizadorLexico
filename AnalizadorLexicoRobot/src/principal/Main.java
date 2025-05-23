/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import lexico.AnalizadorLexico;
import lexico.Token;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnalizadorLexico analizador = new AnalizadorLexico();

        System.out.println("=== ANALIZADOR LEXICO ===");
        System.out.println("Ingresar varias lineas de instrucciones.");
        System.out.println("Presionar Enter en una linea vacia para terminar.\n");

        StringBuilder entradaCompleta = new StringBuilder();
        while (true) {
            System.out.print(">> ");
            String linea = scanner.nextLine();
            if (linea.isBlank()) break;
            entradaCompleta.append(linea).append("\n");
        }

        List<Token> tokens = analizador.analizar(entradaCompleta.toString());

        System.out.printf("%-16s%-20s%n", "TOKEN", "TIPO");
        System.out.println("--------------------------------------------------");

        for (Token token : tokens) {
            System.out.printf("%-16s%-20s%n", token.getValor(), token.getTipo());
        }
    }
}
