package Tree;
import java.util.LinkedList;
import java.util.Stack;
import Tree.BinaryTree.Node;

public class ReverseLevelOrderTraversal {

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

		reverseLevelTraversal(tree.root);
	}

	public static void reverseLevelTraversal(Node node) {
		LinkedList<Node> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();

		queue.add(node);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			stack.add(temp.data);
			if (temp.rightChild != null)
				queue.add(temp.rightChild);
			if (temp.leftChild != null)
				queue.add(temp.leftChild);
		}
		
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.print(stack.get(i) + " ");
		}
	}

}
