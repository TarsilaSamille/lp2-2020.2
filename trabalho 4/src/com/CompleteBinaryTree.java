package com;

import java.util.LinkedList;

public class CompleteBinaryTree extends BinarySearchTree {

	public static void main(String [] args) {
		CompleteBinaryTree tree = new CompleteBinaryTree();
		for(int i=0;i<20;i++) {
			System.out.println("---------------");
			tree.insert(i);
			System.out.println(tree);
		}

		for(int i=10;i<20;i+=2) {
			System.out.println("---------------");
			tree.remove(i);
			System.out.println(tree);
		}
	}

	@Override
	public boolean insert(int value) {
		if(root == null) {
			root = new Node(value);
			return true;
		} else {
			LinkedList <Node> queue = new LinkedList<>();
			queue.addLast(root);
			boolean inserted = false;
			while(!queue.isEmpty() && !inserted) {
				Node current = queue.removeFirst();
				if(!current.hasLeft()) {
					current.left = new Node(value, current);
					inserted = true;
				} else if(!current.hasRight()) {
					current.right = new Node(value, current);
					inserted = true;
				} else {
					if(current.hasLeft())
						queue.add(current.left);
					if(current.hasRight())
						queue.add(current.right);
				}
			}
			return inserted;
		}
	}

	@Override
	public boolean remove(int value) {
		if(root == null) {
			return false;
		} else {
			Node toRemove = null;
			Node lastNode = null;
			LinkedList <Node> queue = new LinkedList<>();
			queue.addLast(root);
			while(!queue.isEmpty()) {
				Node current = queue.removeFirst();
				lastNode = current;
				if(value == current.value)
					toRemove = current;
				if(current.hasLeft())
					queue.addLast(current.left);
				if(current.hasRight())
					queue.addLast(current.right);
			}
			if(toRemove != null) {
				if(lastNode.parent == null) {
					root = null;
				} else {
					toRemove.value = lastNode.value;
					if(lastNode.parent.left == lastNode) {
						lastNode.parent.left = null;
					} else {
						lastNode.parent.right = null;
					}
				}
				return true;
			}
		}
		return false;
	}
}