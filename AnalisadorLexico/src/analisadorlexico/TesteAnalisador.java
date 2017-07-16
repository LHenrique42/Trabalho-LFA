//
//package analisadorlexico;
//
//
//public class TesteAnalisador 
//{
//    static public AnalisadorEstados scanner;
//    public static void main(String[] args) 
//    {
//        try 
//        {
//            // TEMPORARIA: Modificaçao para nao ter que passar nome do arquivo pelo terminal
//            if ( args.length != 1 )
//            {
////                throw new RuntimeException("Nome do arquivo obrigatorio");
//                scanner = new AnalisadorEstados( "entrada.txt" );
//            }  else
//                scanner = new AnalisadorEstados( args[0] );    
//            
//            do
//            {
//                scanner.q0();
//                if (scanner.tokenReconhecido != null)
//                    System.out.println( scanner.tokenReconhecido );
//            } while( scanner.tokenReconhecido != Constantes.Token.EOF);
//                    
//            System.out.println("Sucesso! :D");
//            
//        } catch (ErroLexico e) {
//            System.out.println("Erro lexico: " + e.toString() );
//        } catch (RuntimeException e) {
//            System.out.println("Erro lexico2: " + e.getMessage() );
//        }
//
//        
//    }
//}
