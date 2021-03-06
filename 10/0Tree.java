package week10;

import java.util.*;

/**
 * Skeleton of the recursive implementation of a general tree.
 * 
 * @author James Cross
 * @param <T> The type of values stored in the tree.
 */
public class Tree<T> {
    
    /** a generic object of class Tree called rootValue. */
    private T rootValue;
    /** a List of generic type called children. */
    private List<Tree<T>> children;


    /**
     * Constructor 1.
     * case for if there is a root and children.
     * 
     * @param rootValue generic object.
     *
     * @param children generic list.           
     */

    public Tree(T rootValue, List<Tree<T>> children) {
        this.rootValue = rootValue;
        this.children = children;
    }

    /**
     * Constructor 2 (overload).
     * case for if there are no children.
     * 
     * @param rootValue generic object.
     *
     *        
     */
    

    public Tree(T rootValue) {
        this(rootValue, new ArrayList<Tree<T>>());
    }


    /**
     * Checks if the rootvalue is there, if it is count 1.
     * Check if the children ArrayList is empty.
     * if not - add 1 to count if there is a node in the subtree.
     * 
     * @return count the number of nodes in the tree.
     */
    
    public int size() {
        int c = 1;
        if (rootValue == null) {
            return 0;
        }
        if (children.size() != 0) {
            for (Tree<T> cN : children) {
                c += cN.size();
            }
        }
        return c;
    }

    public int maxDegree() {
        int m = 0;
        if (rootValue == null) {
            return 0;
        }
        if (children.size() != 0) {
            m = children.size();
            for (Tree<T> cN : children) {
                if (cN.maxDegree() > m) {
                    m = cN.maxDegree();
                }
            }
        } else {
            return 0;
        }
        return m;
    }

    public void add(Tree<T> childNode) {
        //base case: if there is something in the children arraylist
        if (children.size()!=0 ) {
            //add a tree object of generic type
            //recursive loop
            //so keep adding nodes as long as children is not empty
            children.add(childNode);
        } else {
            //make an arraylist of type Tree<T>
            children =  new ArrayList<Tree<T>>();
            //add childnodes to that arraylist
            children.add(childNode);
        }
    }

    public Tree<T> find(T value) {
        if (rootValue.equals(value)) {
            return this;
        }
        for (Tree<T> child : children) {
            Tree<T> match = child.find(value);
            if (match != null) {
                return match;
            }
        }
        return null;
    }
  

    public List<T> postOrder() {
        ArrayList<T> p = new ArrayList<T>();
        if (children.size() ==0) {
            p.add(rootValue);
        } else {
            for (Tree<T> cn : children) {
                ArrayList<T> pC = (ArrayList<T>) cn.postOrder();
                p.addAll(pC);
            }
            p.add(rootValue);
        }
        return p ;
    }

    public String toString() {
        if (children.isEmpty()) {
            return rootValue.toString();
        }
        return rootValue.toString() + ' ' + children.toString();
    }


  
    public String toIndentedString() {
        String s =  "";
       
        if (children.size()==0) {
            return rootValue.toString();
        }
        s = rootValue.toString();
        
        for (Tree<T> cN : children) {
            String s2 = cN.toIndentedString();
            String [] s3 = s2.split("\n");
            
            for (int i = 0; i < s3.length; i++){
                s = s + "\n" + "  " + s3[i];
            }
        }
        return s + "\n";
    }

    /** A helper method for testing (used by main).  Searches tree for
     *  the given target and adds white space separated children to
     *  the tree matching target if there is one.
     *
     * @param target the root value to seach for.
     * @param children a white space separated list of children to add
     * to the tree whose value matches target.
     */
    private static void addChildren(String target, String children) {
        Tree<String> parent = tree.find(target);
        if (parent != null) {
            for (String child : children.split(" ")) {
                parent.add(new Tree<>(child));
            }
        }
    }

    /** A tree instance used for testing. */
    private static Tree<String> tree;

    /**
     * Entry point of the program (used for testing).
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        System.out.println("Creating tree\n-------------");
        tree = new Tree<>("food");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding children\n----------------");
        addChildren("food", "meat fruit vegetable");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding deeper children\n----------------------");
        addChildren("meat", "chicken beef fish");
        addChildren("fish", "salmon cod tuna shark");
        addChildren("vegetable", "cabbage");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nPostorder\n---------");
        System.out.println(tree.postOrder());
        System.out.println("\nIndented string\n---------------");
        System.out.print(tree.toIndentedString());
    }

}
