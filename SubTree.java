package Tree;

import Tree.BinaryTree.Node;

public class SubTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(3);
		tree.addBSTItr(6);
		tree.addBSTItr(8);
		tree.addBSTItr(2);
		tree.addBSTItr(11);
		tree.addBSTItr(13);
		tree.addBSTItr(9);

		BinaryTree sub = new BinaryTree();
		sub.addBSTItr(11);
		sub.addBSTItr(13);
		sub.addBSTItr(9);

		System.out.println(isSubtree(tree.root, sub.root));
	}

	public static boolean isSubtree(Node node, Node sub) {
		if (sub == null)
			return true;
		if (node == null)
			return false;
		if (Identical.isIdentical(node, sub))
			return true;

		return isSubtree(node.leftChild, sub)
				|| isSubtree(node.rightChild, sub);
	}
}
