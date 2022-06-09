package com.入门.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/6/8 11:20
 * @message
 */
class ArrayQueueTest {

	@Test
	void enqueue() {
		LinkedQueue queue = new LinkedQueue(10);
		for (int i = 0; i < 20; i++) {
			if(i == 3){
				System.out.println(queue.dequeue());
			}else if (i < 11){
				System.out.println(queue.enqueue(Integer.toString(i)) + "\t" + i);
			}else{
				System.out.println(queue.dequeue());
			}
		}
		System.out.println(queue);
	}

	@Test
	void dequeue() {
	}
}
