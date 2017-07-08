package Tree;

import Tree.BinaryTree.Node;

public class MirrorImage {
	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(50);
		tree.addBSTItr(30);
		tree.addBSTItr(70);
		tree.addBSTItr(5);
		tree.addBSTItr(45);
		tree.addBSTItr(60);
		tree.addBSTItr(80);

		System.out.println("Original Tree--");
		tree.inOrderTravarse(tree.root);
		System.out.println("\n After mirror image-- ");

		mirrorImage(tree.root);
		tree.inOrderTravarse(tree.root);
	}

	static void mirrorImage(Node root) {

		if (root != null) {
			mirrorImage(root.leftChild);
			mirrorImage(root.rightChild);

			Node temp = root.leftChild;
			root.leftChild = root.rightChild;
			root.rightChild = temp;
		}
	}
}
