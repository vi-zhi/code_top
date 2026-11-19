package leetcode.editor;

import leetcode.editor.cn.LRUCache;

/**
 * @author vizhi
 * 描述 :
 * @create 2026-11-19 16:22
 */
public class main {
    public static void main(String[] args) {
        LRUCache lruCache = new  LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
    }
}
