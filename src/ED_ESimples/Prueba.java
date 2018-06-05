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
public class Prueba {
    public static void main(String[] args) {
        Baraja b = new Baraja();
        Player player1 = new Player(1000000);
        b.llenado_estandar("corazon", "pica", "trebol", "diamante");
//        b.print();
//        System.out.println(b.getSize());
//        System.out.println("**************************");
        b.randomize();
//        b.print();
//        System.out.println(b.getSize());        
       Card aux = b.gift_card();
       player1.mano.add_to_the_beginning(aux.getPinta(),aux.getValor());
       Card aux2 = b.gift_card();
       player1.mano.add_to_the_beginning(aux2.getPinta(),aux2.getValor());
       player1.mano.print();

   }    
}
