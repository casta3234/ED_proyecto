/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Juego {
    //esto no esta acabado es programar el trascurso del juego     
    public static void main(String[] args){ 
        Table mesa = new Table();
        Scanner s = new Scanner(System.in);        
        while(mesa.getPlayer1().dinero > 0 && mesa.getPlayer2().dinero > 0){
            int ronda = 0;
            int jugada_p1 = 0;
            int jugada_p2 = 0;
            mesa.nueva_partida();
            while(ronda < 3){
                if (ronda == 0) {
                    
                    mesa.Dar_carta_p1();
                    mesa.Dar_carta_p1();
                    
                    mesa.Dar_carta_p2();
                    mesa.Dar_carta_p2();
                    //no se por que esto de igualar va aca
                    mesa.p1_igualar();
                    mesa.p2_igualar();
                    
                    mesa.añadir_carta_camunitaria();
                    mesa.añadir_carta_camunitaria();
                    mesa.añadir_carta_camunitaria(); 
                    
                mesa.preguntar1();
                int N1 = s.nextInt();
                s.nextLine();
                mesa.accionp1(N1);
                
                mesa.preguntar2();
                int N2 = s.nextInt();
                s.nextLine();
                mesa.accionp2(N2);
                }

                if(ronda == 1 || ronda == 2){
                    
                mesa.añadir_carta_camunitaria();
                mesa.preguntar1();
                int N1 = s.nextInt();
                s.nextLine();
                mesa.accionp1(N1);
                
                mesa.preguntar2();
                int N2 = s.nextInt();
                s.nextLine();
                mesa.accionp2(N2);
                }
                ronda++;
            }
            mesa.compare();
            System.out.println("Nuevo Juego");
            System.out.println("***********");
        }
    }
}
