package com.入门.linked;

import static com.入门.linked.LinkedLru.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/5/21 23:53
 */
public class NodeTest {

	Node<Integer> header;
	Node<Integer> header1;

	@BeforeEach
	public void before(){
		header = new Node<>(-10);
		header.next = new Node<>(-9);
		header.next.next = new Node<>(-6);
		header.next.next.next = new Node<>(-4);
		header.next.next.next.next = new Node<>(1);
		header.next.next.next.next.next = new Node<>(9);
		header.next.next.next.next.next.next = new Node<>(9);
		//[-10,-9,-6,-4,1,9,9]
		//[-5,-3,0,7,8,8]
		header1 = new Node<>(-5);
		header1.next = new Node<>(-3);
		header1.next.next = new Node<>(0);
		header1.next.next.next = new Node<>(7);
		header1.next.next.next.next = new Node<>(8);
		header1.next.next.next.next.next = new Node<>(8);

	}

	@Test
	public void reverseList(){
		Node prev = null;
		Node curr = header;
		while (curr != null){
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		System.out.println(prev);
	}

	@Test
	public void hasCycle() {
		if (header == null || header.next == null) {
			System.out.println("true");
		}
		Map<Node,Integer> map = new HashMap<Node,Integer>();
		// 判断是否有环
		Node curr = header;
		int i = 0;
		while (true){
			Integer idx = map.get(curr.next);
			if (idx != null) {
				System.out.println(true +"\t" + (i - idx - 1));
				break;
			}
			map.put(curr,i);
			curr = curr.next;
			i++;
		}
	}

	public boolean hasCycle(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Map<Node,Integer> map = new HashMap<Node,Integer>();
		Node curr = head;
		int i = 0;
		while (curr != null){
			Integer idx = map.get(curr.next);
			if (idx != null) {
				return true;
			}
			map.put(curr,i);
			curr = curr.next;
			i++;
		}
		return false;
	}

	@Test
	public void mergeTwoLists() {
		Node<Integer> list1 = header;
		Node<Integer> list2 = header1;
		System.out.println(mergeTwoLists(list1, list2));
	}

	public Node mergeTwoLists(Node<Integer> list1, Node<Integer> list2) {
		if(list1 == null){
			return list2;
		}
		if(list2 == null){
			return list1;
		}
		Node result = list1;
		if (list2.value < list1.value){
			Node temp = list1;
			list1 = list2;
			list2 = temp;
			result = list1;
		}
		Node prev = list1;
		while (list1 != null && list2 != null){
			// 比较找到比List1小的
			if (list1.value <= list2.value){
				prev = list1;
				list1 = list1.next;
			}else{
				prev.next = list2;
				list2 = list2.next;
				prev.next.next = list1;
				prev = prev.next;
			}
		}
		if (list1 == null && list2 != null){
			prev.next = list2;
		}
		return result;
	}


	@Test
	public void removeNthFromEnd(){
		Node<Integer> head = new Node<>(1);
		head.next = new Node<>(2);
		head.next.next = new Node<>(3);
		head.next.next.next = new Node<>(4);
		head.next.next.next.next = new Node<>(5);
		System.out.println(removeNthFromEnd(head, 1));
	}

	@Test
	public void middleNode(){
		Node<Integer> head = new Node<>(1);
		head.next = new Node<>(2);
		head.next.next = new Node<>(3);
		head.next.next.next = new Node<>(4);
		head.next.next.next.next = new Node<>(5);
		//head.next.next.next.next.next = new Node<>(6);
		System.out.println(middleNode(head));
	}

	public Node middleNode(Node head) {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
		if (head == null){return null;}
		int index = 0;
		int length = 0;
		Node<Integer> fastback = head;
		Node<Integer> slowly = head;
		while (fastback != null && fastback.next != null){
			fastback = fastback.next.next;
			slowly = slowly.next;
			index++;
		}
		if (fastback != null){
			length = index * 2 + 1;
		}
		if (n < 0 || n > length){
			return null;
		}
		Node<Integer> eachNode = (length - n) > index ? slowly : head;
		Node<Integer> prev = eachNode;
		int indexEach = (length - n) > index ? length - n -index : length - n;
		for (int i = 1; i <= indexEach; i++) {
			if (i == indexEach){
				prev.next = eachNode.next.next;
			} else {
				prev = eachNode;
				eachNode = eachNode.next;
			}
		}
		return head;
	}

}
