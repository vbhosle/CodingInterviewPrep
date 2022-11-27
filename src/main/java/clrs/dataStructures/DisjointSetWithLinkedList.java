package clrs.dataStructures;

//When the edges of the graph are static—not changing over time—we can compute the connected
//components faster by using depth-first search (Exercise 22.3-12). Sometimes, however, the edges
//are added dynamically and we need to maintain the connected components as each edge is added. In
//this case, the implementation given here can be more efficient than running a new depth-first search
//for each new edge.

import java.util.*;

public class DisjointSetWithLinkedList<T> {
    private  static int setCounter = 1;
    
    public void connectedComponents(Graph<T> graph) {
        for(SetMember<T> vertex: graph.vertices)
            makeSet(vertex);
        for(Edge<T> edge: graph.edges) {
            if(findSet(edge.node1) != findSet(edge.node2))
                union(edge.node1, edge.node2);
        }
    }
    
    public boolean sameComponent(SetMember<T> node1, SetMember<T> node2) {
        return findSet(node1) == findSet(node2);
    }

    private void union(SetMember<T> representativeMember1, SetMember<T> representativeMember2) {
        DisjointSet<T> set1 = representativeMember1.set;
        DisjointSet<T> set2 = representativeMember2.set;
        set1.tail.next = set2.head;
        SetMember<T> set2Member = set2.head;
        while(set2Member != null) {
            set1.tail = set2Member;
            set2Member.set = set1;
            set2Member = set2Member.next;
        }
    }

    private DisjointSet<T> findSet(SetMember<T> node) {
        return node.set;
    }

    private void makeSet(SetMember<T> setMember) {
        setMember.set = new DisjointSet<>("SET-" + setCounter++);
        setMember.set.head = setMember;
        setMember.set.tail = setMember;
        setMember.next = null;
    }

    public static class Graph<T> {
        Set<SetMember<T>> vertices = new HashSet<>();
        List<Edge<T>> edges = new ArrayList<>();

        public Graph(Set<SetMember<T>> vertices) {
            this.vertices = vertices;
        }

        public void addEdge(Edge<T> edge) {
            if(edge == null)
                throw new IllegalArgumentException("edge cannot be null");
            if(!vertices.contains(edge.node1) || !vertices.contains(edge.node2))
                throw new IllegalArgumentException("edge nodes must be part of this graph");
            
            edges.add(edge);
        }
    }
    
    public static class Edge<T> {
        SetMember<T> node1;
        SetMember<T> node2;
        
        Edge(SetMember<T> node1, SetMember<T> node2) {
            if(node1 == null)
                throw new IllegalArgumentException("vertex of node cannot be null");
            if(node2 == null)
                throw new IllegalArgumentException("vertex of node cannot be null");
            this.node1 = node1;
            this.node2 = node2;
        }
    }
    
    public static class DisjointSet<T> {
        SetMember<T> head = null;
        SetMember<T> tail = null;
        String name;
        DisjointSet(String name) {
            this.name = name;
        }

        public Set<SetMember<T>> getMembers() {
            Set<SetMember<T>> members = new HashSet<>();
            SetMember<T> next = this.head;
            while(next != null) {
                members.add(next);
                next = next.next;
            }
            
            return members;
        }
    }
    
    public static class SetMember<T> {
        DisjointSet<T> set;
        T value;
        SetMember<T> next = null;
        
        SetMember(T value) {
            if(value == null)
                throw new IllegalArgumentException("value cannot be null");
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SetMember)) return false;
            SetMember<?> setMember = (SetMember<?>) o;
            return value.equals(setMember.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
