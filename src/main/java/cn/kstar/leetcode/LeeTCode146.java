package cn.kstar.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <h6>LRU缓存机制
 * <br/>LRU Cache</h6>
 *
 * <p>运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
 * <br/>它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <br/>Design and implement a data structure for Least Recently Used (LRU) cache. 
 * <br/>It should support the following operations: get and put.</p>
 * <p>获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * <br/>写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。
 * <br/>当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <br/>get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * <br/>put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.</p>
 * <p>The cache is initialized with a positive capacity.</p>
 * <p><b>进阶：</b>
 * <br/><b>Follow up:</b>
 * <br/>你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <br/>Could you do both operations in O(1) time complexity?</p>
 * <pre><b>Example: </b>
 * LRUCache cache = new LRUCache( 2 ); //capacity
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1); // returns 1
 * cache.put(3, 3); // evicts key 2
 * cache.get(2); // returns -1 (not found)
 * cache.put(4, 4); // evicts key 1
 * cache.get(1); // returns -1 (not found)
 * cache.get(3); // returns 3
 * cache.get(4); // returns 4
 * </pre>
 */
public class LeeTCode146 {
    
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        int res1 = lruCache.get(1);
        int res2 = lruCache.get(2);
        int res3 = lruCache.get(3);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}

/**
 * <h6>HashMap+双向链表实现LRU</h6>
 */
class LRUCache {

    /**
     * <h6>头节点</h6>
     */
    private Node head;

    /**
     * <h6>尾节点</h6>
     */
    private Node tail;

    /**
     * <h6>链表的节点个数</h6>
     */
    private int count;

    /**
     * <h6>链表的容量</h6>
     */
    private int capacity;

    /**
     * <h6>保存链表节点位置的Map</h6>
     */
    private Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new Node();
        tail = new Node();
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    /**
     * <h6>获取数据</h6>
     * 
     * @param key
     * @return int
     */
    public int get(int key) {
        Node node = cache.get(key);
        // 目标节点不存在，返回-1
        if (node == null) {
            return -1;
        }

        // 把目标节点移到链表头部，并返回其值
        this.moveToHead(node);
        return node.val;
    }

    /**
     * <h6>写入数据</h6>
     * 
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node node = cache.get(key);

        // 写入的节点存在，修改其值并移到链表头部
        if (node != null) {
            node.val = value;
            this.moveToHead(node);
            return;
        }

        // 当前链表的结点个数大于容量，删除尾部的节点
        if (++count > capacity) {
            Node tailNode = this.removeTailNode();
            this.cache.remove(tailNode.key);
            --count;
        }

        // 把新节点插入链表的头部
        Node newNode = new Node(key, value);
        this.cache.put(key, newNode);
        this.addNode(newNode);
    }

    /**
     * <h6>在头部插入节点</h6>
     * 
     * @param node
     */
    private void addNode(Node node) {
        Node prev = head;
        Node next = head.next;
        node.prev = prev;
        node.next = next;
        head.next = node;
        next.prev = node;
    }

    /**
     * <h6>删除一个入节点</h6>
     * 
     * @param node
     */
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * <h6>把一个节点移动到头部</h6>
     */
    private void moveToHead(Node node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * <h6>移除尾部节点</h6>
     * 
     * @return
     */
    private Node removeTailNode() {
        Node ret = tail.prev;
        this.removeNode(ret);
        return ret;
    }

    /**
     * <h6>节点对象</h6>
     */
    private static class Node {

        public Node() {

        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        /**
         * <h6>键</h6>
         */
        public int key;

        /**
         * <h6>值</h6>
         */
        public int val;

        /**
         * <h6>前节点</h6>
         */
        public Node prev;

        /**
         * <h6>后节点</h6>
         */
        public Node next;
    }
}

/**
 * <h6>使用LinkedHashMap实现LRU</h6>
 */
class LinkedHashMapLRUCache extends LinkedHashMap<Integer, Integer> {

    private static final long serialVersionUID = 1L;

    private int capacity;

    public LinkedHashMapLRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    /**
     * <h6>获取数据</h6>
     *
     * @param intkey
     * @return int
     */
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    /**
     * <h6>写入数据</h6>
     * 
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        super.put(key, value);
    }

    /**
     * <h6>移除末尾最老的节点的条件<h6>
     */
    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}