package com.neeson.alg4;

import java.util.Iterator;

/**
 * @author : neeson
 * Date: 2018/8/15
 * Time: 21:55
 * Description: 
 */
public class ArrayStack<Item> implements Iterable<Item>,Stack<Item> {

	private Item[] element;
	private int N;

	public ArrayStack(int size) {
		this.element = (Item[]) new Object[size];
	}

	@Override
	public void push(Item item) {
		element[N++] = item;
	}

	@Override
	public Item pop() {
		Item result = element[--N];
		element[N] = null;
		return result;
	}

	@Override
	public int size(){
		return N;
	}


	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator<>();
	}

	private class ArrayIterator<Item> implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			return N > 0;
		}

		@Override
		public Item next() {
			return (Item) element[--N];
		}
	}
}
