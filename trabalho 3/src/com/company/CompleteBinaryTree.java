package com.company;

import java.util.LinkedList;
//javac src/com/company/CompleteBinaryTree.java src/com/company/BinarySearchTree.java src/com/company/Node.java
// java src/com/company/CompleteBinaryTree
public class CompleteBinaryTree extends BinarySearchTree {

	public static void main(String[] args) {

		CompleteBinaryTree tree = new CompleteBinaryTree();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);

		System.out.println("\n" + tree );
		tree.remove(1);
		tree.remove(2);
		System.out.println("\n" + tree );

		tree.remove(3);
		System.out.println("\n" + tree );

		tree.remove(4);
		System.out.println("\n" + tree );

		tree.remove(5);
		System.out.println("\n" + tree );
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
		while (node != null) {
			if (node.left == null) {
				node.left = new Node(value);
				return true;

			} else if (node.right == null) {
				node.right = new Node(value);
				return true;

			}
			else {
				int lCount = countChildren(node.left);
				int rCount = countChildren(node.right);
				if (lCount == rCount)
					node = node.left;
				else if (lCount == 0 || lCount == 1)
					node = node.left;
				else
					node = node.right;
			}
		}
		return true;
	}

	public int countChildren(Node node) {
		int count = 0;
		if(node.left != null) {
			count++;
			count += countChildren(node.left);
		}
		if(node.right != null){
			count++;
			count += countChildren(node.right);
		}
		return count;
	}

	public boolean remove(int value) {
		updateChild(find(value), findParent(find(value)), last());
		updateChild(last(), findParent(last()), null);
		return true;
	}

	void updateChild(Node node, Node parent, Node child) {
		if(parent == null) {
			if(child == null) {
				root = null;
			}else root.value = child.value;
		} else if(parent.left == node ) {
			if(child == null) {
				parent.left = null;
			}else parent.left.value = child.value;
		} else if(parent.right == node ) {
			if(child == null) {
				parent.right = null;
			}else parent.right.value = child.value;
		}
	}


	private Node find(int value) {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			if (current != null) {
				queue.addLast(current.left);
				queue.addLast(current.right);
				if(current.value == value) {
					return current;
				}
			}

		}
		return null;
	}
	private Node last() {
		Node last = null;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			if (current != null) {
				last = current;
				queue.addLast(current.left);
				queue.addLast(current.right);
			}
		}
		return last;
	}

	private Node findParent(Node node) {
		Node last = null;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			if (current != null) {
				if(current.left == node || current.right == node){
					return current;
				}
				queue.addLast(current.left);
				queue.addLast(current.right);
			}
		}
		return last;
	}

}

