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
public class Player {
    public Baraja mano;
    public int dinero;
    public int valor_apostao;

    public Player(int dinero) {
        this.dinero = dinero;
        this.mano = new Baraja();
        this.valor_apostao = 0;
    }

    
}
