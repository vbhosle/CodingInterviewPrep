package ctci.dataStructures;

import java.util.*;

class TopologicalSortDFS {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        Graph graph = buildGraph(edges);
        Stack<Integer> stack = findBuildOrder(graph);
        while(!stack.isEmpty())
            sortedOrder.add(stack.pop());
        return sortedOrder;
    }

    private static Stack<Integer> findBuildOrder(Graph graph) {
        Stack<Integer> stack = new Stack<>();
        for(Node node: graph.getNodes()) {
            if(!doDFS(node, stack))
                return new Stack<>();
        }

        return stack;
    }

    private static boolean doDFS(Node node, Stack<Integer> stack) {
        if(node.getState() == State.PARTIAL)
            return false;

        if(node.getState() == State.COMPLETED)
            return true;
        node.setState(State.PARTIAL);
        for(Node child: node.getChildren()) {
            if(!doDFS(child, stack))
                return false;
        }
        node.setState(State.COMPLETED);
        stack.push(node.getLabel());
        return true;
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

    static enum State {
        BLANK, PARTIAL, COMPLETED
    }

    static class Node {
        private int label;
        private List<Node> children = new ArrayList<>();
        private State state = State.BLANK;

        Node(int label) {
            this.label = label;
        }

        public void addChild(Node child) {
            children.add(child);
        }

        public State getState() {
            return this.state;
        }

        public void setState(State state) {
            this.state = state;
        }
        public List<Node> getChildren() {
            return children;
        }

        public int getLabel() {
            return this.label;
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