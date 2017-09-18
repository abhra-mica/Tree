package Tree;
import Tree.BinaryTree.Node;

public class Isomorphic {
	public static void main(String[] args) {

		BinaryTree tree1 = new BinaryTree();
		tree1.addBSTItr(3);
		tree1.addBSTItr(6);
		tree1.addBSTItr(8);
		tree1.addBSTItr(2);
		tree1.addBSTItr(11);
		tree1.addBSTItr(13);
		tree1.addBSTItr(9);

		BinaryTree tree2 = new BinaryTree();

		tree2.root = tree2.new Node(3);
		tree2.root.leftChild = tree2.new Node(6);
		tree2.root.leftChild.leftChild = tree2.new Node(8);
		tree2.root.leftChild.leftChild.leftChild = tree2.new Node(11);
		tree2.root.leftChild.leftChild.leftChild.leftChild = tree2.new Node(13);
		tree2.root.leftChild.leftChild.leftChild.rightChild = tree2.new Node(9);
		tree2.root.rightChild = tree2.new Node(2);
		
		System.out.println(isIsomorphic(tree1.root, tree2.root));
	}

	public static boolean isIsomorphic(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;
		if (node1.data != node2.data)
			return false;

		if (isIsomorphic(node1.leftChild, node2.leftChild)
				&& isIsomorphic(node1.rightChild, node2.rightChild)
				|| isIsomorphic(node1.leftChild, node2.rightChild)
				&& isIsomorphic(node1.rightChild, node2.leftChild))
			return true;

		return false;
	}
}
