package com.入门.queue;

import java.util.Arrays;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/6/7 23:01
 * @message 想直接用一个数组,两个下标,第一个下标标记即将要出的位置.第二个下标标记即将要插入的位置
 * 如果插入的下标已经到极限,
 */
public class ArrayQueue {

	private String [] date;
	private int count;
	private int header;
	private int size;
	private int tail;
	private boolean flag;

	public ArrayQueue(int capacity){
		date = new String[capacity];
		size = capacity;
	}

	// 入队
	public boolean enqueue(String item) {
		// 1: 判断是否超过容量
		if (count > size){
			throw new RuntimeException("超出最大容量" + count);
		}
		//2: 判断入队位置,如果是已经循环过的,插入前方,没有循环过的插入后方
		if (!flag && tail > size && (tail - size) < header){
			tail -= size;
			flag = true;
		}
		date[tail++] = item;
		return true;
	}
	// 出队
	public String dequeue() {
		// 直接获取header的数据,
		if (flag && header > size){
			header -= size;
			flag = false;
		}
		String result = date[header];
		date[header++] = null;
		return result;
	}

	@Override
	public String toString() {
		return "ArrayQueue{" +
				"date=" + Arrays.toString(date) +
				", count=" + count +
				", header=" + header +
				", size=" + size +
				", tail=" + tail +
				", flag=" + flag +
				'}';
	}
}
