package Tree;
import Tree.BinaryTree.Node;

public class BTtoDoublyLL_InOrder {
	static Node prev = null;// Holds current node while traversing the tree
	static Node head ;//Hold linked list head node

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(20);
		tree.addBSTItr(10);
		tree.addBSTItr(5);
		tree.addBSTItr(15);
		tree.addBSTItr(2);
		tree.addBSTItr(7);
		tree.addBSTItr(30);
		tree.addBSTItr(25);
		tree.addBSTItr(35);

		convert(tree.root);
		printList(head);
	}

	public static void convert(Node node) {
		if (node == null)// break condition for recursion
			return;

		convert(node.leftChild);// Recursively traverse to left subtree
		
		if (prev == null) {
			head = node;
		} else {
			node.leftChild = prev;
			prev.rightChild = node;
		}
		prev = node;
		
		convert(node.rightChild);
	}

	// Utility function for printing double linked list.
	static void printList(Node head) {
		System.out.println("Extracted Double Linked List is : ");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.rightChild;
		}
	}
}
