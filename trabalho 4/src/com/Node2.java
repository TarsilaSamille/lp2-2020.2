package com;

import java.util.Objects;

public class Node2 {

	public double value;
	public int height;
	public String caracteristicas;

	public Node2 parent;
	public Node2 left;
	public Node2 right;

	public Node2(double value, String caracteristicas) {
		this.value = value;
		this.height = 1;
		this.caracteristicas = caracteristicas;
	}

	public Node2(double value, String caracteristicas, Node2 parent) {
		this.value = value;
		this.height = 1;
		this.caracteristicas = caracteristicas;
		this.parent = parent;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void setChilds(Node2 left, Node2 right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, height, caracteristicas, parent, left, right);
	}

	public String toString() {
		return Double.toString(value) + " " + caracteristicas ;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node2 other = (Node2) obj;
		if (value != other.value)
			return false;
		return true;
	}
}
