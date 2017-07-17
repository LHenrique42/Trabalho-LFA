package analisadorsintatico;
import analisadorlexico.*;

public class ErroSintatico extends RuntimeException implements Constantes {
	private Token tokenEncontrado;
	private Token[] tokensEsperados;
        private String mensagem;

	public ErroSintatico(Token _tokenEncontrado, Token[] _tokensEsperados) {
		this.tokenEncontrado = _tokenEncontrado;
		this.tokensEsperados = _tokensEsperados;
	}
	public ErroSintatico(Token _tokenEncontrado, Token _tokenEsperado) {
		this.tokenEncontrado = _tokenEncontrado;
		this.tokensEsperados = new Token[1];
		tokensEsperados[0] = _tokenEsperado;
	}
        
        //Sobrecarga para "token surpresa"
        public ErroSintatico(Token _tokenEncontrado) {
            this.tokenEncontrado = _tokenEncontrado;
            this.tokensEsperados = new Token[0];
            this.mensagem = "Outro comando";
	}
        
	public String toString() {
		for(int i=0; i<this.tokensEsperados.length; i++)
			this.mensagem += this.tokensEsperados[i] + " ";
		return "token encontrado: "+this.tokenEncontrado+
		       "\nera(m) esperado(s): "+ this.mensagem;
	}
}

