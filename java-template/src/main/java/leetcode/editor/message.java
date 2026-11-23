package leetcode.editor;

import java.util.LinkedList;

/**
 * @author vizhi
 * 描述 :
 * @create 2026-11-23 14:32
 */

class MessageQueue {
    LinkedList<Message> linkedlist = new LinkedList<>();
    private int cap;

    public MessageQueue(int capatity) {
        this.cap = capatity;
    }

    public void put(Message message) {
        synchronized (linkedlist) {
            while(cap == linkedlist.size()) {
                try {
                    System.out.println(Thread.currentThread().getId() + " 队列已满，生产阻塞put wait");
                    linkedlist.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            linkedlist.addLast(message);
            System.out.println(Thread.currentThread().getId() + " put " + message);
            linkedlist.notifyAll();
        }
    }

    public Message get() {
        synchronized (linkedlist) {
            while(linkedlist.isEmpty()) {
                try {
                    System.out.println("get wait");
                    linkedlist.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Message message = linkedlist.removeFirst();
            System.out.println("get " + message);
            linkedlist.notifyAll();
            return message;
        }
    }


}

final class Message {
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int get() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message:{" + "id=" + id + ", value=" + value + "}";
    }
}