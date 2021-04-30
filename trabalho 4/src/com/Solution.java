package com;

import java.util.LinkedList;
//javac src/com/Node2.java src/com/PriorityQueue.java src/com/BinaryHeap.java
// cd src java com.BinaryHeap

public class Solution {

	public static void main(String [] args) {
		Solution heap = new Solution(5);
		heap.armazenar(0,"a");
		heap.armazenar(9,"das");
		heap.armazenar(5,"asda");
		heap.armazenar(3,"asdas");
		heap.armazenar(2,"a");
		heap.armazenar(7,"a");
		heap.armazenar(10,"asdas");
		heap.armazenar(1,"a");
		heap.armazenar(4.5,"a");
		/*
		* 	7 [Level:2]
				5 [Level:3]
		9 [Level:1]
				2 [Level:3]
			3 [Level:2]
				0 [Level:3]
		* */

		System.out.println(heap);

		LinkedList<Node2> listaSoluções = heap.recuperar();//13
		System.out.println(listaSoluções);

	}

	protected Node2 root;
    protected int size;
	protected int n;


	public Solution(int n) {
		size = 0;
		this.n = n;
	}

	public void armazenar(double value, String caracteristicas){
		if(size == n && root.value < value){
			remove();
		}
		if(size < n) insert(value, caracteristicas);
	}

	public LinkedList<Node2> recuperar() {
		return recuperar(root);
	}

	public LinkedList<Node2> recuperar(Node2 current) {
		if (current == null) {
			return null;
		}
		LinkedList<Node2> queue = new LinkedList<Node2>();
		LinkedList<Node2> queue1 = recuperar(current.left);
		if (queue1 != null) queue.addAll(queue1);
		LinkedList<Node2> queue2 = recuperar(current.right);
		if (queue2 != null) queue.addAll(queue2);
		queue.add(current);
		return queue;
	}

	public void up(Node2 node) {
		Node2 menor = node.parent;
		Node2 atual = node;
		while (menor != null && atual.value < menor.value){
			double nodeTemp = menor.value;
			menor.value = atual.value;
			atual.value = nodeTemp;
			atual = atual.parent;
			menor = menor.parent;
		}
	}
	public void down(Node2 node) {
		Node2 menor = node;
		Node2 atual = new Node2(node.value, node.caracteristicas);
		if (node.left != null){
			if(node.right != null && node.left.value > node.right.value) atual = node.right;
			else atual = node.left;
		}else if(node.right != null) atual = node.right;

		while(menor.hasLeft() && atual.value < menor.value){
			double nodeTemp = menor.value;
			menor.value = atual.value;
			atual.value = nodeTemp;

			if(!atual.isLeaf()) {
				if (atual.left != null) {
					if (atual.right != null && atual.left.value > atual.right.value ) atual = atual.right;
					else atual = atual.left;
				} else if (atual.right != null) atual = atual.right;
			}
			if(!menor.isLeaf()) {
				if (node.left != null) {
					if (node.right != null && menor.left.value > menor.right.value) menor = menor.right;
					else menor = node.left;
				} else if (node.right != null) menor = node.right;
			}
		}
	}

	public boolean insert(double value, String a) {
		if(root == null) {
			root = new Node2(value,a);
			size++;
			return true;
		} else {
			LinkedList<Node2> queue = new LinkedList<>();
			queue.addLast(root);
			boolean inserted = false;
			while(!queue.isEmpty() && !inserted) {
				Node2 current = queue.removeFirst();
				if(!current.hasLeft()) {
					current.left = new Node2(value, a, current);
					inserted = true;
					up(current.left);
				} else if(!current.hasRight()) {
					current.right = new Node2(value,a, current);
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

	public int remove() {
		size -= remove(get().value) ? 1 : 0;
		return size;
	}

	public boolean remove(double value) {
		if(root == null) {
			return false;
		} else {
			Node2 toRemove = null;
			Node2 lastNode2 = null;
			LinkedList <Node2> queue = new LinkedList<>();
			queue.addLast(root);
			while(!queue.isEmpty()) {
				Node2 current = queue.removeFirst();
				lastNode2 = current;
				if(value == current.value)
					toRemove = current;
				if(current.hasLeft())
					queue.addLast(current.left);
				if(current.hasRight())
					queue.addLast(current.right);
			}
			if(toRemove != null) {
				if(lastNode2.parent == null) {
					root = null;
				} else {
					toRemove.value = lastNode2.value;
					if(lastNode2.parent.left == lastNode2) {
						lastNode2.parent.left = null;
					} else {
						lastNode2.parent.right = null;
					}
				}
				down(toRemove);
				return true;
			}
		}
		return false;
	}

	public Node2 get() {
		return root;
	}

	public int size() {
		return size;
	}

	public String toString() {
		return toString(root, "", 0);
	}

	public String toString(Node2 current, String tabs, int level) {
		if (current == null) {
			return "";
		}
		String str = toString(current.right, tabs + "\t", level + 1);
		str += String.format("%s%s [Level:%d]\n", tabs, current, level + 1);
		str += toString(current.left, tabs + "\t", level + 1);
		return str;
	}
}
