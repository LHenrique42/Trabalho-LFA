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
public class ErroLexico extends RuntimeException 
{
    private char simboloEncontrado;
    private String simbolosEsperados;
    
    public ErroLexico( char simboloEncontrado, String simbolosEsperados )
    {
        this.simboloEncontrado = simboloEncontrado;
        this.simbolosEsperados = this.simbolosEsperados;
    }
    
    public String toString()
    {
        return "Simbolo encontrado: " + (char)this.simboloEncontrado + 
                "\n era(m) esperado(s):" + this.simbolosEsperados;
    }
    
}
