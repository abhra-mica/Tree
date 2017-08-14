package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

import Tree.BinaryTree.Node;

public class VerticalTraversal {
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

		verticalTraversal(tree.root);

	}

	public static void verticalTraversal(Node node) {
		// Queue to traverse tree and store Node with it's Horizontal Distance.
		Queue<NodeHDPair> queue = new LinkedList<>();
		// Map hold Horizontal distance as key and nodes list as value
		Map<Integer, List<Node>> hashTable = new TreeMap<>();

		// Add root node to the queue
		queue.add(new NodeHDPair(node, 0));

		while (!queue.isEmpty()) {
			// Remove queue's top element and check if it have left , right
			// child then add in queue with respective HD value
			NodeHDPair temp = queue.poll();

			if (temp.getNode().leftChild != null) {
				queue.add(new NodeHDPair(temp.getNode().leftChild,
						temp.getHd() - 1));
			}

			if (temp.getNode().rightChild != null) {
				queue.add(new NodeHDPair(temp.getNode().rightChild, temp
						.getHd() + 1));
			}

			// Populating hash table with HD and respective nodes
			List<Node> list = null;
			if (hashTable.containsKey(temp.getHd())) {
				list = hashTable.get(temp.getHd());
			} else {
				list = new ArrayList<>();
			}
			list.add(temp.getNode());
			hashTable.put(temp.getHd(), list);
		}

		// Print HD with it's respective nodes
		Set<Integer> keys = hashTable.keySet();
		for (Integer key : keys) {
			System.out.println("HD: " + key + " Nodes: " + hashTable.get(key));
		}

	}
}

// This class Holds Node and it's Horizontal Distance value
class NodeHDPair {
	Node node;
	int hd;

	public NodeHDPair(Node node, int hd) {
		this.node = node;
		this.hd = hd;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

}
