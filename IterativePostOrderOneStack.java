package Tree;

import java.util.Stack;
import Tree.BinaryTree.Node;

public class IterativePostOrderOneStack {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(10);
		tree.addBSTItr(-6);
		tree.addBSTItr(15);
		tree.addBSTItr(8);
		tree.addBSTItr(9);
		tree.addBSTItr(18);

		postOneStack(tree.root);
	}

	static void postOneStack(Node node) {
		Stack<Node> stack = new Stack<>();
		Node current = node;

		while (current != null || !stack.isEmpty()) {
			// If block is taking care of the left children
			if (current != null) {
				stack.push(current);
				current = current.leftChild;
			} else { // The else block take care right children when that node
						// don't have any left child
				Node temp = stack.peek().rightChild;
				if (temp == null) {
					temp = stack.pop();
					System.out.print(temp.data + " ");

					while (!stack.isEmpty()
							&& temp.data == stack.peek().rightChild.data) {
						temp = stack.pop();
						System.out.print(temp.data + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}
}
