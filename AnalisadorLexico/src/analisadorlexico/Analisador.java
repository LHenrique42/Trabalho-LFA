/*
 Classe analisador responsavel por abrir arquivo instanciando 
 */
package analisadorlexico;

/**
 *
 * @author elly
 */
public abstract class Analisador implements Constantes 
{
    protected String nomeArquivoEntrada;
   
    /**
    * Instancia analisador com o nome de arquivo informado
    * @author 
    * @param nomeArquivoEntrada nome ou diretorio do arquivo a ser analisado
    */
    
    public​ Analisador( String nomeArquivoEntrada ) 
    {
        this.nomeArquivoEntrada = nomeArquivoEntrada;
    }
    
    public​ Analisador() 
    {
        this.nomeArquivoEntrada = NOME_DEFAULT_ARQUIVO_ENTRADA;
    }
    
    
    
}
