package Tree;

import Tree.BinaryTree.Node;

public class Successor_Inorder {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(50);
		tree.addBSTItr(16);
		tree.addBSTItr(90);
		tree.addBSTItr(14);
		tree.addBSTItr(40);
		tree.addBSTItr(10);
		tree.addBSTItr(15);
		tree.addBSTItr(5);
		tree.addBSTItr(35);
		tree.addBSTItr(45);
		tree.addBSTItr(32);
		tree.addBSTItr(36);
		tree.addBSTItr(37);
		tree.addBSTItr(78);
		tree.addBSTItr(100);
		tree.addBSTItr(75);
		tree.addBSTItr(82);
		tree.addBSTItr(81);
		tree.addBSTItr(85);
		tree.addBSTItr(79);
		tree.addBSTItr(87);

		System.out.println(inorderSuccesor(tree.root, 100));
	}

	public static int inorderSuccesor(Node node, int data) {
		Node temp = BinaryTree.findNodeWithoutRec(node, data);
		int store = -1;
		if (temp.rightChild != null) {
			temp = temp.rightChild;
			while (temp.leftChild != null)
				temp = temp.leftChild;
			return temp.data;
		} else {
			while (node.data != data) {
				if (data < node.data) {
					store = node.data;
					node = node.leftChild;
				} else
					node = node.rightChild;
			}
		}
		return store;
	}
}
