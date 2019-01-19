// This class Holds Node and it's Horizontal Distance value
It's used problem line Vertical Traversal, Bottom View
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