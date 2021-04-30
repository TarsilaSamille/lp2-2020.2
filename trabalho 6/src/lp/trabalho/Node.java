package lp.trabalho;

public class Node implements Comparable<Node>{

	public char value;
	String codification;
	int data;
	int freq;
	public Node left;
	public Node right;

	public Node(int k, char c) {
		data = k;
		value = c;
		codification = "";
		left = right = null;
	}

	public Node() {
		data = 0;
		value = ' ';
		codification = "";
		left = right = null;
	}
	Node(char value, int freq, Node left, Node right) {
		this.value = value;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}


	public Node(char value) {
		this.value = value;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void setChilds(Node left, Node right) {
		this.left = left;
		this.right = right;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	public String toString() {
		return String.valueOf(value);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (value != other.value)
			return false;
		return true;
	}

	static Node get(Node node, String code) {
		Node r,l,n = node;

		if(node.codification != null && node.codification.equals(code)) {
			return node;
		} else if(node.isLeaf()){
			return null;
		} else {
			r = get(node.right, code);
			l = get(node.left, code);
		}
		return r != null ? r : l ;
	}

	private void codificaNode(String path) {
		if ((left == null) && (right == null)) codification = path;

		if (left != null) left.codificaNode(path + '0');
		if (right != null) right.codificaNode(path + '1');
	}

	public static void geraCodificacao(Node tree) {
		tree.codificaNode("");
	}
	@Override
	public int compareTo(Node o) {
		return this.freq - o.freq;
	}
}
