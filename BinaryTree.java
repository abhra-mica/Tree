package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	public Node root;

	class Node {
		Node leftChild;
		Node rightChild;
		int data;

		Node(int data) {
			this.data = data;
		}

		public String toString() {
			return "" + data;
		}
	}

	// 1>Add childs in a BST in iterative way

	public void addBSTItr(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;

			while (true) {
				parent = focusNode;
				if (data < focusNode.data) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else if (data > focusNode.data) {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	/* 3>In Order traversal */

	public void inOrderTravarse(Node focusNode) {
		if (root == null)
			System.out.println("Empty Tree");
		if (focusNode != null) {
			inOrderTravarse(focusNode.leftChild);
			System.out.print(focusNode + "--> ");
			inOrderTravarse(focusNode.rightChild);
		}
	}

	/* 4>Pre OrderTraversal */
	public void preOrderTraverse(Node focusNode) {
		if (root == null)
			System.out.println("Empty Tree");
		if (focusNode != null) {
			System.out.println(focusNode);
			preOrderTraverse(focusNode.leftChild);
			preOrderTraverse(focusNode.rightChild);
		}
	}

	/* 5> Post Order Traversal */
	public void postOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverse(focusNode.leftChild);
			postOrderTraverse(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}

	/*
	 * 6>Method to print height of a tree, here we are considering number or
	 * edges that's why we are returning -1 within base condition if we consider
	 * nodes as the height of a tree then we can return 0 within base condition.
	 */
	public int height(Node focusNode) {
		if (focusNode == null) {
			return -1;
		} else {
			int lHeight = height(focusNode.leftChild);
			int rHeight = height(focusNode.rightChild);
			return max(lHeight, rHeight) + 1;
		}
	}

	/*
	 * 7>Method to decide maximum between two numbers,it can act as a helping
	 * method in height method defined above.
	 */
	int max(int lHeight, int rHeight) {
		if (lHeight > rHeight)
			return lHeight;
		else
			return rHeight;
	}

	/* 8> Method to traverse Tree through level order means Breadth First Search */
	public void levelOrderTraversal(Node node) {
		Queue<Node> queue = new LinkedList<>();

		if (root == null) {
			System.out.println("Empty String");
			return;
		}

		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp.leftChild != null)
				queue.add(temp.leftChild);
			if (temp.rightChild != null)
				queue.add(temp.rightChild);
			System.out.print(temp + " --> ");
		}
	}

	/*
	 * 9> Search an element in a BT in Non Recursive way. We follow the similar
	 * process what we follow in levelOrderTraversal.Using a queue to store and
	 * check.
	 */

	boolean findNodeWithoutRec(Node node, int data) {
		Queue<Node> queue = new LinkedList();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp.data == data)
				return true;
			if (temp.leftChild != null)
				queue.add(temp.leftChild);
			if (temp.rightChild != null)
				queue.add(temp.rightChild);
		}
		return false;
	}

	/*
	 * 10>Search an element in a BT in Recursive way.We follow the in order
	 * traversal,We can follow others also like pre order, post order etc.
	 */

	boolean findNodeWithRec(Node node, int data) {
		if (node != null) {
			if (node.data == data)
				return false;
			else
				return findNodeWithRec(node.leftChild, data)
						|| findNodeWithRec(node.rightChild, data);
		}
		return false;
	}

}
