/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorlexico;

/**
 *
 * @author elly
 */
public abstract class Analisador implements Constantes 
{
    protected String nomeArquivoEntrada;
    
    public​ Analisador( String nomeArquivoEntrada ) 
    {
        this.nomeArquivoEntrada = nomeArquivoEntrada;
    }
    
    public​ Analisador() 
    {
        this.nomeArquivoEntrada = NOME_DEFAULT_ARQUIVO_ENTRADA;
    }
    
    
    
}
