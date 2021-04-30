
package com;

public class Heap implements PriorityQueue {
	
	public static void main(String [] args) {
		Heap heap = new Heap(10);
		heap.insert(0);
		heap.insert(9);
		heap.insert(5);
		heap.insert(3);
		heap.insert(2);
		heap.insert(7);
		heap.up(5);
		System.out.println(heap.get());
		//heap.remove();
		heap.up(8);
		System.out.println(heap.get());
		
	}

	protected int[] elements;
	protected int size;

	public Heap(int capacity) {
		size = 0;
		elements = new int[capacity];
	}

	//[9, 8, 5, 7, 1, 0, 2, 6]
	// 0  1  2  3  4  5  6  7
	//up(7)
	
	private void up(int index) {
		int child = index; // child == 1
		int p = (index - 1) / 2; // 1/2 = 0
		if (child > 0) {
			if (elements[child] > elements[p]) { // element[1] == 9 > element[0] == 8
				swap(child, p);
				up(p); // up(0)
			}
		}
	}

	//[8, 7, 5, 6, 1, 0, 2]
	// 0  1  2  3  4  5  6
	private void down(int index) {
		int p = index;// p = 3
		int child = ((index + 1) * 2) - 1; // child = 7

		if (child + 1 < size) {
			if (elements[child] >= elements[child + 1]) {
				if (elements[child] > elements[p]) {
					swap(p, child);
					down(child);
				}
			} else {
				if (elements[child + 1] > elements[p]) {
					swap(p, child + 1);
					down(child + 1);
				}
			}
		} else if (child < size) {
			if (elements[child] > elements[p]) {
				swap(p, child);

			}
		}
	}

	private void swap(int i, int j) {
		int aux = elements[i];
		elements[i] = elements[j];
		elements[j] = aux;
	}

	public void update(int current, int newValue) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (elements[i] == current) {
				index = i;
			}
		}
		if (index != -1) {
			if (newValue > current) {
				current = newValue;
				up(index);
			} else if (newValue < current) {
				current = newValue;
				down(index);
			}
		}
	}

	public boolean insert(int e) {
		if (size < elements.length) {
			elements[size] = e; // element[8] = 9
			size += 1; // size + 1 = 9
			up(size - 1); // up(9-1 = 8)
			return true;
		}
		return false;
	}

	public int remove() { // maior prioridade
		if (size <= 0) {
			throw new IndexOutOfBoundsException("Heap is empty!");
		}
		int value = elements[0];
		elements[0] = elements[size - 1];
		size--;
		down(0);
		return value;
	}

	public int get() { // maior
		if (size > 0) {
			return elements[0];
		}
		throw new IndexOutOfBoundsException("Heap is empty!");
	}

	public int size() {
		return size;
	}
}
