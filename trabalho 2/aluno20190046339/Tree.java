package aluno20190046339;

import java.util.LinkedList;
import java.util.Objects;

public class Tree {

	public static void main(String[] args) {
		/**
		 * //q1
		 * Tree tree = new Tree();
		 * 		Tree tree2 = new Tree();
		 * 		tree.insert(5);
		 * 		tree.insert(6);
		 * 		tree.insert(7);
		 * 		tree2.insert(5);
		 * 		tree2.insert(6);
		 * 		tree2.insert(7);
		 * 		System.out.println(tree.equals(tree2));
		 */
		//q2
		Tree tree2 = new Tree();
		tree2.insert(12);
		tree2.insert(10);
		tree2.insert(11);
		tree2.insert(15);
		tree2.insert(13);
		tree2.insert(14);
		tree2.insert(16);
		tree2.insert(5);
		tree2.insert(4);
		tree2.insert(3);
		tree2.insert(8);
		tree2.insert(7);
		tree2.insert(9);
		tree2.insert(2);
		tree2.insert(1);
		tree2.insert(24);
		tree2.insert(23);
		tree2.insert(22);
		tree2.insert(21);


		System.out.println(tree2);
		System.out.println("---------------");
		tree2.removeSuccessor(tree2.root,tree2.root,13);
		tree2.removeSuccessor(tree2.root,tree2.root,10);
		tree2.removeSuccessor(tree2.root,tree2.root,5);
		System.out.println("---------------");

		System.out.println(tree2);

		System.out.println("---------------");
	}

	protected Node root;

	protected Node removeSuccessor(Node node, Node parent, int value){
		Node valueTree = node;
		if(node.value != value) {
			if (value > node.value) {
				valueTree = removeSuccessor(node.right, node.right, value);
			} else {
				valueTree = removeSuccessor(node.left, node.left, value);
			}
		}else{
			if(valueTree != null && !valueTree.hasRight()) return null;
			if (!valueTree.right.hasLeft()) {
				valueTree.right = valueTree.right.right;
				return valueTree.right;
			} else {
				if(!valueTree.right.left.hasLeft()) valueTree.right.left = valueTree.right.left.right;
				else {
					if(node == parent) parent = valueTree.right;
					if(parent.left.hasLeft()){
						return removeSuccessor(node,parent.left,value);
					}else{
						parent.left = parent.left.right;
						return parent.left;
					}
				}
			}
		}
		return valueTree;
	}

	public boolean insert(int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		} else {
			return insert(root, value);
		}
	}
	private boolean insert(Node node, int value) {
		if (value > node.value) {
			if (node.hasRight()) {
				return insert(node.right, value);
			} else {
				node.right = new Node(value);
			}
		} else if (value < node.value) {
			if (node.hasLeft()) {
				return insert(node.left, value);
			} else {
				node.left = new Node(value);
			}
		} else {
			return false; // contains value
		}
		return true;
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node node, int value) {
		if (node == null) {
			return false;
		} else {
			if (node.value == value) {
				return true;
			} else if (value > node.value) {
				return contains(node.right, value);
			} else if (value < node.value) {
				return contains(node.left, value);
			}
		}
		return false;
	}

	public boolean remove(int value) {
		return remove(root, null, value);
	}

	private boolean remove(Node node, Node parent, int value) {
		if (node == null) {
			return false;
		} else if (node.value == value) {
			if (node.isLeaf()) {
				updateChild(node, parent, null);
			} else if (node.hasLeft() && !node.hasRight()) {
				updateChild(node, parent, node.left);
			} else if (!node.hasLeft() && node.hasRight()) {
				updateChild(node, parent, node.right);
			} else {
				Node child = node.right;
				if (!child.hasLeft()) {
					child.left = node.left;
					updateChild(node, parent, child);
				} else {
					Node successor = removeSuccessor(child);
					successor.left = node.left;
					successor.right = node.right;
					updateChild(node, parent, successor);
				}
			}
		} else if (value > node.value) {
			return remove(node.right, node, value);
		} else if (value < node.value) {
			return remove(node.left, node, value);
		}
		return true;
	}

	private void updateChild(Node node, Node parent, Node child) {
		if (parent == null) {
			root = child;
		} else if (node.value > parent.value) {
			parent.right = child;
		} else if (node.value < parent.value) {
			parent.left = child;
		}
	}

	protected Node removeSuccessor(Node node) {
		if (!node.left.hasLeft()) {
			Node successor = node.left;
			node.left = successor.right;
			return successor;
		} else {
			return removeSuccessor(node.left);
		}
	}



	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root);
			inOrder(root.right);
		}
	}

	public void posOrder() {
		posOrder(root);
	}

	private void posOrder(Node root) {
		if (root != null) {
			posOrder(root.left);
			posOrder(root.right);
			System.out.print(root);
		}
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			if (current != null) {
				System.out.println(root);
				queue.addLast(current.left);
				queue.addLast(current.right);
			}
		}
	}

	public int height() {
		return height(root, 0);
	}

	private int height(Node node, int level) {
		if (node == null) { // root
			return level;
		}
		return Math.max(height(node.left, level + 1), height(node.right, level + 1));
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

	public String toString() {
		return toString(root, "", 0);
	}

	public String toString(Node current, String tabs, int level) {
		if (current == null) {
			return "";
		}
		String str = toString(current.right, tabs + "\t", level + 1);
		str += String.format("%s%s [Level:%d]\n", tabs, current, level + 1);
		str += toString(current.left, tabs + "\t", level + 1);
		return str;
	}

	@Override
	public int hashCode() {
		return Objects.hash(root);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tree obj = (Tree) o;
		return root != null && root.equals(obj.root);
	}

}
