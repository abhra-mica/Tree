import Tree.BinaryTree.Node;
public class LCA_BST {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(10);
		tree.addBSTItr(-10);
		tree.addBSTItr(8);
		tree.addBSTItr(6);
		tree.addBSTItr(9);
		tree.addBSTItr(30);
		tree.addBSTItr(25);
		tree.addBSTItr(60);
		tree.addBSTItr(28);
		tree.addBSTItr(78);
		System.out.println(lca(tree.root, 6, 9));
	}

	static int lca(Node node, int n1, int n2) {
		if (node.data > Math.max(n1, n2))
			return lca(node.leftChild, n1, n2);
		if (node.data < Math.min(n1, n2))
			return lca(node.rightChild, n1, n2);
		return node.data;
	}
}
