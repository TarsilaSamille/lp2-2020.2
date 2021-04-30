package lp.trabalho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetIterative {
	
	public static void main(String [] args) {
		List<ElementIterative<Integer>> lista = new ArrayList<>();

		ElementIterative<Integer> b = new ElementIterative<>(15);
		lista.add(b);
		for (int i = 0; i < 15; i++) {
			ElementIterative<Integer> a = new ElementIterative<>(i);
			a.unionElements(b);
			lista.add(a);
		}
		for (ElementIterative<Integer> e: lista) {
			System.out.println(e + " "+ e.getRepresentative());
		}

		System.out.println("----------------");

		Collections.shuffle( lista );

		for (int i = 0; i < 10; i++) {
			ElementIterative<Integer> e = lista.get(i);
			System.out.println(e + " "+ e.getRepresentative());
		}
	}

	public static <T> boolean inSameSet(ElementIterative<T> a, ElementIterative<T> b) {
		if(a.getRepresentative() == null) return false;
		return a.getRepresentative() == b.getRepresentative();
	}

	public static <T> void unionElements(ElementIterative<T> i, ElementIterative<T> j) {
		if (i.inSameSet(j)) {
			ElementIterative<T> x = i.findSet(i), y = j.findSet(j);
			x.setParent(y);
		}
	}
}
