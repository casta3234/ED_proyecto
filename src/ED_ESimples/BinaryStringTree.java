/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;

public class BinaryStringTree {
 
    private String data;
    private BinaryStringTree left;
    private BinaryStringTree right;
 
    public BinaryStringTree() {
        this.data = null;
        this.left = null;
        this.right = null;
    }
     
    public BinaryStringTree(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
 
    public static BinaryStringTree createTree( String content ) {
        BinaryStringTree bstree = new BinaryStringTree();
        if( content != null ) {
            //Borra los signos de puntuacion
            content = content.replaceAll("(\\w+)\\p{Punct}(\\s|$)", "$1$2");
            String[] words = content.split( " " );
            bstree = new BinaryStringTree();
            for( int i = 0; i < words.length; i++ ) {
                bstree.addNode( words[i]);
            }
        } 
        return bstree;
    }
 
    public void addNode(String data) {
        if (this.data == null) {
            this.data = data;
        } else {
            if (this.data.compareTo(data) < 0) {
                if (this.left != null) {
                    this.left.addNode(data);
                } else {
                    this.left = new BinaryStringTree(data);
                }
             } else {
                if (this.right != null) {
                    this.right.addNode(data);
                } else {
                    this.right = new BinaryStringTree(data);
                }
 
            }
        }
    }
     
    public void traversePreOrder() {
        System.out.println(this.data);
        if (this.left != null) {
            this.left.traversePreOrder();
        }
        if (this.right != null) {
            this.right.traversePreOrder();
        }
    }
 
    public void traverseInOrder() {
        if (this.left != null) {
            this.left.traverseInOrder();
        }
        System.out.println(this.data);
        if (this.right != null) {
            this.right.traverseInOrder();
        }
    }
 
 
    public void traversePostOrder() {
        if (this.left != null) {
            this.left.traversePostOrder();
        }
        if (this.right != null) {
            this.right.traversePostOrder();
        }
        System.out.println(this.data);
    }
 
}