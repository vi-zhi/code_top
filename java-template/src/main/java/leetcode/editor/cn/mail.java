package leetcode.editor.cn;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

// 信封对象：保护性暂停核心
class GuardedObject {
    private int id;
    private Object response;

    public GuardedObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // 收信：带超时等待结果，和截图逻辑一致
    public Object get(long timeout) {
        synchronized (this) {
            long begin = System.currentTimeMillis();
            long passedTime = 0;
            while (response == null) {
                long waitTime = timeout - passedTime;
                if (waitTime <= 0) {
                    break;
                }
                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 唤醒后更新已经流逝的时间
                passedTime = System.currentTimeMillis() - begin;
            }
            return response;
        }
    }

    // 送信：填入消息，唤醒等待线程
    public synchronized void complete(Object response) {
        this.response = response;
        this.notifyAll();
    }
}

// 信箱管理器，截图原版
class Mailboxes {
    private static Map<Integer, GuardedObject> boxes = new Hashtable<>();
    private static int id = 1;

    private static synchronized int generateId() {
        return id++;
    }

    public static GuardedObject getGuardedObject(int id) {
        return boxes.remove(id);
    }

    public static GuardedObject createGuardedObject() {
        GuardedObject go = new GuardedObject(generateId());
        boxes.put(go.getId(), go);
        return go;
    }

    public static Set<Integer> getIds() {
        return boxes.keySet();
    }
}

// 收信线程 People
class People extends Thread {
    @Override
    public void run() {
        // 创建信封，存入公共信箱
        GuardedObject guardedObject = Mailboxes.createGuardedObject();
        System.out.println("【收信人】开始收信，信封id：" + guardedObject.getId());
        // 这里把id传给邮递员（模拟传递id，实际网络就是传这个id）
        int mailId = guardedObject.getId();
        // 启动邮递员线程，把id和要送的内容给他
        new Postman(mailId, "你好，这是信件内容！").start();

        // 最多等待5秒收信
        Object mail = guardedObject.get(5000);
        System.out.println("【收信人】收到信封id:" + guardedObject.getId() + "，内容：" + mail);
    }
}

// 送信线程 Postman
class Postman extends Thread {
    private int id;
    private String mail;

    public Postman(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void run() {
        // 模拟邮递员在路上花费2秒
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GuardedObject guardedObject = Mailboxes.getGuardedObject(id);
        if (guardedObject != null) {
            System.out.println("【邮递员】送信，id:" + id + "，内容:" + mail);
            guardedObject.complete(mail);
        } else {
            System.out.println("【邮递员】找不到这个信封，id=" + id);
        }
    }
}

// 测试主类
public class mail {
    public static void main(String[] args) {
        new People().start();
    }
}
