package leetcode.editor;

import leetcode.editor.cn.LRUCache;
import leetcode.editor.cn.Solution;

/**
 * @author vizhi
 * 描述 :
 * @create 2026-11-19 16:22
 */
public class main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);





    }
}
