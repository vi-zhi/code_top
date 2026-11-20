package leetcode.editor.cn;

import java.util.HashMap;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node() {}

        public Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;

    }



    public void put(int key, int value) {

        Node oldNode = map.get(key);
        // not have node
        if(oldNode == null) {
            // new a new node and add to map, update node location to head
            Node node = new Node(key, value);

            if(map.size() >= cap) {
                Node delNode = tail.prev;
                map.remove(delNode.key);
                removeNode(delNode);
                addToHead(node);
                map.put(key, node);
                return ;
            }

            addToHead(node);
            map.put(key, node);
        } else {
            oldNode.value = value;
            moveToHead(oldNode);
        }
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}




















