package aula03;

public class NodeAssociation {
	
	public TreeAssociation tree;
	public int value;

	public NodeAssociation left;
	public NodeAssociation right;

	public NodeAssociation(int value) {
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

	public void setChilds(NodeAssociation left, NodeAssociation right) {
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
		return value + " ";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tree other = (Tree) obj;
		if (value != other.value)
			return false;
		return true;
	}
}
