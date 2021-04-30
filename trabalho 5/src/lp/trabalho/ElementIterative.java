package lp.trabalho;

public class ElementIterative<T> {

	public static void main(String [] args) {

		ElementIterative<Integer> city1 = new ElementIterative<>(1);
		ElementIterative<Integer> city2 = new ElementIterative<>(2);
		ElementIterative<Integer> city3 = new ElementIterative<>(3);

		city1.getRepresentative();

	}

	protected T element;
	protected ElementIterative<T> parent;

	public ElementIterative(T element) {
		this.element = element;
		this.parent = this;
	}

	public void setParent(ElementIterative<T> parent) {
		this.parent = parent;
	}

	public ElementIterative<T> getRepresentative() {
		return parent;
	}

	public T getValue() {
		return element;
	}
	
	public String toString() {
		return element.toString();
	}

	public boolean inSameSet(ElementIterative<T> b) {
		return this.getRepresentative() == b.getRepresentative();
	}

	public ElementIterative<T> findSet(ElementIterative<T> i) {
		ElementIterative<T> j = i;
		while (j != j.parent){
			j = j.parent;
		}
		return j;
	}

	public void unionElements(ElementIterative<T> j) {
		ElementIterative<T> p = parent;
		if(p.element != element) p = findSet(p);
		if (!inSameSet(j)) p.setParent(findSet(j));
	}

}
