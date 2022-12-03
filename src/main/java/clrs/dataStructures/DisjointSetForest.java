package clrs.dataStructures;

import java.util.*;

public class DisjointSetForest<T> {


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

    private void union(SetMember<T> member1, SetMember<T> member2) {
        link(findSet(member1), findSet(member2));
    }

    private void link(SetMember<T> member1, SetMember<T> member2) {
        if(member1.rank > member2.rank)
            member2.parent = member1;
        else {
            member1.parent = member2;
            if(member1.rank == member2.rank)
                member2.rank++;
        }
    }

    private SetMember<T> findSet(SetMember<T> member) {
        if(member.parent != member)
            member.parent = findSet(member.parent);
        return member.parent;
    }

    private void makeSet(SetMember<T> member) {
        member.parent = member;
        member.rank = 0;
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
    
    public static class SetMember<T> {
        SetMember<T> parent = null;
        T value;
        int rank;

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
