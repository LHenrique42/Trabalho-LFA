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
        
        if( this.proxCaractere == 32)
        {
            this.tokenReconhecido = Token.ESPACO;
            leProxCaractere();
            ///System.out.println(this.proxCaractere);
        } 
        else if( proxCaractereIs(SEPARADOR))
        {
            this.tokenReconhecido = Token.SEPARADOR;
            leProxCaractere();
        }
        else if( this.proxCaractere == EOF )
        {
            this.tokenReconhecido = Token.EOF;
            leProxCaractere();
            f();
        }
        else if(this.proxCaractere == 'w'){
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
        else if( this.proxCaractere == '(' )
        {
            leProxCaractere();
            ap0();
        }
        else if( this.proxCaractere == ')' )
        {
            leProxCaractere();
            fp0();
        }
        else if( this.proxCaractere == '{' )
        {
            leProxCaractere();
            ach0();
        }
        else if( this.proxCaractere == '}' )
        {
            leProxCaractere();
            fch0();
        }
        else if( this.proxCaractere == ':' )
        {
            leProxCaractere();
            dp0();
        }
        else if( this.proxCaractere == ';' )
        {
            leProxCaractere();
            pt0();
        }
        else if( this.proxCaractere == '+' )
        {  
            leProxCaractere();
            op0();
        }
        else if( this.proxCaractere == '-' )
        {
            leProxCaractere();
            op1();
        }
        else if( this.proxCaractere == '*' || this.proxCaractere == '/' || this.proxCaractere == '%' )
        {
            leProxCaractere();
            op4();
        }
        else if( this.proxCaractere == '|' )
        {
            leProxCaractere();
            op3();
        }
        else if( this.proxCaractere == '-' )
        {
            leProxCaractere();
            op1();
        }
        else if( this.proxCaractere == '>' )
        {
            leProxCaractere();
            opb1();
        }
        else if( this.proxCaractere == '<' )
        {
            leProxCaractere();
            opb2();
        }
        else if( this.proxCaractere == '=' )
        {
            leProxCaractere();
            ig0();
        }
         else if( this.proxCaractere == '&' )
        {
            leProxCaractere();
            op2();
        }
        else if( this.proxCaractere == '!' )
        {
            leProxCaractere();
            neg0();
        }
        //ta errado -> nao sei fazer aspas simples entre aspas simples
        else if( this.proxCaractere == 39 )
        {
            leProxCaractere();
            crt0();
        }
        else if( proxCaractereIs(DIGITO) )
        {
            leProxCaractere();
            n0();
        }
        else if( this.proxCaractere == '.' )
        {
            leProxCaractere();
            n1();
        }
        else if(this.proxCaractereIs(LETRA) && !this.proxCaractereIs(DIGITO) && this.proxCaractere != 'w' && this.proxCaractere != 'i' && this.proxCaractere != 'f' && this.proxCaractere != 'd' && this.proxCaractere != 's' && this.proxCaractere != 'c'){
            leProxCaractere();
            v0();
        }
        else {
            System.out.println("Entrada não reconhecida");
            throw(new ErroLexico(this.proxCaractere,ALFABETO));
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
    }
    
    public void f()
    {
        this.tokenReconhecido = Token.EOF;
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
            q10();
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
        this.tokenReconhecido = Token.VARIAVEL;
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
        if(proxCaractereIs(ALFA)){
            leProxCaractere();
            v0();
        }
 
    }
    public void ach0(){
        this.tokenReconhecido = Token.ACH;
    }
    public void fch0(){
        this.tokenReconhecido = Token.FCH;
    }
    public void n0(){
        this.tokenReconhecido = Token.NUMERO;
        if (this.proxCaractere == '.'){
            leProxCaractere();
            n1();
        }
        else if (this.proxCaractereIs(DIGITO)){
            leProxCaractere();
            n0();
        }
    }
    public void n1(){
        if (proxCaractereIs(DIGITO)){
            leProxCaractere();
            n2();
        }
        else{
            System.out.println("Entrada não reconhecida");
            throw(new ErroLexico(this.proxCaractere,DIGITO));
        }
    }
    public void n2(){
        this.tokenReconhecido = Token.NUMERO;
        if (proxCaractereIs(DIGITO)){
            leProxCaractere();
            n2();
        }
    }
    public void dp0(){
        this.tokenReconhecido = Token.DPT;
    }
    public void pt0(){
        this.tokenReconhecido = Token.PTV;
//        leProxCaractere();
    }
    
    public void ap0()
    {
        this.tokenReconhecido = Token.AP;
//        leProxCaractere();
        /*
        if(!proxCaractereIs(ALFABETO)){
            System.out.println("Entrada não reconhecida");
            throw(new ErroLexico(this.proxCaractere,ALFABETO));
        }*/
    }
    
    
    
    public void op0(){
        this.tokenReconhecido = Token.OP_UN_BIN;
        if(this.proxCaractere == '+'){
            leProxCaractere();
            opu0();
        }
        else if(this.proxCaractere == '='){
            leProxCaractere();
            att0(); 
        }
        
    }
    
    public void op1(){
        this.tokenReconhecido = Token.OP_UN_BIN;
        if(this.proxCaractere == '-'){
            leProxCaractere();
            opu0();
        }
        else if(this.proxCaractere == '='){
            leProxCaractere();
            att0();
        }
    }
    public void op2(){
        this.tokenReconhecido = Token.OP_BINARIO;
        if(this.proxCaractere == '&'){
            leProxCaractere();
            opb0();
        }
        else if(this.proxCaractere == '='){
            leProxCaractere();
            att0();
        }
    }
    public void op3(){
        this.tokenReconhecido = Token.OP_BINARIO;
        if(this.proxCaractere == '|'){
            leProxCaractere();
            opb0();
        }
        else if(this.proxCaractere == '='){
            leProxCaractere();
            att0();
        }
    }
    public void op4(){
        this.tokenReconhecido = Token.IGUALDADE;
        if(this.proxCaractere == '='){
            leProxCaractere();
            att0();
        }
    }
    public void opb1(){
        this.tokenReconhecido = Token.OP_BINARIO;
        if(this.proxCaractere == '=' || this.proxCaractere == '>'){
            leProxCaractere();
            opb0();
        }
    }
    public void opb2(){
        this.tokenReconhecido = Token.OP_BINARIO;
        if(this.proxCaractere == '=' || this.proxCaractere == '<'){
            leProxCaractere();
            opb0();
        }
    }
    public void ig0(){
        this.tokenReconhecido = Token.IGUALDADE;
        if(this.proxCaractere == '='){
            leProxCaractere();
            opb0();
        }
    }
    public void neg0(){
        this.tokenReconhecido = Token.NEGACAO;
        if(this.proxCaractere == '='){
            leProxCaractere();
            opb0();
        }
    }
    public void crt0(){
        if(proxCaractereIs(ALFABETO)){
            leProxCaractere();
            crt1();
        }else{
            System.out.println("Entrada não reconhecida");
            throw(new ErroLexico(this.proxCaractere,ALFABETO));
        }
    }
    public void crt1(){
        if(this.proxCaractere == 39){
            leProxCaractere();
            crt2();
        }else{
            System.out.println("Entrada não reconhecida");
            throw(new ErroLexico(this.proxCaractere,"'"));
        }
    }
    public void crt2()
    {
        this.tokenReconhecido = Token.CARACTERE;
//        leProxCaractere();
    }
    
    public void opu0()
    {
        this.tokenReconhecido = Token.OP_UNARIO;
    }
    public void att0()
    {
        this.tokenReconhecido = Token.IGUALDADE;
    }
    public void opb0()
    {
        this.tokenReconhecido = Token.OP_BINARIO;
    }
    
    public void fp0()
    {
        this.tokenReconhecido = Token.FP;
    }

    public void v0(){
        this.tokenReconhecido = Token.VARIAVEL;
        if(this.proxCaractereIs(LETRA)){
            leProxCaractere();
            v0();
        }
    }
   
}
