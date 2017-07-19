package analisadorsintatico;
import analisadorlexico.*;

/**
 *  Analisador sintatico responsavel por verificar os comandos e avançar os tokens e invocar a maquina de moore
 * @author elly
 */

public class AnalisadorSintatico extends Analisador implements Constantes 
{
	protected AnalisadorEstados scanner;
	
        /**
         *  Instancia um analisador sintatico q
         * @author 
         * @param  _nomeArquivoEntrada : diretorio+nome do arquivo a ser analisado
         */

	public AnalisadorSintatico(String _nomeArquivoEntrada) {
		this.scanner = new AnalisadorEstados(_nomeArquivoEntrada);
		// lê o primeiro token e o coloca no campo tokenReconhecido
		this.leProxToken();
	}
	
        /**
         *  Contrutor default para analisadores
         * @author elly
         */

        public AnalisadorSintatico() {
		super();
	}

        /**
         *  Executa uma vez a maquina de Moore determinando o proximo token
         * @author elly
         */

	public void leProxToken() 
        {
            this.scanner.q0();
//            System.out.println(this.scanner.tokenReconhecido);
            ignoreEspaco();
	}

        
         /**
         *  Ignora tokens de espaços  e separadores antes de fazer verificaçao
         * @author elly
         */

        public void ignoreEspaco()
        {
            
            while ( this.scanner.tokenReconhecido == Token.ESPACO || this.scanner.tokenReconhecido == Token.SEPARADOR )
            { 
//                System.out.println(this.scanner.tokenReconhecido + " ignorado." );
                this.scanner.q0();
            }
            
        }
        
         /**
         *  Verifica se proximo token e t e avanca ponteiro de leitura
         * @author 
         * @param t : Token esperado a ser analisado
         */

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

	/**
        * Verifica se  proximo token e t sem avancar ponteiro de leitura
        * @author elly
        * @param t : token esperado a ser analisado
        */

	public boolean proxTokenIs(Token t) {
		return t == this.scanner.tokenReconhecido;
	}
}

