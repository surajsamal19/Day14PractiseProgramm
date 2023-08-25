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

    public void deleteNode(int key) {
        if (head == null) {
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        prev.next = current.next;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insert(56);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(70);

        System.out.println("Original Linked List:");
        linkedList.display();

        Node node40 = linkedList.search(40);
        if (node40 != null) {
            linkedList.deleteNode(40);
            System.out.println("Linked List after deleting node 40:");
            linkedList.display();
        }

        int listSize = linkedList.size();
        System.out.println("Size of Linked List: " + listSize);
    }
}
Now, let's write the JUnit test case for these operations:

java
Copy code
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void testDeleteAndSize() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(56);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(70);

        Node node40 = linkedList.search(40);
        assertNotNull("Node with value 40 should be found.", node40);

        linkedList.deleteNode(40);

        Node deletedNode = linkedList.search(40);
        assertNull("Node with value 40 should not be found after deletion.", deletedNode);

        int listSize = linkedList.size();
        assertEquals("Size of linked list should be 3 after deletion.", 3, listSize);
    }
}





