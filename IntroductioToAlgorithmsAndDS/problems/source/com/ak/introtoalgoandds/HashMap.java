package com.ak.introtoalgoandds;

public class HashMap<K,V> {

    private static class Node<K,V> {
        K key = null;
        V value = null;
        Node<K,V> next = null;

        Node(K key,V value) {
            this.key = key;
            this.value = value;
        }
    }

    public enum CompressionType {
        DIVISION,
        MULTIPLICATION,
        UNIVERSAL_HASHING
    }

    public enum HashType {
        STRING_HASH
    }

    private Node<K,V>[] hashTable;
    private CompressionType compressionType = null;
    private int hashTableSize = 0;
    private HashType hashType;

    HashMap(int initialSize, CompressionType compressionType, HashType hashType) {
        this.hashTableSize = initialSize;
        hashTable = (Node<K,V>[]) new Node[hashTableSize];
        this.compressionType = compressionType;
        this.hashType = hashType;
    }

    private int hashCode(K key) {
        switch (hashType) {
            case STRING_HASH: return key.toString().hashCode();
        }
        return 0;
    }

    private int compress(int hashCode) {
        switch (compressionType) {
            case DIVISION : return hashCode%hashTableSize;
            case MULTIPLICATION: return (int) Math.floor(hashTableSize*(hashCode*0.618033 % 1));
            case UNIVERSAL_HASHING: return ((31*hashCode+41) % 51) % hashTableSize;
        }
        return 0;
    }

    public void insert(K key,V value) {
        int index = compress(hashCode(key));
        Node<K,V> existingNode = hashTable[index];
        if(existingNode==null) {
            hashTable[index] = new Node<>(key,value);
        }
        else {
            if(existingNode.key.equals(key)) {
                existingNode.value = value;
            }
            else {
                while (existingNode.next!=null) {
                    existingNode = existingNode.next;
                    if(existingNode.key.equals(key)) {
                        existingNode.value = value;
                        return;
                    }
                }
                existingNode.next = new Node<>(key,value);
            }
        }
    }

    public void delete(K key) {
        int index = compress(hashCode(key));
        Node<K,V> existingNode = hashTable[index];
        if(existingNode!=null) {
            if(existingNode.key.equals(key)) {
                hashTable[index] = existingNode.next;
            }
            else {
                Node<K, V> parent = existingNode;
                existingNode = parent.next;
                while (existingNode != null) {
                    if (existingNode.key.equals(key)) {
                        break;
                    }
                    parent = existingNode;
                    existingNode = existingNode.next;
                }
                if(existingNode!=null) parent.next = existingNode.next;
            }
        }
    }

    public V find(K key) {
        int index = compress(hashCode(key));
        Node<K,V> existingNode = hashTable[index];
        if(existingNode!=null) {
            if(existingNode.key.equals(key)) {
                return existingNode.value;
            }
            else {
                Node<K, V> parent = existingNode;
                existingNode = parent.next;
                while (existingNode != null) {
                    if (existingNode.key.equals(key)) {
                        break;
                    }
                    existingNode = existingNode.next;
                }
                if(existingNode!=null) return existingNode.value;
            }
        }
        return null;
    }



    public static void main(String[] args) {
        HashMap<String,String> hm = new HashMap<>(20, CompressionType.UNIVERSAL_HASHING, HashType.STRING_HASH);
        hm.insert("ak","arun kumar");
        hm.insert("sk","saravana kumar");
        hm.insert("vb","vishnu balaji");
        hm.insert("ss","siva sankar");

        System.out.println(hm.find("sk"));
        System.out.println(hm.find("ss"));
        System.out.println(hm.find("ak"));
        System.out.println(hm.find("vb"));
    }
}
