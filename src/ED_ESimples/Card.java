/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;


/**
 *
 * @author Sebastian
 */
public class Card {

    private String pinta;
    private int valor;
    private Card next = null;

    public Card() {
        
    }

    public Card(String pinta, int valor) {
        this.pinta = pinta;
        this.valor = valor;
    }

    public Card get_next() {
        return next;
    }

    public void set_next(Card next) {
        this.next = next;
    }       
    
    public String getPinta() {
        return pinta;
    }

    public void setPinta(String pinta) {
        this.pinta = pinta;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        if (this.valor == 1){
            return "A " + this.pinta + "\n";
        }
        else{
            if (this.valor == 11) {
                return "J " + this.pinta + "\n";
            }
            else {
                if (this.valor == 12) {
                    return "Q " + this.pinta + "\n";
                }
                else {
                    if (this.valor == 13) {
                        return "K " + this.pinta + "\n";
                    }
                    else{
                        return this.valor + " " + this.pinta + "\n";
                    }
                }
            }
        }        
    }    
}

