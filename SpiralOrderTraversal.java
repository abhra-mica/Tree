package Tree;

import java.util.Stack;
import Tree.BinaryTree.Node;

public class SpiralOrderTraversal {

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

		spiralTraversal(tree.root);
	}

	// Method 1: Using two stacks
	public static void spiralTraversal(Node node) {
		Stack<Node> set1 = new Stack<>();
		Stack<Node> set2 = new Stack<>();

		System.out.print(node.data + "  "); // Root printed

		if (node.leftChild != null)
			set1.push(node.leftChild);
		if (node.rightChild != null)
			set1.push(node.rightChild);

		while (!set1.empty() || !set2.empty()) {
			while (!set1.empty()) {
				Node temp = set1.pop();
				if (temp.rightChild != null)
					set2.push(temp.rightChild);
				if (temp.leftChild != null)
					set2.push(temp.leftChild);
				System.out.print(temp.data + " ");
			}

			while (!set2.empty()) {
				Node temp = set2.pop();
				if (temp.leftChild != null)
					set1.push(temp.leftChild);
				if (temp.rightChild != null)
					set1.push(temp.rightChild);
				System.out.print(temp.data + " ");
			}
		}
	}
}
