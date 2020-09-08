package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写
//入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计


class LRU缓存机制{

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private class LinkNode {
            private int key;
            private int value;
            private LinkNode prev;
            private LinkNode next;

            LinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            LinkNode() {

            }

        }

        private HashMap<Integer, LinkNode> hashMap;
        private int size;
        private int capacity;
        private LinkNode head;
        private LinkNode tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
        }

        public int get(int key) {
            if (hashMap == null || hashMap.get(key) == null){
                return -1;
            }
            LinkNode linkNode = hashMap.get(key);
            moveNode(linkNode);
            addNode(linkNode);
            return linkNode.value;
        }

        public void put(int key, int value) {
            if (hashMap == null) {
                hashMap = new HashMap<>();
                head = new LinkNode();
                tail = new LinkNode();
                head.next = tail;
                tail.prev = head;
            }
            LinkNode linkNode = hashMap.get(key);
            if (linkNode == null) {
                LinkNode newNode = new LinkNode(key, value);
                if (size >= capacity){
                    LinkNode deleteNode = head.next;
                    head.next = deleteNode.next;
                    deleteNode.next.prev = head;
                    hashMap.remove(deleteNode.key);
                    deleteNode = null;
                    --size;
                }
                addNode(newNode);
                hashMap.put(key,newNode);
                ++size;
            }else {
                linkNode.value = value;
                moveNode(linkNode);
                addNode(linkNode);
            }

        }
        private void moveNode(LinkNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private void addNode(LinkNode node){
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;
            node.next = tail;
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

