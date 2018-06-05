/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;

/**
 *
 * @author USUARIO
 */
public class Juego {
    //esto no esta acabado es programar el trascurso del juego     
    public static void main(String[] args){ 
        Table mesa = new Table();        
        while(mesa.getPlayer1().dinero > 0 && mesa.getPlayer2().dinero > 0){
            int ronda = 0;
            int jugda1_p1 = 0;
            int jugada_p2 = 0;
            mesa.nueva_partida();
            while(ronda < 3){
                if (ronda == 0) {
                    
                    mesa.Dar_carta_p1();
                    mesa.Dar_carta_p1();
                    
                    mesa.Dar_carta_p2();
                    mesa.Dar_carta_p2();
                    
                    mesa.p1_igualar();
                    mesa.p2_igualar();
                    
                    mesa.añadir_carta_camunitaria();
                    mesa.añadir_carta_camunitaria();                                        
                }
                mesa.añadir_carta_camunitaria();
                System.out.println("que jugada desea hacer");
                System.out.println("1:igualar 2:subir 3:pasar");
                
            }
        }
    }
}
