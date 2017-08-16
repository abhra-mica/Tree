package Tree;

import java.util.LinkedList;
import java.util.Queue;
import Tree.BinaryTree.Node;

public class BToDoublyLL_BFS {
	static Node prev = null;
	static Node head = null;

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

		convertBFS(tree.root);
		printList(head);
	}

	static void convertBFS(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();

			if (temp.leftChild != null)
				queue.add(temp.leftChild);
			if (temp.rightChild != null)
				queue.add(temp.rightChild);

			if (prev == null)
				head = temp;
			else {
				temp.leftChild = prev;
				prev.rightChild = temp;
			}
			prev = temp;
		}
	}

	// Utility function for printing double linked list.
	static void printList(Node head) {
		System.out.println("Desired Double Linked List is : ");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.rightChild;
		}
	}
}
