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
public class BinarySearchTree {
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

    private Node root;

    /**
     * Inserting to tree occurs with recursive function and this function calls recursive function.
     *
     * @param data is the data of new node
     */
    public void insert(int data) {
        root = insertRecursively(root, data);
    }

    /**
     * We should reach to leaf nodes and to reach them we are using recursive function, which will call itself.
     * This function will reach to leaf node and insert new node to appropriate position
     *
     * @param root is the pointer of current node
     * @param data is the data of new node
     * @return root of node
     */
    private Node insertRecursively(Node root, int data) {
        Node newNode = new Node(data);

        // new node should be added to next of leaf, so next of root has to be null
        // we will always enter this if condition to add new node
        if (root == null) {
            root = newNode;
            return root;
        }

        // if new data is bigger than before, it should be on right side
        // else if smaller, it should be on left side
        if (root.data < data) {
            root.right = insertRecursively(root.right, data);
        } else if (root.data > data) {
            root.left = insertRecursively(root.left, data);
        }

        return root;
    }

    /**
     * Deleting from tree occurs with recursive function and this function calls recursive function.
     *
     * @param data is the data of want to be deleted node
     */
    void delete(int data) {
        root = deleteRecursively(root, data);
    }

    /**
     * This function will try to find the wanted node and delete it.
     *
     * @param root is the pointer of current node
     * @param data is the data of want to be deleted node
     * @return root of node
     */
    Node deleteRecursively(Node root, int data) {
        // if tree is empty return null
        if (root == null) return null;

        // traverse the tree
        if (data < root.data)     // traverse left subtree
            root.left = deleteRecursively(root.left, data);
        else if (data > root.data)  //traverse right subtree
            root.right = deleteRecursively(root.right, data);
        else {
            // if node only has one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // if node has two children get inorder successor (minData in the right subtree)
            root.data = minData(root.right);

            // delete the inorder successor
            root.right = deleteRecursively(root.right, root.data);
        }
        return root;
    }

    /**
     * Shows the minimum data.
     *
     * @param root is current node
     * @return minimum data
     */
    int minData(Node root) {
        //initially minData is root
        int minData = root.data;
        // try to find minData
        while (root.left != null) {
            minData = root.left.data;
            root = root.left;
        }
        return minData;
    }

    /**
     * To get all nodes in order we will use recursive function and this function calls recursive function.
     */
    public void inorder() {
        inorderRecursive(root);
    }

    /**
     * We should reach to leaf node which has smallest data-value and to reach them we are using recursive
     * function, which will call itself. This function will reach to smallest leaf node and after printing it,
     * it will pass that node and try to get other node which has smallest data-value.
     *
     * @param root is the pointer of current node
     */
    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left); // left nodes are smaller than right nodes, that's why we first call left node
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }
}

/**
 * Test class to test our BinarySearchTree class which is Binary Search Tree implementation
 */
class Test {

    /**
     * Main function where we will test BinarySearchTree class
     *
     * @param args is not used
     */
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        System.out.println("----------INSERT PROCESS AND INORDER TRAVERSAL--------");
        binarySearchTree.insert(10);
        binarySearchTree.insert(15);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.inorder();

        System.out.println("\n----------DELETE PROCESS AND INORDER TRAVERSAL--------");
        System.out.println("Delete 6 :");
        binarySearchTree.delete(6);
        binarySearchTree.inorder();

        System.out.println("\nDelete 10 :");
        binarySearchTree.delete(10);
        binarySearchTree.inorder();

        System.out.println("\nDelete 15 :");
        binarySearchTree.delete(15);
        binarySearchTree.inorder();

        System.out.println("\nDelete 5 :");
        binarySearchTree.delete(5);
        binarySearchTree.inorder();
    }
}