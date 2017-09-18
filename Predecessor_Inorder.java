//Assumed that no node holding value of -1
package Tree;
import Tree.BinaryTree.Node;

public class Predecessor_Inorder {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(50);
		tree.addBSTItr(16);
		tree.addBSTItr(90);
		tree.addBSTItr(14);
		tree.addBSTItr(40);
		tree.addBSTItr(10);
		tree.addBSTItr(15);
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

		System.out.println(inOrderPredecessor(tree.root, 79));
	}

	public static int inOrderPredecessor(Node node, int data) {
		Node temp = BinaryTree.findNodeWithoutRec(node, data);
		int store = -1;
		if (temp != null) {
			if (temp.leftChild != null) {
				temp = temp.leftChild;
				while (temp.rightChild != null)
					temp = temp.rightChild;
				return temp.data;
			} else {
				while (node.data != data) {
					if (data > node.data) {
						store = node.data;
						node = node.rightChild;
					} else {
						node = node.leftChild;
					}
				}
			}
		}
		return store;
	}
}
