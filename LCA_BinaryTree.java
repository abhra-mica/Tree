package Tree;

import Tree.BinaryTree.Node;

public class LCA_BinaryTree {
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

		System.out.println(lca(tree.root, 2, 5));

	}

	static Node lca(Node node, int n1, int n2) {
		if (node == null)
			return null;

		if (node.data == n1 || node.data == n2)
			return node;

		Node left = lca(node.leftChild, n1, n2);
		Node right = lca(node.rightChild, n1, n2);

		if (left != null && right != null)
			return node;

		if (left == null && right == null)
			return null;

		return left != null ? left : right;
	}

}
