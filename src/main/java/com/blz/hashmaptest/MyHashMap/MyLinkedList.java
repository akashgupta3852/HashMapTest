package com.blz.hashmaptest.MyHashMap;

public class MyLinkedList<T> {
	public INode<T> head, tail;

	public MyLinkedList() {
		head = null;
		tail = null;
	}

	public void printWelcome() {
		System.out.println("Welcome to Linked List Data Structure");
	}

	public void add(INode<T> newNode) {
		if (head == null)
			head = newNode;
		if (tail == null)
			tail = newNode;
		else {
			INode<T> tempNode = head;
			head = newNode;
			head.setNext(tempNode);
		}
	}

	public void append(INode<T> newNode) {
		if (head == null)
			head = newNode;
		if (tail == null)
			tail = newNode;
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public void insert(INode<T> myNode, INode<T> newNode) {
		INode<T> tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	public INode<T> pop() {
		INode<T> tempNode = head;
		head = head.getNext();
		return tempNode;
	}

	public INode<T> popLast() {
		INode<T> tempNode = head;
		while (!tempNode.getNext().equals(tail))
			tempNode = tempNode.getNext();
		INode<T> lastNode = tail;
		tempNode.setNext(null);
		tail = tempNode;
		return lastNode;
	}

	public INode<T> search(T key) {
		try {
			INode<T> tempNode = head;
			while (!tempNode.getKey().equals(key))
				tempNode = tempNode.getNext();
			return tempNode;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public void insert(T myKey, INode<T> newNode) {
		INode<T> tempNode = search(myKey);
		INode<T> nextNode = tempNode.getNext();
		tempNode.setNext(newNode);
		newNode.setNext(nextNode);
	}

	public void delete(T key) {
		INode<T> tempNode = head;
		while (!tempNode.getNext().getKey().equals(key))
			tempNode = tempNode.getNext();
		INode<T> nextNode = tempNode.getNext().getNext();
		tempNode.setNext(nextNode);
	}

	public int size() {
		int count = 0;
		INode<T> tempNode = head;
		while (tempNode != null) {
			count++;
			tempNode = tempNode.getNext();
		}
		return count;
	}

	public void printMyNodes() {
		StringBuffer myNodes = new StringBuffer("My Nodes : ");
		INode<T> tempNode = head;
		while (tempNode.getNext() != null) {
			myNodes.append(tempNode.getKey());
			if (!tempNode.equals(null))
				myNodes.append(" -> ");
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		System.out.println(myNodes);
	}

	@Override
	public String toString() {
		return "MyLinkedListNodes{" + head + "}";
	}
}
