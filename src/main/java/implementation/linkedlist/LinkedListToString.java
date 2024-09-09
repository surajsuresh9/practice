package implementation.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListToString {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);

        String s = "";

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            s += listIterator.next() + " ";
        }
        System.out.println(s);
    }
}