package analisadorlexico;

/**
 *  Classe de erros lexicos em tempo de execuçao
 * @author elly
 */
public class ErroLexico extends RuntimeException 
{
    private char simboloEncontrado;
    private String simbolosEsperados;
    
    
    
    /**
     *  Classe de erros lexicos em tempo de execuçao
     * @author elly
     */
    public ErroLexico( char simboloEncontrado, String simbolosEsperados )
    {
        this.simboloEncontrado = simboloEncontrado;
        this.simbolosEsperados = simbolosEsperados;
    }
    
    
    /**
     *  Escreve no console os tokens esperados e a ultima classificaçao antes do erro
     * @author elly
     */
    public String toString()
    {
        if(this.simbolosEsperados != null){
        return "Simbolo encontrado: " + (char)this.simboloEncontrado + 
                "\n era(m) esperado(s):" + this.simbolosEsperados ;
        }
        return "";
    }
    
}
