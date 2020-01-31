package lab5.stack_queue;

public interface  Stack<E> {
	int size();
	boolean isEmpty();
	void push(int id,E e);
	E top();
	E pop();
}
