package Tree;

import Tree.BinaryTree.Node;

public class SumTree {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = bt.new Node(56);
		bt.root.leftChild = bt.new Node(13);
		bt.root.rightChild = bt.new Node(15);

		bt.root.leftChild.leftChild = bt.new Node(5);
		bt.root.leftChild.rightChild = bt.new Node(3);

		bt.root.leftChild.leftChild.leftChild = bt.new Node(3);
		bt.root.leftChild.leftChild.rightChild = bt.new Node(2);

		bt.root.rightChild.leftChild = bt.new Node(9);
		bt.root.rightChild.rightChild = bt.new Node(3);

		bt.root.rightChild.rightChild.leftChild = bt.new Node(2);
		bt.root.rightChild.rightChild.rightChild = bt.new Node(1);

		if (sumTree(bt.root) == 1)
			System.out.println("It is a sum tree");
		else
			System.out.println("It is not a sum tree");
	}

	static int sumTree(Node node) {
		if (node == null)
			return 1;
		if (node.leftChild == null && node.rightChild == null)
			return 1;

		int leftSum = BinaryTree.sumAllNodes(node.leftChild);
		int rightSum = BinaryTree.sumAllNodes(node.rightChild);
		int total = leftSum + rightSum;

		if (node.data == total) {
			if (sumTree(node.leftChild) == 1 && sumTree(node.rightChild) == 1)
				return 1;
		}
		return 0;
	}
}
