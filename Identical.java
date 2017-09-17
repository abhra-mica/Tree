package Tree;

import Tree.BinaryTree.Node;

public class Identical {
	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		bt1.addBSTItr(3);
		bt1.addBSTItr(6);
		bt1.addBSTItr(8);
		bt1.addBSTItr(2);
		bt1.addBSTItr(11);
		bt1.addBSTItr(13);
		bt1.addBSTItr(9);

		BinaryTree bt2 = new BinaryTree();
		bt2.addBSTItr(3);
		bt2.addBSTItr(6);
		bt2.addBSTItr(8);
		bt2.addBSTItr(2);
		bt2.addBSTItr(11);
		bt2.addBSTItr(13);
		bt2.addBSTItr(9);

		System.out.println(isIdentical(bt1.root, bt2.root));
	}

	public static boolean isIdentical(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 != null && node2 != null) {
			if (node1.data == node2.data
					&& isIdentical(node1.leftChild, node2.leftChild)
					&& isIdentical(node1.rightChild, node2.rightChild)) {
				return true;
			}
		}
		return false;
	}
}
