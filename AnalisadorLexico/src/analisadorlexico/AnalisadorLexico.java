
package analisadorlexico;

import java.io.FileReader;
import java.io.IOException;

public class AnalisadorLexico extends Analisador 
{

    protected char proxCaractere;
    protected int linha = 1;
    protected Token tokenReconhecido;
    protected int posicao = 0;
    protected StringBuffer entrada = new StringBuffer();
    
            

    public AnalisadorLexico( String nome )
    {
        super( nome );
        try {
             FileReader arq = new FileReader( nome );
             int c;
             while( (c = arq.read() ) != -1 )
             {
                // mostra leitura arquivo caractere por caractere
                System.out.println("" + (char)c);
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
    
////Implementar função para ler o próximo caractere
    public void leProxCaractere()
    {
        try {
            this.proxCaractere = this.entrada.charAt(this.posicao++);
        } catch (IndexOutOfBoundsException e) {
            
            this.proxCaractere = Constantes.EOF;
        }
    }    

////Implementar função para dizer qual o caractere lido    
    public boolean proxCaractereIs(String s)
    {
        return ( s.indexOf(this.proxCaractere) != -1 );       
    }
    
}
