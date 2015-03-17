package org.tommy.stationery.ink.core.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by kun7788 on 15. 2. 9..
 */
public class ConcurrentLRUCache<K,V> {
    private ConcurrentHashMap<K,V> map;
    private ConcurrentLinkedQueue<K> queue;
    private final int size;

    public ConcurrentLRUCache(int size) {
        this.size = size;
        map = new ConcurrentHashMap<K,V>(size);
        queue = new ConcurrentLinkedQueue<K>();
    }

    public V get(K key) {
        queue.remove(key);
        queue.add(key);
        return map.get(key);
    }

    public boolean put(K key, V value) {
        if(key == null || value == null) return false;

        if(map.containsKey(key)) {
            queue.remove(key);
        }

        if(queue.size() >= size) {
            K lruKey = queue.poll();
            if(lruKey != null) {
                map.remove(lruKey);
            }
        }

        queue.add(key);
        map.put(key,value);
        return true;
    }

}

