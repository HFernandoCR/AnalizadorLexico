package lexico;

%%

%class Lexer
%unicode
%public
%line
%column
%type Token

%{
    // Se pueden importar clases aquí si se requiere
%}

IDENTIFICADOR = [a-zA-Z_][a-zA-Z0-9_]*
NUMERO = [0-9]+

%%

"Robot"              { return new Token(yytext(), TipoToken.PALABRA_CLAVE); }
"iniciar"            { return new Token(yytext(), TipoToken.PALABRA_CLAVE); }
"detener"            { return new Token(yytext(), TipoToken.PALABRA_CLAVE); }
"abrirGarra"         { return new Token(yytext(), TipoToken.PALABRA_CLAVE); }
"cerrarGarra"        { return new Token(yytext(), TipoToken.PALABRA_CLAVE); }
"repetir"            { return new Token(yytext(), TipoToken.PALABRA_CLAVE); }
"finRepetir"         { return new Token(yytext(), TipoToken.PALABRA_CLAVE); }
{IDENTIFICADOR}      { return new Token(yytext(), TipoToken.IDENTIFICADOR); }
{NUMERO}             { return new Token(yytext(), TipoToken.NUMERO); }
"="                  { return new Token(yytext(), TipoToken.ASIGNACION); }
"+"                  { return new Token(yytext(), TipoToken.OPERADOR); }
"."                  { return new Token(yytext(), TipoToken.PUNTO); }
"("                  { return new Token(yytext(), TipoToken.PARENTESIS_ABRE); }
")"                  { return new Token(yytext(), TipoToken.PARENTESIS_CIERRA); }
[\t\n\r ]+           { /* Ignorar espacios en blanco */ }
.                    { return new Token(yytext(), TipoToken.INVALIDO); }