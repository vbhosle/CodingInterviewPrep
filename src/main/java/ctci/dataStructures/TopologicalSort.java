package ctci.dataStructures;

import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        Graph graph = buildGraph(edges);
        findBuildOrder(graph, sortedOrder);
        return sortedOrder;
    }

    private static void findBuildOrder(Graph graph, List<Integer> sortedOrder) {
        addNonDependentNodes(graph.getNodes(), sortedOrder);
        int toBeProcessed = 0;
        while(toBeProcessed < sortedOrder.size()) {
            Node current = graph.get(sortedOrder.get(toBeProcessed));
            List<Node> children = current.getChildren();
            for(Node child: children)
                child.decrementDependency();
            addNonDependentNodes(children, sortedOrder);
            toBeProcessed++;
        }
    }

    private static void addNonDependentNodes(List<Node> nodes, List<Integer> sortedOrder) {
        for(Node node: nodes) {
            if(node.dependenciesCount() == 0)
                sortedOrder.add(node.label);
        }
    }

    private static Graph buildGraph(int[][] edges) {
        Graph graph = new Graph();
        for(int[] edge: edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        return graph;
    }
    static class Graph {
        private List<Node> nodes = new ArrayList<>();
        private Map<Integer, Node> map = new HashMap<>();

        private Node getOrCreate(int label) {
            if(!map.containsKey(label)) {
                map.put(label, new Node(label));
                nodes.add(map.get(label));
            }

            return map.get(label);
        }

        public Node get(int label) {
            return map.get(label);
        }

        public void addEdge(int start, int end) {
            Node startNode = getOrCreate(start);
            Node endNode = getOrCreate(end);
            startNode.addChild(endNode);
        }

        public List<Node> getNodes() {
            return this.nodes;
        }
    }

    static class Node {
        private int label;
        private List<Node> children = new ArrayList<>();
        private int dependencies = 0;

        Node(int label) {
            this.label = label;
        }

        public void addChild(Node child) {
            children.add(child);
            child.incrementDependency();
        }

        public List<Node> getChildren() {
            return children;
        }

        public int dependenciesCount() {
            return dependencies;
        }

        public void incrementDependency() {
            this.dependencies++;
        }

        public void decrementDependency() {
            this.dependencies--;
        }
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}