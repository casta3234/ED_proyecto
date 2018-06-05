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

class BSTNode
{
    private String key;
    private int value;
    private BSTNode left, right;

    public BSTNode( String key, int value )
    {
        this.key = key;
        this.value = value;
    }
    //pone el valor en el arbol
    public void put( String key, int value )
    {
        if ( key.compareTo( this.key ) < 0 )         
        {             
            if ( left != null )             
            {                 
                left.put( key, value );             
            }             
            else             
            {                 
                left = new BSTNode( key, value );             
            }         
        }         
        else if ( key.compareTo( this.key ) > 0 )
        {
            if ( right != null )
            {
                right.put( key, value );
            }
            else
            {
                right = new BSTNode( key, value );
            }
        }
        else
        {
            this.value = value;
        }
    }

    //Recoge el valor de la key 
    public int get( String key )
    {
        if ( this.key.equals( key ) )
        {
            return value;
        }

        if ( key.compareTo( this.key ) < 0 )
        {
            return left == null ? null : left.get( key );
        }
        else
        {
            return right == null ? null : right.get( key );
        }
    }
}