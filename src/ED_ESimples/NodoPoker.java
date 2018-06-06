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
public class NodoPoker {
    
    private String key;
    private int value;
    private NodoPoker left, right;

    public NodoPoker( String key, int value )
    {
        this.key = key;
        this.value = value;
    }
    //pone el valor en el arbol
    public void colocar( String key, int value )
    {
        if ( key.compareTo( this.key ) < 0 )         
        {             
            if ( left != null )             
            {                 
                left.colocar( key, value );             
            }             
            else             
            {                 
                left = new NodoPoker( key, value );             
            }         
        }         
        else if ( key.compareTo( this.key ) > 0 )
        {
            if ( right != null )
            {
                right.colocar( key, value );
            }
            else
            {
                right = new NodoPoker( key, value );
            }
        }
        else
        {
            this.value = value;
        }
    }

    //Recoge el valor del arbol 
    public int recuperar( String key )
    {
        if ( this.key.equals( key ) )
        {
            return value;
        }

        if ( key.compareTo( this.key ) < 0 )
        {
            return left == null ? null : left.recuperar( key );
        }
        else
        {
            return right == null ? null : right.recuperar( key );
        }
    }
}

