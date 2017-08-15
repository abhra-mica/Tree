package Tree;

import java.util.LinkedList;
import java.util.Queue;
import Tree.BinaryTree.Node;

public class DiagonalSum {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(20);
		tree.addBSTItr(10);
		tree.addBSTItr(5);
		tree.addBSTItr(15);
		tree.addBSTItr(2);
		tree.addBSTItr(7);
		tree.addBSTItr(30);
		tree.addBSTItr(25);
		tree.addBSTItr(35);

		diagonalSum(tree.root);
	}

	public static void diagonalSum(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);

		int sum = 0;
		while (!queue.isEmpty()) {
			Node temp = queue.poll();

			if (temp == null) {// This means One diagonal sum completed
				System.out.println(sum);
				queue.add(null);
				temp = queue.poll();
				sum = 0;
				if (temp == null)// This line executes when full tree completed traversal
					break;
			}

			while (temp != null) {
				sum = sum + temp.data;
				if (temp.leftChild != null)
					queue.add(temp.leftChild);
				temp = temp.rightChild;
			}
		}
	}
}
