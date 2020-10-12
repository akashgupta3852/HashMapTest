package com.blz.hashmaptest.MyHashMap;

public class MyMapNode<K, V> implements INode<K> {
	private K key;
	private V value;
	private MyMapNode<K, V> next;

	public MyMapNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public INode<K> getNext() {
		return next;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setNext(INode<K> next) {
		this.next = (MyMapNode<K, V>) next;
	}

	@Override
	public String toString() {
		StringBuffer myMapNodeString = new StringBuffer();
		myMapNodeString.append("MyMapNode{" + "Key = ").append(key).append(", Value = ").append(value).append("}");
		if (next != null)
			myMapNodeString.append(" -> ").append(next);
		return myMapNodeString.toString();
	}
}
