package com;

public interface PriorityQueue {

	public void update(int current, int newValue);

	public boolean insert(int e);

	public int remove();

	public int get();

	public int size();

}