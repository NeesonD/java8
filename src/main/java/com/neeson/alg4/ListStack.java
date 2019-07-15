package com.neeson.alg4;

import java.util.Iterator;

/**
 * @author : neeson
 * Date: 2018/8/15
 * Time: 22:56
 * Description: 
 */
public class ListStack<Item> implements Stack<Item>,Iterable<Item> {

	private Node first;
	private int N;

	private static class Node<Item>{
		private Item item;
		private Node<Item> next;

		Node(Item item, Node<Item> next) {
			this.item = item;
			this.next = next;
		}
	}

	@Override
	public void push(Item item) {
		Node<Item> oldFirst = first;
		first = new Node(item,oldFirst);
		N++;
	}

	@Override
	public Item pop() {
		Item result = (Item) first.item;
		first = first.next;
		N--;
		return result;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<>();
	}


	class ListIterator<Item> implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			return first.next != null;
		}

		@Override
		public Item next() {
			Item item = (Item) first.item;
			first = first.next;
			return item;
		}
	}
}
