package com.入门.linked;

import lombok.Data;
import lombok.ToString;

import java.util.Random;
import java.util.StringJoiner;

/**
 * @author 王兴
 * @version 1.0
 * @date 2022/5/19 17:14
 * 这一页写了一个LRU 和 一个回文链表校验
 * 如果链表为空时，代码是否能正常工作？
 * 如果链表只包含一个结点时，代码是否能正常工作？
 * 如果链表只包含两个结点时，代码是否能正常工作？
 * 代码逻辑在处理头结点和尾结点的时候，是否能正常工作？
 * <p>
 * 单链表反转
 * 链表中环的检测
 * 两个有序的链表合并
 * 删除链表倒数第 n 个结点
 * 求链表的中间结点
 * ：206，141，21，19，876。
 *
 * ==================
 * 如果链表为空时，代码是否能正常工作？
 * 如果链表只包含一个结点时，代码是否能正常工作？
 * 如果链表只包含两个结点时，代码是否能正常工作？
 * 代码逻辑在处理头结点和尾结点的时候，是否能正常工作？
 */
public class LinkedLru<E> {


	// LRU 最少使用,每次使用后将
	private Node<E> header;
	private Node<E> tail;
	private int size = 1;
	private int length;

	public LinkedLru(int length) {
		this.length = length;
	}

	public void add(E e) {
		// 校验是否已经满了
		if (size == length) {
			//移除头部数据
			header = header.next;
			size--;
		}
		// 初始化头尾
		if (header == null && tail == null) {
			header = new Node<>(e);
			tail = header;
			header.next = tail;
		}
		Node<E> newNode = new Node<>(e);
		this.tail.next = newNode;
		this.tail = newNode;
		size++;
	}

	public E get(int index) {
		if (size != 0) {
			int i = 0;
			Node<E> e = header;
			while (e != null) {
				if (i == index) {
					return e.value;
				}
				e = header.next;
				i++;
			}
		}
		return null;
	}


	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("--", "{", "}");
		Node<E> temp = header;
		while (temp != null) {
			joiner.add(temp.value.toString());
			temp = temp.next;
		}
		return joiner.toString();
	}

	@ToString
	static class Node<E> {

		E value;
		Node<E> next;

		public Node(E value) {
			this.value = value;
		}


	}

	static class Solution {
		public boolean isPalindrome(Node head) {
			// 判断是否为空 | 是否为一个node. 如果是返回true
			if (head == null || head.next == null) {
				return true;
			}
			// prev 获取反转上半区间,fast 判断结束.slow为中间点
			Node prev = null;
			Node slow = head;
			Node fast = head;
			while (fast != null && fast.next != null) {
				// 快指针快两步
				fast = fast.next.next;
				// 获取慢指针的下一个
				Node next = slow.next;
				// 慢指针下一个 指向 prev
				slow.next = prev;
				// 上一个 指向慢指针
				prev = slow;
				//慢指针
				slow = next;
			}
			// 不存在这种情况
			if (fast != null) {
				slow = slow.next;
			}

			while (slow != null) {
				if (slow.value != prev.value) {
					return false;
				}
				slow = slow.next;
				prev = prev.next;
			}

			return true;
		}
	}


	public static Node reverseList(Node head) {
		Node prev = null;
		Node curr = head;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static boolean isRevere(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		// 做快慢指针
		Node prev = null;
		Node fast = head;
		Node slow = head;
		// 当快指针为null,或next为null时,slow走到中点
		while (fast != null && fast.next != null) {
			// 快指针走两步
			fast = fast.next.next;
			//慢指针走一步
			Node next = slow.next;
			// prev 逆转序列
			slow.next = prev;
			// 上一个 指向慢指针
			prev = slow;
			//慢指针
			slow = next;
			// ====

		}
		// 校验回文.
		while (slow != null) {
			if (prev.value != slow.value) {
				return false;
			}
			prev = prev.next;
			slow = slow.next;
		}
		return true;
	}

}
