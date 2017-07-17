package analisadorsintatico;

public class AnalisadorGramatica extends AnalisadorSintatico 
{
	
	public AnalisadorGramatica(String _nomeArquivoEntrada) 
        {
		super(_nomeArquivoEntrada);
	}
	public void programa() 
        {
		listaComandos();
//                reconhece(Token.EOF);
	}
        
        public void listaComandos() 
        {
            if( proxTokenIs(Token.IF) || proxTokenIs(Token.WHILE) ||
                    proxTokenIs(Token.DO) || proxTokenIs(Token.FOR) ||
                    proxTokenIs(Token.SWITCH) || proxTokenIs(Token.PTV) ||
                    proxTokenIs(Token.NEGACAO) || proxTokenIs(Token.AP) || 
                    proxTokenIs(Token.NUMERO) || proxTokenIs(Token.VARIAVEL) 
                    || proxTokenIs(Token.OP_UNARIO) || proxTokenIs(Token.OP_UN_BIN)){
                
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
            if(proxTokenIs(Token.IF) || proxTokenIs(Token.WHILE) || proxTokenIs(Token.DO) || proxTokenIs(Token.FOR) || proxTokenIs(Token.SWITCH) || proxTokenIs(Token.PTV) || proxTokenIs(Token.NEGACAO) || proxTokenIs(Token.AP) || proxTokenIs(Token.NUMERO) || proxTokenIs(Token.VARIAVEL) || proxTokenIs(Token.OP_UNARIO) || proxTokenIs(Token.OP_UN_BIN)){
              comando();
            }else if(proxTokenIs(Token.ACH) ){
              reconhece(Token.ACH);
              listaComandos();
              reconhece(Token.FCH);
            } else  
                throw new ErroSintatico( this.scanner.tokenReconhecido );
            
                
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
            }else
                throw new ErroSintatico( this.scanner.tokenReconhecido );
        }
        
        public void bicaso() {
            if(proxTokenIs(Token.CASE)){
              reconhece(Token.CASE);
              caso();
            }else if(proxTokenIs(Token.EOF)){
                ;
            }else
                throw new ErroSintatico( this.scanner.tokenReconhecido );
        }
        
        public void condicao() {
            if(proxTokenIs(Token.CARACTERE)){
              reconhece(Token.CARACTERE);
              caso();
            }else if(proxTokenIs(Token.NUMERO)){
               reconhece(Token.NUMERO);
            }else
                throw new ErroSintatico( this.scanner.tokenReconhecido );
        }
        
        // necessita correção
        public void atribuicao() {
            if(proxTokenIs(Token.VARIAVEL)){
              reconhece(Token.VARIAVEL);
              cmdSubAtrib();
            }else if(proxTokenIs(Token.OP_UNARIO) || proxTokenIs(Token.OP_UN_BIN) ){
               cmdOP();
            }else
                throw new ErroSintatico( this.scanner.tokenReconhecido );
        }
        
        
        public void cmdOP()
        {
            if(proxTokenIs(Token.OP_UNARIO) )
            {
                reconhece(Token.OP_UNARIO);
                reconhece(Token.VARIAVEL);
            } else if(proxTokenIs(Token.OP_UN_BIN))
                    {
                        reconhece(Token.OP_UN_BIN);
                        expressao();
                    }else
                throw new ErroSintatico( this.scanner.tokenReconhecido );
            
        }
        
        public void cmdSubAtrib()
        {
            if ( proxTokenIs(Token.IGUALDADE) )
            {
                reconhece( Token.IGUALDADE);
                expressao();
                multAtribuicao();
            } else if ( proxTokenIs(Token.OP_UNARIO) )
            {
                reconhece( Token.OP_UNARIO);
            }else
                throw new ErroSintatico( this.scanner.tokenReconhecido );
        }
        
        
        public void multAtribuicao() {
            if(proxTokenIs(Token.VIRG)){
              reconhece(Token.VIRG);
              atribuicao();
            }else if(proxTokenIs(Token.EOF) ){
               ;
            }else
                throw new ErroSintatico( this.scanner.tokenReconhecido );
        }
        
        public void expressao() {
            if(proxTokenIs(Token.NEGACAO)){
              reconhece(Token.NEGACAO);
              expressao();
            }else if(proxTokenIs(Token.AP) ){
              reconhece(Token.AP);
              expressao();
              reconhece(Token.FP);
            }else if( proxTokenIs(Token.NUMERO) || proxTokenIs(Token.VARIAVEL) ||
                    proxTokenIs(Token.OP_UNARIO) || proxTokenIs(Token.OP_UN_BIN)  ){
              
              cmdExp();
              subExpressao();
            }else
            {
                Token[] tkEsperados = new Token[6];
                tkEsperados[0] = Token.NEGACAO;
                tkEsperados[1] = Token.AP;
                tkEsperados[2] = Token.NUMERO;
                tkEsperados[3] = Token.VARIAVEL;
                tkEsperados[4] = Token.OP_UNARIO;
                tkEsperados[5] = Token.OP_UN_BIN;
                throw new ErroSintatico( this.scanner.tokenReconhecido, tkEsperados );
            }
        }
        
        public void cmdExp()
        {
             if(proxTokenIs(Token.VARIAVEL) )
             {
                 reconhece(Token.VARIAVEL);
                 cmdSubExp();
             }else if( proxTokenIs(Token.NUMERO) )
             {
                 reconhece(Token.NUMERO);
             } else if ( proxTokenIs(Token.OP_UNARIO) || proxTokenIs(Token.OP_UN_BIN) )
             {
                 cmdOP();
             }
        }
        
        public void cmdSubExp()
        {
             if(proxTokenIs(Token.OP_UNARIO) )
             {
                 reconhece(Token.OP_UNARIO);
             }else if( proxTokenIs(Token.EOF) )
             {
                ;
             }
        }
        
        public void subExpressao() {
            if( proxTokenIs(Token.OP_BINARIO)){
              reconhece(Token.OP_BINARIO);
              expressao();              
            }else if( proxTokenIs(Token.OP_UN_BIN)){
              reconhece(Token.OP_UN_BIN);
              expressao();
            }else if(proxTokenIs(Token.EOF) )
            {
             ;
            }
        }
}
