package lp.trabalho;

public class Element <T> {
	
	public static void main(String [] args) {
		
		Element<Integer> city1 = new Element<>(1);
		Element<Integer> city2 = new Element<>(2);
		Element<Integer> city3 = new Element<>(3);

		city1.getRepresentative();
	}

	protected T element;
	protected Element<T> parent;

	public Element(T element) {
		this.element = element;
		this.parent = this;
	}

	public void setParent(Element<T> parent) {
		this.parent = parent;
	}

	public Element<T> getRepresentative() {
		return parent;
	}

	public T getValue() {
		return element;
	}
	
	public String toString() {
		return element.toString();
	}

	public boolean inSameSet(Element<T> b) {
		return this.getRepresentative() != b.getRepresentative();
	}

	public Element<T> findSet(Element<T> i) {
		if (i.parent == i) return i;
		else return findSet(i.parent);
	}

	public void unionElements(Element<T> j) {
		if (inSameSet(j)) setParent(findSet(j));
	}

}
