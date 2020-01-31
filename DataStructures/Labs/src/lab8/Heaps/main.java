package lab8.Heaps;

public class main {
	public static void main(String arg[]) {
		ArrayBinaryTree<Integer> tree= new ArrayBinaryTree();
		ArrayHeap<Integer> heap= new ArrayHeap();
		for(int i=0; i<=20;i++) {
			tree.insert((Integer)i);
		}
		System.out.println(tree.size());
		System.out.println(tree.toStringBreadthFirst());
		System.out.println(tree.remove(0));
		System.out.println(tree.toStringBreadthFirst());
		System.out.println(tree.remove(19));
		System.out.println(tree.toStringBreadthFirst());
		System.out.println(tree.remove(17));
		System.out.println(tree.toStringBreadthFirst());
		System.out.println(tree.remove(77));
		System.out.println(tree.toStringBreadthFirst());
		tree.insert(88);
		System.out.println(tree.getRootElement());
		
		
		for(int i=0; i<=9;i++) {
			heap.insert((Integer)i);
		}
		System.out.println(heap.toStringBreadthFirst());
		System.out.println("removing 2");
		heap.remove(2);
		System.out.println(heap.toStringBreadthFirst());
		System.out.println("removing 3");
		heap.remove(3);
		System.out.println(heap.toStringBreadthFirst());
		System.out.println("removing 4");
		heap.remove(4);
		System.out.println(heap.toStringBreadthFirst());
	}
	
}
