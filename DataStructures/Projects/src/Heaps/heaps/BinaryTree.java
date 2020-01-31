package homework7.heaps;

public interface BinaryTree<E extends Comparable<E>> {
	 int size();
	 boolean isEmpty();
	 void insert(E element);
	 boolean contains(E element);    
	 int height();
	 void printInOrder();
}
