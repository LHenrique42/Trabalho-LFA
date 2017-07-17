package analisadorsintatico;
import analisadorlexico.*;

public class AnalisadorSintatico extends Analisador implements Constantes 
{
	protected AnalisadorEstados scanner;
	
	public AnalisadorSintatico(String _nomeArquivoEntrada) {
		this.scanner = new AnalisadorEstados(_nomeArquivoEntrada);
		// lê o primeiro token e o coloca no campo tokenReconhecido
		this.leProxToken();
	}
	public AnalisadorSintatico() {
		super();
	}

	// executa 1 vez a máquina de Moore
	public void leProxToken() 
        {
            this.scanner.q0();
            System.out.println(this.scanner.tokenReconhecido);
            ignoreEspaco();
	}

        public void ignoreEspaco()
        {
            
            while ( this.scanner.tokenReconhecido == Token.ESPACO || this.scanner.tokenReconhecido == Token.SEPARADOR )
            { 
                System.out.println(this.scanner.tokenReconhecido + " ignorado." );
                this.scanner.q0();
            }
            
        }
        
	// verifica se o próximo token é t
	// avança o ponteiro para o próximo token
	public void reconhece(Token t) {
            
            ignoreEspaco();
            if(t == this.scanner.tokenReconhecido ) 
            {
                this.leProxToken();
                System.out.println(this.scanner.tokenReconhecido + " Reconhecido");

            }
            else 
                throw new ErroSintatico(this.scanner.tokenReconhecido, t);
	}

	// verifica se o próximo token é t
        // N O avança o ponteiro de leitura
	public boolean proxTokenIs(Token t) {
		return t == this.scanner.tokenReconhecido;
	}
}

