Basic Compiler - Java


- Lex file

```
%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_TOKENS 100

int token_counter = 0;
int symbol_counter = 0;
char tokens[MAX_TOKENS][2][100];
char symbols[MAX_TOKENS][2][100];
char oldText[100];

void adicionarToken(char *token, char type) {
    if (token_counter < MAX_TOKENS) {
    	strcpy(tokens[token_counter][0], token);
        tokens[token_counter][1][0] = type;
        token_counter++;
    }
}

void adicionarSimbolo(char *symbol, char type) {
    if (symbol_counter < MAX_TOKENS) {
        strcpy(symbols[symbol_counter][0], symbol);
        symbols[symbol_counter][1][0] = type;
        symbol_counter++;
    }

}

void imprimirTabelaTokens() {
    printf("Tabela de tokens\n");
    printf("Lexema \t Token\t\n");
    printf("-------------------\n");

    for (int i = 0; i < token_counter; i++) {
    	switch(tokens[i][1][0]) {
    		case '0':
    		  printf("%-10s \t <%s>\t\n", tokens[i][0], tokens[i][0]);
    		  break;
    		  
    		case '1':
    		  printf("%-10s \t <float,%s>\t\n", tokens[i][0], tokens[i][0]);
    		  break;
    		  
    		case '2':
    		  printf("%-10s \t <integer,%s>\t\n", tokens[i][0], tokens[i][0]);
    		  break;
    		  
    		case '3':
    		  printf("%-10s \t <string,%s>\t\n", tokens[i][0], tokens[i][0]);
    		  break;
    		  
    	        case '4':
    		  printf("%-10s \t <function,%s>\t\n", tokens[i][0], tokens[i][0]);
    		  break;
    		  
    		case '5':
    		  printf("%-10s \t <var,%s>\t\n", tokens[i][0], tokens[i][0]);
    		  break;
    		  
    		default:
    		  printf("%-10s \t <ext,%s>\t\n", tokens[i][0], tokens[i][0]);
    		  break;
    	}
    }
}

void imprimirTabelaSimbolos() {
    printf("Tabela de simbolos\n");
    printf("\tToken \t\t nome \t\t tipo\n");
    printf("----------------------------------------------------\n");

    for (int i = 0; i < symbol_counter; i++) {
    	switch(symbols[i][1][0]) { 
    		case '1':
    		  printf("\t<float, %d> \t %-12s \t %-12s\t\n", i, symbols[i][0], "float");
    		  break;
    		  
    		case '2':
    		  printf("\t<integer, %d> \t %-12s \t %-12s\t\n", i, symbols[i][0], "integer");
    		  break;
    		  
    		case '3':
    		  printf("\t<string, %d> \t %-12s \t %-12s\t\n", i, symbols[i][0], "string");
    		  break;
    		  
    	        case '4':
    	          printf("\t<function, %d> \t %-12s \t %-12s\t\n", i, symbols[i][0], "function");
    		  break;
    		  
    		case '5':
    		  printf("\t<var, %d> \t %-12s \t %-12s\t\n", i, symbols[i][0], "var");
    		  break;
    		  
    		default:
    		  printf("\t<ext, %d> \t %-12s \t %-12s\t\n", i, symbols[i][0], "ext");
    		  break;
    	}
        
    }
}

%}

KEYWORD if|else|namespace|import|class|String|Integer|Float|void|method|return|printf|[\+\\\-*/=;{},()]
DIGIT ([1-9][0-9]*)|0
LETTER [a-zA-Z$.(\->)\d\\]
CLASSVAR ^\$this->[a-zA-Z]*
FLOAT [0-9]+\.[0-9]+

%%
{KEYWORD} { adicionarToken(yytext, '0'); }
{FLOAT} { adicionarToken(yytext, '1'); adicionarSimbolo(yytext, '1'); }
{CLASSVAR} {
		adicionarToken(yytext, '5');
		adicionarSimbolo(yytext, '5');
}
{LETTER}+ { 

	if(strcmp(oldText,"method") == 0) {
		adicionarToken(yytext, '4');
		adicionarSimbolo(yytext, '4');
	} else if(yytext[0] == '$') {
		adicionarToken(yytext, '5');
		adicionarSimbolo(yytext, '5');
	} else {
		adicionarToken(yytext, '3');
		adicionarSimbolo(yytext, '3');
	}
	
	
	oldText[0] = '\0';
	strcpy(oldText, yytext);
}
{DIGIT}+ { adicionarToken(yytext, '2'); adicionarSimbolo(yytext, '2'); }

%%

int main() {
    char input[1000];
    printf("Entre com a string: ");
    fgets(input, sizeof(input), stdin);
    input[strcspn(input, "\n")] = '\0';

    yy_scan_string(input);
    yylex();

    imprimirTabelaTokens();
    printf("\n");
    imprimirTabelaSimbolos();

    return 0;
}

int yywrap() {
  return 1;
}
```
