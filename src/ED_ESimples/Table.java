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
public class Table {
    private Player player1,player2;
    private Baraja baraja;
    private Baraja cartas_comunitarias;
    private int apuesta;
    private ArbolPoker puntaje;
    Scanner s = new Scanner(System.in); 
    
    public Table() {
        this.player1 = new Player(1000);
        this.player2 = new Player(1000);
        this.baraja = new Baraja();
        this.cartas_comunitarias = new Baraja();
        this.apuesta = 10;
  
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
       
    
    
    public void Dar_carta_p1(){
        Card aux = this.baraja.gift_card();
        this.player1.mano.add_to_the_beginning(aux.getPinta(), aux.getValor());
    }
    
    public void Dar_carta_p2(){
        Card aux = this.baraja.gift_card();
        this.player2.mano.add_to_the_beginning(aux.getPinta(), aux.getValor());
    }
    
    public void añadir_carta_camunitaria(){
        Card aux = this.baraja.gift_card();
        this.cartas_comunitarias.add_to_the_beginning(aux.getPinta(), aux.getValor());
    }
    public void preguntar1(){
                System.out.println("Que jugada desea hacer Jugador 1");
                System.out.println("1:igualar 2:subir 3:pasar");
    }
    public void accionp1(int numaccion){
        if(numaccion == 1){
             if(player1.dinero < this.apuesta){ 
                System.out.println("No puede igualar esta cantidad, Se va ALL-IN");
                player1.valor_apostao = player1.valor_apostao + player1.dinero;
                player1.dinero = 0;
            }
             else{
                           p1_igualar(); 
             }  
        }
         if(numaccion == 2){
            System.out.println("Ingrese el valor a Subir");
            int valorasubir = s.nextInt();
            s.nextLine();
            if(valorasubir > player1.dinero){
                System.out.println("No tiene suficiente dinero para subir esta cantidad, se ingresa lo que le alcanza");
                player1.valor_apostao = player1.valor_apostao + player1.dinero;
                p1_subir(player1.dinero);
            }
            else{
                p1_subir(valorasubir);
            }
        }
        if(numaccion == 3){ 
            System.out.println("Ha pasado su turno");
        }
    }
    
    public void p1_igualar(){
        int diferencia = this.apuesta - this.player1.valor_apostao;
        this.player1.valor_apostao += diferencia;
        this.player1.dinero -= diferencia;
        this.apuesta += diferencia;        
    }
    
    public void p1_subir(int aumento){
        int diferencia = this.apuesta + aumento - this.player1.valor_apostao;
        this.player1.valor_apostao += diferencia;
        this.player1.dinero -= diferencia;
        this.apuesta += diferencia;
    }
    
    public void preguntar2(){
                System.out.println("Que jugada desea hacer Jugador 2");
                System.out.println("1:igualar 2:subir 3:pasar");
    }
    
    public void accionp2(int numaccion){
        if(numaccion == 1){
             if(player2.dinero < this.apuesta){ 
                System.out.println("No puede igualar esta cantidad, Se va ALL-IN");
                player2.valor_apostao = player2.valor_apostao + player2.dinero;
                player2.dinero = 0;
            }
             else{
                           p2_igualar(); 
             }  
        }
         if(numaccion == 2){
            System.out.println("Ingrese el valor a Subir");
            int valorasubir = s.nextInt();
            s.nextLine();
            if(valorasubir > player2.dinero){
                System.out.println("No tiene suficiente dinero para subir esta cantidad, se ingresa lo que le alcanza");
                p2_subir(player2.dinero);
            }
            else{
                p2_subir(valorasubir);
            }
        }
        if(numaccion == 3){ 
            System.out.println("Ha pasado su turno");
        }
    }
    
    public void p2_igualar(){
        int diferencia = this.apuesta - this.player2.valor_apostao;
        this.player2.valor_apostao += diferencia;
        this.player2.dinero -= diferencia;
        this.apuesta += diferencia;        
    }
    
    public void p2_subir(int aumento){
        int diferencia = this.apuesta + aumento - this.player2.valor_apostao;
        this.player2.valor_apostao += diferencia;
        this.player2.dinero -= diferencia;
        this.apuesta += diferencia;
    }
    
    public void nueva_partida(){
        this.baraja = new Baraja();
        this.puntaje = new ArbolPoker();
        this.baraja.llenado_estandar("corazon", "pica", "trebol", "diamante");
        this.baraja.randomize();
        this.baraja.randomize();
        
        this.puntaje.colocar("CartaAlta", 1);
        this.puntaje.colocar("Par", 2);
        this.puntaje.colocar("DoblePar", 3);
        this.puntaje.colocar("Trio", 4);
        this.puntaje.colocar("Escalera", 5);
        this.puntaje.colocar("Color", 6);
        this.puntaje.colocar("Full", 7);
        this.puntaje.colocar("Poker", 8);
        this.puntaje.colocar("EscaleraColor", 9);
        this.puntaje.colocar("EscaleraReal", 10);
        
        this.cartas_comunitarias = new Baraja();
        
        this.player1.mano = new Baraja();
        this.player1.valor_apostao = 0;
        
        this.player2.mano = new Baraja();
        this.player2.valor_apostao = 0;
    }
    
   public String identifyp1(){
   Card carta1 = player1.mano.get_Card(1);
   Card carta2 = player1.mano.get_Card(2);
   int numero = carta1.getValor();
   String family = carta1.getPinta();
   //Aqui se hace la comparacion para saber que tipo de resultado obtuvimos, pero pues no se bien como hacerla
   if{
       
   }
   //resultado es un string que nos sale del if cuando lo identificamos, por ejemplo resultado = "Escalera";
   return resultado;
   }
  
   public String identifyp2(){
   Card carta1 = player2.mano.get_Card(1);
   Card carta2 = player2.mano.get_Card(2);
   int numero = carta1.getValor();
   String family = carta1.getPinta();
   //Aqui se hace la comparacion para saber que tipo de resultado obtuvimos, pero pues no se bien como hacerla
   if{
       
   }
   //resultado es un string que nos sale del if cuando lo identificamos, por ejemplo resultado = "Escalera";
   return resultado;
   }
   public void compare(){
      int valorp1 = (int) this.puntaje.recuperar(identifyp1());
      int valorp2 = (int) this.puntaje.recuperar(identifyp2());
      
      if(valorp1 > valorp2){
          System.out.println("Gana Jugador 1, su combinacion de cartas fue: " + identifyp1());
          player1.dinero = player1.dinero + this.apuesta;
      }
      if(valorp1 < valorp2){
          System.out.println("Gana Jugador 2, su combinacion de cartas fue: " + identifyp2());
          player1.dinero = player1.dinero + this.apuesta;
      }
   }
   
}
