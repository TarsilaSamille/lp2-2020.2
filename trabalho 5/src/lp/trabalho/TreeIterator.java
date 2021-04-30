package lp.trabalho;

import java.util.Iterator;
import java.util.Stack;
import com.Node;

public class TreeIterator<T> implements Iterator<Integer> {
	
	Stack<Node> stack;
	protected static Node root;
	
	public static void main(String [] args) {
		TreeIterator<Integer> tree = new TreeIterator<Integer>();
		tree.insert(5);
		tree.insert(3);
		tree.insert(7);
		tree.insert(4);
		tree.insert(1);
		System.out.println("Tree");
		System.out.println(tree);
		System.out.println("Pré-Ordem");
		
		tree.iteratorTree();
	}
	
	public void iteratorTree() {
		iteratorTree(root);
	}
	
	private void iteratorTree(Node node) {
		if (node == null) { 
			return; 
		} System.out.printf(node.value + " "); 
		iteratorTree(node.left); 
		iteratorTree(node.right); 
	}
	
	 
	public boolean hasNext() {
		return (root != null);
	}
	 
	public Integer next() {
		Node node = null;
		int result =  node.value;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
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
