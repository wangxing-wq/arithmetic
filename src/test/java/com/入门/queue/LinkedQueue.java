package com.入门.queue;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/6/7 23:01
 */
public class LinkedQueue {

	private Node header = new Node(null);
	private Node tail = header;
	private int size;
	private int count;
	private int capacity;

	public LinkedQueue(int capacity){
		this.capacity = capacity;
		this.size = capacity;
	}

	public boolean enqueue(String item) {
		if (count > size){
			throw new RuntimeException("");
		}
		tail.next = new Node(item);
		tail = tail.next;
		count++;
		return true;
	}
	public String dequeue() {
		if (count == 0){
			System.out.println("dequeue");
		}
		Node next = header.next;
		header = header.next;
		return next.value;
	}

	@Override
	public String toString() {
		return "LinkedQueue{" +
				"header=" + header +
				", tail=" + tail +
				", size=" + size +
				", count=" + count +
				", capacity=" + capacity +
				'}';
	}

	static class Node{
		String value;
		Node next;

		public Node(String value){
			this.value = value;
		}

		public Node(String value,Node next){
			this.value = value;
			this.next = next;
		}

	}

}
