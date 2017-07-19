package analisadorsintatico;
import analisadorlexico.*;
/**
 *  Classe de erros sintaticos em tempo de execuçao
 * @author 
 */

public class ErroSintatico extends RuntimeException implements Constantes {
	private Token tokenEncontrado;
	private Token[] tokensEsperados;
        private String mensagem;

        /**
        * Instancia erro sintatico com vetor de  tokens esperador e token encontrado para mensagem
        * @author 
        */
	public ErroSintatico(Token _tokenEncontrado, Token[] _tokensEsperados) {
		this.tokenEncontrado = _tokenEncontrado;
		this.tokensEsperados = _tokensEsperados;
                this.mensagem = "";
	}
	
        /**
        * Instancia erro sintatico com token esperado e token encontrado para mensagem
        * @author 
        */
        public ErroSintatico(Token _tokenEncontrado, Token _tokenEsperado) {
		this.mensagem = "";
                this.tokenEncontrado = _tokenEncontrado;
		this.tokensEsperados = new Token[1];
		tokensEsperados[0] = _tokenEsperado;
	}
        
        /**
        * Instancia erro sintatico com vetor de token encontrado para mensagem Token surpresa
        * geral
        * @author 
        */
        public ErroSintatico(Token _tokenEncontrado) {
            this.tokenEncontrado = _tokenEncontrado;
            this.tokensEsperados = new Token[0];
            this.mensagem = "Outro comando";
	}
        
        /**
        * Cria mensagem com tokens esperados para console
        * @author 
        */
	public String toString() {
            
            for(int i=0; i<this.tokensEsperados.length; i++)
			this.mensagem += this.tokensEsperados[i] + " ";
		return "token encontrado: "+this.tokenEncontrado+
		       "\nera(m) esperado(s): "+ this.mensagem;
	}
}

