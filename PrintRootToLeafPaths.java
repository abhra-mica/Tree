import java.util.Stack;
import Tree.BinaryTree.Node;

public class PrintRootToLeafPaths {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(50);
		tree.addBSTItr(30);
		tree.addBSTItr(70);
		tree.addBSTItr(5);
		tree.addBSTItr(45);
		tree.addBSTItr(60);
		tree.addBSTItr(80);
		tree.addBSTItr(1);
		printPaths(tree.root, new Stack<Integer>());
	}

	static void printPaths(Node node, Stack<Integer> stack) {
		if (node == null)
			return;
		stack.push(node.data);
		printPaths(node.leftChild, stack);

		// Here we check if the right child is also null then we push it to the
		// stack
		if (node.leftChild == null && node.rightChild == null) {
			for (int i = 0; i < stack.size(); i++) {
				System.out.print(stack.get(i) + " ");
			}
		}
		printPaths(node.rightChild, stack);
		stack.pop();
		System.out.println();
	}
}
