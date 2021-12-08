package com.ak.introtoalgoandds;

public class HashMapOpenAddressing<K,V> {
    private static class Node<K,V> {
        K key = null;
        V value = null;
        boolean isDeleted = false;

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

    HashMapOpenAddressing(int initialSizeInPow2, CompressionType compressionType, HashType hashType) {
        this.hashTableSize = (int) Math.pow(2,initialSizeInPow2);
        hashTable = (Node<K,V>[]) new Node[hashTableSize];
        this.compressionType = compressionType;
        this.hashType = hashType;
    }

    private int hashCode1(K key) {
        switch (hashType) {
            case STRING_HASH:
                int h = 0;
                char[] val = key.toString().toCharArray();
                for (char c : val) {
                    h = 31 * h + c;
                }
                return h;
        }
        return 0;
    }

    private int hashCode2(K key) {
        switch (hashType) {
            case STRING_HASH: int h = 0;
                char[] val = key.toString().toCharArray();
                for (char c : val) {
                    h = 31 * h + c;
                    if(h%2==0) h=h+1;
                }
                return h;
        }
        return 0;
    }

    private int hashCode(K key, int i) {
        switch (compressionType) {
            case DIVISION : return ((hashCode1(key) + i*hashCode2(key))%hashTableSize);
        }
        return 0;
    }

    public void insert(K key,V value) {
        int index = hashCode(key,1);
        if(hashTable[index]==null || hashTable[index].isDeleted) {
            hashTable[index] = new Node<>(key,value);
        }
        else {
            if(hashTable[index].key.equals(key)) {
                hashTable[index].value = value;
            }
            else {
                int i=1;
                while (hashTable[index]!=null && !hashTable[index].isDeleted) {
                    index = hashCode(key,i++);
                }
                hashTable[index] = new Node<>(key,value);
            }
        }
    }

    public void delete(K key) {
        int index = hashCode(key,1);
        if(hashTable[index]!=null) {
            if(hashTable[index].key.equals(key)) {
                hashTable[index].isDeleted=true;
            }
            else {
                int i=1;
                while (hashTable[index]!=null && hashTable[index].key.equals(key) && !hashTable[index].isDeleted) {
                    index = hashCode(key,i++);
                }
                if(hashTable[index]!=null && hashTable[index].key.equals(key) && !hashTable[index].isDeleted) hashTable[index].isDeleted=true;
            }
        }
    }

    public V find(K key) {
        int index = hashCode(key,1);
        if(hashTable[index]!=null) {
            if(hashTable[index].key.equals(key) && !hashTable[index].isDeleted) {
                return hashTable[index].value;
            }
            else {
                int i=1;
                while (hashTable[index]!=null && hashTable[index].key.equals(key) && !hashTable[index].isDeleted) {
                    index = hashCode(key,i++);
                }
                if(hashTable[index]!=null && hashTable[index].key.equals(key) && !hashTable[index].isDeleted) return hashTable[index].value;
            }
        }
        return null;
    }



    public static void main(String[] args) {
        HashMapOpenAddressing<String,String> hm = new HashMapOpenAddressing<>(20, CompressionType.DIVISION, HashType.STRING_HASH);
        hm.insert("ak","arun kumar");
        hm.insert("sk","saravana kumar");
        hm.insert("vb","vishnu balaji");
        hm.insert("ss","siva sankar");

        hm.delete("ak");

        System.out.println(hm.find("sk"));
        System.out.println(hm.find("ss"));
        System.out.println(hm.find("ak"));
        System.out.println(hm.find("vb"));
    }
}
