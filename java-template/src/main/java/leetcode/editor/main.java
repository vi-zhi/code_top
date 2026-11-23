package leetcode.editor;

import leetcode.editor.cn.LRUCache;
import leetcode.editor.cn.Solution;
import leetcode.editor.common.ListNode;

/**
 * @author vizhi
 * 描述 :
 * @create 2026-11-19 16:22
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        MessageQueue messageQueue = new MessageQueue(2);

        new Thread(() -> {
            while(true) {
                Message message = messageQueue.get();
            }
        },"get").start();
        Thread.sleep(1000);
        for(int i = 0 ;i < 3; i++) {
            int id = i;
            new Thread(() -> {
                messageQueue.put(new Message(id, "val" + id));
            },"put").start();
        }

    }
}
