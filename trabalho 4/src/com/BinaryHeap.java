
package com;

import java.util.LinkedList;
//javac src/com/Node.java src/com/PriorityQueue.java src/com/BinaryHeap.java
// cd src java com.BinaryHeap


public class BinaryHeap implements PriorityQueue {

	public static void main(String [] args) {
		BinaryHeap heap = new BinaryHeap();
		heap.insert(0);
		heap.insert(9);
		heap.insert(5);
		heap.insert(3);
		heap.insert(2);
		heap.insert(7);
		/*
		* 	7 [Level:2]
				5 [Level:3]
		9 [Level:1]
				2 [Level:3]
			3 [Level:2]
				0 [Level:3]
		* */


		System.out.println(heap.get()); //9
		heap.remove();//9

		System.out.println(heap.get());//7

		heap.update(2,13);//13
			/*
		*	7 [Level:2]
		13 [Level:1]
				3 [Level:3]
			5 [Level:2]
				0 [Level:3]
		* */

		System.out.println(heap.get());//13

	}

	protected Node root;
    protected int size;

	public BinaryHeap() {
		size = 0;
	}


	public void up(Node node) {
		Node maior = node.parent;
		Node atual = node;
		while (maior != null && atual.value > maior.value){
			int nodeTemp = maior.value;
			maior.value = atual.value;
			atual.value = nodeTemp;
			atual = atual.parent;
			maior = maior.parent;
		}
	}
	public void down(Node node) {
		Node maior = node;
		Node atual = new Node(node.value);
		if(!node.isLeaf())atual= node.left.value > node.right.value ? node.left : node.right;
		while(maior.hasLeft() && atual.value > maior.value){
			int nodeTemp = maior.value;
			maior.value = atual.value;
			atual.value = nodeTemp;
			if(!atual.isLeaf())
				atual = atual.left.value > atual.right.value ? atual.left : atual.right;
			if(!maior.isLeaf())
				maior = maior.left.value > maior.right.value ? maior.left : maior.right;
		}
	}

	@Override
	public void update(int atual, int newValue) {
		Node nodeAtual = null;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			if (current != null) {
				if(atual == current.value) {
					nodeAtual = current;
					break;
				}
				queue.addLast(current.left);
				queue.addLast(current.right);
			}
		}
		if (nodeAtual != null) {
			if (newValue > nodeAtual.value) {
				nodeAtual.value = newValue;
				up(nodeAtual);
			} else if (newValue < nodeAtual.value) {
				nodeAtual.value = newValue;
				down(nodeAtual);
			}
		}
	}

	@Override
	public boolean insert(int value) {
		if(root == null) {
			root = new Node(value);
			return true;
		} else {
			LinkedList<Node> queue = new LinkedList<>();
			queue.addLast(root);
			boolean inserted = false;
			while(!queue.isEmpty() && !inserted) {
				Node current = queue.removeFirst();
				if(!current.hasLeft()) {
					current.left = new Node(value, current);
					inserted = true;
					up(current.left);
				} else if(!current.hasRight()) {
					current.right = new Node(value, current);
					inserted = true;
					up(current.right);
				} else {
					if(current.hasLeft())
						queue.add(current.left);
					if(current.hasRight())
						queue.add(current.right);
				}
			}
			if (inserted) size++;
			return inserted;
		}
	}

	@Override
	public int remove() {
		size -= remove(get()) ? 1 : 0;
		return size;
	}

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
				down(toRemove);
				return true;
			}
		}
		return false;
	}

	@Override
	public int get() {
		return root.value;
	}

	public int size() {
		return size;
	}
}
