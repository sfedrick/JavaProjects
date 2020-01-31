package lab7.Binarytrees;

public class Main {
	public static void main(String arg[]) {
		
		int[] list={6, 4, 2, 7, 3, 9, 8, 5};
		BinaryTree<Integer> tree= new BinaryTree();
		for(int i:list){
			tree.insert(i);
			
		}
		tree.printInOrder();
		System.out.println();
		System.out.println(tree.contains(2));
		System.out.println(tree.contains(11));
		System.out.println(tree.height());
	}

}
