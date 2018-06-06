/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;

public class ArbolPoker
{
    private NodoPoker root;

    public void colocar( String key, int value )
    {
        if ( root == null )
        {
            root = new NodoPoker( key, value );
        }
        else
        {
            root.colocar( key, value );
        }
    }

    public Object recuperar( String key )
    {
        return root == null ? null : root.recuperar( key );
    }
}

