///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package analisadorsintatico;
//
//import analisadorlexico.ErroLexico;
//
///**
// *
// * @author elly
// */
//public class ParserApp 
//{
//    static public AnalisadorGramatica parser;
//    
//    
//    public static void main(String[] args) 
//    {
//
//        try 
//        {
//            // TEMPORARIA: Modificaçao para nao ter que passar nome do arquivo pelo terminal
//            if ( args.length != 1 )
//            {
////                throw new RuntimeException("Nome do arquivo obrigatorio");
//                parser = new AnalisadorGramatica( "entrada.txt" );
//            }  else
//                parser = new AnalisadorGramatica( args[0] );    
//          
//            parser.programa();
//            System.out.println("Sucesso: Sintaxe aceita ! :D");
//            
//        } catch (ErroLexico e) {
//            System.out.println("Erro lexico: " + e.toString() );
//        } catch (ErroSintatico e) {
//            System.out.println("Erro sintatico: " + e.toString() );
//        } catch (RuntimeException e) {
//            System.out.println( e.getMessage() );
//        }
//
//    }
//}
