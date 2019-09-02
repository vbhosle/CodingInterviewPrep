package questions.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrangementOfStudentChairs {

	public static void main(String[] args) {
		List<String> students = new ArrayList<>(Arrays.asList("s1", "s2", "s3", "s4", "s5"));
		List<String> chairs = new ArrayList<>(Arrays.asList("c1", "c2", "c3", "c4", "c5", "c6"));
		ArrangementOfStudentChairs solver = new ArrangementOfStudentChairs();
		long start = System.nanoTime();
		List<List<String>> combinations = solver.combination(chairs, students);
		long end = System.nanoTime();
		System.out.println("Time taken " + (end - start));
		System.out.println(combinations.size());
	}
	
	public List<List<String>> combination(List<String> chairs, List<String> students){
		if(chairs.isEmpty()) throw new IllegalArgumentException("No chairs");
		if(students.isEmpty()) throw new IllegalArgumentException("No students");
		if(chairs.size() < students.size()) throw new IllegalArgumentException("Not enough chairs for students");
		
		List<String> choices = new LinkedList<>(students);
		if(chairs.size() > students.size()) {
			choices.add("empty");
		}
		return combinationHelper(chairs, choices);
	}
	public List<List<String>> combinationHelper(List<String> remainingChairs,List<String> choices) {
		if(remainingChairs.isEmpty()) {
			List<List<String>> newList = getNewList();
			newList.add(getNewList());
			return newList;
		}
		
		String selectedChair = remainingChairs.remove(0);
		List<List<String>> result = new LinkedList<>();
		for(int i = 0; i< choices.size(); i++) {
			String choice = choices.remove(i);
			List<List<String>> combinationsSoFar = combinationHelper(remainingChairs, choices);
			combinationsSoFar.forEach(list -> list.add(0, selectedChair + "::" + choice));
			result.addAll(combinationsSoFar);
			choices.add(i, choice);
		}
		
		remainingChairs.add(0, selectedChair);
		return result;
	}

	public <T> List<T> getNewList() {
		return new ArrayList<>();
	}

}
