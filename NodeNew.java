class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void dequeue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Dequeued: " + head.data);
        head = head.next;
        if (head == null) {
            tail = null; // Reset tail if the queue becomes empty
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }
}

class Queue {
    private LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public void enqueue(int data) {
        list.append(data);
    }

    public void dequeue() {
        list.dequeue();
    }

    public void display() {
        list.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(56);
        queue.enqueue(30);
        queue.enqueue(70);

        System.out.println("Queue Sequence:");
        queue.display();

        queue.dequeue();
        System.out.println("Queue Sequence after dequeue:");
        queue.display();
    }
}





