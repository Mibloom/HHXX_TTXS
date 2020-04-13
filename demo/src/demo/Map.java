package demo;

/**
 * @author lipengke
 * @description:
 * @date 2020/4/13 11:18
 */
public interface Map<K, V> {
    V put(K k, V v);

    V get(K k);

    int size();

    interface Entry<K, V> {
        K getKey();

        V getValue();

        V setValue(V v);

    }


}
