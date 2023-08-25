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

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Node search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) {
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insert(56);
        linkedList.insert(30);
        linkedList.insert(70);

        Node node30 = linkedList.search(30);
        linkedList.insertAfter(node30, 40);

        linkedList.display();
    }
}
Now, let's write the JUnit test case for this operation:

java
Copy code
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void testInsertAfter() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(56);
        linkedList.insert(30);
        linkedList.insert(70);

        Node node30 = linkedList.search(30);
        assertNotNull("Node with value 30 should be found.", node30);

        linkedList.insertAfter(node30, 40);

        Node node40 = linkedList.search(40);
        assertNotNull("Node with value 40 should be found after insertion.", node40);

        Node node70 = linkedList.search(70);
        assertNotNull("Node with value 70 should be found.", node70);

        assertEquals("Node after 30 should have data 40.", 40, node30.next.data);
        assertEquals("Node after 40 should have data 70.", 70, node40.next.data);
    }
}






