package com.company;

import java.util.LinkedList;

public class BinarySearchTree {

	protected Node root;
	public int value;

	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();
		tree.inOrder();
		tree.insert(15);
		tree.insert(5);
		tree.insert(3);
		tree.insert(12);
		tree.insert(10);
		tree.insert(7);
		tree.insert(13);
		tree.insert(18);
		tree.insert(20);
		tree.insert(19);
		tree.insert(23);

		System.out.println("TREE");
		System.out.println("---------------");

		System.out.println(tree);
		System.out.println("---------------");
		tree.checkBinaryTreeCompleteness();
		System.out.println("" + tree.checkBinaryTreeCompleteness());

	}

	public boolean checkBinaryTreeCompleteness() {
		return checkBinaryTreeCompleteness(root);
	}

	//metodo para verificar se a arvore é completa
	private boolean checkBinaryTreeCompleteness(Node root) {
		if (root != null) {
			if (root.right == null && root.left == null) {
				return true;
			}
			if (root.right != null && root.left != null) {
				return checkBinaryTreeCompleteness(root.left) && checkBinaryTreeCompleteness(root.right);
			}
		}
		return false;
	}

	public boolean insert(int value) {
		if(root == null) {
			root = new Node(value);
			return true;
		} else {
			return insert(root, value);
		}
	}

	private boolean insert(Node node, int value) {
		if(value > node.value) {
			if(node.hasRight()) {
				return insert(node.right, value);
			} else {
				node.right = new Node(value);
			}
		} else if(value < node.value) {
			if(node.hasLeft()) {
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
		if(node == null) {
			return false;
		} else {
			if(node.value == value) {
				return true;
			} else if(value > node.value) {
				return contains(node.right, value);
			} else if(value < node.value){
				return contains(node.left, value);
			}
		}
		return false;
	}

	public boolean remove(int value) {
		return remove(root, null, value);
	}

	private boolean remove(Node node, Node parent, int value) {
		if(node == null) {
			return false;
		} else if(node.value == value) {
			if(node.isLeaf()) {
				updateChild(node, parent, null);
			} else if(node.hasLeft() && !node.hasRight()) {
				updateChild(node, parent, node.left);
			} else if(!node.hasLeft() && node.hasRight()) {
				updateChild(node, parent, node.right);
			} else {
				Node child = node.right;
				if(!child.hasLeft()) {
					child.left = node.left;
					updateChild(node, parent, child);
				} else {
					Node successor = removeSuccessor(child);
					successor.left = node.left;
					successor.right = node.right;
					updateChild(node, parent, successor);
				}
			}
		} else if(value > node.value) {
			return remove(node.right, node, value);
		} else if(value < node.value) {
			return remove(node.left, node, value);
		}
		return true;
	}

	private void updateChild(Node node, Node parent, Node child) {
		if(parent == null) {
			root = child;
		} else if(node.value > parent.value) {
			parent.right = child;
		} else if(node.value < parent.value) {
			parent.left = child;
		}
	}

	protected Node removeSuccessor(Node node) {
		if(!node.left.hasLeft()) {
			Node successor  = node.left;
			node.left = successor.right;
			return successor;
		} else {
			return removeSuccessor(node.left);
		}
	}

	public void levelOrder1() {
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
}
