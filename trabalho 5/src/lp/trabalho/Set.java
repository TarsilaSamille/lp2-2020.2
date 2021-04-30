package lp.trabalho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Set {
	
	public static void main(String [] args) {
		List<Element<Integer>> lista = new ArrayList<>();

		Element<Integer> b = new Element<>(15);
		lista.add(b);
		for (int i = 0; i < 15; i++) {
			Element<Integer> a = new Element<>(i);
			a.unionElements(b);
			lista.add(a);
		}

		for (Element<Integer> e: lista) {
			System.out.println(e + " "+ e.getRepresentative());
		}
		System.out.println("----------------");

		Collections.shuffle( lista );

		for (int i = 0; i < 10; i++) {
			Element<Integer> e = lista.get(i);
			System.out.println(e + " "+ e.getRepresentative());
		}

	}

	public static <T> boolean inSameSet(Element<T> a, Element<T> b) {
		if(a.getRepresentative() == null) return false;
		return a.getRepresentative() == b.getRepresentative();
	}

	public static <T> void unionElements(Element<T> i, Element<T> j) {
		if (i.inSameSet(j)) {
			Element<T> x = i.findSet(i), y = j.findSet(j);
			x.setParent(y);
		}
	}
}
