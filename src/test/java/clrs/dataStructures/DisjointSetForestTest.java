package clrs.dataStructures;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisjointSetForestTest {

    private DisjointSetForest.SetMember<String> nodeA;
    private DisjointSetForest.SetMember<String> nodeB;
    private DisjointSetForest.SetMember<String> nodeC;
    private DisjointSetForest.SetMember<String> nodeD;
    private DisjointSetForest.SetMember<String> nodeE;
    private DisjointSetForest.SetMember<String> nodeF;
    private DisjointSetForest.SetMember<String> nodeG;
    private DisjointSetForest.SetMember<String> nodeH;
    private DisjointSetForest.SetMember<String> nodeI;
    private DisjointSetForest.SetMember<String> nodeJ;
    private DisjointSetForest.SetMember<String> nodeK;
    
    @Before
    public void setup() {
        nodeA = new DisjointSetForest.SetMember<>("a");
        nodeB = new DisjointSetForest.SetMember<>("b");
        nodeC = new DisjointSetForest.SetMember<>("c");
        nodeD = new DisjointSetForest.SetMember<>("d");
        nodeE = new DisjointSetForest.SetMember<>("e");
        nodeF = new DisjointSetForest.SetMember<>("f");
        nodeG = new DisjointSetForest.SetMember<>("g");
        nodeH = new DisjointSetForest.SetMember<>("h");
        nodeI = new DisjointSetForest.SetMember<>("i");
        nodeJ = new DisjointSetForest.SetMember<>("j");
        nodeK = new DisjointSetForest.SetMember<>("k");    
    }
    
    @Test
    public void graphWithSingleConnectedComponent() {

        DisjointSetForest.Graph<String> graph = new DisjointSetForest.Graph<>(ImmutableSet.of(nodeA, nodeB, nodeC, nodeD, nodeE));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeA, nodeB));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeB, nodeC));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeC, nodeD));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeD, nodeE));

        DisjointSetForest<String> disjointSets = new DisjointSetForest<>();
        disjointSets.connectedComponents(graph);
        
//        assertThat("Node A set members", nodeA.set.getMembers(), equalTo(ImmutableSet.of(nodeA, nodeB, nodeC, nodeD, nodeE)));
        assertSameSet(disjointSets, graph.vertices);
    }
    
    public void assertSameSet(DisjointSetForest<String> disjointSets, Collection<DisjointSetForest.SetMember<String>> nodes) {
        Iterator<DisjointSetForest.SetMember<String>> iterator = nodes.iterator();
        DisjointSetForest.SetMember<String> node1 = iterator.next();
        while(iterator.hasNext())
            assertSameSet(disjointSets, node1, iterator.next());
    }
    
    public void assertSameSet(DisjointSetForest<String> disjointSets, DisjointSetForest.SetMember<String> node1, DisjointSetForest.SetMember<String> node2) {
        assertTrue(String.format("%s and %s are in the same set", node1.value, node2.value), disjointSets.sameComponent(node1, node2));
    }

    public void assertDifferentSet(DisjointSetForest<String> disjointSets, DisjointSetForest.SetMember<String> node1, DisjointSetForest.SetMember<String> node2) {
        assertFalse(String.format("%s and %s are NOT in the same set", node1.value, node2.value), disjointSets.sameComponent(node1, node2));
    }
    
    @Test
    public void graphWithFourConnectedComponentsBookExample1() {

        DisjointSetForest.Graph<String> graph = new DisjointSetForest.Graph<>(
                ImmutableSet.of(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH, nodeI, nodeJ)
        );
        graph.addEdge(new DisjointSetForest.Edge<>(nodeA, nodeB));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeA, nodeC));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeB, nodeC));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeB, nodeD));
        
        graph.addEdge(new DisjointSetForest.Edge<>(nodeE, nodeF));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeE, nodeG));

        graph.addEdge(new DisjointSetForest.Edge<>(nodeH, nodeI));

        DisjointSetForest<String> disjointSets = new DisjointSetForest<>();
        disjointSets.connectedComponents(graph);

        assertSameSet(disjointSets, ImmutableList.of(nodeA, nodeB, nodeC, nodeD));
        assertSameSet(disjointSets, ImmutableList.of(nodeE, nodeF, nodeG));
        assertSameSet(disjointSets, ImmutableList.of(nodeH, nodeI));
        assertSameSet(disjointSets, ImmutableList.of(nodeJ));
//        assertThat("Node A set members", nodeA.set.getMembers(), equalTo(ImmutableSet.of(nodeA, nodeB, nodeC, nodeD)));
//        assertThat("Node E set members", nodeE.set.getMembers(), equalTo(ImmutableSet.of(nodeE, nodeF, nodeG)));
//        assertThat("Node H set members", nodeH.set.getMembers(), equalTo(ImmutableSet.of(nodeH, nodeI)));
//        assertThat("Node J set members", nodeJ.set.getMembers(), equalTo(ImmutableSet.of(nodeJ)));
    }

    @Test
    public void graphWithFourConnectedComponentsBookExample2() {

        DisjointSetForest.Graph<String> graph = new DisjointSetForest.Graph<>(
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
        graph.addEdge(new DisjointSetForest.Edge<>(nodeD, nodeI));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeF, nodeK));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeG, nodeI));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeB, nodeG));

        graph.addEdge(new DisjointSetForest.Edge<>(nodeA, nodeH));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeI, nodeJ));

        graph.addEdge(new DisjointSetForest.Edge<>(nodeD, nodeK));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeB, nodeJ));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeD, nodeF));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeG, nodeJ));
        graph.addEdge(new DisjointSetForest.Edge<>(nodeA, nodeE));

        DisjointSetForest<String> disjointSets = new DisjointSetForest<>();
        disjointSets.connectedComponents(graph);

        assertSameSet(disjointSets, ImmutableList.of(nodeA, nodeH, nodeE));
        assertSameSet(disjointSets, ImmutableList.of(nodeB, nodeD, nodeI, nodeG, nodeJ, nodeF, nodeK));
        assertSameSet(disjointSets, ImmutableList.of(nodeC));
//        assertThat("Node A set members", nodeA.set.getMembers(), equalTo(ImmutableSet.of(nodeA, nodeH, nodeE)));
//        assertThat("Node B set members", nodeB.set.getMembers(), equalTo(ImmutableSet.of(nodeB, nodeD, nodeI, nodeG, nodeJ, nodeF, nodeK)));
//        assertThat("Node C set members", nodeC.set.getMembers(), equalTo(ImmutableSet.of(nodeC)));
    }
}