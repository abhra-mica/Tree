import Tree.BinaryTree.Node;

public class IsBTaBST {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(3);
		tree.addBSTItr(6);
		tree.addBSTItr(8);
		tree.addBSTItr(2);
		tree.addBSTItr(11);
		tree.addBSTItr(13);
		tree.addBSTItr(9);
		System.out.println(isBST(tree.root, Integer.MIN_VALUE,
				Integer.MAX_VALUE));
	}

	public static boolean isBST(Node node, int min, int max) {
		if (node == null)
			return true;
		if (node.data <= min || node.data > max)
			return false;
		return isBST(node.leftChild, min, node.data)
				&& isBST(node.rightChild, node.data, max);
	}
}
