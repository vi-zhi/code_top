package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
public class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(){}

        public Node(int _key, int _value) {
            key = _key; value = _value;
        }
    }

    private int cap;
    private int size;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        movehead(node);
        return node.value;

    }



    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null) {
            Node newNode = new Node(key, value);

            map.put(key, newNode);

            addhead(newNode);
            size ++;
            if(size > cap) {
                Node delNode = removeTail();
                map.remove(delNode.key);
                size--;
            }
        }else {
            node.value = value;
            movehead(node);
        }

    }

    private Node removeTail() {
        Node delNode = tail.prev;
        removeNode(delNode);
        return delNode;
    }

    private void addhead(Node node) {

        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void movehead(Node node) {
        removeNode(node);
        addhead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}




