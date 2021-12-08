package com.ak.introtoalgoandds;

public class KarpRabin {

    private static class Node {
        char c;
        Node next;

        Node(char c) {
            this.c = c;
        }
    }

    int max_size,hash=0,prime,d=256,max_hash=1;
    Node chars_head,chars_tail;

    public KarpRabin(String s) {
        this.max_size = s.length();
        prime = FindNextPrimeNumber.findNextPrimeNumber(this.max_size);
        initialize(s);
    }

    private void initialize(String s) {
        for (int i =0;i<max_size;i++) max_hash = max_hash*d % prime;
        chars_head = new Node(s.charAt(0));
        hash = (d*hash + chars_head.c) % prime;
        Node iterator = chars_head;
        for (int i=1;i<max_size;i++) {
            iterator.next = new Node(s.charAt(i));
            iterator = iterator.next;
            hash = (d*hash + iterator.c) % prime;
        }
        chars_tail = iterator;
    }

    public void add(char c) {
        hash = (d*(hash - chars_head.c * max_hash) + c ) % prime;
        chars_head = chars_head.next;
        chars_tail.next = new Node(c);
        chars_tail = chars_tail.next;
    }

    public boolean equals(KarpRabin kb){
        if(this.max_size == kb.max_size && this.hash == kb.hash) {
            Node it1 = chars_head,it2=kb.chars_head;
            while (it1!=null && it2!=null) {
                if(it1.c != it2.c) return false;
                it1 = it1.next;
                it2 = it2.next;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String pattern = "12";
        String txt = "12298164921291203721074382137237109231020372013";
        KarpRabin patternKR = new KarpRabin(pattern);
        KarpRabin txtKR = new KarpRabin(txt.substring(0,pattern.length()));
        int numberOfOccurrence = 0;
        if(patternKR.equals(txtKR)) numberOfOccurrence ++;
        for (int i=pattern.length();i<txt.length();i++) {
            txtKR.add(txt.charAt(i));
            if(patternKR.equals(txtKR)) numberOfOccurrence ++;
        }
        System.out.println(numberOfOccurrence);
    }

}
