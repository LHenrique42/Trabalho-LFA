package analisadorsintatico;

public class AnalisadorGramatica extends AnalisadorSintatico {
	
	public AnalisadorGramatica(String _nomeArquivoEntrada) {
		super(_nomeArquivoEntrada);
	}
	public void programa() {
		listaComandos(); 
	}
        
        public void listaComandos() {
            if(proxTokenIs(Token.IF) || proxTokenIs(Token.WHILE) || proxTokenIs(Token.DO) || proxTokenIs(Token.FOR) || proxTokenIs(Token.SWITCH) || proxTokenIs(Token.PTV) || proxTokenIs(Token.NEGACAO) || proxTokenIs(Token.AP) || proxTokenIs(Token.NUMERO) || proxTokenIs(Token.VARIAVEL) || proxTokenIs(Token.VARIAVEL) || proxTokenIs(Token.OP_UNARIO) || proxTokenIs(Token.OP_UN_BIN)){
              comando();
              listaComandos();
            }else if(proxTokenIs(Token.EOF)){
                    ;
            }
	}
        
        public void comando() {
            if(proxTokenIs(Token.IF)){
                If();
            }else if(proxTokenIs(Token.WHILE)){
                While();
            }else if(proxTokenIs(Token.DO)){
                doWhile();
            }else if(proxTokenIs(Token.FOR)){
                For();
            }else if(proxTokenIs(Token.SWITCH)){
                Switch();
            }else if(proxTokenIs(Token.PTV)){
                reconhece(Token.PTV);
            }else if(proxTokenIs(Token.NEGACAO) || proxTokenIs(Token.AP) || proxTokenIs(Token.NUMERO) || proxTokenIs(Token.VARIAVEL) || proxTokenIs(Token.VARIAVEL) || proxTokenIs(Token.OP_UNARIO) || proxTokenIs(Token.OP_UN_BIN)){
                expressao();
                reconhece(Token.PTV);
            }else if(proxTokenIs(Token.EOF)){
                ;
            }
	}
        
        public void If() {
          reconhece(Token.IF);
          reconhece(Token.AP);
          expressao();
          reconhece(Token.FP);
          corpo();
        }
        
        public void While() {
          reconhece(Token.WHILE);
          reconhece(Token.AP);
          expressao();
          reconhece(Token.FP);
          corpo();
        }
        
        public void doWhile() {
          reconhece(Token.DO);
          corpo();
          reconhece(Token.WHILE);
          reconhece(Token.AP);
          expressao();
          reconhece(Token.FP);
          reconhece(Token.PTV);
        }
        
        public void For() {
          reconhece(Token.FOR);
          reconhece(Token.AP);
          atribuicao();
          reconhece(Token.PTV);
          expressao();
          reconhece(Token.PTV);
          atribuicao();
          reconhece(Token.FP);
          corpo();
        }
        
        public void Switch() {
          reconhece(Token.SWITCH);
          reconhece(Token.AP);
          expressao();
          reconhece(Token.FP);
          reconhece(Token.ACH);
          caso();
          reconhece(Token.FCH);
        }

        public void corpo() {
            if(proxTokenIs(Token.IF) || proxTokenIs(Token.WHILE) || proxTokenIs(Token.DO) || proxTokenIs(Token.FOR) || proxTokenIs(Token.SWITCH) || proxTokenIs(Token.PTV) || proxTokenIs(Token.NEGACAO) || proxTokenIs(Token.AP) || proxTokenIs(Token.NUMERO) || proxTokenIs(Token.VARIAVEL) || proxTokenIs(Token.VARIAVEL) || proxTokenIs(Token.OP_UNARIO) || proxTokenIs(Token.OP_UN_BIN)){
              comando();
            }else if(proxTokenIs(Token.ACH) ){
              reconhece(Token.ACH);
              listaComandos();
              reconhece(Token.FCH);

            }
        }
        
        public void caso() {
            if(proxTokenIs(Token.CASE)){
              reconhece(Token.CASE);
              condicao();
              reconhece(Token.DPT);
              listaComandos();
              bicaso();
            }else if(proxTokenIs(Token.EOF)){
                ;
            }
        }
        
        public void bicaso() {
            if(proxTokenIs(Token.CASE)){
              reconhece(Token.CASE);
              caso();
            }else if(proxTokenIs(Token.EOF)){
                ;
            }
        }
        
        public void condicao() {
            if(proxTokenIs(Token.CARACTERE)){
              reconhece(Token.CARACTERE);
              caso();
            }else if(proxTokenIs(Token.NUMERO)){
               reconhece(Token.NUMERO);
            }
        }
        // necessita correção
        public void atribuicao() {
            if(proxTokenIs(Token.VARIAVEL)){
              reconhece(Token.VARIAVEL);
              reconhece(Token.IGUALDADE);
              expressao();
              multAtribuicao();
            }else if(proxTokenIs(Token.VARIAVEL) || proxTokenIs(Token.OP_UNARIO) || proxTokenIs(Token.OP_UN_BIN) ){
               unarios();
            }
        }
        
        public void multAtribuicao() {
            if(proxTokenIs(Token.VIRG)){
              reconhece(Token.VIRG);
              atribuicao();
            }else if(proxTokenIs(Token.EOF) ){
               ;
            }
        }
        
        public void expressao() {
            if(proxTokenIs(Token.NEGACAO)){
              reconhece(Token.NEGACAO);
              expressao();
            }else if(proxTokenIs(Token.EOF) ){
              reconhece(Token.AP);
              expressao();
              reconhece(Token.FP);
            }else if(proxTokenIs(Token.EOF) ){
              reconhece(Token.NUMERO);
              subExpressao();
            }else if(proxTokenIs(Token.EOF) ){
              reconhece(Token.VARIAVEL);
              subExpressao();
            }else if(proxTokenIs(Token.VARIAVEL) || proxTokenIs(Token.OP_UNARIO) || proxTokenIs(Token.OP_UN_BIN) ){
               unarios();
               subExpressao();
            }
        }
        
        public void unarios() {
            if(proxTokenIs(Token.VARIAVEL)){
              reconhece(Token.VARIAVEL);
              reconhece(Token.OP_UNARIO);
            }else if(proxTokenIs(Token.OP_UNARIO) ){
              reconhece(Token.OP_UNARIO);
              reconhece(Token.VARIAVEL);
            }else if(proxTokenIs(Token.OP_UN_BIN) ){
              reconhece(Token.OP_UN_BIN);
              reconhece(Token.VARIAVEL);
            }
        }
        
        public void subExpressao() {
            if(proxTokenIs(Token.NEGACAO) || proxTokenIs(Token.AP) || proxTokenIs(Token.NUMERO) || proxTokenIs(Token.VARIAVEL) || proxTokenIs(Token.VARIAVEL) || proxTokenIs(Token.OP_UNARIO) || proxTokenIs(Token.OP_UN_BIN)){
              expressao();
              reconhece(Token.OP_BINARIO);
            }else if(proxTokenIs(Token.EOF) ){
               ;
            }
        }
}
