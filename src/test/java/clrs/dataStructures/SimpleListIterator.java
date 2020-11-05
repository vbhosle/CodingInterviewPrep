package clrs.dataStructures;

import java.util.Iterator;

public interface SimpleListIterator<T> extends Iterator<T>{
	boolean hasPrevious();
	T previous();
}
