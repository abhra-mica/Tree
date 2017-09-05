package Tree;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
//Root node of Binary Tree
	public Node root;
	
	//Inner class that represent node structure
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

	// 2> Add child in BST in recursive way
	public void addRecursive(int data) {
		Node node = root;
		addRecSup(node, data);
	}

	public void addRecSup(Node node, int data) {
		if (node == null)
			return;
		if (data > node.data) {
			addRecSup(node.rightChild, data);
			if (node.rightChild == null)// check from recursive call,otherwise we will get stale data
				node.rightChild = new Node(data);
		}
		if (data < node.data) {
			addRecSup(node.leftChild, data);
			if (node.leftChild == null)// check from recursive call,otherwise we will get stale datas
				node.leftChild = new Node(data);
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
	 * 6>Method to print height of a tree, here we are considering number of
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
	 * Method to decide maximum between two numbers,it can act as a helping
	 * method in height method defined above.
	 */
	int max(int lHeight, int rHeight) {
		if (lHeight > rHeight)
			return lHeight;
		else
			return rHeight;
	}

	/* 7> Method to traverse Tree through level order means Breadth First Search */
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
	 * 8> Search an element in a BT in Non Recursive way. We follow the similar
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
	 * 9>Search an element in a BT in Recursive way.We follow the in order
	 * traversal,We can follow others also like pre order, post order etc.
	 */

	boolean findNodeWithRec(Node node, int data) {
		if (node != null) {
			if (node.data == data)
				return true;
			else
				return findNodeWithRec(node.leftChild, data)
						|| findNodeWithRec(node.rightChild, data);
		}
		return false;
	}
	
	//10> Diameter of a binary tree
	public static int diameter(Node node) {
		if (node == null)
			return 0;
		int lHeight = BinaryTree.height(node.leftChild);
		int rHeight = BinaryTree.height(node.rightChild);

		int lDiameter = diameter(node.leftChild);
		int rDiameter = diameter(node.rightChild);
		int fd = max(lHeight + rHeight + 1, max(lDiameter, rDiameter));
		return fd;
	}

}
