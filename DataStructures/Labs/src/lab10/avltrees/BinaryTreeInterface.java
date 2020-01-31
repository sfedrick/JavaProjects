package lab10.avltrees;

public interface BinaryTreeInterface<E extends Comparable<E>> {
    int size();
    boolean isEmpty();
    void insert(E element);
    boolean contains(E element);    
    int height();
    void printInOrder();
}
