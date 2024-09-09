package implementation;

import java.util.LinkedList;

public class LinkedList_1 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
//        list.printList(list);
        list.insert(list, 10);
        list.insert(list, 20);
        list.insert(list, 30);
        list.insert(list, 40);
        list.insert(list, 50);
        list.insert(list, 60);
        list.insert(list, 70);
        list.printList(list);
        list.delete(list, 30);
        list.printList(list);
        list.delete(list, 60);
        list.printList(list);
        System.out.println("Size: " + list.size(list));
        list.deleteAtPos(list, 1);
        list.printList(list);
        list.deleteAtPos(list, 10);
        list.deleteAtPos(list, 2);
        list.printList(list);
        list.deleteAtPos(list, 3);
        list.deleteAtPos(list, 2);
        list.deleteAtPos(list, 1);
        list.printList(list);

    }
}

class MyLinkedList {
    static class Node {
        int data;
        Node nextNode;

        Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    Node head;

    public MyLinkedList insert(MyLinkedList linkedList, int data) {
        Node newNode = new Node(data);
        if (linkedList.head == null) {
            linkedList.head = newNode;
        } else {
            Node currentNode = linkedList.head;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
        return linkedList;
    }

    public MyLinkedList delete(MyLinkedList list, int key) {
        // key found at head
        if (list.head != null && list.head.data == key) {
            list.head = list.head.nextNode;
            System.out.println(key + " deleted successfully");
            return list;
        }

        Node currentNode, prev = null;
        currentNode = list.head;

        while (currentNode != null && currentNode.data != key) {
            prev = currentNode;
            currentNode = currentNode.nextNode;
        }
        if (currentNode != null) {
            prev.nextNode = currentNode.nextNode;
            System.out.println(key + " deleted successfully");
        }
        if (currentNode == null) {
            System.out.println("Key not found: " + key);
        }
        return list;
    }

    public MyLinkedList deleteAtPos(MyLinkedList list, int index) {
        // check for empty list
        if (list.head == null) {
            System.out.println("List is empty!");
            return list;
        }

        if (index > list.size(list)) {
            System.out.println("Index: " + index + " is greater than list size: " + size(list));
            return list;
        }

        // delete at head of list
        if (index == 1) {
            list.head = list.head.nextNode;
            System.out.println("Node at index 1 successfully deleted");
        } else {
            Node currentNode = list.head, prev = null;
            int idx = 1;
            while (currentNode != null && idx != index) {
                prev = currentNode;
                currentNode = currentNode.nextNode;
                idx++;
            }
            if (currentNode != null) {
                prev.nextNode = currentNode.nextNode;
                System.out.println("Node at index " + idx + " successfully deleted");
            }
        }
        return list;
    }

    public int size(MyLinkedList list) {
        int size = 0;
        if (list.head == null) {
            return 0;
        }
        Node currentNode = list.head;
        while (currentNode != null) {
            currentNode = currentNode.nextNode;
            size++;
        }
        return size;
    }

    public void printList(MyLinkedList list) {
        if (list.head == null) {
            System.out.println("List is empty!");
            return;
        }
        String str = "";
        str += "Linked List: [";
        Node currentNode = list.head;
        while (currentNode != null) {
            str += currentNode.data + ", ";
            currentNode = currentNode.nextNode;
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        System.out.println(str);
    }
}
