package clrs.dataStructures;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DisjointSetWithLinkedListTest {

    private DisjointSetWithLinkedList.SetMember<String> nodeA;
    private DisjointSetWithLinkedList.SetMember<String> nodeB;
    private DisjointSetWithLinkedList.SetMember<String> nodeC;
    private DisjointSetWithLinkedList.SetMember<String> nodeD;
    private DisjointSetWithLinkedList.SetMember<String> nodeE;
    private DisjointSetWithLinkedList.SetMember<String> nodeF;
    private DisjointSetWithLinkedList.SetMember<String> nodeG;
    private DisjointSetWithLinkedList.SetMember<String> nodeH;
    private DisjointSetWithLinkedList.SetMember<String> nodeI;
    private DisjointSetWithLinkedList.SetMember<String> nodeJ;
    private DisjointSetWithLinkedList.SetMember<String> nodeK;
    
    public void setup() {
        nodeA = new DisjointSetWithLinkedList.SetMember<>("a");
        nodeB = new DisjointSetWithLinkedList.SetMember<>("b");
        nodeC = new DisjointSetWithLinkedList.SetMember<>("c");
        nodeD = new DisjointSetWithLinkedList.SetMember<>("d");
        nodeE = new DisjointSetWithLinkedList.SetMember<>("e");
        nodeF = new DisjointSetWithLinkedList.SetMember<>("f");
        nodeG = new DisjointSetWithLinkedList.SetMember<>("g");
        nodeH = new DisjointSetWithLinkedList.SetMember<>("h");
        nodeI = new DisjointSetWithLinkedList.SetMember<>("i");
        nodeJ = new DisjointSetWithLinkedList.SetMember<>("j");
        nodeK = new DisjointSetWithLinkedList.SetMember<>("k");    
    }
    
    @Test
    public void graphWithSingleConnectedComponent() {

        DisjointSetWithLinkedList.Graph<String> graph = new DisjointSetWithLinkedList.Graph<>(ImmutableSet.of(nodeA, nodeB, nodeC, nodeD, nodeE));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeA, nodeB));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeB, nodeC));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeC, nodeD));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeD, nodeE));

        DisjointSetWithLinkedList<String> disjointSets = new DisjointSetWithLinkedList<>();
        disjointSets.connectedComponents(graph);
        
        assertThat("Node A set members", nodeA.set.getMembers(), equalTo(ImmutableSet.of(nodeA, nodeB, nodeC, nodeD, nodeE)));
        assertSameSet(disjointSets, graph.vertices);
    }
    
    public void assertSameSet(DisjointSetWithLinkedList<String> disjointSets, Collection<DisjointSetWithLinkedList.SetMember<String>> nodes) {
        Iterator<DisjointSetWithLinkedList.SetMember<String>> iterator = nodes.iterator();
        DisjointSetWithLinkedList.SetMember<String> node1 = iterator.next();
        while(iterator.hasNext())
            assertSameSet(disjointSets, node1, iterator.next());
    }
    
    public void assertSameSet(DisjointSetWithLinkedList<String> disjointSets, DisjointSetWithLinkedList.SetMember<String> node1, DisjointSetWithLinkedList.SetMember<String> node2) {
        assertTrue(String.format("%s and %s are in the same set", node1.value, node2.value), disjointSets.sameComponent(node1, node2));
    }

    public void assertDifferentSet(DisjointSetWithLinkedList<String> disjointSets, DisjointSetWithLinkedList.SetMember<String> node1, DisjointSetWithLinkedList.SetMember<String> node2) {
        assertFalse(String.format("%s and %s are NOT in the same set", node1.value, node2.value), disjointSets.sameComponent(node1, node2));
    }
    
    @Test
    public void graphWithFourConnectedComponentsBookExample1() {

        DisjointSetWithLinkedList.Graph<String> graph = new DisjointSetWithLinkedList.Graph<>(
                ImmutableSet.of(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH, nodeI, nodeJ)
        );
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeA, nodeB));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeA, nodeC));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeB, nodeC));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeB, nodeD));
        
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeE, nodeF));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeE, nodeG));

        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeH, nodeI));

        DisjointSetWithLinkedList<String> disjointSets = new DisjointSetWithLinkedList<>();
        disjointSets.connectedComponents(graph);

        assertThat("Node A set members", nodeA.set.getMembers(), equalTo(ImmutableSet.of(nodeA, nodeB, nodeC, nodeD)));
        assertThat("Node E set members", nodeE.set.getMembers(), equalTo(ImmutableSet.of(nodeE, nodeF, nodeG)));
        assertThat("Node H set members", nodeH.set.getMembers(), equalTo(ImmutableSet.of(nodeH, nodeI)));
        assertThat("Node J set members", nodeJ.set.getMembers(), equalTo(ImmutableSet.of(nodeJ)));
    }

    @Test
    public void graphWithFourConnectedComponentsBookExample2() {

        DisjointSetWithLinkedList.Graph<String> graph = new DisjointSetWithLinkedList.Graph<>(
                ImmutableSet.of(
                        nodeA, 
                        nodeB, 
                        nodeC, 
                        nodeD, 
                        nodeE, 
                        nodeF, 
                        nodeG, 
                        nodeH, 
                        nodeI, 
                        nodeJ, 
                        nodeK)
        );
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeD, nodeI));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeF, nodeK));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeG, nodeI));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeB, nodeG));

        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeA, nodeH));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeI, nodeJ));

        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeD, nodeK));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeB, nodeJ));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeD, nodeF));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeG, nodeJ));
        graph.addEdge(new DisjointSetWithLinkedList.Edge<>(nodeA, nodeE));

        DisjointSetWithLinkedList<String> disjointSets = new DisjointSetWithLinkedList<>();
        disjointSets.connectedComponents(graph);

        assertThat("Node A set members", nodeA.set.getMembers(), equalTo(ImmutableSet.of(nodeA, nodeH, nodeE)));
        assertThat("Node B set members", nodeB.set.getMembers(), equalTo(ImmutableSet.of(nodeB, nodeD, nodeI, nodeG, nodeJ, nodeF, nodeK)));
        assertThat("Node C set members", nodeC.set.getMembers(), equalTo(ImmutableSet.of(nodeC)));
    }
}