package implementation.linkedlist;

public class MyDoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    private Node head;
    private Node tail;


    // traverse from head to tail
    public void traverseForward() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    // traverse from tail to head
    public void traverseBackward() {
        Node currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.prev;
        }
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // head is the first node, so add a node (newNode) before head and point
            // newNode's next to head
            newNode.next = head;
            head.prev = newNode; // head's prev is newNode
            head = newNode; // newNode is head
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        // no elements in list/ empty list
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 1) {
            insertAtBeginning(data);
        } else {
            Node currentNode = head;
            int currPos = 1;
            while (currentNode != null && currPos < position) {
                currentNode = currentNode.next;
                currPos++;
            }
            if (currentNode == null) {
                insertAtEnd(data);
            } else {
                newNode.next = currentNode;
                newNode.prev = currentNode.prev;
                currentNode.prev.next = newNode;
                currentNode.prev = newNode;
            }
        }
    }

    public int getSize() {
        Node curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    public void printList() {
        String str = "Doubly Linked List: [";
        Node currentNode = head;
        //empty list
        if (head == null) {
            str += "NULL ]";
        } else {
            while (currentNode != null) {
                str += currentNode.data + " <--> ";
                currentNode = currentNode.next;
            }
//            str = str.substring(0, str.length() - 6);
            str += "NULL ]";
        }
        System.out.println(str);
    }

    public void deleteAtEnd() {
        if (tail == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        Node lastNode = tail;
        tail = tail.prev;
        tail.next = null;
        lastNode.prev = null;
    }

    public void deleteAtBeginning() {
        // Empty list
        if (head == null) {
            return;
        }

        // Only 1 element
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node currentNode = head;
        head = currentNode.next;
        head.prev = null;
        currentNode.next = null;
    }

    public void deleteAtSpecificPosition(int position) {
        if (head == null) {
            return;
        }

        if (position == 1) {
            deleteAtBeginning();
        }
        Node current = head;
        int count = 1;
        while (count < position && current != null) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Invalid position");
            return;
        }

        if (current == tail) {
            deleteAtEnd();
            return;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = null;
        current.prev = null;

    }

    public static void main(String[] args) {
        MyDoublyLinkedList list = new MyDoublyLinkedList();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtPosition(30, 3);
        list.insertAtPosition(40, 4);
        list.insertAtPosition(60, 6);
        list.printList();
        list.deleteAtBeginning();
        list.printList();
        list.deleteAtBeginning();
        list.printList();
        System.out.println("Size: " + list.getSize());
    }
}
