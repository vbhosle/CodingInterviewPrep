package questions.interview;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

public class PathFinderTest {

	@Test
	public void testWalkFromStart() {
		String[][] adjTable = new String[][] { 
			   { "A", "B" }, { "B", "C" }, { "B", "D" }
			   	, { "B", "C" }, { "B", "B1" }, { "B1", "C" }
			   	, { "C", "C1" }, { "B", "C" }, { "C", "C" } 
			   };
			   
		List<LinkedList<String>> paths = PathFinder.walkFromStart(adjTable);
		
		List<LinkedList<String>> expectedPaths = new ArrayList<>();
		expectedPaths.add(pathOf("A", "B", "C"));
		expectedPaths.add(pathOf("A", "B", "D"));
		expectedPaths.add(pathOf("A", "B", "C"));
		expectedPaths.add(pathOf("A", "B", "B1", "C", "C1"));
		expectedPaths.add(pathOf("A", "B", "C"));
		
		assertThat(paths, equalTo(expectedPaths));
		
	}
	
	private static LinkedList<String> pathOf(String source, String... nextNodes) {
		LinkedList<String> path = new LinkedList<>();
		path.add(source);
		for(String node: nextNodes) {
			path.add(node);
		}
		return path;
	}

}
