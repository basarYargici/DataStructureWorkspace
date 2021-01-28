package BinarySearchTree;

/**
 * Project: DataStructureFinal
 * Package: BinarySearchTree
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 28.01.2021
 * <p>
 * implementation of Binary Search Tree
 */
public class BST {
    /**
     * Elements in Tree represented as nodes. Node has to have data and pointers of right and left nodes.
     */
    class Node {
        int data;
        Node left; // left pointer
        Node right; // right pointer

        /**
         * Constructor to instantiate new instances with data
         *
         * @param data is the data of node
         */
        public Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    //TODO remove and delete functions should be added
    Node root;
    private int size = 0;


    /**
     * Inserting to tree occurs with recursive function and this function calls recursive function.
     *
     * @param val is the data of new node
     */
    public void insert(int val) {
        root = insertRecursively(root, val);
    }

    /**
     * We should reach to leaf nodes and to reach them we are using recursive function, which will call itself.
     * This function will reach to leaf node and insert new node to appropriate position
     *
     * @param root is the pointer of current node
     * @param val  is the data of new node
     * @return inserted node
     */
    private Node insertRecursively(Node root, int val) {
        Node newNode = new Node(val);

        // new node should be added to next of leaf, so next of root has to be null
        // we will always enter this if condition to add new node
        if (root == null) {
            root = newNode;
            size++;
            return root;
        }

        // if new data is bigger than before, it should be on right side
        // else if smaller, it should be on left side
        if (root.data < val) {
            root.right = insertRecursively(root.right, val);
        } else if (root.data > val) {
            root.left = insertRecursively(root.left, val);
        }

        return root;
    }


    /**
     * To get all nodes in order we will use recursive function and this function calls recursive function.
     */
    public void inorder() {
        inorder_Recursive(root);
    }

    // recursively traverse the BST

    /**
     * We should reach to leaf node which has smallest data-value and to reach them we are using recursive
     * function, which will call itself. This function will reach to smallest leaf node and after printing it,
     * it will pass that node and try to get other node which has smallest data-value.
     *
     * @param root is the pointer of current node
     */
    private void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left); // left nodes are smaller than right nodes, that's why we first call left node
            System.out.print(root.data + " ");
            inorder_Recursive(root.right);
        }
    }

    /**
     * Getter function to get size
     *
     * @return size of queue
     */
    public int getSize() {
        return size;
    }
}

/**
 * Test class to test our BST class which is Binary Search Tree implementation
 */
class Test {

    /**
     * Main function where we will test BST class
     *
     * @param args is not used
     */
    public static void main(String[] args) {
        BST binarySearchTree = new BST();
        binarySearchTree.insert(10);
        binarySearchTree.insert(15);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.inorder();
        System.out.println("\nsize: " + binarySearchTree.getSize());
    }
}