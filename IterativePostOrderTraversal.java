import java.util.Stack;
import Tree.BinaryTree.Node;

public class IterativePostOrderTraversal {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(3);
		tree.addBSTItr(6);
		tree.addBSTItr(8);
		tree.addBSTItr(2);
		tree.addBSTItr(11);
		tree.addBSTItr(13);
		tree.addBSTItr(9);
		tree.addBSTItr(5);
		tree.addBSTItr(7);

		postTraversal(tree.root);
	}

	public static void postTraversal(Node node) {
		Stack<Node> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		stack1.push(node);
		while (!stack1.isEmpty()) {
			Node temp = stack1.pop();
			stack2.push(temp.data);

			if (temp.leftChild != null)
				stack1.push(temp.leftChild);
			if (temp.rightChild != null)
				stack1.push(temp.rightChild);
		}

		for (int i = 0; i < stack2.size(); i++)
			System.out.print(stack2.get(i) + " ");
	}
}
