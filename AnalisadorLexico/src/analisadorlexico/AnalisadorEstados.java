package analisadorlexico;

public class AnalisadorEstados extends AnalisadorLexico 
{
    
    // Contrutor 
    public AnalisadorEstados( String nome )
    {
        super(nome);
    }
    
    
    // Estados
    public void q0(){
        
        if(this.proxCaractere == 'w'){
            leProxCaractere();
            q1();
        }
        else if(this.proxCaractere == 'i'){
            leProxCaractere();
            q6();
        }        
        else if(this.proxCaractere == 'f'){
            leProxCaractere();
            q8();
        }       
        else if(this.proxCaractere == 'd'){
            leProxCaractere();
            q11();
        }        
        else if(this.proxCaractere == 's'){
            leProxCaractere();
            q13();
        }        
        else if(this.proxCaractere == 'c'){
            leProxCaractere();
            q19();
        }        
        else if(this.proxCaractereIs(LETRA) && !this.proxCaractereIs(DIGITO) && this.proxCaractere != 'w' && this.proxCaractere != 'i' && this.proxCaractere != 'f' && this.proxCaractere != 'd' && this.proxCaractere != 's' && this.proxCaractere != 'c'){
            leProxCaractere();
            v0();
        }
    }

    public void q1(){
        if(this.proxCaractere == 'h'){
            leProxCaractere();
            q2();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'h'){
            leProxCaractere();
            v0();
        }
    }
    public void q2(){
            if(this.proxCaractere == 'i'){
            leProxCaractere();
            q3();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'i'){
            leProxCaractere();
            v0();
        }
    }
    public void q3(){
            if(this.proxCaractere == 'l'){
            leProxCaractere();
            q4();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'e'){
            leProxCaractere();
            v0();
        }
    }
    public void q4(){
        if(this.proxCaractere == 'e'){
            leProxCaractere();
            q5();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'e'){
            leProxCaractere();
            v0();
        }
    }
    public void q5(){
        this.tokenReconhecido = Token.WHILE;
        if(proxCaractereIs(LETRA)){
            leProxCaractere();
            v0();
        }
        System.out.println(proxCaractereIs(LETRA));
    }
    public void q6(){
        if(this.proxCaractere == 'f'){
            leProxCaractere();
            q7();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'f'){
            leProxCaractere();
            v0();
        }
    }
    public void q7(){
        this.tokenReconhecido = Token.IF;
        if(proxCaractereIs(LETRA)){
            leProxCaractere();
            v0();
        }
    }
    public void q8(){
        if(this.proxCaractere == 'o'){
            leProxCaractere();
            q9();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'o'){
            leProxCaractere();
            v0();
        }    
    }
    public void q9(){
        if(this.proxCaractere == 'r'){
            leProxCaractere();
            q5();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'r'){
            leProxCaractere();
            v0();
        }  
    }
    public void q10(){
        this.tokenReconhecido = Token.FOR;
        if(proxCaractereIs(LETRA)){
            leProxCaractere();
            v0();
        }   
    }
    public void q11(){
        if(this.proxCaractere == 'o'){
            leProxCaractere();
            q12();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'o'){
            leProxCaractere();
            v0();
        }
    }
    public void q12(){
        this.tokenReconhecido = Token.DO;
        if(proxCaractereIs(LETRA)){
            leProxCaractere();
            v0();
        }
    }
    public void q13(){
        if(this.proxCaractere == 'w'){
            leProxCaractere();
            q14();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'w'){
            leProxCaractere();
            v0();
        }
    }
    public void q14(){
        if(this.proxCaractere == 'i'){
            leProxCaractere();
            q15();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'i'){
            leProxCaractere();
            v0();
        }
    }
    public void q15(){
        if(this.proxCaractere == 't'){
            leProxCaractere();
            q16();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 't'){
            leProxCaractere();
            v0();
        }
    }
    public void q16(){
        if(this.proxCaractere == 'c'){
            leProxCaractere();
            q17();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'c'){
            leProxCaractere();
            v0();
        }
    }
    public void q17(){
        if(this.proxCaractere == 'h'){
            leProxCaractere();
            q18();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'h'){
            leProxCaractere();
            v0();
        }
    }
    public void q18(){
        this.tokenReconhecido = Token.SWITCH;
        if(proxCaractereIs(LETRA)){
            leProxCaractere();
            v0();
        }
    }
    public void q19(){
        if(this.proxCaractere == 'a'){
            leProxCaractere();
            q20();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 'a'){
            leProxCaractere();
            v0();
        }
    }   
    public void q20(){
        if(this.proxCaractere == 's'){
            leProxCaractere();
            q21();
        }
        else if(proxCaractereIs(LETRA) && this.proxCaractere != 's'){
            leProxCaractere();
            v0();
        }
    }
    public void q21(){
        if(this.proxCaractere == 'e'){
            leProxCaractere();
            q22();
        }
        else if(proxCaractereIs(LETRA   ) && this.proxCaractere != 'e'){
            leProxCaractere();
            v0();
        }
    }
    public void q22(){
        this.tokenReconhecido = Token.CASE;
        if(proxCaractereIs(LETRA)){
            leProxCaractere();
            v0();
        }
    }
     
    public void v0(){
        this.tokenReconhecido = Token.VARIAVEL;
        if(this.proxCaractereIs(LETRA)){
            leProxCaractere();
            v0();
        }
    }
}
