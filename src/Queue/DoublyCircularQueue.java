package Queue;

import java.util.*;

/**
 * Project: DataStructureFinal
 * Package: Queue
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 27.01.2021
 * <p>
 * Doubly Circular Linked List implementation of a Queue
 */
public class DoublyCircularQueue {
    /**
     * Elements in Linked List represented as nodes. Node has to have data and pointer of next node.
     */
    class Node {
        int data;
        Node next; // pointer of next node
        Node prev; // pointer of previous node

        /**
         * Constructor to instantiate new instances with data.
         *
         * @param data is the data of node
         */
        public Node(int data) {
            this.data = data;
        }
    }

    private int size = 0;
    private Node head; // front node pointer
    private Node tail; // back-rear node pointer
    private Node temp; // to keep last element


    /**
     * New node will be added to last of queue.
     *
     * @param val is the data of new node
     */
    public void add(int val) {
        Node newNode = new Node(val);
        temp = tail; // keeping last node of queue

        // if list is empty head and tail should point the same node
        // also this is the part of initialization of circularity which previous of head is tail and next of tail is head
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.prev = tail;
            tail.next = head;

            size++;
            return;
        }

        temp.next = newNode;
        newNode.prev = tail;
        tail = newNode;

        size++;
    }


    /**
     * Returns head of queue without removing it.
     *
     * @return head node if queue is not empty, otherwise null
     */
    public Node peek() {
        if (size == 0) return null;
        return head;
    }

    /**
     * This method removes and returns the head of the queue.
     *
     * @return head if queue is not empty, otherwise null
     */
    public Node poll() {
        if (size == 0) return null;

        // if size is one, after removing node, head and tail should point to null
        if (size == 1) {
            temp = head;
            head = null;
            tail = null;
            size--;
            return temp;
        }

        temp = head;
        head = head.next;
        head.prev = tail;

        size--;
        return temp;
    }

    /**
     * This method is similar to poll() except it throws NoSuchElementException if the queue is empty.
     *
     * @return head of queue if list is not empty, otherwise throws NoSuchElementException
     */
    public Node remove() {
        if (size == 0) throw new NoSuchElementException();
        return poll();
    }

    /**
     * Displays the queue
     */
    public void display() {
        if (size == 0) {
            System.out.print("Queue is empty\n");
            return;
        }
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Getter function to get size
     *
     * @return size of queue
     */
    public int getSize() {
        return size;
    }

    /**
     * Checks if the queue is empty or not
     *
     * @return true if list is empty, otherwise false
     */
    public boolean isEmpty() {
        return (size == 0);
    }
}

/**
 * Test class to test DoublyCircularQueue class
 */
class Test {
    /**
     * Main function where we will test DoublyCircularQueue class
     *
     * @param args is not used
     */
    public static void main(String[] args) {
        DoublyCircularQueue circularQueue = new DoublyCircularQueue();
        System.out.println("Is queue empty? " + circularQueue.isEmpty());

        System.out.println("Add function and display function:");
        circularQueue.add(1);
        circularQueue.add(2);
        circularQueue.add(3);
        circularQueue.display();
        System.out.println("(getSize function will display the size of queue) \t\tsize: " + circularQueue.getSize());


        System.out.println("\n(peek function will display head without removing) \t\tpeek: " + circularQueue.peek().data);

        System.out.println("\n(pool function will display head and later remove it) \tpool: " + circularQueue.poll().data);
        System.out.println("New queue:");
        circularQueue.display();

        System.out.println("(getSize function will display the size of queue) \t\tsize: " + circularQueue.getSize());

        System.out.println("\n(pool function will display head and later remove it) \tpool: " + circularQueue.poll().data);
        System.out.println("New queue:");
        circularQueue.display();
        System.out.println("(getSize function will display the size of queue) \t\tsize: " + circularQueue.getSize());

        System.out.println("\n(pool function will display head and later remove it) \tpool: " + circularQueue.poll().data);
        System.out.println("New queue:");
        circularQueue.display();


        System.out.println("\nRemove and pool difference: (now we have empty queue, remove will throw exception)");
        System.out.println("(pool function will display null because queue is ) \t\t\tpool: " + circularQueue.poll());
        System.out.print("(remove function will throw exception because queue is empty) \tremove: ");
        System.out.println(circularQueue.remove());

    }
}