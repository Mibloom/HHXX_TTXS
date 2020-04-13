package demo;

/**
 * @author lipengke
 * @description:
 * @date 2020/4/13 11:23
 */
public class MyMap<K, V> implements Map<K, V> {

    Node<K, V>[] array = null;

    public static int defaultLength = 16;

    public static int SIZE = 0;

    public static double factor = 0.75D;


    @Override
    public V put(K k, V v) {
        // 懒加载
        if (array == null) {
            array = new Node[defaultLength];
        }
        int index = hashIndex(k, defaultLength);

        if (SIZE > defaultLength * factor) {

            array = resize();
        }

        Node<K, V> node = array[index];
        if (node == null) {
            array[index] = new Node<>(k, v, null);
            SIZE++;
        } else {
            Node<K, V> next = node;
            while (next != null) {
                if (next.getKey().equals(k)) {
                    System.out.println(next.getKey());
                    System.out.println(k);
                    return next.setValue(v);
                }else {
                    next = next.next;
                }
            }
            array[index] = new Node<>(k, v, node);
            SIZE++;
        }
        return null;
    }

    private Node<K, V>[] resize() {
        defaultLength = defaultLength * 2;
        Node<K, V>[] newArray = new Node[defaultLength];
        for (int i = 0; i < array.length; i++) {
            Node<K, V> node = array[i];
            while (node != null) {
                // 计算出新的下标 index
                int index = hashIndex(node.getKey(), defaultLength);
                // 保存 下一个节点的指针，防止丢失之后节点
                Node<K, V> next = node.next;
                // 当前节点 下一个节点要执行 链表的头即对应数组位置
                node.next = newArray[index];
                // 数组 位置替换为节点
                newArray[index] = node;
                // 执行下一节点进行重计算
                node = next;
            }
        }
        return newArray;


    }

    private int hashIndex(K k, int defaultLength) {
        if (k == null) {
            return 0;
        }
        int hashCode = k.hashCode();
        return hashCode % (defaultLength);
        //return hashCode & (defaultLength -1);
    }

    @Override
    public V get(K k) {
        if (array != null) {
            int index = hashIndex(k, defaultLength);
            if (array[index] != null) {
                Node<K, V> node = array[index];
                while (node != null) {
                    if (node.getKey() == k) {
                        return node.getValue();
                    } else {
                        node = node.next;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return SIZE;
    }

    void printMap() {
        if (array == null) {
            System.out.println("null");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print("下标[" + i + "]");
            if (array[i] != null) {
                Node<K, V> node = array[i];
                while (node != null) {
                    System.out.print("[key:" + node.getKey() + ":" + node.getValue() + "]");
                    node = node.next;
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }
    }

    static class Node<K, V> implements Entry<K, V> {
        int hashCode;

        K key;

        V value;

        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V v) {
            V oldValue = value;
            value = v;
            return oldValue;
        }
    }

}
