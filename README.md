# Analizador Léxico - Lenguajes y Autómatas I

Este repositorio contiene dos versiones de un **analizador léxico** diseñado para interpretar instrucciones simples de control de un brazo robótico.

## Estructura del repositorio

- `AnalizadorLexicoRobot/`: Analizador hecho **solo con código Java**, sin librerías externas.
- `AnalizadorLexicoRobotJFlex/`: Analizador hecho usando **JFLEX** (generador léxico para Java.

## Ejemplo de entrada
```bash
Robot r1
r1.iniciar
r1.base=90
r1.abrirGarra()
```

## Salida esperada
```bash
TOKEN           TIPO
----------------------------------------
Robot           PALABRA_CLAVE
r1              IDENTIFICADOR
.               PUNTO
iniciar         PALABRA_CLAVE
.               PUNTO
base            IDENTIFICADOR
=               ASIGNACION
90              NUMERO
.               PUNTO
abrirGarra      PALABRA_CLAVE
(               PARENTESIS_ABRE
)               PARENTESIS_CIERRA
```
