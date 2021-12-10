package com.ak.introtoalgoandds;

import java.util.ArrayList;
import java.util.List;

public class GraphOOMethod<V> {

    public static class Vortex<V> {
        V value;
        List<Vortex<V>> neighbours = new ArrayList<>();
        boolean isDFSVisited = false;

        Vortex<V> bfsParent = null;

        public boolean equals(Object obj) {
            Vortex<V> vertex = (Vortex<V>)obj;
            return this.value.equals(vertex.value);
        }
    }

    List<Vortex<V>> vortexes = new ArrayList<>();

    public GraphOOMethod(V[][] edges) {
        for (V[] edge : edges) {
            Vortex<V> parent = new Vortex<>();
            parent.value = edge[0];
            Vortex<V> child = new Vortex<>();
            child.value = edge[1];

            int parentIndex = vortexes.indexOf(parent);
            if(parentIndex==-1) vortexes.add(parent);
            else parent = vortexes.get(parentIndex);

            int childIndex = vortexes.indexOf(child);
            if(childIndex==-1) vortexes.add(child);
            else child = vortexes.get(childIndex);

            parent.neighbours.add(child);
        }
    }

    public void bfs(V value) {
        Vortex<V> vortex = new Vortex<>();
        vortex.value = value;
        vortex = vortexes.get(vortexes.indexOf(vortex));
        bfs(vortex);
    }
    private void bfs(Vortex<V> vortex) {
        List<Vortex<V>> currLevel = new ArrayList<>();
        vortex.bfsParent = vortex;
        currLevel.add(vortex);
        while (!currLevel.isEmpty()) {
            List<Vortex<V>> nextLevel = new ArrayList<>();
            for (Vortex<V> v: currLevel) {
                for (Vortex<V> neighbour : v.neighbours) {
                    if(neighbour.bfsParent==null) {
                        neighbour.bfsParent = v;
                        nextLevel.add(neighbour);
                        if(isBFSLastNode(neighbour)) {
                            bfsPrint(""+neighbour.value,neighbour.bfsParent);
                        }
                    }
                }
            }
            currLevel = nextLevel;
        }
    }
    private boolean isBFSLastNode(Vortex<V> vortex) {
        if(vortex.neighbours.isEmpty()) return true;
        for (Vortex<V> neighbour : vortex.neighbours) {
            if(neighbour.bfsParent==null) return false;
        }
        return true;
    }
    private void bfsPrint(String result,Vortex<V> vortex) {
        if(vortex==null || vortex.bfsParent==null) return;
        if(vortex.equals(vortex.bfsParent)) {
           System.out.println(vortex.value + "  -->  "+result);
           System.out.println();
           return;
        }
        result = vortex.value + "  -->  "+result;
        bfsPrint(result,vortex.bfsParent);
    }

    private void dfs() {
        for (Vortex<V> vortex : vortexes) {
            if(!vortex.isDFSVisited) dfs(new ArrayList<>(), vortex);
        }
        dfsReset();
    }
    private void dfs(List<Vortex<V>>parents,Vortex<V> vortex) {
        if(vortex.neighbours.isEmpty() || isAllNeighboursAreVisited(vortex)) {
            for (Vortex<V> v : parents) {
                System.out.print(v.value + "  -->  ");
            }
            System.out.print(vortex.value);
            System.out.println();
            return;
        }
        for (Vortex<V> neighbour : vortex.neighbours) {
            if(!neighbour.isDFSVisited) {
                neighbour.isDFSVisited=true;
                List<Vortex<V>> newParents = new ArrayList<>(parents);
                newParents.add(vortex);
                dfs(newParents, neighbour);
            }
        }
    }

    private boolean isAllNeighboursAreVisited(Vortex<V> vortex) {
        for (Vortex<V> v : vortex.neighbours) {
            if(!v.isDFSVisited) return false;
        }
        return true;
    }

    private void dfsReset() {
        for (Vortex<V> vortex : vortexes) {
            vortex.isDFSVisited = false;
        }
    }

    public static void main(String[] args) {
        Character[][] edges = {
                {'A','B'},
                {'C','D'},
                {'B','D'},
                {'B','C'}
        };
        GraphOOMethod<Character> graphOOMethod = new GraphOOMethod<>(edges);
        graphOOMethod.dfs();
        System.out.println("-------------------");
        graphOOMethod.bfs('A');
    }

}

