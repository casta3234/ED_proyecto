/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Sebastian
 */
public class Baraja {
    
    private Card head = null;

    public boolean empty(){
        return this.head == null; 
        
    }
    
    public int getSize(){
        int i = 0;
        Card temp = this.head;
        while(temp != null){
            i++;
            temp = temp.get_next();
        }
        return i;
    }
    
    public void add_to_the_beginning(String pinta,int valor){
        Card newNodo = new Card(pinta, valor);
        newNodo.set_next(this.head);
        this.head = newNodo;
    }
    
    public void add_to_the_end(String pinta,int valor){
        Card newNodo = new Card(pinta, valor);
        if (empty()){
            this.head = newNodo;
        }
        else{
            Card temp = this.head;
            while(temp.get_next() != null){
                temp = temp.get_next();         
            }
            temp.set_next(newNodo);
        }        
    }
    
    public void add_in_the_position(String pinta,int valor, int position){
        Card newNodo = new Card(pinta, valor);
        Card temp = this.head;
        for(int i = 0; i < position-1; i++ ){
            temp = temp.get_next();
        }
        newNodo.set_next(temp.get_next()); 
        temp.set_next(newNodo);
    }
       
    public void delete_to_the_beginning(){
        Card temp = this.head;
        this.head = this.head.get_next();
        temp = null;
        System.gc();
    }
    
    public void delete_to_the_end(){
        
        Card pre = this.head;
        Card temp = this.head.get_next().get_next();
        while (temp != null){            
            pre = pre.get_next();
            temp = temp.get_next();
        }        
        pre.set_next(null);
        System.gc();
    }
    
    public void delete_the_position(int posicion){
        Card temp = this.head;
        Card eliminado;
        for(int i = 0; i < posicion-1; i++){
            temp = temp.get_next();
        }
        eliminado = temp.get_next();
        temp.set_next(temp.get_next().get_next()); 
        eliminado = null;        
        System.gc();
    }
    
//    public void inverse(){
//        Stack ptemp = new Stack();
//        Node temp = this.head;
//        
//        while(temp != null){
//            ptemp.push(temp.clone());
//            temp = temp.get_next();
//        }
//        
//        this.head = ptemp.peek();
//    }
    
    public int getIndex(String pinta,int valor){
        Card temp = this.head;
        int index = 0;        
        do {
            if (temp.getPinta().equals(pinta) && temp.getValor() == valor) {
                break;
            }            
                temp = temp.get_next();
                index++;            
        }
        while (index < getSize());
        
        if(index == this.getSize()){
            return -1;
        }
        else{
            return index;
        }
    }    
    
    public Card get_Card(int index){
        Card temp = this.head;
        if(index < getSize()){
            if (index > 0){
                for(int i = 0; i < index; i++){
                    temp = temp.get_next();
                }
                return new Card(temp.getPinta(), temp.getValor());
            }
            else
                return new Card(temp.getPinta(), temp.getValor());
        }
        else
            return null;
    }
    
    public void print(){
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Card temp = this.head;
        try{
            while(temp != null){
                bw.write(temp.toString());
                temp = temp.get_next();
            }
            bw.flush();
        }
        catch(IOException ex){
        }
    }
    
    public Card gift_card(){
        
        Card temp = this.head;
        this.head = this.head.get_next();
        System.gc();
        return new Card(temp.getPinta(), temp.getValor());
    }
    
    public void llenado_estandar(String pinta1,String pinta2,String pinta3,String pinta4){
        for(int i = 1;i <= 13;i++){
            this.add_to_the_beginning(pinta1, i);
        }
        for(int i = 1;i <= 13;i++){
            this.add_to_the_beginning(pinta2, i);
        }
        for(int i = 1;i <= 13;i++){
            this.add_to_the_beginning(pinta3, i);
        }
        for(int i = 1;i <= 13;i++){
            this.add_to_the_beginning(pinta4, i);
        }
    }
    
    public void mover_n(int n){
        Baraja aux = new Baraja();
        Card temp = this.head;
        for (int i = 0; i < n % this.getSize(); i++) {
            aux.add_to_the_end(temp.getPinta(), temp.getValor());
            temp = temp.get_next();
        }
        this.head = temp;
        while (!aux.empty()) {
            Card card_aux = aux.gift_card();
            this.add_to_the_end(card_aux.getPinta(), card_aux.getValor());
        }
    }
    
    public void intercalar(){
        Baraja mitad1 = new Baraja();
        Baraja mitad2 = new Baraja();
        for (int i = 0; i < this.getSize(); i++) {
            if (i < this.getSize()/2){
                mitad1.add_to_the_beginning(this.get_Card(i).getPinta(),this.get_Card(i).getValor());
            }
            else{
                mitad2.add_to_the_beginning(this.get_Card(i).getPinta(),this.get_Card(i).getValor());
            }
        }
                
        this.head = null;
        
        while(!mitad1.empty() && !mitad2.empty() ){
            Card card_mitad1 = mitad1.gift_card();
            this.add_to_the_beginning(card_mitad1.getPinta(), card_mitad1.getValor());
            Card card_mitad2 = mitad2.gift_card();
            this.add_to_the_beginning(card_mitad2.getPinta(), card_mitad2.getValor());
        }
        if (!mitad2.empty()) {
            Card card_mitad2 = mitad2.gift_card();
            this.add_to_the_beginning(card_mitad2.getPinta(), card_mitad2.getValor());
        }        
    }
}
