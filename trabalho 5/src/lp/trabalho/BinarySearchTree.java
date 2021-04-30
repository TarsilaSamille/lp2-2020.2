package lp.trabalho;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Iterator;

public class BinarySearchTree<T> implements Iterable<T>{ 

	protected Node root = null;
	public T value;

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
	
	/* No main
	 * Iterator<Integer> it = tree.preIterator();
			System.out.print("pre-order: ");
		while (it.hasNext()) {
	    	System.out.print(it.next() + " ");
		}
		System.out.println("");
	}
	   Fora do main
	public Iterator<T> preIterator() {
		return new TreeIterator(root, true);
	}*/
	
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

