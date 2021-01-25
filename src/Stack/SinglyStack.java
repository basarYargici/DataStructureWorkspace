package Stack;

/**
 * Project: DataStructureFinal
 * Package: Stack
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 25.01.2021
 * <p>
 * Singly Linked List implementation of a Stack
 */
public class SinglyStack {
    /**
     * Elements in Linked List represented as nodes. Node have to has data and pointer of next node.
     */
    class Node {
        int data;
        Node next; // pointer of next node

        /**
         * Constructor to instantiate new instances with data
         *
         * @param data is the data of node
         */
        public Node(int data) {
            this.data = data;
        }
    }

    private int size = 0;
    private Node head; // first node of stack
    private Node tail; // last node of stack

    /**
     * New node will be pushed to stack
     *
     * @param val is the data of new node
     */
    public void push(int val) {
        Node newNode = new Node(val);

        // if stack is empty (size == 0)
        if (head == null) {
            head = newNode;
            // if stack has only one element, head and tail should point the same node
            tail = head;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    /**
     * Last node will be removed from stack
     */
    public void pop() {
        // if list is null
        if (head == null) return;

        // iterator to iterate until arrive previous of tail
        Node temp = head;

        while (temp.next != tail) temp = temp.next;

        // tail to previous node
        tail = temp;
        // last element will be garbage because nothing will point it. It will be collected by garbage collector
        temp.next = null;

        size--;
    }

    /**
     * Gets the last node's data from stack
     *
     * @return data of last node
     */
    public int peek() {
        return tail.data;
    }

    /**
     * Displays all data from stack
     */
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }


}

class Test {
    public static void main(String[] args) {
        SinglyStack stack = new SinglyStack();
        System.out.println("PUSH PROCESS");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.display();
    }
}