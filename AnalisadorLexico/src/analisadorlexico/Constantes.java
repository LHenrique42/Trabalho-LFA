package analisadorlexico;

public interface Constantes {
    
    enum Token { ESPACO,EOF, WHILE, DO, IF , FOR, SWITCH, CASE, AP, FP, ACH, FCH, PTV, DPT, NEGACAO, VARIAVEL, NUMERO, OP_UN_BIN, OP_UNARIO, OP_BINARIO, IGUALDADE, ASP, CARACTERE }
        
    char    EOF = 0,
            AP = '(',
            FP = '(',
            ACH = '{',
            FCH = '}',
            PTV = ';',
            DPT = ':',
            ESPACO = ' ',
            NEGACAO = '!';
            
          
    String  WHILE = "while",
            DO = "do",
            IF = "if",
            FOR = "for",
            SWITCH = "switch",
            CASE = "case",
            LETRA = "abcdefghijklmnopqrstuvwxyz",
            DIGITO = "0123456789",
            SINAL = "+-",
            OP_BINARIO = "*/%&&||==!=&|>><<",
            OP_UN_BIN = "+-",
            OP_UNARIO = "++--",
            ALFA = LETRA + DIGITO + '_',
            ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+-*/%&|=!&|><(){};': " + EOF;
            //TERMINAL = "\n\t\a";
            
  
    String  NOME_DEFAULT_ARQUIVO_ENTRADA = "entrada.txt";
            
    
}
