package lab6.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
public interface ListIterator<E> extends Iterator<E>{
	void hasPrevious(); void previous(); void set(E e);
	void add(E e);
	void nextIndex();
	void previousIndex(); }

