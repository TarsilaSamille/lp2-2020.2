package com.company;

public class AVLTree extends BinarySearchTree {

	int getHeight(Node n) {
		return n == null ? 0 : n.height;
	}

	protected Node rotateRight(Node node) {
		Node leftNode = node.left;
		Node leftRightNode = leftNode.right;
		leftNode.right = node;
		node.left = leftRightNode;
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		leftNode.height = 1 + Math.max(getHeight(leftNode.left), getHeight(leftNode.right));
		return leftNode;
	}

	protected Node rotateLeft(Node node) {
		Node rightNode = node.right;
		Node rightLeftNode = rightNode.left;
		rightNode.left = node;
		node.right = rightLeftNode;
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		rightNode.height = 1 + Math.max(getHeight(rightNode.left), getHeight(rightNode.right));
		return rightNode;
	}

	protected Node checkBalance(Node node) {
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		int balance = getHeight(node.right) - getHeight(node.left);
		if (balance > 1) {
			if (getHeight(node.right.right) < getHeight(node.right.left)) {
				node.right = rotateRight(node.right);
			}
			node = rotateLeft(node);
		} else if (balance < -1) {
			if (getHeight(node.left.left) < getHeight(node.left.right)) {
				node.left = rotateLeft(node.left);
			}
			node = rotateRight(node);
		}
		return node;
	}

	private Node insert(Node node, int key) {
		if (node == null) {
			return new Node(key);
		} else if (node.value > key) {
			node.left = insert(node.left, key);
		} else if (node.value < key) {
			node.right = insert(node.right, key);
		}
		return checkBalance(node);
	}

	@Override
	public boolean insert(int value) {
		root = insert(root, value);
		return true;
	}
}
