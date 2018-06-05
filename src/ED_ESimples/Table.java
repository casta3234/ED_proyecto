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
public class Table {
    private Player player1,player2;
    private Baraja baraja;
    private Baraja cartas_comunitarias;
    private int apuesta;

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
        this.baraja.llenado_estandar("corazon", "pica", "trebol", "diamante");
        this.baraja.randomize();
        this.baraja.randomize();
        
        this.cartas_comunitarias = new Baraja();
        
        this.player1.mano = new Baraja();
        this.player1.valor_apostao = 0;
        
        this.player2.mano = new Baraja();
        this.player2.valor_apostao = 0;
    }
}
