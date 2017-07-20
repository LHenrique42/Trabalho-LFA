package analisadorlexico;

/**
 *  Classe de erros lexicos em tempo de execuçao
 * @author elly
 */
public class ErroLexico extends RuntimeException 
{
    private char simboloEncontrado;
    private String simbolosEsperados;
    private int linha;
    
    
    /**
     *  Classe de erros lexicos em tempo de execuçao
     * @author elly
     */
    public ErroLexico( char simboloEncontrado, String simbolosEsperados, int linha )
    {
        this.simboloEncontrado = simboloEncontrado;
        this.simbolosEsperados = simbolosEsperados;
        this.linha = linha;
    }
    
    
    /**
     *  Escreve no console os tokens esperados e a ultima classificaçao antes do erro
     * @author elly
     */
    public String toString()
    {
        if(this.simbolosEsperados != null){
        return "Simbolo encontrado: " + (char)this.simboloEncontrado + 
                "\n era(m) esperado(s):" + this.simbolosEsperados + " na linha : " + this.linha ;
                
        }
        return "";
    }
    
}
