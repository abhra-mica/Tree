package Tree;

import java.util.ArrayList;
import java.util.List;

import Tree.BinaryTree.Node;

public class RootToLeafSum {
	public static void main(String[] args) {
		List<Integer> result = new ArrayList<>();

		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(3);
		tree.addBSTItr(6);
		tree.addBSTItr(8);
		tree.addBSTItr(2);
		tree.addBSTItr(11);
		tree.addBSTItr(13);
		tree.addBSTItr(9);

		int sum = 37;

		rootToLeafSum(tree.root, sum, result);
		System.out.println(result);

	}

	public static boolean rootToLeafSum(Node root, int sum, List<Integer> result) {
		if (root == null)
			return false;

		// Leaf Node check
		if (root.leftChild == null && root.rightChild == null) {
			if (root.data == sum) {
				result.add(root.data);
				return true;
			} else {
				return false;
			}
		}

		if (rootToLeafSum(root.leftChild, sum - root.data, result)) {
			result.add(root.data);
			return true;
		}
		if (rootToLeafSum(root.rightChild, sum - root.data, result)) {
			result.add(root.data);
			return true;
		}
		return false;
	}
}
