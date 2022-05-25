package com.入门.stack;

import java.util.Stack;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/5/24 9:54
 * 链表式栈
 * leetcode 上面的题20,155,232,844,224,682,496.
 */
public class LinkedStack<E> {

	private int size;
	private int length;
	private Node<E> header = new Node<>(null);

	public LinkedStack() {
		this.length = 9;
	}

	public LinkedStack(int length){
		this.length = length;
	}


	public E push(E item) {
		if (size > length){
			throw new RuntimeException("stack is full");
		}
		header = new Node<E>(item,header);
		size++;
		return item;
	}


	public synchronized E pop() {
		if (size <= 0){
			throw new RuntimeException("stack size is null");
		}
		E result = null;
		if (header.next != null){
			result = header.val;
			header = header.next;
			size--;
		}
		return result;
	}


	public synchronized E peek() {
		return header.val;
	}


	public boolean empty() {
		return size == 0;
	}


	public synchronized int search(Object o) {
		int result = 1;
		Node<E> temp = header;
		while (temp != null){
			if (temp.val == o){
				return result;
			}
			temp = temp.next;
			result++;
		}
		return result;
	}

	@Override
	public String toString() {
		return "LinkedStack{" +
				"size=" + size +
				", length=" + length +
				", header=" + header +
				'}';
	}

	static class Node<E>{

		E val;
		Node<E> next;

		public Node(){}

		public Node(E val){
			this.val = val;
		}

		public Node(E val,Node<E> next){
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node{" +
					"val=" + val +
					", next=" + next +
					'}';
		}
	}

}
