package lab6.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public interface MyIterator<E> extends Iterator<E> {
boolean hasPrevious(); 
E previous(); 
void set(E e);
E current();
 
}