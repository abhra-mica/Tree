
import java.util.Stack;
import Tree.BinaryTree.Node;

public class InOrderTraversalUsingTwoStack {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addBSTItr(50);
		tree.addBSTItr(30);
		tree.addBSTItr(70);
		tree.addBSTItr(5);
		tree.addBSTItr(45);
		tree.addBSTItr(60);
		tree.addBSTItr(80);
		tree.addBSTItr(1);

		inOrderTraverse(tree.root);
	}

	public static void inOrderTraverse(Node node) {
		Stack<Node> stack1 = new Stack<>(); // Hold nodes for traversing
		Stack<Integer> stack2 = new Stack<>(); // Hold integer values in in-order format

		while (true) {
			// Below while loops traverse until nodes left child reaches to null
			while (node != null) {
				stack1.push(node);
				node = node.leftChild;
			}
			// Break condition for exiting the outer while loop when the stack 1
			// become empty that's means tree traversal completed
			if (stack1.isEmpty())
				break;
			// when left child reaches to null and stack is not empty then push
			// top element from stack 1 to stack 2 and start processing poped
			// elements right child
			Node temp = stack1.pop();
			stack2.push(temp.data);
			node = temp.rightChild;
		}
		// Print Stack 2
		for (int i = 0; i <stack2.size(); i++) {
			System.out.print(stack2.get(i) + " ");
		}
	}
}
