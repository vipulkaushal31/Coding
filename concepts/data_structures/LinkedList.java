package concepts.data_structures;

import concepts.utils.OutputUtils;

public class LinkedList {
    // Doubly Linked List
    static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        void insertNode(int value) {
            Node temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node(value, null, temp);
        }

        Node removeNode(int value) {
            Node head = this, temp = head;
            if (temp.value == value) {
                Node newHead = temp.next;
                newHead.prev = null;
                return newHead;
            }

            while (temp != null && temp.value != value) {
                temp = temp.next;
            }

            if (temp == null) {
                OutputUtils.printKeys("Node with value: ", Integer.toString(value), "not found");
            } else {
                Node prevNode = temp.prev;
                prevNode.next = temp.next;
                temp.next = null;
                temp.prev = null;
            }
            return head;
        }
    }

    public static void main(String args[]) {
        Node head = new Node(10);

        for (int i = 0; i < 10; i++) {
            int randomSeed = i * 231 + 12832;
            OutputUtils.printKeys("inserting value: ", String.valueOf(randomSeed));
            head.insertNode(randomSeed);
        }

        Node temp = head;
        while (temp != null) {
            String nextNodeVal = temp.next != null ? String.valueOf(temp.next.value) : "NULL";
            String prevNodeVal = temp.prev != null ? String.valueOf(temp.prev.value) : "NULL";
            OutputUtils.printKeys("CurrNode ->", String.valueOf(temp.value), "PrevNode ->",
                    prevNodeVal, "NextNode ->", nextNodeVal);
            temp = temp.next;
        }
    }
}
