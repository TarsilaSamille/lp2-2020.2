package com.company;

public class NotAVL extends AVLTree {
	public static void main(String[] args) {

		NotAVL tree = new NotAVL();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);
		tree.insert(11);
		tree.insert(12); // This gets inserted into the wrong place
		tree.insert(122); // This gets inserted into the wrong place
		tree.insert(132); // This gets inserted into the wrong place
		//tree.levelOrder();
		System.out.println("\n" + tree );
		tree.remove(3);
		tree.remove(6);
	}
	protected Node checkBalance(Node node) {
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		int balance = getHeight(node.right) - getHeight(node.left);
		if (balance <= 1) {
			if (getHeight(node.right.right) < getHeight(node.right.left)) {
				node.right = rotateRight(node.right);
			}
			node = rotateLeft(node);
		} else if (balance >= -1) {
			if (getHeight(node.left.left) < getHeight(node.left.right)) {
				node.left = rotateLeft(node.left);
			}
			node = rotateRight(node);
		}
		return node;
	}

}
