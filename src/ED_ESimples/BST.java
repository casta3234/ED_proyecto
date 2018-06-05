/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;

public class BST
{
    private BSTNode root;

    public void put( String key, int value )
    {
        if ( root == null )
        {
            root = new BSTNode( key, value );
        }
        else
        {
            root.put( key, value );
        }
    }

    public Object get( String key )
    {
        return root == null ? null : root.get( key );
    }
}

