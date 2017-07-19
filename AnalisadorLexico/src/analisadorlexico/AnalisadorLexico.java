
package analisadorlexico;

import java.io.FileReader;
import java.io.IOException;
  
    /**
    * Classe responsavel por validar lexicamente as entradas
    * @author 
    */

public class AnalisadorLexico extends Analisador 
{

    protected char proxCaractere;
    protected int linha = 1;
    public Token tokenReconhecido;
    protected int posicao = 0;
    protected StringBuffer entrada = new StringBuffer();
    
            
    /**
    * Metodo responsavel pela conexao com arquivo e copia para memoria.
    * @author 
    * @param nome : arquivo do qual sera copiado
    * @throws RuntimeException : Caso haja problema na abertura do arquivo
    */
    public AnalisadorLexico( String nome )
    {
        super( nome );
        try {
             FileReader arq = new FileReader( nome );
             int c;
             while( (c = arq.read() ) != -1 )
             {
                // mostra leitura arquivo caractere por caractere
//                System.out.println("" + (char)c);
                this.entrada.append( (char)c );
             }
             System.out.println("concluido");
            arq.close();
            leProxCaractere();

        } catch (IOException e) 
        {
            throw new RuntimeException("Erro ao tentar acessar" + nome );
        }
    }
    
/**
    * Le caracter da memoria e adiciona na posiçao de proximo 
    * @author 
    * @throws IndexOutOfBoundsExceptio : Caso nao haja mais caracteres
    */
    public void leProxCaractere()
    {
        try {
            this.proxCaractere = this.entrada.charAt(this.posicao++);
        } catch (IndexOutOfBoundsException e) {
            
            this.proxCaractere = Constantes.EOF;
        }
    }    

/**
    * Determina se o proximo caracter lido e 
    * @author 
    * @param s : string contendo os caracteres que deseja verificar
    * @return true se o proximo caracter e uma substring de s
    */
    public boolean proxCaractereIs(String s)
    {
        return ( s.indexOf(this.proxCaractere) != -1 );       
    }
    
}
