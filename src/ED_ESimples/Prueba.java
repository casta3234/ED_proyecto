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
        b.llenado_estandar("corazon", "pica", "trebol", "diamante");
        b.print();
        System.out.println(b.getSize());
        System.out.println("**************************");
        b.randomize();
        b.print();
        System.out.println(b.getSize());
   }    
}
