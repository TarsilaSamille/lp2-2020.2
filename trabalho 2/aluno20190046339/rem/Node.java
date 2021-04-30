package aluno20190046339.rem;

public class Node {

	public int value;

	public Node left;
	public Node right;
	public Node parent;

	public Node(int value) {
		this.value = value;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public boolean hasParent() {
		return parent != null;
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
		return Integer.toString(value);
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
		return (left == null || left.equals(other.left))
				&& (right == null || right.equals(other.right));
	}
}